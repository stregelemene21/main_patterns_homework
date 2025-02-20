package homework3;

import homework3.command.*;
import homework3.exceptions.*;
import homework3.handlers.*;
import homework3.store.HandlerStore;
import org.junit.jupiter.api.*;

import static homework3.Logger.deleteLogFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Homework3")
public class HandlerTest {

    HandlerStore handlerStore;
    Executor executor;
    CommandQueue commandQueue = CommandQueue.getCommandQueue();

    @BeforeEach
    void init() {
        handlerStore = new HandlerStore();
        commandQueue = CommandQueue.getCommandQueue();
        executor = new Executor(handlerStore);
    }

    @AfterEach
    void after() {
        commandQueue.clearQueue();
        deleteLogFile();
    }

    // Реализовать Команду, которая записывает информацию о выброшенном исключении в лог
//    @Test
//    void checkWriteToLogCommandTest() {
//        // тестовая команда, с хендлером, в котором вызывается запись в лог
//        ICommand testingLogCommand = new TestingLogCommand();
//        handlerStore.registerHandler(testingLogCommand, TestingLogCommandException.class, TestingLogCommandExceptionHandler.class);
//        executor.executeCommand(testingLogCommand);
//        assertTrue(Logger.isLogContains(
//                String.format("An exception %s has been thrown while execution " +
//                                "command %s",
//                        TestingLogCommandException.class.getSimpleName(),
//                        TestingLogCommand.class.getSimpleName())));
//    }

    // Реализовать обработчик исключения, который ставит Команду, пишущую в лог в очередь Команд
//    @Test
//    void addToQueueWriteToLogCommandTest() {
//        ICommand writeToLogCommand = new LogCommand();
//        handlerStore.registerHandler(writeToLogCommand, WriteToLogCommandException.class,
//                WriteToLogCommandExceptionHandler.class);
//        commandQueue.addCommand(writeToLogCommand);
//        assertTrue(commandQueue.isCommandPresentInQueue(writeToLogCommand));
//        executor.executeCommand(
//                commandQueue.getCommandFromQueue());
//        //asserts
//        assertTrue(commandQueue.isCommandPresentInQueue(writeToLogCommand));
//    }

    //  С помощью Команд из пункта 4 и пункта 6 реализовать следующую обработку исключений:
    //  при первом выбросе исключения повторить команду, при повторном выбросе исключения
    //  записать информацию в лог.
    @Test
    void firstAttemptRepeatSecondWriteToLogTest() {
    //  init command
        ICommand command = new TestCommand();
        commandQueue.addCommand(command);
    //  add strategy
        handlerStore.registerHandler(command, FirstAttemptException.class,
                RepeatHandler.class);
        handlerStore.registerHandler(RepeatCommand.class, SecondAttemptException.class,
                SecondAttemptHandler.class);
    //  start process
        executor.execute();

        assertTrue(
                Logger.isLogContains("Cannot execute command TestCommand after 2 attempts" +
                        ", write message to log"));
    }

   //    Реализовать стратегию обработки исключения - повторить два раза, потом записать в лог.
   //    Указание: создать новую команду, точно такую же как в пункте 6.
   //    Тип этой команды будет показывать, что Команду не удалось выполнить два раза.
    @Test
    void firstAttemptRepeatSecondAttemptRepeatThirdAttemptWriteToLogTest() {
    //  init command
        ICommand command = new TestCommand();
        commandQueue.addCommand(command);
    //  add strategy
        handlerStore.registerHandler(command, FirstAttemptException.class,
               RepeatHandler.class);
        handlerStore.registerHandler(RepeatCommand.class, SecondAttemptException.class,
                RepeatHandler.class);
        handlerStore.registerHandler(RepeatTwiceCommand.class, ThirdAttemptException.class,
                ThirdAttemptHandler.class);
    //  start process
        executor.execute();

        assertTrue(
                Logger.isLogContains("Cannot execute command TestCommand after 3 attempts," +
                        ", write message to log"));
    }

    // попытка зарегистрировать хендлер для команды и исключения, для которых
    // уже есть хендлер

    // хендлер не найден в сторе, возвращаем дефолтный
}
