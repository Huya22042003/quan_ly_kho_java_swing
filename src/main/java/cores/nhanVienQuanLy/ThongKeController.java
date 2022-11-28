/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeService;
import cores.nhanVienQuanLy.services.serviceImpls.NvqlLuongKiemKeServiceImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

/**
 *
 * @author window
 */
public class ThongKeController {

    private NvqlLuongKiemKeService thongKeService = null;

    public ThongKeController() {
        this.thongKeService = new NvqlLuongKiemKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<NvqlLuongKiemKeCustom> listItem = thongKeService.getAll();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (NvqlLuongKiemKeCustom item : listItem) {
                dataset.addValue(10, "Học viên", item.getNgayTao());
//                dataset.addValue(2, "a", item.getNgayTao());
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê số lượng sản phẩm theo ngày".toUpperCase(),
                    "Thời gian", "Số lượng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(1100, 250));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }

    }

    public void setDataToChart2(JPanel jpnItem) {
        List<NvqlLuongKiemKeCustom> listItem = thongKeService.getAll();

        TaskSeriesCollection ds = new TaskSeriesCollection();
        JFreeChart ganttChart = ChartFactory.createGanttChart(
                "BIỂU ĐỒ THEO DÕI TÌNH TRẠNG SẢN PHẨM",
                "Mã sản phẩm", "Thời gian", ds, true, false, false
        );

        TaskSeries taskSeries;
        Task task;

        if (listItem != null) {
            for (NvqlLuongKiemKeCustom item : listItem) {
                taskSeries = new TaskSeries(item.getMaPhieuKiem());
                task = new Task(item.getMaPhieuKiem(), new SimpleTimePeriod(item.getNgayTao(), item.getNgayTao()));
                taskSeries.add(task);
                ds.add(taskSeries);
            }
        }
//
        ChartPanel chartPanel = new ChartPanel(ganttChart);
        chartPanel.setPreferredSize(new Dimension(1100, 250));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
