package net.dolpen.libs.stream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 */
public class Streams {
    /**
     * InputStream -> String
     *
     * @param inputStream
     * @param charset
     * @return
     * @throws IOException
     */
    public static String toString(InputStream inputStream, String charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuilder builder = new StringBuilder();
        char[] buf = new char[1024];
        int numRead;
        while (0 <= (numRead = reader.read(buf))) {
            builder.append(buf, 0, numRead);
        }
        return builder.toString();
    }

    public static InputStream ignoreUtf8Bom(InputStream is, String charSet) throws IOException {
        if (!charSet.toUpperCase().equals("UTF-8")) return is;
        if (!is.markSupported()) {
            is = new BufferedInputStream(is);
        }
        is.mark(3);
        if (is.available() >= 3) {
            byte b[] = {0, 0, 0};
            is.read(b, 0, 3);
            if (b[0] != (byte) 0xEF || b[1] != (byte) 0xBB || b[2] != (byte) 0xBF) {
                is.reset();
            }
        }
        return is;
    }
}
