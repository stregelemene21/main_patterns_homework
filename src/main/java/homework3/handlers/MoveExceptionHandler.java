package homework3.handlers;

import homework3.CommandQueue;
import homework3.command.ICommand;
import lombok.Setter;

public class MoveExceptionHandler extends AbstractExceptionHandler {

    @Setter
    private ICommand executedCommand;

    public void execute() {
        // запись в лог с количеством выполнений

        //если уже выполнялась - вызов другого хендлера ?
            // - постановка в очередь ПОВТОРНОЙ команды
        CommandQueue.getInstance().addCommand(executedCommand);
        // повторное выполнение
        
    }
}
