package net.dolpen.research.bsgl.util;

import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.util.groovy.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 文字列操作系
 */
public class StringExtensions {

    private static StringExtensions instance;

    public static StringExtensions getInstance() {
        if (instance == null) instance = new StringExtensions();
        return instance;
    }

    public String include(String path, Map<String, Object> params) {
        if (params == null) return View.renderString(path, new HashMap<String, Object>());
        return View.renderString(path, params);
    }

    public String h(Object o) {
        return h(o.toString());
    }

    public String h(String str) {
        return str
                .replaceAll("&", "&amp;")
                .replaceAll(" ", "&nbsp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;");
    }

    public String nl2br(Object o) {
        return h(o).replaceAll("\n", "<br />");
    }
}
