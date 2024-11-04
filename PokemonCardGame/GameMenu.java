package PokemonCardGame;

import java.util.Scanner;

public class GameMenu {
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Pokemon Card Game Simulator!");
            System.out.println("1. Start Game");
            System.out.println("2. View Deck");
            System.out.println("3. View Instructions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    startGame(scanner);
                    break;
                case 2:
                    Deck deck = new Deck();
                    deck.viewDeck();
                    break;
                case 3:
                    viewInstructions();
                    break;
                case 4:
                    System.out.println("Exiting the game. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void startGame(Scanner scanner) {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Player player1 = new Player("Player 1", deck1);
        Player player2 = new Player("Player 2", deck2);

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

    private void takeTurn(Scanner scanner, Player currentPlayer, Player opponent) {
        boolean turnActive = true;
        while (turnActive) {
            System.out.println("Hand:");
            currentPlayer.showHand();
            System.out.println("Choose an action:");
            System.out.println("1. Draw a card");
            System.out.println("2. Play a card");
            System.out.println("3. Use an attack");
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

    private void viewInstructions() {
        System.out.println("Instructions: This is a simple Pokemon card game simulator. Choose options to play the game, view your deck, or exit.");
    }
}
