package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 道具マスタ
 */
public class MasterFurniture extends Master {

    @SerializedName("api_id")
    public int furnitureId; // 家具ID

    @SerializedName("api_type")
    public int type; // 家具タイプ

    @SerializedName("api_no")
    public int index; // タイプ内並び順

    @SerializedName("api_title")
    public String name; // 家具名

    @SerializedName("api_description")
    public String description; // 説明文

    @SerializedName("api_rarity")
    public int rarity; // レアリティ

    @SerializedName("api_price")
    public int price; // 必要家具コイン

    @SerializedName("api_saleflg")
    public int requireFairy; // 特注家具職人の要否

    @SerializedName("api_season")
    public int season; // 季節家具フラグ?


    public String toString() {
        return String.format("%d %s", furnitureId, name);
    }

    public static List<MasterFurniture> cache() {
        return Arrays.asList(loadMasterAsTypedArray("api_mst_furniture", MasterFurniture[].class));
    }


    public static Map<Integer, MasterFurniture> toIdMap(List<MasterFurniture> list) {
        Map<Integer, MasterFurniture> m = Maps.newHashMap();
        for (MasterFurniture e : list)
            m.put(e.furnitureId, e);
        return m;
    }
}
