/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.admins.views;

import cores.admins.customModels.AdQuanLyLoaiHangCustom;
import cores.admins.services.AdQuanLyLoaiHangService;
import cores.admins.services.serviceImpls.AdQuanLyLoaiHangServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.MaTuSinh;

/**
 *
 * @author admin
 */
public class AdQuanLyLoaiHangForm extends javax.swing.JPanel {

    private AdQuanLyLoaiHangService qllhService;
    private List<AdQuanLyLoaiHangCustom> list = new ArrayList<>();

    public AdQuanLyLoaiHangForm() {
        initComponents();
        qllhService = new AdQuanLyLoaiHangServiceImpl();
        list = qllhService.getList();
        LoadTable();
    }

    public void LoadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblLoaiHang.getModel();
        dtm.setRowCount(0);
        for (AdQuanLyLoaiHangCustom lh : list) {
            Object[] rowData = {
                lh.getMa(),
                lh.getTen(),
                lh.getMoTa(),
                lh.getGia()
            };
            dtm.addRow(rowData);
        }
    }

    private AdQuanLyLoaiHangCustom getFormData() {
        String ma = this.txtMa.getText();
        String ten = this.txtTen.getText();
        String moTa = this.txtMoTa.getText();
        String gia = this.txtGia.getText();
        int index = 0;
        if (ten.trim().length() == 0) {
            index++;
            lblErrTen.setText("Bạn cần phải nhập tên");
        } else {
            lblErrTen.setText("");
            index = 0;
        }
        if (moTa.trim().length() == 0) {
            index++;
            lblErrMoTa.setText("Bạn cần phải nhập mô tả");
        } else {
            lblErrMoTa.setText("");
            index = 0;
        }
        if (gia.trim().length() == 0) {
            index++;
            lblErrGia.setText("Bạn cần phải nhập giá tiên");
        } else {
            lblErrGia.setText("");
            index = 0;
        }
        if (index != 0) {
            return null;
        }
        BigDecimal giaTien = null;
        try {
            giaTien = new BigDecimal(gia);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bạn phải nhập giá tiền là số");
        }
        AdQuanLyLoaiHangCustom lhcm = new AdQuanLyLoaiHangCustom();
        lhcm.setMa(MaTuSinh.gen("LH"));
        lhcm.setTen(ten);
        lhcm.setMoTa(moTa);
        lhcm.setGia(giaTien);
        return lhcm;
    }

    private void clearForm() {
        txtMa.setText("");
        txtTen.setText("");
        txtMoTa.setText("");
        txtGia.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new utilities.palette.TextField();
        txtGia = new utilities.palette.TextField();
        txtMoTa = new utilities.palette.TextField();
        txtTen = new utilities.palette.TextField();
        btnThem = new utilities.palette.UWPButton();
        btnSua = new utilities.palette.UWPButton();
        btnXoa = new utilities.palette.UWPButton();
        lblErrMa = new javax.swing.JLabel();
        lblErrMoTa = new javax.swing.JLabel();
        lblErrTen = new javax.swing.JLabel();
        lblErrGia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiHang = new utilities.palette.TableDark_1();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

        jLabel3.setText("Mô tả");

        jLabel4.setText("Giá");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lblErrMa.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblErrMa.setForeground(new java.awt.Color(255, 0, 51));

        lblErrMoTa.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblErrMoTa.setForeground(new java.awt.Color(255, 0, 51));

        lblErrTen.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblErrTen.setForeground(new java.awt.Color(255, 0, 51));

        lblErrGia.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblErrGia.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblErrMa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblErrTen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErrGia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, 0)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrMa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErrGia, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblErrTen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        tblLoaiHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Mô tả", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiHang.setSelectionBackground(new java.awt.Color(255, 153, 51));
        tblLoaiHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        AdQuanLyLoaiHangCustom lhcm = this.getFormData();
        if (lhcm == null) {
            return;
        }
        list.add(qllhService.InsertLoaiHangById(lhcm));
        LoadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = this.tblLoaiHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng trên table");
            return;
        }
        AdQuanLyLoaiHangCustom lhcm = list.get(row);
        AdQuanLyLoaiHangCustom lh = this.getFormData();
        if (lh == null) {
            return;
        }
        lh.setId(lhcm.getId());
        qllhService.UpdateLoaiHangById(lh);
        list.set(row, lh);
        LoadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tblLoaiHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng trên table");
            return;
        }
        qllhService.DeleteLoaiHangById(list.get(row).getId());
        list.remove(row);
        LoadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblLoaiHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiHangMouseClicked
        int row = this.tblLoaiHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtMa.setText(tblLoaiHang.getValueAt(row, 0).toString());
        txtTen.setText(tblLoaiHang.getValueAt(row, 1).toString());
        txtMoTa.setText(tblLoaiHang.getValueAt(row, 2).toString());
        txtGia.setText(tblLoaiHang.getValueAt(row, 3).toString());

    }//GEN-LAST:event_tblLoaiHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnSua;
    private utilities.palette.UWPButton btnThem;
    private utilities.palette.UWPButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrGia;
    private javax.swing.JLabel lblErrMa;
    private javax.swing.JLabel lblErrMoTa;
    private javax.swing.JLabel lblErrTen;
    private utilities.palette.TableDark_1 tblLoaiHang;
    private utilities.palette.TextField txtGia;
    private utilities.palette.TextField txtMa;
    private utilities.palette.TextField txtMoTa;
    private utilities.palette.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
