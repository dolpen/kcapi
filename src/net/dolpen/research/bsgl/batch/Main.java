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
        View.renderHtmlFile(
            "/templates/myship.html",
            ImmutableMap.<String, Object>builder()
                .put("girls", deck.girls)
                .build(),
            "/outputs/myship.html"
        );
        View.renderHtmlFile(
            "/templates/myequipment.html",
            ImmutableMap.<String, Object>builder()
                .put("items", deck.weapons)
                .build(),
            "/outputs/myequipment.html"
        );

    }
}
