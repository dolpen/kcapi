package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * ステージマスタ
 */
public class MasterMapStage extends Master {

    @SerializedName("api_id")
    public int stageId; // ステージID

    @SerializedName("api_maparea_id")
    public int areaId; // 海域ID

    @SerializedName("api_no")
    public int stageNo; // 海域内ステージ番号

    @SerializedName("api_name")
    public String name; // 海域名

    @SerializedName("api_level")
    public int level; // 難易度

    @SerializedName("api_oretext")
    public String operation; // 作戦名

    @SerializedName("api_infotext")
    public String description; // 説明

    @SerializedName("api_item")
    public List<Integer> item; // 獲得可能アイテム

    @SerializedName("api_sally_flag")
    public List<Integer> sally; // 出撃可能艦隊タイプ[通常,連合]


    public String toString() {
        return String.format("%d-%d %s", areaId, stageNo, name);
    }

    public static List<MasterMapStage> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_mapinfo", MasterMapStage[].class));
    }

    public static Map<Integer, MasterMapStage> toIdMap(List<MasterMapStage> list) {
        Map<Integer, MasterMapStage> m = Maps.newHashMap();
        for (MasterMapStage e : list)
            m.put(e.areaId, e);
        return m;
    }
}
