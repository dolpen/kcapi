package net.dolpen.research.bsgl.model.member;

import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 持ってる艦
 * /api_get_member/ship2
 * <p/>
 * api_sort_order:2
 * api_sort_key:2
 */
public class InventoryShip extends Common {

    // 船一覧
    public List<ShipData> api_data;

    // 艦隊一覧
    public List<FleetData> api_data_deck;

    public static class ShipData {
        public int api_afterlv;
        public int api_aftershipid;
        public int api_backs;
        public List<Integer> api_broken;

        public int api_bull;
        public int api_bull_max;
        public int api_cond;
        public int api_exp;
        public int api_fuel;
        public int api_fuel_max;
        public Integer api_gomesx;
        public Integer api_gomes2;

        public List<Integer> api_houg;

        public List<Integer> api_houm;

        public int api_id;
        public List<Integer> api_kaihi;
        public List<Integer> api_karyoku;
        public List<Integer> api_kyouka;
        public int api_leng;
        //public int api_locked;
        public List<Integer> api_lucky;
        public int api_lv;
        public int api_maxhp;
        public int api_member_id;
        public String api_name;
        public List<Integer> api_ndock_item;
        public int api_ndock_time;
        public String api_ndock_time_str;
        public int api_nowhp;
        public List<Integer> api_onslot;
        public List<Integer> api_powup;
        public List<Integer> api_raig;
        public List<Integer> api_raim;
        public List<Integer> api_raisou;
        public List<Integer> api_saku;
        public List<Integer> api_sakuteki;
        public int api_ship_id;
        public List<Integer> api_slot;
        public int api_slotnum;
        public int api_soku;
        public int api_sortno;
        public List<Integer> api_souk;
        public List<Integer> api_soukou;
        public int api_srate;
        public int api_star;
        public int api_stype;
        public List<Integer> api_taik;
        public List<Integer> api_taiku;
        public List<Integer> api_taisen;
        public List<Integer> api_tyku;
        public int api_use_bull;
        public int api_use_fuel;
        public int api_voicef;
        public String api_yomi;
    }

    public static class FleetData {
        public String api_flagship;
        public int api_id;
        public int api_member_id;
        public List<Long> api_mission;
        public String api_name;
        public String api_name_id;
        public List<Integer> api_ship;
    }

    /*
    public static InventoryShip get(int sort) {
        String resp = Request.postJson(
                "/api_get_member/ship2",
                ImmutableMap.<String, String>builder().put("api_sort_order", "" + sort).put("api_sort_key", "" + sort).build()
        );
        return new Gson().fromJson(resp, InventoryShip.class);
    }
    */
    public static InventoryShip cache() {
        String resp = Cache.load("./kcapi/inputs/member/ship.txt");
        return new Gson().fromJson(resp, InventoryShip.class);
    }
}
