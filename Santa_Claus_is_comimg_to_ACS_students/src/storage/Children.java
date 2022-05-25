package storage;

import entities.Child;

import java.util.List;

public class Children {
    List<Child> children;

    public Children(List<Child> children) {
        this.children = children;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Children{" +
                "children=" + children +
                '}';
    }
}
