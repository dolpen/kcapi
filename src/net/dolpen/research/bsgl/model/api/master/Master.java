package net.dolpen.research.bsgl.model.api.master;

import com.google.gson.*;
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
    protected static JsonObject loadMasterData(String elementName) {
        return loadApiData("/inputs/master/start2_master.txt")
                .getAsJsonObject(elementName);
    }

    /**
     * マスタデータを得る
     *
     *
     * @param elementName 要素名
     * @return データセット
     */
    protected static JsonArray loadMasterAsArray(String elementName) {
        return loadApiData("/inputs/master/start2_master.txt")
                .getAsJsonArray(elementName);
    }

    /**
     * 対応する型を指定し、データを得る
     *
     * @param elementName 要素名
     * @param clazz       変換対象
     * @return レスポンス
     */
    public static <T> T loadMasterAsTypedObject(String elementName, Class<T> clazz) {
        return new Gson().fromJson(loadMasterData(elementName), clazz);
    }

    /**
     * 対応する型を指定し、データを得る
     *
     * @param elementName 要素名
     * @param clazz       変換対象
     * @return レスポンス
     */
    public static <T> T loadMasterAsTypedArray(String elementName, Class<T> clazz) {
        return new Gson().fromJson(loadMasterAsArray(elementName), clazz);
    }

}
