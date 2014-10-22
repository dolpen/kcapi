package net.dolpen.research.bsgl.model.api;

import com.google.gson.*;
import net.dolpen.research.bsgl.api.Cache;

/**
 * 基本的に全部のデータにくっつく感じ
 */
public class Common {
    public int api_result;
    public String api_result_msg;

    public boolean isSuccess() {
        return "成功".equals(api_result_msg);
    }

    /**
     * ファイルをロードし、中身のデータを展開する
     *
     * @param path パス
     * @return JsonObject
     */
    protected static JsonObject loadApiData(String path) {
        return new JsonParser().parse(Cache.load(path)).getAsJsonObject().getAsJsonObject("api_data");
    }

    /**
     * ファイルをロードし、中身のデータを展開する
     *
     * @param path パス
     * @return JsonObject
     */
    protected static JsonArray loadApiDataAsArray(String path) {
        return new JsonParser().parse(Cache.load(path)).getAsJsonObject().getAsJsonArray("api_data");
    }


    /**
     * ファイルをロードし、中身のデータを展開する
     *
     * @param path パス
     * @return JsonObject
     */
    protected static JsonArray loadApiListAsArray(String path) {
        return new JsonParser().parse(Cache.load(path)).getAsJsonObject().getAsJsonObject("api_data").getAsJsonArray("api_list");
    }


    /**
     * ファイルと対応する型を指定し、データを得る
     *
     * @param path  パス
     * @param clazz 変換対象
     * @return データ
     */
    public static <T> T loadTypedData(String path, Class<T> clazz) {
        return new Gson().fromJson(loadApiData(path), clazz);
    }


    /**
     * ファイルと対応する型を指定し、データを得る
     *
     * @param path  パス
     * @param clazz 変換対象
     * @return データ
     */
    public static <T> T loadTypedArray(String path, Class<T> clazz) {
        return new Gson().fromJson(loadApiDataAsArray(path), clazz);
    }


    /**
     * ファイルと対応する型を指定し、データを得る
     *
     * @param path  パス
     * @param clazz 変換対象
     * @return データ
     */
    public static <T> T loadTypedList(String path, Class<T> clazz) {
        return new Gson().fromJson(loadApiListAsArray(path), clazz);
    }
}
