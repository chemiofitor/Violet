package hlft.violet;

import hlft.violet.system.ThreadCore;
import hlft.violet.system.language.I18n;
import hlft.violet.system.recipe.Circuit;

public class Main {
    public static final ThreadCore THREAD_POOL = new ThreadCore();

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        new I18n().run();
        new Circuit().run();
    }
}

