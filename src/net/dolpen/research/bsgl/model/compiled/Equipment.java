package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.member.InventorySlotItem;

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

    InventorySlotItem.Entry raw;

    public Ship ship;

    public SlotItem info;

    public static Equipment build(InventorySlotItem.Entry e) {
        Equipment resp = new Equipment();
        resp.id = e.api_id;
        resp.itemId = e.api_slotitem_id;
        resp.name = e.api_name;
        resp.sight = e.api_saku;
        resp.fire = e.api_houg;
        resp.torpedo = e.api_raig;
        resp.air = e.api_tyku;
        resp.armor = e.api_souk;
        resp.evasion = e.api_kaih;
        resp.sub = e.api_tais;
        resp.luck = e.api_luck;
        resp.raw = e;
        return resp;
    }

    public static List<Equipment> buildList(InventorySlotItem s) {
        List<Equipment> resp = Lists.newArrayList();
        for (InventorySlotItem.Entry e : s.api_data) {
            resp.add(build(e));
        }
        return resp;
    }

    public static Map<Integer, Equipment> toLocalIdMap(List<Equipment> l) {
        Map<Integer, Equipment> resp = Maps.newHashMap();
        for (Equipment e : l) resp.put(e.id, e);
        return resp;
    }
}
