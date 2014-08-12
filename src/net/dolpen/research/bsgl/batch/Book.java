package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import net.dolpen.research.bsgl.model.api.member.MemberBookShip;
import net.dolpen.research.bsgl.model.compiled.BookShip;
import net.dolpen.research.bsgl.model.compiled.Deck;
import net.dolpen.research.bsgl.util.groovy.View;

/**
 * 図鑑
 */
public class Book {

    public static void main(String... args) throws Exception {
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("bookShips", BookShip.buildList(MemberBookShip.cache())).build(), "book_ship.html");
    }
}
