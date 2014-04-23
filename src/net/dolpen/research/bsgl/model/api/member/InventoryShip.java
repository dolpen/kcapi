package net.dolpen.research.bsgl.model.api.member;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 所持艦リスト
 */
public class InventoryShip extends Member {

    public List<Entry> api_data;

    public static InventoryShip cache() {
        InventoryShip resp = new InventoryShip();
        String cache = loadPortCache("api_ship");
        resp.api_data = Arrays.asList(new Gson().fromJson(cache, Entry[].class));
        return resp;
        //String resp = Cache.load("/inputs/member/ship.txt");
        //return new Gson().fromJson(resp, InventoryShip.class);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : api_data) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Local shipId -> Entry
     *
     * @return map
     */
    public Map<Integer, Entry> toIdMap() {
        Map<Integer, Entry> items = Maps.newHashMap();
        for (Entry s : api_data) {
            items.put(s.api_id, s);
        }
        return items;
    }

    /**
     * itemId -> Local shipId
     *
     * @return map
     */
    public Map<Integer, Integer> toitemIdMap() {
        Map<Integer, Integer> items = Maps.newHashMap();
        for (Entry s : api_data) {
            for (int i : s.api_slot) {
                if (i < 0) continue;
                items.put(i, s.api_id);
            }
        }
        return items;
    }

    public static class Entry {

        public int api_backs; // Rarity

        public int api_bull; // Bullets held

        public int api_cond; // Condition (fatigue)

        public List<Integer> api_exp; //  exp [ total, nextlv, percentile of exp bar?]

        public int api_fuel; // Fuel

        public int api_id; // Her local ID (just an identifier in your deck)

        public List<Integer> api_kaihi; // Evasion, with equipment

        public List<Integer> api_karyoku; // Firepower, with modernization and equipment (cur, max)

        public List<Integer> api_kyouka; // Something to do with modernization

        public int api_leng; // Range

        public int api_locked; // is Locked

        public List<Integer> api_lucky; // Luck, with modernization and equipment (current, max)

        public int api_lv; // Level

        public int api_maxhp; // Max HP

        public List<Integer> api_ndock_item; // Current cost to repair (Steel, Fuel)

        public int api_ndock_time; // Current repair time, in seconds

        public int api_nowhp; // Current HP

        public List<Integer> api_onslot; // ???

        public List<Integer> api_raisou; // Torpedo, with modernization and equipment (cur, max)

        public List<Integer> api_sakuteki; // Line of Sight, with modernization and equipment (cur, max)

        public int api_ship_id; // ID of the ship

        public List<Integer> api_slot; // What's equipped in each slot

        public int api_slotnum; // Available number of slots

        public int api_sortno; // The number on the card

        public List<Integer> api_soukou; // Armor, with modernization and equipment (cur, max)

        public int api_srate; // Always seems to be the same as api_star

        public List<Integer> api_taiku; // Anti-Air, with modernization and equipment (cur, max)

        public List<Integer> api_taisen; // Anti-Sub (cur, max)

        public String toString() {
            return String.format("%d : %d", api_id, api_ship_id);
        }
    }
}
