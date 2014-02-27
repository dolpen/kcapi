package net.dolpen.libs.crawl;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import net.dolpen.libs.stream.Streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

/**
 * メソッドチェインでなんでもロードできるすごいやつ
 */
public class Connection {
    private String url;
    private String ref = null;
    private Map<String, String> q;
    private static String ENCODING = "UTF-8";
    private static String UA = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36";

    public Connection(String url) {
        q = Maps.newHashMap();
        this.url = url;
    }

    public Connection query(Map<String, String> q) {
        this.q.putAll(q);
        return this;
    }

    public Connection query(String key, String param) {
        this.q.put(key, param);
        return this;
    }

    public Connection referrer(String referer) {
        ref = referer;
        return this;
    }


    public String getBody() throws IOException {
        String qstr = encodeQuery(q);
        URL u = new URL(url + (qstr != null ? "?" : "") + qstr);
        URLConnection c = u.openConnection();
        c.addRequestProperty("User-Agent", UA);
        if (ref != null) c.addRequestProperty("Referer", ref);
        String encoding = Objects.firstNonNull(ENCODING, c.getContentEncoding());
        InputStream in = Streams.ignoreUtf8Bom(c.getInputStream(), encoding);
        return Streams.toString(in, encoding);
    }

    public String postBody() throws IOException {
        URL u = new URL(url);
        URLConnection c = u.openConnection();
        c.addRequestProperty("User-Agent", UA);
        if (ref != null) c.addRequestProperty("Referer", ref);
        c.setDoOutput(true);
        OutputStream os = c.getOutputStream();//POST用のOutputStreamを取得
        PrintStream ps = new PrintStream(os);
        ps.print(encodeQuery(q));//データをPOSTする
        ps.close();
        String encoding = Objects.firstNonNull(ENCODING, c.getContentEncoding());
        InputStream in = Streams.ignoreUtf8Bom(c.getInputStream(), encoding);
        return Streams.toString(in, encoding);
    }

    private static String encodeQuery(Map<String, String> q) {
        if (q == null || q.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        try {
            for (Map.Entry<String, String> e : q.entrySet()) {
                sb.append(first ? "" : "&");
                first = false;
                sb.append(URLEncoder.encode(e.getKey(), ENCODING))
                        .append("=")
                        .append(URLEncoder.encode(e.getValue(), ENCODING));
            }
        } catch (Exception e) {
            return "";
        }
        return sb.toString();
    }
}
