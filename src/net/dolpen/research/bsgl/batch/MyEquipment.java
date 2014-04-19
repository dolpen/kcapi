package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.dolpen.research.bsgl.model.compiled.Deck;
import net.dolpen.research.bsgl.model.master.ShipTypeMaster;
import net.dolpen.research.bsgl.model.master.SlotItemMaster;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;
import net.dolpen.research.bsgl.util.groovy.View;

import java.util.List;
import java.util.Map;

public class MyEquipment {

    public static void main(String... args) throws Exception {


        ShipTypeMaster shipTypeMaster = ShipTypeMaster.cache();
        SlotItemMaster slotItemMaster = SlotItemMaster.cache();
        InventoryShip inventoryShip = InventoryShip.cache();
        InventorySlotItem inventorySlotItem = InventorySlotItem.cache();

        Deck deck = Deck.build(shipTypeMaster, slotItemMaster, inventorySlotItem, inventoryShip);
        View.renderFile(
                "/templates/myequipment.html",
                ImmutableMap.<String, Object>builder()
                        .put("items", deck.slotItems)
                        .build(),
                "/outputs/myequipment.html"
        );
    }
}
