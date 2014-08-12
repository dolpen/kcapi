package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.api.Common;

/**
 * マスタデータの親オブジェクト
 */
public class Master extends Common {

    /**
     * マスタデータを得る
     *
     *
     * @param elementName 要素名
     * @return データセット
     */
    protected static JsonArray loadMaster(String elementName) {
        return loadApidata("/inputs/master/start2_master.txt")
                .getAsJsonArray(elementName);
    }

    /**
     * 対応する型を指定し、データを得る
     *
     * @param elementName 要素名
     * @param clazz       変換対象
     * @return レスポンス
     */
    public static <T> T loadMasterTyped(String elementName, Class<T> clazz) {
        return new Gson().fromJson(loadMaster(elementName), clazz);
    }

}
