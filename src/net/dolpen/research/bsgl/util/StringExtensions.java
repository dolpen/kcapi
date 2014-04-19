package net.dolpen.research.bsgl.util;

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
