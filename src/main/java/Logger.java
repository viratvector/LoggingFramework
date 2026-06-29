import appender.LogAppender;
import entities.LogMessage;
import enums.LogLevel;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static Logger instance;
    private final List<LogAppender> appenders;
    private LogLevel threshold;

    public Logger() {
        appenders = new ArrayList<>();
        threshold = LogLevel.INFO;
    }

    public static synchronized Logger getInstance(){
        if(instance == null){
            instance =  new Logger();
        }
        return instance;
    }

    public void addAppender(LogAppender appender){
        if(appender == null){
            throw new NullPointerException("appender cannot be null");
        }
        appenders.add(appender);
    }

    public void removeAppender(LogAppender appender){
        appenders.remove(appender);
    }

    public LogLevel getThreshold() {
        return threshold;
    }

    public void setThreshold(LogLevel threshold) {
        this.threshold = threshold;
    }

    private void log(String message, LogLevel level) {
        if(message == null){
            throw new NullPointerException("message cannot be null");
        }
        if(!level.isGreaterOrEqualThan(threshold)){
            return;
        }
        LogMessage logMessage = new LogMessage(level, message);
        for(LogAppender appender : appenders){
            appender.appender(logMessage);
        }
    }

    public void debug(String message) {
        log(message, LogLevel.DEBUG);
    }

    public void info(String message) {
        log(message, LogLevel.INFO);
    }

    public void warn(String message) {
        log(message, LogLevel.WARN);
    }

    public void error(String message) {
        log(message, LogLevel.ERROR);
    }

    public void fatal(String message) {
        log(message, LogLevel.FATAL);
    }
}
