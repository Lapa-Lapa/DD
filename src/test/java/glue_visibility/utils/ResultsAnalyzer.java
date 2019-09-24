package glue_visibility.utils;

import java.util.List;

public class ResultsAnalyzer {
    public static boolean isListsEqual(List<String> actual, List<String> expected) {
        if (actual != null && expected != null) {
            System.out.println(actual.equals(expected));
            return actual.equals(expected);
        } else {
            return false;
        }
    }
}
