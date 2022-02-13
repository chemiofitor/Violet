package hlft.violet.system;

import hlft.violet.system.language.I18n;

import java.util.Locale;
import java.util.concurrent.*;

public class ThreadCore extends ScheduledThreadPoolExecutor {

    /**
     * 默认核心线程：5
     */
    public ThreadCore() {
        super(5);
    }

    /**
     * 重载语言
     */
    public void reloadLanguage(Locale locale) {
        add(() -> I18n.reload(locale));
    }

    /**
     * 向线程池添加的线程的简单包装
     */
    public void add(Runnable runnable) {
        schedule(runnable, 100L, TimeUnit.MILLISECONDS);
    }
}
