package homework3.handlers;

import homework3.CommandQueue;
import homework3.command.RepeatTwiceCommand;
import homework3.store.CommandLog;

public class RepeatTwiceHandler extends AbstractExceptionHandler {

    @Override
    public void execute() {
        RepeatTwiceCommand command =
                new RepeatTwiceCommand(CommandLog.getInstance().getLastExecutedCommand());
        CommandQueue.getInstance().addCommand(command);
    }
}
