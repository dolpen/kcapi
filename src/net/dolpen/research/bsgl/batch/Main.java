package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import net.dolpen.research.bsgl.model.compiled.Deck;
import net.dolpen.research.bsgl.util.groovy.View;

/**
 * All
 */
public class Main {

    public static void main(String... args) throws Exception {
        Deck deck = Deck.build();
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("girls", deck.girls).build(), "girl.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("ships", deck.ships).build(), "ship.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("weapons", deck.weapons).build(), "slot.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("weapons", deck.weapons).build(), "weapon.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("weapons", deck.slotItems).build(), "equip.html");
    }
}
