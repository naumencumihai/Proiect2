package Storage;

import entities.SantaChild;
import entities.SantaGift;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    List<SantaChild> santaChildren = new ArrayList<>();
    List<SantaGift> santaGiftsList = new ArrayList<>();

    public InitialData() {}

    public InitialData(List<SantaChild> santaChildren, List<SantaGift> santaGiftsList) {
        this.santaChildren = santaChildren;
        this.santaGiftsList = santaGiftsList;
    }

    public List<SantaChild> getChildren() {
        return santaChildren;
    }

    public List<SantaGift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setChildren(List<SantaChild> santaChildren) {
        this.santaChildren = santaChildren;
    }

    public void setSantaGiftsList(List<SantaGift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    @Override
    public String toString() {
        return "{" +
                "santaChildren=" + santaChildren +
                ", santaGiftsList=" + santaGiftsList +
                '}';
    }
}
