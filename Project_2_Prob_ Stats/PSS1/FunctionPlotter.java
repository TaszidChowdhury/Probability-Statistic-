import java.io.FileWriter;
import java.io.IOException;

public class FunctionPlotter {


    public static void generatePlotData(double start, double end, double interval, String fileName) throws IOException {
        // Validate range and interval
        if (start >= end || interval <= 0) {
            throw new IllegalArgumentException("Invalid range or interval. Ensure start < end and interval > 0.");
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write CSV header
            writer.write("x,y\n");

            // Generate data points
            for (double x = start; x <= end; x += interval) {
                double y = function(x); // Compute y = f(x)
                writer.write(x + "," + y + "\n");
            }
        }
    }

    /**
     * Define the function to plot.
     * For example, f(x) = x^2 - 2x + 1
     *
     * @param x The input value
     * @return The function output
     */
    private static double function(double x) {
        // Example: quadratic function
        return Math.pow(x, 2) - 2 * x + 1;
    }
}
