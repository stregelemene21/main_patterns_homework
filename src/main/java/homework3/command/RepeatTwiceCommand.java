package homework3.command;

import homework3.exceptions.FirstAttemptException;
import homework3.exceptions.SecondAttemptException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RepeatTwiceCommand implements ICommand {

    @Getter
    private ICommand baseCommand; // SimpleCommand - первый повтор, RepeatTwiceCommand - второй повтор

    @Override
    public void execute() {
        if (baseCommand.getClass() == this.getClass()) {
            throw new SecondAttemptException(baseCommand.getClass());
        } else {
            throw new FirstAttemptException();
        }
    }
}
