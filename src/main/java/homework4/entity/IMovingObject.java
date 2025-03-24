package homework4.entity;


import homework4.entity.Params.FuelCount;
import homework4.entity.Params.Location;
import homework4.entity.Params.Velocity;

import static homework4.entity.Params.*;

public interface IMovingObject {

    FuelCount getFuelCount();

    FuelEfficiency getFuelEfficiency();

    Location getLocation();

    Velocity getVelocity();

    Angle getAngle();

    void setLocation(Location location);

    void setVelocity(Velocity velocity);

    void setFuelCount(FuelCount fuelCount);

    void setFuelEfficiency(FuelEfficiency fuelEfficiency);

}
