package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.ChiTietPhieuHoanXuatCustom;
import cores.nhanVienQuanLy.customModels.PhieuHoanXuatCustom;
import cores.nhanVienQuanLy.services.Tai_LuongHoanXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_LuongHoanXuatServiceImpl;
import domainModels.PhieuHoanXuat;
import infrastructures.constant.TrangThaiPhieuHoanConstant;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MsgBox;
import utilities.Page;

/**
 *
 * @author Acer
 */
public class NvqlLuongHoanXuatView extends javax.swing.JPanel {

    private Tai_LuongHoanXuatService luongHXService;
    private List<PhieuHoanXuatCustom> listPHX;
    private Tai_LuongHoanXuat_ListPhieuXuat lisPXView;
    private Tai_LuongHoanXuat_ChiTietPXView ctpxView;
    private Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView ctphieuHoanXuatView;
//
    private Page p;

    private int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    public NvqlLuongHoanXuatView() {
        //
        p = new Page();
        initComponents();
        luongHXService = new Tai_LuongHoanXuatServiceImpl();
        lisPXView = new Tai_LuongHoanXuat_ListPhieuXuat();
        ctpxView = new Tai_LuongHoanXuat_ChiTietPXView();
        ctphieuHoanXuatView = new Tai_LuongHoanXuat_ChiTietPhieuHoanXuatView();
        listPHX = luongHXService.getListPHX();
        loadTable(listPHX);
        clearForm();
    }

    private void clearForm() {
        txtGhiChu.setText("");
        txtKhachHang.setText("");
        txtMaPhieu.setText("");
        txtNgayTao.setText("");
        txtNgayThanhToan.setText("");
        txtIdPhieuXuat.setText("");
        txtNhapTien.setText("");
        txtTongTienPhaiTraKhach.setText("");
        txtTienThua.setText("");
        txtTrangThai.setText("");
        txtLiDo.setText("");
        sizes = listPHX.size();
        offset = 0;
        index = 1;
        loadIndex();
    }

    private void loadTable(List<PhieuHoanXuatCustom> ls) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblPhieuHoanXuat.getModel();
        dtm.setRowCount(0);
        int sum = limit + offset;
        if (ls.size() <= sum) {
            sum = ls.size();
        }
        for (int i = offset; i < sum; i++) {
            if (ls.get(i) == null) {
                return;
            }
            PhieuHoanXuatCustom phx = ls.get(i);
//        for (PhieuHoanXuatCustom phx : listPHX) {
            Date ngayTao = new Date(phx.getNgayTao());
            Date ngayThanhToan = new Date(phx.getNgayThanhToan());
            Object[] rowData = {
                dtm.getRowCount() + 1,
                phx.getId(),
                ngayTao,
                ngayThanhToan,
                phx.getGhiChu(),
                phx.getLiDo(),
                Converter.TrangThaiPhieuHoan(phx.getTrangThai()),
                phx.getPhieuXuat().getId(),
                phx.getPhieuXuat().getKhachHang().getMa()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuHoanXuat = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound15 = new utilities.palette.PanelRound();
        btnCtPhieuXuat = new utilities.palette.MyButton();
        btnCreatPhieuXuat = new utilities.palette.MyButton();
        btnChiTietSP = new utilities.palette.MyButton();
        btnChiTietSP1 = new utilities.palette.MyButton();
        btnShow = new utilities.palette.MyButton();
        btnPre = new utilities.palette.UWPButton();
        btnNext = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtNgayTao = new utilities.palette.TextField();
        txtMaPhieu = new utilities.palette.TextField();
        textAreaScroll1 = new utilities.palette.TextAreaScroll();
        txtGhiChu = new utilities.palette.TextAreaCustom();
        txtTongTienPhaiTraKhach = new utilities.palette.TextField();
        btnThanhToan = new utilities.palette.MyButton();
        txtIdPhieuXuat = new utilities.palette.TextField();
        txtKhachHang = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        txtNgayThanhToan = new utilities.palette.TextField();
        txtNhapTien = new utilities.palette.TextField();
        txtTienThua = new utilities.palette.TextField();
        txtLiDo = new utilities.palette.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tblPhieuHoanXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Phiếu Hoàn", "Ngày tạo", "Ngày thanh toán", "Ghi chú", "Lí do", "Trạng thái", "ID Phiếu Xuât", "Mã KH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuHoanXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuHoanXuatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuHoanXuat);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANH SÁCH PHIẾU HOÀN - XUẤT");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        btnCtPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnCtPhieuXuat.setToolTipText("Xem những sản phẩm được hoàn");
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
        btnCreatPhieuXuat.setToolTipText("Chọn phiếu xuất để tạo mới phiếu hoàn xuất");
        btnCreatPhieuXuat.setBorderColor(new java.awt.Color(221, 242, 244));
        btnCreatPhieuXuat.setColor(new java.awt.Color(221, 242, 244));
        btnCreatPhieuXuat.setRadius(50);
        btnCreatPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatPhieuXuatActionPerformed(evt);
            }
        });

        btnChiTietSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-to-basket.png"))); // NOI18N
        btnChiTietSP.setToolTipText("Giỏ Hàng của phiếu xuất");
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
        btnChiTietSP1.setToolTipText("In bill phiếu hoàn xuất");
        btnChiTietSP1.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChiTietSP1.setColor(new java.awt.Color(221, 242, 244));
        btnChiTietSP1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChiTietSP1.setRadius(50);
        btnChiTietSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSP1ActionPerformed(evt);
            }
        });

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        btnShow.setToolTipText("Hiện thị danh sách phiếu hoàn xuất");
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
                .addContainerGap()
                .addComponent(btnCreatPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCtPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTietSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTietSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTietSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreatPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCtPhieuXuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnChiTietSP1.getAccessibleContext().setAccessibleDescription("Xuất phiếu xuất");

        btnPre.setText("Pre");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        txtIndex.setText("1/1");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 319, Short.MAX_VALUE))))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(txtIndex)
                .addGap(46, 46, 46)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndex))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin phiếu hoàn xuất");

        txtNgayTao.setEditable(false);
        txtNgayTao.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTao.setLabelText("Ngày tạo");

        txtMaPhieu.setEditable(false);
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

        txtGhiChu.setEditable(false);
        txtGhiChu.setBackground(new java.awt.Color(228, 206, 224));
        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.setDisabledTextColor(new java.awt.Color(204, 204, 255));
        textAreaScroll1.setViewportView(txtGhiChu);

        txtTongTienPhaiTraKhach.setEditable(false);
        txtTongTienPhaiTraKhach.setBackground(new java.awt.Color(228, 206, 224));
        txtTongTienPhaiTraKhach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongTienPhaiTraKhach.setLabelText("Tổng tiền phải trả lại khách");

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

        txtIdPhieuXuat.setEditable(false);
        txtIdPhieuXuat.setBackground(new java.awt.Color(228, 206, 224));
        txtIdPhieuXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIdPhieuXuat.setLabelText("ID Phiếu Xuất");

        txtKhachHang.setEditable(false);
        txtKhachHang.setBackground(new java.awt.Color(228, 206, 224));
        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtKhachHang.setLabelText("Khách Hàng");
        txtKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachHangActionPerformed(evt);
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

        txtNgayThanhToan.setEditable(false);
        txtNgayThanhToan.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayThanhToan.setLabelText("Ngày thanh toán");

        txtNhapTien.setBackground(new java.awt.Color(228, 206, 224));
        txtNhapTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhapTien.setLabelText("Nhập tiền");
        txtNhapTien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNhapTienCaretUpdate(evt);
            }
        });

        txtTienThua.setEditable(false);
        txtTienThua.setBackground(new java.awt.Color(228, 206, 224));
        txtTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienThua.setLabelText("Tiền thừa");
        txtTienThua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienThuaCaretUpdate(evt);
            }
        });

        txtLiDo.setEditable(false);
        txtLiDo.setBackground(new java.awt.Color(228, 206, 224));
        txtLiDo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLiDo.setLabelText("Lí do");
        txtLiDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLiDoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNhapTien, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLiDo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(txtTongTienPhaiTraKhach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLiDo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtTongTienPhaiTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtNhapTien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatPhieuXuatActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCreatPhieuXuatActionPerformed
        if (ctphieuHoanXuatView != null || ctpxView != null) {
            ctphieuHoanXuatView.setVisible(false);
            ctpxView.setVisible(false);
        }
        lisPXView.setVisible(true);
    }//GEN-LAST:event_btnCreatPhieuXuatActionPerformed

    private void txtMaPhieuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuActionPerformed
    public PhieuHoanXuat chon() {
        int row = this.tblPhieuHoanXuat.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "Bạn phải chọn 1 phiếu hoàn");
            return null;
        }
        PhieuHoanXuatCustom phxct = listPHX.get(row);
        PhieuHoanXuat phx = new PhieuHoanXuat();
        phx.setGhiChu(phxct.getGhiChu());
        phx.setId(phxct.getId());
        phx.setLiDo(phxct.getLiDo());
        phx.setNgayTao(phxct.getNgayTao());
        phx.setNgayThanhToan(phxct.getNgayThanhToan());
        phx.setPhieuXuat(phxct.getPhieuXuat());
        phx.setTrangThai(phxct.getTrangThai());
        return phx;
    }
    private void btnCtPhieuXuatActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCtPhieuXuatActionPerformed
        if (chon() == null) {
            return;
        }
//        ctpxHoanXuatView.clearForm();
//        ctpxHoanXuatView.setPhieuXuat(chon());
//        ctpxHoanXuatView.setVisible(true);
        ctphieuHoanXuatView.setPhieuHX(chon());
        ctphieuHoanXuatView.setVisible(true);
    }//GEN-LAST:event_btnCtPhieuXuatActionPerformed
    private void txtKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachHangActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void btnChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSPActionPerformed
        int row = tblPhieuHoanXuat.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "Bạn phải chọn một phiếu hoàn");
            return;
        }
        ctpxView.setPhieuXuat(chon());
        ctpxView.setVisible(true);

    }//GEN-LAST:event_btnChiTietSPActionPerformed

    private void tblPhieuHoanXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuHoanXuatMouseClicked
        int row = this.tblPhieuHoanXuat.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maPhieu = this.tblPhieuHoanXuat.getValueAt(row, 1).toString();
        String ngayTao = this.tblPhieuHoanXuat.getValueAt(row, 2).toString();
        String ngayThanhToan = this.tblPhieuHoanXuat.getValueAt(row, 3).toString();
//        String ghiChu = tblPhieuHoanXuat.getValueAt(row, 4).toString();
        String liDo = tblPhieuHoanXuat.getValueAt(row, 5).toString();
        String trangThai = this.tblPhieuHoanXuat.getValueAt(row, 6).toString();
        String idPhieuXuat = this.tblPhieuHoanXuat.getValueAt(row, 7).toString();
        String khachHang = this.tblPhieuHoanXuat.getValueAt(row, 8).toString();

        txtMaPhieu.setText(maPhieu);
        txtNgayTao.setText(ngayTao);
        txtNgayThanhToan.setText(ngayThanhToan);
        txtIdPhieuXuat.setText(idPhieuXuat);
        txtKhachHang.setText(khachHang);
        txtLiDo.setText(liDo);
        txtTrangThai.setText(trangThai);
        txtGhiChu.setText("");
        double tien = 0;
        List<ChiTietPhieuHoanXuatCustom> listCTPHX = luongHXService.getListCTphxByID(listPHX.get(row).getId());
        for (ChiTietPhieuHoanXuatCustom ctphxct : listCTPHX) {
            tien += ctphxct.getIdChiTietSp().getGiaBan().multiply(new BigDecimal(ctphxct.getSoLuong())).doubleValue();
        }
        int tongTien =(int) tien;
        txtTongTienPhaiTraKhach.setText(tongTien + "");
        if (txtTrangThai.getText().equalsIgnoreCase("Hoàn Thành Công")) {
            btnThanhToan.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(true);
        }


    }//GEN-LAST:event_tblPhieuHoanXuatMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = this.tblPhieuHoanXuat.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "Bạn phải chọn 1 phiếu hoàn xuất");
            return;
        }
        String tienNhap = txtNhapTien.getText();
        String TongtienPhaiTra = txtTongTienPhaiTraKhach.getText();
        double tienNhapTraKhach = 0;
        try {
            tienNhapTraKhach = Double.parseDouble(tienNhap);
            if (tienNhapTraKhach <= 0) {
                MsgBox.alert(this, "Phải nhập tiền là kiểu số nguyên dương");
                return;
            }
        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Phải nhập tiền là kiểu số");
            return;
        }
        if (tienNhapTraKhach < Double.valueOf(TongtienPhaiTra)) {
            MsgBox.alert(this, "Phải nhập tiền lớn hơn tiền phải trả");
            return;
        }

        PhieuHoanXuatCustom phxct = listPHX.get(row);
        phxct.setTrangThai(TrangThaiPhieuHoanConstant.HOAN_THANH_CONG);
        luongHXService.updatePHX(phxct);
        MsgBox.alert(this, "Bạn đã thanh toán thành công");
        listPHX.set(row, phxct);
        loadTable(listPHX);
        clearForm();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienThuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienThuaCaretUpdate

    }//GEN-LAST:event_txtTienThuaCaretUpdate

    private void txtNhapTienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNhapTienCaretUpdate
        String tienKhachDua = txtNhapTien.getText();
        String tienPhaiTra = txtTongTienPhaiTraKhach.getText();
        double tienKhach = 0;
        try {
            tienKhach = Double.parseDouble(tienKhachDua);
            if (tienKhach <= 0) {
                MsgBox.alert(this, "Phải nhập tiền là kiểu số nguyên dương");
                return;
            }
        } catch (NumberFormatException e) {
//            MsgBox.alert(this, "Phải nhập tiền là kiểu số");
//            e.printStackTrace();
            return;
        }

        double tienThua = tienKhach - Double.valueOf(tienPhaiTra);
        int tongTien = (int)tienThua;
        txtTienThua.setText(tongTien + "");
    }//GEN-LAST:event_txtNhapTienCaretUpdate

    private void btnChiTietSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSP1ActionPerformed

    }//GEN-LAST:event_btnChiTietSP1ActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        listPHX = luongHXService.getListPHX();
        loadTable(listPHX);
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtLiDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLiDoActionPerformed

    }//GEN-LAST:event_txtLiDoActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        loadTable(listPHX);
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        loadTable(listPHX);
    }//GEN-LAST:event_btnNextActionPerformed

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnChiTietSP;
    private utilities.palette.MyButton btnChiTietSP1;
    private utilities.palette.MyButton btnCreatPhieuXuat;
    private utilities.palette.MyButton btnCtPhieuXuat;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnShow;
    private utilities.palette.MyButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.TableDark_1 tblPhieuHoanXuat;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private utilities.palette.TextField txtIdPhieuXuat;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtKhachHang;
    private utilities.palette.TextField txtLiDo;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.TextField txtNgayThanhToan;
    private utilities.palette.TextField txtNhapTien;
    private utilities.palette.TextField txtTienThua;
    private utilities.palette.TextField txtTongTienPhaiTraKhach;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
