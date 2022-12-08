package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TpNhanVienCustom;
import cores.truongPhongs.services.TpQuanLyNhanVienSevice;
import cores.truongPhongs.services.serviceImpls.TpQuanLyNhanVienServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utilities.Converter;
import utilities.Page;

/**
 *
 * @author LENOVO
 */
public class TpQuanLyNhanVien extends javax.swing.JPanel {

    private TpQuanLyNhanVienSevice nhanVienSevice;
    private List<TpNhanVienCustom> getList;
    private TpCreateQuanLyNhanVien create;
    private TpRUDQuanLyNhanVien rud;
    private Page p;

    private int limit = 3;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    public TpQuanLyNhanVien() {
        nhanVienSevice = new TpQuanLyNhanVienServiceImpl();
        getList = new ArrayList<>();
        create = new TpCreateQuanLyNhanVien();
        rud = new TpRUDQuanLyNhanVien();
        p = new Page();
        initComponents();
        getList = nhanVienSevice.getListNhanVien();
        nhanVienSevice.loadComboboxTT(cbbTrangThai);
        clearForm();
        loadTable(nhanVienSevice.phanTrang(getList, offset, limit));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound7 = new utilities.palette.PanelRound();
        btnThem = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNV = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound8 = new utilities.palette.PanelRound();
        btnSearch = new utilities.palette.MyButton();
        cbbTrangThai = new utilities.palette.Combobox();
        panelRound6 = new utilities.palette.PanelRound();
        rdoTen = new utilities.palette.RadioButtonCustom();
        rdoMa = new utilities.palette.RadioButtonCustom();
        rdoDiaChi = new utilities.palette.RadioButtonCustom();
        txtSearchtheo = new utilities.palette.SearchCustom.TextFieldAnimation();
        uWPButton4 = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        uWPButton5 = new utilities.palette.UWPButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        panelRound7.setBackground(new java.awt.Color(67, 130, 187));
        panelRound7.setRoundBottomLeft(50);
        panelRound7.setRoundBottomRight(50);
        panelRound7.setRoundTopLeft(50);
        panelRound7.setRoundTopRight(50);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThem.setToolTipText("Thêm Thông Tin Nhân Viên");
        btnThem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem.setColor(new java.awt.Color(221, 242, 244));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setRadius(50);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Properties.png"))); // NOI18N
        btnHienThi.setToolTipText("Hiển Thị");
        btnHienThi.setBorderColor(new java.awt.Color(221, 242, 244));
        btnHienThi.setColor(new java.awt.Color(221, 242, 244));
        btnHienThi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHienThi.setRadius(50);
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panelRound7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHienThi, btnThem});

        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHienThi, btnThem});

        tblQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Mã", "SĐT", "Email", "Ngày Sinh", "Địa Chỉ", "Trạng Thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLNV);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound8.setBackground(new java.awt.Color(67, 130, 187));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);

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

        cbbTrangThai.setLabeText("Trạng Thái");

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelRound6.setBackground(new java.awt.Color(67, 130, 187));
        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);

        buttonGroup1.add(rdoTen);
        rdoTen.setSelected(true);
        rdoTen.setText("Tên");

        buttonGroup1.add(rdoMa);
        rdoMa.setText("Mã");

        buttonGroup1.add(rdoDiaChi);
        rdoDiaChi.setText("Địa Chỉ");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(rdoDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(txtSearchtheo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchtheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
  public void clearForm() {
        rdoTen.setSelected(true);
        cbbTrangThai.setSelectedIndex(0);
        getList = nhanVienSevice.getListNhanVien();
        sizes = getList.size();
        offset = 0;
        index = 1;
        loadIndex();
    }

    public List<TpNhanVienCustom> listSearch(int rdo) {
        String timKiem = this.txtSearchtheo.getText();
        getList = nhanVienSevice.findAllByRadio(timKiem, nhanVienSevice.loc(cbbTrangThai.getSelectedIndex()), rdo);
        sizes = getList.size();
        return getList;
    }

    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTable(nhanVienSevice.phanTrang(listSearch(0), offset, limit));
        } else if (rdoTen.isSelected()) {
            loadTable(nhanVienSevice.phanTrang(listSearch(1), offset, limit));
        } else {
            loadTable(nhanVienSevice.phanTrang(listSearch(2), offset, limit));
        }
        loadIndex();
    }

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    public void loadTable(List<TpNhanVienCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblQLNV.getModel();
        dtm.setRowCount(0);
        for (TpNhanVienCustom nv : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                nv.getTen(),
                nv.getMa(),
                nv.getSdt(),
                nv.getEmail(),
                //                nv.getMatKhau(),
                nv.getNgaySinh() == null ? "" : new Date(nv.getNgaySinh()),
                //                nv.getHinhAnh(),
                //                Converter.trangThaiGioiTinh(nv.getGioiTinh()),
                nv.getDiaChi(),
                Converter.trangThaiNhanVien(nv.getTrangThai())
            };
            dtm.addRow(rowData);
        }
    }
    private void tblQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVMouseClicked

        int row = this.tblQLNV.getSelectedRow();
        create.setVisible(false);
        rud.custom = nhanVienSevice.finNhanVienByMa(tblQLNV.getValueAt(row, 2).toString());
        rud.setVisible(true);
        rud.showData();
    }//GEN-LAST:event_tblQLNVMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        create.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
//        getList = nhanVienSevice.getListNhanVien();
        clearForm();
        loadTable(nhanVienSevice.phanTrang(getList, offset, limit));

    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        searchRadio();

    }//GEN-LAST:event_btnSearchActionPerformed

    private void uWPButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton4ActionPerformed
//        getList = nhanVienSevice.getListNhanVien();
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        loadTable(nhanVienSevice.phanTrang(getList, offset, limit));
    }//GEN-LAST:event_uWPButton4ActionPerformed

    private void uWPButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton5ActionPerformed
//        getList = nhanVienSevice.getListNhanVien();
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        loadTable(nhanVienSevice.phanTrang(getList, offset, limit));
    }//GEN-LAST:event_uWPButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.MyButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private utilities.palette.Combobox cbbTrangThai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.PanelRound panelRound6;
    private utilities.palette.PanelRound panelRound7;
    private utilities.palette.PanelRound panelRound8;
    private utilities.palette.RadioButtonCustom rdoDiaChi;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoTen;
    private utilities.palette.TableDark_1 tblQLNV;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearchtheo;
    private utilities.palette.UWPButton uWPButton4;
    private utilities.palette.UWPButton uWPButton5;
    // End of variables declaration//GEN-END:variables
}
