package entities;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class Child extends ChildSuper {
    private Double averageScore = 0.0d;
    private List<Double> niceScoreHistory =  new ArrayList<>();
    private Double assignedBudget;
    private List<Gift> receivedGifts = new ArrayList<>();

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
        this.giftsPreferences.addAll(santaChild.getGiftsPreferences());
    }

    public void addToNiceScoreHistory(Double niceScore) {
        this.niceScoreHistory.add(niceScore);
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void addBonus(Double niceScoreBonus) {
        averageScore += averageScore * niceScoreBonus / 100;
        if (averageScore > 10) averageScore = 10.0d;
    }

    public void setAverageScoreWithoutBonus() {
        if (age < 5)
            averageScore = 10.0d;
        else if (age < 12) {
            for (Double score : niceScoreHistory) {
                averageScore += score;
            }
            averageScore /= niceScoreHistory.size();
        } else if (age <= 18) {
            double divisor = 0.0d;
            for (int i = 0; i < niceScoreHistory.size(); i++) {
                averageScore += niceScoreHistory.get(i) * (i + 1);
                divisor += (i + 1);
            }
            averageScore /= divisor;
        }
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory.addAll(niceScoreHistory);
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

    public void addGift(Gift gift) {
        this.receivedGifts.add(gift);
    }

    @Override
    public String toString() {
        return "\n" + "Child{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", giftsPreferences=" + giftsPreferences +
                ", averageScore=" + averageScore +
                ", niceScoreHistory=" + niceScoreHistory +
                ", assignedBudget=" + assignedBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }
}
