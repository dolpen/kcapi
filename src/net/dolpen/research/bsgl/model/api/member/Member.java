package net.dolpen.research.bsgl.model.api.member;

import com.google.gson.JsonParser;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.api.Common;

/**
 * ユーザーデータ
 */
public class Member extends Common {

    protected static String loadPortCache(String elementName) {
        String master = Cache.load("/inputs/member/port.txt");
        return new JsonParser().parse(master).getAsJsonObject()
                .getAsJsonObject("api_data")
                .getAsJsonArray(elementName)
                .toString();
    }
}
