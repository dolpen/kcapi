package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.api.master.ShipMaster;
import net.dolpen.research.bsgl.model.api.master.SlotItemMaster;
import net.dolpen.research.bsgl.model.api.member.InventoryShip;
import net.dolpen.research.bsgl.model.api.member.InventorySlotItem;
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

    public InventoryShip.Entry raw;

// builder

    public static Ship build(InventoryShip.Entry e, Map<Integer, InventorySlotItem.Entry> i, Map<Integer, ShipMaster.Content> sm,Map<Integer, SlotItemMaster.Entry> im) {
        ShipMaster.Content mc = sm.get(e.api_ship_id);
        Ship resp = new Ship();
        resp.id = e.api_id;
        resp.range = Range.by(e.api_leng);
        resp.name = mc.api_name;
        resp.lv = e.api_lv;
        resp.exp = e.api_exp.get(0);
        resp.hp = new LimitedValue(e.api_nowhp, e.api_maxhp, 0);
        resp.fuel = new LimitedValue(e.api_fuel, mc.api_fuel_max, 0);
        resp.bullet = new LimitedValue(e.api_bull, mc.api_bull_max, 0);
        //それぞれのindex[0]には近代化改修+装備補正値が足され、index[1]は近代化改修後の最大値を示す
        //index[0]から装備補正を引かなければ正しい表示にならない
        int[] p = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (Integer k : e.api_slot) {
            if (k < 0) continue;
            InventorySlotItem.Entry slot = i.get(k);
            SlotItemMaster.Entry item = im.get(slot.api_slotitem_id);
            p[0] += item.api_saku;
            p[1] += item.api_houg;
            p[2] += item.api_raig;
            p[3] += item.api_tyku;
            p[4] += item.api_souk;
            p[5] += item.api_houk;
            p[6] += item.api_tais;
            p[7] += item.api_luck;
        }
        resp.sight = new AbilityScore(e.api_sakuteki.get(0), e.api_sakuteki.get(1), p[0]);
        resp.fire = new AbilityScore(e.api_karyoku.get(0), e.api_karyoku.get(1), p[1]);
        resp.torpedo = new AbilityScore(e.api_raisou.get(0), e.api_raisou.get(1), p[2]);
        resp.air = new AbilityScore(e.api_taiku.get(0), e.api_taiku.get(1), p[3]);
        resp.armor = new AbilityScore(e.api_soukou.get(0), e.api_soukou.get(1), p[4]);
        resp.evasion = new AbilityScore(e.api_kaihi.get(0), e.api_kaihi.get(1), p[5]);
        resp.sub = new AbilityScore(e.api_taisen.get(0), e.api_taisen.get(1), p[6]);
        resp.luck = new AbilityScore(e.api_lucky.get(0), e.api_lucky.get(1), p[7]);
        resp.equipments = Lists.newArrayList();
        resp.raw = e;
        return resp;
    }

    public static List<Ship> buildList(InventoryShip s, InventorySlotItem i, ShipMaster smst, SlotItemMaster imst) {
        Map<Integer, InventorySlotItem.Entry> iim = i.toIdMap();
        Map<Integer, ShipMaster.Content> sm = smst.toIdMap();
        Map<Integer, SlotItemMaster.Entry> im =imst.toIdMap();
        List<Ship> resp = Lists.newArrayList();
        for (InventoryShip.Entry e : s.api_data) {
            resp.add(build(e, iim, sm, im));
        }
        return resp;
    }

}
