package homework3.command;

import homework3.exceptions.FirstAttemptException;

public class TestCommand implements ICommand {

    @Override
    public void execute() {
        throw new FirstAttemptException();
    }
}
