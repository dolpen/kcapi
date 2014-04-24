package net.dolpen.research.bsgl.model.compiled;

import net.dolpen.research.bsgl.model.api.master.MasterShip;
import net.dolpen.research.bsgl.model.api.master.MasterShipType;
import net.dolpen.research.bsgl.model.api.master.MasterSlotItem;
import net.dolpen.research.bsgl.model.api.member.MemberShip;
import net.dolpen.research.bsgl.model.api.member.MemberSlotItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 鎮守府全般
 */
public class Deck {


    public List<ShipType> shipTypes;

    public List<Weapon> weapons;

    public List<Ship> ships;

    public List<SlotItem> equipments;

    public static Deck build() {
        Deck resp = new Deck();
        List<MemberShip> memberShipList = MemberShip.cache();
        List<MemberSlotItem> memberSlotItemList = MemberSlotItem.cache();

        List<MasterShipType> masterShipTypeList = MasterShipType.cache();
        List<MasterShip> masterShipList = MasterShip.cache();
        List<MasterSlotItem> masterSlotItemList = MasterSlotItem.cache();

        Map<Integer, MemberSlotItem> memberSlotItemMap = MemberSlotItem.toIdMap(memberSlotItemList);
        Map<Integer, MasterShip> masterShipMap = MasterShip.toIdMap(masterShipList);
        Map<Integer, MasterShipType> masterShipTypeMap = MasterShipType.toIdMap(masterShipTypeList);
        Map<Integer, MasterSlotItem> masterSlotItemMap = MasterSlotItem.toIdMap(masterSlotItemList);

        resp.shipTypes = ShipType.buildList(masterShipTypeList);
        resp.weapons = Weapon.buildList(masterSlotItemList);
        resp.equipments = SlotItem.buildList(memberSlotItemList, masterSlotItemMap);
        resp.ships = Ship.buildList(memberShipList, memberSlotItemMap, masterShipMap, masterSlotItemMap);

        Map<Integer, ShipType> shipTypeMap = ShipType.toIdMap(resp.shipTypes);
        Map<Integer, SlotItem> equipmentMap = SlotItem.toLocalIdMap(resp.equipments);
        Map<Integer, Weapon> slotItemMap = Weapon.toIdMap(resp.weapons);

        for (Ship ship : resp.ships) {
            MasterShip masterShip = masterShipMap.get(ship.raw.shipId);
            ShipType type = shipTypeMap.get(masterShip.type);
            ship.type = type; // ship <-> stype
            type.ships.add(ship);
            for (int slotId : ship.raw.slotIds) {
                if (slotId < 0) continue;
                SlotItem equipment = equipmentMap.get(slotId); // ship <-> equipment
                ship.equipments.add(equipment);
                equipment.ship = ship;
            }
        }
        for (SlotItem equipment : resp.equipments) { // slotitem <-> equipment
            Weapon item = slotItemMap.get(equipment.weaponId);
            item.slots.add(equipment);
            item.amount++;
            equipment.info = item;
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
