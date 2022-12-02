package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLyDonViCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.services.TpQuanLyChiTietSanPhamService;
import cores.truongPhongs.services.serviceImpls.TpQuanLyChiTietSanPhamServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.Page;

/**
 *
 * @author MMC
 */
public class TpQuanLyChiTietSanPhamForm extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<TpQuanLyChiTietSanPhamCustom> listChiTietSP = new ArrayList<>();
    private List<TpQuanLyDonViCustom> listDonVi = new ArrayList<>();
    private List<TpQuanLySanPhamCustom> listSanPham = new ArrayList<>();
    private TpQuanLyChiTietSanPhamService serviceChiTietSP = new TpQuanLyChiTietSanPhamServiceImpl();

    private TpQuanLyChiTietSanPhamAdd createView;
    private TpQuanLyChiTietSanPhamU rud;
    private Page p;

    private int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    public TpQuanLyChiTietSanPhamForm() {
        createView = new TpQuanLyChiTietSanPhamAdd();
        rud = new TpQuanLyChiTietSanPhamU();
        p = new Page();
        initComponents();
        tbChiTietSanPham.setModel(dtm);
        String[] hearders = {"STT", "Sản Phẩm", "Màu", "Size", "Năm BH", "Đơn vị", "Giá Bán", "Giá Nhập", "Trạng thái"};
        dtm.setColumnIdentifiers(hearders);
        serviceChiTietSP.loadCombobox(cbMauSac);
        this.clearForm();
        showData(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }

    public void showData(List<TpQuanLyChiTietSanPhamCustom> list) {
        dtm.setRowCount(0);

//            TpQuanLyChiTietSanPhamCustom ct = list.get(i);
        for (TpQuanLyChiTietSanPhamCustom ct : list) {
            dtm.addRow(new Object[]{
                dtm.getRowCount() + 1,
                ct.getSanPham().getTen(),
                Converter.trangThaiMauSac(ct.getMau()),
                ct.getSize(),
                ct.getNamBaoHanh(),
                ct.getDonVi().getDonViGoc(),
                ct.getGiaBan() == null ? "Chưa có" : ct.getGiaBan(),
                ct.getGiaNhap(),
                Converter.trangThaiSanPham(ct.getTrangThai())
            });
        }
    }

    public List<TpQuanLyChiTietSanPhamCustom> listSearch(int rdo) {
        String timKiem = this.txtSearchTheo.getText();
        listChiTietSP = serviceChiTietSP.findAllByRadio(rdo, serviceChiTietSP.loc(cbMauSac.getSelectedIndex()), timKiem);
        return listChiTietSP;
    }

    public void searchRadio() {
        if (rdoGiaNhap.isSelected()) {
            showData(serviceChiTietSP.phanTrang(listSearch(0), offset, limit));
        } else if (rdoGiaBan.isSelected()) {
            showData(serviceChiTietSP.phanTrang(listSearch(1), offset, limit));
        } else {
            showData(serviceChiTietSP.phanTrang(listSearch(2), offset, limit));
        }
    }

    public void clearForm() {
        rdoGiaNhap.setSelected(true);
        listChiTietSP = serviceChiTietSP.getAll();
        sizes = listChiTietSP.size();
        offset = 0;
        index = 1;
        loadIndex();
    }

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    public void fillData(int i) {
//        TpQuanLyChiTietSanPhamCustom ct = listChiTietSP.get(i);
        TpQuanLyChiTietSanPhamCustom ct = serviceChiTietSP.phanTrang(listChiTietSP, offset, limit).get(i);
        txtTenSP.setText(ct.getSanPham().getTen());
        txtMaSP.setText(ct.getSanPham().getMa());
        txtDonVi.setText(ct.getDonVi().getDonViGoc());
        txtNamBH.setText(String.valueOf(ct.getNamBaoHanh()));
        txtSoLuongTon.setText(String.valueOf(ct.getSoLuongTon()));
        txtMau.setText(Converter.trangThaiMauSac(ct.getMau()));
        txtSize.setText(String.valueOf(ct.getSize()));
        txtTrangThai.setText(Converter.trangThaiSanPham(ct.getTrangThai()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtTenSP = new utilities.palette.TextField();
        txtMaSP = new utilities.palette.TextField();
        txtMau = new utilities.palette.TextField();
        myButton7 = new utilities.palette.MyButton();
        txtSoLuongTon = new utilities.palette.TextField();
        txtDonVi = new utilities.palette.TextField();
        txtNamBH = new utilities.palette.TextField();
        txtSize = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound15 = new utilities.palette.PanelRound();
        btnThem = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        btnChon = new utilities.palette.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTietSanPham = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        txtSearchTheo = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoGiaBan = new utilities.palette.RadioButtonCustom();
        rdoGiaNhap = new utilities.palette.RadioButtonCustom();
        rdoTenSP = new utilities.palette.RadioButtonCustom();
        panelRound8 = new utilities.palette.PanelRound();
        cbMauSac = new utilities.palette.Combobox();
        btnSearch = new utilities.palette.MyButton();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        txtIndex = new javax.swing.JLabel();
        uWPButton5 = new utilities.palette.UWPButton();
        uWPButton4 = new utilities.palette.UWPButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin sản phẩm");

        txtTenSP.setEditable(false);
        txtTenSP.setBackground(new java.awt.Color(228, 206, 224));
        txtTenSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenSP.setLabelText("Tên sản phẩm");

        txtMaSP.setBackground(new java.awt.Color(228, 206, 224));
        txtMaSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSP.setLabelText("Mã sản phẩm");

        txtMau.setBackground(new java.awt.Color(228, 206, 224));
        txtMau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMau.setLabelText("Màu");

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        myButton7.setText("Clear");
        myButton7.setToolTipText("Clear");
        myButton7.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton7.setColor(new java.awt.Color(221, 242, 244));
        myButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton7.setRadius(50);
        myButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton7ActionPerformed(evt);
            }
        });

        txtSoLuongTon.setEditable(false);
        txtSoLuongTon.setBackground(new java.awt.Color(228, 206, 224));
        txtSoLuongTon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoLuongTon.setLabelText("Số Lượng Tồn");

        txtDonVi.setEditable(false);
        txtDonVi.setBackground(new java.awt.Color(228, 206, 224));
        txtDonVi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDonVi.setLabelText("Đơn Vị Gốc");

        txtNamBH.setBackground(new java.awt.Color(228, 206, 224));
        txtNamBH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNamBH.setLabelText("Năm Bảo Hành");

        txtSize.setBackground(new java.awt.Color(228, 206, 224));
        txtSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSize.setLabelText("Size");

        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");

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
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDonVi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        btnThem.setBackground(new java.awt.Color(221, 242, 244));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThem.setToolTipText("Thêm mới ctsp");
        btnThem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem.setColor(new java.awt.Color(221, 242, 244));
        btnThem.setRadius(50);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill.png"))); // NOI18N
        btnHienThi.setToolTipText("Hiển thị");
        btnHienThi.setBorderColor(new java.awt.Color(221, 242, 244));
        btnHienThi.setColor(new java.awt.Color(221, 242, 244));
        btnHienThi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHienThi.setRadius(50);
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Buddy.png"))); // NOI18N
        btnChon.setToolTipText("Chọn");
        btnChon.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChon.setColor(new java.awt.Color(221, 242, 244));
        btnChon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChon.setRadius(50);
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbChiTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChiTietSanPham);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        buttonGroup1.add(rdoGiaBan);
        rdoGiaBan.setText("Giá Bán");
        rdoGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        buttonGroup1.add(rdoGiaNhap);
        rdoGiaNhap.setText("Giá Nhập");
        rdoGiaNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        buttonGroup1.add(rdoTenSP);
        rdoTenSP.setText("Tên SP");
        rdoTenSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(rdoTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        panelRound8.setBackground(new java.awt.Color(67, 130, 187));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

        cbMauSac.setBackground(new java.awt.Color(67, 130, 187));
        cbMauSac.setToolTipText("Chọn màu sắc để tìm kiếm");
        cbMauSac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbMauSac.setLabeText("Màu sắc");
        cbMauSac.setLineColor(new java.awt.Color(145, 200, 249));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm kiếm");
        btnSearch.setBorderColor(new java.awt.Color(221, 242, 244));
        btnSearch.setColor(new java.awt.Color(221, 242, 244));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setRadius(50);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addGroup(panelRound8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DANH SÁCH CHI TIẾT SẢN PHẨM");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtIndex.setText("1/1");

        uWPButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-next-circle-solid-24.png"))); // NOI18N
        uWPButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton5ActionPerformed(evt);
            }
        });

        uWPButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-previous-circle-solid-24.png"))); // NOI18N
        uWPButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietSanPhamMouseClicked
        int row = this.tbChiTietSanPham.getSelectedRow();
        createView.setVisible(false);
        fillData(row);
//        rud.ct = listChiTietSP.get(row);
        rud.ct = serviceChiTietSP.phanTrang(listChiTietSP, offset, limit).get(row);
        rud.setVisible(true);
        rud.showData();
    }//GEN-LAST:event_tbChiTietSanPhamMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchRadio();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        createView.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        clearForm();
        showData(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void uWPButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton5ActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
//        showData(listChiTietSP);
        showData(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_uWPButton5ActionPerformed

    private void uWPButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton4ActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
//        showData(listChiTietSP);
        showData(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_uWPButton4ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed

    }//GEN-LAST:event_myButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnChon;
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.MyButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private utilities.palette.Combobox cbMauSac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.RadioButtonCustom rdoGiaBan;
    private utilities.palette.RadioButtonCustom rdoGiaNhap;
    private utilities.palette.RadioButtonCustom rdoTenSP;
    private utilities.palette.TableDark_1 tbChiTietSanPham;
    private utilities.palette.TextField txtDonVi;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtMaSP;
    private utilities.palette.TextField txtMau;
    private utilities.palette.TextField txtNamBH;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearchTheo;
    private utilities.palette.TextField txtSize;
    private utilities.palette.TextField txtSoLuongTon;
    private utilities.palette.TextField txtTenSP;
    private utilities.palette.TextField txtTrangThai;
    private utilities.palette.UWPButton uWPButton4;
    private utilities.palette.UWPButton uWPButton5;
    // End of variables declaration//GEN-END:variables
}
