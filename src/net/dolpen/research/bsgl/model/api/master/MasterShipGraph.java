package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 艦船リソースマスタ
 */
public class MasterShipGraph extends Master {

    @SerializedName("api_id")
    public int shipId; // 艦船ID

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_filename")
    public String name; // ファイル名プレフィックス

    @SerializedName("api_version")
    public int version; // バージョン

    // あまりやる気がない
    public int[] api_boko_n; // ?
    public int[] api_boko_d; // ?
    public int[] api_kaisyu_n; // 近代化改修?
    public int[] api_kaisyu_d; // 近代化改修?
    public int[] api_kaizo_n; // 改造?
    public int[] api_kaizo_d; // 改造?
    public int[] api_map_n; // 出撃?
    public int[] api_map_d; // 出撃?
    public int[] api_ensyuf_n; // 演習?
    public int[] api_ensyuf_d; // 演習?
    public int[] api_ensyue_n; // 演習?
    public int[] api_battle_n; // 戦闘?
    public int[] api_battle_d; // 戦闘?
    public int[] api_weda; // ?
    public int[] api_wedb; // ?

    public String toString() {
        return String.format("%d %s", shipId, name);
    }

    public static List<MasterShipGraph> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_shipgraph", MasterShipGraph[].class));
    }

    public static Map<Integer, MasterShipGraph> toIdMap(List<MasterShipGraph> list) {
        Map<Integer, MasterShipGraph> m = Maps.newHashMap();
        for (MasterShipGraph e : list)
            m.put(e.shipId, e);
        return m;
    }
}
