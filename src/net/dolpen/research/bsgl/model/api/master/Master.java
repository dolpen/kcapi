package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.JsonParser;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.api.Common;

/**
 * マスタデータの親オブジェクト
 */
public class Master extends Common {

    protected static String loadMasterCache(String elementName) {
        String master = Cache.load("/inputs/master/start2_master.txt");
        return new JsonParser().parse(master).getAsJsonObject()
            .getAsJsonObject("api_data")
            .getAsJsonArray(elementName)
            .toString();
    }
}
