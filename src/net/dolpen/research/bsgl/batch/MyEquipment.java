package net.dolpen.research.bsgl.batch;

import com.beust.jcommander.internal.Lists;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.dolpen.research.bsgl.model.compiled.Ship;
import net.dolpen.research.bsgl.model.compiled.SlotItem;
import net.dolpen.research.bsgl.model.master.ShipType;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;
import net.dolpen.research.bsgl.util.Constructors;
import net.dolpen.research.bsgl.util.groovy.View;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MyEquipment {

    public static void main(String... args) throws Exception {
        Map<Integer, ShipType.Content> type = Maps.newHashMap();

        ShipType types = ShipType.cache();
        for (ShipType.Content c : types.api_data)
            type.put(c.api_id, c);

        InventoryShip inventoryShip = InventoryShip.cache();
        InventorySlotItem inventorySlotItem = InventorySlotItem.cache();
        List<Ship> ships = Ship.buildList(inventoryShip, inventorySlotItem);
        List<SlotItem> slotItems = SlotItem.buildList(inventorySlotItem);
        Constructors.appendItems(ships, slotItems);

        Map<Integer, List<SlotItem>> itemMap = Maps.newHashMap();
        for (SlotItem item : slotItems) {
            List<SlotItem> list = itemMap.get(item.itemId);
            if (list == null) {
                list = Lists.newArrayList();
                itemMap.put(item.itemId, list);
            }
            list.add(item);
        }
        List<Integer> keys = Lists.newArrayList(itemMap.keySet());
        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // sort by exp(level)
                return o1 - o2;
            }
        });
        View.renderFile(
                "/templates/myequipment.html",
                ImmutableMap.<String, Object>builder()
                        .put("keys", keys)
                        .put("items", itemMap)
                        .build(),
                "/outputs/myequipment.html"
        );
    }
}
