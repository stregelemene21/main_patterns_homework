package homework2.actions;

import homework2.IMovingObject;
import homework2.exceptions.MoveException;
import homework2.object_params.Location;

public class Move {

    public static void move(IMovingObject movingObject) {
        var actualLocation = movingObject.getLocation();
        var actualVelocity = movingObject.getVelocity();
        Location newLocation;
        try {
            newLocation = new Location(
                    actualLocation.x() + actualVelocity.x(),
                    actualLocation.y() + actualVelocity.y());
        } catch (NullPointerException e) {
            throw new MoveException("one or more required params are missing! " + e.getMessage());
        }

        if (newLocation.x() == actualLocation.x() && newLocation.y() == actualLocation.y()) {
            throw new MoveException("object didn't move, velocity is null!");
        }

        try {
            movingObject.setLocation(newLocation);
        } catch (Exception e) {
            throw new MoveException("can't set new location to object " + e.getMessage());
        }
    }
}
