package homework3;

import homework3.command.ICommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class Logger {

    private static final String LOG_PATH = "src/main/resources/test.log";

    private static final String MESSAGE = "An exception '{}' has been thrown while execution command '{}'" +
            "\nMESSAGE: {}";

    public static void logException(Class<? extends ICommand> command, Exception e) {
        log.info(MESSAGE, e.getClass().getSimpleName(), command.getSimpleName(), e.getMessage());
    }

    public static boolean isLogContains(String message) {
        return getLogFileData().contains(message);
    }

    private static String getLogFileData() {
        try {
            var inputStream = new FileInputStream(LOG_PATH);
            return IOUtils.toString(inputStream, UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read log file: " + LOG_PATH);
        }
    }
}
