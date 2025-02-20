package homework3.handlers;

import homework3.command.ICommand;
import homework3.command.RepeatCommand;
import homework3.exceptions.SecondAttemptException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecondAttemptHandler extends AbstractHandler {

    ICommand repeatedTwiceCommand;

    @Override
    public void execute() {
        var baseCommandClass = ((RepeatCommand) repeatedTwiceCommand).getBaseCommand().getClass();
        writeToLog(baseCommandClass, new SecondAttemptException(baseCommandClass));
    }
}
