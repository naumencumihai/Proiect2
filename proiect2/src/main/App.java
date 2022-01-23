package main;

import entities.Child;
import enums.CityStrategyEnum;
import storage.OutputData;
import entities.Santa;
import entities.SantaChild;
import entities.SantaGift;
import storage.AnnualChange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import strategy.Strategy;
import strategy.StrategyFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static common.Constants.FILE_EXTENSION;

public class App {
    private JsonNode input;
    protected Integer numberOfYears;
    protected List<AnnualChange> annualChanges;
    protected Santa santa;
    private OutputData outputData;

    public App() { }

    public void ParseInput(Integer testNumber) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            input = mapper.readTree(new File("tests/test"
                    + testNumber
                    + FILE_EXTENSION));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String initialDataString = input.get("initialData").toString();
        JsonNode jsonNode = mapper.readTree(initialDataString);
        String childrenString = jsonNode.get("children").toString();
        String santaGiftsListString = jsonNode.get("santaGiftsList").toString();
        List<SantaChild> santaChildren = mapper.readValue(childrenString,
                new TypeReference<>() {});
        List<SantaGift> santaGifts = mapper.readValue(santaGiftsListString,
                new TypeReference<>() {});
        String annualChangesString = input.get("annualChanges").toString();

        numberOfYears = input.get("numberOfYears").asInt();
        annualChanges = mapper.readValue(annualChangesString, new TypeReference<>() {});
        santa = new Santa(santaChildren, santaGifts, input.get("santaBudget").asDouble());
    }

    public void WriteOutputData() {
        outputData = new OutputData();
        StrategyFactory strategyFactory = new StrategyFactory();
        outputData.addChildrenThisYear(strategyFactory.
                createStrategy(CityStrategyEnum.ID).getChildrenThisYear(this, 0));

        for (int i = 0; i < numberOfYears; i++) {
            Strategy strategy = strategyFactory.createStrategy(annualChanges.get(i).getStrategy());
            System.out.println(strategy);
            outputData.addChildrenThisYear(strategy.getChildrenThisYear(this, i + 1));
        }
    }

    public void WriteToFile(Integer testNumber) {

    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public Santa getSanta() {
        return santa;
    }

    public void setSanta(Santa santa) {
        this.santa = santa;
    }

    public OutputData getOutputData() {
        return outputData;
    }
}
