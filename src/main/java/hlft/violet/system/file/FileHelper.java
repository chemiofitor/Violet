package hlft.violet.system.file;

import com.sun.istack.internal.NotNull;
import hlft.violet.system.language.I18n;
import hlft.violet.system.resources.Link;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FileHelper {
    /**
     * 实例：{@link I18n#run()}
     * @param path Resources目录下的相对地址
     * @return Path导向的文件的内容Scanner
     */
    public static Scanner guide(@NotNull String path) {
        InputStream is = FileHelper.class.getResourceAsStream("/"+path);
        assert is != null;
        return new Scanner(is);
    }

    /**
     * 功能同{@link FileHelper#guide(String path)}，但是默认后缀".json"。
     * @param name Resources目录下的相对地址（无需后缀名）
     * @return Path导向的文件的内容Scanner
     */
    public static Scanner guideJson(@NotNull String name) {
        return guide(name + ".json");
    }

    /**
     * 简易的使用{@link java.io.File}类
     * @param path Resources目录下的相对地址
     * @return Path导向的文件
     */
    public static File create(@NotNull String path) {
        String var1 = String.valueOf(FileHelper.class.getResource("/"+path));
        String var2 = var1.replace("file:/","");
        return new File(var2);
    }

    /**
     * @param link 详细查看 {@link hlft.violet.system.resources.Link}类
     * @return 获取Link的文件（略似MC的RL）
     */
    public static File linkTemplate(@NotNull Link link) {
        return create("asset/template/"+link.getHead()+"/"+link.getDescribe()+".json");
    }
}
