package homework3.handlers;

import homework3.command.TestingLogCommand;
import homework3.command.LogCommand;
import homework3.exceptions.TestingLogCommandException;

public class TestingLogCommandExceptionHandler extends AbstractExceptionHandler {

    public void execute() {
        new LogCommand(TestingLogCommand.class, new TestingLogCommandException()).execute();
    }
}
