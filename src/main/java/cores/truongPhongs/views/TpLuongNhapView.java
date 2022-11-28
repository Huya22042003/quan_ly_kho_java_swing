/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.truongPhongs.views;

import cores.nhanVienQuanLy.services.NVQLQuanLyPhieuXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.NVQLQuanLyPhieuXuatServiceImpl;
import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import cores.truongPhongs.services.serviceImpls.TpPhieuNhapServiceImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import cores.truongPhongs.services.TpPhieuNhapService;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;
import utilities.Converter;
import utilities.palette.SearchCustom.EventCallBack;
import utilities.palette.SearchCustom.EventTextField;

/**
 *
 * @author Acer
 */
public class TpLuongNhapView extends javax.swing.JPanel {

    /**
     * Creates new form luongNhapHang
     */
    private TpPhieuNhapService phieuNhapService;
    private List<TpPhieuNhapCustom> listPn ;

    public TpLuongNhapView() {
        initComponents();
        listPn = new ArrayList<>();
        phieuNhapService = new TpPhieuNhapServiceImpl();
        listPn = phieuNhapService.getListPn();
        this.loadTablePn(listPn);
        this.loadCbbTrangThai();
        this.clearForm();
           txtSearch.addEvent(new EventTextField() {
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

    TpLuongNhapView(UUID id) {
        initComponents();
        phieuNhapService = new TpPhieuNhapServiceImpl();
          listPn = new ArrayList<>();
        TpPhieuNhapCustom phieuNhap = new TpPhieuNhapCustom();
        phieuNhap.setIdNcc(id);
        phieuNhap.setIdNhanVien(UUID.fromString("6e6bd9d9-e92b-7247-b2ee-f75d2f528127"));
        phieuNhapService.addPn(phieuNhap);
        this.loadTablePn(listPn);
    }

    private void loadCbbTrangThai() { 
        this.cbbTrangThai.addItem(Converter.trangThaiDonHang(TrangThaiPhieuConstant.CHO_THANH_TOAN));
        this.cbbTrangThai.addItem(Converter.trangThaiDonHang(TrangThaiPhieuConstant.DA_HUY));
        this.cbbTrangThai.addItem(Converter.trangThaiPhieuNhap(TrangThaiPhieuConstant.DA_THANH_TOAN));
    }
   
    public List<TpPhieuNhapCustom> listSearch(int rdo) {
        // nhập vào 
        String timKiem = this.txtSearch.getText();
        List<TpPhieuNhapCustom> listTimKiem = new ArrayList<>();

        // tìm kiếm theo tên mã vị trí
        checkCbb(phieuNhapService.loc(this.cbbTrangThai.getSelectedIndex())).forEach(el -> {
            String search = "";
            List<String> strings = new ArrayList<>();

            // truyền tham số
            switch (rdo) {
                case 0:
                    search = el.getId().toString();
                    break;

                case 1:
                    search = el.getTenNcc();
                    break;
                case 2:
                    search = el.getTenNhanVien();
                    break;
            }
            // cắt phần tử rồi ném vào mảng String[] vd Hà Nội =>  H, à , , N, ộ, i => [
//                                                                                      "H",
//                                                                                       "Hà",
//                                                                                      "Hà ",
//                                                                                      "Hà N"
//                                                                                       ....,
//                                                                                      "Hà Nội"]
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

    public List<TpPhieuNhapCustom> checkCbb(TrangThaiPhieuConstant cs) {
        List<TpPhieuNhapCustom> listTimKiem = new ArrayList<>();
        listPn.forEach(el -> {
            if (el.getTrangThai() == cs) {
                listTimKiem.add(el);
            }
        });
        return listTimKiem;
    }

    public void clearForm() {
        this.txtSearch.setText("");
        this.rdoMa.setSelected(true);
        listPn = phieuNhapService.getListPn();
        searchRadio();
    }
     public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTablePn(listSearch(0));
        }  else if (rdoNcc.isSelected()) {
            loadTablePn(listSearch(1));
        } else {
            loadTablePn(listSearch(2));
        }
    }

    private void loadTablePn(List<TpPhieuNhapCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        dtm.setRowCount(0);
        for (TpPhieuNhapCustom pn : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                pn.getId(),
                new Date(pn.getNgayTao()),
                pn.getNgayThanhToan() == null ? null : new Date(pn.getNgayThanhToan()),
                pn.getTenNcc(),
                pn.getTenNhanVien(),
                Converter.trangThaiPhieuNhap(pn.getTrangThai())
            };
            dtm.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoMa = new utilities.palette.RadioButtonCustom();
        rdoNcc = new utilities.palette.RadioButtonCustom();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        txtSearch = new utilities.palette.SearchCustom.TextFieldAnimation();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        cbbTrangThai = new utilities.palette.Combobox();
        btnKhoangTime = new utilities.palette.MyButton();
        panelRound15 = new utilities.palette.PanelRound();
        btnPhieuNhapChiTiet = new utilities.palette.MyButton();
        btnThemPhieuNhapMoi = new utilities.palette.MyButton();
        btnThemSpVaoPhieu = new utilities.palette.MyButton();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtNgayTao = new utilities.palette.TextField();
        txtMaPhieu = new utilities.palette.TextField();
        textAreaScroll1 = new utilities.palette.TextAreaScroll();
        txtGhiChu = new utilities.palette.TextAreaCustom();
        txtTienPhaiTra = new utilities.palette.TextField();
        myButton7 = new utilities.palette.MyButton();
        txtNhaCungCap = new utilities.palette.TextField();
        txtNhanVien = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu", "Ngày tạo", "Ngày thanh toán", "Nhà cung cấp", "Nhân viên", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        rdoMa.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoMa);
        rdoMa.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa.setText("Mã");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaActionPerformed(evt);
            }
        });

        rdoNcc.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoNcc);
        rdoNcc.setForeground(new java.awt.Color(255, 255, 255));
        rdoNcc.setText("Nhà cung cấp");
        rdoNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNccActionPerformed(evt);
            }
        });

        rdoNhanVien.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setText("Nhân viên");
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANH SÁCH PHIẾU NHẬP");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound8.setBackground(new java.awt.Color(67, 130, 187));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        cbbTrangThai.setBackground(new java.awt.Color(67, 130, 187));
        cbbTrangThai.setToolTipText("Chọn trạng thái để tìm kiếm");
        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbTrangThai.setLabeText("Trạng thái");
        cbbTrangThai.setLineColor(new java.awt.Color(145, 200, 249));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        btnKhoangTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendarrrrrr.png"))); // NOI18N
        btnKhoangTime.setToolTipText("Chọn khoảng thời gian để tìm kiếm");
        btnKhoangTime.setBorderColor(new java.awt.Color(221, 242, 244));
        btnKhoangTime.setColor(new java.awt.Color(221, 242, 244));
        btnKhoangTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhoangTime.setRadius(50);
        btnKhoangTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoangTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btnKhoangTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKhoangTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        btnPhieuNhapChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnPhieuNhapChiTiet.setToolTipText("Phiếu nhập chi tiết");
        btnPhieuNhapChiTiet.setBorderColor(new java.awt.Color(221, 242, 244));
        btnPhieuNhapChiTiet.setColor(new java.awt.Color(221, 242, 244));
        btnPhieuNhapChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPhieuNhapChiTiet.setRadius(50);
        btnPhieuNhapChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapChiTietActionPerformed(evt);
            }
        });

        btnThemPhieuNhapMoi.setBackground(new java.awt.Color(221, 242, 244));
        btnThemPhieuNhapMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThemPhieuNhapMoi.setToolTipText("Thêm mới phiếu nhập");
        btnThemPhieuNhapMoi.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThemPhieuNhapMoi.setColor(new java.awt.Color(221, 242, 244));
        btnThemPhieuNhapMoi.setRadius(50);
        btnThemPhieuNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhieuNhapMoiActionPerformed(evt);
            }
        });

        btnThemSpVaoPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-to-basket.png"))); // NOI18N
        btnThemSpVaoPhieu.setToolTipText("Thêm sản phẩm muốn nhập");
        btnThemSpVaoPhieu.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThemSpVaoPhieu.setColor(new java.awt.Color(221, 242, 244));
        btnThemSpVaoPhieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSpVaoPhieu.setRadius(50);
        btnThemSpVaoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSpVaoPhieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnThemPhieuNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPhieuNhapChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemSpVaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemPhieuNhapMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnPhieuNhapChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSpVaoPhieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin phiếu nhập");

        txtNgayTao.setEditable(false);
        txtNgayTao.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTao.setLabelText("Ngày tạo");

        txtMaPhieu.setBackground(new java.awt.Color(228, 206, 224));
        txtMaPhieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaPhieu.setLabelText("Mã phiếu ");
        txtMaPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuActionPerformed(evt);
            }
        });

        textAreaScroll1.setBackground(new java.awt.Color(153, 204, 255));
        textAreaScroll1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textAreaScroll1.setLabelText("Ghi chú");

        txtGhiChu.setBackground(new java.awt.Color(228, 206, 224));
        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.setDisabledTextColor(new java.awt.Color(204, 204, 255));
        textAreaScroll1.setViewportView(txtGhiChu);

        txtTienPhaiTra.setEditable(false);
        txtTienPhaiTra.setBackground(new java.awt.Color(228, 206, 224));
        txtTienPhaiTra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienPhaiTra.setLabelText("Tiền phải trả");

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/credit-card.png"))); // NOI18N
        myButton7.setText("THANH TOÁN");
        myButton7.setToolTipText("THANH TOÁN");
        myButton7.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton7.setColor(new java.awt.Color(221, 242, 244));
        myButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton7.setRadius(50);

        txtNhaCungCap.setEditable(false);
        txtNhaCungCap.setBackground(new java.awt.Color(228, 206, 224));
        txtNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhaCungCap.setLabelText("Nhà cung cấp");

        txtNhanVien.setEditable(false);
        txtNhanVien.setBackground(new java.awt.Color(228, 206, 224));
        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhanVien.setLabelText("Nhân viên");
        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });

        txtTrangThai.setEditable(false);
        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");
        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienPhaiTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNhanVienActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void rdoNccActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rdoNccActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoNccActionPerformed

    private void rdoMaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rdoMaActionPerformed
        searchRadio();
    }//GEN-LAST:event_rdoMaActionPerformed

    private void cbbTrangThaiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        // TODO add your handling code here:
         listSearch(this.cbbTrangThai.getSelectedIndex());
        searchRadio();
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnThemPhieuNhapMoiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnThemPhieuNhapMoiActionPerformed
            Tp_ThemNccVaoPhieuNhapForm themNcc = new Tp_ThemNccVaoPhieuNhapForm();
            themNcc.setVisible(true);
            
    }//GEN-LAST:event_btnThemPhieuNhapMoiActionPerformed

    private void txtMaPhieuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void btnKhoangTimeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnKhoangTimeActionPerformed
        // TODO add your handling code here:
       TpLuongNhapChonKhongTimeView time = new TpLuongNhapChonKhongTimeView();
       time.setVisible(true);
    }//GEN-LAST:event_btnKhoangTimeActionPerformed

    private void btnPhieuNhapChiTietActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPhieuNhapChiTietActionPerformed

    private void txtNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void btnThemSpVaoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpVaoPhieuActionPerformed
        int row = this.tblPhieuNhap.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một phiếu nhập chưa thanh toán!");
            return;
        }
        if(tblPhieuNhap.getValueAt(row, 6).toString().equals("Đã thanh toán") || tblPhieuNhap.getValueAt(row, 6).toString().equals("Đã hủy")){
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một phiếu nhập chưa thanh toán!");
            return;
        }
        TpChonSanPhamThemVaoPhieuNhap chonSp = new TpChonSanPhamThemVaoPhieuNhap(listPn.get(row).getId());
        chonSp.setVisible(true);
    }//GEN-LAST:event_btnThemSpVaoPhieuActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        searchRadio();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
         searchRadio();
    }//GEN-LAST:event_txtSearchMouseClicked

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int row = tblPhieuNhap.getSelectedRow();
        if(row == -1){
            return;
        }
        TpPhieuNhapCustom pn = phieuNhapService.findPhieuNhapById((UUID) tblPhieuNhap.getValueAt(row, 1));
        txtGhiChu.setText(pn.getGhiChu());
        txtMaPhieu.setText(pn.getId().toString());
        txtNgayTao.setText(new Date(pn.getNgayTao()).toString());
        txtNhaCungCap.setText(pn.getTenNcc());
        txtNhanVien.setText(pn.getTenNhanVien());
        txtTrangThai.setText(Converter.trangThaiDonHang(listPn.get(row).getTrangThai()));
    }//GEN-LAST:event_tblPhieuNhapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnKhoangTime;
    private utilities.palette.MyButton btnPhieuNhapChiTiet;
    private utilities.palette.MyButton btnThemPhieuNhapMoi;
    private utilities.palette.MyButton btnThemSpVaoPhieu;
    private javax.swing.ButtonGroup buttonGroup1;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoNcc;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tblPhieuNhap;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.TextField txtNhaCungCap;
    private utilities.palette.TextField txtNhanVien;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearch;
    private utilities.palette.TextField txtTienPhaiTra;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
