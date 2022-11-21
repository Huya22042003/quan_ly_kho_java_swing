/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import views.event.EventMenu;
import views.event.EventMenuSelected;
import views.event.EventShowPopupMenu;
import views.model.ModelMenu;
import views.swing.MenuAnimation;
import views.swing.MenuItem;
import views.swing.scrollbar.ScrollBarCustom;

/**
 *
 * @author QUOC HUY
 */
public class MenuNhanVienQuanLy extends javax.swing.JPanel {

    /**
     * Creates new form MenuNhanVienQuanLy
     */
     
    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = false;

    public MenuNhanVienQuanLy() {
        initComponents();
        cmdMenu.setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/1.png")), "Dashboard", "Home", "Buttons", "Cards", "Tabs", "Accordions", "Modals"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/2.png")), "Charts", "Morris", "Flot", "Line"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/3.png")), "Report", "Income", "Expense", "Profit"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/4.png")), "Message", "Sender", "Inbox", "User"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/5.png")), "Staff", "Sender", "Inbox", "User"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/6.png")), "Student", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/7.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/9.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/13.png")), "Our Centres"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icons/14.png")), "Gallery"));
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    
    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(19,106,138), getWidth(), 0, new Color(38,120,113));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        cmdMenu = new views.swing.Button();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(153, 153, 255));
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        cmdMenu.setBackground(new java.awt.Color(242, 242, 242));
        cmdMenu.setEnabled(false);
        cmdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private views.swing.Button cmdMenu;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
