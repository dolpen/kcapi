package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.SlotItemMaster;
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
    SlotItemMaster.Entry raw;

    public static SlotItem build(SlotItemMaster.Entry e) {
        SlotItem resp = new SlotItem();
        resp.itemId = e.api_id;
        resp.name = e.api_name;
        resp.sight = e.api_saku;
        resp.fire = e.api_houg;
        resp.torpedo = e.api_raig;
        resp.air = e.api_tyku;
        resp.armor = e.api_souk;
        resp.sub = e.api_tais;
        resp.evasion = e.api_houk;
        resp.luck = e.api_luck;
        resp.range = Range.by(e.api_leng);
        resp.amount = 0;
        resp.equipments = Lists.newArrayList();
        resp.raw = e;
        return resp;
    }

    public static List<SlotItem> buildList(SlotItemMaster s) {
        List<SlotItem> resp = Lists.newArrayList();
        for (SlotItemMaster.Entry e : s.api_data) resp.add(build(e));
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
