package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 艦船特殊改造マスタ
 */
public class MasterShipUpgrade extends Master {

    @SerializedName("api_id")
    public int shipId; // 艦船ID

    @SerializedName("api_original_ship_id")
    public int originalShipId; // 改造前艦船ID

    @SerializedName("api_upgrade_type")
    public int type; // 艦種

    @SerializedName("api_upgrade_level")
    public int phase; // 改造段階

    @SerializedName("api_drawing_count")
    public int drawing; // 改装設計図必要数

    @SerializedName("api_sortno")
    public int index; // 並び順


    public String toString() {
        return String.format("%d", shipId);
    }

    public static List<MasterShipUpgrade> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_shipupgrade", MasterShipUpgrade[].class));
    }

    public static Map<Integer, MasterShipUpgrade> toIdMap(List<MasterShipUpgrade> list) {
        Map<Integer, MasterShipUpgrade> m = Maps.newHashMap();
        for (MasterShipUpgrade e : list)
            m.put(e.shipId, e);
        return m;
    }
}
