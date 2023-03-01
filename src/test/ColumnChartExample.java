package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class ColumnChartExample extends JFrame {
    public ColumnChartExample() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100000, "Sales", "Tháng 1");
        dataset.setValue(150000, "Sales", "Tháng 2");
        dataset.setValue(200000, "Sales", "Tháng 3");
        dataset.setValue(250000, "Sales", "Tháng 4");
        dataset.setValue(100000, "Sales", "Tháng 5");
        dataset.setValue(150000, "Sales", "Tháng 6");
        dataset.setValue(200000, "Sales", "Tháng 7");
        dataset.setValue(250000, "Sales", "Tháng 8");
        dataset.setValue(100000, "Sales", "Tháng 9");
        dataset.setValue(150000, "Sales", "Tháng 10");
        dataset.setValue(200000, "Sales", "Tháng 11");
        dataset.setValue(250000, "Sales", "Tháng 12");
        JFreeChart chart = ChartFactory.createBarChart("Thông kê tiền điện", "Tháng", "vnd", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ColumnChartExample();
    }
}
