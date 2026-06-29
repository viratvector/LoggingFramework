package appender;

import entities.LogMessage;

public class ConsoleAppender implements LogAppender {

    @Override
    public void appender(LogMessage logMessage) {
        System.out.println(logMessage.format());
    }
}
