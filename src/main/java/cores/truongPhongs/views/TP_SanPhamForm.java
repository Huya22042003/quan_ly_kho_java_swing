/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TP_SanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.services.TP_SanPhamService;
import cores.truongPhongs.services.serviceImpls.TP_SanPhamServiceImpl;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Page;

/**
 *
 * @author asus
 */
public class TP_SanPhamForm extends javax.swing.JPanel {

    private TP_SanPhamService service;
    private List<TpQuanLySanPhamCustom> getList;
    private TP_CreateSanPhamForm createSanPham;
    private TP_RUDSanPhamForm rud;
    private Page p;

    private int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;
    private DecimalFormat formatter = new DecimalFormat("###,###,##0");
//    private TP_ChiTietSanPhamForm ctsp = new TP_ChiTietSanPhamForm();
    public TP_SanPhamForm() {
        service = new TP_SanPhamServiceImpl();
        getList = new ArrayList<>();
        createSanPham = new TP_CreateSanPhamForm();
        rud = new TP_RUDSanPhamForm();
        p = new Page();
        initComponents();
        getList = service.getAll("");
        loadTable(service.phanTrang(getList, offset, limit));
        clearForm();
    }

    public void clearForm() {
//        rdoTen.setSelected(true);
        getList = service.findAllByRadio("", 0);
        sizes = getList.size();
        offset = 0;
        index = 1;
        loadIndex();
    }

    public List<TpQuanLySanPhamCustom> listSearch(int rdo) {
        String timKiem = this.txtSearchTheo.getText();
        getList = service.findAllByRadio(timKiem, rdo);
        return getList;

    }
    
    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTable(service.phanTrang(listSearch(0), offset, limit));
        } else {
            loadTable(service.phanTrang(listSearch(1), offset, limit));
        }
    }

    public void loadTable(List<TpQuanLySanPhamCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tbSanPham.getModel();
        dtm.setRowCount(0);

        for (TpQuanLySanPhamCustom el : list) {
            String giaNhap = "Chưa có";
            if (el.getGiaNhapMin() != null || el.getGiaNhapMax() != null) {
                giaNhap = formatter.format(el.getGiaNhapMin()) + " VNĐ" + " - " + formatter.format(el.getGiaNhapMax()) + " VNĐ";
            }
            String giaBan = "Chưa có";
            if (el.getGiaBanMin() != null && el.getGiaBanMax() != null) {
                giaBan = formatter.format(el.getGiaBanMin()) + " VNĐ" + " - " + formatter.format(el.getGiaBanMax()) + " VNĐ";
            }
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getMa(),
                el.getTen(),
                giaNhap,
                giaBan,
                formatter.format(el.getSoLuong()) + " Đôi"
            };
            dtm.addRow(rowData);
        }
    }

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new utilities.palette.PanelRound();
        panelRound16 = new utilities.palette.PanelRound();
        btnChon = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        btnThem = new utilities.palette.MyButton();
        btnUpdate = new utilities.palette.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new utilities.palette.TableDark_1();
        panelRound4 = new utilities.palette.PanelRound();
        rdoTen = new utilities.palette.RadioButtonCustom();
        rdoMa = new utilities.palette.RadioButtonCustom();
        txtSearchTheo = new javax.swing.JTextField();
        btnSearch = new utilities.palette.MyButton();
        panelRound15 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        btnPre = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        btnNext = new utilities.palette.UWPButton();

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Giá nhập", "Giá bán", "Số lượng"
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

        rdoTen.setBackground(new java.awt.Color(67, 130, 187));
        rdoTen.setForeground(new java.awt.Color(255, 255, 255));
        rdoTen.setText("Tên");
        rdoTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoMa.setBackground(new java.awt.Color(67, 130, 187));
        rdoMa.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa.setText("Mã");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm phiếu nhập");
        btnSearch.setBorderColor(new java.awt.Color(221, 242, 244));
        btnSearch.setColor(new java.awt.Color(221, 242, 244));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setRadius(50);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(txtSearchTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txtSearchTheo))
                .addContainerGap())
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
//        int row = this.tbSanPham.getSelectedRow();
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
//            return;
//        }
//        this.FrameChiTietSanPham.setLocationRelativeTo(null);
//        this.FrameChiTietSanPham.setVisible(true);
//        this.clearFormCtsp();
//        this.loadIndexCtsp();
//        showDataCtsp(serviceChiTietSP.phanTrang(listChiTietSP, offset, limit));
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        getList = service.getAll("");
        loadTable(service.phanTrang(getList, offset, limit));
        clearForm();
        loadIndex();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        createSanPham.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        rud.setVisible(true);
        createSanPham.setVisible(false);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String search = this.txtSearchTheo.getText();
        getList = service.getAll(search);
        loadTable(service.phanTrang(getList, offset, limit));
        loadIndex();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        loadTable(service.phanTrang(getList, offset, limit));
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        loadTable(service.phanTrang(getList, offset, limit));
    }//GEN-LAST:event_btnNextActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int row = tbSanPham.getSelectedRow();
//        rud.showData();
    }//GEN-LAST:event_tbSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnChon;
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.MyButton btnThem;
    private utilities.palette.MyButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound2;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoTen;
    private utilities.palette.TableDark_1 tbSanPham;
    private javax.swing.JLabel txtIndex;
    private javax.swing.JTextField txtSearchTheo;
    // End of variables declaration//GEN-END:variables
}
