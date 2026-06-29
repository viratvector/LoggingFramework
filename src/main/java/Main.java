//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import appender.ConsoleAppender;
import appender.DatabaseAppender;
import enums.LogLevel;

class Main {
    public static void main() {
        Logger logger = new Logger();
        logger.addAppender(new ConsoleAppender());
        logger.addAppender(new DatabaseAppender());

        logger.debug("Hello Debug World!");
        logger.warn("Hello Warn World!");
        logger.error("Hello Error World!");
        logger.fatal("Hello Fatal World!");

        logger.setThreshold(LogLevel.WARN);
        logger.warn("This is a warn log!");
        logger.error("This is an error log!");
        logger.fatal("This is a fatal log!");
        logger.debug("This is a debug log!");
    }
}
