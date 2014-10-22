package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * 商品棚マスタ
 */
public class MasterItemShop extends Master {

    // MasterPayItem#productIdの配列

    @SerializedName("api_cabinet_1")
    public List<Integer> common; // 通常の棚

    @SerializedName("api_cabinet_2")
    public List<Integer> special; // 特選棚

    public String toString(){
        return String.format("%s,%s",common,special);
    }

    public static MasterItemShop cache() {
        return loadMasterAsTypedObject("api_mst_item_shop", MasterItemShop.class);
    }

}
