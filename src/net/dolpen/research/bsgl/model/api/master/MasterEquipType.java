package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * 装備タイプ
 */
public class MasterEquipType extends Master {

    @SerializedName("api_id")
    public int typeId;

    @SerializedName("api_name")
    public String name;

    @SerializedName("api_show_flg")
    public int showFlg;

    public String toString() {
        return String.format("%d %s", typeId, name);
    }

    public static List<MasterEquipType> cache() {
        String cache = loadMasterCache("api_mst_slotitem_equiptype");
        return Arrays.asList(new Gson().fromJson(cache, MasterEquipType[].class));
    }
}
