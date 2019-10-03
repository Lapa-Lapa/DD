package utils.Exceptions;

/**
 * Thrown to indicate that an invalid URL has occurred. Either URL string could not be parsed.
 * @author Darya_Tarelko
 */
public class InvalidUrlForAppiumDriver extends RuntimeException {

    public InvalidUrlForAppiumDriver(String message) {
        super(message);
    }
}
