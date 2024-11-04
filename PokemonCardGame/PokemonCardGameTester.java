// PokemonCardGameTester.java
package PokemonCardGame;

import java.util.Scanner;

public class PokemonCardGameTester {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player("Player 1", deck);
        Player player2 = new Player("Player 2", deck);
        Scanner scanner = new Scanner(System.in);

        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("\n" + player1.getName() + "'s turn:");
            takeTurn(scanner, player1, player2);
            if (player1.hasWon()) {
                System.out.println(player1.getName() + " wins the game!");
                break;
            }

            System.out.println("\n" + player2.getName() + "'s turn:");
            takeTurn(scanner, player2, player1);
            if (player2.hasWon()) {
                System.out.println(player2.getName() + " wins the game!");
                break;
            }
        }
    }

    private static void takeTurn(Scanner scanner, Player currentPlayer, Player opponent) {
        boolean turnActive = true;
        while (turnActive) {
            System.out.println("Hand:");
            currentPlayer.showHand();
            System.out.println("Choose an action:");
            System.out.println("1. Draw a card");
            System.out.println("2. Play a card");
            System.out.println("3. Attack");
            System.out.print("Enter choice (1-3): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    currentPlayer.drawCard();
                    break;
                case 2:
                    System.out.print("Enter the index of the card to play: ");
                    int index = scanner.nextInt() - 1; // Adjust for 1-based input
                    currentPlayer.playCard(index);
                    break;
                case 3:
                    System.out.print("Choose an attack (1 or 2): ");
                    int attackChoice = scanner.nextInt();
                    currentPlayer.useAttack(opponent, attackChoice);
                    turnActive = false; // End turn after attacking
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
