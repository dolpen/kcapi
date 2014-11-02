package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 装備タイプ
 */
public class MasterWeaponType extends Master {

    @SerializedName("api_id")
    public int typeId;

    @SerializedName("api_name")
    public String name;

    @SerializedName("api_show_flg")
    public int showFlg;

    public static List<MasterWeaponType> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_slotitem_equiptype", MasterWeaponType[].class));
    }

    public static Map<Integer, MasterWeaponType> cacheAsMap() {
        Map<Integer, MasterWeaponType> m = Maps.newHashMap();
        for (MasterWeaponType e : cache())
            m.put(e.typeId, e);
        return m;
    }

    public String toString() {
        return String.format("%d %s", typeId, name);
    }
}
