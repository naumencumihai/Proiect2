package main;

import checker.Checker;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws JsonProcessingException {
        App app = new App();
        app.ParseInput(19);


        Checker.calculateScore();
    }
}
