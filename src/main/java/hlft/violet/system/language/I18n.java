package hlft.violet.system.language;

import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import hlft.violet.system.file.FileHelper;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class I18n implements Runnable {
    public static final String LANG_PATH = toPath(Locale.getDefault());
    private static Map TEXTS;

    @Override
    public void run() {
        Scanner scanner = FileHelper.guideJson("asset/lang/"+LANG_PATH);
        StringBuilder s = new StringBuilder();
        while (scanner.hasNextLine()) {
            s.append(scanner.nextLine().replace(" ", ""));
        }
        TEXTS = new Gson().fromJson(s.toString(), Map.class);
    }

    public static String getText(@NotNull String key) {
        return String.valueOf(TEXTS.get(key));
    }

    public static String toPath(@NotNull Locale locale) {
        return locale.toString().toLowerCase();
    }
}
