package appender;
import entities.LogMessage;

public interface LogAppender {
    void appender(LogMessage logMessage);
}
