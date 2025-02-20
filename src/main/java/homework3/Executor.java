package homework3;

import homework3.command.ICommand;
import homework3.handlers.HandlerManager;
import homework3.store.HandlerStore;
import lombok.AllArgsConstructor;

import static homework3.CommandQueue.getCommandQueue;

@AllArgsConstructor
public class Executor implements ICommand{

     HandlerStore handlerStore;

    @Override
    public void execute() {
        var queue = getCommandQueue();
        while (!queue.isEmpty()) {
            var command = queue.getCommandFromQueue();
            try {
                command.execute();
            } catch (Exception e) {
                HandlerManager.getHandler(command, e, handlerStore).execute();
            }
        }
    }
}
