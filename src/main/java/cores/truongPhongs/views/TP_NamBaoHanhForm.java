package cores.truongPhongs.views;

import cores.truongPhongs.customModels.TP_NamBaoHanhCustom;
import cores.truongPhongs.services.TP_NamBaoHanhService;
import cores.truongPhongs.services.serviceImpls.TP_NamBaoHanhServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utilities.Page;

public class TP_NamBaoHanhForm extends javax.swing.JPanel {

    private TP_NamBaoHanhService baoHanhService;

    private List<TP_NamBaoHanhCustom> getList;

    private TP_CreateNamBaoHangForm createView;

    private TP_RUDNamBaoHangForm rud;
    //
    private Page p;

    private int limit = 7;

    private int offset = 0;

    private int sizes = 0;

    private int index = 1;

    public TP_NamBaoHanhForm() {
        baoHanhService = new TP_NamBaoHanhServiceImpl();
        getList = new ArrayList<>();
        createView = new TP_CreateNamBaoHangForm();
        rud = new TP_RUDNamBaoHangForm();
        //
        p = new Page();
        initComponents();
        getList = baoHanhService.getListNBH();
        loadTable(getList);
        clearForm();
    }

    public void clearForm() {
        rdoTen.setSelected(true);
        getList = baoHanhService.findAllByRadio("", 0);
        sizes = getList.size();
        offset = 0;
        index = 1;
        loadIndex();
    }

    public List<TP_NamBaoHanhCustom> listSearch(int rdo) {
        String timKiem = this.txtSearchTheo1.getText();
        getList = baoHanhService.findAllByRadio(timKiem, rdo);
        return getList;

    }

    public void searchRadio() {
        if (rdoMa.isSelected()) {
            loadTable(listSearch(0));
        } else {
            loadTable(listSearch(1));
        }
    }

    public void loadTable(List<TP_NamBaoHanhCustom> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tableAll.getModel();
        dtm.setRowCount(0);
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                return;
            }
            TP_NamBaoHanhCustom el = list.get(i);
//        for (TP_NamBaoHanhCustom el : list) {
            Object[] rowData = {
                dtm.getRowCount() + 1,
                el.getMa(),
                el.getTen()
            };
            dtm.addRow(rowData);
        }
    }

    public void fillData(int i) {
        TP_NamBaoHanhCustom ql = getList.get(i);
        txtMaNBH.setText(ql.getMa());
        txtTenNBH.setText(ql.getTen());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelRound1 = new utilities.palette.PanelRound();
        panelRound5 = new utilities.palette.PanelRound();
        rdoTen = new utilities.palette.RadioButtonCustom();
        txtSearchTheo1 = new utilities.palette.SearchCustom.TextFieldAnimation();
        rdoMa = new utilities.palette.RadioButtonCustom();
        panelRound15 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound16 = new utilities.palette.PanelRound();
        btnSearch = new utilities.palette.MyButton();
        btnThem = new utilities.palette.MyButton();
        btnHienThi = new utilities.palette.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAll = new utilities.palette.TableDark_1();
        btnPre = new utilities.palette.UWPButton();
        txtIndex = new javax.swing.JLabel();
        btnNext = new utilities.palette.UWPButton();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtTenNBH = new utilities.palette.TextField();
        txtMaNBH = new utilities.palette.TextField();
        myButton7 = new utilities.palette.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        rdoTen.setBackground(new java.awt.Color(67, 130, 187));
        rdoTen.setForeground(new java.awt.Color(255, 255, 255));
        rdoTen.setText("Tên");
        rdoTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoMa.setBackground(new java.awt.Color(67, 130, 187));
        rdoMa.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa.setText("Mã");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtSearchTheo1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTheo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Danh sách năm bảo hành");

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelRound16.setBackground(new java.awt.Color(67, 130, 187));
        panelRound16.setRoundBottomLeft(50);
        panelRound16.setRoundBottomRight(50);
        panelRound16.setRoundTopLeft(50);
        panelRound16.setRoundTopRight(50);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        btnSearch.setToolTipText("Tìm năm bảo hành");
        btnSearch.setBorderColor(new java.awt.Color(221, 242, 244));
        btnSearch.setColor(new java.awt.Color(221, 242, 244));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setRadius(50);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(221, 242, 244));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        btnThem.setToolTipText("Thêm mới năm bảo hành");
        btnThem.setBorderColor(new java.awt.Color(221, 242, 244));
        btnThem.setColor(new java.awt.Color(221, 242, 244));
        btnThem.setRadius(50);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHienThi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAll);

        btnPre.setText("Pre");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        txtIndex.setText("1/1");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(txtIndex)
                        .addGap(87, 87, 87)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndex)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin năm bảo hành");

        txtTenNBH.setEditable(false);
        txtTenNBH.setBackground(new java.awt.Color(228, 206, 224));
        txtTenNBH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenNBH.setLabelText("Tên năm bảo hành");

        txtMaNBH.setBackground(new java.awt.Color(228, 206, 224));
        txtMaNBH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaNBH.setLabelText("Mã năm bảo hành");
        txtMaNBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNBHActionPerformed(evt);
            }
        });

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        myButton7.setText("Clear");
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

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenNBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtMaNBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaNBH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenNBH, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllMouseClicked
        int row = this.tableAll.getSelectedRow();
        createView.setVisible(false);
        fillData(row);
        rud.custom = baoHanhService.findNBHByMa(tableAll.getValueAt(row, 1).toString());
        rud.setVisible(true);
        rud.showData();
    }//GEN-LAST:event_tableAllMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchRadio();
        clearForm();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        createView.setVisible(true);
        rud.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        getList = baoHanhService.getListNBH();
        loadTable(getList);
        clearForm();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void txtMaNBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNBHActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        txtMaNBH.setText("");
        txtTenNBH.setText("");
    }//GEN-LAST:event_myButton7ActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        index = p.prevIndex(offset, limit, index);
        offset = p.prev(offset, limit);
        loadIndex();
        loadTable(getList);
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index = p.nextIndex(offset, limit, sizes, index);
        offset = p.next(offset, limit, sizes);
        loadIndex();
        loadTable(getList);
    }//GEN-LAST:event_btnNextActionPerformed

    private void loadIndex() {
        this.txtIndex.setText(String.valueOf(index) + " / " + (Math.round((sizes / limit) + 0.5)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.MyButton btnHienThi;
    private utilities.palette.UWPButton btnNext;
    private utilities.palette.UWPButton btnPre;
    private utilities.palette.MyButton btnSearch;
    private utilities.palette.MyButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound16;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoTen;
    private utilities.palette.TableDark_1 tableAll;
    private javax.swing.JLabel txtIndex;
    private utilities.palette.TextField txtMaNBH;
    private utilities.palette.SearchCustom.TextFieldAnimation txtSearchTheo1;
    private utilities.palette.TextField txtTenNBH;
    // End of variables declaration//GEN-END:variables
}
