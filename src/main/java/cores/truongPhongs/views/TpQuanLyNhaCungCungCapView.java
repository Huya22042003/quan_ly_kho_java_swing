package cores.truongPhongs.views;

/**
 *
 * @author LENOVO
 */
public class TpQuanLyNhaCungCungCapView extends javax.swing.JFrame {

    /**
     * Creates new form TpQuanLyNhaCungCungCapView
     */
    public TpQuanLyNhaCungCungCapView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound4 = new utilities.palette.PanelRound();
        rdoNhanVien = new utilities.palette.RadioButtonCustom();
        rdoNcc = new utilities.palette.RadioButtonCustom();
        rdoMa = new utilities.palette.RadioButtonCustom();
        textFieldAnimation1 = new utilities.palette.SearchCustom.TextFieldAnimation();
        panelRound3 = new utilities.palette.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        textField3 = new utilities.palette.TextField();
        textField4 = new utilities.palette.TextField();
        myButton7 = new utilities.palette.MyButton();
        textField6 = new utilities.palette.TextField();
        textField7 = new utilities.palette.TextField();
        textField8 = new utilities.palette.TextField();
        combobox1 = new utilities.palette.Combobox();
        combobox2 = new utilities.palette.Combobox();
        panelRound1 = new utilities.palette.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark_11 = new utilities.palette.TableDark_1();
        panelRound5 = new utilities.palette.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound15 = new utilities.palette.PanelRound();
        myButton9 = new utilities.palette.MyButton();
        myButton10 = new utilities.palette.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRound4.setBackground(new java.awt.Color(67, 130, 187));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        rdoNhanVien.setBackground(new java.awt.Color(67, 130, 187));
        rdoNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setText("Mã");
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        rdoNcc.setBackground(new java.awt.Color(67, 130, 187));
        rdoNcc.setForeground(new java.awt.Color(255, 255, 255));
        rdoNcc.setText("Tên");
        rdoNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNccActionPerformed(evt);
            }
        });

        rdoMa.setBackground(new java.awt.Color(67, 130, 187));
        rdoMa.setForeground(new java.awt.Color(255, 255, 255));
        rdoMa.setText("SDT");
        rdoMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldAnimation1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelRound3.setBackground(new java.awt.Color(228, 206, 224));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông Tin Nhà Cung Cấp");

        textField3.setEditable(false);
        textField3.setBackground(new java.awt.Color(228, 206, 224));
        textField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textField3.setLabelText("Tên Nhà Cung Cấp");

        textField4.setBackground(new java.awt.Color(228, 206, 224));
        textField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textField4.setLabelText("Mã  ");
        textField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField4ActionPerformed(evt);
            }
        });

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Addd.png"))); // NOI18N
        myButton7.setText("Thêm Nhà Cung Cấp");
        myButton7.setToolTipText("THANH TOÁN");
        myButton7.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton7.setColor(new java.awt.Color(221, 242, 244));
        myButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton7.setRadius(50);

        textField6.setEditable(false);
        textField6.setBackground(new java.awt.Color(228, 206, 224));
        textField6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textField6.setLabelText("Địa Chỉ");

        textField7.setEditable(false);
        textField7.setBackground(new java.awt.Color(228, 206, 224));
        textField7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textField7.setLabelText("Email");
        textField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField7ActionPerformed(evt);
            }
        });

        textField8.setBackground(new java.awt.Color(228, 206, 224));
        textField8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textField8.setLabelText("SDT");
        textField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField8ActionPerformed(evt);
            }
        });

        combobox1.setBackground(new java.awt.Color(228, 206, 224));
        combobox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combobox1.setLabeText("Đánh Giá");

        combobox2.setBackground(new java.awt.Color(228, 206, 224));
        combobox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combobox2.setLabeText("Trạng Thái");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                        .addComponent(textField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combobox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        tableDark_11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Địa Chỉ", "Email", "SDT", "Trạng Thái", "Đánh Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDark_11);

        panelRound5.setBackground(new java.awt.Color(67, 130, 187));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUẢN LÝ NHÀ CUNG CẤP");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(67, 130, 187));
        panelRound15.setRoundBottomLeft(50);
        panelRound15.setRoundBottomRight(50);
        panelRound15.setRoundTopLeft(50);
        panelRound15.setRoundTopRight(50);

        myButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        myButton9.setToolTipText("Phiếu nhập chi tiết");
        myButton9.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton9.setColor(new java.awt.Color(221, 242, 244));
        myButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton9.setRadius(50);
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });

        myButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-to-basket.png"))); // NOI18N
        myButton10.setToolTipText("Thêm sản phẩm muốn nhập");
        myButton10.setBorderColor(new java.awt.Color(221, 242, 244));
        myButton10.setColor(new java.awt.Color(221, 242, 244));
        myButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton10.setRadius(50);
        myButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(myButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(myButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 344, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton9ActionPerformed

    private void myButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton10ActionPerformed

    private void textField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField4ActionPerformed

    private void textField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField7ActionPerformed

    private void textField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField8ActionPerformed

    private void rdoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaActionPerformed
        //searchRadio();
    }//GEN-LAST:event_rdoMaActionPerformed

    private void rdoNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNccActionPerformed
        //searchRadio();
    }//GEN-LAST:event_rdoNccActionPerformed

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        //        searchRadio();
    }//GEN-LAST:event_rdoNhanVienActionPerformed

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
            java.util.logging.Logger.getLogger(TpQuanLyNhaCungCungCapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TpQuanLyNhaCungCungCapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TpQuanLyNhaCungCungCapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TpQuanLyNhaCungCungCapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TpQuanLyNhaCungCungCapView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.Combobox combobox1;
    private utilities.palette.Combobox combobox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.MyButton myButton10;
    private utilities.palette.MyButton myButton7;
    private utilities.palette.MyButton myButton9;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.PanelRound panelRound15;
    private utilities.palette.PanelRound panelRound3;
    private utilities.palette.PanelRound panelRound4;
    private utilities.palette.PanelRound panelRound5;
    private utilities.palette.RadioButtonCustom rdoMa;
    private utilities.palette.RadioButtonCustom rdoNcc;
    private utilities.palette.RadioButtonCustom rdoNhanVien;
    private utilities.palette.TableDark_1 tableDark_11;
    private utilities.palette.TextField textField3;
    private utilities.palette.TextField textField4;
    private utilities.palette.TextField textField6;
    private utilities.palette.TextField textField7;
    private utilities.palette.TextField textField8;
    private utilities.palette.SearchCustom.TextFieldAnimation textFieldAnimation1;
    // End of variables declaration//GEN-END:variables
}
