package homework4.entity;

import homework4.entity.Params.Angle;
import homework4.entity.Params.Velocity;

import static homework4.entity.Params.*;

public interface IRotatingObject {

//    Velocity getVelocity();

    Angle getAngle();

//    void setVelocity(Velocity velocity);

    void setAngle(Angle angle);

    void setLocation(Location location);
}
