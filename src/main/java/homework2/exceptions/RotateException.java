package homework2.exceptions;

import static java.lang.String.format;

public class RotateException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "An error occurred while rotating object, %s";

    public RotateException(String cause) {
        super(format(DEFAULT_MESSAGE, cause));
    }
}
