package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 艦船マスタ
 */
public class MasterShip extends Master {

    @SerializedName("api_id")
    public int shipId; // 艦船ID

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_name")
    public String name; // 艦名

    @SerializedName("api_yomi")
    public String ruby; // 艦名ひらがな

    @SerializedName("api_stype")
    public int type; // 艦種

    @SerializedName("api_afterlv")
    public int remodelLevel; // 改造可能レベル

    @SerializedName("api_aftershipid")
    public int remodelledShipId; // 改造後艦船ID

    @SerializedName("api_taik")
    public List<Integer> endurance;  // 耐久 (???, 最大値=HP最大値)

    @SerializedName("api_souk")
    public List<Integer> armor; // 装甲 (初期値, 最大値)

    @SerializedName("api_houg")
    public List<Integer> firePower; // 火力 (初期値, 最大値)

    @SerializedName("api_raig")
    public List<Integer> torpedo; // 雷撃 (初期値, 最大値)

    @SerializedName("api_tyku")
    public List<Integer> antiAir;  // 対空 (初期値, 最大値)

    @SerializedName("api_luck")
    public List<Integer> luck; // 運 (初期値, 最大値)

    @SerializedName("api_soku")
    public int speed; // 速度?（10とかあるので、少なくとも高中低の区分ではない）

    @SerializedName("api_leng")
    public int range; // 射程

    @SerializedName("api_slot_num")
    public int slots; // 利用可能装備スロット数

    @SerializedName("api_maxeq")
    public List<Integer> slotCapacity; // スロット毎の搭載数

    @SerializedName("api_buildtime")
    public int buildTime; // 建造時間(分単位)

    @SerializedName("api_broken")
    public List<Integer> deconstructionGain; // 解体時獲得資材 [ 燃, 弾, 鋼, ボ ]

    @SerializedName("api_powup")
    public List<Integer> modernizationGain; // 食わせたときの上昇値 [ 火, 雷, 空, 甲 ]

    @SerializedName("api_backs")
    public int rarity; // レアリティ(背景色のソース)

    @SerializedName("api_getmes")
    public String greetingMessage; // 獲得時メッセージ

    @SerializedName("api_afterbull")
    public int remodelledMaxBullet; // 改造後の装弾数（なぜあるか不明）

    @SerializedName("api_afterfuel")
    public int remodelledMaxFuel; // 改造後の燃料搭載量（なぜあるか不明）

    @SerializedName("api_bull_max")
    public int maxBullet; // 装弾数

    @SerializedName("api_fuel_max")
    public int maxFuel; // 燃料搭載量

    @SerializedName("api_voicef")
    public int extraVoices; // おまけボイスの有無。あれば1-3だが大抵0


    public String toString() {
        return String.format("%d %s(%s)", shipId, name, ruby);
    }

    public static List<MasterShip> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_ship", MasterShip[].class));
    }

    public static Map<Integer, MasterShip> toIdMap(List<MasterShip> list) {
        Map<Integer, MasterShip> m = Maps.newHashMap();
        for (MasterShip e : list)
            m.put(e.shipId, e);
        return m;
    }
}
