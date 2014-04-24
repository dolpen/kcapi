package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.MasterSlotItem;
import net.dolpen.research.bsgl.model.enums.Range;

import java.util.List;
import java.util.Map;

/**
 * view向けSlotItemMaster
 */
public class SlotItem {

    public int itemId;

    public String name;

    public Range range;

    public int sight;

    public int fire;

    public int torpedo;

    public int air;

    public int armor;

    public int evasion;

    public int sub;

    public int luck;

    public int amount;

    public List<Equipment> equipments;

    MasterSlotItem raw;

    public static SlotItem build(MasterSlotItem item) {
        SlotItem resp = new SlotItem();
        resp.itemId = item.equipmentId;
        resp.name = item.name;
        resp.sight = item.sight;
        resp.fire = item.firepower;
        resp.torpedo = item.torpedo;
        resp.air = item.antiAir;
        resp.armor = item.armor;
        resp.sub = item.antiSub;
        resp.evasion = item.evasion;
        resp.luck = item.luck;
        resp.range = Range.by(item.range);
        resp.amount = 0;
        resp.equipments = Lists.newArrayList();
        resp.raw = item;
        return resp;
    }

    public static List<SlotItem> buildList(List<MasterSlotItem> masterSlotItemList) {
        List<SlotItem> resp = Lists.newArrayList();
        for (MasterSlotItem e : masterSlotItemList) resp.add(build(e));
        return resp;
    }

    public static Map<Integer, SlotItem> toIdMap(List<SlotItem> l) {
        Map<Integer, SlotItem> resp = Maps.newHashMap();
        for (SlotItem e : l) resp.put(e.itemId, e);
        return resp;
    }

    public String getOwnerNames() {
        StringBuilder sb = new StringBuilder();
        boolean b = false;
        for (Equipment e : equipments) {
            if (e.ship == null) continue;
            if (b) sb.append("\n");
            sb.append(e.ship.name);
            b = true;
        }
        return sb.toString();
    }
}
