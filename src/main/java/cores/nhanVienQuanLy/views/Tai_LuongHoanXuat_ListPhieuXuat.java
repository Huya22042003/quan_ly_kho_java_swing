package cores.nhanVienQuanLy.views;

import cores.nhanVienQuanLy.customModels.PhieuHoanXuatCustom;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import cores.nhanVienQuanLy.services.NVQLQuanLyPhieuXuatService;
import cores.nhanVienQuanLy.services.Tai_LuongHoanXuatService;
import cores.nhanVienQuanLy.services.serviceImpls.NVQLQuanLyPhieuXuatServiceImpl;
import cores.nhanVienQuanLy.services.serviceImpls.Tai_LuongHoanXuatServiceImpl;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MsgBox;

/**
 *
 * @author admin
 */
public class Tai_LuongHoanXuat_ListPhieuXuat extends javax.swing.JFrame {

    private NVQLQuanLyPhieuXuatService phieuXuatService;
    private List<PhieuXuatCustom> listPhieuXuat;
    private Tai_LuongHoanXuatService luongHXService;
    private ConcurrentHashMap<UUID, String> map;


    public Tai_LuongHoanXuat_ListPhieuXuat() {
        initComponents();
        phieuXuatService = new NVQLQuanLyPhieuXuatServiceImpl();
        listPhieuXuat = phieuXuatService.getListDaThanhToan();
        luongHXService = new Tai_LuongHoanXuatServiceImpl();
        map = luongHXService.getMapPhx();
        loadTablePhieuXuat(listPhieuXuat);
        clearForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuXuat = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound15 = new utilities.palette.PanelRound();
        btnChon = new utilities.palette.MyButton();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtNgayTao = new utilities.palette.TextField();
        txtMaPhieu = new utilities.palette.TextField();
        textAreaScroll1 = new utilities.palette.TextAreaScroll();
        txtGhiChu = new utilities.palette.TextAreaCustom();
        txtNhanVien = new utilities.palette.TextField();
        txtKhachHang = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        txtNgayThanhToan = new utilities.palette.TextField();
        btnThemPhieuHoanXuat = new utilities.palette.MyButton();
        myButton12 = new utilities.palette.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap(42, Short.MAX_VALUE))
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

        btnChon.setBackground(new java.awt.Color(221, 242, 244));
        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnChon.setToolTipText("Thêm mới phiếu nhập");
        btnChon.setBorderColor(new java.awt.Color(221, 242, 244));
        btnChon.setColor(new java.awt.Color(221, 242, 244));
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
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
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

        txtNhanVien.setEditable(false);
        txtNhanVien.setBackground(new java.awt.Color(228, 206, 224));
        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhanVien.setLabelText("Nhân Viên");

        txtKhachHang.setEditable(false);
        txtKhachHang.setBackground(new java.awt.Color(228, 206, 224));
        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtKhachHang.setLabelText("Khách Hàng");
        txtKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachHangActionPerformed(evt);
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

        btnThemPhieuHoanXuat.setBackground(new java.awt.Color(221, 242, 244));
        btnThemPhieuHoanXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThemPhieuHoanXuat.setToolTipText("Thêm mới phiếu nhập");
        btnThemPhieuHoanXuat.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThemPhieuHoanXuat.setColor(new java.awt.Color(221, 242, 244));
        btnThemPhieuHoanXuat.setRadius(50);
        btnThemPhieuHoanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhieuHoanXuatActionPerformed(evt);
            }
        });

        myButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit.png"))); // NOI18N
        myButton12.setToolTipText("Phiếu nhập chi tiết");
        myButton12.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton12.setColor(new java.awt.Color(221, 242, 244));
        myButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton12.setRadius(50);
        myButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1))
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
                                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnThemPhieuHoanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemPhieuHoanXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(myButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1286, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        txtNhanVien.setText(nhanVien);
        txtKhachHang.setText(khachHang);
        txtGhiChu.setText(listPhieuXuat.get(row).getGhiChu());

    }//GEN-LAST:event_tblPhieuXuatMouseClicked
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
        txtMaPhieu.setText("");
        txtNgayTao.setText("");
        txtNgayThanhToan.setText("");
        txtTrangThai.setText("");
        txtNhanVien.setText("");
        txtKhachHang.setText("");
        txtGhiChu.setText("");
    }
    private void txtMaPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void txtKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachHangActionPerformed
    }//GEN-LAST:event_txtKhachHangActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void btnThemPhieuHoanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhieuHoanXuatActionPerformed
        int row = tblPhieuXuat.getSelectedRow();
        if (row == -1) {
            MsgBox.alert(this, "Bạn phải chọn phiếu xuất mà bạn muốn hoàn");
            return;
        }
        PhieuXuatCustom pxct = this.listPhieuXuat.get(row);
        if(map.containsKey(pxct.getId())) {
            JOptionPane.showMessageDialog(this, "Bạn đã có phiếu hoàn", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        luongHXService.addPhieuHoanXuatTuDong(pxct, "New", "Không muốn lấy nhiều nữa");
        map.put(pxct.getId(), "ghihi");
        MsgBox.alert(this, "Bạn đã thêm phiếu hoàn cho phiếu xuất này thành công !");
        this.dispose();
    }//GEN-LAST:event_btnThemPhieuHoanXuatActionPerformed

    private void myButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton12ActionPerformed
        this.dispose();
    }//GEN-LAST:event_myButton12ActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        
    }//GEN-LAST:event_btnChonActionPerformed

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
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ListPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ListPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ListPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tai_LuongHoanXuat_ListPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tai_LuongHoanXuat_ListPhieuXuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnChon;
    private utilities.palette.MyButton btnThemPhieuHoanXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton12;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.TableDark_1 tblPhieuXuat;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private utilities.palette.TextField txtKhachHang;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.TextField txtNgayThanhToan;
    private utilities.palette.TextField txtNhanVien;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
