package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import cores.nhanVienQuanLy.customModels.Tai_SanPhamCustom;
import cores.nhanVienQuanLy.services.Tai_NvqlLuongPhieuXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_NvqlLuongPhieuXuatServiceImpl;
import domainModels.ChiTietSanPham;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MsgBox;
import utilities.Page;

/**
 *
 * @author admin
 */
public class Tai_LuongPhieuXuat_CTSanPhamView extends javax.swing.JFrame {

    private Tai_NvqlLuongPhieuXuatService luongService;
    List<Tai_SanPhamCustom> ListSP;
    private List<LuongBanHang_ChiTietSanPhamCustom> listChiTietSP;
    public List<Luong_ChiTietPhieuXuatCustom> listCTPX;
    private Tai_LuongPhieuXuat_CTPhieuXuatView ctpxView;
    public PhieuXuat phieuXuat;
    private String duongDan = getClass().getResource("/icons/file.png").getPath();

    public void setPhieuXuat(PhieuXuat phieuXuat) {
        this.phieuXuat = phieuXuat;
    }
    private Page p;

    private int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;
    private DecimalFormat formatter = new DecimalFormat("###,###,##0");

    public Tai_LuongPhieuXuat_CTSanPhamView() {
        p = new Page();
        initComponents();
        luongService = new Tai_NvqlLuongPhieuXuatServiceImpl();
        ListSP = luongService.getListSP();
        listChiTietSP = new ArrayList<>();
        ctpxView = new Tai_LuongPhieuXuat_CTPhieuXuatView();
        listCTPX = luongService.getListCTPhieuXuat();
        sizes = ListSP.size();
        loadTable(luongService.getListSP());

    }

    public void loadTable(List<Tai_SanPhamCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblSanPham.getModel();
        dtm.setRowCount(0);
        for (Tai_SanPhamCustom sp : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                sp.getMa(),
                sp.getTen()
            };
            dtm.addRow(rowData);
        }

    }

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    public void showDataCtsp(List<LuongBanHang_ChiTietSanPhamCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tbChiTietSanPham.getModel();
        dtm.setRowCount(0);
//        for (LuongBanHang_ChiTietSanPhamCustom ct : list) {
//            ChiTietPhieuNhap ctpn = luongService.findCTpnByID(ct.getId());
//            dtm.addRow(new Object[]{
//                dtm.getRowCount() + 1,
//                formatter.format(ct.getSoLuongTon()) + " Đôi",
//                ct.getGiaNhap() == null ? "Chưa có" : formatter.format(ct.getGiaNhap()) + "VNĐ",
//                ct.getGiaBan() == null ? "Chưa có" : formatter.format(ct.getGiaBan()) + "VNĐ",
//                Converter.trangThaiMauSac(ct.getMau()),
//                ct.getDonVi().getDonViQuyDoi(),
//                ct.getNamBaoHanh(),
//                Converter.trangThaiSanPham(ct.getTrangThai()),
//                ct.getSize(),
//                ctpn.getIdPhieuNhap().getNhaCungCap().getTen(),
//                ctpn.getIdPhieuNhap().getNhaCungCap().getMa(),
//                new Date(ctpn.getIdPhieuNhap().getNgayTao()).toString()
//            });
//        }
        for (LuongBanHang_ChiTietSanPhamCustom ctsp : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                ctsp.getSoLuongTon(),
                ctsp.getGiaNhap() == null ? "Chưa có" : formatter.format(ctsp.getGiaNhap()) + "VNĐ",
                ctsp.getGiaBan() == null ? "Chưa có" : formatter.format(ctsp.getGiaBan()) + "VNĐ",
                Converter.trangThaiMauSac(ctsp.getMau()),
                ctsp.getDonVi().getDonViGoc(),
                ctsp.getNamBaoHanh(),
                Converter.trangThaiSanPham(ctsp.getTrangThai()),
                ctsp.getSize(),
                ctsp.getNcc().getTen()
            };
            dtm.addRow(rowData);
        }
    }

    LuongBanHang_ChiTietSanPhamCustom getRowTable() {
        int row = this.tbChiTietSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return null;
        }
        return luongService.getListCTSanPham().get(row);
    }

    public void addMouseClickTable(MouseListener e) {
        tbChiTietSanPham.addMouseListener(e);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameChiTietSanPham = new javax.swing.JFrame();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound17 = new utilities.palette.PanelRound();
        btnHienThi1 = new utilities.palette.MyButton();
        myButton7 = new utilities.palette.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChiTietSanPham = new utilities.palette.TableDark_1();
        panelRound7 = new utilities.palette.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelRound2 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new utilities.palette.TextField();
        txtTenSp = new utilities.palette.TextField();
        txtSoLuong = new utilities.palette.TextField();
        txtGiaNhap = new utilities.palette.TextField();
        errorSoLuong = new javax.swing.JLabel();
        txtGiaBan = new utilities.palette.TextField();
        panelRound6 = new utilities.palette.PanelRound();
        jButton1 = new javax.swing.JButton();
        btnHienThi = new utilities.palette.MyButton();
        btnSearch = new utilities.palette.MyButton();
        txtGiaTo = new utilities.palette.TextField();
        btnChon = new utilities.palette.MyButton();
        panelRound4 = new utilities.palette.PanelRound();
        btnAnh = new utilities.palette.UWPButton();
        btnPre = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        btnNext = new utilities.palette.UWPButton();

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

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound17Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnHienThi1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThi1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(myButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Số lượng", "Giá Nhập", "Giá Bán", "Màu", "Đơn vị", "Năm BH", "Trạng thái", "Size", "Tên NCC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChiTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbChiTietSanPham);

        panelRound7.setBackground(new java.awt.Color(67, 130, 187));
        panelRound7.setRoundBottomLeft(50);
        panelRound7.setRoundBottomRight(50);
        panelRound7.setRoundTopLeft(50);
        panelRound7.setRoundTopRight(50);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DANH SÁCH CHI TIẾT SẢN PHẨM");

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound7Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản phẩm", "Tên sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        panelRound2.setBackground(new java.awt.Color(228, 206, 224));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Thông tin sản phẩm");

        txtMa.setEditable(false);
        txtMa.setBackground(new java.awt.Color(228, 206, 224));
        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMa.setLabelText("Mã SP");
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        txtTenSp.setEditable(false);
        txtTenSp.setBackground(new java.awt.Color(228, 206, 224));
        txtTenSp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSp.setLabelText("Tên SP");

        txtSoLuong.setEditable(false);
        txtSoLuong.setBackground(new java.awt.Color(228, 206, 224));
        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuong.setLabelText("Số lượng");

        txtGiaNhap.setEditable(false);
        txtGiaNhap.setBackground(new java.awt.Color(228, 206, 224));
        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaNhap.setLabelText("Giá nhập");
        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });

        errorSoLuong.setForeground(new java.awt.Color(255, 0, 0));

        txtGiaBan.setEditable(false);
        txtGiaBan.setBackground(new java.awt.Color(228, 206, 224));
        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaBan.setLabelText("Giá Bán");
        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenSp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(errorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound6.setBackground(new java.awt.Color(0, 255, 255));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnHienThi.setText("\n");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtGiaTo.setLabelText("Đến");

        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Lists.png"))); // NOI18N
        btnChon.setText(" ");
        btnChon.setToolTipText("Xem chi tiết sản phẩm");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(txtGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound6Layout.createSequentialGroup()
                        .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );

        panelRound4.setBackground(new java.awt.Color(228, 206, 224));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        btnAnh.setBackground(new java.awt.Color(228, 206, 224));
        btnAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/d8566d8da1401a4114298a7726147ec8.jpg"))); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelRound6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(txtIndex)
                        .addGap(67, 67, 67)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtIndex)))
                        .addGap(33, 33, 33))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

        int row = this.tblSanPham.getSelectedRow();
        txtMa.setText(tblSanPham.getValueAt(row, 1).toString());
        txtTenSp.setText(tblSanPham.getValueAt(row, 2).toString());
        listChiTietSP = luongService.getListCTSanPhamByID(ListSP.get(row).getId());
        int tongSL = 0;
        for (LuongBanHang_ChiTietSanPhamCustom ctsp : listChiTietSP) {
            tongSL +=ctsp.getSoLuongTon();
        }
        txtSoLuong.setText(tongSL +" ");
        
//        txtSoLuong.setText(tblSanPham.getValueAt(row, 3).toString());
//        txtGiaNhap.setText(tblSanPham.getValueAt(row, 4).toString());
//        txtGiaBan.setText(tblSanPham.getValueAt(row, 5).toString());
        
    }//GEN-LAST:event_tblSanPhamMouseClicked


    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        ListSP = luongService.getListSP();
        loadTable(ListSP);
//        loadIndex();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
//        indexSp = p.prevIndex(offsetSp, limitSp, indexSp);
//        offset = p.prev(offsetSp, limitSp);
//        loadIndex();
//        //        loadTable(getList);
//        loadTable(sanPhamService.phanTrang(ListSP, offsetSp, limitSp));
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
//        index = p.nextIndex(offsetSp, limitSp, sizes, indexSp);
//        offset = p.next(offsetSp, limitSp, sizesSp);
//        loadIndex();
//        //        loadTable(getList);
//        loadTable(sanPhamService.phanTrang(ListSP, offsetSp, limitSp));
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnHienThi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThi1ActionPerformed
        listChiTietSP = luongService.getListCTSanPhamByID(ListSP.get(tblSanPham.getSelectedRow()).getId());
        showDataCtsp(listChiTietSP);
    }//GEN-LAST:event_btnHienThi1ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        this.FrameChiTietSanPham.setVisible(false);
    }//GEN-LAST:event_myButton7ActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        int row = this.tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }
        this.FrameChiTietSanPham.setLocationRelativeTo(null);
        this.FrameChiTietSanPham.setVisible(true);
        listChiTietSP = luongService.getListCTSanPhamByID(ListSP.get(row).getId());
        showDataCtsp(listChiTietSP);
    }//GEN-LAST:event_btnChonActionPerformed

    private void tbChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietSanPhamMouseClicked
        int row = this.tbChiTietSanPham.getSelectedRow();
        LuongBanHang_ChiTietSanPhamCustom ctsp = listChiTietSP.get(row);
        if (phieuXuat.getTrangThai().equals(TrangThaiPhieuConstant.DA_THANH_TOAN)) {
            MsgBox.alert(this, "Phiếu xuất này đã ở trạng thái đã thanh toán nên không thể mua hàng! Vui tạo tạo phiếu xuất mới");
            return;
        }
        if (ctsp.getTrangThai().equals(TrangThaiSanPhamConstanst.CHO_XAC_NHAN) || ctsp.getTrangThai().equals(TrangThaiSanPhamConstanst.DUNG_BAN)) {
            MsgBox.alert(this, "Sản phẩm này hiện được bán nên không thể mua hàng! ");
            return;
        }
        String input = JOptionPane.showInputDialog("Bạn mua muốn bao nhiêu ?");
        if (input == null) {
            return;
        }
        int sl = 0;
        try {
            sl = Integer.parseInt(input);
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập số nguyên dương");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập là kiểu số");
            e.printStackTrace();
            return;
        }
        if (ctsp.getSoLuongTon() < sl) {
            MsgBox.alert(this, "Số lượng sản phẩm phải lớn hơn hoặc bằng số lượng tồn");
            return;
        }
        for (Luong_ChiTietPhieuXuatCustom ctpx : luongService.getListCTPhieuXuat()) {
            if (listChiTietSP.get(row).getId().equals(ctpx.getIdChiTietSp().getId()) && phieuXuat.getId().equals(ctpx.getIdPhieuXuat().getId())) {
                ctpx.setSoLuong(ctpx.getSoLuong() + sl);
                luongService.updateCTPX(ctpx);
                ctsp.setSoLuongTon(ctsp.getSoLuongTon() - sl);
                luongService.updateCTSP(ctsp);

                listChiTietSP.set(row, ctsp);
                showDataCtsp(listChiTietSP);
                if (listChiTietSP.get(row).getHinhAnh() == null) {
                    this.btnAnh.setIcon(new ImageIcon(duongDan));
                } else {
                    btnAnh.setIcon(new ImageIcon(listChiTietSP.get(row).getHinhAnh()));
                }
                return;
            }
        }
        ctsp.setSoLuongTon(ctsp.getSoLuongTon() - sl);
        luongService.updateCTSP(ctsp);
        listChiTietSP.set(row, ctsp);
        showDataCtsp(listChiTietSP);
        Luong_ChiTietPhieuXuatCustom ctPhieuXuat = new Luong_ChiTietPhieuXuatCustom();
        ChiTietSanPham ctSanPham = new ChiTietSanPham(ctsp.getId(), ctsp.getSoLuongTon(), ctsp.getHinhAnh(),
                ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getNamBaoHanh(),
                ctsp.getMau(), ctsp.getTrangThai(), ctsp.getSize(), ctsp.getNgayTao(), ctsp.getSanPham(), ctsp.getDonVi());
        ctPhieuXuat.setIdChiTietSp(ctSanPham);
        ctPhieuXuat.setSoLuong(sl);
        ctPhieuXuat.setIdPhieuXuat(this.phieuXuat);
        luongService.addCTPX(ctPhieuXuat);
        JOptionPane.showMessageDialog(this, "Thêm vào phiếu xuất thành công");
        ctpxView.listCTPX.add(ctPhieuXuat);
//
//        loadTable(sanPhamService.phanTrang(sanPhamService.getAll(""), offset, limit));
//
        if (listChiTietSP.get(row).getHinhAnh() == null) {
            this.btnAnh.setIcon(new ImageIcon(duongDan));
        } else {
            btnAnh.setIcon(new ImageIcon(listChiTietSP.get(row).getHinhAnh()));
        }
    }//GEN-LAST:event_tbChiTietSanPhamMouseClicked

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
            java.util.logging.Logger.getLogger(Tai_LuongPhieuXuat_CTSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongPhieuXuat_CTSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongPhieuXuat_CTSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongPhieuXuat_CTSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tai_LuongPhieuXuat_CTSanPhamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameChiTietSanPham;
    private utilities.palette.UWPButton btnAnh;
    private utilities.palette.MyButton btnChon;
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.MyButton btnHienThi1;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnSearch;
    private javax.swing.JLabel errorSoLuong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound17;
    private utilities.palette.PanelRound panelRound2;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound6;
    private utilities.palette.PanelRound panelRound7;
    private utilities.palette.TableDark_1 tbChiTietSanPham;
    private utilities.palette.TableDark_1 tblSanPham;
    private utilities.palette.TextField txtGiaBan;
    private utilities.palette.TextField txtGiaNhap;
    private utilities.palette.TextField txtGiaTo;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtMa;
    private utilities.palette.TextField txtSoLuong;
    private utilities.palette.TextField txtTenSp;
    // End of variables declaration//GEN-END:variables
}
