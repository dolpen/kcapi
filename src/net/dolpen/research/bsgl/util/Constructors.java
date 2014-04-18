package net.dolpen.research.bsgl.util;

import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.compiled.Ship;
import net.dolpen.research.bsgl.model.compiled.SlotItem;

import java.util.List;
import java.util.Map;

/**
 * 重めの破壊的処理
 */
public class Constructors {

    /**
     * 装備/艦の紐付け
     *
     * @param ships 艦
     * @param items 装備
     */
    public static void appendItems(List<Ship> ships, List<SlotItem> items) {
        Map<Integer, Ship> shipMap = Maps.newHashMap();
        for (Ship s : ships) shipMap.put(s.id, s);
        Map<Integer, SlotItem> itemMap = Maps.newHashMap();
        for (SlotItem s : items) itemMap.put(s.id, s);
        for (Ship s : ships) {
            for (int i : s.raw.api_slot) {
                if (i < 0) continue;
                SlotItem item = itemMap.get(i);
                item.ship = s;
                s.items.add(item);
            }
        }
    }

}
