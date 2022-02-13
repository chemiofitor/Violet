package hlft.violet.system.recipe;

import com.google.gson.Gson;
import hlft.violet.system.file.FileHelper;
import hlft.violet.system.resources.Link;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Circuit implements Runnable {
    /**
     * 添加的模板的list位置
     */
    private static final File LIST = FileHelper.create("asset/template/list.json");
    private static Map GUIDE_MAP;

    /**
     * @return 所有模板的Link集合
     */
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

    /**
     * 先用{@link FileReader}读取文件内容，
     * 再用{@link Gson}创造Map。
     */
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
