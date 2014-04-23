package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 艦船のマスタデータ
 * 艦娘以外に敵のデータもある
 */
public class ShipMaster extends Master {

    public List<Content> api_data;

    public static class Content {
        public int api_afterbull; // Bullet cost for remodelling

        public int api_afterfuel; // Fuel cost for remodelling

        public int api_afterlv; // Minimum level for remodelling

        public int api_aftershipid; // ID of the next form after remodelling

        public List<Integer> api_atap; // Unused, always [ 0, 0 ]

        public int api_backs; // Rarity

        public List<Integer> api_bakk; // Unused, always [ 0, 0 ]

        public List<Integer> api_baku; // Unused, always [ 0, 0 ]

        public List<Integer> api_broken; // Deconstruction gain (Fuel, Ammo, Steel, Bauxite)

        public int api_buildtime; // The build time, in minutes

        public int api_bull_max; // Max bullet capacity (cost to resupply)

        public int api_cnum; // Index within its category

        public int api_ctype; // Class

        public List<Integer> api_defeq; // ???

        public int api_enqflg; // Has this ship been encountered?

        public int api_fuel_max; // Max fuel capacity (cost to resupply)

        public String api_getmes; // Message upon getting her

        public List<Integer> api_grow; // Unused, always [0,0,0,0,0,0,0,0]

        public List<Integer> api_gumax; // Unused, always [ 0, 0, 0, 0 ]

        public List<Integer> api_houg; // Firepower (base, max)

        public List<Integer> api_houk; // Unknown (always [ 0, 0 ], but has equipment)

        public List<Integer> api_houm; // Unknown (always [ 0, 0 ], but has equipment)

        public int api_id; // Ship ID

        public List<Integer> api_kaih; // Evasion (base, max)

        public int api_leng; // Range

        public List<Integer> api_luck; // Luck (base, ???; not max)

        public List<Integer> api_maxeq; // Plane Capacity

        //public Object api_missions; // ??? (always null)

        public String api_name; // The ship's name, in Kanji

        public List<Integer> api_powup; // Powerups granted when used for modernization

        public List<Integer> api_raig; // Torpedo (base, max)

        public List<Integer> api_raik; // Unused, always [ 0, 0 ]

        public List<Integer> api_raim; // Unknown (always [ 0, 0 ], but has equipment)

        public List<Integer> api_sakb; // Unused, always [ 0, 0 ]

        public List<Integer> api_saku; // Line of Sight (base, max)

        public String api_sinfo; // Description for the Shipdex

        public int api_slot_num; // Number of equipment slots

        public int api_sortno; // Card Number

        public List<Integer> api_souk; // Armor (base, max)

        public int api_stype; // Ship Class

        // public Object api_systems; // ??? (always null)

        public List<Integer> api_taik; // Endurance/Max HP (base, max)

        public List<Integer> api_tais; // Anti-Sub Warfare (base, max)

        // public List<Object> api_touchs; // Unused, always [ null, null, null ]

        public List<Integer> api_tous; // ???

        public List<Integer> api_tyku; // Anti-Air

        public int api_voicef; // 1 or 3 if the ship has extra voice clips, normally 0

        public String api_yomi; // The name's reading

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

    public Map<Integer,Content> toIdMap(){
        Map<Integer, Content> idMap = Maps.newHashMap();
        for(Content c : api_data){
            idMap.put(c.api_id,c);
        }
        return idMap;
    }


    public static ShipMaster cache() {
        ShipMaster resp = new ShipMaster();
        String cache = loadMasterCache("api_mst_ship");
        resp.api_data = Arrays.asList(new Gson().fromJson(cache, Content[].class));
        return resp;
    }


}
