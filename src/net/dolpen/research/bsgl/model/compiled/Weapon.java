package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.MasterWeapon;
import net.dolpen.research.bsgl.model.api.master.MasterWeaponType;
import net.dolpen.research.bsgl.model.enums.Range;

import java.util.List;
import java.util.Map;

/**
 * view向けSlotItemMaster
 */
public class Weapon {

    public int weaponId;

    public String name;

    public String typeName;

    public Range range;

    public int sight;

    public int firePower;

    public int torpedo;

    public int antiAir;

    public int armor;

    public int evasion;

    public int accuracy;

    public int antiSub;

    public int luck;

    public int amount;

    MasterWeapon raw;

    MasterWeaponType rawType;

    public static Weapon build(MasterWeapon weapon, Map<Integer, MasterWeaponType> weaponTypeMap) {
        Weapon resp = new Weapon();
        resp.weaponId = weapon.weaponId;
        resp.name = weapon.name;
        resp.sight = weapon.sight;
        resp.firePower = weapon.firePower;
        resp.torpedo = weapon.torpedo;
        resp.antiAir = weapon.antiAir;
        resp.armor = weapon.armor;
        resp.antiSub = weapon.antiSub;
        resp.evasion = weapon.fireEvasion;
        resp.accuracy = weapon.fireAccuracy;
        resp.luck = weapon.luck;
        resp.range = Range.by(weapon.range);
        resp.amount = 0;
        resp.raw = weapon;
        MasterWeaponType type = weaponTypeMap.get(weapon.getTypeId());
        resp.typeName = type.name;
        resp.rawType = type;
        return resp;
    }

    public static List<Weapon> buildList(List<MasterWeapon> masterWeaponList, Map<Integer, MasterWeaponType> weaponTypeMap) {
        List<Weapon> resp = Lists.newArrayList();
        for (MasterWeapon e : masterWeaponList) resp.add(build(e,weaponTypeMap));
        return resp;
    }

    public static Map<Integer, Weapon> toIdMap(List<Weapon> weaponList) {
        Map<Integer, Weapon> resp = Maps.newHashMap();
        for (Weapon e : weaponList) resp.put(e.weaponId, e);
        return resp;
    }
}
