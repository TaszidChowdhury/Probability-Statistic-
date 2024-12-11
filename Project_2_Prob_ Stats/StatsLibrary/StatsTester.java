package StatsLibrary;

import java.util.*;
import java.util.Scanner;
import java.util.Collections;
public class StatsTester {
	public static void main(String[] args) {
		StatsLibrary lib = new StatsLibrary();
		
		//Poisson Distribution Tests
		System.out.printf("Poisson Distribution (lambda=2, y = 4): %.3f", lib.poissonDistribution(2, 4));
		System.out.println("\n\nPoisson Distribution - Expected Value and Variance: " + lib.poissonExpectedAndVariance(2));
		System.out.printf("\nPoisson Distribution - Standard Deviation: %.3f", lib.poissonStandardDeviation(2));
		
		//Chebyshev Tests
		System.out.printf("\n\nPercentage of values between 16 and 24 "
				+ "\n(mean=20, standard deviation=2): %.3f", lib.chebyshev(16, 24, 20, 2));
		System.out.printf("\n\nPercentage of values between 16 and 24 "
				+ "\n(mean=20, variance=4): %.3f", lib.chebyshevGivenVariance(16, 24, 20, 4));
		
		
		//Uniform Distribution Tests
		System.out.printf("\n\nUniform Distribution "
				+ "\n(a=5, b=15, c=0, d=20): %.3f", lib.uniformDistribution(5, 15, 0, 20));
		System.out.printf("\n\nUniform Distribution - Expected Value"
				+ "\n(c=1, d=20): %.3f", lib.uniformExpectedValue(1, 20));
		System.out.printf("\n\nUniform Distribution - Variance: %.3f", lib.uniformVariance(1, 20));
		System.out.printf("\n\nUniform Distribution - Standard Deviation: %.3f", lib.uniformStandardDeviation(1, 20));
	}
}