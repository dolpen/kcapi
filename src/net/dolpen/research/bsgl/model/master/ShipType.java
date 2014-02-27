package net.dolpen.research.bsgl.model.master;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.api.Request;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 艦船タイプのデータ
 */
public class ShipType extends Common {

    public List<Content> api_data;

    public static class Content {
        public int api_id; // stype
        public int api_sortno;
        public String api_name;
        public int api_scnt;
        public int api_kcnt;
    }

    public static ShipType get() {
        String resp = Request.postJson("/api_get_master/stype", null);
        return new Gson().fromJson(resp, ShipType.class);
    }

    public static ShipType cache() {
        String resp = Cache.load("./kankolle/inputs/master/stype.txt");
        return new Gson().fromJson(resp, ShipType.class);
    }
}
