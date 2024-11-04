package PokemonCardGame;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private Deck deck;
    private int prizeCards;
    private PokemonCard activePokemon;
    private ArrayList<PokemonCard> bench;
    private int energyCount;

    public Player(String name, Deck deck) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.deck = deck;
        this.prizeCards = 6; // Start with 6 prize cards
        this.bench = new ArrayList<>();
        this.energyCount = 0;
        drawInitialHand();
        setActivePokemon(); // Set an initial active Pokemon
    }

    private void drawInitialHand() {
        for (int i = 0; i < 7; i++) {
            drawCard();
        }
    }

    public void drawCard() {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
            System.out.println(name + " drew a card: " + card.getName());
        }
    }

    public void playCard(int index) {
        if (index >= 0 && index < hand.size()) {
            Card card = hand.remove(index);
            System.out.println(name + " played " + card.getName());
            if (card instanceof PokemonCard) {
                if (activePokemon == null) {
                    activePokemon = (PokemonCard) card;
                    System.out.println(name + " set " + activePokemon.getName() + " as the active Pokemon.");
                } else if (bench.size() < 5) {
                    bench.add((PokemonCard) card);
                    System.out.println(name + " placed " + card.getName() + " on the bench.");
                } else {
                    System.out.println("Bench is full. Cannot play more Pokemon.");
                }
            } else if (card instanceof EnergyCard) {
                energyCount++;
                System.out.println(name + " now has " + energyCount + " energy.");
            }
            card.play();
        } else {
            System.out.println("Invalid card index.");
        }
    }

    public void useAttack(Player opponent, int attackChoice) {
        if (activePokemon != null) {
            if (energyCount > 0) {
                System.out.println("Attacking with " + activePokemon.getName() + " - HP: " + activePokemon.getHp());
                if (opponent.activePokemon != null) {
                    activePokemon.useAttack(opponent.activePokemon, attackChoice);
                    energyCount--; // Consumes energy to attack
                    if (opponent.activePokemon.isKnockedOut()) {
                        System.out.println(opponent.activePokemon.getName() + " has been knocked out!");
                        opponent.setActivePokemon(); // Choose a new active Pokemon if available
                        prizeCards--;
                        System.out.println(name + " collected a prize card! Remaining prize cards: " + prizeCards);
                    }
                } else {
                    System.out.println("Opponent has no active Pokemon to attack.");
                }
            } else {
                System.out.println("Not enough energy to attack.");
            }
        } else {
            System.out.println("No active Pokemon to use for attack.");
        }
    }

    public void setActivePokemon() {
        if (bench.isEmpty()) {
            activePokemon = null;
            System.out.println(name + " has no active Pokemon.");
        } else {
            activePokemon = bench.remove(0);
            System.out.println(name + "'s active Pokemon is now " + activePokemon.getName() + " with HP: " + activePokemon.getHp());
        }
    }

    public void showHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ": " + hand.get(i).getName());
        }
    }

    public String getName() {
        return name;
    }

    public int getPrizeCards() {
        return prizeCards;
    }

    public boolean hasWon() {
        return prizeCards <= 0;
    }

    public void addPokemonToBench(PokemonCard card) {
        if (bench.size() < 5) {
            bench.add(card);
            System.out.println(card.getName() + " has been added to your Bench.");
        } else {
            System.out.println("Bench is full. Cannot add more Pokémon.");
        }
    }

    public void discardHand() {
        hand.clear();
        System.out.println(name + " discarded their hand.");
    }

    public void drawCards(Deck deck, int numCards) {
        for (int i = 0; i < numCards; i++) {
            drawCard();
        }
    }
}
