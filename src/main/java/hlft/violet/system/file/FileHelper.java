package hlft.violet.system.file;

import com.sun.istack.internal.NotNull;
import hlft.violet.system.resources.Link;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FileHelper {
    public static Scanner guide(@NotNull String path) {
        InputStream is = FileHelper.class.getResourceAsStream("/"+path);
        assert is != null;
        return new Scanner(is);
    }

    public static Scanner guideJson(@NotNull String name) {
        return guide(name + ".json");
    }

    public static File create(@NotNull String path) {
        String var1 = String.valueOf(FileHelper.class.getResource("/"+path));
        String var2 = var1.replace("file:/","");
        return new File(var2);
    }

    public static File linkTemplate(@NotNull Link link) {
        return create("asset/template/"+link.getHead()+"/"+link.getDescribe()+".json");
    }
}
