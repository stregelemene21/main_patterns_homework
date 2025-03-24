package homework4;

import homework4.command.*;
import homework4.entity.IMovingObject;
import homework4.entity.Params.FuelCount;
import homework4.entity.Spaceship;
import homework4.exception.BurnFuelException;
import homework4.exception.LowFuelException;
import homework4.exception.MacroCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Queue;

import static homework3.Logger.isLogContains;
import static homework4.entity.Params.*;
import static homework4.utils.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Homework4")
public class CommandTest {

    IMovingObject spaceship;

    @BeforeEach
    void createSpaceship() {
        var location = new Location(1, 1);
        var velocity = new Velocity(5, 5);
        var fuelCount = new FuelCount(100);
        var fuelEfficiency = new FuelEfficiency(1);
        this.spaceship = new Spaceship(location, velocity, fuelCount, fuelEfficiency);
    }

    @ParameterizedTest
    @ValueSource(ints = {40, 1, 99, 100})
    void checkFuelCommandPositiveTest(int percent) {
        spaceship.setVelocity(new Velocity(1, 1));
        spaceship.setFuelCount(new FuelCount(percent));

        assertDoesNotThrow(() -> new CheckFuelCommand(spaceship).execute());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void checkFuelCommandNegativeTest(int percent) {
        assertThrows(IllegalArgumentException.class, () -> new FuelCount(percent));
    }

    @Test
    void checkFuelCommandLowCountTest() {
        spaceship.setFuelCount(new FuelCount(0));
        assertThrows(LowFuelException.class, () -> new CheckFuelCommand(spaceship).execute());
    }

    @Test
    void burnFuelCommandPositiveTest() {
        spaceship.setFuelEfficiency(new FuelEfficiency(2));
        assertEquals(spaceship.getFuelCount().percent(), 100);
        assertEquals(calculateDistanceByVelocity(spaceship.getVelocity()).length(), 7);

        new BurnFuelCommand(spaceship).execute();

        assertEquals(spaceship.getFuelCount().percent(), 86);
    }

    @Test
    void burnFuelCommandNegativeTest() {
        spaceship.setFuelCount(new FuelCount(6));
        assertThrows(BurnFuelException.class, () -> new BurnFuelCommand(spaceship).execute());
    }

    @Test
    void moveWithBurnFuelMacroCommandSuccessfulTest() {

        Queue<ICommand> commandQueue = new LinkedList<>();
        commandQueue.add(new CheckFuelCommand(spaceship));
        commandQueue.add(new MoveCommand(spaceship));
        commandQueue.add(new BurnFuelCommand(spaceship));

        new MacroCommand(commandQueue).execute();

        assertEquals(new Location(6, 6), spaceship.getLocation());
        assertEquals(93, spaceship.getFuelCount().percent());
        assertEquals(new Velocity(5, 5), spaceship.getVelocity());
    }

    @Test
    void moveWithBurnFuelThrowsCheckFuelExceptionTest() {
        spaceship.setFuelCount(new FuelCount(6));

        Queue<ICommand> commandQueue = new LinkedList<>();
        commandQueue.add(new CheckFuelCommand(spaceship));
        commandQueue.add(new MoveCommand(spaceship));
        commandQueue.add(new BurnFuelCommand(spaceship));

        assertThrows(MacroCommandException.class, () -> new MacroCommand(commandQueue).execute());
        assertTrue(isLogContains("Command CheckFuelCommand has been thrown an exception"));
    }

    @Test
    void moveWithBurnFuelThrowsMoveExceptionTest() {
        spaceship.setVelocity(new Velocity(0, 0));

        Queue<ICommand> commandQueue = new LinkedList<>();
        commandQueue.add(new CheckFuelCommand(spaceship));
        commandQueue.add(new MoveCommand(spaceship));
        commandQueue.add(new BurnFuelCommand(spaceship));

        assertThrows(MacroCommandException.class, () -> new MacroCommand(commandQueue).execute());
        assertTrue(isLogContains("Command MoveCommand has been thrown an exception"));
    }

    @Test
    void moveWithBurnFuelThrowsBurnFuelExceptionTest() {
        spaceship.setVelocity(new Velocity(0, 0));

        Queue<ICommand> commandQueue = new LinkedList<>();
        commandQueue.add(new CheckFuelCommand(spaceship));
        commandQueue.add(new BurnFuelCommand(spaceship));
        commandQueue.add(new MoveCommand(spaceship));

        assertThrows(MacroCommandException.class, () -> new MacroCommand(commandQueue).execute());
        assertTrue(isLogContains("Command BurnFuelCommand has been thrown an exception"));
    }


    @ParameterizedTest
    @ValueSource(ints = {45, 0, -45, 360})
    void changeVelocityCommandForMovingObjectTest(int angle) {
        assertEquals(45, spaceship.getAngle().angleDegrees());

        new ChangeVelocityCommand(spaceship, new Angle(angle))
                .execute();
        assertEquals(45 + angle,
                spaceship.getAngle().angleDegrees());

    }

    @Test
    void changeVelocityCommandForStaticObjectTest() {


    }


    @Test
    void rotateAndChangeVelocityMacroCommandTest() {

    }


//    // Базовые интерфейсы
//    interface Command {
//        void execute();
//    }
//
//    interface Callback {
//        void handleResult(String result);
//    }
//
//    // Команда с поддержкой callback
//    class CommandWithCallback implements Command {
//        private final Command command;
//        private final Callback callback;
//
//        public CommandWithCallback(Command command, Callback callback) {
//            this.command = command;
//            this.callback = callback;
//        }
//
//        @Override
//        public void execute() {
//            String result = command.execute();
//            callback.handleResult(result);
//        }
//    }
//
//    // Конкретная команда
//    class ConcreteCommand implements Command {
//        @Override
//        public String execute() {
//            // Выполняем действие
//            System.out.println("Выполнение команды...");
//            return "Результат выполнения";
//        }
//    }
}
