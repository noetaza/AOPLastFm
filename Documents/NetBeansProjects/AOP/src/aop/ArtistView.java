/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject; 
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.imageio.ImageIO;

/**
 *
 * @author Noe
 */
public class ArtistView extends javax.swing.JFrame {

    /**
     * Creates new form ArtistView
     */
    String BASE_URL = "https://api.genius.com";
    String CLIENT_ACCESS_TOKEN_GENIUS = "P0ScDQvCodEmWbEgK-X7IU8nTjYNEKYaKDPOEePZYE8glZZU17cq7fYgS7nQNDwR";
    String CLIENT_ACCESS_TOKEN_LASTFM = "dce1aee6815b747ce8c10528ac1091bb";
    String ARTIST_NAME = "Florence + the Machine";
    String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; rv:40.0) Gecko/20100101 Firefox/40.0";
    
    int xx, xy;
    
    public ArtistView(){
        initComponents();
        
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        
        pnlHeader.setBackground(new Color(0,0,0,100));
        ImageIcon head = new ImageIcon(getClass().getResource("/images/header.jpg"));
        headerLabel.setIcon(scaleImageFill(head, headerLabel));
        
        loadImage("https://lastfm-img2.akamaized.net/i/u/300x300/e79b23131749eab7d7057808c6f3e53a.png", imgArtist);
        
        artistName.setText(ARTIST_NAME);
        this.repaint(); 
        
        //String ArtistID = getArtistID(ARTIST_NAME);
        //System.out.println(ArtistID);
        
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
        /*
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    String path = "https://images.genius.com/0987aa5b4e0767e6cb85a4312fd12d67.1000x278x1.jpg";
                    System.out.println("Get Image from " + path);
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    
                    //connection.setRequestMethod("GET");
                    //connection.setRequestProperty("Authorization", "Bearer " + CLIENT_ACCESS_TOKEN_GENIUS);
                    
                    //connection.setRequestProperty("Accept", "application/json");
                    connection.setRequestProperty("User-Agent", USER_AGENT);
                    
                    int contentLength = connection.getContentLength();
                    System.out.println("File contentLength = " + contentLength + " bytes");
                    
                    BufferedImage image = ImageIO.read(url.openStream());
                    System.out.println("Load image into frame...");
                    jl.setIcon(new ImageIcon(image));

                } catch (IOException exp) {
                }

            }
        });
        */
        
    }
    
    // JSON
    public String getArtistID(String ArtistName){ 
        String ID = "@";
        
        try { 
            URL queryURL = new URL(String.format(BASE_URL + "/search?q=%s", URLEncoder.encode(ARTIST_NAME, "UTF-8").replace("+", "%20")));
            
            HttpURLConnection conn = (HttpURLConnection) queryURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + CLIENT_ACCESS_TOKEN_GENIUS);
            conn.setRequestProperty("User-Agent", USER_AGENT);
            
            if (conn.getResponseCode() != 200) {
                //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            //creamos un StringBuilder para almacenar la respuesta del web service
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = br.read()) != -1){
                sb.append((char) cp);
            }

            //en la cadena output almacenamos toda la respuesta del servidor
            String output = sb.toString();
            //convertimos la cadena a JSON a traves de la libreria GSON
            JsonObject jsonF = new Gson().fromJson(output,JsonObject.class);

            conn.disconnect();
            
            JsonArray data = jsonF.getAsJsonObject("response").getAsJsonArray("hits");
            
            for (JsonElement element : data) {
                JsonObject search = element.getAsJsonObject().getAsJsonObject("result"); 
                String artist = search.getAsJsonObject("primary_artist").get("name").getAsString();
                
                if(artist.equalsIgnoreCase(ARTIST_NAME)){
                    return search.getAsJsonObject("primary_artist").get("id").getAsString();
                }
            }
             
        } catch (IOException e) { 
            System.out.println(e.getMessage());
        } 
        
        return ID;
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
        titlebar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlArtist = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        imgArtist = new javax.swing.JLabel();
        artistName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioArtist = new javax.swing.JTextPane();
        headerLabel = new javax.swing.JLabel();
        topAlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(990, 590));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(990, 560));
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

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(900, 560));

        pnlArtist.setBackground(new java.awt.Color(247, 247, 247));
        pnlArtist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgArtist.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imgArtist.setOpaque(true);
        pnlHeader.add(imgArtist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 160));

        artistName.setFont(new java.awt.Font("Arvo", 1, 24)); // NOI18N
        artistName.setForeground(new java.awt.Color(255, 255, 255));
        artistName.setText("Artist");
        pnlHeader.add(artistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 780, -1));

        bioArtist.setEditable(false);
        bioArtist.setFont(new java.awt.Font("Arvo", 0, 14)); // NOI18N
        bioArtist.setText("Florence + the Machine (a stylisation of Florence and The Machine) is a London, UK, art pop band led by singer-songwriter Florence Welch and formed in 2007. The band consists of: Florence Welch (vocals), Robert Ackroyd (guitar), Isabella Summers (aka Isa Machine - keyboards), Tom Monger (harp), Mark Saunders (bass, percussion), Christopher Lloyd Hayden (drums, backing vocals), Rusty Bradshaw (keyboard, backing vocals) and Sam White (backing vocals).");
        bioArtist.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(bioArtist);

        pnlHeader.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 780, 120));

        pnlArtist.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 190));

        headerLabel.setBackground(new java.awt.Color(204, 204, 255));
        headerLabel.setOpaque(true);
        pnlArtist.add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 190));

        topAlabel.setFont(new java.awt.Font("Arvo", 0, 24)); // NOI18N
        topAlabel.setText("Top Albums");
        pnlArtist.add(topAlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jScrollPane2.setViewportView(pnlArtist);

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
            java.util.logging.Logger.getLogger(ArtistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArtistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArtistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArtistView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArtistView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel artistName;
    private javax.swing.JTextPane bioArtist;
    private javax.swing.JLabel exitLogin;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel imgArtist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel minLogin;
    private javax.swing.JPanel pnlArtist;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTitlebar;
    private javax.swing.JLabel titlebar;
    private javax.swing.JLabel topAlabel;
    // End of variables declaration//GEN-END:variables
}
