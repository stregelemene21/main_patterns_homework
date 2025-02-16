package homework3.store;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import homework3.command.ICommand;
import homework3.exceptions.HandlerAlreadyRegisteredException;
import homework3.exceptions.HandlerNotFoundException;
import homework3.handlers.AbstractExceptionHandler;

public class HandlerStore {
//    Table<Class<? extends ICommand>, Class<? extends Exception>, Class<? extends AbstractExceptionHandler>> store
//            = HashBasedTable.create();

    Table<Class<? extends ICommand>, Class<? extends Exception>, Class<? extends AbstractExceptionHandler>> store
            = HashBasedTable.create();

    public void registerHandler(ICommand command, Class<? extends Exception> e, Class<? extends AbstractExceptionHandler> handler) {
        var commandClass = command.getClass();
        if (!store.contains(commandClass, e)) {
            store.put(commandClass, e, handler);
        } else {
            throw new HandlerAlreadyRegisteredException(commandClass, e);
        }
    }

    public void registerHandler(Class <? extends ICommand> command, Class<? extends Exception> e,
                                Class<? extends AbstractExceptionHandler> handler) {
        if (!store.contains(command, e)) {
            store.put(command, e, handler);
        } else {
            throw new HandlerAlreadyRegisteredException(command, e);
        }
    }

    public Class<? extends AbstractExceptionHandler> getHandler(ICommand command, Exception e) throws HandlerNotFoundException {
        var foundHandler = store.get(command.getClass(), e.getClass());
        if (foundHandler != null) {
            return foundHandler;
        } else {
            throw new HandlerNotFoundException(command, e);
        }
    }
}
