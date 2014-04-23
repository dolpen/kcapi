package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.SlotItemMaster;
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
    public Ship ship;
    public SlotItem info;
    InventorySlotItem.Entry raw;

    public static Equipment build(InventorySlotItem.Entry e, Map<Integer, SlotItemMaster.Entry> im) {
        Equipment resp = new Equipment();
        SlotItemMaster.Entry item = im.get(e.api_slotitem_id);
        resp.id = e.api_id;
        resp.itemId = e.api_slotitem_id;
        resp.name = item.api_name;
        resp.sight = item.api_saku;
        resp.fire = item.api_houg;
        resp.torpedo = item.api_raig;
        resp.air = item.api_tyku;
        resp.armor = item.api_souk;
        resp.evasion = item.api_houk;
        resp.sub = item.api_tais;
        resp.luck = item.api_luck;
        resp.raw = e;
        return resp;
    }

    public static List<Equipment> buildList(InventorySlotItem s, SlotItemMaster imst) {
        List<Equipment> resp = Lists.newArrayList();
        Map<Integer, SlotItemMaster.Entry> im = imst.toIdMap();
        for (InventorySlotItem.Entry e : s.api_data) {
            resp.add(build(e, im));
        }
        return resp;
    }

    public static Map<Integer, Equipment> toLocalIdMap(List<Equipment> l) {
        Map<Integer, Equipment> resp = Maps.newHashMap();
        for (Equipment e : l) resp.put(e.id, e);
        return resp;
    }
}
