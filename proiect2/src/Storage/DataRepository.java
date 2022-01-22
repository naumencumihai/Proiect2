package Storage;

import java.util.List;

public class DataRepository {
    private int numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    public DataRepository() {}

    public DataRepository(int numberOfYears, Double santaBudget, InitialData initialData, List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public void setAnnualChanges(List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    @Override
    public String toString() {
        return "{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", initialData=" + initialData +
                ", annualChanges=" + annualChanges +
                '}';
    }
}
