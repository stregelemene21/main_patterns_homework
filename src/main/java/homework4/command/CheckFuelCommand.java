package homework4.command;

import homework4.entity.IMovingObject;
import homework4.exception.LowFuelException;
import lombok.AllArgsConstructor;

import static homework4.entity.Params.*;
import static homework4.utils.Utils.calculateBurnedFuelByDistanceAndEfficiency;
import static homework4.utils.Utils.calculateDistanceByVelocity;

@AllArgsConstructor
public class CheckFuelCommand implements ICommand {

    IMovingObject object;

    @Override
    public void execute() {
        checkStartFuelCount();
        var actualFuel = object.getFuelCount();
        var distance = calculateDistanceByVelocity(object.getVelocity());
        var burnedFuel = calculateBurnedFuelByDistanceAndEfficiency(distance, object.getFuelEfficiency());
        checkMoveOpportunity(actualFuel, burnedFuel);
    }

    private void checkStartFuelCount() {
        if (object.getFuelCount().percent() < 1) {
            throw new LowFuelException(object);
        }
    }

    private void checkMoveOpportunity(FuelCount actualFuel, FuelCount burnedFuel) {
        if (actualFuel.percent() < burnedFuel.percent()) {
            throw new LowFuelException(object, actualFuel);
        }
    }
}
