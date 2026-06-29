# Logging Framework - Low Level Design

A lightweight logging framework implemented in Java, inspired by SLF4J/Logback. Supports multiple log levels, pluggable appenders, runtime configuration, and level-based filtering.

## Design Patterns Used

| Pattern | Where | Purpose |
|---------|--------|---------|
| **Singleton** | `Logger` | Single logger instance with shared config across the application |
| **Strategy** | `LogAppender` → Console / File / Database | Swap output destination without changing logger logic |
| **Chain of Responsibility (lite)** | Threshold filter in `Logger` | Block logs below configured level before they reach appenders |


## Core Features

### Logging
- Five log levels: `DEBUG`, `INFO`, `WARN`, `ERROR`, `FATAL`
- Level-specific methods: `debug()`, `info()`, `warn()`, `error()`, `fatal()`
- Configurable minimum threshold — logs below threshold are ignored
- Consistent format: `[LEVEL] [timestamp] message`

### Appenders
- **ConsoleAppender** — prints to console
- **FileAppender** — appends to a file (append mode)
- **DatabaseAppender** — simulated DB output (MVP)
- Multiple appenders can be registered on the same logger (fan-out)

### Runtime Configuration
- `setLogLevel(LogLevel)` — change threshold at runtime
- `addAppender(LogAppender)` — register a new destination
- `removeAppender(LogAppender)` — remove a destination

## Sample Usage

Logger logger = Logger.getInstance();

logger.addAppender(new ConsoleAppender());
logger.addAppender(new FileAppender("app.log"));

logger.setLogLevel(LogLevel.INFO);

logger.debug("Debug - ignored");     // below INFO
logger.info("Info - logged");
logger.warn("Warn - logged");
logger.error("Error - logged");

logger.setLogLevel(LogLevel.WARN);
logger.info("Ignored after threshold change");
logger.warn("Still logged");

## Sample Output

[INFO] [2026-06-12T14:30:00] Info - logged
[WARN] [2026-06-12T14:30:00] Warn - logged
[ERROR] [2026-06-12T14:30:00] Error - logged
[WARN] [2026-06-12T14:30:01] Still logged
