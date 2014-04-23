package net.dolpen.research.bsgl.model.api.member;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.api.Common;

import java.util.Arrays;
import java.util.List;

/**
 * 消費/課金アイテム所持状況
 */
public class InventoryUseItem extends Common {

    public List<Content> api_data;

    public static class Content {

        public int api_member_id; // ID of the admiral who owns the item
        public int api_id; // ID of the item
        public int api_value; // Value of the item, in fcoins
        public int api_usetype; // The type of the item
        public int api_category; // The category of the item
        public String api_name; // Name of the item
        public List<String> api_description; // Description of the item followed by an empty string (WHY)
        public int api_price; // Price of the item?
        public int api_count; // How many of them you have

        public String toString() {
            return String.format("%d %s x%d %s", api_id, api_name, api_count, Arrays.deepToString(api_description.toArray()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : api_data) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }

    public static InventoryUseItem cache() {
        String resp = Cache.load("/inputs/member/useitem.txt");
        return new Gson().fromJson(resp, InventoryUseItem.class);
    }
}
