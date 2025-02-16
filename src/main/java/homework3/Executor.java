package homework3;

import homework3.command.ICommand;
import homework3.exceptions.ExceptionHandler;
import homework3.store.CommandLog;
import homework3.store.HandlerStore;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Executor {

     HandlerStore handlerStore;

    public void executeCommand(ICommand command) {
        try {
            command.execute();
        } catch (Exception e) {
            // идем в handle, возвращаем найденный для связки команда-исключение хендлер !ИЛИ дефолтный хендлер
            ExceptionHandler.getHandler(command, e, handlerStore).execute();
        }
    }

    public void execute() {
        CommandQueue queue = CommandQueue.getInstance();
        CommandLog commandLog = CommandLog.getInstance();
        while (!queue.isEmpty()) {
            var command = queue.getCommandFromQueue();
            try {
                commandLog.addCommand(command);
                command.execute();
            } catch (Exception e) {
                ExceptionHandler.getHandler(command, e, handlerStore).execute();
            }
        }
    }
}
