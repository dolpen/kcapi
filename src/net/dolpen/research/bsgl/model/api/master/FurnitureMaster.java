package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * 家具マスタ
 */
public class FurnitureMaster extends Master {

    public List<Entry> api_data;

    public static FurnitureMaster cache() {
        FurnitureMaster resp = new FurnitureMaster();
        String cache = loadMasterCache("api_mst_furniture");
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

}
