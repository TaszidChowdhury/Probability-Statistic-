package PokemonCardGame;

public class CardGameTester {
    public static void main(String[] args) {
        // Run the original Monte Carlo simulation for each deck configuration from 1-60 Pokémon
        System.out.println("Monte Carlo Simulation for Reshuffles:");
        for (int numPokemon = 1; numPokemon <= 60; numPokemon++) {
            int avgReshuffles = runMonteCarloSimulation(numPokemon, 10000);
            System.out.printf("Pokémon Count: %d - Avg Reshuffles: %d%n", numPokemon, avgReshuffles);
        }
        
        System.out.println("\nReshuffles and Odds Calculation:");
        // Calculate reshuffles needed and odds of getting a Pokémon in the opening hand for decks with 1-60 Pokémon
        calculateReshufflesAndOdds();

        System.out.println("\nRare Candy Prizing and Bricking Simulation:");
        // Calculate odds of prizing and being bricked for decks with 1-4 rare candies
        calculatePrizingAndBrickingOdds();
    }
    
    /**
     * Original Monte Carlo simulation to calculate average reshuffles for having a Pokémon in hand
     * for decks with 1-60 Pokémon.
     */
    public static int runMonteCarloSimulation(int numPokemon, int trials) {
        int totalReshuffles = 0;
        for (int i = 0; i < trials; i++) {
            CardGame game = new CardGame();
            game.fillDeck(numPokemon, 0); // Assume 0 rare candies for this simulation
            int reshuffles = 0;
            
            while (true) {
                game.drawHand();
                if (game.hasPokemonInHand()) {
                    break;
                } else {
                    reshuffles++;
                    game.fillDeck(numPokemon, 0); // Refill and reshuffle deck for a new hand
                }
            }
            totalReshuffles += reshuffles;
        }
        return totalReshuffles / trials;
    }
    
    /**
     * Method to calculate average reshuffles and odds of having a Pokémon in the opening hand
     * for decks with 1-60 Pokémon.
     */
    public static void calculateReshufflesAndOdds() {
        int trials = 10000;  // Number of trials for each deck configuration

        System.out.printf("%-10s %-20s %-10s%n", "Pokémon", "Avg Reshuffles", "Odds (%)");

        for (int numPokemon = 1; numPokemon <= 60; numPokemon++) {
            int totalReshuffles = 0;
            int handsWithPokemon = 0;

            for (int i = 0; i < trials; i++) {
                CardGame game = new CardGame();
                game.fillDeck(numPokemon, 0); // Assume 0 rare candies for this simulation
                int reshuffles = 0;

                while (true) {
                    game.drawHand();
                    if (game.hasPokemonInHand()) {
                        handsWithPokemon++;
                        break;
                    } else {
                        reshuffles++;
                        game.fillDeck(numPokemon, 0); // Refill and reshuffle deck for a new hand
                    }
                }
                totalReshuffles += reshuffles;
            }

            double avgReshuffles = (double) totalReshuffles / trials;
            double odds = ((double) handsWithPokemon / trials) * 100;

            System.out.printf("%-10d %-20.2f %-10.2f%n", numPokemon, avgReshuffles, odds);
        }
    }

    /**
     * Method to calculate the odds of prizing and being bricked for decks with 1-4 rare candies.
     */
    public static void calculatePrizingAndBrickingOdds() {
        int trials = 10000;

        System.out.printf("%-15s %-20s %-20s %-20s %-20s%n", "Rare Candies", "Odds of 1 Prized (%)", "Odds of 2 Prized (%)", "Odds of 3 Prized (%)", "Odds of 4 Prized (%)");

        int[] brickedCounts = new int[5]; // For counting the number of bricked hands for each rare candy configuration

        for (int numRareCandies = 1; numRareCandies <= 4; numRareCandies++) {
            int[] prizedCounts = new int[5]; // For counting 0-4 prized rare candies

            for (int i = 0; i < trials; i++) {
                CardGame game = new CardGame();
                game.fillDeck(10, numRareCandies); // Example deck with 10 Pokémon and numRareCandies
                game.drawHandWithPrizes();

                int rareCandiesPrized = game.countRareCandiesInPrizes();
                if (rareCandiesPrized <= 4) {
                    prizedCounts[rareCandiesPrized]++;
                }

                if (game.isBricked(numRareCandies)) {
                    brickedCounts[numRareCandies]++;
                }
            }

            // Print results for prizing odds
            System.out.printf("%-15d", numRareCandies);
            for (int j = 1; j <= 4; j++) {
                double odds = ((double) prizedCounts[j] / trials) * 100;
                System.out.printf("%-20.2f", odds);
            }
            System.out.println();
        }

        System.out.println("\nBricking Odds:");
        System.out.printf("%-15s %-20s%n", "Rare Candies", "Bricked Odds (%)");
        for (int numRareCandies = 1; numRareCandies <= 4; numRareCandies++) {
            double brickedOdds = ((double) brickedCounts[numRareCandies] / trials) * 100;
            System.out.printf("%-15d %-20.2f%n", numRareCandies, brickedOdds);
        }
    }
}
