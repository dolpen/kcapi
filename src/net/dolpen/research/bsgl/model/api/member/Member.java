package net.dolpen.research.bsgl.model.api.member;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import net.dolpen.research.bsgl.model.api.Common;

/**
 * ユーザーデータ
 */
public class Member extends Common {


    /**
     * ユーザーデータを得る
     *
     *
     * @param elementName 要素名
     * @return データセット
     */
    protected static JsonArray loadMember(String elementName) {
        return loadApiData("/inputs/member/port.txt")
                .getAsJsonArray(elementName);
    }

    /**
     * 対応する型を指定し、データを得る
     *
     * @param elementName 要素名
     * @param clazz       変換対象
     * @return レスポンス
     */
    public static <T> T loadMemberTyped(String elementName, Class<T> clazz) {
        return new Gson().fromJson(loadMember(elementName), clazz);
    }
}
