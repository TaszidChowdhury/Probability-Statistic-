import java.math.BigInteger;
import java.util.*;

public class StatsLibraryTester {

    public static void main(String[] args) {
        StatsLibrary stats = new StatsLibrary();

        // New example sets for testing
        List<Integer> setA = Arrays.asList(2, 4, 4, 5, 7, 10);
        List<Integer> setB = Arrays.asList(3, 4, 6, 8, 8);

        // Test Mean
        System.out.println("Mean of Set A: " + stats.mean(setA));

        // Test Median
        System.out.println("Median of Set A: " + stats.median(setA));

        // Test Mode
        System.out.println("Mode of Set A: " + stats.mode(setA));

        // Test Standard Deviation
        System.out.println("Standard Deviation of Set A: " + stats.standardDeviation(setA));

        // Test Variance
        System.out.println("Variance of Set A: " + stats.variance(setA));

        // Test Factorial
        System.out.println("Factorial of 5: " + stats.factorial(5));

        // Test Permutation
        System.out.println("Permutation (5, 3): " + stats.permutation(5, 3));

        // Test Combination
        System.out.println("Combination (5, 3): " + stats.combination(5, 3));

        // Test Conditional Probability
        Set<Integer> eventA = new HashSet<>(Arrays.asList(4, 5, 7));
        Set<Integer> eventB = new HashSet<>(Arrays.asList(3, 4, 6, 8));
        System.out.println("Conditional Probability of A given B: " + stats.conditionalProbability(eventA, eventB));

        // Test Geometric Distribution
        System.out.println("Geometric Distribution (Trial 3, p=0.4): " + stats.geometricDistribution(3, 0.4));
    }
}
