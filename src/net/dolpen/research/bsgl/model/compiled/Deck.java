package net.dolpen.research.bsgl.model.compiled;

import net.dolpen.research.bsgl.model.api.master.ShipMaster;
import net.dolpen.research.bsgl.model.api.master.ShipTypeMaster;
import net.dolpen.research.bsgl.model.api.master.SlotItemMaster;
import net.dolpen.research.bsgl.model.api.member.InventoryShip;
import net.dolpen.research.bsgl.model.api.member.InventorySlotItem;

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

    public static Deck build(ShipTypeMaster shipTypeMaster, ShipMaster shipMaster, SlotItemMaster slotItemMaster, InventorySlotItem inventorySlotItem, InventoryShip inventoryShip) {
        Deck resp = new Deck();
        resp.shipTypes = ShipType.buildList(shipTypeMaster);
        resp.slotItems = SlotItem.buildList(slotItemMaster);

        resp.equipments = Equipment.buildList(inventorySlotItem, slotItemMaster);
        resp.ships = Ship.buildList(inventoryShip, inventorySlotItem, shipMaster, slotItemMaster);


        Map<Integer, SlotItem> slotItemMap = SlotItem.toIdMap(resp.slotItems);
        Map<Integer, ShipType> shipTypeMap = ShipType.toIdMap(resp.shipTypes);
        Map<Integer, Equipment> equipmentMap = Equipment.toLocalIdMap(resp.equipments);
        Map<Integer, ShipMaster.Content> shipMasterMap = shipMaster.toIdMap();
        for (Ship s : resp.ships) {
            ShipMaster.Content c = shipMasterMap.get(s.raw.api_ship_id);
            ShipType t = shipTypeMap.get(c.api_stype);
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
