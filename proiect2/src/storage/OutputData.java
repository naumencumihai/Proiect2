package storage;

import entities.Child;

import java.util.ArrayList;
import java.util.List;

public class OutputData {
    private final List<Children> annualChildren = new ArrayList<>();

    public OutputData() { }

    public void addChildrenThisYear(Children childrenThisYear) {
        annualChildren.add(childrenThisYear);
    }

    public List<Children> getAnnualChildren() {
        return annualChildren;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "annualChildren=" + annualChildren +
                '}';
    }
}
