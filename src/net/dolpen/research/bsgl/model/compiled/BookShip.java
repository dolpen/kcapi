package net.dolpen.research.bsgl.model.compiled;

import com.beust.jcommander.internal.Lists;
import net.dolpen.research.bsgl.model.api.member.MemberBookShip;

import java.util.List;

/**
 * 艦船収集ステータス
 */
public class BookShip {

    public int bookId; // 図鑑ID

    public String name; // 名前

    public boolean hasGet;

    public boolean hasBroken;

    public static BookShip build(MemberBookShip bs) {
        BookShip resp = new BookShip();
        resp.bookId = bs.bookId;
        resp.name = bs.name;
        resp.hasGet = true;
        resp.hasBroken = bs.state.get(0).get(1) == 1;
        return resp;
    }

    public static BookShip buildDummy(int bookId) {
        BookShip resp = new BookShip();
        resp.bookId = bookId;
        resp.name = "？？？";
        resp.hasGet = false;
        resp.hasBroken = false;
        return resp;
    }

    public static List<BookShip> buildList(List<MemberBookShip> memberBookShipList) {
        List<BookShip> ret = Lists.newArrayList();
        int j = 0, l = memberBookShipList.size(), m = MemberBookShip.pages * MemberBookShip.items;
        for (int i = 1; i <= m; i++) {
            if (j < l) {
                MemberBookShip bs = memberBookShipList.get(j);
                if (bs.bookId == i) {
                    ret.add(build(bs));
                    j++;
                    continue;
                }
            }
            ret.add(buildDummy(i));
        }
        return ret;
    }
}
