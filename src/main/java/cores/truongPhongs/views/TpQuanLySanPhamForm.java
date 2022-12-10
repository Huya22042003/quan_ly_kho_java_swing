package cores.truongPhongs.views;

import cores.exportPDF.services.ExportSanPhamService;
import cores.exportPDF.services.serviceImpls.ExportSanPhamServiceImpl;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.services.TpQuanLyChiTietSanPhamService;
import cores.truongPhongs.services.TpQuanLySanPhamService;
import cores.truongPhongs.services.serviceImpls.TpQuanLyChiTietSanPhamServiceImpl;
import cores.truongPhongs.services.serviceImpls.TpQuanLySanPhamServiceImpl;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.DateTimeUtil;
import utilities.MaTuSinh;
import utilities.MsgBox;
import utilities.Page;

/**
 *
 * @author MMC
 */
public final class TpQuanLySanPhamForm extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private TpQuanLySanPhamService serviceSanPham = new TpQuanLySanPhamServiceImpl();
    private List<TpQuanLySanPhamCustom> listSanPham = new ArrayList<>();

    private Page p;

    private int limitSp = 7;

    private int offsetSp = 0;

    private int sizesSp = 0;

    private int indexSp = 1;

    // chi tiet sp
    private DefaultTableModel dtmCtsp = new DefaultTableModel();
    private List<TpQuanLyChiTietSanPhamCustom> listChiTietSP = new ArrayList<>();
    private TpQuanLyChiTietSanPhamService serviceChiTietSP = new TpQuanLyChiTietSanPhamServiceImpl();
    String duongdananh = getClass().getResource("/icons/FPT_Polytechnic_doc.png").getPath();

    private final int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    private final ExportSanPhamService esps;

    private final DecimalFormat formatter = new DecimalFormat("###,###,##0");

    public TpQuanLySanPhamForm() {
        p = new Page();
        initComponents();
        tbSanPham.setModel(dtm);
        FormDataCreate.setLocationRelativeTo(null);
        FormDataUpdate.setLocationRelativeTo(null);
        FrameChiTietSanPham.setLocationRelativeTo(null);
        diaLogSearchCtsp.setLocationRelativeTo(null);

        String[] headers = {"STT", "Mã", "Tên", "Giá Nhập", "Giá Bán", "Số lượng"};
        dtm.setColumnIdentifiers(headers);
        clearForm();

        showData(serviceSanPham.phanTrang(listSanPham, offsetSp, limitSp));
        loadIndexSp();
        // chi tiet sp
        esps = new ExportSanPhamServiceImpl();
        tbChiTietSanPham.setModel(dtmCtsp);
        String[] hearders = {"STT", "SL", "Giá Nhập", "Giá Bán", "Màu", "ĐV", "Năm BH", "Trạng thái", "Size", "Tên NCC", "Mã SP NCC", "Ngày nhập"};
        dtmCtsp.setColumnIdentifiers(hearders);
        loadIndexCtsp();
    }

    public void showData(List<TpQuanLySanPhamCustom> list) {
        dtm.setRowCount(0);

        for (TpQuanLySanPhamCustom sp : list) {
            String giaNhap = "Chưa có";
            if (sp.getGiaNhapMin() != null || sp.getGiaNhapMax() != null) {
                giaNhap = formatter.format(sp.getGiaNhapMin()) + " VNĐ" + " - " + formatter.format(sp.getGiaNhapMax()) + " VNĐ";
            }
            String giaBan = "Chưa có";
            if (sp.getGiaBanMin() != null && sp.getGiaBanMax() != null) {
                giaBan = formatter.format(sp.getGiaBanMin()) + " VNĐ" + " - " + formatter.format(sp.getGiaBanMax()) + " VNĐ";
            }
            dtm.addRow(new Object[]{
                dtm.getRowCount() + 1,
                sp.getMa(),
                sp.getTen(),
                giaNhap,
                giaBan,
                sp.getSoLuong() == null ? "Chưa có" : formatter.format(sp.getSoLuong()) + " Đôi"
            });

        }
    }

    public void clearFormCtsp() {
        listChiTietSP = serviceChiTietSP.getAll(this.serviceSanPham.phanTrang(listSanPham, offsetSp, limitSp).get(tbSanPham.getSelectedRow()).getId(), "", "", "", "", "");
        sizes = listChiTietSP.size();
        offset = 0;
        index = 1;
        loadIndexCtsp();
    }

    private void loadIndexCtsp() {
        this.txtIndexCtsp.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    private void loadIndexSp() {
        this.txtIndex.setText(String.valueOf(indexSp) + " / " + (Math.round((sizesSp / limitSp) + 0.5)));
    }

    public void clearForm() {
        listSanPham = serviceSanPham.getAll("");
        sizesSp = listSanPham.size();
        offsetSp = 0;
        indexSp = 1;
        loadIndexSp();
    }

    public void showDataCtsp(List<TpQuanLyChiTietSanPhamCustom> list) {
        dtmCtsp.setRowCount(0);

//            TpQuanLyChiTietSanPhamCustom ct = list.get(i);
        for (TpQuanLyChiTietSanPhamCustom ct : list) {
            dtmCtsp.addRow(new Object[]{
                dtmCtsp.getRowCount() + 1,
                formatter.format(ct.getSoLuongTon()) + "Đôi",
                ct.getGiaNhap() == null ? "Chưa có" : formatter.format(ct.getGiaNhap()) + "VNĐ",
                ct.getGiaBan() == null ? "Chưa có" : formatter.format(ct.getGiaBan()) + "VNĐ",
                Converter.trangThaiMauSac(ct.convertMau()),
                ct.getDoViQuyDoi(),
                ct.getNamBaoHanh(),
                Converter.trangThaiSanPham(ct.convertTrangThai()),
                ct.getSize(),
                ct.getTenNcc(),
                ct.getMaSpNcc(),
                new Date(ct.getNgayNhap()).toString()
            });
        }
    }

    TpQuanLyChiTietSanPhamCustom getRowTable() {
        int row = this.tbChiTietSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return null;
        }
        return serviceChiTietSP.phanTrang(listChiTietSP, offset, limit).get(row);
    }

    public void addMouseClickTable(MouseListener e) {
        tbChiTietSanPham.addMouseListener(e);
    }

    public TpQuanLySanPhamCustom getFormData() {
        TpQuanLySanPhamCustom sp = new TpQuanLySanPhamCustom();
        sp.setMa(this.txtMa.getText());
        sp.setTen(txtTen.getText());

        return sp;
    }

    public TpQuanLySanPhamCustom getFormDataUpdate() {
        TpQuanLySanPhamCustom sp = new TpQuanLySanPhamCustom();
        sp.setMa(this.txtMaUpdate.getText());
        sp.setTen(txtTenUpdate.getText());

        return sp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        FrameChiTietSanPham = new javax.swing.JFrame();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound17 = new utilities.palette.PanelRound();
        btnThem1 = new utilities.palette.MyButton();
        btnHienThi1 = new utilities.palette.MyButton();
        myButton7 = new utilities.palette.MyButton();
        btnSearch = new utilities.palette.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChiTietSanPham = new utilities.palette.TableDark_1();
        panelRound6 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        txtIndexCtsp = new javax.swing.JLabel();
        uWPButton6 = new utilities.palette.UWPButton();
        uWPButton7 = new utilities.palette.UWPButton();
        diaLogSearchCtsp = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        txtMaSpNcc = new utilities.palette.TextField();
        txtTenNcc = new utilities.palette.TextField();
        btnSearch2 = new utilities.palette.MyButton();
        btnExit = new utilities.palette.MyButton();
        jLabel1 = new javax.swing.JLabel();
        txtSdtNcc = new utilities.palette.TextField();
        txtEmailNcc = new utilities.palette.TextField();
        txtMaNcc = new utilities.palette.TextField();
        FormDataCreate = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        uWPButton1 = new utilities.palette.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        test = new javax.swing.JLabel();
        uWPButton2 = new utilities.palette.UWPButton();
        uWPButton3 = new utilities.palette.UWPButton();
        txtMa = new utilities.palette.TextField();
        txtTen = new utilities.palette.TextField();
        erroMa = new javax.swing.JLabel();
        erroTen = new javax.swing.JLabel();
        FormDataUpdate = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        uWPButton8 = new utilities.palette.UWPButton();
        jPanel5 = new javax.swing.JPanel();
        test1 = new javax.swing.JLabel();
        btnUpdate1 = new utilities.palette.UWPButton();
        uWPButton9 = new utilities.palette.UWPButton();
        txtMaUpdate = new utilities.palette.TextField();
        txtTenUpdate = new utilities.palette.TextField();
        erroMa1 = new javax.swing.JLabel();
        erroViTri = new javax.swing.JLabel();
        erroTen1 = new javax.swing.JLabel();
        btnDelete = new utilities.palette.UWPButton();
        panelRound2 = new utilities.palette.PanelRound();
        panelRound16 = new utilities.palette.PanelRound();
        btnChon = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        btnThem = new utilities.palette.MyButton();
        btnUpdate = new utilities.palette.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        txtSearchTheo = new javax.swing.JTextField();
        btnSearch1 = new utilities.palette.MyButton();
        panelRound15 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        uWPButton4 = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        uWPButton5 = new utilities.palette.UWPButton();

        FrameChiTietSanPham.setUndecorated(true);
        FrameChiTietSanPham.setSize(new java.awt.Dimension(1120, 636));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        panelRound17.setBackground(new java.awt.Color(67, 130, 187));
        panelRound17.setRoundBottomLeft(50);
        panelRound17.setRoundBottomRight(50);
        panelRound17.setRoundTopLeft(50);
        panelRound17.setRoundTopRight(50);

        btnThem1.setBackground(new java.awt.Color(221, 242, 244));
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print.png"))); // NOI18N
        btnThem1.setToolTipText("In phiếu");
        btnThem1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem1.setColor(new java.awt.Color(221, 242, 244));
        btnThem1.setRadius(50);
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnHienThi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill.png"))); // NOI18N
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

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Log out.png"))); // NOI18N
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

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHienThi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(myButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jScrollPane2.setViewportView(tbChiTietSanPham);

        panelRound6.setBackground(new java.awt.Color(67, 130, 187));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DANH SÁCH CHI TIẾT SẢN PHẨM");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound6Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtIndexCtsp.setText("hihi");

        uWPButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-next-circle-solid-24.png"))); // NOI18N
        uWPButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton6ActionPerformed(evt);
            }
        });

        uWPButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-previous-circle-solid-24.png"))); // NOI18N
        uWPButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(326, 335, Short.MAX_VALUE)
                .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(txtIndexCtsp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndexCtsp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout FrameChiTietSanPhamLayout = new javax.swing.GroupLayout(FrameChiTietSanPham.getContentPane());
        FrameChiTietSanPham.getContentPane().setLayout(FrameChiTietSanPhamLayout);
        FrameChiTietSanPhamLayout.setHorizontalGroup(
            FrameChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameChiTietSanPhamLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        FrameChiTietSanPhamLayout.setVerticalGroup(
            FrameChiTietSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameChiTietSanPhamLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        diaLogSearchCtsp.setSize(new java.awt.Dimension(549, 383));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMaSpNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSpNcc.setLabelText("Mã sản phẩm nhà cung cấp");
        txtMaSpNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSpNccActionPerformed(evt);
            }
        });

        txtTenNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenNcc.setLabelText("Tên nhà cung cấp");
        txtTenNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNccActionPerformed(evt);
            }
        });

        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        btnSearch2.setToolTipText("Tìm kiếm");
        btnSearch2.setBorderColor(new java.awt.Color(204, 204, 255));
        btnSearch2.setColorClick(new java.awt.Color(204, 204, 255));
        btnSearch2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch2.setLabel("Search");
        btnSearch2.setRadius(200);
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setToolTipText("Thoát");
        btnExit.setBorderColor(new java.awt.Color(204, 204, 255));
        btnExit.setColorClick(new java.awt.Color(204, 204, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setRadius(200);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Mời bạn tìm kiếm");

        txtSdtNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSdtNcc.setLabelText("Sdt nhà cung cấp");
        txtSdtNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtNccActionPerformed(evt);
            }
        });

        txtEmailNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmailNcc.setLabelText("Email Ncc");
        txtEmailNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailNccActionPerformed(evt);
            }
        });

        txtMaNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaNcc.setLabelText("Mã nhà cung cấp");
        txtMaNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(txtTenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaSpNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmailNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSdtNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSpNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtSdtNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout diaLogSearchCtspLayout = new javax.swing.GroupLayout(diaLogSearchCtsp.getContentPane());
        diaLogSearchCtsp.getContentPane().setLayout(diaLogSearchCtspLayout);
        diaLogSearchCtspLayout.setHorizontalGroup(
            diaLogSearchCtspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        diaLogSearchCtspLayout.setVerticalGroup(
            diaLogSearchCtspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        FormDataCreate.setUndecorated(true);
        FormDataCreate.setSize(new java.awt.Dimension(436, 466));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        uWPButton1.setBackground(new java.awt.Color(255, 51, 51));
        uWPButton1.setText("X");
        uWPButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FPT_Polytechnic_doc.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(test, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        uWPButton2.setBackground(new java.awt.Color(255, 153, 102));
        uWPButton2.setText("Save");
        uWPButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton2ActionPerformed(evt);
            }
        });

        uWPButton3.setBackground(new java.awt.Color(255, 51, 51));
        uWPButton3.setText("Close");
        uWPButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton3ActionPerformed(evt);
            }
        });

        txtMa.setEditable(false);
        txtMa.setLabelText("Mã");

        txtTen.setLabelText("Tên");

        erroMa.setForeground(new java.awt.Color(255, 51, 51));

        erroTen.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(uWPButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(uWPButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroMa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroTen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroMa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uWPButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uWPButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FormDataCreateLayout = new javax.swing.GroupLayout(FormDataCreate.getContentPane());
        FormDataCreate.getContentPane().setLayout(FormDataCreateLayout);
        FormDataCreateLayout.setHorizontalGroup(
            FormDataCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormDataCreateLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FormDataCreateLayout.setVerticalGroup(
            FormDataCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormDataCreateLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        FormDataUpdate.setUndecorated(true);
        FormDataUpdate.setSize(new java.awt.Dimension(402, 457));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        uWPButton8.setBackground(new java.awt.Color(255, 51, 51));
        uWPButton8.setText("X");
        uWPButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton8ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        test1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FPT_Polytechnic_doc.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(test1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnUpdate1.setBackground(new java.awt.Color(255, 153, 102));
        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        uWPButton9.setBackground(new java.awt.Color(255, 51, 51));
        uWPButton9.setText("Close");
        uWPButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton9ActionPerformed(evt);
            }
        });

        txtMaUpdate.setEditable(false);
        txtMaUpdate.setLabelText("Mã");

        txtTenUpdate.setLabelText("Tên");

        erroMa1.setForeground(new java.awt.Color(255, 51, 51));

        erroViTri.setForeground(new java.awt.Color(255, 51, 51));

        erroTen1.setForeground(new java.awt.Color(255, 51, 51));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(erroViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uWPButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroMa1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uWPButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uWPButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(txtMaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroMa1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtTenUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(erroViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(uWPButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FormDataUpdateLayout = new javax.swing.GroupLayout(FormDataUpdate.getContentPane());
        FormDataUpdate.getContentPane().setLayout(FormDataUpdateLayout);
        FormDataUpdateLayout.setHorizontalGroup(
            FormDataUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        FormDataUpdateLayout.setVerticalGroup(
            FormDataUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        panelRound2.setBackground(new java.awt.Color(204, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        panelRound16.setBackground(new java.awt.Color(67, 130, 187));
        panelRound16.setRoundBottomLeft(50);
        panelRound16.setRoundBottomRight(50);
        panelRound16.setRoundTopLeft(50);
        panelRound16.setRoundTopRight(50);

        btnChon.setBackground(new java.awt.Color(221, 242, 244));
        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Buddy.png"))); // NOI18N
        btnChon.setToolTipText("Xem Chi tiết");
        btnChon.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChon.setColor(new java.awt.Color(221, 242, 244));
        btnChon.setRadius(50);
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Properties.png"))); // NOI18N
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

        btnThem.setBackground(new java.awt.Color(221, 242, 244));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThem.setToolTipText("Thêm mới phiếu nhập");
        btnThem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem.setColor(new java.awt.Color(221, 242, 244));
        btnThem.setRadius(50);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_1.png"))); // NOI18N
        btnUpdate.setToolTipText("Update, Delete");
        btnUpdate.setBorderColor(new java.awt.Color(221, 242, 244));
        btnUpdate.setColor(new java.awt.Color(221, 242, 244));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setRadius(50);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound16Layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnHienThi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnSearch1.setToolTipText("Tìm phiếu nhập");
        btnSearch1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnSearch1.setColor(new java.awt.Color(221, 242, 244));
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch1.setRadius(50);
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txtSearchTheo))
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        uWPButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-previous-circle-solid-24.png"))); // NOI18N
        uWPButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton4ActionPerformed(evt);
            }
        });

        txtIndex.setText("1/1");

        uWPButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skip-next-circle-solid-24.png"))); // NOI18N
        uWPButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked

    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        String search = this.txtSearchTheo.getText();
        listSanPham = serviceSanPham.getAll(search);
        showData(serviceSanPham.phanTrang(listSanPham, offsetSp, limitSp));
        loadIndexSp();
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        int row = this.tbSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }
        this.FrameChiTietSanPham.setLocationRelativeTo(null);
        this.FrameChiTietSanPham.setVisible(true);
        this.clearFormCtsp();
        this.loadIndexCtsp();
        showDataCtsp(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        listSanPham = serviceSanPham.getAll("");
        showData(serviceSanPham.phanTrang(listSanPham, offsetSp, limitSp));
        clearForm();
        loadIndexSp();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        FormDataCreate.setVisible(true);
        FormDataUpdate.setVisible(false);
        FrameChiTietSanPham.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void uWPButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton4ActionPerformed
        indexSp = p.prevIndex(offsetSp, limitSp, indexSp);
        offsetSp = p.prev(offsetSp, limitSp);
        loadIndexSp();
        showData(serviceSanPham.phanTrang(listSanPham, offsetSp, limitSp));
    }//GEN-LAST:event_uWPButton4ActionPerformed

    private void uWPButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton5ActionPerformed
        indexSp = p.nextIndex(offsetSp, limitSp, sizesSp, indexSp);
        offsetSp = p.next(offsetSp, limitSp, sizesSp);
        loadIndexSp();
        showData(serviceSanPham.phanTrang(listSanPham, offsetSp, limitSp));
    }//GEN-LAST:event_uWPButton5ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = this.tbSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }

        this.txtMaUpdate.setText(listSanPham.get(row).getMa());
        this.txtTenUpdate.setText(listSanPham.get(row).getTen());

        FormDataCreate.setVisible(false);
        FormDataUpdate.setVisible(true);
        FrameChiTietSanPham.setVisible(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    // chi tiết san pham ------------------------------------------------

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        int row = this.tbChiTietSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }
        TpQuanLyChiTietSanPhamCustom ctsp = listChiTietSP.get(row);
        String fileName = new Date(DateTimeUtil.convertDateToTimeStampSecond()).toString() + ".pdf";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (esps.exportSanPham(fileChooser.getSelectedFile().getPath() + "\\" + fileName.replaceAll(":", "_"), ctsp.getId())) {
                JOptionPane.showMessageDialog(this, "Xuất file thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xuất file thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Folder Selected: ");
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnHienThi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThi1ActionPerformed
        clearFormCtsp();
        loadIndexCtsp();
        showDataCtsp(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_btnHienThi1ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        this.FrameChiTietSanPham.setVisible(false);
    }//GEN-LAST:event_myButton7ActionPerformed

    private void tbChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietSanPhamMouseClicked
//        int row = this.tbChiTietSanPham.getSelectedRow();
//        jFrameCreate.setVisible(false);
//        //        fillData(row);
//        //        rud.ct = listChiTietSP.get(row);
//        this.jFrameUpdate.setVisible(true);
//        //        rud.ct = serviceChiTietSP.phanTrang(listChiTietSP, offset, limit).get(row);
//        //        rud.setVisible(true);
//        //        rud.showData();
    }//GEN-LAST:event_tbChiTietSanPhamMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        diaLogSearchCtsp.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void uWPButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton6ActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndexCtsp();
        showDataCtsp(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_uWPButton6ActionPerformed

    private void uWPButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton7ActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndexCtsp();
        showDataCtsp(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_uWPButton7ActionPerformed

    private void txtMaSpNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSpNccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSpNccActionPerformed

    private void txtTenNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNccActionPerformed

    private void txtSdtNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtNccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtNccActionPerformed

    private void txtEmailNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailNccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailNccActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        String maNcc = this.txtMaNcc.getText();
        String tenNcc = this.txtTenNcc.getText();
        String maSpNcc = this.txtMaSpNcc.getText();
        String emailNcc = this.txtEmailNcc.getText();
        String sdtNcc = this.txtSdtNcc.getText();

        listChiTietSP = serviceChiTietSP.getAll(this.listSanPham.get(tbSanPham.getSelectedRow()).getId(), maNcc, tenNcc, maSpNcc, emailNcc, sdtNcc);
        sizes = listChiTietSP.size();
        offset = 0;
        index = 1;
        loadIndexCtsp();
        showDataCtsp(listChiTietSP);
        diaLogSearchCtsp.setVisible(false);
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        diaLogSearchCtsp.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtMaNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNccActionPerformed

    private void uWPButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton1ActionPerformed
        FormDataCreate.setVisible(false);
    }//GEN-LAST:event_uWPButton1ActionPerformed

    private void uWPButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton2ActionPerformed
        TpQuanLySanPhamCustom check = serviceSanPham.checkValidate(getFormData(), erroMa, erroTen);
        if (check == null) {
            return;
        }

        check.setMa(MaTuSinh.gen("SP"));

        if (serviceSanPham.addSanPham(check) == null) {
            MsgBox.alert(this, "Thêm thất bại");
            FormDataCreate.setVisible(true);
        } else {
            MsgBox.alert(this, "Thêm thành công");
            FormDataCreate.setVisible(false);
        }
    }//GEN-LAST:event_uWPButton2ActionPerformed

    private void uWPButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton3ActionPerformed
        FormDataCreate.setVisible(false);
    }//GEN-LAST:event_uWPButton3ActionPerformed

    private void uWPButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton8ActionPerformed
        FormDataUpdate.setVisible(false);
    }//GEN-LAST:event_uWPButton8ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        TpQuanLySanPhamCustom check = serviceSanPham.checkValidate(getFormDataUpdate(), erroMa1, erroTen1);
        if (check == null) {
            return;
        }

        check.setId(listSanPham.get(tbSanPham.getSelectedRow()).getId());

        if (serviceSanPham.updateSanPham(check)) {
            MsgBox.alert(this, "Sửa thành công");
            FormDataUpdate.setVisible(false);
        } else {
            MsgBox.alert(this, "Sửa thất bại");
            FormDataUpdate.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void uWPButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton9ActionPerformed
        FormDataUpdate.setVisible(false);
    }//GEN-LAST:event_uWPButton9ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (serviceSanPham.deleteSanPham(listSanPham.get(this.tbSanPham.getSelectedRow()).getId())) {
            MsgBox.alert(this, "Xóa thành công");
            FormDataUpdate.setVisible(false);
        } else {
            MsgBox.alert(this, "Xóa thất bại");
            FormDataUpdate.setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FormDataCreate;
    private javax.swing.JFrame FormDataUpdate;
    private javax.swing.JFrame FrameChiTietSanPham;
    private utilities.palette.MyButton btnChon;
    private utilities.palette.UWPButton btnDelete;
    private utilities.palette.MyButton btnExit;
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.MyButton btnHienThi1;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.MyButton btnSearch1;
    private utilities.palette.MyButton btnSearch2;
    private utilities.palette.MyButton btnThem;
    private utilities.palette.MyButton btnThem1;
    private utilities.palette.MyButton btnUpdate;
    private utilities.palette.UWPButton btnUpdate1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog diaLogSearchCtsp;
    private javax.swing.JLabel erroMa;
    private javax.swing.JLabel erroMa1;
    private javax.swing.JLabel erroTen;
    private javax.swing.JLabel erroTen1;
    private javax.swing.JLabel erroViTri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound17;
    private utilities.palette.PanelRound panelRound2;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound6;
    private utilities.palette.TableDark_1 tbChiTietSanPham;
    private utilities.palette.TableDark_1 tbSanPham;
    private javax.swing.JLabel test;
    private javax.swing.JLabel test1;
    private utilities.palette.TextField txtEmailNcc;
    private javax.swing.JLabel txtIndex;
    private javax.swing.JLabel txtIndexCtsp;
    private utilities.palette.TextField txtMa;
    private utilities.palette.TextField txtMaNcc;
    private utilities.palette.TextField txtMaSpNcc;
    private utilities.palette.TextField txtMaUpdate;
    private utilities.palette.TextField txtSdtNcc;
    private javax.swing.JTextField txtSearchTheo;
    private utilities.palette.TextField txtTen;
    private utilities.palette.TextField txtTenNcc;
    private utilities.palette.TextField txtTenUpdate;
    private utilities.palette.UWPButton uWPButton1;
    private utilities.palette.UWPButton uWPButton2;
    private utilities.palette.UWPButton uWPButton3;
    private utilities.palette.UWPButton uWPButton4;
    private utilities.palette.UWPButton uWPButton5;
    private utilities.palette.UWPButton uWPButton6;
    private utilities.palette.UWPButton uWPButton7;
    private utilities.palette.UWPButton uWPButton8;
    private utilities.palette.UWPButton uWPButton9;
    // End of variables declaration//GEN-END:variables
}
