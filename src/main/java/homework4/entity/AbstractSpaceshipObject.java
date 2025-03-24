package homework4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static homework4.entity.Params.*;
import static homework4.utils.Utils.calculateAngleByVelocity;
import static homework4.utils.Utils.calculateNewVelocityByNewAngle;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractSpaceshipObject implements IMovingObject, IRotatingObject {

    Location location;
    Velocity velocity;
    FuelCount fuelCount;
    FuelEfficiency fuelEfficiency;

    @Override
    public Angle getAngle() {
        return calculateAngleByVelocity(velocity);
    }

    @Override
    public void setAngle(Angle angle) {
        this.velocity = calculateNewVelocityByNewAngle(velocity, angle);
    }
}
