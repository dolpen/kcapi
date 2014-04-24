package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * 艦船マスタ
 */
public class MasterShip extends Master {

    @SerializedName("api_afterbull")
    public int remodelledMaxBullet; // 改造後の装弾数（なぜあるか不明）

    @SerializedName("api_afterfuel")
    public int remodelledMaxFuel; // 改造後の燃料搭載量（なぜあるか不明）

    @SerializedName("api_afterlv")
    public int remodelLevel; // 改造可能レベル

    @SerializedName("api_aftershipid")
    public int remodelledShipId; // 改造後艦船ID

    //public List<Integer> api_atap; // 不使用 [ 0, 0 ]

    @SerializedName("api_backs")
    public int rarity; // レアリティ(背景色のソース)

    //public List<Integer> api_bakk; // 不使用 常に [ 0, 0 ]

    //public List<Integer> api_baku; // 不使用 常に [ 0, 0 ]

    @SerializedName("api_broken")
    public List<Integer> deconstructionGain; // 解体時獲得資材 [ 燃, 弾, 鋼, ボ ]

    @SerializedName("api_buildtime")
    public int buildTime; // 建造時間(分単位)

    @SerializedName("api_bull_max")
    public int maxBullet; // 装弾数

    public int api_cnum; // Index within its category

    public int api_ctype; // Class

    // public List<Integer> api_defeq; // ???

    // public int api_enqflg; // Has this ship been encountered?

    @SerializedName("api_fuel_max")
    public int maxFuel; // 燃料搭載量

    @SerializedName("api_getmes")
    public String greetingMessage; // 獲得時メッセージ

    //public List<Integer> api_grow; // 不使用 常に [0,0,0,0,0,0,0,0]

    //public List<Integer> api_gumax; // 不使用 常に [ 0, 0, 0, 0 ]

    //public String api_homemes; // ???


    @SerializedName("api_houg")
    public List<Integer> firePower; // 火力 (初期値, 最大値)

    // public List<Integer> api_houk; // 不使用 常に [ 0, 0 ]

    // public List<Integer> api_houm; // 不使用 常に [ 0, 0 ]


    @SerializedName("api_id")
    public int shipId; // 艦船ID

    @SerializedName("api_kaih")
    public List<Integer> evasion; // 回避 (初期値, 最大値)

    @SerializedName("api_leng")
    public int range; // 射程

    @SerializedName("api_luck")
    public List<Integer> luck; // 運 (初期値, 最大値)

    @SerializedName("api_maxeq")
    public List<Integer> slotCapacity; // スロット毎の航空機搭載数

    //public Object api_missions; // ??? (いつもnull)

    @SerializedName("api_name")
    public String name; // 艦名

    @SerializedName("api_powup")
    public List<Integer> modernizationGain; // 食わせたときの上昇値 [ 火, 雷, 空, 甲 ]

    @SerializedName("api_raig")
    public List<Integer> torpedo; // 雷撃 (初期値, 最大値)

    //public List<Integer> api_raik; // 不使用 常に [ 0, 0 ]

    //public List<Integer> api_raim; // 不使用 常に [ 0, 0 ]

    //public List<Integer> api_sakb; // 不使用 常に [ 0, 0 ]

    @SerializedName("api_saku")
    public List<Integer> sight; // 索敵 (初期値, 最大値)

    @SerializedName("api_sinfo")
    public String description; // 図鑑説明文

    @SerializedName("api_slot_num")
    public int slots; // スロット数

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_souk")
    public List<Integer> armor; // 装甲 (初期値, 最大値)

    public int api_stype; // Ship Class

    // public Object api_systems; // ??? (always null)

    @SerializedName("api_taik")
    public List<Integer> endurance;  // 耐久 (???, 最大値=HP最大値)

    @SerializedName("api_tais")
    public List<Integer> submarine; // 対潜 (初期値, 最大値)

    // public List<Object> api_touchs; // 不使用 常に [ null, null, null ]

    // public List<Integer> api_tous; // 不使用 常に [ 0, 0 ] 搭載？

    @SerializedName("api_tyku")
    public List<Integer> air;  // 対空 (初期値, 最大値)

    @SerializedName("api_voicef")
    public int extraVoices; // おまけボイスの有無。あれば1-3だが大抵0

    @SerializedName("api_yomi")
    public String ruby; // 艦名ひらがな

    public String toString() {
        return String.format("%d %s(%s)", shipId, name, ruby);
    }

    public static List<MasterShip> cache() {
        String cache = loadMasterCache("api_mst_ship");
        System.out.println(cache);
        return Arrays.asList(new Gson().fromJson(cache, MasterShip[].class));
    }
}
