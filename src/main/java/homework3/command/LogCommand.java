package homework3.command;

import homework3.Logger;

public class LogCommand implements ICommand {

    Class<? extends ICommand> command;
    Exception exception;

    public LogCommand() {
        this.command = this.getClass();
    }

    public LogCommand(Class<? extends ICommand> command, Exception e) {
        this.command = command;
        this.exception = e;
    }

    @Override
    public void execute() {
        System.out.println("Пишу в лог");
        Logger.logException(command, exception);
        //throw new WriteToLogCommandException();
    }
}
