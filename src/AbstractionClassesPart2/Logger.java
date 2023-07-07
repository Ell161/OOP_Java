package AbstractionClassesPart2;

import java.util.Date;

public class Logger {
    public enum Level {
        INFO, ERROR
    }

    private Level level = Level.INFO;

    public Logger(Level level) {
        this.level = level;
    }

    public Logger() {
    }

    public void logging(String message, Exception exception) {
        Date date = new Date();
        if (level == Level.INFO) {
            if (exception != null) System.out.println(date + " | " + message + " | " + exception);
            else System.out.println(date + " | " + message);
        } else if (level == Level.ERROR && exception != null) {
            System.out.println(date + " | " + message + " | " + exception);
        }
    }
}
