/*
 * TestStackedAreaChart.java
 *
 * Created on March 16, 2006, 2:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.test;
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.*;
/**
 *
 * @author bhagvank
 */
public class TestStackedAreaChart {

    /** Creates a new instance of TestStackedAreaChart */
    public TestStackedAreaChart() {
    }


    public static CategoryDataset createDataset(Map dataMap)
    {
        double ad[][] = {
            {
                1.0D, 4D, 3D, 5D, 5D, 7D, 7D, 8D
            }, {
                5D, 7D, 6D, 8D, 4D, 4D, 2D, 1.0D
            }, {
                4D, 3D, 2D, 3D, 6D, 3D, 4D, 3D
            }
        };
        CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Series ", "Type ", ad);
        return categorydataset;
    }

    public static  JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedAreaChart("Stacked Area Chart", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setForegroundAlpha(0.85F);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setLowerMargin(0.0D);
        categoryaxis.setUpperMargin(0.0D);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setItemLabelsVisible(true);
        return jfreechart;
    }


}
