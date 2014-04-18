package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;

import java.util.List;

/**
 * コンパイル済み装備データ
 */
public class SlotItem {

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

    InventorySlotItem.Entry raw;

    public static SlotItem build(InventorySlotItem.Entry e) {
        SlotItem resp = new SlotItem();
        resp.raw = e;
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
        return resp;
    }

    public static List<SlotItem> buildList(InventorySlotItem inventorySlotItem) {
        List<SlotItem> resp = Lists.newArrayList();
        for (InventorySlotItem.Entry s : inventorySlotItem.api_data) {
            resp.add(build(s));
        }
        return resp;
    }
}
