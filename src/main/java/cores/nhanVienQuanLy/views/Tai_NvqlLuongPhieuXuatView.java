/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import cores.nhanVienQuanLy.services.NVQLQuanLyPhieuXuatService;
import cores.nhanVienQuanLy.services.Tai_NvqlLuongPhieuXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.NVQLQuanLyPhieuXuatServiceImpl;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_NvqlLuongPhieuXuatServiceImpl;
import domainModels.ChiTietPhieuXuat;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.DateTimeUtil;
import utilities.MsgBox;

/**
 *
 * @author Acer
 */
public class Tai_NvqlLuongPhieuXuatView extends javax.swing.JPanel {

    private Tai_NvqlLuongPhieuXuatService luongPxService;
    private NVQLQuanLyPhieuXuatService phieuXuatService;
    private List<LuongBanHang_ChiTietSanPhamCustom> listCTSP;
    private List<PhieuXuatCustom> listPhieuXuat;
    private Tai_LuongPhieuXuat_CTPhieuXuatView ctpxView;
    private Tai_LuongPhieuXuat_CTSanPhamView ctspView;
    private Tai_ChonKhachHangView chonKhView;

    public Tai_NvqlLuongPhieuXuatView() {
        initComponents();
        luongPxService = new Tai_NvqlLuongPhieuXuatServiceImpl();
        phieuXuatService = new NVQLQuanLyPhieuXuatServiceImpl();
        listPhieuXuat = phieuXuatService.getList();
        ctpxView = new Tai_LuongPhieuXuat_CTPhieuXuatView();
        ctspView = new Tai_LuongPhieuXuat_CTSanPhamView();
        chonKhView = new Tai_ChonKhachHangView();
        phieuXuatService.loadComBox(cbbTrangThai);
        loadTablePhieuXuat(listPhieuXuat);
        clearForm();
    }

    private void loadTablePhieuXuat(List<PhieuXuatCustom> listPX) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuXuat.getModel();
        dtm.setRowCount(0);
        for (PhieuXuatCustom el : listPhieuXuat) {
            Date ngayNhan = new Date(el.getNgayTao());
            Date ngayThanhToan = new Date(el.getNgayThanhToan());
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getId(),
                ngayNhan,
                ngayThanhToan,
                Converter.TrangThaiPhieuXuat(el.getTrangThai()),
                el.getNhanVien().getMa(),
                el.getKhachHang().getMa()
            };
            dtm.addRow(rowData);
        }
    }

    private void clearForm() {
        txtGhiChu.setText("");
//        cbbKhachHang.setSelectedIndex(0);
        txtMaPhieu.setText("");
        txtNgayTao.setText("");
        txtNgayThanhToan.setText("");
        txtMaNhanVien.setText("");
        txtTienKhachDua.setText("");
        txtTienPhaitra.setText("");
        txtTienThua.setText("");
        txtTrangThai.setText("");
        rdoMa.setSelected(false);
        rdoKhachHang.setSelected(false);
        rdoNhanVien.setSelected(false);
        cbbTrangThai.setSelectedItem(Converter.TrangThaiPhieuXuat(TrangThaiPhieuConstant.DA_THANH_TOAN));
        txtTimKiem.setText("");
        ngayBatDau.setDate(null);
        ngayKetThuc.setDate(null);
        rdoNgayTao.setSelected(false);
        rdoNgayThanhToan.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuXuat = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        rdoKhachHang = new utilities.palette.RadioButtonCustom();
        rdoMa = new utilities.palette.RadioButtonCustom();
        txtTimKiem = new utilities.palette.TextField();
        buttonGradient1 = new utilities.palette.ButtonGradient();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        cbbTrangThai = new utilities.palette.Combobox();
        btnShow = new utilities.palette.MyButton();
        panelRound15 = new utilities.palette.PanelRound();
        btnCtPhieuXuat = new utilities.palette.MyButton();
        btnCreatPhieuXuat = new utilities.palette.MyButton();
        btnChiTietSP = new utilities.palette.MyButton();
        btnChiTietSP1 = new utilities.palette.MyButton();
        panelRound9 = new utilities.palette.PanelRound();
        rdoNgayTao = new utilities.palette.RadioButtonCustom();
        rdoNgayThanhToan = new utilities.palette.RadioButtonCustom();
        ngayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ngayKetThuc = new com.toedter.calendar.JDateChooser();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtNgayTao = new utilities.palette.TextField();
        txtMaPhieu = new utilities.palette.TextField();
        textAreaScroll1 = new utilities.palette.TextAreaScroll();
        txtGhiChu = new utilities.palette.TextAreaCustom();
        txtTienPhaitra = new utilities.palette.TextField();
        btnThanhToan = new utilities.palette.MyButton();
        txtTrangThai = new utilities.palette.TextField();
        txtNgayThanhToan = new utilities.palette.TextField();
        txtTienKhachDua = new utilities.palette.TextField();
        txtTienThua = new utilities.palette.TextField();
        txtMaKhachHang = new utilities.palette.TextField();
        txtMaNhanVien = new utilities.palette.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu", "Ngày tạo", "Ngày thanh toán", "Trạng thái", "Nhân viên", "Khách Hàng"
            }
        ));
        tblPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuXuatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuXuat);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

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

        rdoKhachHang.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoKhachHang);
        rdoKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        rdoKhachHang.setText("Khách Hàng");
        rdoKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhachHangActionPerformed(evt);
            }
        });

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

        txtTimKiem.setLabelText("Search");

        buttonGradient1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        buttonGradient1.setColor1(new java.awt.Color(51, 255, 255));
        buttonGradient1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/OK.png"))); // NOI18N
        buttonGradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANH SÁCH PHIẾU XUẤT");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound8.setBackground(new java.awt.Color(67, 130, 187));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        cbbTrangThai.setBackground(new java.awt.Color(67, 130, 187));
        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbTrangThai.setLabeText("Trạng thái");
        cbbTrangThai.setLineColor(new java.awt.Color(145, 200, 249));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnShow.setToolTipText("Hiện thị danh sách phiếu xuất");
        btnShow.setBorderColor(new java.awt.Color(221, 242, 244));
        btnShow.setColor(new java.awt.Color(221, 242, 244));
        btnShow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow.setRadius(50);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnShow.getAccessibleContext().setAccessibleDescription("Hiện thị danh sách phiếu xuất");

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        btnCtPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnCtPhieuXuat.setToolTipText("Giỏ hàng của phiếu xuất");
        btnCtPhieuXuat.setBorderColor(new java.awt.Color(221, 242, 244));
        btnCtPhieuXuat.setColor(new java.awt.Color(221, 242, 244));
        btnCtPhieuXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCtPhieuXuat.setRadius(50);
        btnCtPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtPhieuXuatActionPerformed(evt);
            }
        });

        btnCreatPhieuXuat.setBackground(new java.awt.Color(221, 242, 244));
        btnCreatPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnCreatPhieuXuat.setToolTipText("Thêm mới phiếu xuất");
        btnCreatPhieuXuat.setBorderColor(new java.awt.Color(221, 242, 244));
        btnCreatPhieuXuat.setColor(new java.awt.Color(221, 242, 244));
        btnCreatPhieuXuat.setRadius(50);
        btnCreatPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatPhieuXuatActionPerformed(evt);
            }
        });

        btnChiTietSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-to-basket.png"))); // NOI18N
        btnChiTietSP.setToolTipText("Thêm sản phẩm muốn bán");
        btnChiTietSP.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChiTietSP.setColor(new java.awt.Color(221, 242, 244));
        btnChiTietSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChiTietSP.setRadius(50);
        btnChiTietSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSPActionPerformed(evt);
            }
        });

        btnChiTietSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill.png"))); // NOI18N
        btnChiTietSP1.setToolTipText("In bill phiếu xuất");
        btnChiTietSP1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChiTietSP1.setColor(new java.awt.Color(221, 242, 244));
        btnChiTietSP1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChiTietSP1.setRadius(50);
        btnChiTietSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreatPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCtPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTietSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChiTietSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTietSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreatPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCtPhieuXuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnChiTietSP1.getAccessibleContext().setAccessibleDescription("Xuất phiếu xuất");

        panelRound9.setBackground(new java.awt.Color(67, 130, 187));
        panelRound9.setRoundBottomLeft(50);
        panelRound9.setRoundBottomRight(50);
        panelRound9.setRoundTopLeft(50);
        panelRound9.setRoundTopRight(50);

        rdoNgayTao.setBackground(new java.awt.Color(255, 153, 0));
        buttonGroup2.add(rdoNgayTao);
        rdoNgayTao.setText("Ngày Tạo");

        rdoNgayThanhToan.setBackground(new java.awt.Color(255, 102, 0));
        buttonGroup2.add(rdoNgayThanhToan);
        rdoNgayThanhToan.setText("Ngày Thanh Toán");

        jLabel3.setText("From:");

        jLabel4.setText("To:");

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(rdoNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(rdoNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rdoNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin phiếu xuất");

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

        txtTienPhaitra.setBackground(new java.awt.Color(228, 206, 224));
        txtTienPhaitra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienPhaitra.setLabelText("Tiền phải trả");

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/credit-card.png"))); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.setToolTipText("THANH TOÁN");
        btnThanhToan.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThanhToan.setColor(new java.awt.Color(221, 242, 244));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setRadius(50);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");
        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
            }
        });

        txtNgayThanhToan.setEditable(false);
        txtNgayThanhToan.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayThanhToan.setLabelText("Ngày thanh toán");

        txtTienKhachDua.setBackground(new java.awt.Color(228, 206, 224));
        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienKhachDua.setLabelText("Tiền khách đưa");
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        txtTienThua.setBackground(new java.awt.Color(228, 206, 224));
        txtTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienThua.setLabelText("Tiền thừa");
        txtTienThua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienThuaCaretUpdate(evt);
            }
        });

        txtMaKhachHang.setEditable(false);
        txtMaKhachHang.setBackground(new java.awt.Color(228, 206, 224));
        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaKhachHang.setLabelText("Mã Khách Hàng");

        txtMaNhanVien.setEditable(false);
        txtMaNhanVien.setBackground(new java.awt.Color(228, 206, 224));
        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaNhanVien.setLabelText("Mã Nhân Viên");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1))
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtTienPhaitra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienPhaitra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoMaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rdoMaActionPerformed
        //searchRadio();
    }//GEN-LAST:event_rdoMaActionPerformed

    private void rdoKhachHangActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rdoKhachHangActionPerformed
        //searchRadio();
    }//GEN-LAST:event_rdoKhachHangActionPerformed

    private void rdoNhanVienActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
//        searchRadio();
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void cbbTrangThaiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
//        searchRadio();
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnCreatPhieuXuatActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCreatPhieuXuatActionPerformed
        chonKhView.setVisible(true);
//        PhieuXuatCustom pxcs = new PhieuXuatCustom();
//        pxcs.setId(phieuXuatService.addPhieuXuat(pxcs).getId());
//        pxcs.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
//        pxcs.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
//        pxcs.setGhiChu("new");
//        pxcs.setTrangThai(TrangThaiPhieuConstant.CHO_THANH_TOAN);
//        pxcs.setKhachHang(luongPxService.getKhachHangByMa("KH000004"));
//        pxcs.setNhanVien(luongPxService.getNhanVienByMa("NV00002"));
//        phieuXuatService.addPhieuXuat(pxcs);
//        listPhieuXuat.add(pxcs);
//        loadTablePhieuXuat(listPhieuXuat);
    }//GEN-LAST:event_btnCreatPhieuXuatActionPerformed

    private void txtMaPhieuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void btnShowActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        listPhieuXuat = phieuXuatService.getList();
        loadTablePhieuXuat(listPhieuXuat);
        clearForm();
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnCtPhieuXuatActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCtPhieuXuatActionPerformed
        if (chon() == null) {
            return;
        }
        ctpxView.clearForm();
        ctpxView.setPhieuXuat(chon());
        ctpxView.setVisible(true);
    }//GEN-LAST:event_btnCtPhieuXuatActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void btnChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSPActionPerformed
        if (chon() == null) {
            return;
        }
        ctspView.setPhieuXuat(chon());
        ctspView.setVisible(true);
    }//GEN-LAST:event_btnChiTietSPActionPerformed

    private void tblPhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuXuatMouseClicked
        int row = this.tblPhieuXuat.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maPhieu = this.tblPhieuXuat.getValueAt(row, 1).toString();
        String ngayTao = this.tblPhieuXuat.getValueAt(row, 2).toString();
        String ngayThanhToan = this.tblPhieuXuat.getValueAt(row, 3).toString();
        String trangThai = this.tblPhieuXuat.getValueAt(row, 4).toString();
        String nhanVien = this.tblPhieuXuat.getValueAt(row, 5).toString();
        String khachHang = this.tblPhieuXuat.getValueAt(row, 6).toString();

        txtMaPhieu.setText(maPhieu);
        txtNgayTao.setText(ngayTao);
        txtNgayThanhToan.setText(ngayThanhToan);
        txtTrangThai.setText(trangThai);
        txtMaKhachHang.setText(khachHang);
        txtMaNhanVien.setText(nhanVien);
        txtGhiChu.setText(listPhieuXuat.get(row).getGhiChu());
        double tien = 0;
        List<Luong_ChiTietPhieuXuatCustom> listCTPX = luongPxService.getListCTPhieuXuatByID(listPhieuXuat.get(row).getId());
        for (Luong_ChiTietPhieuXuatCustom ctpx : listCTPX) {
            tien += ctpx.getIdChiTietSp().getGiaBan().multiply(new BigDecimal(ctpx.getSoLuong())).doubleValue();
        }
        txtTienPhaitra.setText(tien + "");
        if (txtTrangThai.getText().equalsIgnoreCase("Đã Thanh Toán")) {
            btnThanhToan.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(true);
        }
        
    }//GEN-LAST:event_tblPhieuXuatMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = this.tblPhieuXuat.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "Bạn phải chọn 1 phiếu xuất");
            return;
        }
        if (listPhieuXuat.get(row).getTrangThai() == TrangThaiPhieuConstant.DA_THANH_TOAN) {
            MsgBox.alert(this, "Phiếu xuất này đã thanh toán. Vui lòng mời bạn thanh toán phiếu xuất khác");
            return;
        }
        String tienKhachDua = txtTienKhachDua.getText();
        String tienPhaiTra = txtTienPhaitra.getText();
        double tienKhach = 0;
        try {
            tienKhach = Double.parseDouble(tienKhachDua);
            if (tienKhach <= 0) {
                MsgBox.alert(this, "Phải nhập tiền là kiểu số nguyên dương");
                return;
            }
        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Phải nhập tiền là kiểu số");
            return;
        }
        if (tienKhach < Double.valueOf(tienPhaiTra)) {
            MsgBox.alert(this, "Phải nhập tiền lớn hơn tiền phải trả");
            return;
        }

        PhieuXuatCustom pxcs = listPhieuXuat.get(row);
        pxcs.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuXuatService.updatePhieuXuat(pxcs);
        MsgBox.alert(this, "Bạn đã thanh toán thành công");
        listPhieuXuat.set(row, pxcs);
        loadTablePhieuXuat(listPhieuXuat);
        clearForm();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienThuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienThuaCaretUpdate

    }//GEN-LAST:event_txtTienThuaCaretUpdate

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        String tienKhachDua = txtTienKhachDua.getText();
        String tienPhaiTra = txtTienPhaitra.getText();
        double tienKhach = 0;
        try {
            tienKhach = Double.parseDouble(tienKhachDua);
            if (tienKhach <= 0) {
                MsgBox.alert(this, "Phải nhập tiền là kiểu số nguyên dương");
                return;
            }
        } catch (NumberFormatException e) {
//            MsgBox.alert(this, "Phải nhập tiền là kiểu số");
            return;
        }

        double tienThua = tienKhach - Double.valueOf(tienPhaiTra);
        txtTienThua.setText(tienThua + "");
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnChiTietSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSP1ActionPerformed

    }//GEN-LAST:event_btnChiTietSP1ActionPerformed

    private void buttonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient1ActionPerformed
        searchRadio();

        if (rdoMa.isSelected()) {
            listPhieuXuat = phieuXuatService.findByMa(UUID.fromString(txtTimKiem.getText()));
        }
        loadTablePhieuXuat(listPhieuXuat);
        if (rdoNgayTao.isSelected() || rdoNgayThanhToan.isSelected()) {
            TimKiemTheoNgay();
        }
//        listPhieuXuat = phieuXuatService.findByTrangThai();
    }//GEN-LAST:event_buttonGradient1ActionPerformed
    public void TimKiemTheoNgay() {
        if (ngayBatDau.getDate() == null) {
            MsgBox.alert(this, "Bạn phải chọn ngày bắt đầu");
            return;
        }
        if (ngayKetThuc.getDate() == null) {
            MsgBox.alert(this, "Bạn phải chọn ngày Kết thúc");
            return;
        }
        if (!rdoNgayTao.isSelected() && !rdoNgayThanhToan.isSelected()) {
            MsgBox.alert(this, "Bạn phải lựa chọn ngày");
            return;
        }

        if (rdoNgayTao.isSelected()) {
            listPhieuXuat = phieuXuatService.getListByNgayTao(ngayBatDau.getDate().getTime(), ngayKetThuc.getDate().getTime());
            loadTablePhieuXuat(listPhieuXuat);
        } else {
            listPhieuXuat = phieuXuatService.getListByNgayThanhToan(ngayBatDau.getDate().getTime(), ngayKetThuc.getDate().getTime());
            loadTablePhieuXuat(listPhieuXuat);
        }
    }

    public List<PhieuXuatCustom> getListByTT(int rdo) {
        String timKiem = this.txtTimKiem.getText();
        listPhieuXuat = phieuXuatService.findAllByKhAndNV(timKiem, phieuXuatService.loc(cbbTrangThai.getSelectedIndex()), rdo);
        return listPhieuXuat;
    }
//    public List<PhieuXuatCustom> timTheoID(){
//        String tk = txtTimKiem.getText();
//        listPhieuXuat = phieuXuatService.findByMaAndTT(UUID.fromString(tk),phieuXuatService.loc(cbbTrangThai.getSelectedIndex()));
//        return listPhieuXuat;
//        
//    }

    public void searchRadio() {
        if (rdoNhanVien.isSelected()) {
            loadTablePhieuXuat(getListByTT(0));
        } else if (rdoKhachHang.isSelected()) {
            loadTablePhieuXuat(getListByTT(1));
        } else {
            loadTablePhieuXuat(getListByTT(2));
        }
    }

    public PhieuXuat chon() {
        int row = this.tblPhieuXuat.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 phiếu xuất");
            return null;
        }
        PhieuXuat px = new PhieuXuat();
        px.setId(listPhieuXuat.get(row).getId());
        px.setNgayTao(listPhieuXuat.get(row).getNgayTao());
        px.setNgayThanhToan(listPhieuXuat.get(row).getNgayThanhToan());
        px.setNgayTao(listPhieuXuat.get(row).getNgayTao());
        px.setGhiChu(listPhieuXuat.get(row).getGhiChu());
        px.setKhachHang(listPhieuXuat.get(row).getKhachHang());
        px.setNhanVien(listPhieuXuat.get(row).getNhanVien());
        px.setTrangThai(listPhieuXuat.get(row).getTrangThai());
        return px;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnChiTietSP;
    private utilities.palette.MyButton btnChiTietSP1;
    private utilities.palette.MyButton btnCreatPhieuXuat;
    private utilities.palette.MyButton btnCtPhieuXuat;
    private utilities.palette.MyButton btnShow;
    private utilities.palette.MyButton btnThanhToan;
    private utilities.palette.ButtonGradient buttonGradient1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser ngayBatDau;
    private com.toedter.calendar.JDateChooser ngayKetThuc;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.PanelRound panelRound9;
    private utilities.palette.RadioButtonCustom rdoKhachHang;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoNgayTao;
    private utilities.palette.RadioButtonCustom rdoNgayThanhToan;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tblPhieuXuat;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private utilities.palette.TextField txtMaKhachHang;
    private utilities.palette.TextField txtMaNhanVien;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.TextField txtNgayThanhToan;
    private utilities.palette.TextField txtTienKhachDua;
    private utilities.palette.TextField txtTienPhaitra;
    private utilities.palette.TextField txtTienThua;
    private utilities.palette.TextField txtTimKiem;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}