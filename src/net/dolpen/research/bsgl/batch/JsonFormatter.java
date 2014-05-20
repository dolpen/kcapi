package net.dolpen.research.bsgl.batch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.dolpen.research.bsgl.api.Cache;

/**
 * Format Large Json (ex. master/api_start2)
 */
public class JsonFormatter {
    public static void main(String... args) throws Exception {
        final String path = "/inputs/master/start2_master.txt";
        String master = Cache.load(path);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(master);
        Cache.save(path, gson.toJson(je));
    }
}
