package net.dolpen.research.bsgl.model.member;

import java.util.List;

/**
 * 建造ドックの状態
 */
public class BuildDock {

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
        public int api_item5;
        public int api_member_id;
        public int api_state; // -1だと使えない
    }
    /*
    public static BuildDock get() {
        String resp = Request.postJson("/api_get_member/kdock", null);
        return new Gson().fromJson(resp, BuildDock.class);
    }
    */
}
