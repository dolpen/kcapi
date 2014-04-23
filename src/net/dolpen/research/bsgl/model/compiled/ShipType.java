package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.ShipTypeMaster;

import java.util.List;
import java.util.Map;

/**
 * view向けShipTypeMaster
 */
public class ShipType {

    public int typeId;

    public String name;

    ShipTypeMaster.Entry raw;

    public List<Ship> ships;

    public static ShipType build(ShipTypeMaster.Entry e) {
        ShipType resp = new ShipType();
        resp.typeId = e.api_id;
        resp.name = e.api_name;
        resp.ships = Lists.newArrayList();
        resp.raw = e;
        return resp;
    }

    public static List<ShipType> buildList(ShipTypeMaster s) {
        List<ShipType> resp = Lists.newArrayList();
        for (ShipTypeMaster.Entry e : s.api_data) resp.add(build(e));
        return resp;
    }

    public static Map<Integer, ShipType> toIdMap(List<ShipType> l) {
        Map<Integer, ShipType> resp = Maps.newHashMap();
        for (ShipType e : l) resp.put(e.typeId, e);
        return resp;
    }
}
