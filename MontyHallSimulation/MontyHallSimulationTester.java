package MontyHallSimulation;
/**
 * MontyHallSimulationTester tests the Monty Hall simulation by running both the switch and no-switch strategies.
 * It checks if the results fall within expected probability ranges.
 */
public class MontyHallSimulationTester {
    /**
     * The main method to run the tests for the Monty Hall simulation.
     * It prints the win percentages and verifies if they fall within expected ranges.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Instantiate the GameSimulator
        GameSimulator simulator = new GameSimulator();

        // Run the simulation and store the results
        double winPercentageNoSwitch = (simulator.simulateNoSwitch() / (double) GameSimulator.TOTAL_TRIALS) * 100;
        double winPercentageSwitch = (simulator.simulateSwitch() / (double) GameSimulator.TOTAL_TRIALS) * 100;

        // Print the results
        System.out.printf("Test Result - Win percentage without switching: %.2f%%%n", winPercentageNoSwitch);
        System.out.printf("Test Result - Win percentage with switching: %.2f%%%n", winPercentageSwitch);

        // Basic assertions to check if results are within reasonable ranges
        assert winPercentageNoSwitch >= 30.0 && winPercentageNoSwitch <= 40.0 :
                "Test failed: Win percentage without switching is out of expected range.";
        assert winPercentageSwitch >= 60.0 && winPercentageSwitch <= 70.0 :
                "Test failed: Win percentage with switching is out of expected range.";

        System.out.println("All tests passed.");
    }
}
