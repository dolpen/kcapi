package net.dolpen.research.bsgl.batch;

import com.google.gson.*;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.util.Const;

import java.io.File;
import java.util.*;

/**
 * Format Large Json (ex. master/api_start2)
 */
public class JsonFormatter {

    static final String dirName = "/inputs";

    public static void main(String... args) throws Exception {
        List<String> names = getNames(Const.ROOT, dirName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        for (String name : names) {
            String data = Cache.load(name);
            JsonElement je = jp.parse(data);
            Cache.save(name, gson.toJson(je));
        }
    }

    public static List<String> getNames(String prefix, String path) {
        List<String> ret = new ArrayList<String>();
        File f = new File(prefix + path);
        if (!f.exists()) return ret;
        if (f.isFile()) {
            ret.add(path);
        } else if (f.isDirectory()) {
            for (String s : f.list()) {
                ret.addAll(getNames(prefix, path + "/" + s));
            }
        }
        return ret;
    }
}
