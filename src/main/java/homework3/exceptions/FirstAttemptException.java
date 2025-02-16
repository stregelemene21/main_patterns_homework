package homework3.exceptions;

import homework3.command.ICommand;

public class FirstAttemptException extends RuntimeException {

    private static final String MESSAGE = "Cannot execute command %s after 1 attempt, write message to log";

    public FirstAttemptException(Class<? extends ICommand>  command) {
        super(String.format(MESSAGE, command.getSimpleName()));
    }
}
