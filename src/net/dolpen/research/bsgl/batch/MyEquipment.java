package net.dolpen.research.bsgl.batch;

import com.beust.jcommander.internal.Lists;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.dolpen.research.bsgl.model.compiled.IndexedItem;
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
        List<IndexedItem> items = IndexedItem.buildList(inventoryShip,inventorySlotItem);
        View.renderFile(
                "/templates/myequipment.html",
                ImmutableMap.<String, Object>builder()
                        .put("items", items)
                        .build(),
                "/outputs/myequipment.html"
        );
    }
}
