package model.api.master;

import net.dolpen.research.bsgl.model.api.master.*;

public class MasterTest {
    public static void main(String... args) {
        testShip();
        testEquip();
        testMap();
        testItem();
        testOthers();
    }


    static void testShip() {
        System.out.println("########## Ship");
        for (MasterShip e : MasterShip.cache()) {
            System.out.println(e);
        }
        for (MasterShipGraph e : MasterShipGraph.cache()) {
            System.out.println(e);
        }
        for (MasterShipType e : MasterShipType.cache()) {
            System.out.println(e);
        }
        for (MasterShipUpgrade e : MasterShipUpgrade.cache()) {
            System.out.println(e);
        }
    }

    static void testEquip() {
        System.out.println("########## Equipment");
        for (MasterWeaponType e : MasterWeaponType.cache()) {
            System.out.println(e);
        }
        for (MasterWeapon e : MasterWeapon.cache()) {
            System.out.println(e);
        }
        for (MasterWeaponGraph e : MasterWeaponGraph.cache()) {
            System.out.println(e);
        }
    }


    static void testMap() {
        System.out.println("########## Map");
        for (MasterMapArea e : MasterMapArea.cache()) {
            System.out.println(e);
        }
        for (MasterMapStage e : MasterMapStage.cache()) {
            System.out.println(e);
        }
        for (MasterMapCell e : MasterMapCell.cache()) {
            System.out.println(e);
        }
        for (MasterMapBgm e : MasterMapBgm.cache()) {
            System.out.println(e);
        }
    }

    static void testItem() {
        System.out.println("########## Item");
        for (MasterUseItem e : MasterUseItem.cache()) {
            System.out.println(e);
        }
        for (MasterPayItem e : MasterPayItem.cache()) {
            System.out.println(e);
        }
        System.out.println(MasterItemShop.cache());
        for (MasterMapBgm e : MasterMapBgm.cache()) {
            System.out.println(e);
        }
    }


    static void testOthers() {
        System.out.println("########## Others");
        for (MasterBgm e : MasterBgm.cache()) {
            System.out.println(e);
        }
        for (MasterFurniture e : MasterFurniture.cache()) {
            System.out.println(e);
        }
        for (MasterFurnitureGraph e : MasterFurnitureGraph.cache()) {
            System.out.println(e);
        }
        for (MasterMission e : MasterMission.cache()) {
            System.out.println(e);
        }
    }

}
