import java.io.IOException;

public class Tester {

    public static void main(String[] args) {
        // Plotter Tests: Small samples
        String plotFileSmall1 = "plot_data_small_1.csv";
        testPlotter(-10, 10, 1, plotFileSmall1); // Small range, low density

        String plotFileSmall2 = "plot_data_small_2.csv";
        testPlotter(0, 50, 5, plotFileSmall2); // Moderate range, very low density

        // Plotter Tests: Large samples
        String plotFileLarge1 = "plot_data_large_1.csv";
        testPlotter(-100, 100, 0.01, plotFileLarge1); // Large range, high density

        String plotFileLarge2 = "plot_data_large_2.csv";
        testPlotter(0, 1000, 0.1, plotFileLarge2); // Very large range, moderate density

        // Salter Tests: Apply salt to small and large datasets
        // Small samples
        String saltedFileSmall1 = "salted_data_small_1.csv";
        testSalter(plotFileSmall1, saltedFileSmall1, 5); // Low volatility

        String saltedFileSmall2 = "salted_data_small_2.csv";
        testSalter(plotFileSmall2, saltedFileSmall2, 20); // Medium volatility

        // Large samples
        String saltedFileLarge1 = "salted_data_large_1.csv";
        testSalter(plotFileLarge1, saltedFileLarge1, 5); // Low volatility

        String saltedFileLarge2 = "salted_data_large_2.csv";
        testSalter(plotFileLarge2, saltedFileLarge2, 50); // High volatility

        // Smoother Tests: Apply smoothing to small and large datasets
        // Small samples
        testSmoother(saltedFileSmall1, "smoothed_data_small_1.csv", 2); // Small window size
        testSmoother(saltedFileSmall2, "smoothed_data_small_2.csv", 3); // Moderate window size

        // Large samples
        testSmoother(saltedFileLarge1, "smoothed_data_large_1.csv", 10); // Moderate window size
        testSmoother(saltedFileLarge2, "smoothed_data_large_2.csv", 50); // Large window size
    }

    /**
     * Runs a single test case for the FunctionPlotter.
     *
     * @param start    The starting x value
     * @param end      The ending x value
     * @param interval The interval between x values
     * @param fileName The output CSV file name
     */
    private static void testPlotter(double start, double end, double interval, String fileName) {
        try {
            System.out.println("Generating plot data: " + fileName);
            FunctionPlotter.generatePlotData(start, end, interval, fileName);
            System.out.println("Data successfully written to " + fileName);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: Could not write to file " + fileName);
        }
    }

    /**
     * Runs a single test case for the FunctionSalter.
     *
     * @param inputFile  The input CSV file
     * @param outputFile The output CSV file with salted data
     * @param saltRange  The range of salt to apply to y-values
     */
    private static void testSalter(String inputFile, String outputFile, double saltRange) {
        try {
            System.out.println("Applying salt to: " + inputFile + " with range " + saltRange);
            FunctionSalter.applySalt(inputFile, outputFile, saltRange);
            System.out.println("Salted data successfully written to " + outputFile);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: Could not write to file " + outputFile);
        }
    }

    /**
     * Runs a single test case for the GraphSmoother.
     *
     * @param inputFile  The input CSV file (salted data)
     * @param outputFile The output CSV file with smoothed data
     * @param windowSize The window size for smoothing
     */
    private static void testSmoother(String inputFile, String outputFile, int windowSize) {
        try {
            System.out.println("Smoothing data: " + inputFile + " with window size " + windowSize);
            GraphSmoother.smoothData(inputFile, outputFile, windowSize);
            System.out.println("Smoothed data successfully written to " + outputFile);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: Could not write to file " + outputFile);
        }
    }
}
