package storage;

import entities.SantaChild;
import entities.ChildUpdate;
import entities.SantaGift;
import enums.CityStrategyEnum;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<SantaGift> newSantaGifts;
    private List<SantaChild> newSantaChildren;
    private List<ChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

    public AnnualChange(){}

    public AnnualChange(Double newSantaBudget, List<SantaGift> newSantaGifts,
                        List<SantaChild> newSantaChildren,
                        List<ChildUpdate> childrenUpdates,
                        CityStrategyEnum strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newSantaGifts = newSantaGifts;
        this.newSantaChildren = newSantaChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<SantaGift> getNewGifts() {
        return newSantaGifts;
    }

    public void setNewGifts(List<SantaGift> newSantaGifts) {
        this.newSantaGifts = newSantaGifts;
    }

    public List<SantaChild> getNewChildren() {
        return newSantaChildren;
    }

    public void setNewChildren(List<SantaChild> newSantaChildren) {
        this.newSantaChildren = newSantaChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    public void setStrategy(CityStrategyEnum strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "annualChange{" +
                "newSantaBudget=" + newSantaBudget +
                ", newSantaGifts=" + newSantaGifts +
                ", newSantaChildren=" + newSantaChildren +
                ", childrenUpdates=" + childrenUpdates +
                ", strategy=" + strategy +
                '}';
    }
}
