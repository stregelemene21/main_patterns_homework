package homework4.exception;

import homework4.entity.IMovingObject;

import static java.lang.String.format;

public class MoveException extends RuntimeException {

    private static final String MESSAGE = "An exception while executing MoveCommand for %s has been thrown";

    public MoveException(IMovingObject object) {
        super(format(MESSAGE, object.getClass().getSimpleName()));
    }
}
