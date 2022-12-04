/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.truongPhongs.views;

import cores.Chart.model.ModelChartLine;
import cores.Chart.model.ModelChartPie;
import cores.Chart.service.LineService;
import cores.Chart.service.PieService;
import cores.Chart.service.serviceImpl.LineServiceImp;
import cores.Chart.service.serviceImpl.PieServiceImp;
import cores.truongPhongs.customModels.TpThongKeSpCustom;
import cores.truongPhongs.services.serviceImpls.TpTongSoSanPhamTrongKhoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import cores.truongPhongs.services.TpThongKeService;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import utilities.palette.SearchCustom.EventCallBack;
import utilities.palette.SearchCustom.EventTextField;

/**
 *
 * @author Acer
 */
public class TpThongKeView extends javax.swing.JPanel {

    /**
     * Creates new form TpThongKeView
     */
    private List<ModelChartPie> listPie = new ArrayList<>();
    private PieService servicePie;

    private List<ModelChartLine> listLine = new ArrayList<>();
    private LineService serviceLine;

    private TpThongKeService khoService = new TpTongSoSanPhamTrongKhoServiceImpl();
    private List<TpThongKeSpCustom> listSp = new ArrayList<>();

    public TpThongKeView() {
        initComponents();
        listSp = khoService.getListSp();

        lblTongSp.setText(khoService.getList().toString());
        lblSoSpDaBan.setText(khoService.getSoSanPhamDaXuat().toString());
        lblSoSpChuaBan.setText(khoService.getSoSanPhamDaNhap().toString());
        lblSoSpHoanNhap.setText(khoService.getSoLuongSpHoanNhap().toString());
        lblSoSpHoanXuat.setText(khoService.getSoLuongSpHoanXuat().toString());
        servicePie = new PieServiceImp();
        listPie = servicePie.getSoLuongSpTonNhieuNhat();
        chartPie1.setModel(listPie);
        serviceLine = new LineServiceImp();
        listLine = serviceLine.getSanPhamBanNhieuNhat();
        chartLine1.setModel(listLine);

        loadTableHD(listSp);

        txtSearch1.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                try {
                    for (int i = 1; i <= 100; i++) {

                        Thread.sleep(5);
                    }
                    call.done();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }

    public void loadTableHD(List<TpThongKeSpCustom> listSP) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblHoaDon.getModel();
        dtm.setRowCount(0);
        double dt;
        double d = 0;
        for (TpThongKeSpCustom tpThongKeSpCustom : listSP) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                tpThongKeSpCustom.getIdPhieuXuat().getId(),
                tpThongKeSpCustom.getIdPhieuXuat().getNhanVien().getMa(),
                tpThongKeSpCustom.getIdPhieuXuat().getNhanVien().getTen(),
                tpThongKeSpCustom.doanhThu()
            };

            dtm.addRow(rowData);
            dt = tpThongKeSpCustom.getIdCtsp().getGiaBan().multiply(new BigDecimal(tpThongKeSpCustom.getSoLuong())).doubleValue();

            d += dt;

        }
        lblTongDoanhThuTheoNgay.setText(String.valueOf(d));
    }

    public List<TpThongKeSpCustom> listSearch1(int rdo) {
        // nhập vào 
        String timKiem = this.txtSearch1.getText();
        List<TpThongKeSpCustom> listTimKiem = new ArrayList<>();

        // tìm kiếm theo tên mã vị trí
        listSp.forEach(el -> {
            String search = "";
            List<String> strings = new ArrayList<>();

            // truyền tham số
            switch (rdo) {
                case 0:
                    search = el.getIdPhieuXuat().getId().toString();
                    break;

                case 1:
                    search = el.getIdPhieuXuat().getNhanVien().getMa();
                    break;
                case 2:
                    search = el.getIdPhieuXuat().getNhanVien().getTen();
                    break;
            }
            for (int i = 0; i <= search.length(); i++) {
                String newMa = search.substring(0, i);
                strings.add(newMa);
            }
            // so sánh mảng vừa cắt với phần tử nhập vào
            for (String e : strings) {
                if (e.equalsIgnoreCase(timKiem)) {
                    listTimKiem.add(el);
                }
            }
        });

        return listTimKiem;
    }

    public void searchRadio1() {
        if (rdoMaHD.isSelected()) {
            loadTableHD(listSearch1(0));
        }
        if (rdoMaNv.isSelected()) {
            loadTableHD(listSearch1(1));
        }
        if (rdoTenNv.isSelected()) {
            loadTableHD(listSearch1(2));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        materialTabbed1 = new utilities.palette.MaterialTabbed();
        panelRound7 = new utilities.palette.PanelRound();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound6 = new utilities.palette.PanelRound();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        lblSoSpChuaBan = new javax.swing.JLabel();
        panelRound9 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        lblSoSpDaBan = new javax.swing.JLabel();
        panelRound15 = new utilities.palette.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        lblTongSp = new javax.swing.JLabel();
        panelRound10 = new utilities.palette.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        lblSoSpHoanXuat = new javax.swing.JLabel();
        panelRound11 = new utilities.palette.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        lblSoSpHoanNhap = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        panelRound20 = new utilities.palette.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new utilities.palette.TableDark_1();
        panelRound17 = new utilities.palette.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        lblTongDoanhThuTheoNgay = new javax.swing.JLabel();
        panelRound18 = new utilities.palette.PanelRound();
        rdoMaHD = new utilities.palette.RadioButtonCustom();
        txtSearch1 = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoMaNv = new utilities.palette.RadioButtonCustom();
        rdoTenNv = new utilities.palette.RadioButtonCustom();
        ngayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        ngayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chartLine1 = new cores.Chart.view.ChartLine();
        chartPie1 = new cores.Chart.view.ChartPie();

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        panelRound7.setBackground(new java.awt.Color(204, 204, 255));
        panelRound7.setRoundBottomLeft(50);
        panelRound7.setRoundBottomRight(50);
        panelRound7.setRoundTopLeft(50);
        panelRound7.setRoundTopRight(50);

        panelRound1.setBackground(new java.awt.Color(67, 130, 187));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        panelRound6.setBackground(new java.awt.Color(204, 204, 255));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        panelRound5.setBackground(new java.awt.Color(0, 153, 153));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Số sản phẩm đã nhập");

        lblSoSpChuaBan.setBackground(new java.awt.Color(255, 255, 255));
        lblSoSpChuaBan.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSoSpChuaBan.setForeground(new java.awt.Color(255, 255, 255));
        lblSoSpChuaBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoSpChuaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoSpChuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        panelRound9.setBackground(new java.awt.Color(0, 153, 153));
        panelRound9.setRoundBottomLeft(50);
        panelRound9.setRoundBottomRight(50);
        panelRound9.setRoundTopLeft(50);
        panelRound9.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Số sản phẩm đã bán  ");

        lblSoSpDaBan.setBackground(new java.awt.Color(255, 255, 255));
        lblSoSpDaBan.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSoSpDaBan.setForeground(new java.awt.Color(255, 255, 255));
        lblSoSpDaBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSoSpDaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSoSpDaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelRound15.setBackground(new java.awt.Color(0, 153, 153));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tổng sản phẩm đang có");

        lblTongSp.setBackground(new java.awt.Color(255, 255, 255));
        lblTongSp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTongSp.setForeground(new java.awt.Color(255, 255, 255));
        lblTongSp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblTongSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongSp, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound10.setBackground(new java.awt.Color(0, 153, 153));
        panelRound10.setRoundBottomLeft(50);
        panelRound10.setRoundBottomRight(50);
        panelRound10.setRoundTopLeft(50);
        panelRound10.setRoundTopRight(50);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Số sản phẩm đã hoàn(Xuất)");

        lblSoSpHoanXuat.setBackground(new java.awt.Color(255, 255, 255));
        lblSoSpHoanXuat.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSoSpHoanXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblSoSpHoanXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoSpHoanXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSoSpHoanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound11.setBackground(new java.awt.Color(0, 153, 153));
        panelRound11.setRoundBottomLeft(50);
        panelRound11.setRoundBottomRight(50);
        panelRound11.setRoundTopLeft(50);
        panelRound11.setRoundTopRight(50);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Số sản phẩm đã hoàn(Nhập)");

        lblSoSpHoanNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblSoSpHoanNhap.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSoSpHoanNhap.setForeground(new java.awt.Color(255, 255, 255));
        lblSoSpHoanNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoSpHoanNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSoSpHoanNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound6Layout.createSequentialGroup()
                        .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound6Layout.createSequentialGroup()
                                .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound8.setBackground(new java.awt.Color(204, 204, 255));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        panelRound20.setBackground(new java.awt.Color(67, 130, 187));
        panelRound20.setRoundBottomLeft(50);
        panelRound20.setRoundBottomRight(50);
        panelRound20.setRoundTopLeft(50);
        panelRound20.setRoundTopRight(50);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DOANH THU THEO NGÀY");

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel17)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Mã NV", "Tên NV", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        panelRound17.setBackground(new java.awt.Color(0, 153, 153));
        panelRound17.setRoundBottomLeft(50);
        panelRound17.setRoundBottomRight(50);
        panelRound17.setRoundTopLeft(50);
        panelRound17.setRoundTopRight(50);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng doanh thu theo ngày");

        lblTongDoanhThuTheoNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblTongDoanhThuTheoNgay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTongDoanhThuTheoNgay.setForeground(new java.awt.Color(255, 255, 255));
        lblTongDoanhThuTheoNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTongDoanhThuTheoNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongDoanhThuTheoNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound18.setBackground(new java.awt.Color(67, 130, 187));
        panelRound18.setRoundBottomLeft(50);
        panelRound18.setRoundBottomRight(50);
        panelRound18.setRoundTopLeft(50);
        panelRound18.setRoundTopRight(50);

        rdoMaHD.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup2.add(rdoMaHD);
        rdoMaHD.setForeground(new java.awt.Color(255, 255, 255));
        rdoMaHD.setSelected(true);
        rdoMaHD.setText("Mã HD");
        rdoMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearch1MouseClicked(evt);
            }
        });

        rdoMaNv.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup2.add(rdoMaNv);
        rdoMaNv.setForeground(new java.awt.Color(255, 255, 255));
        rdoMaNv.setText("Mã NV");
        rdoMaNv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoTenNv.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup2.add(rdoTenNv);
        rdoTenNv.setForeground(new java.awt.Color(255, 255, 255));
        rdoTenNv.setText("Tên NV");
        rdoTenNv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound18Layout = new javax.swing.GroupLayout(panelRound18);
        panelRound18.setLayout(panelRound18Layout);
        panelRound18Layout.setHorizontalGroup(
            panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rdoMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound18Layout.setVerticalGroup(
            panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ngayBatDau.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ngayBatDauInputMethodTextChanged(evt);
            }
        });

        jLabel6.setText("To:");

        jLabel8.setText("From:");

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelRound8Layout.createSequentialGroup()
                        .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(panelRound18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ngayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(panelRound17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Thống kê sản phẩm", panelRound7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartPie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(chartPie1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        materialTabbed1.addTab("Biểu đồ thống kê", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void searchTheoNgay() {
        if (ngayBatDau == null) {
            return;
        }
        if (ngayKetThuc == null) {
            return;
        }
        listSp = khoService.getListByNgayThanhToan(ngayBatDau.getDate().getTime(), ngayKetThuc.getDate().getTime());
        loadTableHD(listSp);
    }
    private void txtSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearch1MouseClicked
        searchRadio1();
        searchTheoNgay();

    }//GEN-LAST:event_txtSearch1MouseClicked

    private void ngayBatDauInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ngayBatDauInputMethodTextChanged
//        // TODO add your handling code here:
//        TimKiemTheoNgay();
    }//GEN-LAST:event_ngayBatDauInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private cores.Chart.view.ChartLine chartLine1;
    private cores.Chart.view.ChartPie chartPie1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSoSpChuaBan;
    private javax.swing.JLabel lblSoSpDaBan;
    private javax.swing.JLabel lblSoSpHoanNhap;
    private javax.swing.JLabel lblSoSpHoanXuat;
    private javax.swing.JLabel lblTongDoanhThuTheoNgay;
    private javax.swing.JLabel lblTongSp;
    private utilities.palette.MaterialTabbed materialTabbed1;
    private com.toedter.calendar.JDateChooser ngayBatDau;
    private com.toedter.calendar.JDateChooser ngayKetThuc;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound10;
    private utilities.palette.PanelRound panelRound11;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound17;
    private utilities.palette.PanelRound panelRound18;
    private utilities.palette.PanelRound panelRound20;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound6;
    private utilities.palette.PanelRound panelRound7;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.PanelRound panelRound9;
    private utilities.palette.RadioButtonCustom rdoMaHD;
    private utilities.palette.RadioButtonCustom rdoMaNv;
    private utilities.palette.RadioButtonCustom rdoTenNv;
    private utilities.palette.TableDark_1 tblHoaDon;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearch1;
    // End of variables declaration//GEN-END:variables
}
