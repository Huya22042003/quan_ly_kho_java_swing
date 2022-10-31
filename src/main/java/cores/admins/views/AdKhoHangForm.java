/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.admins.views;

import cores.admins.customModels.AdGetTenCoSoCustom;
import cores.admins.customModels.AdKhoHangCustom;
import cores.admins.services.AdCoSoService;
import cores.admins.services.AdKhoHangService;
import cores.admins.services.serviceImpls.AdCoSoServiceImpl;
import cores.admins.services.serviceImpls.AdKhoHangServiceImpl;
import infrastructures.constant.KhoHangConstant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.MaTuSinh;
import views.main.Admin;

/**
 *
 * @author Acer
 */
public class AdKhoHangForm extends javax.swing.JPanel {

    private AdKhoHangService qlkh = new AdKhoHangServiceImpl();
    private AdCoSoService qlcs = new AdCoSoServiceImpl();
    private List<AdGetTenCoSoCustom> listCS = new ArrayList<>();
    private List<AdKhoHangCustom> listKH = new ArrayList<>();

    public AdKhoHangForm() {
        initComponents();
        listKH = qlkh.getListKhoHang();
        listCS = qlcs.getCbbCoSo();
        this.loadTable();
        this.loadCbbCS();
        this.loadCbbTT();
    }

    private void loadCbbCS() {
        for (AdGetTenCoSoCustom adGetTenCoSoCustom : listCS) {
            this.cbbCoSo.addItem(adGetTenCoSoCustom.getTen());
        }

    }

    private void loadCbbTT() {

        this.cbbTrangThai.addItem(Converter.trangThaiKhoHang(KhoHangConstant.DANG_HOAT_DONG));
        this.cbbTrangThai.addItem(Converter.trangThaiKhoHang(KhoHangConstant.SAP_HOAT_DONG));
        this.cbbTrangThai.addItem(Converter.trangThaiKhoHang(KhoHangConstant.DA_DONG_CUA));
        this.cbbTrangThai.addItem(Converter.trangThaiKhoHang(KhoHangConstant.TAM_NGHI));
    }

    private AdKhoHangCustom getFormData() {
        String ma = MaTuSinh.gen("KH");
        String ten = this.txtTen.getText();
        int cs = this.cbbCoSo.getSelectedIndex();
        String tt = this.cbbTrangThai.getSelectedItem().toString();
        AdKhoHangCustom kh = qlkh.checkValidate(lblErrTen, ten, ma, tt, listCS.get(cs).getId());
        return kh;
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblKH.getModel();
        dtm.setRowCount(0);
        for (AdKhoHangCustom adKhoHangCustom : listKH) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                adKhoHangCustom.getMa(),
                adKhoHangCustom.getTen(),
                Converter.trangThaiKhoHang(adKhoHangCustom.getTrangThai()),
                adKhoHangCustom.getTenCoSo()
            };
            dtm.addRow(rowData);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new utilities.palette.UWPButton();
        btnSua = new utilities.palette.UWPButton();
        btnXoaForm = new utilities.palette.UWPButton();
        btnXoa = new utilities.palette.UWPButton();
        cbbTrangThai = new utilities.palette.Combobox();
        cbbCoSo = new utilities.palette.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new utilities.palette.TableDark_1();
        txtTen = new utilities.palette.TextField();
        txtMa = new utilities.palette.TextField();
        lblErrTen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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

        btnXoaForm.setText("Xóa Form");
        btnXoaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cbbTrangThai.setLabeText("Trạng thái");

        cbbCoSo.setLabeText("Cơ sở");

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã kho hàng", "Tên kho hàng", "Trạng thái", "Cơ sở"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKH);

        txtTen.setLabelText("Tên kho hàng");

        txtMa.setEditable(false);
        txtMa.setToolTipText("");
        txtMa.setLabelText("Mã kho hàng");

        lblErrTen.setBackground(new java.awt.Color(255, 255, 255));
        lblErrTen.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnXoaForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblErrTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbCoSo, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbCoSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(lblErrTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearForm() {
        this.txtMa.setText("");
        this.txtTen.setText("");
        this.cbbCoSo.setSelectedIndex(0);
        this.cbbTrangThai.setSelectedIndex(0);
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        AdKhoHangCustom kh = this.getFormData();
        if (kh == null) {
            return;
        }
        listKH.add(qlkh.saveKhoHang(kh));

        this.loadTable();
        this.clearForm();

        JOptionPane.showMessageDialog(this, "Thêm thành công!");

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
        int row = this.tblKH.getSelectedRow();
        if (row == -1) {
            return;
        }
        this.txtMa.setText(tblKH.getValueAt(row, 1).toString());
        this.txtTen.setText(tblKH.getValueAt(row, 2).toString());
        this.cbbCoSo.setSelectedItem(tblKH.getValueAt(row, 4).toString());
        this.cbbTrangThai.setSelectedItem(tblKH.getValueAt(row, 3).toString());


    }//GEN-LAST:event_tblKHMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = this.tblKH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một kho hàng!");
            return;
        }
        AdKhoHangCustom kh = this.getFormData();
        AdKhoHangCustom kh1 = listKH.get(row);
        kh.setId(kh1.getId());
        kh.setMa(kh1.getMa());
        qlkh.updateKhoHang(kh);
        listKH.set(row, kh);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Sửa thành công!");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
         int row = this.tblKH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một kho hàng!");
            return;
        }
        qlkh.deleteKhoHangById(listKH.get(row).getId());
        listKH.remove(row);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnXoaFormActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnSua;
    private utilities.palette.UWPButton btnThem;
    private utilities.palette.UWPButton btnXoa;
    private utilities.palette.UWPButton btnXoaForm;
    private utilities.palette.Combobox cbbCoSo;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrTen;
    private utilities.palette.TableDark_1 tblKH;
    private utilities.palette.TextField txtMa;
    private utilities.palette.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
