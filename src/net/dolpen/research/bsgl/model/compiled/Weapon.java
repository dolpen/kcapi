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
public class Weapon {

    public int weaponId;

    public String name;

    public Range range;

    public int sight;

    public int firePower;

    public int torpedo;

    public int antiAir;

    public int armor;

    public int evasion;

    public int antiSub;

    public int luck;

    public int amount;

    public List<SlotItem> slots;

    MasterSlotItem raw;

    public static Weapon build(MasterSlotItem item) {
        Weapon resp = new Weapon();
        resp.weaponId = item.weaponId;
        resp.name = item.name;
        resp.sight = item.sight;
        resp.firePower = item.firePower;
        resp.torpedo = item.torpedo;
        resp.antiAir = item.antiAir;
        resp.armor = item.armor;
        resp.antiSub = item.antiSub;
        resp.evasion = item.evasion;
        resp.luck = item.luck;
        resp.range = Range.by(item.range);
        resp.amount = 0;
        resp.slots = Lists.newArrayList();
        resp.raw = item;
        return resp;
    }

    public static List<Weapon> buildList(List<MasterSlotItem> masterSlotItemList) {
        List<Weapon> resp = Lists.newArrayList();
        for (MasterSlotItem e : masterSlotItemList) resp.add(build(e));
        return resp;
    }

    public static Map<Integer, Weapon> toIdMap(List<Weapon> l) {
        Map<Integer, Weapon> resp = Maps.newHashMap();
        for (Weapon e : l) resp.put(e.weaponId, e);
        return resp;
    }

    public String getOwnerNames() {
        StringBuilder sb = new StringBuilder();
        boolean b = false;
        for (SlotItem e : slots) {
            if (e.ship == null) continue;
            if (b) sb.append("\n");
            sb.append(e.ship.name);
            b = true;
        }
        return sb.toString();
    }
}
