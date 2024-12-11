// Updated Plotter.java
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.FileWriter;
import java.io.IOException;

public class Plotter {
    public static void generatePlotData(double start, double end, double interval, String fileName) throws IOException {
        WeightedObservedPoints points = new WeightedObservedPoints();
        XYSeries series = new XYSeries("Quadratic Function");

        // Generate data and save to CSV
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("x,y\n");
            for (double x = start; x <= end; x += interval) {
                double y = x * x - 2 * x + 1; // Quadratic function
                points.add(x, y);
                series.add(x, y);
                writer.write(String.format("%.2f,%.2f\n", x, y));
            }
        }

        // Fit polynomial
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2); // Quadratic
        double[] coefficients = fitter.fit(points.toList());
        PolynomialFunction polynomial = new PolynomialFunction(coefficients);
        System.out.println("Fitted Polynomial: " + polynomial);

        // Create dataset for chart
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Generate chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Quadratic Function Plot",
                "X",
                "Y",
                dataset
        );

        // Save chart as PNG
        String chartFileName = fileName.replace(".csv", ".png");
        ChartUtils.saveChartAsPNG(new java.io.File(chartFileName), chart, 800, 600);

        System.out.println("Chart saved as: " + chartFileName);
    }
}
