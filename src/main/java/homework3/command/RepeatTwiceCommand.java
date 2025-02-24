package homework3.command;

import homework3.exceptions.ThirdAttemptException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RepeatTwiceCommand implements ICommand {

    @Getter
    private ICommand baseCommand;

    @Override
    public void execute() {
        throw new ThirdAttemptException(baseCommand.getClass());
    }
}
