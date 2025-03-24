package homework4.entity;

import static homework4.entity.Params.*;

public class Spaceship extends AbstractSpaceshipObject {

    public Spaceship(Location location, Velocity velocity, FuelCount fuelCount,
                     FuelEfficiency fuelEfficiency) {
        super(location, velocity, fuelCount, fuelEfficiency);
    }

    public Spaceship(FuelCount fuelCount) {
        super(null, null, fuelCount, null);
    }
}
