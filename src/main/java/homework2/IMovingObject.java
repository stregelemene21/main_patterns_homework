package homework2;

import homework2.object_params.Location;
import homework2.object_params.Velocity;

public interface IMovingObject {

    Location getLocation();

    Velocity getVelocity();

    void setLocation(Location location);

}