package net.dolpen.research.bsgl.model.enums;

/**
 * 射程
 */
public enum Range {

    UNKNOWN(0, "不明"),
    SHORT(1, "短"),
    MIDDLE(2, "中"),
    LONG(3, "長"),
    FAR(4, "超");

    private int code;

    private String label;

    private Range(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static Range by(int code) {
        for (Range r : values()) {
            if (r.code == code) return r;
        }
        return UNKNOWN;
    }
}
