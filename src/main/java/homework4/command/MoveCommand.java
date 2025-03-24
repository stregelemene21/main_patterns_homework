package homework4.command;

import homework4.entity.IMovingObject;
import homework4.exception.MoveException;
import lombok.AllArgsConstructor;

import static homework4.entity.Params.*;

@AllArgsConstructor
public class MoveCommand implements ICommand {

    IMovingObject object;

    @Override
    public void execute() {
        var newLocation = calculateNewLocation();
        if (newLocation.equals(object.getLocation())) {
            throw new MoveException(object);
        } else {
            object.setLocation(calculateNewLocation());
        }
    }

    private Location calculateNewLocation() {
        return new Location(
                object.getLocation().x() + object.getVelocity().x(),
                object.getLocation().x() + object.getVelocity().y());
    }
}
