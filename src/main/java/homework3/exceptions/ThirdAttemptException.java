package homework3.exceptions;

import homework3.command.ICommand;

public class ThirdAttemptException extends RuntimeException {

    private static final String MESSAGE = "Cannot execute command %s after 3 attempts, write message to log";

    public ThirdAttemptException(Class<? extends ICommand>  command) {
        super(String.format(MESSAGE, command.getSimpleName()));
    }
}
