package com.edd.travelmapgt.swing;

import com.edd.travelmapgt.MenuController;
import com.edd.travelmapgt.TravelMapGT;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author mgome
 */
public class Menu extends javax.swing.JPanel {
    
    final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private MenuController mc;

    public Menu() {
        initComponents();
        setOpaque(false);
        
        
        cargarMapa.setUI(new StyledButtonUI());
        crearRuta.setUI(new StyledButtonUI());
        salir.setUI(new StyledButtonUI());
        limpiarMapa.setUI(new StyledButtonUI());
        
        ActionListener timerListener = (ActionEvent e) -> {
            Date date = new Date();
            String time = timeFormat.format(date);
            hora.setText(time);
        };
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        
        mc = new MenuController();
        
        
        buttonVehiculo.setSelected(true);
        buttonCaminando.setSelected(false);
        
        bg.add(buttonCaminando);
        bg.add(buttonVehiculo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        panelMoving = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        espacioHora = new javax.swing.JPanel();
        tagHora = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cargarMapa = new javax.swing.JButton();
        crearRuta = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        limpiarMapa = new javax.swing.JButton();
        buttonCaminando = new com.edd.travelmapgt.swing.RadioButtonCustom();
        buttonVehiculo = new com.edd.travelmapgt.swing.RadioButtonCustom();

        panelMoving.setOpaque(false);

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Aldo the Apache", 0, 30)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Travel Map GT");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        espacioHora.setOpaque(false);

        tagHora.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        tagHora.setForeground(new java.awt.Color(255, 255, 255));
        tagHora.setText("Hora:");

        hora.setBackground(new java.awt.Color(255, 255, 255));
        hora.setFont(new java.awt.Font("Aldo the Apache", 0, 24)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText(".");

        javax.swing.GroupLayout espacioHoraLayout = new javax.swing.GroupLayout(espacioHora);
        espacioHora.setLayout(espacioHoraLayout);
        espacioHoraLayout.setHorizontalGroup(
            espacioHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(espacioHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(espacioHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tagHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        espacioHoraLayout.setVerticalGroup(
            espacioHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(espacioHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tagHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        cargarMapa.setBackground(new java.awt.Color(255, 255, 255));
        cargarMapa.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        cargarMapa.setForeground(new java.awt.Color(0, 0, 0));
        cargarMapa.setText("Cargar Mapa");
        cargarMapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargarMapaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargarMapaMouseExited(evt);
            }
        });
        cargarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarMapaActionPerformed(evt);
            }
        });

        crearRuta.setBackground(new java.awt.Color(255, 255, 255));
        crearRuta.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        crearRuta.setForeground(new java.awt.Color(0, 0, 0));
        crearRuta.setText("Crear Ruta");
        crearRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearRuta.setEnabled(false);
        crearRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearRutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearRutaMouseExited(evt);
            }
        });
        crearRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearRutaActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("Salir");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
        });
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        limpiarMapa.setBackground(new java.awt.Color(255, 255, 255));
        limpiarMapa.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        limpiarMapa.setForeground(new java.awt.Color(0, 0, 0));
        limpiarMapa.setText("Limpiar Mapa");
        limpiarMapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiarMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                limpiarMapaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                limpiarMapaMouseExited(evt);
            }
        });
        limpiarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarMapaActionPerformed(evt);
            }
        });

        buttonCaminando.setBackground(new java.awt.Color(255, 0, 51));
        buttonCaminando.setText("Caminando");
        buttonCaminando.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        buttonCaminando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCaminandoActionPerformed(evt);
            }
        });

        buttonVehiculo.setBackground(new java.awt.Color(255, 0, 51));
        buttonVehiculo.setText("Vehiculo");
        buttonVehiculo.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        buttonVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limpiarMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearRuta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(cargarMapa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCaminando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cargarMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crearRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpiarMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(buttonCaminando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(espacioHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(espacioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargarMapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMapaMouseEntered
        cargarMapa.setBackground(new Color(204, 245, 238));
    }//GEN-LAST:event_cargarMapaMouseEntered

    private void cargarMapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMapaMouseExited
        cargarMapa.setBackground(Color.white);
    }//GEN-LAST:event_cargarMapaMouseExited

    private void crearRutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearRutaMouseEntered
        if(crearRuta.isEnabled()) {
            crearRuta.setBackground(new Color(204, 245, 238));
        }
    }//GEN-LAST:event_crearRutaMouseEntered

    private void crearRutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearRutaMouseExited
        crearRuta.setBackground(Color.white);
    }//GEN-LAST:event_crearRutaMouseExited

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setBackground(new Color(204, 245, 238));
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setBackground(Color.white);
    }//GEN-LAST:event_salirMouseExited

    private void cargarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarMapaActionPerformed
        TravelMapGT.newMain.accion1();
    }//GEN-LAST:event_cargarMapaActionPerformed

    private void limpiarMapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarMapaMouseEntered
                                   
        limpiarMapa.setBackground(new Color(204, 245, 238));
    }//GEN-LAST:event_limpiarMapaMouseEntered

    private void limpiarMapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarMapaMouseExited
                                   
        limpiarMapa.setBackground(Color.WHITE);
    }//GEN-LAST:event_limpiarMapaMouseExited

    private void limpiarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarMapaActionPerformed
        TravelMapGT.newMain.accion2();
    }//GEN-LAST:event_limpiarMapaActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void crearRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearRutaActionPerformed
        
    }//GEN-LAST:event_crearRutaActionPerformed

    private void buttonCaminandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCaminandoActionPerformed
        TravelMapGT.newMain.accion3();
    }//GEN-LAST:event_buttonCaminandoActionPerformed

    private void buttonVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVehiculoActionPerformed
        TravelMapGT.newMain.accion3();
    }//GEN-LAST:event_buttonVehiculoActionPerformed

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gd = new GradientPaint(0, 0, Color.decode("#00ceac"), 0, getHeight(), Color.decode("#223377"));
        g2.setPaint(gd);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }
    
    private int x;
    private int y;
    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg;
    public com.edd.travelmapgt.swing.RadioButtonCustom buttonCaminando;
    public com.edd.travelmapgt.swing.RadioButtonCustom buttonVehiculo;
    private javax.swing.JButton cargarMapa;
    public javax.swing.JButton crearRuta;
    private javax.swing.JPanel espacioHora;
    private javax.swing.JLabel hora;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton limpiarMapa;
    private javax.swing.JPanel panelMoving;
    private javax.swing.JButton salir;
    private javax.swing.JLabel tagHora;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
