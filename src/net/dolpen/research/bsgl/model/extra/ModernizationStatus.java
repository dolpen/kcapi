package net.dolpen.research.bsgl.model.extra;

/**
 * 近代化改修ステータス
 */
public class ModernizationStatus {

    public int current;
    public int max;

    public ModernizationStatus(int current, int max) {
        this.current = current;
        this.max = max;
    }

    public boolean isFinished() { // has...
        return current >= max;
    }

    public String toString() {
        return String.format("%d/%d", current, max);
    }

}
