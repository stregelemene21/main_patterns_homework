package homework3.command;

import homework3.exceptions.SecondAttemptException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RepeatCommand implements ICommand {

    @Getter
    private ICommand baseCommand;

    @Override
    public void execute() {
        throw new SecondAttemptException(baseCommand.getClass());
    }
}
