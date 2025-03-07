package homework3;

import homework3.command.ICommand;

import java.util.LinkedList;
import java.util.Queue;

public class CommandQueue {

    private static CommandQueue instance;

    public CommandQueue() {

    }

    public static CommandQueue getCommandQueue() {
        if (instance == null) {
            synchronized (CommandQueue.class) {
                instance = new CommandQueue();
            }
        }
        return instance;
    }

    private Queue<ICommand> commandQueue = new LinkedList<>();

    public void addCommand(ICommand command) {
        this.commandQueue.add(command);
    }

    public ICommand getCommandFromQueue() {
        return this.commandQueue.poll();
    }

    public boolean isCommandPresentInQueue(ICommand command) {
        return commandQueue.contains(command);
    }

    public void clearQueue() {
        this.commandQueue.clear();
    }

    public boolean isEmpty() {
        return this.commandQueue.isEmpty();
    }
}
