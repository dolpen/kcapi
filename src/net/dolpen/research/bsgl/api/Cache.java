package net.dolpen.research.bsgl.api;

import net.dolpen.research.bsgl.util.Const;
import net.dolpen.research.bsgl.util.Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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
            return filter(Streams.toString(new FileInputStream(Const.ROOT + path), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * レスポンスフィルター解除
     *
     * @param str 入力
     * @return 出力
     */
    public static String unfilter(String str) {
        return "svdata=" + str;
    }

    /**
     * レスポンスをキャッシュする
     *
     * @param path
     * @param content
     */
    public static void save(String path, String content) {
        try {
            Streams.fromString(new FileOutputStream(Const.ROOT + path), unfilter(content), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}