package homework3.handlers;

import homework3.command.ICommand;
import homework3.command.LogCommand;
import homework3.exceptions.FirstAttemptException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddToQueueLogCommandHandler extends AbstractHandler {

    ICommand command;

    @Override
    public void execute() {
        writeMessageToLog(command.getClass(), new FirstAttemptException(command.getClass()));
    }
}
