package strategy;

import entities.*;
import enums.Category;
import enums.ElvesType;
import main.App;
import storage.AnnualChange;
import storage.Children;
import storage.ChildrenRecord;

import java.util.*;

public class IdStrategy implements Strategy {

    @Override
    public Children getChildrenThisYear(App app, int year){
        List<Child> childrenThisYear =  new ArrayList<>();
        Santa santa = app.getSanta();
        ChildrenRecord childrenRecord = santa.getChildrenRecord();
        //First year
        if (year == 0) {
            //Put children from Santa's list in another list for output
            List<SantaChild> santaChildren = santa.getSantaChildren();
            for (SantaChild santaChild : santaChildren) {
                childrenRecord.addNiceScoreToRecord(santaChild.getId(), santaChild.getNiceScore());
                childrenThisYear.add(new Child(santaChild));
            }

            for (Child child : childrenThisYear) {
                child.setNiceScoreHistory(childrenRecord.getNiceScoreHistoryForChild(child.getId()));
            }
        }
        //Subsequent years
        else {
            santa.passToNextYear();
            AnnualChange annualChange = app.getAnnualChanges().get(year - 1);

            //Add new children
            for (SantaChild santaChild : annualChange.getNewChildren()) {
                if (santaChild.getAge() <= 18) {
                    santa.addChild(santaChild);
                }
            }

            //Perform children updates
            for (ChildUpdate childUpdate : annualChange.getChildrenUpdates()) {
                for (SantaChild santaChild : santa.getSantaChildren()) {
                    if (santaChild.getId() == childUpdate.getId()) {
                        if (childUpdate.getNiceScore() != null) {
                            santaChild.setNiceScore(childUpdate.getNiceScore());
                            childrenRecord.addNiceScoreToRecord(santaChild.getId(), childUpdate.getNiceScore());
                        }
                        List<Category> reveresePreferences = childUpdate.getGiftsPreferences();
                        Collections.reverse(reveresePreferences);
                        for (Category category : reveresePreferences) {
                            santaChild.addToGiftPreferences(category);
                        }
                        santaChild.setElf(childUpdate.getElf());
                    }
                }
            }
            //Add new gifts to santa's list
            for (SantaGift santaGift : annualChange.getNewGifts()) {
                santa.addGift(santaGift);
            }

            santa.setSantaBudget(annualChange.getNewSantaBudget());

            //Put children from Santa's list in another list for output
            for (SantaChild santaChild : santa.getSantaChildren()) {
                childrenThisYear.add(new Child(santaChild));
            }

            for (Child child : childrenThisYear) {
                child.setNiceScoreHistory(childrenRecord.getNiceScoreHistoryForChild(child.getId()));
            }
        }
        //First Stage (assign average score and budget to children)
        executeFirstStage(childrenThisYear, santa);
        //Second Stage (assign gifts)
        executeSecondStage(childrenThisYear, santa);

        return new Children(childrenThisYear);
    }

    private void executeFirstStage(List<Child> children, Santa santa) {
        //Remove young adults and calculate avg. scores for children
        for (Iterator<Child> iterator = children.iterator(); iterator.hasNext();) {
            Child child = iterator.next();
            if (child.getAge() > 18) {
                santa.removeChild(child.getId());
                iterator.remove();
            } else {
                child.setAverageScoreWithoutBonus();
                child.addBonus(santa.getNiceScoreBonusForChild(child.getId()));
            }
        }
        Double avgSum = 0.0d;
        for (Child child : children) {
            avgSum += child.getAverageScore();
        }
        Double budgetUnit = santa.getSantaBudget() / avgSum;

        //Assign budgets for each child
        for (Child child : children) {
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            if (santa.getElfForChild(child.getId()) == ElvesType.BLACK) {
                child.setAssignedBudget(child.getAssignedBudget() - child.getAssignedBudget() * 30 / 100);
            } else if (santa.getElfForChild(child.getId()) == ElvesType.PINK) {
                child.setAssignedBudget(child.getAssignedBudget() + child.getAssignedBudget() * 30 / 100);
            }
        }
    }

    private void executeSecondStage(List<Child> children, Santa santa) {
        for (Child child : children) {
            Double budget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreferences()) {
                List<SantaGift> possibleGifts = new ArrayList<>();
                for (SantaGift santaGift : santa.getSantaGifts()) {
                    if (santaGift.getCategory() == category) {
                        possibleGifts.add(santaGift);
                    }
                }
                Gift giftReceived = null;
                //Assign gift if only 1 in category
                if (possibleGifts.size() == 1
                        && budget >= possibleGifts.get(0).getPrice()
                        && possibleGifts.get(0).getQuantity() != 0) {
                    //Subtract price of gift from budget for child
                    budget -= possibleGifts.get(0).getPrice();
                    //Decrease quantity of gift in santa's sack
                    santa.decreaseQuantityForGift(possibleGifts.get(0).getProductName());
                    //Assign gift to child
                    giftReceived = new Gift(possibleGifts.get(0));
                //Assign gift if more than 1 in category
                } else if (possibleGifts.size() > 1) {
                    //sort by price
                    possibleGifts.sort(Comparator.comparing(SantaGift::getPrice));
                    //if in budget
                    if (budget >= possibleGifts.get(0).getPrice()
                            && possibleGifts.get(0).getQuantity() != 0) {
                        budget -= possibleGifts.get(0).getPrice();
                        santa.decreaseQuantityForGift(possibleGifts.get(0).getProductName());
                        giftReceived = new Gift(possibleGifts.get(0));
                    }
                }
                if (giftReceived != null)
                    child.addGift(giftReceived);
            }
        }
        //Yellow elf assigns gift
        for (Child child : children) {
            if (santa.getElfForChild(child.getId()) == ElvesType.YELLOW
                    && child.getReceivedGifts().isEmpty()) {
                List<SantaGift> possibleGifts = new ArrayList<>();
                for (SantaGift santaGift : santa.getSantaGifts()) {
                    if (santaGift.getCategory() == child.getGiftsPreferences().get(0)) {
                        possibleGifts.add(santaGift);
                    }
                }
                Gift giftReceived = null;
                //Assign gift if only 1 in category
                if (possibleGifts.size() == 1
                        && possibleGifts.get(0).getQuantity() != 0) {
                    //Decrease quantity of gift in santa's sack
                    santa.decreaseQuantityForGift(possibleGifts.get(0).getProductName());
                    //Assign gift to child
                    giftReceived = new Gift(possibleGifts.get(0));
                    //Assign gift if more than 1 in category
                } else if (possibleGifts.size() > 1) {
                    //sort by price
                    possibleGifts.sort(Comparator.comparing(SantaGift::getPrice));
                    //if in budget
                    if (possibleGifts.get(0).getQuantity() != 0) {
                        santa.decreaseQuantityForGift(possibleGifts.get(0).getProductName());
                        giftReceived = new Gift(possibleGifts.get(0));
                    }
                }
                if (giftReceived != null)
                    child.addGift(giftReceived);
            }
        }
    }
}
