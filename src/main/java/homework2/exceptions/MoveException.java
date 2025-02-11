package homework2.exceptions;

import static java.lang.String.format;

public class MoveException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "An error occurred while moving object, %s";

    public MoveException(String cause) {
        super(format(DEFAULT_MESSAGE, cause));
    }
}