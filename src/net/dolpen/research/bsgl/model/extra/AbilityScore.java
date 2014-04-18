package net.dolpen.research.bsgl.model.extra;

/**
 * 艦船ステータス
 */
public class AbilityScore {

    public int current; // Lv100より上だとmaxより大きくなる

    public int max; // 近代化最大値

    public int itemScore; // 装備補正値

    public AbilityScore(int current, int max, int itemScore) {
        this.current = current - itemScore;
        this.max = max;
        this.itemScore = itemScore;
    }

    // 近代化改修最大値到達
    public boolean isFinished() { // has...
        return current >= max;
    }

    public String toString() {
        if (itemScore > 0)
            return String.format("%d/%d(+%d)", current, max, itemScore);
        return String.format("%d/%d", current, max);
    }

}
