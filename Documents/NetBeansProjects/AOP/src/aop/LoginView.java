package aop;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Noe
 */
public class LoginView extends javax.swing.JFrame {

    int xy,xx;
    
    public LoginView() {
        initComponents();
        pnl_overlay.setBackground(new Color(0,0,0,150));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitlebar = new javax.swing.JPanel();
        exitLogin = new javax.swing.JLabel();
        minLogin = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        titlebar = new javax.swing.JLabel();
        pnl_overlay = new javax.swing.JPanel();
        imageLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        userLogin = new javax.swing.JLabel();
        txt_userLogin = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pwdLogin = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txt_passwordLogin = new javax.swing.JPasswordField();
        signin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setFocusableWindowState(true);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitlebar.setBackground(new java.awt.Color(0, 0, 0));
        pnlTitlebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        exitLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLoginMouseClicked(evt);
            }
        });
        pnlTitlebar.add(exitLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

        minLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expand.png"))); // NOI18N
        minLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minLoginMouseClicked(evt);
            }
        });
        pnlTitlebar.add(minLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon.png"))); // NOI18N
        pnlTitlebar.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        getContentPane().add(pnlTitlebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 35));

        titlebar.setBackground(new java.awt.Color(0, 0, 0));
        titlebar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlebarMouseDragged(evt);
            }
        });
        titlebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlebarMousePressed(evt);
            }
        });
        getContentPane().add(titlebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 35));

        pnl_overlay.setBackground(new java.awt.Color(0, 0, 0));
        pnl_overlay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnl_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 410, 560));

        imageLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mw.jpg"))); // NOI18N
        imageLogin.setPreferredSize(new java.awt.Dimension(410, 550));
        getContentPane().add(imageLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLogin.setFont(new java.awt.Font("Arvo", 0, 18)); // NOI18N
        userLogin.setForeground(new java.awt.Color(57, 113, 177));
        userLogin.setText("User");
        jPanel2.add(userLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        txt_userLogin.setBackground(new java.awt.Color(32, 33, 35));
        txt_userLogin.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt_userLogin.setForeground(new java.awt.Color(255, 255, 255));
        txt_userLogin.setBorder(null);
        jPanel2.add(txt_userLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 370, 20));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 370, 10));

        pwdLogin.setFont(new java.awt.Font("Arvo", 0, 18)); // NOI18N
        pwdLogin.setForeground(new java.awt.Color(57, 113, 177));
        pwdLogin.setText("Password");
        jPanel2.add(pwdLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 370, 10));

        txt_passwordLogin.setBackground(new java.awt.Color(32, 33, 35));
        txt_passwordLogin.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt_passwordLogin.setForeground(new java.awt.Color(255, 255, 255));
        txt_passwordLogin.setBorder(null);
        txt_passwordLogin.setEchoChar('\u25CF');
        txt_passwordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordLoginActionPerformed(evt);
            }
        });
        jPanel2.add(txt_passwordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 370, -1));

        signin.setBackground(new java.awt.Color(102, 102, 255));
        signin.setFont(new java.awt.Font("Arvo", 0, 18)); // NOI18N
        signin.setForeground(new java.awt.Color(255, 255, 255));
        signin.setText("SIGN IN");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        jPanel2.add(signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 370, 50));

        jLabel1.setFont(new java.awt.Font("Arvo", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Member? Register now.");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 210, 30));

        signup.setBackground(new java.awt.Color(51, 102, 255));
        signup.setFont(new java.awt.Font("Arvo", 0, 11)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("SIGN UP");
        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 580, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordLoginActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_passwordLoginActionPerformed

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signinActionPerformed

    private void exitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLoginMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLoginMouseClicked

    private void minLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minLoginMouseClicked
        // TODO add your handling code here:
        this.setState(LoginView.ICONIFIED);
    }//GEN-LAST:event_minLoginMouseClicked

    private void titlebarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);  
        
    }//GEN-LAST:event_titlebarMouseDragged

    private void titlebarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_titlebarMousePressed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitLogin;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel imageLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel minLogin;
    private javax.swing.JPanel pnlTitlebar;
    private javax.swing.JPanel pnl_overlay;
    private javax.swing.JLabel pwdLogin;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup;
    private javax.swing.JLabel titlebar;
    private javax.swing.JPasswordField txt_passwordLogin;
    private javax.swing.JTextField txt_userLogin;
    private javax.swing.JLabel userLogin;
    // End of variables declaration//GEN-END:variables
}
