package storage;

import java.util.*;

public class ChildrenRecord {
    private final Map<Integer, List<Double>> niceScoreHistoryRecord = new TreeMap<>();

    public ChildrenRecord() { }

    public void addNiceScoreToRecord(Integer id, Double niceScore) {
        getNiceScoreHistoryForChild(id).add(niceScore);
    }

    public List<Double> getNiceScoreHistoryForChild(int id) {
        return this.niceScoreHistoryRecord.computeIfAbsent(id, i -> new ArrayList<>());
    }

    @Override
    public String toString() {
        return "ChildrenRecord{" +
                "niceScoreHistoryRecord=" + niceScoreHistoryRecord +
                '}';
    }
}
