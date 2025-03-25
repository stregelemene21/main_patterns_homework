package homework4.utils;

import homework4.entity.IRotatingObject;

import static homework4.entity.Params.*;
import static java.lang.Math.*;

public class Utils {

    public static Angle calculateAngleDegreesByVelocity(Velocity velocity) {
        return new Angle(
                (int) toDegrees(atan2(velocity.y(), velocity.x())));
    }

    public static Velocity calculateNewVelocityByNewAngle(Velocity velocity, Angle angle) {
        var distance = calculateDistanceByVelocity(velocity).length();
        double angleInRadiance = Math.toRadians(angle.angleDegrees()
                + calculateAngleDegreesByVelocity(velocity).angleDegrees());

        double newX = distance * Math.cos(angleInRadiance);
        double newY = distance * Math.sin(angleInRadiance);
        return new Velocity((int) newX, (int) newY);
    }

    public static Distance calculateDistanceByVelocity(Velocity velocity) {
        return new Distance(
                (int) sqrt((pow(velocity.x(), 2) + pow(velocity.y(), 2))));
    }

    public static FuelCount calculateBurnedFuelByDistanceAndEfficiency(Distance distance, FuelEfficiency fuelEfficiency) {
        return new FuelCount(distance.length() * fuelEfficiency.percentOnDistanceUnit());
    }

    public static Angle calculateNewAngleForOnlyRotatingObject(IRotatingObject object, Angle angle) {
        return new Angle(
                normalizeAngle(
                        object.getAngle().angleDegrees() + angle.angleDegrees()));
    }

    public static int normalizeAngle(int angle) {
        return ((angle % 360) + 360) % 360;
    }
}
