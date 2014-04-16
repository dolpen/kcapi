package net.dolpen.research.bsgl.model.member;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 所持艦リスト
 */
public class InventoryShip extends Common {

    public List<Content> api_data;

    public static class Content {
        public int api_afterlv; // Remodel level
        public int api_aftershipid; // Remodels into...
        public int api_backs; // Rarity
        public List<Integer> api_baku; // Seems unused...
        public List<Integer> api_broken; // Resources gained for deconstructing her
        public int api_bull; // Bullets held
        public int api_bull_max; // Bullet capacity
        public int api_cond; // Condition (fatigue)
        public int api_exp; // Total EXP
        public int api_fuel; // Fuel
        public int api_fuel_max; // Fuel capacity
        // public Object api_gomes; // ??? (always null?)
        // public Object api_gomes2; // ??? (always null?)
        public List<Integer> api_houg; // Firepower, with modernization (cur, max)
        public List<Integer> api_houm; // ???
        public int api_id; // Her local ID (just an identifier in your deck)
        public List<Integer> api_kaihi; // Evasion, with equipment
        public List<Integer> api_karyoku; // Firepower, with modernization and equipment (cur, max)
        public List<Integer> api_kyouka; // Something to do with modernization
        public int api_leng; // Range
        public List<Integer> api_luck; // Luck, with modernizations (current, max)
        public List<Integer> api_lucky; // Luck, with modernization and equipment (current, max)
        public int api_lv; // Level
        public int api_maxhp; // Max HP
        public int api_member_id; // ID of her admiral
        public String api_name; // Her name, with Kanji
        public List<Integer> api_ndock_item; // Current cost to repair (Steel, Fuel)
        public int api_ndock_time; // Current repair time, in seconds
        public String api_ndock_time_str; // Current time to repair (in the format HH:MM:SS)
        public int api_nowhp; // Current HP
        public List<Integer> api_onslot; // ???
        public List<Integer> api_powup; // Bonus when used for modernization, ( FP, TP, AA, AM )
        public List<Integer> api_raig; // Torpedo, with modernization (cur, max)
        public List<Integer> api_raim; // Seems unused (always [ 0, 0 ])
        public List<Integer> api_raisou; // Torpedo, with modernization and equipment (cur, max)
        public List<Integer> api_saku; // Line of Sight, with modernization (cur, max)
        public List<Integer> api_sakuteki; // Line of Sight, with modernization and equipment (cur, max)
        public int api_ship_id; // ID of the ship
        public List<Integer> api_slot; // What's equipped in each slot
        public int api_slotnum; // Available number of slots
        public int api_soku; // Speed
        public int api_sortno; // The number on the card
        public List<Integer> api_souk; // Armor, with modernization (cur, max)
        public List<Integer> api_soukou; // Armor, with modernization and equipment (cur, max)
        public int api_srate; // Always seems to be the same as api_star
        public int api_star; // Number of stars the ship has minus 1 (0-4)
        public int api_stype; // Ship Type
        public List<Integer> api_taik; // Endurance/Max HP (cur, max)
        public List<Integer> api_taiku; // Anti-Air, with modernization and equipment (cur, max)
        public List<Integer> api_taisen; // Anti-Sub (cur, max)
        public List<Integer> api_tyku; // Anti-Air, with modernization (cur, max)
        public int api_use_bull; // Ammo cost per point to resupply
        public int api_use_fuel; // Fuel cost per point to resupply
        public int api_voicef; // 1 or 3 if the ship has extra (hourly?) voice clips
        public String api_yomi; // Name, in Hiragana/Katakana

        public String toString() {
            return String.format("%d : %d : %s", api_id, api_ship_id, api_name);

        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : api_data) {
            sb.append(content.toString()).append("\n");
        }
        return sb.toString();
    }

    public static InventoryShip cache() {
        String resp = Cache.load("/inputs/member/ship.txt");
        return new Gson().fromJson(resp, InventoryShip.class);
    }
}
