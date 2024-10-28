package MontyHallSimulation;

import java.util.Random;
/**
 * MontyHallSimulation is the main class that runs the Monty Hall problem simulation.
 * It uses the GameSimulator class to simulate the Monty Hall game with two strategies:
 * 1. Not switching doors.
 * 2. Switching doors.
 */
public class MontyHallSimulation {
    /**
     * The main method to start the Monty Hall simulation.
     * @param args Command-line arguments (not used).
     */
        public static void main(String[] args) {
        GameSimulator simulator = new GameSimulator();
        simulator.runSimulation();
    }
}
/**
 * GameSimulator is a helper class that runs simulations of the Monty Hall game.
 * It contains methods to simulate both strategies (switching and not switching doors).
 */
class GameSimulator {
    /**
     * Total number of trials to run for each strategy.
     */
    public static final int TOTAL_TRIALS = 10000;
    /**
     * Runs both simulations (switch and no-switch strategies) and prints the win percentages.
     */
    public void runSimulation() {
        int winsNoSwitch = simulateNoSwitch();
        int winsSwitch = simulateSwitch();

        System.out.printf("Win percentage without switching: %.2f%%%n", (winsNoSwitch / (double) TOTAL_TRIALS) * 100);
        System.out.printf("Win percentage with switching: %.2f%%%n", (winsSwitch / (double) TOTAL_TRIALS) * 100);
    }
    /**
     * Simulates the Monty Hall game without switching doors.
     * @return The number of wins when the contestant does not switch doors.
     */
    // Simulate 10,000 trials without switching
    public int simulateNoSwitch() {
        int wins = 0;
        Random random = new Random();

        for (int i = 0; i < TOTAL_TRIALS; i++) {
            int prizeDoor = random.nextInt(3); // Randomly place prize behind one of three doors (0, 1, or 2)
            int contestantChoice = random.nextInt(3); // Contestant picks a random door

            if (contestantChoice == prizeDoor) {
                wins++; // Win if contestant's initial choice was the prize door
            }
        }
        return wins;
    }
    /**
     * Simulates the Monty Hall game with switching doors.
     * @return The number of wins when the contestant switches doors.
     */
    // Simulate 10,000 trials with switching
    public int simulateSwitch() {
        int wins = 0;
        Random random = new Random();

        for (int i = 0; i < TOTAL_TRIALS; i++) {
            int prizeDoor = random.nextInt(3); // Randomly place prize behind one of three doors (0, 1, or 2)
            int contestantChoice = random.nextInt(3); // Contestant picks a random door

            // Host reveals a dud door (one that isn't the prize and wasn't chosen by contestant)
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == prizeDoor || revealedDoor == contestantChoice);

            // Contestant switches to the remaining unopened door
            int switchedChoice = 3 - contestantChoice - revealedDoor;

            if (switchedChoice == prizeDoor) {
                wins++; // Win if the switched door was the prize door
            }
        }
        return wins;
    }
}
