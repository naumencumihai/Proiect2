package entities;

import java.util.List;

public class Santa {
    private List<SantaChild> santaChildren;
    private List<SantaGift> santaGifts;
    private Double santaBudget;

    public Santa(List<SantaChild> santaChildren, List<SantaGift> santaGifts, Double santaBudget) {
        this.santaChildren = santaChildren;
        this.santaGifts = santaGifts;
        this.santaBudget = santaBudget;
    }

    public List<SantaChild> getSantaChildren() {
        return santaChildren;
    }

    public void setSantaChildren(List<SantaChild> santaChildren) {
        this.santaChildren = santaChildren;
    }

    public List<SantaGift> getSantaGifts() {
        return santaGifts;
    }

    public void setSantaGifts(List<SantaGift> santaGifts) {
        this.santaGifts = santaGifts;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }
}
