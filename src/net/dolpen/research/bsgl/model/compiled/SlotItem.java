package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.member.MemberSlotItem;

import java.util.List;
import java.util.Map;

/**
 * 個別装備データ
 */
public class SlotItem {

    public int slotId; // local slotId

    public int weaponId; // item slotId

    public boolean locked;

    public int level;

    public Girl girl;

    public Weapon weapon;

    MemberSlotItem raw;

    public static SlotItem build(MemberSlotItem item) {
        SlotItem resp = new SlotItem();
        resp.slotId = item.slotId;
        resp.weaponId = item.weaponId;
        resp.locked = item.locked == 1;
        resp.level = item.level;
        resp.raw = item;
        return resp;
    }

    public static List<SlotItem> buildList(List<MemberSlotItem> memberSlotItemList) {
        List<SlotItem> resp = Lists.newArrayList();
        for (MemberSlotItem e : memberSlotItemList) resp.add(build(e));
        return resp;
    }

    public static Map<Integer, SlotItem> toLocalIdMap(List<SlotItem> slotItemList) {
        Map<Integer, SlotItem> resp = Maps.newHashMap();
        for (SlotItem e : slotItemList) resp.put(e.slotId, e);
        return resp;
    }

    public static void attachAll(List<SlotItem> slotItemList, Map<Integer, Weapon> weaponMap) {
        for (SlotItem e : slotItemList) e.attach(weaponMap.get(e.weaponId));
    }

    private void attach(Weapon weapon) {
        this.weapon = weapon;
        weapon.slots.add(this);
        weapon.amount++;
    }
}
