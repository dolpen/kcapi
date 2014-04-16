package net.dolpen.research.bsgl.model.member;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 所持装備
 */
public class InventorySlotItem extends Common {

    public List<Content> api_data;

    public static class Content {
        public int api_atap; // Unused value (Nothing boosts this)

        public int api_bakk; // Unused value (Nothing boosts this)

        public int api_baku; // Unused value

        public List<Integer> api_broken; // ???

        public int api_houg; // Firepower

        public int api_houk; // Unknown

        public int api_houm; // Unknown

        public int api_id; // Local ID (just an identifier in your deck)

        public String api_info; // Description of the item

        public int api_kaih; // Evasion

        public int api_leng; // Range

        public int api_luck; // Luck Boost (nothing boosts this)

        public int api_member_id; // ID of admiral

        public String api_name; // Name of the item

        public int api_raig; // Torpedo

        public int api_raik; // Unused value (Nothing boosts this)

        public int api_raim; // Unknown

        public int api_rare; // Rarity on a scale of 1-5

        public int api_sakb; // Unused (Nothing boosts this)

        public int api_saku; // Line of Sight

        public int api_slotitem_id; // ID of the actual item

        public int api_soku; // Speed

        public int api_souk; // Armor (Nothing boosts this)

        public int api_taik; // Endurance/Max HP (Nothing boosts this)

        public int api_tais; // Anti-Sub

        public int api_tyku; // Anti-Air

        public List<Integer> api_type; // Type of the item?

        public String toString() {
            return String.format("%d %d %s", api_id, api_slotitem_id, api_name);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : api_data) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }

    public static InventorySlotItem cache() {
        String resp = Cache.load("/inputs/member/slotitem.txt");
        return new Gson().fromJson(resp, InventorySlotItem.class);
    }
}
