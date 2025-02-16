package homework3.exceptions;

import homework3.command.ICommand;

import static java.lang.String.format;

public class HandlerNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Handler for command %s and exception %s not found!";

    public HandlerNotFoundException(ICommand command, Exception e) {
        super(format(DEFAULT_MESSAGE, command.toString(), e.getClass().getSimpleName()));
    }
}