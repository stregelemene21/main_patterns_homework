package homework4.exception;

import homework4.entity.IMovingObject;

import static homework4.entity.Params.*;
import static java.lang.String.format;

public class LowFuelException extends RuntimeException {

    private static final String LOW_FUEL_BEFORE_MOVE_MESSAGE = "The object %s has insufficient fuel" +
            " for further actions";

    private static final String LOW_FUEL_FOR_COVER_DISTANCE_MESSAGE = "The object %s " +
            "has %s percent of fuel and can no longer move at its velocity";

    public LowFuelException(IMovingObject object) {
        super(format(LOW_FUEL_BEFORE_MOVE_MESSAGE, object.getClass().getSimpleName()));
    }

    public LowFuelException(IMovingObject object, FuelCount fuelCount) {
        super(format(LOW_FUEL_FOR_COVER_DISTANCE_MESSAGE, object.getClass().getSimpleName(),
                fuelCount));
    }
}
