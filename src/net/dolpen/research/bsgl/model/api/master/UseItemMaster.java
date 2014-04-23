package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * 消費アイテムマスタ
 */
public class UseItemMaster extends Master {

    public List<Entry> api_data;

    public static UseItemMaster cache() {
        UseItemMaster resp = new UseItemMaster();
        String cache = loadMasterCache("api_mst_useitem");
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
        public int api_id; // The ID of the item

        public int api_usetype; // The type of the item

        public int api_category; // The category of the item

        public String api_name; // The name of the item

        public List<String> api_description; // Contains (Description, empty string)

        public String toString() {
            return String.format("%d %s", api_id, api_name);
        }
    }
}
