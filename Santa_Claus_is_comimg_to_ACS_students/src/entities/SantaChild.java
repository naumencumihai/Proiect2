package entities;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.List;

public class SantaChild extends ChildSuper {
    private Double niceScore;
    private Double niceScoreBonus;
    private ElvesType elf;

    public SantaChild() { }

    public SantaChild(int id, String lastName, String firstName, int age,
                      Cities city, Double niceScore, List<Category> giftsPreferences,
                      Double niceScoreBonus, ElvesType elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public ElvesType getElf() {
        return elf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(List<Category> giftsPreference) {
        this.giftsPreferences = giftsPreference;
    }

    public void setNiceScoreBonus(Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public void setElf(ElvesType elf) {
        this.elf = elf;
    }

    @Override
    public String toString() {
        return "SantaChild{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", giftsPreferences=" + giftsPreferences +
                ", niceScore=" + niceScore +
                ", niceScoreBonus=" + niceScoreBonus +
                ", elf=" + elf +
                '}';
    }
}
