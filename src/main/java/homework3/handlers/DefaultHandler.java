package homework3.handlers;

import homework3.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.lang.System.exit;

@Slf4j
@AllArgsConstructor
public class DefaultHandler implements ICommand {

    ICommand command;

    @Override
    public void execute() {
        log.error("Cannot find handler for command {} I don't know what to do", command.getClass().getSimpleName());
        exit(0);
    }
}
