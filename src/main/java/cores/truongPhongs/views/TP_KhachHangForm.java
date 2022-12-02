package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TP_KhachHangCustom;
import cores.truongPhongs.services.TP_KhachHangService;
import cores.truongPhongs.services.serviceImpls.TP_KhachHangServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.Page;

public class TP_KhachHangForm extends javax.swing.JPanel {

    private TP_KhachHangService hangService;
    private List<TP_KhachHangCustom> getList;
    private TP_CreateKhachHangForm createView;
    private TP_RUDKhachHangForm rud;
//
    private Page p;

    private int limit = 2;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    public TP_KhachHangForm() {
        hangService = new TP_KhachHangServiceImpl();
        getList = new ArrayList<>();
        createView = new TP_CreateKhachHangForm();
        rud = new TP_RUDKhachHangForm();
        //
        p = new Page();
        initComponents();
        getList = hangService.getListKH();
        hangService.loadCbbTT(cbbTrangThai);

        loadTable(getList);
        clearForm();

    }

    public void fillData(int i) {
//        TP_KhachHangCustom ql = getList.get(i);
        TP_KhachHangCustom ql = hangService.phanTrang(getList, offset, limit).get(i);
        txtMaKH.setText(ql.getMa());
        txtTenKH.setText(ql.getTen());
        txtSDT.setText(ql.getSdt());
        txtEmail.setText(ql.getEmail());
        txtDanhGia.setText(String.valueOf(ql.getDanhGia()));
        txtDiaChi.setText(ql.getDiaChi());
        txtNgaySinh.setText(new Date(ql.getNgaySinh()).toString());
        txtTrangThai.setText(String.valueOf(ql.getTrangThai()));
    }

    public void clearForm() {
        rdoTen.setSelected(true);
        cbbTrangThai.setSelectedIndex(0);
        getList = hangService.findAllByRadio("", hangService.loc(cbbTrangThai.getSelectedIndex()), 0);
        //
        sizes = getList.size();
        offset = 0;
        index = 1;
        loadIndex();
    }

    public List<TP_KhachHangCustom> listSearch(int rdo) {
        String timKiem = this.txtSearchTheo.getText();
        getList = hangService.findAllByRadio(timKiem, hangService.loc(cbbTrangThai.getSelectedIndex()), rdo);
        return getList;
    }

    public void searchRadio() {
        if (rdoTen.isSelected()) {
//            loadTable(listSearch(0));
            loadTable(hangService.phanTrang(listSearch(0), offset, limit));
        } else if (rdoSDT.isSelected()) {
            loadTable(hangService.phanTrang(listSearch(1), offset, limit));

        } else {
            loadTable(hangService.phanTrang(listSearch(2), offset, limit));

        }
    }

    public void loadTable(List<TP_KhachHangCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tableAll.getModel();
        dtm.setRowCount(0);

        for (TP_KhachHangCustom el : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getMa(),
                el.getTen(),
                el.getSdt(),
                el.getEmail(),
                el.getDiaChi(),
                //                el.getMatKhau(),
                el.getNgaySinh() == null ? "" : new Date(el.getNgaySinh()),
                Converter.trangThaiDanhGia(el.getDanhGia()),
                //                Converter.trangThaiGioiTinh(el.getGioiTinh()),
                Converter.trangThaiKhachHang(el.getTrangThai()), //                el.getHinhAnh()
            };
            dtm.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound15 = new utilities.palette.PanelRound();
        cbbTrangThai = new utilities.palette.Combobox();
        btnSearch1 = new utilities.palette.MyButton();
        panelRound16 = new utilities.palette.PanelRound();
        btnThem1 = new utilities.palette.MyButton();
        btnHienThi1 = new utilities.palette.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAll = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoTen = new utilities.palette.RadioButtonCustom();
        txtSearchTheo = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoSDT = new utilities.palette.RadioButtonCustom();
        rdoDiaChi = new utilities.palette.RadioButtonCustom();
        panelRound17 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        btnPre = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        btnNext = new utilities.palette.UWPButton();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtTenKH = new utilities.palette.TextField();
        txtMaKH = new utilities.palette.TextField();
        txtDanhGia = new utilities.palette.TextField();
        myButton7 = new utilities.palette.MyButton();
        txtSDT = new utilities.palette.TextField();
        txtEmail = new utilities.palette.TextField();
        txtDiaChi = new utilities.palette.TextField();
        txtNgaySinh = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

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

        cbbTrangThai.setLabeText("Trạng thái");

        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnSearch1.setToolTipText("Tìm khách hàng");
        btnSearch1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnSearch1.setColor(new java.awt.Color(221, 242, 244));
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch1.setRadius(50);
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound16.setBackground(new java.awt.Color(67, 130, 187));
        panelRound16.setRoundBottomLeft(50);
        panelRound16.setRoundBottomRight(50);
        panelRound16.setRoundTopLeft(50);
        panelRound16.setRoundTopRight(50);

        btnThem1.setBackground(new java.awt.Color(221, 242, 244));
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThem1.setToolTipText("Thêm mới khách hàng");
        btnThem1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem1.setColor(new java.awt.Color(221, 242, 244));
        btnThem1.setRadius(50);
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnHienThi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Properties.png"))); // NOI18N
        btnHienThi1.setToolTipText("Hiển thị");
        btnHienThi1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnHienThi1.setColor(new java.awt.Color(221, 242, 244));
        btnHienThi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHienThi1.setRadius(50);
        btnHienThi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnHienThi1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "SĐT", "Email", "Địa chỉ", "Ngày sinh", "Đánh giá", "Trạng thái"
            }
        ));
        tableAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAll);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        rdoTen.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoTen);
        rdoTen.setForeground(new java.awt.Color(255, 255, 255));
        rdoTen.setText("Tên");
        rdoTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoSDT.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoSDT);
        rdoSDT.setForeground(new java.awt.Color(255, 255, 255));
        rdoSDT.setText("SĐT");
        rdoSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoDiaChi.setBackground(new java.awt.Color(67, 130, 187));
        buttonGroup1.add(rdoDiaChi);
        rdoDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        rdoDiaChi.setText("Địa chỉ");
        rdoDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(rdoDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panelRound17.setBackground(new java.awt.Color(67, 130, 187));
        panelRound17.setRoundBottomLeft(50);
        panelRound17.setRoundBottomRight(50);
        panelRound17.setRoundTopLeft(50);
        panelRound17.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh sách khách hàng");

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound17Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-previous-circle-solid-24.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        txtIndex.setText("1/1");

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-next-circle-solid-24.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(txtIndex)
                        .addGap(77, 77, 77)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(txtIndex)
                        .addGap(54, 54, 54))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin khách hàng");

        txtTenKH.setEditable(false);
        txtTenKH.setBackground(new java.awt.Color(228, 206, 224));
        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenKH.setLabelText("Tên khách hàng");

        txtMaKH.setBackground(new java.awt.Color(228, 206, 224));
        txtMaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaKH.setLabelText("Mã khách hàng");

        txtDanhGia.setBackground(new java.awt.Color(228, 206, 224));
        txtDanhGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDanhGia.setLabelText("Đánh giá");

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

        txtSDT.setEditable(false);
        txtSDT.setBackground(new java.awt.Color(228, 206, 224));
        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSDT.setLabelText("Số điện thoại");

        txtEmail.setEditable(false);
        txtEmail.setBackground(new java.awt.Color(228, 206, 224));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.setLabelText("Email");

        txtDiaChi.setBackground(new java.awt.Color(228, 206, 224));
        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDiaChi.setLabelText("Địa chỉ");

        txtNgaySinh.setBackground(new java.awt.Color(228, 206, 224));
        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgaySinh.setLabelText("Ngày sinh");

        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDanhGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDanhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tableAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllMouseClicked
        int row = this.tableAll.getSelectedRow();
        createView.setVisible(false);
        fillData(row);
        rud.custom = hangService.phanTrang(getList, offset, limit).get(row);
//        rud.custom = hangService.findKHByMa(tableAll.getValueAt(row, 1).toString());
        rud.setVisible(true);
        rud.showData();
    }//GEN-LAST:event_tableAllMouseClicked

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        searchRadio();
        clearForm();
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        createView.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnHienThi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThi1ActionPerformed
        getList = hangService.getListKH();
        loadTable(hangService.phanTrang(getList, offset, limit));

        clearForm();
    }//GEN-LAST:event_btnHienThi1ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        txtDanhGia.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMaKH.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtTenKH.setText("");
        txtTrangThai.setText("");
    }//GEN-LAST:event_myButton7ActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        loadTable(hangService.phanTrang(getList, offset, limit));
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        loadTable(hangService.phanTrang(getList, offset, limit));
    }//GEN-LAST:event_btnNextActionPerformed

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnHienThi1;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnSearch1;
    private utilities.palette.MyButton btnThem1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound17;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.RadioButtonCustom rdoDiaChi;
    private utilities.palette.RadioButtonCustom rdoSDT;
    private utilities.palette.RadioButtonCustom rdoTen;
    private utilities.palette.TableDark_1 tableAll;
    private utilities.palette.TextField txtDanhGia;
    private utilities.palette.TextField txtDiaChi;
    private utilities.palette.TextField txtEmail;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtMaKH;
    private utilities.palette.TextField txtNgaySinh;
    private utilities.palette.TextField txtSDT;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearchTheo;
    private utilities.palette.TextField txtTenKH;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
