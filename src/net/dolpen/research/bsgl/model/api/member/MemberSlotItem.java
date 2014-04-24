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
    public int equipmentId; // 装備マスタID

    public String toString() {
        return String.format("%d : %d", slotId, equipmentId);
    }

    public static Map<Integer, MemberSlotItem> toIdMap(List<MemberSlotItem> list) {
        Map<Integer, MemberSlotItem> m = Maps.newHashMap();
        for (MemberSlotItem e : list) {
            m.put(e.equipmentId, e);
        }
        return m;
    }

    public static List<MemberSlotItem> cache() {
        String resp = Cache.load("/inputs/member/slotitem.txt");
        return Arrays.asList(
            new Gson().fromJson(
                new JsonParser().parse(resp).getAsJsonObject().getAsJsonArray("api_data").toString(),
                MemberSlotItem[].class
            )
        );
    }
}
