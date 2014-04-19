package net.dolpen.research.bsgl.model.master;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 消費アイテムマスタ
 */
public class UseItemMaster extends Common {

    public List<Content> api_data;

    public static class Content {
        public int api_id; // The ID of the item

        public int api_usetype; // The type of the item

        public int api_category; // The category of the item

        public String api_name; // The name of the item

        public List<String> api_description; // Contains (Description, empty string)

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

    public static UseItemMaster cache() {
        String resp = Cache.load("/inputs/master/useitem.txt");
        return new Gson().fromJson(resp, UseItemMaster.class);
    }
}
