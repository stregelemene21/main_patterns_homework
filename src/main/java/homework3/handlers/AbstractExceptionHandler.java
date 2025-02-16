package homework3.handlers;

import homework3.CommandQueue;
import homework3.command.ICommand;

public abstract class AbstractExceptionHandler implements ICommand{

    public void secondExecute(ICommand command) {
        command.execute();
    }

//    public void addToQueueWriteToLogCommand(ICommand command) {
//        CommandQueue.getInstance().addCommand(command);
//    }
//
//    public void addToQueueWriteToLogCommandRepeater(ICommand command) {
//        CommandQueue.getInstance().addCommand(command);
//    }

    protected void addToCommandQueue(ICommand command) {
        CommandQueue.getInstance().addCommand(command);

    }
}
