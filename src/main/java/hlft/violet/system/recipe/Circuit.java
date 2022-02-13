package hlft.violet.system.recipe;

import com.google.gson.Gson;
import hlft.violet.system.file.FileHelper;
import hlft.violet.system.resources.Link;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Circuit implements Runnable {
    private static final File LIST = FileHelper.create("asset/template/list.json");
    private static Map GUIDE_MAP;

    public static Set<Link> getTemplatesNames() {
        ArrayList<Link> list = new ArrayList<>();
        GUIDE_MAP.forEach((key, value) -> {
            HashSet<String> strSet = new HashSet<>((ArrayList<String>) value);
            for (String var1: strSet) {
                Link var2 = new Link((String) key, var1);
                list.add(var2);
            }
        });
        return new HashSet<>(list);
    }

    public static Map getGuideMap() {
        return GUIDE_MAP;
    }

    @Override
    public void run() {
        try {
            FileReader reader = new FileReader(LIST);
            char[] byt = new char[1024];
            int len = reader.read(byt);
            String strList = new String(byt, 0 ,len);
            GUIDE_MAP = new Gson().fromJson(strList, Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
