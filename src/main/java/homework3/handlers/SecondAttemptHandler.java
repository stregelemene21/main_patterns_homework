package homework3.handlers;

import homework3.CommandQueue;
import homework3.command.ICommand;
import homework3.command.LogCommand;
import homework3.command.RepeatCommand;
import homework3.command.RepeatTwiceCommand;
import homework3.exceptions.SecondAttemptException;
import homework3.store.CommandLog;

public class SecondAttemptHandler extends AbstractExceptionHandler {

    @Override
    public void execute() {
        var command = CommandLog.getInstance().getLastExecutedCommand();
        Class<? extends ICommand> repeatedCommand;
        if (command.getClass().equals(RepeatTwiceCommand.class)) {
            repeatedCommand = ((RepeatTwiceCommand) command).getBaseCommand().getClass();

//            Logger.logException(
//                    ((RepeatCommand) command).getBaseCommand().getClass(),
//                    new SecondAttemptRepeatException(repeatedCommand));

            var logCommand = new LogCommand(repeatedCommand,
                    new SecondAttemptException(repeatedCommand));
            CommandQueue.getInstance().addCommand(logCommand);
        }
    }
}
