package net.dolpen.research.bsgl.model.compiled;

import net.dolpen.research.bsgl.model.api.master.MasterShip;
import net.dolpen.research.bsgl.model.api.master.MasterShipType;
import net.dolpen.research.bsgl.model.api.master.MasterWeapon;
import net.dolpen.research.bsgl.model.api.master.MasterWeaponType;
import net.dolpen.research.bsgl.model.api.member.MemberShip;
import net.dolpen.research.bsgl.model.api.member.MemberSlotItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 鎮守府全般
 */
public class Deck {

    public List<Weapon> weapons;

    public List<Ship> ships;

    public List<Girl> girls;

    public List<Equipment> equipments;

    public Deck() {
        buildShip();
        buildWeapon();
        buildEquipment();
        buildGirl();
    }

    /**
     * 表示用装備データの生成
     */
    private void buildWeapon() {
        weapons = Weapon.buildList(
                MasterWeapon.cache(),
                MasterWeaponType.cacheAsMap()
        );
    }

    /**
     * 表示用艦船データの生成
     */
    private void buildShip() {
        ships = Ship.buildList(
                MasterShip.cache(),
                MasterShipType.cacheAsMap()
        );
    }

    /**
     * 表示用所持装備データの生成
     */
    private void buildEquipment() {
        equipments = Equipment.buildList(
                MemberSlotItem.cache(),
                Weapon.toIdMap(weapons)
        );
        // ID順の並び替え
        Collections.sort(equipments, new Comparator<Equipment>() {
            @Override
            public int compare(Equipment o1, Equipment o2) {
                return o1.weaponId - o2.weaponId;
            }
        });
    }

    /**
     * 表示用所持艦娘データの生成
     */
    private void buildGirl() {
        girls = Girl.buildList(
                MemberShip.cache(),
                Ship.toIdMap(ships),
                Equipment.toIdMap(equipments)
        );

        // LV順の並び替え
        Collections.sort(girls, new Comparator<Girl>() {
            @Override
            public int compare(Girl o1, Girl o2) {
                return o2.exp - o1.exp;
            }
        });
    }
}
