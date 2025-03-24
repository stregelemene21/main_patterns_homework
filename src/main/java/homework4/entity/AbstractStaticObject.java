package homework4.entity;

import homework4.entity.Params.Angle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static homework4.entity.Params.*;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractStaticObject implements IRotatingObject {

    Location location;
    Angle angle;

}
