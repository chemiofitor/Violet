package hlft.violet.file;

public class FileDatum implements FileInterface {
    private final File Datum;

    public FileDatum(String name) {
        Datum = FileHelper.guide(name+".datum");
    }

    public static FileDatum violet() {
        return new FileDatum("violet");
    }

    @Override
    public File getNoumenon() {
        return Datum;
    }

    @Override
    public String toString() {
        return Datum.toString();
    }
}
