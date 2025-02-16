package homework3.command;

import homework3.exceptions.FirstAttemptException;

public class SimpleCommand implements ICommand {

    @Override
    public void execute() {
            throw new FirstAttemptException();
    }
}
