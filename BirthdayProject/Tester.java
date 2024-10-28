package BirthdayProject;
/**
 * The Tester class runs the BirthdayProgram with a fixed class size
 * and number of simulation runs, then prints the probability of shared birthdays.
 */

public class Tester {
    /**
     * The main method runs the birthday probability calculation
     * with predefined class size and number of runs.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int classSize = 30; // Fixed number of students in the class
        int runs = 1000; // Fixed number of simulation runs for probability calculation
        
        BirthdayProgram program = new BirthdayProgram(classSize, runs);
        double probability = program.calculateProbability();
        
        System.out.printf("The probability of any two people sharing a birthday in a class of %d students is: %.2f%%\n", classSize, probability * 100);
    }
}
