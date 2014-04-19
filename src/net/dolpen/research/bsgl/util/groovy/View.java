package net.dolpen.research.bsgl.util.groovy;

import com.google.common.collect.Maps;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;
import net.dolpen.research.bsgl.util.Const;
import net.dolpen.research.bsgl.util.StringExtensions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class View {

    private static final Map<String, Template> cache = Maps.newHashMap();

    /**
     * 指定されたpathでテンプレートファイルをロードする、キャッシュは自動
     *
     * @param path ファイルパス
     * @return テンプレート
     */
    private static Template loadTemplate(String path) {
        Template cached = cache.get(path);
        if (cached != null) return cached;
        File file = new File(path);
        SimpleTemplateEngine ste = new SimpleTemplateEngine();
        Template loaded = null;
        try {
            loaded = ste.createTemplate(file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        cache.put(path, loaded);
        return loaded;
    }

    /**
     * mutableなbind用mapの生成
     *
     * @param params immutableかもしれないパラメータ
     * @return 同内容のmap
     */
    private static Map<String, Object> wrapParams(Map<String, Object> params) {
        Map<String, Object> binding = Maps.newHashMap();
        if (params != null) binding.putAll(params);
        binding.put("_", StringExtensions.getInstance());
        return binding;
    }

    /**
     * テキストをレンダリングする
     *
     * @param path   テンプレートのパス
     * @param params パラメータ
     * @return レンダリング結果
     */
    public static String renderString(String path, Map<String, Object> params) {
        return loadTemplate(Const.ROOT + path).make(wrapParams(params)).toString();
    }


    /**
     * テキストをレンダリングする
     *
     * @param path     テンプレートのパス
     * @param params   パラメータ
     * @param filename 書き込み先
     */
    public static void renderFile(String path, Map<String, Object> params, String filename) {
        try {
            loadTemplate(Const.ROOT + path)
                    .make(wrapParams(params)).writeTo(new FileWriter(Const.ROOT + filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
