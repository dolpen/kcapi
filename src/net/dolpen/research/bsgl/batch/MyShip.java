package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import net.dolpen.research.bsgl.model.compiled.Deck;
import net.dolpen.research.bsgl.model.compiled.Ship;
import net.dolpen.research.bsgl.model.master.ShipTypeMaster;
import net.dolpen.research.bsgl.model.master.SlotItemMaster;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;
import net.dolpen.research.bsgl.util.groovy.View;

import java.util.Collections;
import java.util.Comparator;

public class MyShip {

    public static void main(String... args) throws Exception {

        ShipTypeMaster shipTypeMaster = ShipTypeMaster.cache();
        SlotItemMaster slotItemMaster = SlotItemMaster.cache();
        InventoryShip inventoryShip = InventoryShip.cache();
        InventorySlotItem inventorySlotItem = InventorySlotItem.cache();

        Deck deck = Deck.build(shipTypeMaster, slotItemMaster, inventorySlotItem, inventoryShip);
        Collections.sort(deck.ships, new Comparator<Ship>() {
            @Override
            public int compare(Ship o1, Ship o2) {
                // sort by exp(level)
                return o2.exp - o1.exp;
            }
        });
        View.renderFile(
                "/templates/myship.html",
                ImmutableMap.<String, Object>builder()
                        .put("ships", deck.ships)
                        .build(),
                "/outputs/myship.html"
        );
    }
}
