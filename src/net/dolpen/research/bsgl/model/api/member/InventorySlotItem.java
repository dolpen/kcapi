package net.dolpen.research.bsgl.model.api.member;

import com.beust.jcommander.internal.Maps;
import com.google.gson.Gson;
import net.dolpen.research.bsgl.api.Cache;
import net.dolpen.research.bsgl.model.api.Common;

import java.util.List;
import java.util.Map;

/**
 * 所持装備
 */
public class InventorySlotItem extends Common {

    public List<Entry> api_data;

    public static InventorySlotItem cache() {
        String resp = Cache.load("/inputs/member/slotitem.txt");
        return new Gson().fromJson(resp, InventorySlotItem.class);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : api_data) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Local ID -> Entry
     *
     * @return map
     */
    public Map<Integer, Entry> toIdMap() {
        Map<Integer, Entry> items = Maps.newHashMap();
        for (Entry s : api_data) {
            items.put(s.api_id, s);
        }
        return items;
    }

    public static class Entry {

        public int api_id; // Local ID (just an identifier in your deck)

        public int api_slotitem_id; // ID of the actual item

        public String toString() {
            return String.format("%d %d", api_id, api_slotitem_id);
        }
    }
}
