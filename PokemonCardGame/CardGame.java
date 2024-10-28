package PokemonCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardGame {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeCards;
    private static final int MAX_PRIZES = 6;
    private static final int HAND_SIZE = 7;
    
    public CardGame() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        prizeCards = new ArrayList<>();
    }
    
    public void fillDeck(int numPokemon, int numRareCandies) {
        deck.clear();
        prizeCards.clear();
        for (int i = 0; i < 60 - numPokemon - numRareCandies; i++) {
            deck.add(new Energy());
        }
        for (int i = 0; i < numPokemon; i++) {
            deck.add(new Pokemon(70)); // Example HP for Pokemon
        }
        for (int i = 0; i < numRareCandies; i++) {
            deck.add(new RareCandy());
        }
        Collections.shuffle(deck);
    }

    public void drawHand() {
        hand.clear();
        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(deck.remove(0));
        }
    }

    public boolean hasPokemonInHand() {
        for (Card card : hand) {
            if (card.getType().equals("Pokemon")) {
                return true;
            }
        }
        return false;
    }

    public void drawHandWithPrizes() {
        hand.clear();
        prizeCards.clear();
        Random gen = new Random();
        
        // Draw 6 cards as prizes
        for (int i = 0; i < MAX_PRIZES; i++) {
            prizeCards.add(deck.remove(0));
        }
        
        // Draw 7 cards as the initial hand
        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(deck.remove(0));
        }
    }

    public int countRareCandiesInPrizes() {
        int rareCandyCount = 0;
        for (Card card : prizeCards) {
            if (card.getType().equals("RareCandy")) {
                rareCandyCount++;
            }
        }
        return rareCandyCount;
    }

    public boolean isBricked(int numRareCandies) {
        // Check if we have any rare candies in hand or deck given the number prized
        int rareCandyCountInHand = 0;
        for (Card card : hand) {
            if (card.getType().equals("RareCandy")) {
                rareCandyCountInHand++;
            }
        }
        
        // A deck is "bricked" if there are no rare candies in hand and fewer than expected in prizes
        return rareCandyCountInHand == 0 && countRareCandiesInPrizes() >= numRareCandies;
    }
}
