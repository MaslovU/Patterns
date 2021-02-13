package singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger logger;

    private Logger() {
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());

    public void log(String msg) {
        System.out.println("[" + formatter.format(date) + " " + num++ + "] " + msg);
    }

    public static synchronized Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}
