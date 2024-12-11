import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Smoother {
    public static void smoothData(String inputFile, String outputFile, int windowSize) throws IOException {
        XYSeries series = new XYSeries("Smoothed Data");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            writer.write("x,y\n"); // Write header
            String line;
            reader.readLine(); // Skip header

            Queue<Double> window = new LinkedList<>();
            double sum = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);

                if (window.size() == windowSize) {
                    sum -= window.poll();
                }

                window.add(y);
                sum += y;
                double smoothedY = sum / window.size();
                series.add(x, smoothedY);
                writer.write(String.format("%.2f,%.2f\n", x, smoothedY));
            }
        }

        // Create dataset for chart
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Generate chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Smoothed Data Plot",
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
