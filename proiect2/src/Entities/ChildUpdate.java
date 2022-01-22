package Entities;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildUpdate {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private ElvesType elf;

    public ChildUpdate(){}

    public ChildUpdate(int id, Double niceScore, List<Category> giftsPreferences, ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    public int getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public ElvesType getElf() {
        return elf;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                ", elf=" + elf +
                '}';
    }
}
