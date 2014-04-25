package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.api.master.MasterShip;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.extra.LimitedValue;

import java.util.List;

/**
 * 艦船データ
 */
public class Ship {

    public int shipId; // 艦船ID

    public String name; // 艦名

    public String ruby; // 艦名ひらがな

    public String description; // 図鑑説明文

    public LimitedValue sight;

    public LimitedValue firePower;

    public LimitedValue torpedo;

    public LimitedValue antiAir;

    public LimitedValue armor;

    public LimitedValue evasion;

    public LimitedValue antiSub;

    public LimitedValue luck;

    public Range range;

    public int maxBullet; // 装弾数

    public int maxFuel; // 燃料搭載量

    public MasterShip raw;

    public static Ship build(MasterShip ship) {
        Ship resp = new Ship();
        resp.shipId = ship.shipId;
        resp.name = ship.name;
        resp.ruby = ship.ruby;
        resp.description = ship.description;
        resp.sight = fromList(ship.sight);
        resp.firePower = fromList(ship.firePower);
        resp.torpedo = fromList(ship.torpedo);
        resp.antiAir = fromList(ship.antiAir);
        resp.armor = fromList(ship.armor);
        resp.evasion = fromList(ship.evasion);
        resp.antiSub = fromList(ship.antiSub);
        resp.luck = fromList(ship.luck);
        resp.maxBullet = ship.maxBullet;
        resp.maxFuel = ship.maxFuel;
        resp.range = Range.by(ship.range);
        resp.raw = ship;
        return resp;
    }


    private static LimitedValue fromList(List<Integer> ab) {
        return new LimitedValue(ab.get(0), ab.get(1), 0);
    }

    public static List<Ship> buildList(List<MasterShip> masterShipList) {
        List<Ship> resp = Lists.newArrayList();
        for (MasterShip e : masterShipList) resp.add(build(e));
        return resp;
    }
}
