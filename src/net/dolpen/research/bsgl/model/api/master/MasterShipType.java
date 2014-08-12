package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 艦種マスタ
 */
public class MasterShipType extends Master {

    @SerializedName("api_id")
    public int typeId; // 艦種ID

    @SerializedName("api_sortno")
    public int index; // 並び順

    @SerializedName("api_name")
    public String name; // 艦種名

    public int api_scnt; // ?

    public int api_kcnt; // ?

    public String toString() {
        return String.format("%d %s", typeId, name);
    }

    public static List<MasterShipType> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_stype",  MasterShipType[].class));
    }

    public static Map<Integer, MasterShipType> toIdMap(List<MasterShipType> list) {
        Map<Integer, MasterShipType> m = Maps.newHashMap();
        for (MasterShipType e : list)
            m.put(e.typeId, e);
        return m;
    }
}
