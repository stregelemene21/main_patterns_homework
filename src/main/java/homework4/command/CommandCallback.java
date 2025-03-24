package homework4.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CommandCallback implements ICommand {

    ICommand command;
//    @Override
//    void execute() {
//        String result = command.execute();
//    }
}
