package homework3.command;

import homework3.exceptions.TestingLogCommandException;

public class TestingLogCommand implements ICommand {

    @Override
    public void execute() {
        throw new TestingLogCommandException();
    }
}
