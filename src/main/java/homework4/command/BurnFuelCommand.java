package homework4.command;

import homework4.entity.IMovingObject;
import homework4.exception.BurnFuelException;
import lombok.AllArgsConstructor;

import static homework4.entity.Params.*;
import static homework4.utils.Utils.calculateBurnedFuelByDistanceAndEfficiency;
import static homework4.utils.Utils.calculateDistanceByVelocity;

@AllArgsConstructor
public class BurnFuelCommand implements ICommand {

    IMovingObject object;

    @Override
    public void execute() {
        var actualFuel = object.getFuelCount();
        var distance = calculateDistanceByVelocity(object.getVelocity());
        var burnedFuel = calculateBurnedFuelByDistanceAndEfficiency(distance, object.getFuelEfficiency());
        if (actualFuel.percent() < burnedFuel.percent() || burnedFuel.percent() == 0) {
            throw new BurnFuelException(object);
        } else {
            setNewFuelCount(actualFuel, burnedFuel);
        }
    }

    private void setNewFuelCount(FuelCount actualFuel, FuelCount burnedFuel) {
        object.setFuelCount(new FuelCount(actualFuel.percent() - burnedFuel.percent()));
    }
}
