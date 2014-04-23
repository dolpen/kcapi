package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.enums.Range;
import net.dolpen.research.bsgl.model.extra.AbilityScore;
import net.dolpen.research.bsgl.model.extra.LimitedValue;
import net.dolpen.research.bsgl.model.api.member.InventoryShip;
import net.dolpen.research.bsgl.model.api.member.InventorySlotItem;

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

    public InventoryShip.Entry raw;

// builder

    public static Ship build(InventoryShip.Entry e, Map<Integer, InventorySlotItem.Entry> m) {
        Ship resp = new Ship();
        resp.id = e.api_id;
        resp.range = Range.by(e.api_leng);
        resp.name = e.api_name;
        resp.lv = e.api_lv;
        resp.exp = e.api_exp;
        resp.hp = new LimitedValue(e.api_nowhp, e.api_maxhp, 0);
        resp.fuel = new LimitedValue(e.api_fuel, e.api_fuel_max, 0);
        resp.bullet = new LimitedValue(e.api_bull, e.api_bull_max, 0);
        //それぞれのindex[0]には近代化改修+装備補正値が足され、index[1]は近代化改修後の最大値を示す
        //index[0]から装備補正を引かなければ正しい表示にならない
        int[] p = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (Integer k : e.api_slot) {
            if (k < 0) continue;
            InventorySlotItem.Entry i = m.get(k);
            p[0] += i.api_saku;
            p[1] += i.api_houg;
            p[2] += i.api_raig;
            p[3] += i.api_tyku;
            p[4] += i.api_souk;
            p[5] += i.api_kaih;
            p[6] += i.api_tais;
            p[7] += i.api_luck;
        }
        resp.sight = new AbilityScore(e.api_saku.get(0), e.api_saku.get(1), p[0]);
        resp.fire = new AbilityScore(e.api_houg.get(0), e.api_houg.get(1), p[1]);
        resp.torpedo = new AbilityScore(e.api_raig.get(0), e.api_raig.get(1), p[2]);
        resp.air = new AbilityScore(e.api_tyku.get(0), e.api_tyku.get(1), p[3]);
        resp.armor = new AbilityScore(e.api_souk.get(0), e.api_souk.get(1), p[4]);
        resp.evasion = new AbilityScore(e.api_kaihi.get(0), e.api_kaihi.get(1), p[5]);
        resp.sub = new AbilityScore(e.api_taisen.get(0), e.api_taisen.get(1), p[6]);
        resp.luck = new AbilityScore(e.api_luck.get(0), e.api_luck.get(1), p[7]);
        resp.equipments = Lists.newArrayList();
        resp.raw = e;
        return resp;
    }

    public static List<Ship> buildList(InventoryShip s, InventorySlotItem i) {
        Map<Integer, InventorySlotItem.Entry> m = i.toIdMap();
        List<Ship> resp = Lists.newArrayList();
        for (InventoryShip.Entry e : s.api_data) {
            resp.add(build(e, m));
        }
        return resp;
    }

}
