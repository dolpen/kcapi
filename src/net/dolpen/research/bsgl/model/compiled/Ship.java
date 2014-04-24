package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.api.master.MasterShip;
import net.dolpen.research.bsgl.model.api.master.MasterShipType;
import net.dolpen.research.bsgl.model.api.master.MasterSlotItem;
import net.dolpen.research.bsgl.model.api.member.MemberShip;
import net.dolpen.research.bsgl.model.api.member.MemberSlotItem;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.extra.AbilityScore;
import net.dolpen.research.bsgl.model.extra.LimitedValue;

import java.util.List;
import java.util.Map;

/**
 * 所持艦データ
 */
public class Ship {

    public int id;

    public int lv;

    public int exp;

    public String name;

    public Range range;

    public LimitedValue hp;

    public LimitedValue fuel;

    public LimitedValue bullet;

    public AbilityScore sight;

    public AbilityScore fire;

    public AbilityScore torpedo;

    public AbilityScore air;

    public AbilityScore armor;

    public AbilityScore evasion;

    public AbilityScore sub;

    public AbilityScore luck;

    public ShipType type;

    public List<Equipment> equipments;

    public MemberShip raw;

// builder

    public static Ship build(MemberShip ship, Map<Integer, MemberSlotItem> memberSlotItemMap, Map<Integer, MasterShip> masterShipMap, Map<Integer, MasterSlotItem> masterSlotItemMap) {
        MasterShip masterShip = masterShipMap.get(ship.shipId);
        Ship resp = new Ship();
        resp.id = ship.shipId;
        resp.range = Range.by(ship.range);
        resp.name = masterShip.name;
        resp.lv = ship.lv;
        resp.exp = ship.exp.get(0);
        resp.hp = new LimitedValue(ship.hp, ship.maxHp, 0);
        resp.fuel = new LimitedValue(ship.fuel, masterShip.maxFuel, 0);
        resp.bullet = new LimitedValue(ship.bullet, masterShip.maxBullet, 0);
        //それぞれのindex[0]には近代化改修+装備補正値が足され、index[1]は近代化改修後の最大値を示す
        //index[0]から装備補正を引かなければ正しい表示にならない
        int[] p = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (Integer slotId : ship.slotIds) {
            if (slotId < 0) continue;
            MemberSlotItem slotItem = memberSlotItemMap.get(slotId);
            MasterSlotItem equipment = masterSlotItemMap.get(slotItem.equipmentId);
            p[0] += equipment.sight;
            p[1] += equipment.firepower;
            p[2] += equipment.torpedo;
            p[3] += equipment.antiAir;
            p[4] += equipment.armor;
            p[5] += equipment.evasion;
            p[6] += equipment.antiSub;
            p[7] += equipment.luck;
        }
        resp.sight = fromList(ship.sight, p[0]);
        resp.fire = fromList(ship.firePower, p[1]);
        resp.torpedo = fromList(ship.torpedo, p[2]);
        resp.air = fromList(ship.antiAir, p[3]);
        resp.armor = fromList(ship.armor, p[4]);
        resp.evasion = fromList(ship.evasion, p[5]);
        resp.sub = fromList(ship.antiSub, p[6]);
        resp.luck = fromList(ship.luck, p[7]);
        resp.equipments = Lists.newArrayList();
        resp.raw = ship;

        return resp;
    }

    private static AbilityScore fromList(List<Integer> ab, int fix) {
        return new AbilityScore(ab.get(0), ab.get(1), fix);
    }

    public static List<Ship> buildList(List<MemberShip> memberShips, Map<Integer, MemberSlotItem> memberSlotItemMap, Map<Integer, MasterShip> masterShipMap, Map<Integer, MasterSlotItem> masterSlotItemMap) {
        List<Ship> resp = Lists.newArrayList();
        for (MemberShip e : memberShips) {
            resp.add(build(e, memberSlotItemMap, masterShipMap, masterSlotItemMap));
        }
        return resp;
    }

}
