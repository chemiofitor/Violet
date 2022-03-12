package hlft.violet.file;

import com.sun.istack.internal.NotNull;


public interface FileInterface {
    @NotNull
    File getNoumenon();

    default String getIPath() {
        return getNoumenon().getPath();
    }

    default File getIParent() {
        String var1 = getNoumenon().getParentFile().getPath();
        String var2 = var1.replace("!", "").replace("file:\\", "");
        return new hlft.violet.file.File(var2);
    }
}
