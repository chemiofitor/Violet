package hlft.violet.file;

import com.sun.istack.internal.Nullable;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 可以看作是文件夹的实现
 */
public class FileCasket implements FileInterface {
    /**
     * 本体文件
     */
    private final File Noumenon;

    /**
     * @param path 应为文件夹的名称
     */
    private FileCasket(String path) {
        this.Noumenon = FileHelper.guide(path);
    }

    /**
     * @param file 不应为文件
     */
    private FileCasket(File file) {
        this.Noumenon = file;
    }

    public static FileCasket create(FileDatum datum, String name) {
        File file = new FileCasket(FileHelper.subGuide(datum.getIParent().getIParent(),name)).getNoumenon();
        if (!file.exists()) {
            file.mkdir();
        }
        return new FileCasket(file);
    }
    public hlft.violet.file.File getNoumenon() {
        return Noumenon;
    }

    /**
     * 获取FileCasket下所有文件
     */
    @Nullable
    public Set<File> hyponymFiles() {
        HashSet<File> set = new HashSet<>();
        File[] files = (File[]) getNoumenon().listFiles();
        if (files == null) {
            return null;
        }
        for(File file: files){
            if(file.isFile()) {
                set.add(file);
            }
        }
        return set;
    }

    /**
     * 获取FileCasket下所有文件夹
     */
    @Nullable
    public Set<FileCasket> hyponymCaskets() {
        HashSet<FileCasket> set = new HashSet<>();
        File[] files = (File[]) getNoumenon().listFiles();
        if (files == null) {
            return null;
        }
        for(File file: files){
            set.add(new FileCasket(file));
        }
        return set;
    }

    @Override
    public String toString() {
        return Noumenon.toString();
    }

    /**
     * <p>在Casket下创建一个不存在的文件，
     * <br/>如果存在则不创建。</p>
     * @param name 将创建的文件的名称
     * @param suffix 将创建的文件的后缀
     * @return 返回创建的文件
     */
    public File createSubFile(String name, String suffix) {
        File file = FileHelper.subGuide(getNoumenon(),name+"."+suffix);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * <p>在Casket下创建一个不存在的文件夹，
     * <br/>如果存在则不创建。</p>
     * @param name 将创建的文件夹的名称
     * @return 返回创建的文件夹
     */
    public FileCasket createSubCasket(String name) {
        FileCasket casket = new FileCasket(FileHelper.subGuide(getNoumenon(), name));
        File file = casket.getNoumenon();
        if (!file.exists()) {
            file.mkdir();
        }
        return casket;
    }
}