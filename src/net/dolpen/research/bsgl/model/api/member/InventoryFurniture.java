package net.dolpen.research.bsgl.model.api.member;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.api.Common;

import java.util.List;

/**
 * 所持家具一覧
 */
public class InventoryFurniture extends Common {

    // 船一覧
    public List<Content> api_data;

    public static class Content {
        public int api_member_id; // ID of the admiral who owns it
        public int api_id; // Local ID of the item (equal to api_furniture_id)
        public int api_furniture_type; // Type/Category
        public int api_furniture_no; // Number within that category
        public int api_furniture_id; // ID of the actual item

        public String toString() {
            return String.format("%d", api_id);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : api_data) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }

    public static InventoryFurniture cache() {
        String resp = Cache.load("/inputs/member/furniture.txt");
        return new Gson().fromJson(resp, InventoryFurniture.class);
    }

}
