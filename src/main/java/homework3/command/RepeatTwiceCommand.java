package homework3.command;

import homework3.exceptions.ThirdAttemptException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RepeatTwiceCommand implements ICommand {

    @Getter
    private ICommand baseCommand;

//    @Override
//    public void execute() {
//        if (baseCommand.getClass() == this.getClass()) {
//            throw new SecondAttemptException(baseCommand.getClass());
//        } else {
//            throw new FirstAttemptException(baseCommand.getClass());
//        }
//    }

    @Override
    public void execute() {
        throw new ThirdAttemptException(baseCommand.getClass());
    }
}
