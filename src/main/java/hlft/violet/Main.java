package hlft.violet;

import hlft.violet.file.File;
import hlft.violet.file.FileCasket;
import hlft.violet.file.FileDatum;

public class Main {
    public static void main(String[] args) {
        FileDatum datum = FileDatum.violet();
        FileCasket casket = FileCasket.create(datum, "test");
        System.out.print(casket);
        File file = casket.createSubFile("test", "json");
        System.out.print(file);
    }
}

