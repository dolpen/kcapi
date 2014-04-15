package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.dolpen.research.bsgl.util.groovy.View;
import net.dolpen.research.bsgl.model.master.ShipType;
import net.dolpen.research.bsgl.model.member.InventoryShip;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class MyShip {

    public static void main(String... args) throws Exception {
        Map<Integer, ShipType.Content> type = Maps.newHashMap();
        ShipType types = ShipType.cache();
        for (ShipType.Content c : types.api_data)
            type.put(c.api_id, c);
        InventoryShip inventoryShip = InventoryShip.cache();
        Collections.sort(inventoryShip.api_data,new Comparator<InventoryShip.ShipData>() {
            @Override
            public int compare(InventoryShip.ShipData o1, InventoryShip.ShipData o2) {
                return o2.api_exp - o1.api_exp;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });


        for(InventoryShip.ShipData shipData : inventoryShip.api_data){
            System.out.println(String.format("%s %s",type.get(shipData.api_stype).api_name,shipData.api_name));
        }
        //View.renderFile("/templates/myship.html", ImmutableMap.<String, Object>builder().put("type", type).put("list", inventoryShip.api_data).build(), "./kankolle/outputs/my_ship.html");
    }
}
