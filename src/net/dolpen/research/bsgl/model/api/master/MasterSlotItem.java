package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 装備マスタ
 */
public class MasterSlotItem extends Master {

    // public int api_atap; // 未使用 (0以外なし)

    // public int api_bakk; // 未使用 (0以外なし)

    // public int api_baku; // 未使用

    @SerializedName("api_broken")
    public List<Integer> deconstructionGain; // 廃棄時獲得資材 [ 燃, 弾, 鋼, ボ ]

    @SerializedName("api_houg")
    public int firePower; // 火力

    @SerializedName("api_houk")
    public int evasion; // 回避(砲撃？)

    @SerializedName("api_houm")
    public int accuracy; // 命中（砲撃？）

    @SerializedName("api_id")
    public int weaponId; // 装備ID

    @SerializedName("api_info")
    public String description; // 説明文

    @SerializedName("api_leng")
    public int range; // 射程

    @SerializedName("api_luck")
    public int luck; // 運

    @SerializedName("api_name")
    public String name; // 装備名

    @SerializedName("api_raig")
    public int torpedo; // 雷装

    // public int api_raik; // Unused value (Nothing boosts this)

    // public int api_raim; // Unknown

    @SerializedName("api_rare")
    public int rarity; // レアリティ

    // public int api_sakb; // Unused (Nothing boosts this)

    @SerializedName("api_saku")
    public int sight; // 索敵

    @SerializedName("api_soku")
    public int speed; // スピード

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_souk")
    public int armor; // 装甲

    @SerializedName("api_taik")
    public int endurance; // 耐久

    @SerializedName("api_tais")
    public int antiSub; // 対潜

    @SerializedName("api_tyku")
    public int antiAir; // 対空

    @SerializedName("api_type")
    public List<Integer> type; // Type of the item?

    // public String api_usebull; // Unused; always 0

    public String toString() {
        return String.format("%d %s", weaponId, name);
    }

    public static List<MasterSlotItem> cache() {
        String cache = loadMasterCache("api_mst_slotitem");
        return Arrays.asList(new Gson().fromJson(cache, MasterSlotItem[].class));
    }

    public static Map<Integer, MasterSlotItem> toIdMap(List<MasterSlotItem> list) {
        Map<Integer, MasterSlotItem> m = Maps.newHashMap();
        for (MasterSlotItem e : list)
            m.put(e.weaponId, e);
        return m;
    }
}
