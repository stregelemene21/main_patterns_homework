package homework2.actions;

import homework2.IRotatingObject;
import homework2.exceptions.RotateException;
import homework2.object_params.Velocity;

public class Rotate {

    public static void rotate(IRotatingObject rotateObject) {
        var actualVelocity = rotateObject.getVelocity();
        Velocity newVelocity;
        try {
            newVelocity = new Velocity(-actualVelocity.x(), -actualVelocity.y());
        } catch (NullPointerException e) {
            throw new RotateException("one or more required params are missing! " + e.getMessage());
        }

        if (newVelocity.x() == actualVelocity.x() && newVelocity.y() == actualVelocity.y()) {
            throw new RotateException("object didn't rotate, velocity is null!");
        }

        try {
            rotateObject.setVelocity(newVelocity);
        } catch (Exception e) {
            throw new RotateException("can't set new velocity to object " + e.getMessage());
        }
    }
}