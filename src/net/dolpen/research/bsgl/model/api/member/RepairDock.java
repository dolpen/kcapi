package net.dolpen.research.bsgl.model.api.member;

import java.util.List;

/**
 * 修理ドック(入渠)の状態
 * TODO まだ
 */
public class RepairDock {

    public List<Content> api_data;

    public static class Content {
        public int api_complete_time;
        public String api_complete_time_str;
        public int api_created_ship_id;
        public int api_id;
        public int api_item1;
        public int api_item2;
        public int api_item3;
        public int api_item4;
        public int api_ship_id;
        public int api_member_id;
        public int api_state; // -1だと使えない
    }
    /*
    public static RepairDock get() {
        String resp = Request.postJson("/api_get_member/ndock", null);
        return new Gson().fromJson(resp, RepairDock.class);
    }
    */
}
