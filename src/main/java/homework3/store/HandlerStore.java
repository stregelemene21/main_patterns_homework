package homework3.store;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import homework3.command.ICommand;
import homework3.exceptions.HandlerAlreadyRegisteredException;
import homework3.exceptions.HandlerNotFoundException;

public class HandlerStore {

    Table<Class<? extends ICommand>, Class<? extends Exception>, Class<? extends ICommand>> store
            = HashBasedTable.create();

    public void registerHandler(ICommand command, Class<? extends Exception> e, Class<? extends ICommand> handler) {
        var commandClass = command.getClass();
        if (!store.contains(commandClass, e)) {
            store.put(commandClass, e, handler);
        } else {
            throw new HandlerAlreadyRegisteredException(commandClass, e);
        }
    }

    public void registerHandler(Class <? extends ICommand> command, Class<? extends Exception> e,
                                Class<? extends ICommand> handler) {
        if (!store.contains(command, e)) {
            store.put(command, e, handler);
        } else {
            throw new HandlerAlreadyRegisteredException(command, e);
        }
    }

    public Class<? extends ICommand> getHandler(ICommand command, Exception e)  {
        var foundHandler = store.get(command.getClass(), e.getClass());
        if (foundHandler != null) {
            return foundHandler;
        } else {
            throw new HandlerNotFoundException(command, e);
        }
    }
}
