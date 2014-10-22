package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 遠征任務マスタ
 */
public class MasterMission extends Master {

    @SerializedName("api_id")
    public int missionId; // 任務ID

    @SerializedName("api_maparea_id")
    public int areaId; // 海域ID

    @SerializedName("api_name")
    public String name; // 任務名

    @SerializedName("api_time")
    public int time; // 所要時間（分単位）

    @SerializedName("api_difficulty")
    public int level; // 難易度

    @SerializedName("api_use_fuel")
    public double fuel; // 燃料消費割合

    @SerializedName("api_use_bull")
    public double bull; // 弾薬消費割合

    @SerializedName("api_win_item1")
    public List<Integer> item1; // 獲得アイテム(ID,個数)

    @SerializedName("api_win_item2")
    public List<Integer> item2; // 獲得アイテム(ID,個数)

    public String toString() {
        return String.format("%d %s", missionId, name);
    }

    public static List<MasterMission> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_mission", MasterMission[].class));
    }

    public static Map<Integer, MasterMission> toIdMap(List<MasterMission> list) {
        Map<Integer, MasterMission> m = Maps.newHashMap();
        for (MasterMission e : list)
            m.put(e.areaId, e);
        return m;
    }
}
