package cores.truongPhongs.views;

import cores.nhanVienQuanLy.views.*;
import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import cores.nhanVienQuanLy.services.Tai_NvqlLuongPhieuXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_NvqlLuongPhieuXuatServiceImpl;
import cores.truongPhongs.customModels.TpPhieuNhapChiTietCustom;
import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import cores.truongPhongs.services.TpPhieuNhapChiTietService;
import cores.truongPhongs.services.serviceImpls.TpPhieuNhapChiTietServiceImpl;
import domainModels.ChiTietPhieuXuat;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MsgBox;

/**
 *
 * @author admin
 */
public class TpLuongNhapChiTietPhieuNhapForm extends javax.swing.JFrame {

    private TpPhieuNhapCustom phieuNhap;
    private TpPhieuNhapChiTietService phieuNhapChiTietService;
    private List<TpPhieuNhapChiTietCustom> listCtpnCustom = new ArrayList<>();

    public void setPhieuNhap(TpPhieuNhapCustom phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public TpLuongNhapChiTietPhieuNhapForm() {
        initComponents();
        phieuNhapChiTietService = new TpPhieuNhapChiTietServiceImpl();
    }
    
    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tbCtpn.getModel();
        dtm.setRowCount(0);
        for (TpPhieuNhapChiTietCustom ctpx : listCtpnCustom) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                ctpx.getIdSanPham().getSanPham().getTen(),
                Converter.trangThaiMauSac(ctpx.getIdSanPham().getMau()),
                ctpx.getIdSanPham().getDonVi().getDonViGoc(),
                ctpx.getIdSanPham().getNamBaoHanh(),
                ctpx.getSoLuong(),
                ctpx.getIdSanPham().getGiaNhap()
            };
            dtm.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCtpn = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        rdoNcc = new utilities.palette.RadioButtonCustom();
        textFieldAnimation1 = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoMa1 = new utilities.palette.RadioButtonCustom();
        combobox1 = new utilities.palette.Combobox();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        myButton8 = new utilities.palette.MyButton();
        panelRound15 = new utilities.palette.PanelRound();
        myButton6 = new utilities.palette.MyButton();
        myButton7 = new utilities.palette.MyButton();
        textField1 = new utilities.palette.TextField();
        textField8 = new utilities.palette.TextField();
        textField9 = new utilities.palette.TextField();
        textField10 = new utilities.palette.TextField();
        textField11 = new utilities.palette.TextField();
        textField12 = new utilities.palette.TextField();
        textField13 = new utilities.palette.TextField();
        panelRound19 = new utilities.palette.PanelRound();
        btnShow18 = new utilities.palette.MyButton();
        btnShow19 = new utilities.palette.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tbCtpn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Màu", "Đơn vị", "Năm bảo hành", "Số lượng", "Giá nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCtpn);

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

        rdoMa1.setBackground(new java.awt.Color(67, 130, 187));
        rdoMa1.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa1.setText("Năm bảo hành");
        rdoMa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        combobox1.setBackground(new java.awt.Color(67, 130, 187));
        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Red", "Pig" }));
        combobox1.setSelectedIndex(-1);
        combobox1.setToolTipText("Chọn màu sắc sản phẩm muốn tìm kiếm");
        combobox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combobox1.setLabeText("Màu sắc");
        combobox1.setLineColor(new java.awt.Color(145, 200, 249));

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoMa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(textFieldAnimation1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(rdoNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoNcc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoMa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANH SÁCH PHIẾU NHẬP CHI TIẾT");

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

        myButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        myButton8.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton8.setColor(new java.awt.Color(221, 242, 244));
        myButton8.setRadius(50);

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        myButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        myButton6.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton6.setColor(new java.awt.Color(221, 242, 244));
        myButton6.setRadius(50);

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_2.png"))); // NOI18N
        myButton7.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton7.setColor(new java.awt.Color(221, 242, 244));
        myButton7.setRadius(50);

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textField1.setBackground(new java.awt.Color(221, 242, 244));
        textField1.setToolTipText("");
        textField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField1.setLabelText("Mã phiếu");

        textField8.setBackground(new java.awt.Color(221, 242, 244));
        textField8.setToolTipText("");
        textField8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField8.setLabelText("Màu");

        textField9.setBackground(new java.awt.Color(221, 242, 244));
        textField9.setToolTipText("");
        textField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField9.setLabelText("Tên sản phẩm");

        textField10.setBackground(new java.awt.Color(221, 242, 244));
        textField10.setToolTipText("");
        textField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField10.setLabelText("Đơn vị");

        textField11.setBackground(new java.awt.Color(221, 242, 244));
        textField11.setToolTipText("");
        textField11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField11.setLabelText("Số lượng");

        textField12.setBackground(new java.awt.Color(221, 242, 244));
        textField12.setToolTipText("");
        textField12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField12.setLabelText("Năm bảo hành");

        textField13.setBackground(new java.awt.Color(221, 242, 244));
        textField13.setToolTipText("");
        textField13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField13.setLabelText("Giá nhập");

        panelRound19.setBackground(new java.awt.Color(102, 255, 255));
        panelRound19.setRoundBottomLeft(50);
        panelRound19.setRoundBottomRight(50);
        panelRound19.setRoundTopLeft(50);
        panelRound19.setRoundTopRight(50);

        btnShow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnShow18.setToolTipText("Hiển thị");
        btnShow18.setBorderColor(new java.awt.Color(221, 242, 244));
        btnShow18.setColor(new java.awt.Color(221, 242, 244));
        btnShow18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow18.setRadius(50);
        btnShow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow18ActionPerformed(evt);
            }
        });

        btnShow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        btnShow19.setToolTipText("Đóng form");
        btnShow19.setBorderColor(new java.awt.Color(221, 242, 244));
        btnShow19.setColor(new java.awt.Color(221, 242, 244));
        btnShow19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow19.setRadius(50);
        btnShow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound19Layout = new javax.swing.GroupLayout(panelRound19);
        panelRound19.setLayout(panelRound19Layout);
        panelRound19Layout.setHorizontalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound19Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnShow18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnShow19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelRound19Layout.setVerticalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound19Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnShow19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShow18, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textField13, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(panelRound19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow18ActionPerformed
        listCtpnCustom = phieuNhapChiTietService.getListCTPhieuNhapByID(this.phieuNhap.getId());
        loadTable();
    }//GEN-LAST:event_btnShow18ActionPerformed

    private void btnShow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow19ActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnShow19ActionPerformed


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
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietPhieuNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietPhieuNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietPhieuNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TpLuongNhapChiTietPhieuNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TpLuongNhapChiTietPhieuNhapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnShow18;
    private utilities.palette.MyButton btnShow19;
    private utilities.palette.Combobox combobox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton6;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.MyButton myButton8;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound19;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.RadioButtonCustom rdoMa1;
    private utilities.palette.RadioButtonCustom rdoNcc;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tbCtpn;
    private utilities.palette.TextField textField1;
    private utilities.palette.TextField textField10;
    private utilities.palette.TextField textField11;
    private utilities.palette.TextField textField12;
    private utilities.palette.TextField textField13;
    private utilities.palette.TextField textField8;
    private utilities.palette.TextField textField9;
    private utilities.palette.SearchCustom.TextFieldAnimation textFieldAnimation1;
    // End of variables declaration//GEN-END:variables
}
