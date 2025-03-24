package homework4.command;

import homework4.entity.IMovingObject;
import homework4.entity.IRotatingObject;
import homework4.entity.Params;
import homework4.exception.ChangeVelocityException;
import homework4.utils.Utils;
import lombok.AllArgsConstructor;

import java.util.Objects;

import static homework4.entity.Params.*;
import static homework4.utils.Utils.calculateNewVelocityByNewAngle;

@AllArgsConstructor
public class ChangeVelocityCommand implements ICommand {

    Object object;

    Angle angle;

    @Override
    public void execute() {
        if (object instanceof IRotatingObject rotatingObj) {
            rotatingObj.setAngle(angle);
        } else if (object instanceof IMovingObject movingObj) {
            movingObj.setVelocity(
                    calculateNewVelocityByNewAngle(movingObj.getVelocity(), angle));
        } else {
            throw new ChangeVelocityException(object);
        }
    }
}
