package homework3.exceptions;

import homework3.handlers.AbstractExceptionHandler;
import homework3.store.HandlerStore;
import homework3.command.ICommand;
import homework3.Logger;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class ExceptionHandler {

    public static ICommand getHandler(ICommand command, Exception e, HandlerStore store) {
//        Logger.logException(command.getClass(), e);
        return findHandler(command, e, store);
    }

    //TODO add DEFAULT handler

    private static <T> ICommand findHandler(ICommand command, Exception e, HandlerStore store) {
        var handlerClass = getHandlerClass(command, e, store);
        try {
            return (ICommand) Class.forName(handlerClass.getName())
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException ex) {
            throw new HandlerNotCreatedException(handlerClass);
        }
    }

    private static Class<? extends AbstractExceptionHandler> getHandlerClass(ICommand command, Exception e, HandlerStore store) {
        try {
            return store.getHandler(command, e);
        } catch (HandlerNotFoundException ex) {
            System.out.println("mock");
            return null;
            //return new DefaultHandler.class;
        }
    }
}