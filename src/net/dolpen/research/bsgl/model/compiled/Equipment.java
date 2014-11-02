package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.member.MemberSlotItem;

import java.util.List;
import java.util.Map;

/**
 * 個別装備データ
 */
public class Equipment {

    public int equipmentId; // local equipmentId

    public int weaponId; // item equipmentId

    public boolean locked;

    public int level;

    public Girl girl;

    public Weapon weapon;

    MemberSlotItem raw;

    public static Equipment build(MemberSlotItem item, Map<Integer, Weapon> weaponMap) {
        Equipment resp = new Equipment();
        resp.equipmentId = item.slotId;
        resp.weaponId = item.weaponId;
        resp.locked = item.locked == 1;
        resp.level = item.level;
        resp.raw = item;
        Weapon weapon = weaponMap.get(item.weaponId);
        resp.weapon = weapon;
        weapon.countUp();
        return resp;
    }

    public static List<Equipment> buildList(List<MemberSlotItem> memberSlotItemList, Map<Integer, Weapon> weaponMap) {
        List<Equipment> resp = Lists.newArrayList();
        for (MemberSlotItem e : memberSlotItemList) resp.add(build(e, weaponMap));
        return resp;
    }

    public static Map<Integer, Equipment> toIdMap(List<Equipment> equipmentList) {
        Map<Integer, Equipment> resp = Maps.newHashMap();
        for (Equipment e : equipmentList) resp.put(e.equipmentId, e);
        return resp;
    }

}
