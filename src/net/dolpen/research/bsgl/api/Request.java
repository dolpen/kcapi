package net.dolpen.research.bsgl.api;

import com.google.common.collect.ImmutableMap;
import net.dolpen.research.bsgl.util.crawl.Connection;

import java.util.Map;

public class Request {
    /**
     * パラメータとか
     */
    public static final String API_BASE = "http://125.6.187.205/kcsapi";
    public static final String API_REF = "http://125.6.187.205/kcs/port.swf?version=";
    public static final String API_VERSION = "1";
    public static final String API_TOKEN = "";
    public static final Map<String, String> API_PARAMS = ImmutableMap.<String, String>builder().put("api_verno", API_VERSION).put("api_token", API_TOKEN).build();

    /**
     * リクエスト
     *
     * @param path パス
     * @return 接続用オブジェクト
     */
    public static Connection connect(String path) {
        return new Connection(API_BASE + path).referrer(API_REF).query(API_PARAMS);
    }

    /**
     * レスポンスフィルター
     *
     * @param str 入力
     * @return 出力
     */
    public static String filter(String str) {
        return str.replace("svdata=", "");
    }

    /**
     * getしてレスポンスを得る
     *
     * @param path  path
     * @param param パラメータ
     * @return レスポンス
     */
    public static String getJson(String path, Map<String, String> param) {
        Connection c = connect(path);
        try {
            if (param == null || param.isEmpty()) return filter(c.getBody());
            return filter(c.query(param).getBody());
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * postしてレスポンスを得る
     *
     * @param path  path
     * @param param パラメータ
     * @return レスポンス
     */
    public static String postJson(String path, Map<String, String> param) {
        Connection c = connect(path);
        try {
            if (param == null || param.isEmpty()) return filter(c.postBody());
            return filter(c.query(param).postBody());
        } catch (Exception e) {
        }
        return "";
    }
}
