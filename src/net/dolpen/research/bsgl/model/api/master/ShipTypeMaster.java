package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * 艦種マスタ
 */
public class ShipTypeMaster extends Master {

    public List<Entry> api_data;

    public static ShipTypeMaster cache() {
        ShipTypeMaster resp = new ShipTypeMaster();
        String cache = loadMasterCache("api_mst_stype");
        resp.api_data = Arrays.asList(new Gson().fromJson(cache, Entry[].class));
        return resp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : api_data) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    public static class Entry {

        public int api_id; // Ship type ID

        public int api_sortno; // Index in menus

        public String api_name; // Name of the class

        public int api_scnt; // ???

        public int api_kcnt; // ???

        public String toString() {
            return String.format("%d %s", api_id, api_name);
        }

    }
}
