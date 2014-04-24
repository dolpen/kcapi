package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * 艦船マスタ
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
        String cache = loadMasterCache("api_mst_stype");
        return Arrays.asList(new Gson().fromJson(cache, MasterShipType[].class));
    }
}
