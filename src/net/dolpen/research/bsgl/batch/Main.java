package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import net.dolpen.research.bsgl.model.compiled.Deck;
import net.dolpen.research.bsgl.model.api.master.ShipTypeMaster;
import net.dolpen.research.bsgl.model.api.master.SlotItemMaster;
import net.dolpen.research.bsgl.model.api.member.InventoryShip;
import net.dolpen.research.bsgl.model.api.member.InventorySlotItem;
import net.dolpen.research.bsgl.util.groovy.View;

/**
 * All
 */
public class Main {

    public static void main(String... args) throws Exception {
        ShipTypeMaster shipTypeMaster = ShipTypeMaster.cache();
        SlotItemMaster slotItemMaster = SlotItemMaster.cache();
        InventoryShip inventoryShip = InventoryShip.cache();
        InventorySlotItem inventorySlotItem = InventorySlotItem.cache();

        Deck deck = Deck.build(shipTypeMaster, slotItemMaster, inventorySlotItem, inventoryShip);

        View.renderHtmlFile(
                "/templates/myship.html",
                ImmutableMap.<String, Object>builder()
                        .put("ships", deck.ships)
                        .build(),
                "/outputs/myship.html"
        );

        View.renderHtmlFile(
                "/templates/myequipment.html",
                ImmutableMap.<String, Object>builder()
                        .put("items", deck.slotItems)
                        .build(),
                "/outputs/myequipment.html"
        );
    }
}
