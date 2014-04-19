package net.dolpen.research.bsgl.model.compiled;

import net.dolpen.research.bsgl.model.master.ShipTypeMaster;
import net.dolpen.research.bsgl.model.master.SlotItemMaster;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 鎮守府全般
 */
public class Deck {


    public List<ShipType> shipTypes;
    public List<SlotItem> slotItems;

    public List<Ship> ships;
    public List<Equipment> equipments;

    public static Deck build(ShipTypeMaster shipTypeMaster, SlotItemMaster slotItemMaster, InventorySlotItem inventorySlotItem, InventoryShip inventoryShip) {
        Deck resp = new Deck();
        resp.shipTypes = ShipType.buildList(shipTypeMaster);
        resp.slotItems = SlotItem.buildList(slotItemMaster);

        resp.equipments = Equipment.buildList(inventorySlotItem);
        resp.ships = Ship.buildList(inventoryShip, inventorySlotItem);


        Map<Integer, SlotItem> slotItemMap = SlotItem.toIdMap(resp.slotItems);
        Map<Integer, ShipType> shipTypeMap = ShipType.toIdMap(resp.shipTypes);
        Map<Integer, Equipment> equipmentMap = Equipment.toLocalIdMap(resp.equipments);
        for (Ship s : resp.ships) {
            ShipType t = shipTypeMap.get(s.raw.api_stype);
            s.type = t; // ship <-> stype
            t.ships.add(s);
            for (int eid : s.raw.api_slot) {
                if (eid < 0) continue;
                Equipment e = equipmentMap.get(eid); // ship <-> equipment
                s.equipments.add(e);
                e.ship = s;
            }
        }
        for (Equipment e : resp.equipments) { // slotitem <-> equipment
            SlotItem s = slotItemMap.get(e.itemId);
            s.equipments.add(e);
            s.amount++;
            e.info = s;
        }
        Collections.sort(resp.ships, new Comparator<Ship>() {
            @Override
            public int compare(Ship o1, Ship o2) {
                return o2.exp - o1.exp;
            }
        });
        return resp;
    }


}
