/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import cores.truongPhongs.services.TpXemChiTietSanPhamService;
import cores.truongPhongs.services.serviceImpls.TpXemChiTietSanPhamImpl;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MsgBox;

/**
 *
 * @author Acer
 */
public class TpLuongNhapChiTietSanPhamForm extends javax.swing.JFrame {

    private TpXemChiTietSanPhamService ctspService;
    private List<TpXemChiTietSanPhamCustom> listSp = new ArrayList<>();
    private TpPhieuNhapCustom phieuNhap;
    private TpLuongNhapAddChiTietSanPhamForm createView;

    public void setPhieuNhap(TpPhieuNhapCustom phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public TpLuongNhapChiTietSanPhamForm() {
        createView = new TpLuongNhapAddChiTietSanPhamForm();
        initComponents();
        ctspService = new TpXemChiTietSanPhamImpl();
        listSp = ctspService.listCtsp();
        loadTableNcc(listSp);
    }

    public TpLuongNhapChiTietSanPhamForm(UUID id) {
        initComponents();
        ctspService = new TpXemChiTietSanPhamImpl();
        listSp = ctspService.listCtsp();
        loadTableNcc(listSp);
    }

    private void loadTableNcc(List<TpXemChiTietSanPhamCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblCtsp.getModel();
        dtm.setRowCount(0);
        for (TpXemChiTietSanPhamCustom sp : listSp) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                sp.getSanPham().getMa(),
                sp.getSanPham().getTen(),
                sp.getSoLuongTon(),
                sp.getGiaNhap(),
                sp.getDonVi().getDonViGoc(),
                sp.getMau(),
                sp.getNamBaoHanh(),
                Converter.trangThaiSanPham(sp.getTrangThai())
            };
            dtm.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCtsp = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        rdoNcc = new utilities.palette.RadioButtonCustom();
        textFieldAnimation1 = new utilities.palette.SearchCustom.TextFieldAnimation();
        combobox1 = new utilities.palette.Combobox();
        combobox2 = new utilities.palette.Combobox();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        myButton8 = new utilities.palette.MyButton();
        txtMa = new utilities.palette.TextField();
        txtMau = new utilities.palette.TextField();
        txtTenSp = new utilities.palette.TextField();
        txtGiaNhap = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        txtSoLuongTon = new utilities.palette.TextField();
        txtNamBH = new utilities.palette.TextField();
        txtDonVi = new utilities.palette.TextField();
        panelRound6 = new utilities.palette.PanelRound();
        jButton2 = new javax.swing.JButton();
        btnHienThi1 = new utilities.palette.MyButton();
        myButton1 = new utilities.palette.MyButton();
        btnSearch = new utilities.palette.MyButton();
        txtGiaFrom = new utilities.palette.TextField();
        txtGiaTo = new utilities.palette.TextField();
        jLabel3 = new javax.swing.JLabel();
        myButton2 = new utilities.palette.MyButton();
        btnOK = new utilities.palette.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tblCtsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Giá nhập", "Đơn vị", "Màu", "Năm bảo hành", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCtsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCtspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCtsp);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        rdoNhanVien.setBackground(new java.awt.Color(67, 130, 187));
        rdoNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setText("Mã sản phẩm");
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoNcc.setBackground(new java.awt.Color(67, 130, 187));
        rdoNcc.setForeground(new java.awt.Color(255, 255, 255));
        rdoNcc.setText("Tên sản phẩm");
        rdoNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        combobox1.setBackground(new java.awt.Color(67, 130, 187));
        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chờ xác nhận", "Đã mở bán" }));
        combobox1.setSelectedIndex(-1);
        combobox1.setToolTipText("Chọn trạng thái sản phẩm muốn tìm kiếm");
        combobox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combobox1.setLabeText("Trạng thái");
        combobox1.setLineColor(new java.awt.Color(145, 200, 249));
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });

        combobox2.setBackground(new java.awt.Color(67, 130, 187));
        combobox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Red", "Pig", "Black", "Yellow", "Gray" }));
        combobox2.setSelectedIndex(-1);
        combobox2.setToolTipText("Chọn màu sắc sản phẩm muốn tìm kiếm");
        combobox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combobox2.setLabeText("Màu sắc");
        combobox2.setLineColor(new java.awt.Color(145, 200, 249));
        combobox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                    .addContainerGap(475, Short.MAX_VALUE)
                    .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(261, 261, 261)))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(textFieldAnimation1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(rdoNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoNcc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANH SÁCH SẢN PHẨM");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        myButton8.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton8.setColor(new java.awt.Color(221, 242, 244));
        myButton8.setRadius(50);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtMa.setEditable(false);
        txtMa.setBackground(new java.awt.Color(221, 242, 244));
        txtMa.setToolTipText("");
        txtMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMa.setLabelText("Mã sản phẩm");

        txtMau.setEditable(false);
        txtMau.setBackground(new java.awt.Color(221, 242, 244));
        txtMau.setToolTipText("");
        txtMau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMau.setLabelText("Màu");

        txtTenSp.setEditable(false);
        txtTenSp.setBackground(new java.awt.Color(221, 242, 244));
        txtTenSp.setToolTipText("");
        txtTenSp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTenSp.setLabelText("Tên sản phẩm");

        txtGiaNhap.setEditable(false);
        txtGiaNhap.setBackground(new java.awt.Color(221, 242, 244));
        txtGiaNhap.setToolTipText("");
        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaNhap.setLabelText("Giá nhập");

        txtTrangThai.setEditable(false);
        txtTrangThai.setBackground(new java.awt.Color(221, 242, 244));
        txtTrangThai.setToolTipText("");
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");

        txtSoLuongTon.setEditable(false);
        txtSoLuongTon.setBackground(new java.awt.Color(221, 242, 244));
        txtSoLuongTon.setToolTipText("");
        txtSoLuongTon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSoLuongTon.setLabelText("Số lượng tồn");

        txtNamBH.setEditable(false);
        txtNamBH.setBackground(new java.awt.Color(221, 242, 244));
        txtNamBH.setToolTipText("");
        txtNamBH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNamBH.setLabelText("Năm bảo hành");

        txtDonVi.setEditable(false);
        txtDonVi.setBackground(new java.awt.Color(221, 242, 244));
        txtDonVi.setToolTipText("");
        txtDonVi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDonVi.setLabelText("Đơn vị");

        panelRound6.setBackground(new java.awt.Color(0, 255, 255));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnHienThi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnHienThi1.setText("\n");
        btnHienThi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThi1ActionPerformed(evt);
            }
        });

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_2.png"))); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtGiaFrom.setLabelText("Từ");

        txtGiaTo.setLabelText("Đến");

        jLabel3.setText("Tìm kiếm theo giá:");

        myButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        myButton2.setToolTipText("Thêm sản phẩm mới");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGiaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHienThi1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnOK.setBorder(null);
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Accept.png"))); // NOI18N
        btnOK.setBorderColor(new java.awt.Color(221, 242, 244));
        btnOK.setColor(new java.awt.Color(221, 242, 244));
        btnOK.setRadius(50);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(panelRound6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox1ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton8ActionPerformed

    private void combobox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox2ActionPerformed

    public TpXemChiTietSanPhamCustom mouseClickSanPham(int row) {
        return listSp.get(row);
    }
    public void fillData(int i){
        TpXemChiTietSanPhamCustom ct = listSp.get(i);
        txtMa.setText(ct.getSanPham().getMa());
        txtTenSp.setText(ct.getSanPham().getTen());
        txtDonVi.setText(ct.getDonVi().getDonViGoc());
        txtNamBH.setText(String.valueOf(ct.getNamBaoHanh()));
        txtMau.setText(String.valueOf(ct.getMau()));
        txtTrangThai.setText(Converter.trangThaiSanPham(ct.getTrangThai()));
    }
    
    
    private void tblCtspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCtspMouseClicked
        // TODO add your handling code here:
        int row = this.tblCtsp.getSelectedRow();
        if (row == -1) {
            return;
        }
        TpXemChiTietSanPhamCustom tpXemChiTietSanPhamCustom = mouseClickSanPham(row);

        txtMa.setText(tblCtsp.getValueAt(row, 1).toString());
        txtTenSp.setText(tblCtsp.getValueAt(row, 2).toString());
        txtSoLuongTon.setText(tblCtsp.getValueAt(row, 3).toString());
        txtGiaNhap.setText(tblCtsp.getValueAt(row, 4).toString());
        txtDonVi.setText(tblCtsp.getValueAt(row, 5).toString());
        txtMau.setText(tblCtsp.getValueAt(row, 6).toString());
        txtNamBH.setText(tblCtsp.getValueAt(row, 7).toString());
        txtTrangThai.setText(tblCtsp.getValueAt(row, 8).toString());

        if (phieuNhap.getTrangThai().equals(TrangThaiPhieuConstant.DA_THANH_TOAN)) {
            MsgBox.alert(this, "Phiếu nhập này đã ở trạng thái đã thanh toán nên không thể sửa! ");
            return;
        }
//        String suaSL = JOptionPane.showInputDialog("Bạn muốn nhập số lượng bao nhiêu ?");
//        int sl = 0;
//        try {
//            sl = Integer.parseInt(suaSL);
//            if (sl <= 0) {
//                JOptionPane.showMessageDialog(this, "Bạn phải nhập lớn hơn 0");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Bạn phải nhập là kiểu số");
//            return;
//        }
//        String suaĐG = JOptionPane.showInputDialog("Bạn muốn đơn giá bao nhiêu ?");
//
//        JOptionPane.showMessageDialog(this, suaĐG + suaSL);

//        TpXemChiTietSanPhamCustom ctsp = listSp.get(row);
//          TpLuongNhapAddChiTietSanPhamForm add = new TpLuongNhapAddChiTietSanPhamForm();
//          add.setVisible(true);
        fillData(row);
        createView.ct = listSp.get(row);
        createView.setPhieuNhap(phieuNhap);
        createView.setVisible(true);
        createView.showData();
          

    }//GEN-LAST:event_tblCtspMouseClicked

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        int row = this.tblCtsp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn một sản phẩm !");
            return;
        }

        String chuso = JOptionPane.showInputDialog("Bạn muốn nhập vào bao nhiêu sản phẩm này?");
        int soluong = 0;
        try {
            soluong = Integer.parseInt(chuso);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bạn phải nhập số lượng là chữ số!");
            return;
        }
        if (soluong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
            return;
        }
//        if()


    }//GEN-LAST:event_btnOKActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHienThi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThi1ActionPerformed
        listSp = ctspService.listCtsp();
        loadTableNcc(listSp);
    }//GEN-LAST:event_btnHienThi1ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
//        txtGiaFrom.setText("");
//        txtGiaTo.setText("");
//        listCTSP = luongService.getListCTSanPham();
//        loadTable(listCTSP);
    }//GEN-LAST:event_myButton1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
//        if (txtGiaFrom.getText().trim().length() == 0 || txtGiaTo.getText().trim().length() == 0) {
//            MsgBox.alert(this, "Bạn phải nhập khoảng giá tìm kiếm");
//            return;
//        }
//        listCTSP = luongService.getListCTSanPhamBanHang(new BigDecimal(txtGiaFrom.getText()), new BigDecimal(txtGiaTo.getText()));
//        loadTable(listCTSP);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TpLuongNhapChiTietSanPhamForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnHienThi1;
    private utilities.palette.MyButton btnOK;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.Combobox combobox1;
    private utilities.palette.Combobox combobox2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton1;
    private utilities.palette.MyButton myButton2;
    private utilities.palette.MyButton myButton8;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound6;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.RadioButtonCustom rdoNcc;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tblCtsp;
    private utilities.palette.SearchCustom.TextFieldAnimation textFieldAnimation1;
    private utilities.palette.TextField txtDonVi;
    private utilities.palette.TextField txtGiaFrom;
    private utilities.palette.TextField txtGiaNhap;
    private utilities.palette.TextField txtGiaTo;
    private utilities.palette.TextField txtMa;
    private utilities.palette.TextField txtMau;
    private utilities.palette.TextField txtNamBH;
    private utilities.palette.TextField txtSoLuongTon;
    private utilities.palette.TextField txtTenSp;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
