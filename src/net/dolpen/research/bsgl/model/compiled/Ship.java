package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.extra.AbilityScore;
import net.dolpen.research.bsgl.model.extra.LimitedValue;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;

import java.util.List;
import java.util.Map;

/**
 * コンパイル済み所持艦データ
 */
public class Ship {

    public int id;

    public int lv;

    public int exp;

    public String name;

    public int stype;

    public int leng;

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

    public List<SlotItem> items;

    public InventoryShip.Entry raw;

    public String getRange() {
        return Range.by(leng).getLabel();
    }

// builder

    public static Ship build(InventoryShip.Entry ship, Map<Integer, InventorySlotItem.Entry> items) {
        Ship resp = new Ship();
        resp.raw = ship;
        resp.id = ship.api_id;
        resp.leng = ship.api_leng;
        resp.name = ship.api_name;
        resp.lv = ship.api_lv;
        resp.exp = ship.api_exp;
        resp.stype = ship.api_stype;
        resp.hp = new LimitedValue(ship.api_nowhp, ship.api_maxhp, 0);
        resp.fuel = new LimitedValue(ship.api_fuel, ship.api_fuel_max, 0);
        resp.bullet = new LimitedValue(ship.api_bull, ship.api_bull_max, 0);
        //それぞれのindex[0]には近代化改修+装備補正値が足され、index[1]は近代化改修後の最大値を示す
        //index[0]から装備補正を引かなければ正しい表示にならない
        int[] p = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (Integer i : ship.api_slot) {
            if (i < 0) continue;
            InventorySlotItem.Entry e = items.get(i);
            p[0] += e.api_saku;
            p[1] += e.api_houg;
            p[2] += e.api_raig;
            p[3] += e.api_tyku;
            p[4] += e.api_souk;
            p[5] += e.api_kaih;
            p[6] += e.api_tais;
            p[7] += e.api_luck;
        }
        resp.sight = new AbilityScore(ship.api_saku.get(0), ship.api_saku.get(1), p[0]);
        resp.fire = new AbilityScore(ship.api_houg.get(0), ship.api_houg.get(1), p[1]);
        resp.torpedo = new AbilityScore(ship.api_raig.get(0), ship.api_raig.get(1), p[2]);
        resp.air = new AbilityScore(ship.api_tyku.get(0), ship.api_tyku.get(1), p[3]);
        resp.armor = new AbilityScore(ship.api_souk.get(0), ship.api_souk.get(1), p[4]);
        resp.evasion = new AbilityScore(ship.api_kaihi.get(0), ship.api_kaihi.get(1), p[5]);
        resp.sub = new AbilityScore(ship.api_taisen.get(0), ship.api_taisen.get(1), p[6]);
        resp.luck = new AbilityScore(ship.api_luck.get(0), ship.api_luck.get(1), p[7]);
        resp.items = Lists.newArrayList();
        return resp;
    }

    public static List<Ship> buildList(InventoryShip inventoryShip, InventorySlotItem inventorySlotItem) {
        Map<Integer, InventorySlotItem.Entry> items = inventorySlotItem.toIdMap();
        List<Ship> resp = Lists.newArrayList();
        for (InventoryShip.Entry s : inventoryShip.api_data) {
            resp.add(build(s, items));
        }
        return resp;
    }

}
