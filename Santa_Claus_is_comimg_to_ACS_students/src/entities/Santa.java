package entities;

import enums.ElvesType;
import storage.ChildrenRecord;

import java.util.ArrayList;
import java.util.List;

public class Santa {
    private List<SantaChild> santaChildren;
    private List<SantaGift> santaGifts;
    private Double santaBudget;
    private ChildrenRecord childrenRecord = new ChildrenRecord();

    public Santa(List<SantaChild> santaChildren, List<SantaGift> santaGifts, Double santaBudget) {
        this.santaChildren = santaChildren;
        this.santaGifts = santaGifts;
        this.santaBudget = santaBudget;
    }

    public void passToNextYear() {
        for (SantaChild santaChild : santaChildren) {
            santaChild.increaseAge();
        }
    }

    public void decreaseQuantityForGift(String productName) {
        SantaGift giftToRemove = null;
        for (SantaGift santaGift : santaGifts) {
            if (santaGift.getProductName().equals(productName)) {
                santaGift.decreaseQuantity();
                if (santaGift.getQuantity() == 0) {
                    giftToRemove = santaGift;
                }
            }
        }
        if (giftToRemove != null) {
            santaGifts.remove(giftToRemove);
        }
    }

    public void removeChild(int id) {
        santaChildren.removeIf(santaChild -> santaChild.getId() == id);
    }

    public void addChild(SantaChild santaChild) {
        santaChildren.add(santaChild);
        childrenRecord.addNiceScoreToRecord(santaChild.getId(), santaChild.getNiceScore());
    }

    public void addGift(SantaGift gift) {
        santaGifts.add(gift);
    }

    public ChildrenRecord getChildrenRecord() {
        return childrenRecord;
    }

    public void setChildrenRecord(ChildrenRecord childrenRecord) {
        this.childrenRecord = childrenRecord;
    }

    public List<SantaChild> getSantaChildren() {
        return santaChildren;
    }

    public Double getNiceScoreBonusForChild(int id) {
        for (SantaChild santaChild : santaChildren) {
            if (santaChild.getId() == id) {
                return santaChild.getNiceScoreBonus();
            }
        }
        return null;
    }

    public ElvesType getElfForChild(int id) {
        for (SantaChild santaChild : santaChildren) {
            if (santaChild.getId() == id) {
                return santaChild.getElf();
            }
        }
        return null;
    }

    public void setSantaChildren(List<SantaChild> santaChildren) {
        this.santaChildren = santaChildren;
    }

    public List<SantaGift> getSantaGifts() {
        return santaGifts;
    }

    public void setSantaGifts(List<SantaGift> santaGifts) {
        this.santaGifts = santaGifts;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    @Override
    public String toString() {
        return "Santa{" +
                "santaChildren=" + santaChildren +
                ", santaGifts=" + santaGifts +
                ", santaBudget=" + santaBudget +
                '}';
    }
}
