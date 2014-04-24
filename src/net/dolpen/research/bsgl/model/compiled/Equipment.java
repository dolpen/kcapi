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
public class Equipment {

    public int id; // local id

    public int itemId; // item id

    public String name; // item name

    public int sight;

    public int fire;

    public int torpedo;

    public int air;

    public int armor;

    public int evasion;

    public int sub;

    public int luck;

    public Ship ship;

    public SlotItem info;

    MemberSlotItem raw;

    public static Equipment build(MemberSlotItem item, Map<Integer, MasterSlotItem> masterSlotItemMap) {
        Equipment resp = new Equipment();
        MasterSlotItem master = masterSlotItemMap.get(item.equipmentId);
        resp.id = item.slotId;
        resp.itemId = item.equipmentId;
        resp.name = master.name;
        resp.sight = master.sight;
        resp.fire = master.firepower;
        resp.torpedo = master.torpedo;
        resp.air = master.antiAir;
        resp.armor = master.armor;
        resp.evasion = master.evasion;
        resp.sub = master.antiSub;
        resp.luck = master.luck;
        resp.raw = item;
        return resp;
    }

    public static List<Equipment> buildList(List<MemberSlotItem> memberSlotItemList, Map<Integer, MasterSlotItem> masterSlotItemMap) {
        List<Equipment> resp = Lists.newArrayList();
        for (MemberSlotItem e : memberSlotItemList) {
            resp.add(build(e, masterSlotItemMap));
        }
        return resp;
    }

    public static Map<Integer, Equipment> toLocalIdMap(List<Equipment> l) {
        Map<Integer, Equipment> resp = Maps.newHashMap();
        for (Equipment e : l) resp.put(e.id, e);
        return resp;
    }
}
