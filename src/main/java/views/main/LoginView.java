/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main;

import cores.logins.custom.NhanVienCustom;
import cores.logins.service.ServiceImpl.UserServiceImpl;
import cores.logins.service.UserService;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JOptionPane;
import utilities.Auth;

/**
 *
 * @author QUOC HUY
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private UserService service;
    
    private ConcurrentHashMap<String, NhanVienCustom> map;
    
    public LoginView() {
        service = new UserServiceImpl();
        map = new ConcurrentHashMap<>();
        initComponents();
        setLocationRelativeTo(null);
        txtEmail.setOpaque(false);
        txtPassWord.setOpaque(false);
        btnLogin.setOpaque(false);
        btnForgot.setOpaque(false);
        map = service.mapUserKeyEmail();
        Auth.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassWord = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new utilities.palette.UWPButton();
        jCheckBoxCustom1 = new utilities.palette.JCheckBoxCustom();
        btnForgot = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 100, 30));

        txtEmail.setBackground(new java.awt.Color(242, 242, 242));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setToolTipText("Nhập email");
        txtEmail.setAutoscrolls(false);
        txtEmail.setBorder(null);
        txtEmail.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 270, 40));

        txtPassWord.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassWord.setForeground(new java.awt.Color(255, 255, 255));
        txtPassWord.setToolTipText("Nhập password");
        txtPassWord.setAutoscrolls(false);
        txtPassWord.setBorder(null);
        txtPassWord.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(txtPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 270, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PassWord :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 170, 30));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setBorder(null);
        btnLogin.setText("LOGIN");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setOpaque(true);
        btnLogin.setSelectedColor(new java.awt.Color(255, 255, 255));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 200, 50));
        btnLogin.getAccessibleContext().setAccessibleName("LOGIN");

        jCheckBoxCustom1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBoxCustom1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom1.setText("Remember me ?");
        jCheckBoxCustom1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jCheckBoxCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, -1, -1));

        btnForgot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnForgot.setForeground(new java.awt.Color(255, 255, 255));
        btnForgot.setText("Forgot Password ?");
        btnForgot.setBorder(null);
        btnForgot.setOpaque(true);
        jPanel1.add(btnForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 140, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 131, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loginForm.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 710));
        jLabel1.getAccessibleContext().setAccessibleParent(jLabel3);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String email = this.txtEmail.getText();
        if(map.containsKey(email)) {
            if(map.get(email).getMatKhau().equals(txtPassWord.getText())) {
                Auth.nhanVien = map.get(email);
                JOptionPane.showMessageDialog(this, "Thành công" , "Welcome", JOptionPane.OK_OPTION);
                // check chức vụ
                Main n = new Main();
                n.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(this, "Mật khẩu không chính sác" , "ERROR !!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản không có trong bộ nhớ" , "ERROR !!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgot;
    private utilities.palette.UWPButton btnLogin;
    private utilities.palette.JCheckBoxCustom jCheckBoxCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassWord;
    // End of variables declaration//GEN-END:variables
}