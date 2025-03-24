package homework4.exception;

public class ChangeVelocityException extends RuntimeException {

    private static final String MESSAGE = "Couldn't set new velocity for %s";

    public ChangeVelocityException(Object obj) {
        super(String.format(MESSAGE, obj.getClass().getSimpleName()));
    }
}
