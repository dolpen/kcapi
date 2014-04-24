package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.MasterSlotItem;
import net.dolpen.research.bsgl.model.api.member.MemberSlotItem;

import java.util.List;
import java.util.Map;

/**
 * 個別装備データ
 */
public class SlotItem {

    public int slotId; // local slotId

    public int weaponId; // item slotId

    public String name; // item name

    public int sight;

    public int firePower;

    public int torpedo;

    public int antiAir;

    public int armor;

    public int evasion;

    public int antiSub;

    public int luck;

    public Ship ship;

    public Weapon info;

    MemberSlotItem raw;

    public static SlotItem build(MemberSlotItem item, Map<Integer, MasterSlotItem> masterSlotItemMap) {
        SlotItem resp = new SlotItem();
        MasterSlotItem master = masterSlotItemMap.get(item.weaponId);
        resp.slotId = item.slotId;
        resp.weaponId = item.weaponId;
        resp.name = master.name;
        resp.sight = master.sight;
        resp.firePower = master.firePower;
        resp.torpedo = master.torpedo;
        resp.antiAir = master.antiAir;
        resp.armor = master.armor;
        resp.evasion = master.evasion;
        resp.antiSub = master.antiSub;
        resp.luck = master.luck;
        resp.raw = item;
        return resp;
    }

    public static List<SlotItem> buildList(List<MemberSlotItem> memberSlotItemList, Map<Integer, MasterSlotItem> masterSlotItemMap) {
        List<SlotItem> resp = Lists.newArrayList();
        for (MemberSlotItem e : memberSlotItemList) {
            resp.add(build(e, masterSlotItemMap));
        }
        return resp;
    }

    public static Map<Integer, SlotItem> toLocalIdMap(List<SlotItem> l) {
        Map<Integer, SlotItem> resp = Maps.newHashMap();
        for (SlotItem e : l) resp.put(e.slotId, e);
        return resp;
    }
}
