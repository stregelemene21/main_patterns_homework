package homework3.handlers;

import homework3.command.ICommand;

public class RepeatHandler extends AbstractHandler {

    public RepeatHandler(ICommand command) {
        baseCommand = command;
    }

    @Override
    public void execute() {
        repeatCommand();
    }
}
