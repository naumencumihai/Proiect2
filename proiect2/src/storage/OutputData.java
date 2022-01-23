package storage;

import entities.Child;

import java.util.ArrayList;
import java.util.List;

public class OutputData {
    private final List<List<Child>> annualChildren = new ArrayList<>();

    public OutputData() { }

    public void addChildrenThisYear(List<Child> childrenThisYear) {
        annualChildren.add(childrenThisYear);
    }

    public List<List<Child>> getAnnualChildren() {
        return annualChildren;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "annualChildren=" + annualChildren +
                '}';
    }
}
