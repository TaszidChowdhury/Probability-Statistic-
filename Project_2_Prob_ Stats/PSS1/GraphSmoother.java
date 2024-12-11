import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GraphSmoother {

    public static void smoothData(String inputFile, String outputFile, int windowSize) throws IOException {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("Window size must be greater than 0.");
        }

        // Read the input CSV file into memory
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine(); // Read the header
            if (line == null || !line.equals("x,y")) {
                throw new IllegalArgumentException("Invalid input file format. Expected a header 'x,y'.");
            }

            // Read data points
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) continue; // Skip invalid lines
                xValues.add(Double.parseDouble(parts[0]));
                yValues.add(Double.parseDouble(parts[1]));
            }
        }

        // Apply smoothing to y-values
        List<Double> smoothedYValues = new ArrayList<>();
        int n = yValues.size();
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - windowSize);
            int right = Math.min(n - 1, i + windowSize);

            // Compute the average of the values in the window
            double sum = 0;
            int count = 0;
            for (int j = left; j <= right; j++) {
                sum += yValues.get(j);
                count++;
            }
            smoothedYValues.add(sum / count);
        }

        // Write the smoothed data to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("x,y\n");
            for (int i = 0; i < xValues.size(); i++) {
                writer.write(xValues.get(i) + "," + smoothedYValues.get(i) + "\n");
            }
        }
    }
}
