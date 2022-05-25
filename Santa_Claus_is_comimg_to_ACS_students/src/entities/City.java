package entities;

import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class City {
    private Cities name;
    private Double score;
    private List<Double> scores = new ArrayList<>();
    private List<Child> children = new ArrayList<>();

    public City(Cities name) {
        this.name = name;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public void addToCityScores(Double score) {
        scores.add(score);
    }

    public void calculateAverageScore() {
        Double sum = 0.0d;
        for (Double score : this.scores) {
            sum += score;
        }
        this.score = sum / this.scores.size();
    }

    public Cities getName() {
        return name;
    }

    public String getNameString() {
        return name.toString();
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setName(Cities name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "\n ---" + "City{" +
                "name=" + name +
                ", score=" + score +
                ", scores=" + scores +
                ", children=" + children +
                '}';
    }
}
