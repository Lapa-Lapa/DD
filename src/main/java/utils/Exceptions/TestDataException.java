package utils.Exceptions;

/**
 * Thrown if an application not succeeds to get test data for expected result took place
 * @author Darya_Tarelko
 */
public class TestDataException extends RuntimeException {

    public TestDataException(String message) {
        super(message);
    }
}
