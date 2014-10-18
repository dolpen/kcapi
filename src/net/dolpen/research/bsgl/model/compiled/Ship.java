package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.MasterShip;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.extra.LimitedValue;

import java.util.List;
import java.util.Map;

/**
 * 艦船データ
 */
public class Ship {

    public int shipId; // 艦船ID

    public int typeId; // 艦種ID

    public String name; // 艦名

    public String ruby; // 艦名ひらがな

    public String description; // 図鑑説明文

    public int maxHp;

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

    public ShipType shipType;

    public static Ship build(MasterShip ship) {
        Ship resp = new Ship();
        resp.shipId = ship.shipId;
        resp.typeId = ship.type;
        resp.name = ship.name;
        resp.ruby = ship.ruby;
        resp.maxHp = ship.endurance.get(1);
        resp.description = ship.description;
        resp.sight = fromDummy();
        resp.firePower = fromList(ship.firePower);
        resp.torpedo = fromList(ship.torpedo);
        resp.antiAir = fromList(ship.antiAir);
        resp.armor = fromList(ship.armor);
        resp.evasion = fromDummy();
        resp.antiSub = fromDummy();
        resp.luck = fromList(ship.luck);
        resp.maxBullet = ship.maxBullet;
        resp.maxFuel = ship.maxFuel;
        resp.range = Range.by(ship.range);
        resp.raw = ship;
        return resp;
    }


    /**
     * なぜかマスタデータから消滅した項目の補完
     *
     * @return
     */
    private static LimitedValue fromDummy() {
        return new LimitedValue(0, 0, 0);
    }

    private static LimitedValue fromList(List<Integer> ab) {
        return new LimitedValue(ab.get(0), ab.get(1), 0);
    }

    public static List<Ship> buildList(List<MasterShip> masterShipList) {
        List<Ship> resp = Lists.newArrayList();
        for (MasterShip e : masterShipList) resp.add(build(e));
        return resp;
    }

    public static Map<Integer, Ship> toIdMap(List<Ship> shipList) {
        Map<Integer, Ship> resp = Maps.newHashMap();
        for (Ship e : shipList) resp.put(e.shipId, e);
        return resp;
    }

    public static void attachAll(List<Ship> shipList, Map<Integer, ShipType> shipTypeMap) {
        for (Ship e : shipList) e.attach(shipTypeMap.get(e.typeId));
    }

    public void attach(ShipType shipType) {
        if (shipType == null || shipType.typeId != typeId) {
            throw new IllegalArgumentException("不正な艦種マスタデータがアタッチされました");
        }
        this.shipType = shipType;
        shipType.ships.add(this);
    }

    public boolean isValid() {
        return !"なし".equals(name);
    }
}
