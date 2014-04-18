package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;

import javax.sql.rowset.Joinable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * itemList
 */
public class IndexedItem {

    public int itemId; // item id

    public String name; // item name

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

    public List<Ship> ships;

    public String getOwnerNames() {
        StringBuilder sb = new StringBuilder();
        for (Ship s : ships) sb.append(s.name).append(" ");
        return sb.toString().trim();
    }


    public static IndexedItem build(InventorySlotItem.Entry e) {
        IndexedItem resp = new IndexedItem();
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
        resp.ships = Lists.newArrayList();
        resp.range = Range.by(e.api_leng);
        resp.amount = 0;
        return resp;
    }


    public static List<IndexedItem> buildList(InventoryShip inventoryShip, InventorySlotItem inventorySlotItem) {
        Map<Integer, InventorySlotItem.Entry> items = inventorySlotItem.toIdMap();
        Map<Integer, IndexedItem> itemMap = Maps.newHashMap();
        for (InventorySlotItem.Entry e : inventorySlotItem.api_data) {
            IndexedItem ii = itemMap.get(e.api_slotitem_id);
            if (ii == null) {
                ii = build(e);
                itemMap.put(e.api_slotitem_id, ii);
            }
            ii.amount++;
        }
        for (InventoryShip.Entry e : inventoryShip.api_data) {
            Ship s = Ship.build(e, items);
            for (int i : s.raw.api_slot) {
                if (i < 0) continue;
                IndexedItem ii = itemMap.get(items.get(i).api_slotitem_id);
                ii.ships.add(s);
            }
        }
        List<IndexedItem> indexedItems = Lists.newArrayList(itemMap.values());
        Collections.sort(indexedItems, new Comparator<IndexedItem>() {
            @Override
            public int compare(IndexedItem o1, IndexedItem o2) {
                return o2.itemId - o1.itemId;
            }
        });
        return indexedItems;
    }
}
