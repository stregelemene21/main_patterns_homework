package homework4.exception;

import homework4.entity.IMovingObject;
import lombok.AllArgsConstructor;

import static java.lang.String.format;

public class BurnFuelException extends RuntimeException {

    IMovingObject object;

    private static final String MESSAGE = "The %s doesn't have enough fuel count " +
            "to cover the distance";

    public BurnFuelException(IMovingObject object) {
        super(format(MESSAGE, object.getClass().getSimpleName()));
    }
}
