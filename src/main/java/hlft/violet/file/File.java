package hlft.violet.file;

public class File extends java.io.File implements FileInterface {
    public File(String pathname) {
        super(pathname);
    }

    @Override
    public File getNoumenon() {
        return this;
    }
}
