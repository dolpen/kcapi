package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import net.dolpen.research.bsgl.model.api.master.MasterShipType;

import java.util.List;
import java.util.Map;

/**
 * view向けShipTypeMaster
 */
public class ShipType {

    public int typeId;

    public String name;

    MasterShipType raw;

    public List<Ship> ships;

    public static ShipType build(MasterShipType type) {
        ShipType resp = new ShipType();
        resp.typeId = type.typeId;
        resp.name = type.name;
        resp.ships = Lists.newArrayList();
        resp.raw = type;
        return resp;
    }

    public static List<ShipType> buildList(List<MasterShipType> masterShipTypeList) {
        List<ShipType> resp = Lists.newArrayList();
        for (MasterShipType e : masterShipTypeList) resp.add(build(e));
        return resp;
    }

    public static Map<Integer, ShipType> toIdMap(List<ShipType> l) {
        Map<Integer, ShipType> resp = Maps.newHashMap();
        for (ShipType e : l) resp.put(e.typeId, e);
        return resp;
    }
}
