package net.dolpen.research.bsgl.model.master;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 装備マスタ
 */
public class SlotItemMaster extends Common {
    public List<Entry> api_data;

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


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : api_data) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    public static SlotItemMaster cache() {
        String resp = Cache.load("/inputs/master/slotitem.txt");
        return new Gson().fromJson(resp, SlotItemMaster.class);
    }
}
