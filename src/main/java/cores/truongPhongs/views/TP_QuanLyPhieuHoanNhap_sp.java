package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TP_HoanNhap_spCustom;
import cores.truongPhongs.customModels.TP_PhieuHoanNhapCustom;
import cores.truongPhongs.services.TP_PhieuHoanNhapService;
import cores.truongPhongs.services.serviceImpls.TP_PhieuHoanNhapServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;

/**
 *
 * @author QUOC HUY
 */
public class TP_QuanLyPhieuHoanNhap_sp extends javax.swing.JFrame {

    private TP_PhieuHoanNhapService hoanNhapService;
    private List<TP_HoanNhap_spCustom> listSP;
    private TP_PhieuHoanNhapCustom idPhieuHoanNhap;
    private String duongDan = getClass().getResource("/icons/file.png").getPath();

    public TP_QuanLyPhieuHoanNhap_sp(TP_PhieuHoanNhapCustom idPhieuNhap) {
        this.idPhieuHoanNhap = idPhieuNhap;
        hoanNhapService = new TP_PhieuHoanNhapServiceImpl();
        listSP = new ArrayList<>();
        initComponents();
        listSP = hoanNhapService.getListSpByPhieuNhap(idPhieuHoanNhap.getPhieuNhap().getId());
        this.btnAnh.setIcon(new ImageIcon(duongDan));
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (TP_HoanNhap_spCustom el : listSP) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getSanPham().getMa(),
                el.getSanPham().getTen(),
                el.getMau(),
                el.getSoLuongTon(),
                el.getGiaNhap()
            };
            dtm.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new utilities.palette.TableDark_1();
        panelRound2 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new utilities.palette.TextField();
        txtTenSp = new utilities.palette.TextField();
        txtSoLuongNhap = new utilities.palette.TextField();
        panelRound16 = new utilities.palette.PanelRound();
        myButton12 = new utilities.palette.MyButton();
        myButton6 = new utilities.palette.MyButton();
        txtMau = new utilities.palette.TextField();
        txtSoLuongHoan = new utilities.palette.TextField();
        txtGiaNhap = new utilities.palette.TextField();
        errorSoLuong = new javax.swing.JLabel();
        panelRound3 = new utilities.palette.PanelRound();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        panelRound4 = new utilities.palette.PanelRound();
        btnAnh = new utilities.palette.UWPButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopRight(50);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Màu sắc", "Số lượng", "Giá nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(228, 206, 224));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin sản phẩm");

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

        txtSoLuongNhap.setEditable(false);
        txtSoLuongNhap.setBackground(new java.awt.Color(228, 206, 224));
        txtSoLuongNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongNhap.setLabelText("Số lượng nhập");
        txtSoLuongNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongNhapActionPerformed(evt);
            }
        });

        panelRound16.setBackground(new java.awt.Color(67, 130, 187));
        panelRound16.setRoundBottomLeft(50);
        panelRound16.setRoundBottomRight(50);
        panelRound16.setRoundTopLeft(50);
        panelRound16.setRoundTopRight(50);

        myButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Closed door.png"))); // NOI18N
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

        myButton6.setBackground(new java.awt.Color(221, 242, 244));
        myButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        myButton6.setToolTipText("Thêm mới phiếu nhập");
        myButton6.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton6.setColor(new java.awt.Color(221, 242, 244));
        myButton6.setRadius(50);
        myButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(myButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtMau.setEditable(false);
        txtMau.setBackground(new java.awt.Color(228, 206, 224));
        txtMau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMau.setLabelText("Màu sắc");

        txtSoLuongHoan.setBackground(new java.awt.Color(228, 206, 224));
        txtSoLuongHoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongHoan.setLabelText("Số lượng hoàn");
        txtSoLuongHoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongHoanActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenSp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtSoLuongHoan, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(30, 30, 30)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSoLuongHoan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(panelRound16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        panelRound3.setBackground(new java.awt.Color(221, 242, 244));
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DANH SÁCH SẢN PHẨM TRONG PHIẾU NHẬP");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(16, 16, 16))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = this.tblSanPham.getSelectedRow();
        if (row == -1) {
            return;
        }

        TP_HoanNhap_spCustom item = this.listSP.get(row);
        txtMa.setText(item.getSanPham().getMa());
        txtTenSp.setText(item.getSanPham().getTen());
        txtMau.setText(Converter.trangThaiMauSac(item.getMau()));
        txtSoLuongNhap.setText(String.valueOf(item.getSoLuongTon()));
        if (item.getHinhAnh() == null) {
            this.btnAnh.setIcon(new ImageIcon(duongDan));
        } else {
            btnAnh.setIcon(new ImageIcon(item.getHinhAnh()));
        }
        txtGiaNhap.setText(item.getGiaNhap().toString());
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtSoLuongNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongNhapActionPerformed

    private void myButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton12ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_myButton12ActionPerformed

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        String soLuong = this.txtSoLuongHoan.getText();
        int row = this.tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int sl = 0;
        try {
            sl = Integer.parseInt(soLuong);
            if (sl <= 0) {
                this.errorSoLuong.setText("Số lượng phải là số nguyên dương");
                return;
            }
            if (listSP.get(this.tblSanPham.getSelectedRow()).getSoLuongTon() < sl) {
                this.errorSoLuong.setText("Số lượng nhập phải nhỏ hơn số lượng tồn");
                return;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.errorSoLuong.setText("Số lượng phải nhập đúng định dạng số");
            return;
        }
        
        if (hoanNhapService.addSanPhamInPhieuHoan(listSP.get(row).getId(), idPhieuHoanNhap.getId(), sl)) {
            System.out.println(sl);
            JOptionPane.showMessageDialog(this, "Thêm thành công", "Thành CÔng !!!", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_myButton6ActionPerformed

    private void txtSoLuongHoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongHoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongHoanActionPerformed

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

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
            java.util.logging.Logger.getLogger(TP_QuanLyPhieuHoanNhap_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TP_QuanLyPhieuHoanNhap_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TP_QuanLyPhieuHoanNhap_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TP_QuanLyPhieuHoanNhap_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TP_QuanLyPhieuHoanNhap_sp(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.UWPButton btnAnh;
    private javax.swing.JLabel errorSoLuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton12;
    private utilities.palette.MyButton myButton6;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound2;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.TableDark_1 tblSanPham;
    private utilities.palette.TextField txtGiaNhap;
    private utilities.palette.TextField txtMa;
    private utilities.palette.TextField txtMau;
    private utilities.palette.TextField txtSoLuongHoan;
    private utilities.palette.TextField txtSoLuongNhap;
    private utilities.palette.TextField txtTenSp;
    // End of variables declaration//GEN-END:variables
}
