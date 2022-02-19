package hlft.violet.file;

import java.io.File;

public class FileCasket {

    public FileCasket(String path) {
        create(path);
    }

    public void create(String path) {
        File file = FileHelper.guide(path);
        if(!file.exists()){
            file.mkdir();
        }
    }
}