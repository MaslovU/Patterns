package singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger logger;
    protected SimpleDateFormat formatter;
    protected Date date;

    private Logger() {
    }

    public void log(String msg) {
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = new Date(System.currentTimeMillis());
        System.out.println("[" + formatter.format(date) + " " + num++ + "] " + msg);
    }

    public static synchronized Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}
