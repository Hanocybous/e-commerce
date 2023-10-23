package com.hanocybous.ecommercesystem.config;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.logging.Logger;

@UtilityClass
@Getter
public class LoggingConfig {

    private static final Logger LOGGER = Logger.getLogger(LoggingConfig.class.getName());
    private static LoggingConfig instance;

    public static void logInfo(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            LOGGER.info(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logInfo method");
    }

    public static void logWarning(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.WARNING)) {
            LOGGER.warning(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logWarning method");
    }

    public static void logSevere(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.SEVERE)) {
            LOGGER.severe(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logSevere method");
    }

    public static void logFine(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.FINE)) {
            LOGGER.fine(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logFine method");
    }

    public static void logFiner(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.FINER)) {
            LOGGER.finer(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logFiner method");
    }

    public static void logFinest(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.FINEST)) {
            LOGGER.finest(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logFinest method");
    }

    public static void logConfig(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.CONFIG)) {
            LOGGER.config(message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logConfig method");
    }

    public static void logAll(String message, Throwable throwable) {
        if (LOGGER.isLoggable(java.util.logging.Level.ALL)) {
            LOGGER.log(java.util.logging.Level.ALL, message, throwable);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logAll method");
    }

    public static void logOff(String message) {
        if (LOGGER.isLoggable(java.util.logging.Level.OFF)) {
            LOGGER.log(java.util.logging.Level.OFF, message);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logOff method");
    }

    public static void logSevere(String message, Throwable throwable) {
        if (LOGGER.isLoggable(java.util.logging.Level.SEVERE)) {
            LOGGER.log(java.util.logging.Level.SEVERE, message, throwable);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logSevere method");
    }

    public static void logWarning(String message, Throwable throwable) {
        if (LOGGER.isLoggable(java.util.logging.Level.WARNING)) {
            LOGGER.log(java.util.logging.Level.WARNING, message, throwable);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logWarning method");
    }

    public static void logInfo(String message, Throwable throwable) {
        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            LOGGER.log(java.util.logging.Level.INFO, message, throwable);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logInfo method");
    }

    public static void logFine(String message, Throwable throwable) {
        if (LOGGER.isLoggable(java.util.logging.Level.FINE)) {
            LOGGER.log(java.util.logging.Level.FINE, message, throwable);
        }
        LOGGER.warning("This is a warning message from LoggingConfig, logFine method");
    }

    @Contract(" -> new")
    public static @NotNull LoggingConfig getInstance() {
        if (instance == null) {
            instance = new LoggingConfig();

        }
        return instance;
    }
}
