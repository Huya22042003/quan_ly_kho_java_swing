package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLyDonViCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.services.TpQuanLyChiTietSanPhamService;
import cores.truongPhongs.services.serviceImpls.TpQuanLyChiTietSanPhamServiceImpl;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import utilities.Converter;
import utilities.MsgBox;

/**
 *
 * @author MMC
 */
public class TpQuanLyChiTietSanPhamU extends javax.swing.JFrame {

    private TpQuanLyChiTietSanPhamService serviceChiTietSP = new TpQuanLyChiTietSanPhamServiceImpl();
    TpQuanLyChiTietSanPhamCustom ct = new TpQuanLyChiTietSanPhamCustom();
    private List<TpQuanLyChiTietSanPhamCustom> listCTSP = new ArrayList<>();
    private List<TpQuanLyDonViCustom> listDonVi = new ArrayList<>();
    private List<TpQuanLySanPhamCustom> listSanPham = new ArrayList<>();
    String duongdananh = getClass().getResource("/icons/FPT_Polytechnic_doc.png").getPath();

    public TpQuanLyChiTietSanPhamU() {
        initComponents();
        loadList();
        loadCBB();
        serviceChiTietSP.loadCombobox(cbbMauSac);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public void showData() {
        this.txtGiaNhap.setText(String.valueOf(ct.getGiaNhap()));
        this.txtGiaBan.setText(String.valueOf(ct.getGiaBan()));
        this.txtSoLuongTon.setText(String.valueOf(ct.getSoLuongTon()));
        this.txtNamBH.setText(String.valueOf(ct.getNamBaoHanh()));
        this.lblHinhAnh.setIcon(new javax.swing.ImageIcon(ct.getHinhAnh()));
        this.cbbMauSac.setSelectedItem(Converter.trangThaiMauSac(ct.getMau()));
        cbbDonVi.setSelectedItem(ct.getDonVi().getDonViGoc());
        cbbSanPham.setSelectedItem(ct.getSanPham().getTen());

    }

    public TpQuanLyChiTietSanPhamCustom getFormData() {
        TpQuanLyChiTietSanPhamCustom sp = serviceChiTietSP.checkValidate(serviceChiTietSP.getAllDonVi().get(cbbDonVi.getSelectedIndex()).getId(),
                txtNamBH.getText(),
                serviceChiTietSP.getAllSanPham().get(cbbSanPham.getSelectedIndex()).getId(),
                lblHinhAnh.getText(), txtGiaNhap.getText(), txtGiaBan.getText(), txtSoLuongTon.getText(),
                erroHinhAnh, erroGiaNhap, erroGiaBan, erroNamBH, erroSoLuongTon, serviceChiTietSP.loc(this.cbbMauSac.getSelectedIndex()));

        return sp;
    }

    public void loadList() {
        listDonVi = serviceChiTietSP.getAllDonVi();
        listSanPham = serviceChiTietSP.getAllSanPham();
    }

    public void loadCBB() {
        cbbDonVi.removeAllItems();
        cbbSanPham.removeAllItems();

        for (TpQuanLyDonViCustom dv : listDonVi) {
            cbbDonVi.addItem(dv.getDonViGoc());
        }

        for (TpQuanLySanPhamCustom sp : listSanPham) {
            cbbSanPham.addItem(sp.getTen());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new utilities.palette.PanelRound();
        panelRound3 = new utilities.palette.PanelRound();
        test1 = new javax.swing.JLabel();
        btnUpdate = new utilities.palette.UWPButton();
        panelRound1 = new utilities.palette.PanelRound();
        txtGiaNhap = new utilities.palette.TextField();
        erroGiaNhap = new javax.swing.JLabel();
        txtGiaBan = new utilities.palette.TextField();
        erroGiaBan = new javax.swing.JLabel();
        txtSoLuongTon = new utilities.palette.TextField();
        erroSoLuongTon = new javax.swing.JLabel();
        cbbDonVi = new utilities.palette.Combobox();
        txtNamBH = new utilities.palette.TextField();
        erroNamBH = new javax.swing.JLabel();
        cbbSanPham = new utilities.palette.Combobox();
        cbbMauSac = new utilities.palette.Combobox();
        lblHinhAnh = new utilities.palette.lable();
        erroHinhAnh = new javax.swing.JLabel();
        uWPButton1 = new utilities.palette.UWPButton();
        btnDelete = new utilities.palette.UWPButton();
        btnClose = new utilities.palette.UWPButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound2.setBackground(new java.awt.Color(221, 242, 244));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        panelRound3.setBackground(new java.awt.Color(51, 153, 255));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        test1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FPT_Polytechnic_doc.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(test1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        btnUpdate.setBackground(new java.awt.Color(255, 153, 102));
        btnUpdate.setText("UpDate");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        txtGiaNhap.setLabelText("Giá Nhập");

        erroGiaNhap.setForeground(new java.awt.Color(255, 51, 51));

        txtGiaBan.setLabelText("Giá Bán ");

        erroGiaBan.setForeground(new java.awt.Color(255, 51, 51));

        txtSoLuongTon.setLabelText("Số Lượng Tồn");

        erroSoLuongTon.setForeground(new java.awt.Color(255, 51, 51));

        cbbDonVi.setLabeText("Chọn Đơn Vị");

        txtNamBH.setLabelText("Năm Bảo Hành");

        erroNamBH.setForeground(new java.awt.Color(255, 51, 51));

        cbbSanPham.setLabeText("Chọn Sản Phẩm");

        cbbMauSac.setLabeText("Chọn Màu Sắc");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroNamBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroSoLuongTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erroGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbDonVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cbbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(cbbDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        erroHinhAnh.setForeground(new java.awt.Color(255, 51, 51));

        uWPButton1.setBackground(new java.awt.Color(255, 51, 51));
        uWPButton1.setText("X");
        uWPButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton1ActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 153, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(erroHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound2Layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(629, 629, 629)
                        .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erroHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uWPButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_uWPButton1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        TpQuanLyChiTietSanPhamCustom check = getFormData();
        if (check == null) {
            return;
        }

//        TpQuanLyChiTietSanPhamCustom sp = 
//                new TpQuanLyChiTietSanPhamCustom(
//                        ct.getId()
//                , check.getSoLuongTon()
//                , check.getHinhAnh()
//                , check.getGiaBan()
//                , check.getGiaNhap()
//                , check.getNamBaoHanh()
//                , check.getMau()
//                , check.getSanPham()
//                , check.getDonVi());
        
          TpQuanLyChiTietSanPhamCustom sp = 
                new TpQuanLyChiTietSanPhamCustom(ct.getId(), check.getSoLuongTon()
                        , check.getHinhAnh()
                        , check.getGiaBan()
                        , check.getGiaBan()
                        , check.getMau()
                        , check.getSanPham()
                        , check.getDonVi()
                        , check.getNamBaoHanh()
                        , TrangThaiSanPhamConstanst.DA_MO_BAN);
        
        if (serviceChiTietSP.updateCTSanPham(sp)) {
            MsgBox.alert(this, "Sửa thành công");
            this.setVisible(false);

        } else {
            MsgBox.alert(this, "Sửa thất bại");
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        try {
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Mở file");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            duongdananh = ftenanh.getAbsolutePath();

            lblHinhAnh.setIcon(new javax.swing.ImageIcon(duongdananh));
            System.out.println(duongdananh);

        } catch (Exception e) {
            System.out.println("Ban chua chon anh");
            System.out.println(duongdananh);
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (serviceChiTietSP.deleteCTSanPham(ct.getId())) {
            MsgBox.alert(this, "Xóa thành công");
            this.setVisible(false);
        } else {
            MsgBox.alert(this, "Xóa thất bại");
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(TpQuanLyChiTietSanPhamU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TpQuanLyChiTietSanPhamU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TpQuanLyChiTietSanPhamU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TpQuanLyChiTietSanPhamU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TpQuanLyChiTietSanPhamU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnClose;
    private utilities.palette.UWPButton btnDelete;
    private utilities.palette.UWPButton btnUpdate;
    private utilities.palette.Combobox cbbDonVi;
    private utilities.palette.Combobox cbbMauSac;
    private utilities.palette.Combobox cbbSanPham;
    private javax.swing.JLabel erroGiaBan;
    private javax.swing.JLabel erroGiaNhap;
    private javax.swing.JLabel erroHinhAnh;
    private javax.swing.JLabel erroNamBH;
    private javax.swing.JLabel erroSoLuongTon;
    private utilities.palette.lable lblHinhAnh;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound2;
    private utilities.palette.PanelRound panelRound3;
    private javax.swing.JLabel test1;
    private utilities.palette.TextField txtGiaBan;
    private utilities.palette.TextField txtGiaNhap;
    private utilities.palette.TextField txtNamBH;
    private utilities.palette.TextField txtSoLuongTon;
    private utilities.palette.UWPButton uWPButton1;
    // End of variables declaration//GEN-END:variables
}
