package Storage;

import Entities.Child;
import Entities.ChildUpdate;
import Entities.Gift;
import enums.CityStrategyEnum;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<Gift> newGifts;
    private List<Child> newChildren;
    private List<ChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

    public AnnualChange(){}

    public AnnualChange(Double newSantaBudget, List<Gift> newGifts,
                        List<Child> newChildren,
                        List<ChildUpdate> childrenUpdates,
                        CityStrategyEnum strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public List<Child> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<Child> newChildren) {
        this.newChildren = newChildren;
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
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                ", strategy=" + strategy +
                '}';
    }
}
