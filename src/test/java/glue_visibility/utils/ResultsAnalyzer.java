package glue_visibility.utils;

import org.apache.log4j.Logger;
import utils.Exceptions.TestDataException;

import java.util.List;

public class ResultsAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(ResultsAnalyzer.class);

    public static boolean isListsEqual(List<String> actual, List<String> expected) {
        if (expected != null && actual != null) {
            //TODO: Logs here - Done
            LOGGER.info("Expected results list: " + expected.toString());
            LOGGER.info("Actual results list: " + actual.toString());
            return actual.equals(expected);
        }
        if (expected == null) {
            //TODO: Expected test data list null exeption - Done
            throw new TestDataException("ERROR! - List of expected results is null.");
        } else {
            return false;
        }
    }

    public static boolean isNumbersEqual(Integer actual, Integer expected) {
        if (expected != null && actual != null) {
            LOGGER.info("Expected: " + expected + " number of results");
            LOGGER.info("Actual: " + actual + " number of results");
            return actual.equals(expected);
        }
        if (expected == null) {
            throw new TestDataException("ERROR! - Number of expected results is null.");
        } else {
            return false;
        }
    }
}
