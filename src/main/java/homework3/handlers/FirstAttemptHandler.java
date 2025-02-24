package homework3.handlers;

import homework3.command.ICommand;
import homework3.exceptions.FirstAttemptException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FirstAttemptHandler extends AbstractHandler {

    ICommand unsuccessfulCommand;

    @Override
    public void execute() {
        writeMessageToLog(unsuccessfulCommand.getClass(),
                new FirstAttemptException(unsuccessfulCommand.getClass()));
    }
}
