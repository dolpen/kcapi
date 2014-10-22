package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 海域マスタ
 */
public class MasterMapArea extends Master {

    @SerializedName("api_id")
    public int areaId; // 海域ID

    @SerializedName("api_name")
    public String name; // 海域名

    @SerializedName("api_type")
    public int type; // 海域タイプ

    public String toString() {
        return String.format("%d %s", areaId, name);
    }

    public static List<MasterMapArea> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_maparea", MasterMapArea[].class));
    }

    public static Map<Integer, MasterMapArea> toIdMap(List<MasterMapArea> list) {
        Map<Integer, MasterMapArea> m = Maps.newHashMap();
        for (MasterMapArea e : list)
            m.put(e.areaId, e);
        return m;
    }
}
