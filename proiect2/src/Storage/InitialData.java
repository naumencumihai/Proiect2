package Storage;

import Entities.Child;
import Entities.Gift;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    List<Child> children = new ArrayList<>();
    List<Gift> santaGiftsList = new ArrayList<>();

    public InitialData() {}

    public InitialData(List<Child> children, List<Gift> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void setSantaGiftsList(List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    @Override
    public String toString() {
        return "{" +
                "children=" + children +
                ", santaGiftsList=" + santaGiftsList +
                '}';
    }
}
