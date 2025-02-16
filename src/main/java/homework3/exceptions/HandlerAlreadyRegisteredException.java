package homework3.exceptions;

import homework3.command.ICommand;

import static java.lang.String.format;

public class HandlerAlreadyRegisteredException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Handler for command %s and exception %s has already been registered!";

    public HandlerAlreadyRegisteredException(Class<? extends ICommand> command, Class<? extends Exception> e) {
        super(format(DEFAULT_MESSAGE, command.getSimpleName(), e.getSimpleName()));
    }
}
