package cores.nhanVienVanDons.views;

import cores.nhanVienVanDons.customModels.NVVDListNVGHCustom;
import cores.nhanVienVanDons.services.NVVDListNVGHService;
import cores.nhanVienVanDons.services.serviceImpls.NVVDListNVGHServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author admin
 */
public class NVVDListNVGHForm extends javax.swing.JPanel {

    private NVVDListNVGHService qlListNVGH;
    private List<NVVDListNVGHCustom> list;
    public NVVDListNVGHForm() {
        initComponents();
        qlListNVGH = new NVVDListNVGHServiceImpl();
        list = qlListNVGH.getListNVGHByMa();
        loadTable(this.list);
    }
    private void loadTable(List<NVVDListNVGHCustom> list){
        DefaultTableModel dtm = (DefaultTableModel) this.tblNVGH.getModel();
        dtm.setRowCount(0);
        for (NVVDListNVGHCustom nv : list) {
            Object[] rowData ={
                nv.getMa(),
                nv.getTen(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getMatKhau(),
                nv.getNgaySinh(),
                nv.getHinhAnh(),
                nv.getGioiTinh(),
                nv.getTrangThai(),
                nv.getIdKhoHang(),
                nv.getIdKhoGiao()
            };
            dtm.addRow(rowData);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new utilities.palette.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNVGH = new utilities.palette.TableDark_1();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tìm kiếm theo Mã:");

        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        tblNVGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "SDT", "Email", "Mật khẩu", "Ngày sinh", "Hình ảnh", "Giới tính", "Trạng thái", "Mã Kho Hang", "Mã Kho Giao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNVGH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        String ma = this.txtSearch.getText();
        if(ma.trim().length() == 0) {
            loadTable(this.list);
            return;
        }
        List<NVVDListNVGHCustom> listNew = list;
        List<NVVDListNVGHCustom> listSearch = new ArrayList<>();
        listNew.parallelStream().forEach(el -> {
            String maNV = el.getMa();
            List<String> strings = new ArrayList<>();
            for (int i = 1; i <= maNV.length(); i++) {
                String newMa = maNV.substring(0, i).trim();
                strings.add(newMa);
            }
            for (String e : strings) {
                if(e.equalsIgnoreCase(ma)) {
                    listSearch.add(el);
                }
            }
        });
        loadTable(listSearch);
    }//GEN-LAST:event_txtSearchCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private utilities.palette.TableDark_1 tblNVGH;
    private utilities.palette.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
