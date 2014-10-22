package net.dolpen.research.bsgl.model.api.master;

import com.beust.jcommander.internal.Maps;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 商品マスタ
 */
public class MasterPayItem extends Master {

    @SerializedName("api_id")
    public int productId; // 商品ID

    @SerializedName("api_type")
    public int type; // 商品タイプ

    @SerializedName("api_name")
    public String name; // 商品名

    @SerializedName("api_description")
    public String description; // 説明文

    @SerializedName("api_item")
    public List<Integer> item; // 各アイテム獲得量

    @SerializedName("api_price")
    public int price; // 必要ポイント

    public String toString() {
        return String.format("%d %s", productId, name);
    }

    public static List<MasterPayItem> cache() {
        return Arrays.asList(loadMasterTyped("api_mst_payitem",  MasterPayItem[].class));
    }

    public static Map<Integer, MasterPayItem> toIdMap(List<MasterPayItem> list) {
        Map<Integer, MasterPayItem> m = Maps.newHashMap();
        for (MasterPayItem e : list)
            m.put(e.productId, e);
        return m;
    }
}
