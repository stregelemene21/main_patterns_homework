package homework3.handlers;

import homework3.CommandQueue;
import homework3.command.RepeatCommand;
import homework3.store.CommandLog;

public class FirstAttemptHandler extends AbstractExceptionHandler {

    @Override
    public void execute() {
        RepeatCommand repeatCommand = new RepeatCommand(
                CommandLog.getInstance().getLastExecutedCommand());
        CommandQueue.getInstance().addCommand(repeatCommand);
    }
}
