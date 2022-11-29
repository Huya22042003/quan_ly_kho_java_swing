package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TP_PhieuHoanNhapCustom;
import cores.truongPhongs.services.TP_PhieuHoanNhapService;
import cores.truongPhongs.services.serviceImpls.TP_PhieuHoanNhapServiceImpl;
import infrastructures.constant.TrangThaiPhieuHoanConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.DateTimeUtil;
import utilities.MsgBox;

/**
 *
 * @author QUOC HUY
 */
public class TP_QuanLyPhieuHoanNhap extends javax.swing.JPanel {

    private TP_PhieuHoanNhapService phieuHoanNhapService;
    private List<TP_PhieuHoanNhapCustom> hoanNhapCustoms;
    private TP_QuanLyPhieuHoanNhap_pn tn;
    private TP_QuanLyPhieuHoanNhap_sp hoanNhap_sp;
    private TP_QuanLyPhieuHoanNhap_ctp ctp;

    public TP_QuanLyPhieuHoanNhap() {
        phieuHoanNhapService = new TP_PhieuHoanNhapServiceImpl();
        tn = new TP_QuanLyPhieuHoanNhap_pn();
        hoanNhapCustoms = new ArrayList<>();
        initComponents();
        hoanNhapCustoms = phieuHoanNhapService.getListPhieuHoanNhap();
        clearForm();
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblPhieuHoanNhap.getModel();
        dtm.setRowCount(0);
        for (TP_PhieuHoanNhapCustom el : hoanNhapCustoms) {
            Date ngayTao = new Date(el.getNgayTao());
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getId(),
                ngayTao,
                el.getNgayThanhToan() == null ? "Chưa thanh toán" : new Date(el.getNgayThanhToan()).toString(),
                el.getPhieuNhap().getNhaCungCap().getTen(),
                el.getPhieuNhap().getNhanVien().getTen(),
                Converter.TrangThaiPhieuHoan(el.getTrangThai())
            };
            dtm.addRow(rowData);
        }
    }

    private void clearForm() {
        txtMaPhieu.setText("");
        txtGhiChu.setText("");
        txtLiDo.setText("");
        txtNgayTao.setText("");
        txtNgayThanhToan.setText("");
        txtTrangThai.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuHoanNhap = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        panelRound15 = new utilities.palette.PanelRound();
        myButton9 = new utilities.palette.MyButton();
        myButton5 = new utilities.palette.MyButton();
        myButton11 = new utilities.palette.MyButton();
        myButton14 = new utilities.palette.MyButton();
        panelRound2 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtMaPhieu = new utilities.palette.TextField();
        txtNgayTao = new utilities.palette.TextField();
        txtTrangThai = new utilities.palette.TextField();
        textAreaScroll1 = new utilities.palette.TextAreaScroll();
        txtGhiChu = new utilities.palette.TextAreaCustom();
        panelRound16 = new utilities.palette.PanelRound();
        btnXacNhan = new utilities.palette.MyButton();
        textAreaScroll2 = new utilities.palette.TextAreaScroll();
        txtLiDo = new utilities.palette.TextAreaCustom();
        txtNgayThanhToan = new utilities.palette.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tblPhieuHoanNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu", "Ngày tạo", "Ngày thanh toán", "Nhà cung cấp", "Nhân viên", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuHoanNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuHoanNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuHoanNhap);
        if (tblPhieuHoanNhap.getColumnModel().getColumnCount() > 0) {
            tblPhieuHoanNhap.getColumnModel().getColumn(3).setHeaderValue("Ngày thanh toán");
        }

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DANH SÁCH PHIẾU HOÀN - NHẬP");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        myButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        myButton9.setToolTipText("Danh sách những sản phẩm hoàn");
        myButton9.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton9.setColor(new java.awt.Color(221, 242, 244));
        myButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton9.setRadius(50);
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });

        myButton5.setBackground(new java.awt.Color(221, 242, 244));
        myButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        myButton5.setToolTipText("Thêm phiếu hoàn");
        myButton5.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton5.setColor(new java.awt.Color(221, 242, 244));
        myButton5.setRadius(50);
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        myButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-to-basket.png"))); // NOI18N
        myButton11.setToolTipText("Chọn sản phẩm hoàn");
        myButton11.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton11.setColor(new java.awt.Color(221, 242, 244));
        myButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton11.setRadius(50);
        myButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton11ActionPerformed(evt);
            }
        });

        myButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Show.png"))); // NOI18N
        myButton14.setToolTipText("Hiển thị");
        myButton14.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton14.setColor(new java.awt.Color(221, 242, 244));
        myButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton14.setRadius(50);
        myButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(myButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                            .addComponent(panelRound15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        panelRound2.setBackground(new java.awt.Color(228, 206, 224));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin phiếu nhập");

        txtMaPhieu.setEditable(false);
        txtMaPhieu.setBackground(new java.awt.Color(228, 206, 224));
        txtMaPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaPhieu.setLabelText("Mã phiếu ");
        txtMaPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuActionPerformed(evt);
            }
        });

        txtNgayTao.setEditable(false);
        txtNgayTao.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayTao.setLabelText("Ngày tạo");

        txtTrangThai.setEditable(false);
        txtTrangThai.setBackground(new java.awt.Color(228, 206, 224));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTrangThai.setLabelText("Trạng thái");
        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
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

        panelRound16.setBackground(new java.awt.Color(67, 130, 187));
        panelRound16.setRoundBottomLeft(50);
        panelRound16.setRoundBottomRight(50);
        panelRound16.setRoundTopLeft(50);
        panelRound16.setRoundTopRight(50);

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Upload.png"))); // NOI18N
        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.setToolTipText("Phiếu nhập chi tiết");
        btnXacNhan.setBorderColor(new java.awt.Color(221, 242, 244));
        btnXacNhan.setColor(new java.awt.Color(221, 242, 244));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.setRadius(50);
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound16Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        textAreaScroll2.setBackground(new java.awt.Color(153, 204, 255));
        textAreaScroll2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textAreaScroll2.setLabelText("Lý do");

        txtLiDo.setEditable(false);
        txtLiDo.setBackground(new java.awt.Color(228, 206, 224));
        txtLiDo.setColumns(20);
        txtLiDo.setRows(5);
        txtLiDo.setWrapStyleWord(false);
        txtLiDo.setDisabledTextColor(new java.awt.Color(204, 204, 255));
        textAreaScroll2.setViewportView(txtLiDo);

        txtNgayThanhToan.setEditable(false);
        txtNgayThanhToan.setBackground(new java.awt.Color(228, 206, 224));
        txtNgayThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayThanhToan.setLabelText("Ngày thanh toán");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(textAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(panelRound16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        int row = this.tblPhieuHoanNhap.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tn.setVisible(false);
        if (hoanNhap_sp != null) {
            hoanNhap_sp.setVisible(false);
        }
        ctp = new TP_QuanLyPhieuHoanNhap_ctp(this.hoanNhapCustoms.get(row));
        ctp.setVisible(true);
    }//GEN-LAST:event_myButton9ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        if (ctp != null && hoanNhap_sp != null) {
            ctp.setVisible(false);
            hoanNhap_sp.setVisible(false);
        }
        tn.setVisible(true);
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton11ActionPerformed
        int row = this.tblPhieuHoanNhap.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(ctp != null && tn != null) {
            tn.setVisible(false);
            ctp.setVisible(false);
        }
        hoanNhap_sp = new TP_QuanLyPhieuHoanNhap_sp(this.hoanNhapCustoms.get(row));
        hoanNhap_sp.setVisible(true);
    }//GEN-LAST:event_myButton11ActionPerformed

    private void txtMaPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int row =this.tblPhieuHoanNhap.getSelectedRow();
        if (row == -1) {
            return;
        }
        TP_PhieuHoanNhapCustom phn = this.hoanNhapCustoms.get(row);
        phn.setTrangThai(TrangThaiPhieuHoanConstant.HOAN_THANH_CONG);
        phn.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        phieuHoanNhapService.updatePhieuHoanNhap(phn);
        MsgBox.alert(this, "Bạn đã xác nhận thành công !");
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void tblPhieuHoanNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuHoanNhapMouseClicked
        int row = this.tblPhieuHoanNhap.getSelectedRow();
        if (row == -1) {
            return;
        }

        TP_PhieuHoanNhapCustom item = this.hoanNhapCustoms.get(row);
        txtMaPhieu.setText(item.getId().toString());
        txtGhiChu.setText(item.getGhiChu());
        txtLiDo.setText(item.getLiDo());
        txtNgayTao.setText(new Date(item.getNgayTao()).toString());
        txtNgayThanhToan.setText(item.getNgayThanhToan() == null ? "Chưa thanh toán" : new Date(item.getNgayThanhToan()).toString());
        txtTrangThai.setText(Converter.TrangThaiPhieuHoan(item.getTrangThai()));
        if (txtTrangThai.getText().equalsIgnoreCase("Hoàn Thành Công")) {
            btnXacNhan.setEnabled(false);
        }else{
            btnXacNhan.setEnabled(true);
        }
    }//GEN-LAST:event_tblPhieuHoanNhapMouseClicked

    private void myButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton14ActionPerformed
        hoanNhapCustoms = phieuHoanNhapService.getListPhieuHoanNhap();
        loadTable();
    }//GEN-LAST:event_myButton14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton11;
    private utilities.palette.MyButton myButton14;
    private utilities.palette.MyButton myButton5;
    private utilities.palette.MyButton myButton9;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound2;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.TableDark_1 tblPhieuHoanNhap;
    private utilities.palette.TextAreaScroll textAreaScroll1;
    private utilities.palette.TextAreaScroll textAreaScroll2;
    private utilities.palette.TextAreaCustom txtGhiChu;
    private utilities.palette.TextAreaCustom txtLiDo;
    private utilities.palette.TextField txtMaPhieu;
    private utilities.palette.TextField txtNgayTao;
    private utilities.palette.TextField txtNgayThanhToan;
    private utilities.palette.TextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
