package homework3;

import homework3.command.ICommand;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class Logger {

    private static final String MESSAGE = "An exception '{}' has been thrown while execution command '{}'" +
            "\nMESSAGE: {}";

    public static void logException(Class<? extends ICommand> command, Exception e) {
        log.info(MESSAGE, e.getClass().getSimpleName(), command.getSimpleName(), e.getMessage());
    }

    public static boolean isLogContains(String message) {
        // TODO реализовать

        return true;
    }

    public static void deleteLogFile() {
        var logFile = new File("src/main/resources/test.log");
        if (logFile.exists()) {
            logFile.delete();
        }
    }
}
