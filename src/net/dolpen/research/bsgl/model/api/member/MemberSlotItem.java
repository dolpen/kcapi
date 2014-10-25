package net.dolpen.research.bsgl.model.api.member;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import net.dolpen.research.bsgl.api.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 所持装備
 */
public class MemberSlotItem extends Member {

    @SerializedName("api_id")
    public int slotId; // 装備メンバID

    @SerializedName("api_slotitem_id")
    public int weaponId; // 装備マスタID

    @SerializedName("api_locked")
    public int locked; // ロック

    @SerializedName("api_level")
    public int level; // 改修レベル



    public String toString() {
        return String.format("%d : %d", slotId, weaponId);
    }

    public static Map<Integer, MemberSlotItem> toIdMap(List<MemberSlotItem> list) {
        Map<Integer, MemberSlotItem> m = Maps.newHashMap();
        for (MemberSlotItem e : list) {
            m.put(e.slotId, e);
        }
        return m;
    }

    public static List<MemberSlotItem> cache() {
        return Arrays.asList(loadTypedArray("/inputs/member/slotitem.txt", MemberSlotItem[].class));
    }
}
