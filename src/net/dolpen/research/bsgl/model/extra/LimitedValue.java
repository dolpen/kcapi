package net.dolpen.research.bsgl.model.extra;

/**
 * 制約付きデータ
 */
public class LimitedValue {

    public int current;
    public int maxValue;
    public int minValue;

    public LimitedValue(int current, int max, int min) {
        this.maxValue = max;
        this.minValue = min;
        this.current = Math.max(Math.min(current, max), min);
    }

    public boolean isMaximum() {
        return current >= maxValue;
    }

    public boolean isMinimum() {
        return current <= minValue;
    }

    public String toString() {
        return String.format("%d/%d", current, maxValue);
    }
}
