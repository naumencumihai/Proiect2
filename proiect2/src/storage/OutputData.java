package storage;

import entities.Child;

import java.util.List;

public class OutputData {
    private List<List<Child>> annualChildren;

    public OutputData() { }

    public OutputData(List<List<Child>> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public void addChildrenThisYear(List<Child> childrenThisYear) {
        annualChildren.add(childrenThisYear);
    }

    public List<List<Child>> getAnnualChildren() {
        return annualChildren;
    }
}
