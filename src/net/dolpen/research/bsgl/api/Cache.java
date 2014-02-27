package net.dolpen.research.bsgl.api;

import com.google.common.collect.ImmutableMap;
import net.dolpen.libs.crawl.Connection;
import net.dolpen.libs.stream.Streams;

import java.io.FileInputStream;
import java.util.Map;

public class Cache {
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
     * レスポンスを得る
     *
     * @param path path
     * @return レスポンス
     */
    public static String load(String path) {
        try {
            return filter(Streams.toString(new FileInputStream(path), "UTF-8"));
        } catch (Exception e) {
        }
        return "";
    }
}