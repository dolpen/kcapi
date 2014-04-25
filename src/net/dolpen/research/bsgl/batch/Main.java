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
            "/templates/girl.html",
            ImmutableMap.<String, Object>builder()
                .put("girls", deck.girls)
                .build(),
            "/outputs/girl.html"
        );
        View.renderHtmlFile(
            "/templates/weapon.html",
            ImmutableMap.<String, Object>builder()
                .put("items", deck.weapons)
                .build(),
            "/outputs/weapon.html"
        );

    }
}
