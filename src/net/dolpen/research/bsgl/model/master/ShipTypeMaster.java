package net.dolpen.research.bsgl.model.master;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 艦種マスタ
 */
public class ShipTypeMaster extends Common {

    public List<Content> api_data;

    public static class Content {

        public int api_id; // Ship type ID

        public int api_sortno; // Index in menus

        public String api_name; // Name of the class

        public int api_scnt; // ???

        public int api_kcnt; // ???

        public String toString() {
            return String.format("%d %s", api_id, api_name);
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : api_data) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }

    public static ShipTypeMaster cache() {
        String resp = Cache.load("/inputs/master/stype.txt");
        return new Gson().fromJson(resp, ShipTypeMaster.class);
    }
}
