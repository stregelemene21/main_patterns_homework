package homework3.store;

import homework3.exceptions.HandlerNotCreatedException;
import homework3.exceptions.HandlerNotFoundException;
import homework3.handlers.DefaultHandler;
import homework3.store.HandlerStore;
import homework3.command.ICommand;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class HandlerManager {

    public static ICommand getHandler(ICommand command, Exception e, HandlerStore store) {
        return createHandlerInstance(command, e, store);
    }

    private static ICommand createHandlerInstance(ICommand command, Exception e, HandlerStore store) {
        var handlerClass = getHandlerClass(command, e, store);
        try {
            return (ICommand) Class.forName(handlerClass.getName())
                    .getConstructor(ICommand.class).newInstance(command);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException ex) {
            throw new HandlerNotCreatedException(handlerClass);
        }
    }

    private static Class<? extends ICommand> getHandlerClass(ICommand command, Exception e, HandlerStore store) {
        try {
            return store.getHandler(command, e);
        } catch (HandlerNotFoundException ex) {
            log.error(ex.getMessage());
            return DefaultHandler.class;
        }
    }
}