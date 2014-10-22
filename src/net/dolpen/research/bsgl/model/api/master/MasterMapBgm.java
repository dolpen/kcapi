package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * ステージBGMマスタ
 */
public class MasterMapBgm extends Master {

    @SerializedName("api_id")
    public int stageId; // ステージID

    @SerializedName("api_maparea_id")
    public int areaId; // 海域ID

    @SerializedName("api_no")
    public int stageNo; // 海域内ステージ番号

    @SerializedName("api_map_bgm")
    public List<Integer> map; // 通常BGM

    @SerializedName("api_boss_bgm")
    public List<Integer> boss; // ボスBGM

    public String toString() {
        return String.format("%d-%d", areaId, stageNo);
    }

    public static List<MasterMapBgm> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_mapbgm", MasterMapBgm[].class));
    }

    public static Map<Integer, MasterMapBgm> toIdMap(List<MasterMapBgm> list) {
        Map<Integer, MasterMapBgm> m = Maps.newHashMap();
        for (MasterMapBgm e : list)
            m.put(e.areaId, e);
        return m;
    }
}
