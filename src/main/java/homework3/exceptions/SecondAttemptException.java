package homework3.exceptions;

import homework3.command.ICommand;

public class SecondAttemptException extends RuntimeException {

    private static final String MESSAGE = "Cannot execute command %s after 2 attempts, write message to log";

    public SecondAttemptException(Class<? extends ICommand>  command) {
        super(String.format(MESSAGE, command.getSimpleName()));
    }
}
