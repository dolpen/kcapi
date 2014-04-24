package net.dolpen.research.bsgl.model.api.member;

import net.dolpen.research.bsgl.model.api.Common;

import java.util.List;

/**
 * 艦隊編成の一覧です
 */
public class MemberDeck extends Common {

    public List<Content> api_data;

    public static class Content {
        public String api_flagship;
        public int api_id;
        public int api_member_id;
        public List<Long> api_mission;
        public String api_name;
        public String api_name_id;
        public List<Integer> api_ship;
    }

    /*
    public static MemberDeck get() {
        String resp = Request.postJson("/api_get_member/deck", null);
        return new Gson().fromJson(resp, MemberDeck.class);
    }
    */
}