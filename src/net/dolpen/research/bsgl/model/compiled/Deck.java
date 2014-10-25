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

    public List<Girl> girls;

    public List<SlotItem> slotItems;

    public static Deck build() {
        Deck resp = new Deck();
        // マスタデータの取得
        List<MasterShipType> masterShipTypeList = MasterShipType.cache();
        List<MasterShip> masterShipList = MasterShip.cache();
        List<MasterSlotItem> masterSlotItemList = MasterSlotItem.cache();

        // ユーザーデータの取得
        List<MemberShip> memberShipList = MemberShip.cache();
        List<MemberSlotItem> memberSlotItemList = MemberSlotItem.cache();

        // 兵装関連
        resp.weapons = Weapon.buildList(masterSlotItemList); // 兵装マスタ
        resp.slotItems = SlotItem.buildList(memberSlotItemList); // 所持兵装
        SlotItem.attachAll(resp.slotItems, Weapon.toIdMap(resp.weapons)); // 所持兵装<->兵装マスタの解決
        Collections.sort(resp.slotItems,new Comparator<SlotItem>() {
            @Override
            public int compare(SlotItem o1, SlotItem o2) {
                return o1.weaponId - o2.weaponId;
            }
        });
        // 艦種関連
        resp.shipTypes = ShipType.buildList(masterShipTypeList); // 艦種マスタ
        resp.ships = Ship.buildList(masterShipList); // 艦船マスタ
        Ship.attachAll(resp.ships, ShipType.toIdMap(resp.shipTypes)); // 艦船マスタ <-> 艦種マスタの解決
        resp.girls = Girl.buildList(memberShipList); // 所持艦
        Girl.attachMasterAll(resp.girls, Ship.toIdMap(resp.ships));  // 所持艦 <-> 艦船マスタの解決
        Girl.attachSlotItemAll(resp.girls, SlotItem.toLocalIdMap(resp.slotItems));// 所持艦 <-> 所持兵装の解決

        // LV順の並び替え
        Collections.sort(resp.girls, new Comparator<Girl>() {
            @Override
            public int compare(Girl o1, Girl o2) {
                return o2.exp - o1.exp;
            }
        });

        return resp;
    }
}
