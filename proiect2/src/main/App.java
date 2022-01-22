package main;

import entities.SantaChild;
import entities.SantaGift;
import Storage.AnnualChange;
import Storage.InputData;
import Storage.InitialData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static common.Constants.FILE_EXTENSION;

public class App {
    InputData inputData = new InputData();
    JsonNode input;

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
        InitialData initialData = new InitialData(santaChildren, santaGifts);

        String annualChangesString = input.get("annualChanges").toString();
        List<AnnualChange> annualChanges = mapper.readValue(annualChangesString,
                new TypeReference<>() {});

        inputData.setNumberOfYears(input.get("numberOfYears").asInt());
        inputData.setSantaBudget(input.get("santaBudget").asDouble());
        inputData.setInitialData(initialData);
        inputData.setAnnualChanges(annualChanges);
    }


}
