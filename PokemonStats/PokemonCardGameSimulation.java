package PokemonStats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    enum CardType { POKEMON, TRAINER, ENERGY }

    CardType type;

    public Card(CardType type) {
        this.type = type;
    }

    public CardType getType() {
        return type;
    }
}

public class PokemonCardGameSimulation {
    public static void main(String[] args) {
        // Run the experiment for 1-60 Pokemon
        for (int i = 1; i <= 60; i++) {
            double odds = calculateOpeningHandOdds(i, 10000);
            double averageReshuffles = calculateAverageReshuffles(i, 10000);
            System.out.println("Pokemon in deck: " + i + " | Odds of opening with Pokemon: " + (odds * 100) + "% | Average reshuffles: " + averageReshuffles);
        }
    }

    // Create a deck with a specific number of Pokemon
    public static List<Card> createDeck(int numberOfPokemon) {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < numberOfPokemon; i++) {
            deck.add(new Card(Card.CardType.POKEMON));
        }
        for (int i = numberOfPokemon; i < 60; i++) {
            deck.add(new Card(Card.CardType.ENERGY)); // Assume rest are Energy cards
        }
        Collections.shuffle(deck);
        return deck;
    }

    // Draw 7 cards from the deck
    public static List<Card> drawHand(List<Card> deck) {
        return new ArrayList<>(deck.subList(0, 7));
    }

    // Check if there is any Pokemon in the hand
    public static boolean hasPokemonInHand(List<Card> hand) {
        for (Card card : hand) {
            if (card.getType() == Card.CardType.POKEMON) {
                return true;
            }
        }
        return false;
    }

    // Monte Carlo experiment to determine average reshuffles needed to get a Pokemon in hand
    public static double calculateAverageReshuffles(int numberOfPokemon, int trials) {
        int totalReshuffles = 0;
        for (int i = 0; i < trials; i++) {
            List<Card> deck = createDeck(numberOfPokemon);
            List<Card> hand = drawHand(deck);
            int reshuffles = 0;
            while (!hasPokemonInHand(hand)) {
                reshuffles++;
                Collections.shuffle(deck);
                hand = drawHand(deck);
            }
            totalReshuffles += reshuffles;
        }
        return (double) totalReshuffles / trials;
    }

    // Calculate the odds of having a Pokemon in the opening hand
    public static double calculateOpeningHandOdds(int numberOfPokemon, int trials) {
        int successfulHands = 0;
        for (int i = 0; i < trials; i++) {
            List<Card> deck = createDeck(numberOfPokemon);
            List<Card> hand = drawHand(deck);
            if (hasPokemonInHand(hand)) {
                successfulHands++;
            }
        }
        return (double) successfulHands / trials;
    }
}
