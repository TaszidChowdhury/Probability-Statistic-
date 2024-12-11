package StatsLibrary;

import java.util.*;
import java.lang.Math;
import java.math.BigInteger;

public class StatsLibrary {

	//BigInteger Factorial
    public BigInteger factorial(int x) {
        BigInteger result = BigInteger.valueOf(x);
        
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result;
    }

    //BigInteger Combination
    public BigInteger combination(int n, int r) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(r).multiply(factorial(n - r));
        
        return numerator.divide(denominator);
    }

    //Poisson Distribution
    public double poissonDistribution(int lambda, int y) {
        double expLambda = Math.exp(-lambda);
        double numerator = Math.pow(lambda, y);
        double denominator = factorial(y).doubleValue();
        return (numerator / denominator) * expLambda;
    }

    //Expected value and variance of a Poisson distribution.
    public int poissonExpectedAndVariance(int lambda) {
        return lambda;
    }

    //Standard deviation of a Poisson distribution.
    public double poissonStandardDeviation(int lambda) {
        return Math.sqrt(lambda);
    }

    //Chebyshev's
    public double chebyshev(double lowerRange, double upperRange, double mean, double standardDeviation) {
        double k = (upperRange - mean) / standardDeviation;
        return 1 - (1 / (k * k));
    }

    //Given variance for Chebyshev's
    public double chebyshevGivenVariance(double lowerRange, double upperRange, double mean, double variance) {
        double standardDeviation = Math.sqrt(variance);
        double k = (upperRange - mean) / standardDeviation;
        return 1 - (1 / (k * k));
    }

    //Uniform Distribution
    public double uniformDistribution(int a, int b, int c, int d) {
        double intervalUpperBound = d;
        return (b - a) / (intervalUpperBound - c);
    }

    //Expected value of Uniform distribution
    public double uniformExpectedValue(int c, int d) {
        double intervalUpperBound = d;
        return (intervalUpperBound + c) / 2;
    }

    //Variance of uniform distribution
    public double uniformVariance(int c, int d) {
        double intervalUpperBound = d;
        return ((intervalUpperBound - c) * (intervalUpperBound - c)) / 12;
    }

    //Standard deviation of uniform distribution
    public double uniformStandardDeviation(int c, int d) {
        return Math.sqrt(uniformVariance(c, d));
    }
}