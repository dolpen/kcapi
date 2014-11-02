package net.dolpen.research.bsgl.batch;

import com.google.common.collect.ImmutableMap;
import net.dolpen.research.bsgl.model.compiled.Deck;
import net.dolpen.research.bsgl.util.groovy.View;

/**
 * All
 */
public class Main {

    public static void main(String... args) throws Exception {
        Deck deck = new Deck();
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("girls", deck.girls).build(), "girl.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("ships", deck.ships).build(), "ship.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("weapons", deck.weapons).build(), "weapon.html");
        View.renderHtmlFile(ImmutableMap.<String, Object>builder().put("weapons", deck.equipments).build(), "equipment.html");
    }
}
