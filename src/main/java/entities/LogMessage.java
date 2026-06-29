package entities;

import enums.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {

    private LogLevel level;
    private String message;
    private LocalDateTime timestamp;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String format() {
        return "[" + level + "] [" + timestamp + "] " + message;
    }
}
