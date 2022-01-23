package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildrenRecord {
    private final Map<Integer, List<Double>> niceScoreHistoryRecord =  new HashMap<>();

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
