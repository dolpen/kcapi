package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.dolpen.research.bsgl.model.compiled.Ship;
import net.dolpen.research.bsgl.model.master.ShipType;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;
import net.dolpen.research.bsgl.util.groovy.View;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MyShip {

    public static void main(String... args) throws Exception {
        Map<Integer, ShipType.Content> type = Maps.newHashMap();

        ShipType types = ShipType.cache();
        for (ShipType.Content c : types.api_data)
            type.put(c.api_id, c);

        InventoryShip inventoryShip = InventoryShip.cache();
        InventorySlotItem inventorySlotItem = InventorySlotItem.cache();
        List<Ship> ships = Ship.buildList(inventoryShip,inventorySlotItem);


        Collections.sort(ships, new Comparator<Ship>() {
            @Override
            public int compare(Ship o1, Ship o2) {
                // sort by exp(level)
                return o2.exp - o1.exp;
            }
        });
        View.renderFile(
                "/templates/myship.html",
                ImmutableMap.<String, Object>builder()
                        .put("type", type)
                        .put("list", ships)
                        .build(),
                "/outputs/myship.html"
        );
    }
}
