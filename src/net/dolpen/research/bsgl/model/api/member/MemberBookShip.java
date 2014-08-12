package net.dolpen.research.bsgl.model.api.member;

import com.beust.jcommander.internal.Lists;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;


public class MemberBookShip extends Member {

    @SerializedName("api_index_no")
    public int bookId; // 図鑑ID

    @SerializedName("api_name")
    public String name; // 名前

    @SerializedName("api_state")
    public List<List<Integer>> state;

    public String toString() {
        return String.format("%d : %s, %s", bookId, name, Arrays.deepToString(state.get(0).toArray()));
    }

    public static final int pages = 5;
    public static final int items = 50;

    public static List<MemberBookShip> cache() {
        List<MemberBookShip> bookShips = Lists.newArrayList();
        for (int i = 1; i <= pages; i++) {
            bookShips.addAll(Arrays.asList(loadTypedArray("/inputs/member/book_ship_" + i + ".txt", MemberBookShip[].class)));
        }
        return bookShips;
    }

}

