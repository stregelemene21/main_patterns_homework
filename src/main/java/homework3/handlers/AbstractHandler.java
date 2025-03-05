package homework3.handlers;

import homework3.command.ICommand;
import homework3.command.LogCommand;
import homework3.command.RepeatCommand;
import homework3.command.RepeatTwiceCommand;

import static homework3.CommandQueue.getCommandQueue;

public abstract class AbstractHandler implements ICommand {

    ICommand baseCommand;

    protected void addNextCommandToCommandQueue(ICommand command) {
        getCommandQueue().addCommand(command);
    }

    public void repeatCommand() {
        addNextCommandToCommandQueue(
                baseCommand.getClass().equals(RepeatCommand.class) ?
                        new RepeatTwiceCommand(baseCommand) : new RepeatCommand(baseCommand));
    }

    public void writeMessageToLog(Class<? extends ICommand> command, Exception e) {
        addNextCommandToCommandQueue(new LogCommand(command, e));
    }
}
