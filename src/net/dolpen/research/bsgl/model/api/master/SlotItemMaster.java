package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 装備マスタ
 */
public class SlotItemMaster extends Master {
    public List<Entry> api_data;

    public static SlotItemMaster cache() {
        SlotItemMaster resp = new SlotItemMaster();
        String cache = loadMasterCache("api_mst_slotitem");
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

    public Map<Integer, Entry> toIdMap() {
        Map<Integer, Entry> idMap = Maps.newHashMap();
        for (Entry e : api_data) {
            idMap.put(e.api_id, e);
        }
        return idMap;
    }

    public static class Entry {

        public int api_atap; // Unused value (Nothing boosts this)

        public int api_bakk; // Unused value (Nothing boosts this)

        public int api_baku; // Unused value

        public List<Integer> api_broken; // ???

        public int api_houg; // Firepower

        public int api_houk; // Unknown　-- 実データを見ると缶系の回避増加値に見える

        public int api_houm; // Unknown

        public int api_id; // ID of the item

        public String api_info; // Description of the item

        public int api_leng; // Range

        public int api_luck; // Luck Boost (nothing boosts this)

        public String api_name; // Name of the item

        public int api_raig; // Torpedo

        public int api_raik; // Unused value (Nothing boosts this)

        public int api_raim; // Unknown

        public int api_rare; // Rarity on a scale of 1-5

        public int api_sakb; // Unused (Nothing boosts this)

        public int api_saku; // Line of Sight

        public int api_soku; // Speed

        public int api_sortno; // Index within its category

        public int api_souk; // Armor (Nothing boosts this)

        public int api_taik; // Endurance/Max HP (Nothing boosts this)

        public int api_tais; // Anti-Sub

        public int api_tyku; // Anti-Air

        public List<Integer> api_type; // Type of the item?

        public String api_usebull; // Unused; always 0

        public String toString() {
            return String.format("%d %s", api_id, api_name);
        }
    }

}
