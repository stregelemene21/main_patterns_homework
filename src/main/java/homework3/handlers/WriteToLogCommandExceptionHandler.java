package homework3.handlers;

import homework3.CommandQueue;
import homework3.command.LogCommand;

public class WriteToLogCommandExceptionHandler extends AbstractExceptionHandler {

    public void execute() {
        CommandQueue.getInstance().addCommand(new LogCommand());
    }
}
