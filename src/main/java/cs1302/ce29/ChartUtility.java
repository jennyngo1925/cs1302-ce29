package cs1302.ce29;

import java.util.Scanner;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import java.util.Arrays;

/**
 * A utility class for creating JavaFX {@code LineChart} objects.
 * The static methods in this class hide some of the details of
 * creating JavaFX line charts to allow the user to focus on the
 * contents of the chart instead of the chart creation details.
 */
public class ChartUtility {

    /**
     * Create a new {@code LineChart} from the provided x an y values and axis descriptors.
     * The returned {@code LineChart} object can be added to a JavaFX scene graph.
     * 
     * @return the {@code LineChart} object with x and y values set
     * @param xValues the provided x values
     * @param yValues the provided y values
     * @param xLabel the descriptor for the x-axis
     * @param yLabel the descriptor for the y-axis
     * @param yBound the upper bound for the y-axis
     * @param seriesName the name of the series for the legend
     */
    public static LineChart<Number, Number> createChart(Integer[] xValues, Double[] yValues,
                                                        String xLabel, String yLabel,
                                                        double yBound, String seriesName) {
        
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel(xLabel);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(yLabel);
        
        yAxis.setUpperBound(yBound);
        yAxis.setAutoRanging(false);
        
        LineChart<Number, Number> lc = new LineChart<Number, Number>(xAxis, yAxis);
        addSeries(lc, xValues, yValues, seriesName);

        return lc;
    } // createChart

    /**
     * Create a new series of data items from the specified x and y values and
     * add the series to the provided {@code LineChart}.
     *
     * @param chart the {@code LineChart} on which the series will be added
     * @param xValues the x values for the series
     * @param yValues the y values for the series
     * @param seriesName the name of the series for the legend
     */
    public static void addSeries(LineChart<Number, Number> chart, Integer[] xValues,
                                 Double[] yValues, String seriesName) {

        XYChart.Series<Number, Number> dataSet = new XYChart.Series<>();

        for (int i = 0; i < xValues.length; i++) {
            XYChart.Data<Number, Number> data = new XYChart.Data<>(xValues[i], yValues[i]);
            dataSet.getData().add(data);
        } // for

        dataSet.setName(seriesName);
        chart.getData().add(dataSet);
        
    } // addSeries

} // ChartUtility
