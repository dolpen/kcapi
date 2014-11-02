package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 装備マスタ
 */
public class MasterWeapon extends Master {

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


    public static List<MasterWeapon> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_slotitem", MasterWeapon[].class));
    }

    public static Map<Integer, MasterWeapon> cacheAsMap() {

        Map<Integer, MasterWeapon> m = Maps.newHashMap();
        for (MasterWeapon e : cache())
            m.put(e.weaponId, e);
        return m;
    }

    public String toString() {
        return String.format("%d %s", weaponId, name);
    }

    // api_typeの3番目が装備タイプマスタID
    public int getTypeId(){
        return type.get(2);
    }
}
