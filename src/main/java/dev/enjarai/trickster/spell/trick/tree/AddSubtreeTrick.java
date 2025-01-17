package dev.enjarai.trickster.spell.trick.tree;

import dev.enjarai.trickster.spell.*;
import dev.enjarai.trickster.spell.fragment.ListFragment;
import dev.enjarai.trickster.spell.blunder.AddressNotInTreeBlunder;
import dev.enjarai.trickster.spell.blunder.BlunderException;

import java.util.List;

public class AddSubtreeTrick extends AbstractMetaTrick {
    public AddSubtreeTrick() {
        super(Pattern.of(2, 1, 0, 4, 8, 7, 6, 4, 2, 5, 8));
    }

    @Override
    public Fragment distort(SpellContext ctx, List<Fragment> fragments) throws BlunderException {
        var spell = expectInput(fragments, SpellPart.class, 0);
        var addressFragment = expectInput(fragments, ListFragment.class, 1);
        var subtree = expectInput(fragments, SpellPart.class, 2);

        var newSpell = spell.deepClone();
        var node = findNode(newSpell, addressFragment)
                .orElseThrow(() -> new AddressNotInTreeBlunder(this, addressFragment.sanitizeAddress(this)));
        node.subParts.add(subtree);

        return newSpell;
    }
}
