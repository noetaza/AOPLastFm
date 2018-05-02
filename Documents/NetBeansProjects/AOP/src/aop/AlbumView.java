/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Noe
 */
public class AlbumView extends javax.swing.JFrame {

    /**
     * Creates new form AlbumView
     */
    
    String BASE_URL = "https://api.genius.com";
    String CLIENT_ACCESS_TOKEN_GENIUS = "P0ScDQvCodEmWbEgK-X7IU8nTjYNEKYaKDPOEePZYE8glZZU17cq7fYgS7nQNDwR";
    String CLIENT_ACCESS_TOKEN_LASTFM = "dce1aee6815b747ce8c10528ac1091bb";
    String ALBUM_NAME = "Ceremonials";
    String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; rv:40.0) Gecko/20100101 Firefox/40.0";
    
    String []Tracks = {
                        "Only If for a Night",
                        "Shake It Out",
                        "What the Water Gave Me",
                        "Never Let Me Go",
                        "Breaking Down",
                        "Lover to Lover",
                        "No Light, No Light",
                        "Seven Devils",
                        "Heartlines",
                        "Spectrum",
                        "All This and Heaven Too",
                        "Leave My Body"
                    };
    
    int xx, xy;
    
    private ArrayList<JLabel> nameTrack;
    
    public AlbumView() {
        initComponents();
        
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
        
        pnlHeader.setBackground(new Color(0,0,0,100));
        ImageIcon head = new ImageIcon(getClass().getResource("/images/header.jpg"));
        headerLabel.setIcon(scaleImageFill(head, headerLabel));
        
        loadImage("https://lastfm-img2.akamaized.net/i/u/300x300/3738ff515abf28ea87a7c949df8b9841.png", imgAlbum);
        
        albumName.setText(ALBUM_NAME);
        
        int xal=40, yal=230;
        int cy = 0;
        for(int i=0; i<12; i++){
            JLabel albImage = new JLabel();
            JLabel albName = new JLabel();
            
            albName.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
            String num = "" + (i+1);
            albName.setText( num + " - " + Tracks[i]);
            pnlAlbum.add(albName, new org.netbeans.lib.awtextra.AbsoluteConstraints(xal, yal + cy*30, 500, -1));
            cy++;
            
            if( i>10 ) {
                pnlAlbum.setPreferredSize(new Dimension(pnlAlbum.getWidth(), pnlAlbum.getHeight()+35));
            }
        }
        
        this.repaint();
    }

    public void loadImage(String str, JLabel jl){
        
        URL imageUrl;
        try {
            imageUrl = new URL(str);
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
                    connection.setRequestProperty("User-Agent", USER_AGENT);
            BufferedImage propertImage = ImageIO.read(imageUrl);
            ImageIcon img = new ImageIcon(propertImage);
            
            jl.setIcon(scaleImageFill(img, jl));
        } catch (Exception ex) {
        }
    }
    
    // Escalando Imagenes
    public ImageIcon scaleImageFill(ImageIcon imgi, JLabel jl){
        int iconWidth = imgi.getIconWidth();
        int iconHeight = imgi.getIconHeight();
        
        double scaleFactor = Math.min(1d, getScaleFactorToFill(new Dimension(iconWidth, iconHeight), jl.getSize()));

        int scaleWidth = (int) Math.round(iconWidth * scaleFactor);
        int scaleHeight = (int) Math.round(iconHeight * scaleFactor);

        Image scaled = imgi.getImage().getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
        ImageIcon iconf = new ImageIcon(scaled);
        return iconf;
    }
    
    public double getScaleFactor(int iMasterSize, int iTargetSize) {
        double dScale = 1;
        if (iMasterSize > iTargetSize) {
            dScale = (double) iTargetSize / (double) iMasterSize;
        } else {
            dScale = (double) iTargetSize / (double) iMasterSize;
        }
        return dScale;
    }

    public double getScaleFactorToFit(Dimension original, Dimension toFit) {
        double dScale = 1d;
        if (original != null && toFit != null) {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);

            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;
    }
    
    public double getScaleFactorToFill(Dimension masterSize, Dimension targetSize) {
        double dScaleWidth = getScaleFactor(masterSize.width, targetSize.width);
        double dScaleHeight = getScaleFactor(masterSize.height, targetSize.height);

        double dScale = Math.max(dScaleHeight, dScaleWidth);

        return dScale;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlAlbum = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        imgAlbum = new javax.swing.JLabel();
        albumName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioArtist = new javax.swing.JTextPane();
        headerLabel = new javax.swing.JLabel();
        tracklist = new javax.swing.JLabel();
        pnlLyrics = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitlebar.setBackground(new java.awt.Color(0, 0, 0));
        pnlTitlebar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTitlebarMouseDragged(evt);
            }
        });
        pnlTitlebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTitlebarMousePressed(evt);
            }
        });
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

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(900, 560));

        pnlAlbum.setBackground(new java.awt.Color(247, 247, 247));
        pnlAlbum.setPreferredSize(new java.awt.Dimension(990, 560));
        pnlAlbum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgAlbum.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imgAlbum.setOpaque(true);
        pnlHeader.add(imgAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 160));

        albumName.setFont(new java.awt.Font("Arvo", 1, 24)); // NOI18N
        albumName.setForeground(new java.awt.Color(255, 255, 255));
        albumName.setText("Album");
        pnlHeader.add(albumName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 780, -1));

        bioArtist.setEditable(false);
        bioArtist.setFont(new java.awt.Font("Arvo", 0, 14)); // NOI18N
        bioArtist.setText("Florence + the Machine deliver one baroque-pop anthem after another on Ceremonials. Featuring majestic, theatrical arrangements centered on Florence Welch’s remarkable vocals, this is a bolder and more dramatic offering than their debut, Lungs. Booming percussion, strings, echoing keyboards, and big guitars create a towering platform of sound from which Welch emotes with a fury. Her powerful voice erupts amid a gospel choir on “Shake It Out,” “What the Water Gave Me,” and “Leave My Body,” while tribal drums fuel “No Light, No Light” and “Heartlines.” Even the relatively subdued “Lover to Lover” builds to a spine-tingling crescendo. A distinctly British blend of Celtic, goth, and neo-soul influences, Ceremonials is a thickly layered and orchestral production that practically demands a visceral response from the listener. Fans will be blown away.");
        bioArtist.setCaretPosition(0);
        bioArtist.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(bioArtist);

        pnlHeader.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 780, 120));

        pnlAlbum.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 190));

        headerLabel.setBackground(new java.awt.Color(204, 204, 255));
        headerLabel.setOpaque(true);
        pnlAlbum.add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 190));

        tracklist.setFont(new java.awt.Font("Arvo", 0, 24)); // NOI18N
        tracklist.setText("Tracklist");
        pnlAlbum.add(tracklist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        pnlLyrics.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlLyricsLayout = new javax.swing.GroupLayout(pnlLyrics);
        pnlLyrics.setLayout(pnlLyricsLayout);
        pnlLyricsLayout.setHorizontalGroup(
            pnlLyricsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        pnlLyricsLayout.setVerticalGroup(
            pnlLyricsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        pnlAlbum.add(pnlLyrics, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 430, 350));

        jScrollPane2.setViewportView(pnlAlbum);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 990, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLoginMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLoginMouseClicked

    private void minLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minLoginMouseClicked
        // TODO add your handling code here:
        this.setState(ArtistView.ICONIFIED);
    }//GEN-LAST:event_minLoginMouseClicked

    private void pnlTitlebarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitlebarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlTitlebarMouseDragged

    private void pnlTitlebarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitlebarMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTitlebarMousePressed

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
            java.util.logging.Logger.getLogger(AlbumView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlbumView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlbumView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlbumView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlbumView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel albumName;
    private javax.swing.JTextPane bioArtist;
    private javax.swing.JLabel exitLogin;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel imgAlbum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel minLogin;
    private javax.swing.JPanel pnlAlbum;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlLyrics;
    private javax.swing.JPanel pnlTitlebar;
    private javax.swing.JLabel tracklist;
    // End of variables declaration//GEN-END:variables
}
