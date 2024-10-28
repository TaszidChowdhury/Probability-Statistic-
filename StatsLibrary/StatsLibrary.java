import java.math.BigInteger;
import java.util.*;
/**
 * StatsLibrary provides basic statistical and probability methods. 
 * You can use it to calculate averages, find modes, and do other
 * common statistical operations on lists of numbers.
 */

public class StatsLibrary {
/**
     * Calculates the average (mean) of a list of numbers.
     *
     * @param numbers A list of numbers to find the average.
     * @return The average (mean) value.
     */
    // Mean

    public double mean(List<Integer> numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }
    /**
     * Finds the middle value (median) in a list of numbers.
     *
     * @param numbers A list of numbers to find the median.
     * @return The median value.
     */

    // Median
    public double median(List<Integer> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 1) {
            return numbers.get(size / 2);
        } else {
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0;
        }
    }
    
    /**
     * Finds the most frequently occurring number(s) in a list.
     * 
     * @param numbers A list of numbers to find the mode.
     * @return A list of the number(s) that appear most often.
     */

    // Mode
    public List<Integer> mode(List<Integer> numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
        }
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }
     /**
     * Calculates the spread of numbers in a list (variance).
     *
     * @param numbers A list of numbers to find the variance.
     * @return The variance, which measures how spread out the numbers are.
     */

    // Variance
    public double variance(List<Integer> numbers) {
        double mean = mean(numbers);
        double sum = 0;
        for (int num : numbers) {
            sum += Math.pow(num - mean, 2);
        }
        return sum / numbers.size();  // Population variance
    }
    /**
     * Calculates the spread of numbers in a list (standard deviation).
     *
     * @param numbers A list of numbers to find the standard deviation.
     * @return The standard deviation, which is a measure of spread.
     */

    // Standard Deviation
    public double standardDeviation(List<Integer> numbers) {
        return Math.sqrt(variance(numbers)); // Standard deviation is sqrt of variance
    }

    /**
     * Finds the factorial of a number, which is the product of all positive integers up to that number.
     *
     * @param n The number to calculate factorial for.
     * @return The factorial of the number as a BigInteger.
     */ 

    // Factorial
    public BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Calculates the number of ways to arrange a selection of items in order (permutation).
     *
     * @param n Total number of items to choose from.
     * @param r Number of items to arrange.
     * @return The number of arrangements (permutations).
     */

    // Permutation
    public BigInteger permutation(int n, int r) {
        return factorial(n).divide(factorial(n - r));
    }

    /**
     * Calculates the number of ways to choose a group of items without regard to order (combination).
     *
     * @param n Total number of items to choose from.
     * @param r Number of items to choose.
     * @return The number of combinations.
     */

    // Combination
    public BigInteger combination(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    /**
     * Finds the probability of Event A happening given that Event B has already happened.
     *
     * @param eventA The set of outcomes for Event A.
     * @param eventB The set of outcomes for Event B.
     * @return The conditional probability of Event A given Event B.
     */
    // Conditional Probability
    public double conditionalProbability(Set<Integer> eventA, Set<Integer> eventB) {
        Set<Integer> intersection = new HashSet<>(eventA);
        intersection.retainAll(eventB);
        return (double) intersection.size() / eventB.size();  // Divide by size of Event B for P(A|B)
    }
    /**
     * Calculates the probability of the first success occurring on a certain trial
     * using geometric probability.
     *
     * @param trial The trial number on which the first success occurs.
     * @param successProbability The probability of success on each trial.
     * @return The probability of the first success on the specified trial.
     */

    // Geometric Distribution
    public double geometricDistribution(int trial, double successProbability) {
        return Math.pow(1 - successProbability, trial - 1) * successProbability;
    }
}
