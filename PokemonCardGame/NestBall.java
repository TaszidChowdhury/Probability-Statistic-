package PokemonCardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Nest Ball Trainer Card
public class NestBall extends TrainerCard {
    public NestBall() {
        super("Nest Ball", "Search your deck for a Basic Pokémon and put it onto your Bench. Then, shuffle your deck.", "Item");
    }

    @Override
    public void useAbility(Player player, Deck deck) {
        System.out.println(player.getName() + " used Nest Ball!");
        Scanner scanner = new Scanner(System.in);
        try {
            List<PokemonCard> basicPokemonCards = deck.getBasicPokemonCards();

            if (basicPokemonCards.size() == 0) {
                System.out.println("No Basic Pokémon found in deck.");
                return;
            }

            System.out.println("Available Basic Pokémon in deck:");
            for (int i = 0; i < basicPokemonCards.size(); i++) {
                System.out.println((i + 1) + ". " + basicPokemonCards.get(i).getName());
            }

            System.out.print("Select the number of the Pokémon you want to add to your Bench: ");
            int choice = scanner.nextInt();
            PokemonCard selectedPokemon = basicPokemonCards.get(choice - 1);
            player.addPokemonToBench(selectedPokemon);
            deck.removeCard(selectedPokemon);
            deck.shuffle();
        } finally {
            scanner.close(); // Close the scanner to avoid resource leak
        }
    }

    @Override
    public void play() {
        System.out.println("Playing Trainer Card: " + getName());
    }
}
