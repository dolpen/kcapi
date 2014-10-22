package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * ステージセルマスタ
 */
public class MasterMapCell extends Master {

    @SerializedName("api_map_no")
    public int stageId; // ステージID

    @SerializedName("api_maparea_id")
    public int areaId; // 海域ID

    @SerializedName("api_mapinfo_no")
    public int stageNo; // 海域内ステージ番号

    @SerializedName("api_id")
    public int cellId; // セルID

    @SerializedName("api_no")
    public int cellNo; // セル番号

    @SerializedName("api_color_no")
    public int color; // セル表示 [0:スタート,1:？,2:緑,3:渦潮,4:赤,5:ボス]

    public String toString() {
        return String.format("%d-%d-%d", areaId, stageNo, cellNo);
    }

    public static List<MasterMapCell> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_mapcell", MasterMapCell[].class));
    }

    public static Map<Integer, MasterMapCell> toIdMap(List<MasterMapCell> list) {
        Map<Integer, MasterMapCell> m = Maps.newHashMap();
        for (MasterMapCell e : list)
            m.put(e.areaId, e);
        return m;
    }
}
