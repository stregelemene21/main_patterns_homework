package homework4.exception;

import homework4.command.ICommand;

public class MacroCommandException extends RuntimeException {

    private static final String MESSAGE = "Command %s in macroCommand has been thrown an exception: \n%s";

    public MacroCommandException(ICommand command, String message) {
        super(String.format(MESSAGE, command.getClass().getSimpleName(), message));
    }
}
