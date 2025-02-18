package homework2;

import homework2.exceptions.MoveException;
import homework2.exceptions.RotateException;
import homework2.object_params.Location;
import homework2.object_params.Velocity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static homework2.actions.Move.move;
import static homework2.actions.Rotate.rotate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Homework2")
public class MovingObjectTest {

    @Test
    void simpleMoveTest() {
        var expectedLocation = new Location(5, 8);
        IMovingObject spaceship = new SimpleSpaceship(
                new Location(12, 5), new Velocity(-7, 3));
        move(spaceship);
        assertEquals(
                spaceship.getLocation().x(), expectedLocation.x());
        assertEquals(
                spaceship.getLocation().y(), expectedLocation.y());
    }

    @Test
    void errorWhileMoveObjectWithoutLocationTest() {
        IMovingObject spaceship = new SimpleSpaceship(null,
                new Velocity(100, 50));
        assertThrows(MoveException.class, () -> move(spaceship));
    }

    @Test
    void errorWhileMoveObjectWithoutVelocityTest() {
        IMovingObject spaceship = new SimpleSpaceship(
                new Location(54, 81), null);
        assertThrows(MoveException.class, () -> move(spaceship));
    }

    @Test
    void errorWhileMoveObjectWithoutMoveParamsTest() {
        IMovingObject spaceship = new SimpleSpaceship(null, null);
        assertThrows(MoveException.class, () -> move(spaceship));
    }

    @Test
    void errorWhileMoveObjectTest() {
        IMovingObject spaceship = new SimpleSpaceship(
                new Location(1, 1), new Velocity(0, 0));
        assertThrows(MoveException.class, () -> move(spaceship));
    }

    @Test
    void simpleRotateTest() {
        var actualVelocity = new Velocity(-1, 1);
        var expectedVelocity = new Velocity(1, -1);
        IRotatingObject spaceship = new SimpleSpaceship(null, actualVelocity);
        rotate(spaceship);
        assertEquals(
                spaceship.getVelocity().x(), expectedVelocity.x());
        assertEquals(
                spaceship.getVelocity().y(), expectedVelocity.y());
    }

    @Test
    void rotateObjectWithoutLocationTest() {
        IRotatingObject spaceship = new SimpleSpaceship(null, new Velocity(100, 50));
        rotate(spaceship);
        assertEquals(spaceship.getVelocity().x(), -100);
        assertEquals(spaceship.getVelocity().y(), -50);
    }

    @Test
    void errorWhileRotateObjectWithoutVelocityTest() {
        IRotatingObject spaceship = new SimpleSpaceship(
                new Location(54, 81), null);
        assertThrows(RotateException.class, () -> rotate(spaceship));
    }

    @Test
    void errorWhileRotateObjectWithoutParamsTest() {
        IRotatingObject spaceship = new SimpleSpaceship(null, null);
        assertThrows(RotateException.class, () -> rotate(spaceship));
    }

    @Test
    void errorWhileRotateObjectTest() {
        IRotatingObject spaceship = new SimpleSpaceship(
                new Location(1, 1), new Velocity(0, 0));
        assertThrows(RotateException.class, () -> rotate(spaceship));
    }
}
