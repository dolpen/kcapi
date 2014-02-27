package net.dolpen.research.bsgl.model.member;

import net.dolpen.research.bsgl.model.Common;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dolpen
 * Date: 13/08/10
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class Book extends Common {

    public Content api_data;

    public static class Content {
        public int api_count;
        public int api_disp_no;
        public int api_disp_type;
        public int api_member_id;
        public List<Entry> api_list;
    }

    public static class Entry {
        public int api_cnum;
        public int api_ctype;
        public int api_houg;
        public int api_id;
        public int api_index_no;
        public int api_kaih;
        public int api_leng;
        public String api_name;
        public int api_raig;
        public String api_sinfo;
        public int api_souk;
        public List<Integer> api_state;
        public int api_stype;
        public int api_table_id;
        public int api_taik;
        public int api_tais;
        public int api_tyku;
        public String api_yomi;

    }

    /**
     * @param type 1が船,2が装備
     * @param no   ページ、それぞれ3,2まで
     * @return
     */
    /*
    public static Book get(int type, int no) {
        String resp = Request.postJson(
                "/api_get_member/book2",
                ImmutableMap.<String, String>builder().put("api_type", "" + type).put("api_no", "" + no).build()
        );
        return new Gson().fromJson(resp.replaceAll("(,-1)+\\]\\}\\}", "]}}"), Book.class);
    }
    */
}
