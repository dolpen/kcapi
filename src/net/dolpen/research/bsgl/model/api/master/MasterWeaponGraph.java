package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 装備リソースマスタ
 */
public class MasterWeaponGraph extends Master {

    @SerializedName("api_id")
    public int weaponId; // 装備ID

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_filename")
    public String name; // ファイル名プレフィックス

    @SerializedName("api_version")
    public int version; // バージョン

    public static List<MasterWeaponGraph> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_slotitemgraph", MasterWeaponGraph[].class));
    }

    public static Map<Integer, MasterWeaponGraph> cacheAsMap() {
        Map<Integer, MasterWeaponGraph> m = Maps.newHashMap();
        for (MasterWeaponGraph e : cache())
            m.put(e.weaponId, e);
        return m;
    }

    public String toString() {
        return String.format("%d %s", weaponId, name);
    }
}
