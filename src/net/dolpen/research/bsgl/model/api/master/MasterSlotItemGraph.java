package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 装備リソースマスタ
 */
public class MasterSlotItemGraph extends Master {

    @SerializedName("api_id")
    public int weaponId; // 装備ID

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_filename")
    public String name; // ファイル名プレフィックス

    @SerializedName("api_version")
    public int version; // バージョン

    public String toString() {
        return String.format("%d %s", weaponId, name);
    }

    public static List<MasterSlotItemGraph> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_slotitemgraph", MasterSlotItemGraph[].class));
    }

    public static Map<Integer, MasterSlotItemGraph> toIdMap(List<MasterSlotItemGraph> list) {
        Map<Integer, MasterSlotItemGraph> m = Maps.newHashMap();
        for (MasterSlotItemGraph e : list)
            m.put(e.weaponId, e);
        return m;
    }
}
