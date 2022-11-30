package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TpPhieuNhapChiTietCustom;
import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import cores.truongPhongs.services.TpPhieuNhapChiTietService;
import cores.truongPhongs.services.serviceImpls.TpPhieuNhapServiceImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import cores.truongPhongs.services.TpPhieuNhapService;
import cores.truongPhongs.services.serviceImpls.TpPhieuNhapChiTietServiceImpl;
import domainModels.NhanVien;
import domainModels.PhieuNhap;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;
import utilities.Auth;
import utilities.Converter;
import utilities.MsgBox;
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
    private List<TpPhieuNhapCustom> listPn;
    private NhanVien nhanVien;
    private TpLuongNhapChiTietSanPhamForm ctspView;
    private TpLuongNhapChiTietPhieuNhapForm ctpnView;
    private TpPhieuNhapChiTietService tpncts;

    public TpLuongNhapView() {
        initComponents();
        listPn = new ArrayList<>();
        phieuNhapService = new TpPhieuNhapServiceImpl();
        tpncts = new TpPhieuNhapChiTietServiceImpl();
        listPn = phieuNhapService.getListPn();
        loadTablePn(listPn);
        ctspView = new TpLuongNhapChiTietSanPhamForm();
        ctpnView = new TpLuongNhapChiTietPhieuNhapForm();
        clearForm();
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

    public TpLuongNhapView(UUID id) {
        initComponents();
        nhanVien = new NhanVien();
        nhanVien.setId(Auth.nhanVien.getId());
        nhanVien.setMa(Auth.nhanVien.getMa());
        nhanVien.setEmail(Auth.nhanVien.getEmail());
        nhanVien.setDiaChi(Auth.nhanVien.getDiaChi());
        nhanVien.setGioiTinh(Auth.nhanVien.getGioiTinh());
        nhanVien.setHinhAnh(Auth.nhanVien.getHinhAnh());
        nhanVien.setIdChucVu(Auth.nhanVien.getChucVu());
        nhanVien.setMatKhau(Auth.nhanVien.getMatKhau());
        nhanVien.setNgaySinh(Auth.nhanVien.getNgaySinh());
        nhanVien.setSdt(Auth.nhanVien.getSdt());
        nhanVien.setTen(Auth.nhanVien.getTen());
        nhanVien.setTrangThai(Auth.nhanVien.getTrangThai());
        phieuNhapService = new TpPhieuNhapServiceImpl();
        ctspView = new TpLuongNhapChiTietSanPhamForm();
        TpPhieuNhapCustom phieuNhap = new TpPhieuNhapCustom();
        phieuNhap.setIdNcc(id);
        phieuNhap.setIdNhanVien(nhanVien.getId());
        phieuNhap.setNgayTao(new Date().getTime());
        phieuNhapService.addPn(phieuNhap);
        listPn = new ArrayList<>();
        listPn = phieuNhapService.getListPn();
        loadTablePn(listPn);
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

    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTablePn(listSearch(0));
        } else if (rdoNcc.isSelected()) {
            loadTablePn(listSearch(1));
        } else {
            loadTablePn(listSearch(2));
        }
    }

    private void loadTablePn(List<TpPhieuNhapCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuNhap.getModel();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        dtm.setRowCount(0);
        for (TpPhieuNhapCustom pn : listPn) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                pn.getId(),
                simpleDateFormat.format(new Date(pn.getNgayTao())),
                pn.getNgayThanhToan() == null ? "Chưa có" : simpleDateFormat.format(new Date(pn.getNgayThanhToan())),
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
        btnShow = new utilities.palette.MyButton();
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
        txtTienPhaiTra = new utilities.palette.TextField();
        btnThanhToan = new utilities.palette.MyButton();
        txtNhaCungCap = new utilities.palette.TextField();
        txtNhanVien = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        txtTienKhachDua = new utilities.palette.TextField();
        txtTienThua = new utilities.palette.TextField();

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

        rdoNcc.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoNcc);
        rdoNcc.setForeground(new java.awt.Color(255, 255, 255));
        rdoNcc.setText("Nhà cung cấp");
        rdoNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoNhanVien.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setText("Nhân viên");
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
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
                .addContainerGap(13, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound8.setBackground(new java.awt.Color(67, 130, 187));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        cbbTrangThai.setBackground(new java.awt.Color(67, 130, 187));
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chờ thanh toán", "Đã hủy", "Đã thanh toán" }));
        cbbTrangThai.setSelectedIndex(-1);
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
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnKhoangTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnKhoangTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
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

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnThemPhieuNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPhieuNhapChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemSpVaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemPhieuNhapMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnPhieuNhapChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSpVaoPhieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound9.setBackground(new java.awt.Color(67, 130, 187));
        panelRound9.setRoundBottomLeft(50);
        panelRound9.setRoundBottomRight(50);
        panelRound9.setRoundTopLeft(50);
        panelRound9.setRoundTopRight(50);

        rdoNgayTao.setBackground(new java.awt.Color(255, 153, 0));
        rdoNgayTao.setText("Ngày Tạo");

        rdoNgayThanhToan.setBackground(new java.awt.Color(255, 102, 0));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        txtMaPhieu.setEditable(false);
        txtMaPhieu.setBackground(new java.awt.Color(228, 206, 224));
        txtMaPhieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaPhieu.setLabelText("Mã phiếu ");

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

        txtNhaCungCap.setEditable(false);
        txtNhaCungCap.setBackground(new java.awt.Color(228, 206, 224));
        txtNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhaCungCap.setLabelText("Nhà cung cấp");

        txtNhanVien.setEditable(false);
        txtNhanVien.setBackground(new java.awt.Color(228, 206, 224));
        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhanVien.setLabelText("Nhân viên");

        txtTrangThai.setEditable(false);
        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");

        txtTienKhachDua.setBackground(new java.awt.Color(228, 206, 224));
        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienKhachDua.setLabelText("Thanh toán");
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        txtTienThua.setEditable(false);
        txtTienThua.setBackground(new java.awt.Color(228, 206, 224));
        txtTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienThua.setLabelText("Còn thừa");
        txtTienThua.setName(""); // NOI18N
        txtTienThua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienThuaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienPhaiTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
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
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(txtTienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84)
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTrangThaiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        // TODO add your handling code here:
        listSearch(this.cbbTrangThai.getSelectedIndex());
        searchRadio();
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnThemPhieuNhapMoiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnThemPhieuNhapMoiActionPerformed
        TpLuongNhapThemNccVaoPhieuNhapForm themNcc = new TpLuongNhapThemNccVaoPhieuNhapForm();
        themNcc.setVisible(true);

    }//GEN-LAST:event_btnThemPhieuNhapMoiActionPerformed

    private void btnKhoangTimeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnKhoangTimeActionPerformed
        // TODO add your handling code here:
        TpLuongNhapChonKhongTimeView time = new TpLuongNhapChonKhongTimeView();
        time.setVisible(true);
    }//GEN-LAST:event_btnKhoangTimeActionPerformed

    private void btnPhieuNhapChiTietActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapChiTietActionPerformed
        if (chon() == null) {
            return;
        }
        TpLuongNhapChiTietPhieuNhapForm chonStpn = new TpLuongNhapChiTietPhieuNhapForm();
        chonStpn.setPhieuNhap(chon());
        chonStpn.setVisible(true);
    }//GEN-LAST:event_btnPhieuNhapChiTietActionPerformed

    public TpPhieuNhapCustom chon() {
        int row = this.tblPhieuNhap.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 phiếu nhập");
            return null;
        }
        TpPhieuNhapCustom px = new TpPhieuNhapCustom();
        px.setId(listPn.get(row).getId());
        px.setNgayTao(listPn.get(row).getNgayTao());
        px.setNgayThanhToan(listPn.get(row).getNgayThanhToan());
        px.setNgayTao(listPn.get(row).getNgayTao());
        px.setGhiChu(listPn.get(row).getGhiChu());
        px.setIdNcc(listPn.get(row).getIdNcc());
        px.setIdNhanVien(listPn.get(row).getId());
        px.setTrangThai(listPn.get(row).getTrangThai());
        return px;
    }
    private void btnThemSpVaoPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpVaoPhieuActionPerformed
        if (chon() == null) {
            return;
        }
        int row = this.tblPhieuNhap.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một phiếu nhập!");
            return;
        }
        if (tblPhieuNhap.getValueAt(row, 6).toString().equals("Đã thanh toán") || tblPhieuNhap.getValueAt(row, 6).toString().equals("Đã hủy")) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một phiếu nhập chưa thanh toán!");
            return;
        }
        TpLuongNhapChiTietSanPhamForm chonSp = new TpLuongNhapChiTietSanPhamForm();
        chonSp.setPhieuNhap(chon());
        chonSp.setVisible(true);
    }//GEN-LAST:event_btnThemSpVaoPhieuActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
        searchRadio();
    }//GEN-LAST:event_txtSearchMouseClicked

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int row = tblPhieuNhap.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maPhieu = this.tblPhieuNhap.getValueAt(row, 1).toString();
        String ngayTao = this.tblPhieuNhap.getValueAt(row, 2).toString();
        String ngayThanhToan = this.tblPhieuNhap.getValueAt(row, 3).toString();
        String nhaCungCap = this.tblPhieuNhap.getValueAt(row, 4).toString();
        String nhanVien = this.tblPhieuNhap.getValueAt(row, 5).toString();
        String trangThai = this.tblPhieuNhap.getValueAt(row, 6).toString();

        txtMaPhieu.setText(maPhieu);
        txtNgayTao.setText(ngayTao);
        txtTrangThai.setText(trangThai);
        txtNhanVien.setText(nhanVien);
        txtNhaCungCap.setText(nhaCungCap);
        txtGhiChu.setText("new");

        double tien = 0;
        List<TpPhieuNhapChiTietCustom> listCTPX = tpncts.getListCTPhieuNhapByID(listPn.get(row).getId());
        for (TpPhieuNhapChiTietCustom ctpx : listCTPX) {
            tien += ctpx.getIdSanPham().getGiaNhap().multiply(new BigDecimal(ctpx.getSoLuong())).doubleValue();
        }
        txtTienPhaiTra.setText(tien + "");
        if (txtTrangThai.getText().equalsIgnoreCase("Đã Thanh Toán")) {
            btnThanhToan.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(true);
        }

    }//GEN-LAST:event_tblPhieuNhapMouseClicked

        private void clearForm() {
        txtGhiChu.setText("");
        txtMaPhieu.setText("");
        txtNgayTao.setText("");
        txtNhaCungCap.setText("");
        txtTienKhachDua.setText("");
        txtTienPhaiTra.setText("");
        txtTienThua.setText("");
        txtTrangThai.setText("");
        rdoMa.setSelected(false);
        rdoNhanVien.setSelected(false);
        cbbTrangThai.setSelectedItem(Converter.TrangThaiPhieuXuat(TrangThaiPhieuConstant.DA_THANH_TOAN));
        ngayBatDau.setDate(null);
        ngayKetThuc.setDate(null);
        rdoNgayTao.setSelected(false);
        rdoNgayThanhToan.setSelected(false);
    }
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        listPn = phieuNhapService.getListPn();
        loadTablePn(listPn);
        clearForm();
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        String tienKhachDua = txtTienKhachDua.getText();
        String tienPhaiTra = txtTienPhaiTra.getText();
        double tienKhach = 0;
        try {
            tienKhach = Double.parseDouble(tienKhachDua);
            if (tienKhach <= 0) {
                MsgBox.alert(this, "Phải nhập tiền là kiểu số nguyên dương");
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }

        double tienThua = tienKhach - Double.valueOf(tienPhaiTra);
        txtTienThua.setText(tienThua + "");
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtTienThuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienThuaCaretUpdate

    }//GEN-LAST:event_txtTienThuaCaretUpdate

    
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        clearForm();
        int row = this.tblPhieuNhap.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "Bạn phải chọn 1 phiếu nhập");
            return;
        }
        if (listPn.get(row).getTrangThai() == TrangThaiPhieuConstant.DA_THANH_TOAN) {
            MsgBox.alert(this, "Phiếu nhập này đã thanh toán. Vui lòng thanh toán phiếu nhập khác");
            return;
        }
        String tienKhachDua = txtTienKhachDua.getText();
        String tienPhaiTra = txtTienPhaiTra.getText();
        double tienKhach = 0;
//        try {
//            tienKhach = Double.parseDouble(tienKhachDua);
//            if (tienKhach <= 0) {
//                MsgBox.alert(this, "Phải nhập tiền là kiểu số nguyên dương");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            MsgBox.alert(this, "Phải nhập tiền là kiểu số");
//            return;
//        }
//        if (tienKhach < Double.valueOf(tienPhaiTra)) {
//            MsgBox.alert(this, "Phải nhập tiền lớn hơn tiền phải trả");
//            return;
//        }

        TpPhieuNhapCustom pxcs = listPn.get(row);
        pxcs.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuNhapService.updatePn(pxcs);
        MsgBox.alert(this, "Bạn đã thanh toán thành công");
        listPn.set(row, pxcs);
        loadTablePn(listPn);
        clearForm();
    }//GEN-LAST:event_btnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnKhoangTime;
    private utilities.palette.MyButton btnPhieuNhapChiTiet;
    private utilities.palette.MyButton btnShow;
    private utilities.palette.MyButton btnThanhToan;
    private utilities.palette.MyButton btnThemPhieuNhapMoi;
    private utilities.palette.MyButton btnThemSpVaoPhieu;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoNcc;
    private utilities.palette.RadioButtonCustom rdoNgayTao;
    private utilities.palette.RadioButtonCustom rdoNgayThanhToan;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tblPhieuNhap;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.TextField txtNhaCungCap;
    private utilities.palette.TextField txtNhanVien;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearch;
    private utilities.palette.TextField txtTienKhachDua;
    private utilities.palette.TextField txtTienPhaiTra;
    private utilities.palette.TextField txtTienThua;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
