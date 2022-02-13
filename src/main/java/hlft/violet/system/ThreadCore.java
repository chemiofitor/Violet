package hlft.violet.system;

import hlft.violet.system.language.I18n;

import java.util.concurrent.*;

public class ThreadCore extends ScheduledThreadPoolExecutor {

    public ThreadCore() {
        super(5);
    }

    public void i18n() {
        schedule(new I18n(), 0, TimeUnit.MILLISECONDS);
    }

    public void add(Runnable runnable) {
        schedule(runnable, 0, TimeUnit.MILLISECONDS);
    }
}
