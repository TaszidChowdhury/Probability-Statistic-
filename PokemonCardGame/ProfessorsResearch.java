package PokemonCardGame;

import java.util.ArrayList;
import java.util.List;

// Professor's Research Trainer Card
public class ProfessorsResearch extends TrainerCard {
    public ProfessorsResearch() {
        super("Professor's Research", "Discard your hand and draw 7 cards.", "Supporter");
    }

    @Override
    public void useAbility(Player player, Deck deck) {
        System.out.println(player.getName() + " used Professor's Research!");
        player.discardHand();
        player.drawCards(deck, 7);
    }

    @Override
    public void play() {
        System.out.println("Playing Trainer Card: " + getName());
    }
}
