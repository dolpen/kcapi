package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.api.member.MemberShip;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.extra.AbilityScore;
import net.dolpen.research.bsgl.model.extra.LimitedValue;

import java.util.List;
import java.util.Map;

/**
 * 所持艦データ
 */
public class Girl {

    public int girlId;

    public int shipId;

    public int lv;

    public int exp;

    public String name;

    public Range range;

    public LimitedValue hp;

    public LimitedValue fuel;

    public LimitedValue bullet;

    public AbilityScore sight;

    public AbilityScore firePower;

    public AbilityScore torpedo;

    public AbilityScore antiAir;

    public AbilityScore armor;

    public AbilityScore accuracy;

    public AbilityScore evasion;

    public AbilityScore antiSub;

    public AbilityScore luck;

    public boolean locked;

    public Ship ship;

    public List<Equipment> equipments;

    public MemberShip raw;

// builder

    public static Girl build(MemberShip ship, Map<Integer, Ship> shipMap, Map<Integer, Equipment> equipmentMap) {
        Girl resp = new Girl();
        resp.girlId = ship.girlId;
        resp.shipId = ship.shipId;
        resp.range = Range.by(ship.range);
        resp.lv = ship.lv;
        resp.exp = ship.exp.get(0);
        resp.hp = new LimitedValue(ship.hp, ship.maxHp, 0);
        resp.fuel = new LimitedValue(ship.fuel, Integer.MAX_VALUE, 0);
        resp.bullet = new LimitedValue(ship.bullet, Integer.MAX_VALUE, 0);
        resp.sight = fromList(ship.sight, 0);
        resp.firePower = fromList(ship.firePower, 0);
        resp.torpedo = fromList(ship.torpedo, 0);
        resp.antiAir = fromList(ship.antiAir, 0);
        resp.armor = fromList(ship.armor, 0);
        resp.accuracy = new AbilityScore(0, 0, 0); // 回避は常にゼロ(少なくともメンバデータに該当項目無し)
        resp.evasion = fromList(ship.evasion, 0);
        resp.antiSub = fromList(ship.antiSub, 0);
        resp.luck = fromList(ship.luck, 0);
        resp.locked = ship.locked == 1;
        resp.equipments = Lists.newArrayList();
        resp.raw = ship;
        resp.attachShip(shipMap.get(ship.shipId));
        for (int equipmentId : ship.slotIds) {
            resp.appendEquipment(equipmentMap.get(equipmentId));
        }
        return resp;
    }

    private static AbilityScore fromList(List<Integer> ab, int fix) {
        return new AbilityScore(ab.get(0), ab.get(1), fix);
    }

    public static List<Girl> buildList(List<MemberShip> memberShips, Map<Integer, Ship> shipMap, Map<Integer, Equipment> equipmentMap) {
        List<Girl> resp = Lists.newArrayList();
        for (MemberShip e : memberShips) {
            Girl girl = build(e, shipMap, equipmentMap);
            resp.add(girl);
        }
        return resp;
    }

    private void attachShip(Ship ship) {
        this.name = ship.name;
        fuel.maxValue = ship.maxFuel;
        bullet.maxValue = ship.maxBullet;
        this.ship = ship;
    }

    private void appendEquipment(Equipment equipment) {
        if (equipment == null) return;
        this.sight.addItemScore(equipment.weapon.sight);
        this.firePower.addItemScore(equipment.weapon.firePower);
        this.torpedo.addItemScore(equipment.weapon.torpedo);
        this.antiAir.addItemScore(equipment.weapon.antiAir);
        this.armor.addItemScore(equipment.weapon.armor);
        this.accuracy.fixItemScore(equipment.weapon.accuracy);
        this.evasion.addItemScore(equipment.weapon.evasion);
        this.antiSub.addItemScore(equipment.weapon.antiSub);
        this.luck.addItemScore(equipment.weapon.luck);
        this.equipments.add(equipment);
        equipment.girl = this;
    }

}
