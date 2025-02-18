package homework2;

import homework2.object_params.Location;
import homework2.object_params.Velocity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class BattleParticipant implements IMovingObject, IRotatingObject {

    private Location location;

    private Velocity velocity;

}
