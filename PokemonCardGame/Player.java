package PokemonCardGame;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private String name;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeCards;
    private Pokemon activePokemon;

    public Player(String name, ArrayList<Card> deck) {
        this.name = name;
        this.deck = new ArrayList<>(deck);
        this.hand = new ArrayList<>();
        this.prizeCards = new ArrayList<>();
        initializePlayer();
    }

    private void initializePlayer() {
        Collections.shuffle(deck);
        drawInitialHand();
        setPrizeCards();
    }

    private void drawInitialHand() {
        hand.clear();
        for (int i = 0; i < 7; i++) {
            hand.add(deck.remove(0));
        }
        // Check for mulligan
        if (!hasPokemonInHand()) {
            System.out.println(name + " has a mulligan! Redrawing hand...");
            deck.addAll(hand);
            Collections.shuffle(deck);
            drawInitialHand();
        }
    }

    private boolean hasPokemonInHand() {
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    private void setPrizeCards() {
        prizeCards.clear();
        for (int i = 0; i < 6; i++) {
            prizeCards.add(deck.remove(0));
        }
    }

    public void drawCard() {
        if (!deck.isEmpty()) {
            hand.add(deck.remove(0));
            System.out.println(name + " drew a card.");
        } else {
            System.out.println(name + "'s deck is empty!");
        }
    }

    public void playTurn() {
        drawCard();

        if (activePokemon == null) {
            for (Card card : hand) {
                if (card instanceof Pokemon) {
                    activePokemon = (Pokemon) card;
                    hand.remove(card);
                    System.out.println(name + " played " + activePokemon.getName() + " as their active Pokémon.");
                    break;
                }
            }
        }
    }

    public boolean hasWon() {
        return prizeCards.isEmpty();
    }

    public String getName() {
        return name;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon pokemon) {
        this.activePokemon = pokemon;
    }
}
