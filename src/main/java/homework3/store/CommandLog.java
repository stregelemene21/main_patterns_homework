package homework3.store;

import homework3.command.ICommand;

import java.util.Stack;

public class CommandLog {

    private static CommandLog instance;

    public CommandLog() {
    }

    public static CommandLog getInstance() {
        if (instance == null) {
            instance = new CommandLog();
        }
        return instance;
    }

    Stack<ICommand> executedCommands = new Stack<>();

    public void addCommand(ICommand command) {
        executedCommands.addElement(command);
    }

    //java.util.EmptyStackException

    public ICommand getLastExecutedCommand() {
        return executedCommands.peek();
    }

}
