package homework3.command;

import homework3.Logger;

public class LogCommand implements ICommand {

    Class<? extends ICommand> command;
    Exception exception;

    public LogCommand(Class<? extends ICommand> command, Exception e) {
        this.command = command;
        this.exception = e;
    }

    @Override
    public void execute() {
        Logger.logException(command, exception);
    }
}
