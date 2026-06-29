package appender;
import entities.LogMessage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAppender implements LogAppender {

    private final String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void appender(LogMessage logMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(logMessage.format());
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}
