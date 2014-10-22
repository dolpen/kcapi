package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 道具リソースマスタ
 */
public class MasterFurnitureGraph extends Master {

    @SerializedName("api_id")
    public int furnitureId; // 家具ID

    @SerializedName("api_type")
    public int type; // 家具タイプ

    @SerializedName("api_no")
    public int index; // タイプ内並び順

    @SerializedName("api_filename")
    public String name; // ファイル名プレフィックス

    @SerializedName("api_version")
    public int version; // バージョン


    public String toString() {
        return String.format("%d %s", furnitureId, name);
    }

    public static List<MasterFurnitureGraph> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_furnituregraph", MasterFurnitureGraph[].class));
    }

    public static Map<Integer, MasterFurnitureGraph> toIdMap(List<MasterFurnitureGraph> list) {
        Map<Integer, MasterFurnitureGraph> m = Maps.newHashMap();
        for (MasterFurnitureGraph e : list)
            m.put(e.furnitureId, e);
        return m;
    }
}
