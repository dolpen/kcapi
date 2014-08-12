package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 道具マスタ
 */
public class MasterUseItem extends Master {

    @SerializedName("api_id")
    public int itemId; // 道具ID

    @SerializedName("api_usetype")
    public int type; // 道具タイプ

    @SerializedName("api_category")
    public int categoryId; // 道具カテゴリ

    @SerializedName("api_name")
    public String name; // 道具名

    @SerializedName("api_description")
    public List<String> description; // 説明文

    public String toString() {
        return String.format("%d %s", itemId, name);
    }

    public static List<MasterUseItem> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_useitem",  MasterUseItem[].class));
    }


    public static Map<Integer, MasterUseItem> toIdMap(List<MasterUseItem> list) {
        Map<Integer, MasterUseItem> m = Maps.newHashMap();
        for (MasterUseItem e : list)
            m.put(e.itemId, e);
        return m;
    }
}
