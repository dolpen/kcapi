package net.dolpen.research.bsgl.model.master;

import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * 艦船のマスタデータ
 * 艦娘以外に敵のデータもある
 */
public class Ship extends Common {

    public List<Content> api_data;

    public static class Content {
        public int api_id;
        public int api_sortno;
        public String api_name;
        public String api_yomi;
        public int api_stype;
        public int api_ctype;
        public int api_cnum;
        public String api_enqflg;
        public int api_afterlv;
        public String api_aftershipid;
        public List<Integer> api_taik; // 対艦
        public List<Integer> api_souk; // 装甲
        public List<Integer> api_tous; // ?
        public List<Integer> api_houg; // 砲撃
        public List<Integer> api_raig; // 雷撃
        public List<Integer> api_baku; // 爆装
        public List<Integer> api_tyku; // 耐久
        public List<Integer> api_atap; //
        public List<Integer> api_tais; // 対潜
        public List<Integer> api_houm;
        public List<Integer> api_raim;
        public List<Integer> api_kaih; //
        public List<Integer> api_houk; //
        public List<Integer> api_raik;
        public List<Integer> api_bakk;
        public List<Integer> api_saku;
        public List<Integer> api_sakb;
        public List<Integer> api_luck;
        public int api_sokuh;
        public int api_soku;
        public int api_leng;
        public List<Integer> api_grow;
        public int api_slot_num;
        public List<Integer> api_maxeq;
        public List<Integer> api_defeq;
        public int api_buildtime;
        public List<Integer> api_broken;
        public List<Integer> api_powup;
        public List<Integer> api_gumax;
        public int api_backs;
        public String api_getmes;
        public String api_homemes;
        public String api_gomes;
        public String api_gomes2;
        public String api_sinfo;
        public int api_afterfuel;
        public int api_afterbull;
        //public List<Integer> api_touchs; // 型不明
        public int api_missions; // 型不明
        public int api_systems; // 型不明
        public int api_fuel_max;
        public int api_bull_max;
        public int api_voicef;
    }

    /*
    public static Ship get() {
        String resp = Request.postJson("/api_get_master/ship", null);
        return new Gson().fromJson(resp, Ship.class);
    }
    */
}
