package homework4.command;

import homework4.entity.IMovingObject;
import homework4.entity.IRotatingObject;
import homework4.entity.Params;
import homework4.exception.ChangeVelocityException;
import homework4.exception.RotateException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import static homework4.entity.Params.*;
import static homework4.utils.Utils.calculateNewAngleForOnlyRotatingObject;
import static homework4.utils.Utils.calculateNewVelocityByNewAngle;

@AllArgsConstructor
public class RotateCommand implements ICommand {

    Object object;

    Angle angle;

    public void execute() {
        if (object instanceof IRotatingObject rotatingObj) {
            rotatingObj.setAngle(
                    calculateNewAngleForOnlyRotatingObject(rotatingObj, angle));
        } else if (object instanceof IMovingObject movingObj) {
            new ChangeVelocityCommand(movingObj,
                    calculateNewVelocityByNewAngle(movingObj.getVelocity(), angle))
                    .execute();
        } else {
            throw new RotateException(object);
        }
    }
}
