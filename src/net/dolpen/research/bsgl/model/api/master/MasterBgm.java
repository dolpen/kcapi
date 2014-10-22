package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * BGMマスタ
 */
public class MasterBgm extends Master {

    @SerializedName("api_id")
    public int bgmId; // 艦船ID

    @SerializedName("api_name")
    public String name; // 曲名

    public String toString() {
        return String.format("%d %s", bgmId, name);
    }

    public static List<MasterBgm> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_bgm", MasterBgm[].class));
    }

    public static Map<Integer, MasterBgm> toIdMap(List<MasterBgm> list) {
        Map<Integer, MasterBgm> m = Maps.newHashMap();
        for (MasterBgm e : list)
            m.put(e.bgmId, e);
        return m;
    }
}
