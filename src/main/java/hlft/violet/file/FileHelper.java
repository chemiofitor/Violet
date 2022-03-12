package hlft.violet.file;

import com.sun.istack.internal.NotNull;

import java.util.Objects;

public class FileHelper {
    /**
     * 简易的使用{@link java.io.File}类，其目标必须存在。
     * @param path Resources目录下的相对地址
     * @return Path导向的文件
     */
    public static File guide(@NotNull String path) {
        return new File(Objects.requireNonNull(FileHelper.class.getResource("/" + path)).getFile());
    }

    public static hlft.violet.file.File subGuide(@NotNull FileInterface file, String sub) {
        return new File(file.getIPath()+"/"+sub);
    }
}
