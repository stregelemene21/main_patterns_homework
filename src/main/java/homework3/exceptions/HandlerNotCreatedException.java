package homework3.exceptions;


import homework3.command.ICommand;

public class HandlerNotCreatedException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Cannot create handler instance for %s class!";

    public HandlerNotCreatedException(Class<? extends ICommand> handlerClass) {
        super(String.format(DEFAULT_MESSAGE, handlerClass.getSimpleName()));
    }
}
