package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * 艦種マスタ
 */
public class ShipTypeMaster extends Master {

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
        ShipTypeMaster resp = new ShipTypeMaster();
        String cache = loadMasterCache("api_mst_stype");
        resp.api_data = Arrays.asList(new Gson().fromJson(cache, Content[].class));
        return resp;
    }
}
