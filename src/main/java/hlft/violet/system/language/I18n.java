package hlft.violet.system.language;

import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import hlft.violet.system.file.FileHelper;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class I18n implements Runnable {
    /**
     * 默认语言的path
     */
    private static Map TEXTS;

    /**
     * 实际为reload默认语言
     */
    @Override
    public void run() {
        reload(Locale.getDefault());
    }

    /**
     * 重载其他语言，
     * 这个方法可以看出Scanner相对File的优势。
     * @param locale 需要重载的语言
     */
    public static void reload(Locale locale) {
        Scanner scanner = FileHelper.guideJson("asset/lang/"+toPath(locale));
        StringBuilder s = new StringBuilder();
        while (scanner.hasNextLine()) {
            s.append(scanner.nextLine().replace(" ", ""));
        }
        TEXTS = new Gson().fromJson(s.toString(), Map.class);
    }

    /**
     * @param key MC的语言键的Light版
     * @return key对应的本地化文本
     */
    public static String getText(@NotNull String key) {
        return String.valueOf(TEXTS.get(key));
    }

    /**
     * 简单的小写转换，path用。
     */
    public static String toPath(@NotNull Locale locale) {
        return locale.toString().toLowerCase();
    }
}
