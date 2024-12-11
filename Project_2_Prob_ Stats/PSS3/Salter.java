import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Salter {
    public static void applySalt(String inputFile, String outputFile, double saltRange) throws IOException {
        Random random = new Random();
        XYSeries series = new XYSeries("Salted Data");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            writer.write("x,y\n"); // Write header
            String line;
            reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                double salt = (random.nextDouble() * saltRange) - (saltRange / 2);
                y += salt;
                series.add(x, y);
                writer.write(String.format("%.2f,%.2f\n", x, y));
            }
        }

        // Create dataset for chart
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Generate chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Salted Data Plot",
                "X",
                "Y",
                dataset
        );

        // Save chart as PNG
        String chartFileName = outputFile.replace(".csv", ".png");
        ChartUtils.saveChartAsPNG(new java.io.File(chartFileName), chart, 800, 600);

        System.out.println("Chart saved as: " + chartFileName);
    }
}
