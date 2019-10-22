package glue_visibility.utils;

import org.apache.log4j.Logger;
import utils.Exceptions.TestDataException;

import java.util.List;

public class ResultsAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(ResultsAnalyzer.class);

    public static boolean isListsEqual(List<String> actual, List<String> expected) { //TODO:asserts fisrst second actual expected
        LOGGER.info("Expected results list: " + expected.toString());
        LOGGER.info("Actual results list: " + actual.toString());
        if (expected != null && actual != null) {
            //TODO: Logs here - Done
            return actual.equals(expected);
        }
        if (expected == null) {
            //TODO: Expected test data list null exeption - Done
            throw new TestDataException("ERROR! - List of expected results is null.");
        } else {
            //TODO:(expected=null&actual=null)
            return false;
        }
    }

    public static boolean isNumbersEqual(Integer actual, Integer expected) {
        LOGGER.info("Expected: " + expected + " number of results");
        LOGGER.info("Actual: " + actual + " number of results");
        if (expected != null && actual != null) {
            return actual.equals(expected);
        }
        if (expected == null) {
            throw new TestDataException("ERROR! - Number of expected results is null.");
        } else {
            //TODO:(expected=null&actual=null)
            return false;
        }
    }
}
