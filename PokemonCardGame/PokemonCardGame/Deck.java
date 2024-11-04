// Deck class
package PokemonCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        // Adding 20 Pokemon cards
        for (int i = 0; i < 7; i++) {
            cards.add(new BulbasaurCard());
            cards.add(new CharmanderCard());
            cards.add(new SquirtleCard());
        }
        cards.add(new BulbasaurCard()); // to make 20 total

        // Adding 20 Energy cards
        for (int i = 0; i < 20; i++) {
            cards.add(new EnergyCard("Basic"));
        }

        // Adding Trainer cards (use subclasses like ProfessorsResearch or NestBall)
        for (int i = 0; i < 10; i++) {
            cards.add(new ProfessorsResearch());
            cards.add(new NestBall());
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public void viewDeck() {
        for (Card card : cards) {
            System.out.println(card.getName());
        }
    }

    public List<PokemonCard> getBasicPokemonCards() {
        List<PokemonCard> basicPokemonCards = new ArrayList<>();
        for (Card card : cards) {
            if (card instanceof PokemonCard && ((PokemonCard) card).isBasic()) {
                basicPokemonCards.add((PokemonCard) card);
            }
        }
        return basicPokemonCards;
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void shuffle() {
        shuffleDeck();
    }
}
