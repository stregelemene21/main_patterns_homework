package homework4.command;

import homework4.exception.MacroCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;

@Slf4j
@AllArgsConstructor
public class MacroCommand implements ICommand {

    Queue<ICommand> commands;

    @Override
    public void execute() {
        while (!commands.isEmpty()) {
            ICommand nextCommand;
            nextCommand = commands.poll();
            try {
                nextCommand.execute();
            } catch (Exception e) {
                log.error("Command {} has been thrown an exception", nextCommand.getClass().getSimpleName());
                throw new MacroCommandException(nextCommand, e.getMessage());
            }
        }
    }
}
