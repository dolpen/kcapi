package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.extra.LimitedValue;
import net.dolpen.research.bsgl.model.extra.ModernizationStatus;
import net.dolpen.research.bsgl.model.member.InventoryShip;
import net.dolpen.research.bsgl.model.member.InventorySlotItem;

import java.util.List;
import java.util.Map;

/**
 * コンパイル済み所持艦データ
 */
public class Ship {

    public int lv;
    public int exp;
    public String name;

    public int stype;
    public int leng;

    public LimitedValue hp;
    public LimitedValue fuel;
    public LimitedValue bullet;

    public ModernizationStatus sight;
    public ModernizationStatus fire;
    public ModernizationStatus torpedo;
    public ModernizationStatus air;
    public ModernizationStatus armor;
    public ModernizationStatus evasion;
    public ModernizationStatus sub;
    public ModernizationStatus luck;


    public static Ship build(InventoryShip.Content ship, Map<Integer, InventorySlotItem.Content> items) {
        int s = 0, f = 0, t = 0, a = 0, m = 0, k = 0, b = 0, l = 0;
        for (Integer i : ship.api_slot) {
            if (i < 0) continue;
            InventorySlotItem.Content c = items.get(i);
            s += c.api_saku;
            f += c.api_houg;
            t += c.api_raig;
            a += c.api_tyku;
            m += c.api_souk;
            k += c.api_kaih;
            b += c.api_tais;
            l += c.api_luck;
        }
        Ship resp = new Ship();
        resp.leng=ship.api_leng;
        resp.name = ship.api_name;
        resp.lv = ship.api_lv;
        resp.exp = ship.api_exp;
        resp.stype = ship.api_stype;
        resp.hp = new LimitedValue(ship.api_nowhp, ship.api_maxhp, 0);
        resp.fuel = new LimitedValue(ship.api_fuel, ship.api_fuel_max, 0);
        resp.bullet = new LimitedValue(ship.api_bull, ship.api_bull_max, 0);
        //それぞれのindex[0]には近代化改修+装備補正値が足され、index[1]は近代化改修後の最大値を示す
        //index[0]から装備補正を引かなければ正しい表示にならない
        resp.sight = new ModernizationStatus(ship.api_saku.get(0) - s, ship.api_saku.get(1));
        resp.fire = new ModernizationStatus(ship.api_houg.get(0) - f, ship.api_houg.get(1));
        resp.torpedo = new ModernizationStatus(ship.api_raig.get(0) - t, ship.api_raig.get(1));
        resp.air = new ModernizationStatus(ship.api_tyku.get(0) - a, ship.api_tyku.get(1));
        resp.armor = new ModernizationStatus(ship.api_souk.get(0) - m, ship.api_souk.get(1));
        resp.evasion = new ModernizationStatus(ship.api_kaihi.get(0) - k, ship.api_kaihi.get(1));
        resp.sub = new ModernizationStatus(ship.api_taisen.get(0) - b, ship.api_taisen.get(1));
        resp.luck = new ModernizationStatus(ship.api_luck.get(0) - l, ship.api_luck.get(1));
        return resp;
    }

    public static List<Ship> buildList(InventoryShip inventoryShip, InventorySlotItem inventorySlotItem) {
        Map<Integer, InventorySlotItem.Content> items = Maps.newHashMap();
        for (InventorySlotItem.Content s : inventorySlotItem.api_data) {
            items.put(s.api_id, s);
        }
        List<Ship> resp = Lists.newArrayList();
        for (InventoryShip.Content s : inventoryShip.api_data) {
            resp.add(build(s, items));
        }
        return resp;
    }

}
