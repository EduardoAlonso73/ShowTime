/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time.vista;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import time.controlador.CtdStart;
//import com.sun.awt.AWTUtilities;

/**
 *
 * @author Edwin
 */
public class Start extends javax.swing.JDialog {

    public Start(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        setBackground(new Color(108, 246, 248, 0));
        initComponents();
        jPanel1.setOpaque(false);
        //Position of  top right
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - getWidth();
        setLocation(x, 0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        menuItem1 = new java.awt.MenuItem();
        MNIRefresc = new java.awt.MenuItem();
        MNISetting = new java.awt.MenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblShowTime = new javax.swing.JLabel();
        lblShowDate = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        menuItem1.setActionCommand("Exit");
        menuItem1.setLabel("Exit");
        popupMenu1.add(menuItem1);

        MNIRefresc.setActionCommand("Refresh");
        MNIRefresc.setLabel("Refresh");
        popupMenu1.add(MNIRefresc);

        MNISetting.setLabel("Setting");
        popupMenu1.add(MNISetting);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblShowTime.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        lblShowTime.setForeground(new java.awt.Color(255, 255, 255));
        lblShowTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowTime.setText("02:08:7 p.m");
        lblShowTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblShowTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 540, 80));

        lblShowDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblShowDate.setForeground(new java.awt.Color(153, 153, 153));
        lblShowDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowDate.setText("4,Jul del 2021");
        lblShowDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblShowDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked
    int xx, xy;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    public static void main(String args[]) {

        Start dlgStart = new Start(new javax.swing.JFrame(), true);
        CtdStart ctdStart = new CtdStart(dlgStart);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.MenuItem MNIRefresc;
    public java.awt.MenuItem MNISetting;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblShowDate;
    public javax.swing.JLabel lblShowTime;
    public java.awt.MenuItem menuItem1;
    public java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
