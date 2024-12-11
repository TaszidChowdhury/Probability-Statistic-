import java.io.*;
import java.util.Random;

public class FunctionSalter {


    public static void applySalt(String inputFile, String outputFile, double saltRange) throws IOException {
        // Validate salt range
        if (saltRange <= 0) {
            throw new IllegalArgumentException("Salt range must be greater than 0.");
        }

        Random random = new Random();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line = reader.readLine(); // Read the header
            if (line != null) {
                writer.write(line + "\n"); // Write the header to the output
            }

            // Process each line in the input file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) continue; // Skip invalid lines

                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);

                // Add random salt to y
                double salt = (random.nextDouble() * 2 - 1) * saltRange; // Random value in [-saltRange, saltRange]
                double saltedY = y + salt;

                // Write the salted values to the output file
                writer.write(x + "," + saltedY + "\n");
            }
        }
    }
}
