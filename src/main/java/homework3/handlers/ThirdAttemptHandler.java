package homework3.handlers;

import homework3.command.ICommand;
import homework3.command.RepeatCommand;
import homework3.command.RepeatTwiceCommand;
import homework3.exceptions.ThirdAttemptException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ThirdAttemptHandler extends AbstractHandler {

    ICommand twiceRepeatedCommand;

    @Override
    public void execute() {
        var baseCommandClass = ((RepeatCommand) (
                (RepeatTwiceCommand) twiceRepeatedCommand).getBaseCommand())
                .getBaseCommand().getClass();
        writeToLog(baseCommandClass, new ThirdAttemptException(baseCommandClass));
    }
}
