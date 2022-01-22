package main;

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
        santa.setSantaChildren(santaChildren);
        santa.setSantaGifts(santaGifts);
        santa.setSantaBudget(input.get("santaBudget").asDouble());
    }

    public void WriteOutputData() {
        outputData = new OutputData();
        for(int i = 0; i <= numberOfYears; i++) {
            StrategyFactory strategyFactory = new StrategyFactory();
            Strategy strategy = strategyFactory.createStrategy(annualChanges.get(i).getStrategy());
            outputData.addChildrenThisYear(strategy.getChildrenThisYear(this));
        }
    }

    public void WriteToFile(Integer testNumber) {

    }
}
