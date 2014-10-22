package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 装備マスタ
 */
public class MasterSlotItem extends Master {

    @SerializedName("api_id")
    public int weaponId; // 装備ID

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_name")
    public String name; // 装備名

    @SerializedName("api_type")
    public List<Integer> type; // Type of the item?

    @SerializedName("api_taik")
    public int endurance; // 耐久

    @SerializedName("api_souk")
    public int armor; // 装甲

    @SerializedName("api_houg")
    public int firePower; // 火力

    @SerializedName("api_raig")
    public int torpedo; // 雷装

    @SerializedName("api_soku")
    public int speed; // スピード

    @SerializedName("api_baku")
    public int bomb; // 爆装?

    @SerializedName("api_tyku")
    public int antiAir; // 対空

    @SerializedName("api_tais")
    public int antiSub; // 対潜

    // public int api_atap; // 未使用 (0以外なし)

    @SerializedName("api_houm")
    public int fireAccuracy; // 命中（砲撃？）

    @SerializedName("api_raim")
    public int torpedoAccuracy; // 命中（雷撃？）

    @SerializedName("api_houk")
    public int fireEvasion; // 回避(砲撃？)

    @SerializedName("api_raik")
    public int torpedoEvasion; // 回避(雷撃？)

    @SerializedName("api_bakk")
    public int bombEvasion; // 回避(爆撃？)

    @SerializedName("api_saku")
    public int sight; // 索敵

    // public int api_sakb; // Unused (Nothing boosts this)

    @SerializedName("api_luck")
    public int luck; // 運

    @SerializedName("api_leng")
    public int range; // 射程

    @SerializedName("api_rare")
    public int rarity; // レアリティ

    @SerializedName("api_broken")
    public List<Integer> deconstructionGain; // 廃棄時獲得資材 [ 燃, 弾, 鋼, ボ ]

    @SerializedName("api_info")
    public String description; // 説明文

    // public String api_usebull; // Unused; always 0

    public String toString() {
        return String.format("%d %s", weaponId, name);
    }

    public static List<MasterSlotItem> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_slotitem", MasterSlotItem[].class));
    }

    public static Map<Integer, MasterSlotItem> toIdMap(List<MasterSlotItem> list) {
        Map<Integer, MasterSlotItem> m = Maps.newHashMap();
        for (MasterSlotItem e : list)
            m.put(e.weaponId, e);
        return m;
    }
}
