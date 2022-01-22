package entities;

import enums.Category;
import enums.Cities;

import java.util.List;

public class Child extends ChildSuper {
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public Child(int id, String lastName, String firstName, int age,
                 Cities city, List<Category> giftsPreferences,
                 Double averageScore, List<Double> niceScoreHistory,
                 Double assignedBudget, List<Gift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }

    public Child(SantaChild santaChild) {
        this.id = santaChild.getId();
        this.lastName = santaChild.getLastName();
        this.firstName = santaChild.getFirstName();
        this.age = santaChild.getAge();
        this.city = santaChild.getCity();
        this.giftsPreferences = santaChild.getGiftsPreferences();
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
