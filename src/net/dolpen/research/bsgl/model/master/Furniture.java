package net.dolpen.research.bsgl.model.master;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 家具マスタ
 */
public class Furniture extends Common {
    public List<Content> api_data;

    public static class Content {

        public String api_description;    // Description

        public int api_id; // ID of the item

        public int api_no; // Sort number within its category

        public int api_price; // Price, in furniture coins

        public int api_rarity; // Rarity

        public int api_saleflg; // Is this item sold without a "furniture fairy"?

        public String api_title; // Item Name

        public int api_type; // Type/Category

        public String toString() {
            return String.format("%d %s", api_id, api_title);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : api_data) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Furniture cache() {
        String resp = Cache.load("/inputs/master/furniture.txt");
        return new Gson().fromJson(resp, Furniture.class);
    }

}
