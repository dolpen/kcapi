package net.dolpen.research.bsgl.model.api.member;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * 所持艦船
 */
public class MemberShip extends Member {

    @SerializedName("api_backs")
    public int rarity; // レアリティ(背景色のソース)

    @SerializedName("api_bull")
    public int bullet; // 搭載中弾薬

    @SerializedName("api_cond")
    public int condition; // 疲労とかキラキラ

    @SerializedName("api_exp")
    public List<Integer> exp; //  経験値 [ 累積, LvUP必要量, percentile of exp bar?]

    @SerializedName("api_fuel")
    public int fuel; // 燃料

    @SerializedName("api_id")
    public int girlId; // ローカルID

    @SerializedName("api_kaihi")
    public List<Integer> evasion; // 回避 (現在,最大)

    @SerializedName("api_karyoku")
    public List<Integer> firePower; // 火力 (現在,最大)

    @SerializedName("api_kyouka")
    public List<Integer> modernizationStatus; // 改修状況

    @SerializedName("api_leng")
    public int range; // 射程

    @SerializedName("api_locked")
    public int locked; // ロック

    @SerializedName("api_lucky")
    public List<Integer> luck; // 運 (現在,最大)

    @SerializedName("api_lv")
    public int lv; // レベル

    @SerializedName("api_maxhp")
    public int maxHp; // Max HP

    @SerializedName("api_ndock_item")
    public List<Integer> repairCost; // 修理コスト [鋼, 燃]

    @SerializedName("api_ndock_time")
    public int repairTime; // 修理所要時間(秒単位)

    @SerializedName("api_nowhp")
    public int hp; // 現在のHP

    // public List<Integer> api_onslot; // ???

    @SerializedName("api_raisou")
    public List<Integer> torpedo; // 雷装 (現在,最大)

    @SerializedName("api_sakuteki")
    public List<Integer> sight; // 索敵 (現在,最大)

    @SerializedName("api_ship_id")
    public int shipId; // 艦船マスタID

    @SerializedName("api_slot")
    public List<Integer> slotIds; // 装備メンバID

    @SerializedName("api_slotnum")
    public int slots; // 装備スロット数

    @SerializedName("api_sortno")
    public int index; // 荒び順

    @SerializedName("api_soukou")
    public List<Integer> armor; // 装甲 (現在,最大)

    @SerializedName("api_srate")
    public int star; // あの謎の星マークの数

    @SerializedName("api_taiku")
    public List<Integer> antiAir; // 対空 (現在,最大)

    @SerializedName("api_taisen")
    public List<Integer> antiSub; // 対潜 (現在,最大)

    public String toString() {
        return String.format("%d : %d", girlId, shipId);
    }

    public static List<MemberShip> cache() {
        return Arrays.asList(loadMemberTyped("api_ship", MemberShip[].class));
    }

}
