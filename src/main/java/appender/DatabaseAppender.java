package appender;
import entities.LogMessage;

public class DatabaseAppender implements  LogAppender {
    @Override
    public void appender(LogMessage logMessage) {
        System.out.println("DB " + logMessage.format());
    }
}
