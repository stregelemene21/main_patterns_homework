package homework4.command;

import homework4.entity.IMovingObject;
import homework4.entity.IRotatingObject;
import homework4.exception.ChangeVelocityException;
import lombok.AllArgsConstructor;


import static homework4.entity.Params.*;
import static homework4.utils.Utils.*;

@AllArgsConstructor
public class ChangeVelocityCommand implements ICommand {

    Object object;

    Velocity velocity;

    @Override
    public void execute() {
        if (object instanceof IRotatingObject rotatingObj) {
            var rotateAngle = calculateAngleDegreesByVelocity(velocity).angleDegrees();
            rotatingObj.setAngle(
                    calculateNewAngleForOnlyRotatingObject(
                            rotatingObj, new Angle(rotateAngle)));

        } else if (object instanceof IMovingObject movingObj) {
            movingObj.setVelocity(velocity);
        } else {
            throw new ChangeVelocityException(object);
        }
    }
}
