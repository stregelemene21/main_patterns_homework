package homework4.exception;

public class RotateException extends RuntimeException {

    private static final String MESSAGE = "Object %s can't rotate";

    public RotateException(Object obj) {
        super(String.format(MESSAGE, obj.getClass().getSimpleName()));
    }
}
