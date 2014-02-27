package net.dolpen.research.bsgl.model.member;

import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * ユーザー情報
 */
public class Basic extends Common {
    public Content api_data;

    public static class Content {
        public int api_active_flag;
        public String api_comment;
        public String api_comment_id;
        public int api_count_deck; // 艦隊数
        public int api_count_kdock; // どっちかのドック
        public int api_count_ndock; // どっちかのドック
        public int api_experience; // 提督経験値
        public int api_fcoin; // 家具コイン
        public int api_firstflag; // なんだろう
        public String api_fleetname; // 艦隊名？
        public List<Integer> api_furniture;
        public int api_level;
        public int api_max_chara; // 艦娘
        public int api_max_kagu; // 特注家具職人
        public int api_max_slotitem; // アイテム
        public String api_member_id;
        public int api_ms_count; // 娘
        public int api_ms_success; // ？
        public String api_nickname;
        public String api_nickname_id;
        public int api_playtime;
        public int api_pt_challenged;
        public int api_pt_challenged_win;
        public int api_pt_lose;
        public int api_pt_win;
        public List<Integer> api_pvp;
        public int api_rank;
        public int api_st_lose;
        public int api_st_win;
        public long api_starttime;
        public int api_tutorial;
        public int api_tutorial_progress;
    }
}
