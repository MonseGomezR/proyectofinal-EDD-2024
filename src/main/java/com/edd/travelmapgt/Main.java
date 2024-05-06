package com.edd.travelmapgt;

import com.edd.travelmapgt.grafosN.GrafoN;
import com.edd.travelmapgt.grafosN.NodoGrafo;
import java.awt.CardLayout;
import java.awt.Color;

/**
 *
 * @author mgome
 */
public class Main extends javax.swing.JFrame {

    MenuController mc;
    CardLayout cl;

    public Main() {
        initComponents();
        cl = (CardLayout) jPanel2.getLayout();
        setBackground(new Color(0, 0, 0, 0));
        menu1.initMoving(Main.this);
        mc = new MenuController();
        cl.show(jPanel2, "1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.edd.travelmapgt.swing.PanelBorder();
        menu1 = new com.edd.travelmapgt.swing.Menu();
        jPanel1 = new javax.swing.JPanel();
        espacioMapa1 = new com.edd.travelmapgt.swing.EspacioMapa();
        jPanel2 = new javax.swing.JPanel();
        cover = new javax.swing.JPanel();
        setRutaForm1 = new com.edd.travelmapgt.swing.SetRutaForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        espacioMapa1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(espacioMapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 480));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.CardLayout());

        cover.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout coverLayout = new javax.swing.GroupLayout(cover);
        cover.setLayout(coverLayout);
        coverLayout.setHorizontalGroup(
            coverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        coverLayout.setVerticalGroup(
            coverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel2.add(cover, "1");
        jPanel2.add(setRutaForm1, "2");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void accion1() {
        GrafoN grafo = mc.crearGrafoNuevo(espacioMapa1, espacioMapa1.mapa, menu1.buttonCaminando.isSelected());
        setRutaForm1.setEnabled(true);
        NodoGrafo aux = grafo.getPrimero();
        while (aux != null) {
            setRutaForm1.cbOrigen.addItem(aux.dato.toString());
            setRutaForm1.cbDestino.addItem(aux.dato.toString());
            aux = aux.siguiente;
        }

        cl.show(jPanel2, "2");
        espacioMapa1.repaint();
        espacioMapa1.updateUI();
        jPanel2.revalidate();
        jPanel2.repaint();
        menu1.crearRuta.setEnabled(true);
        menu1.cargarMapa.setEnabled(false);
    }

    public void accion2() {
        cl.show(jPanel2, "1");
        mc.limpiarLabel(espacioMapa1, espacioMapa1.mapa);
        espacioMapa1.mapa.setIcon(null);
        espacioMapa1.espacioMapa.updateUI();
        espacioMapa1.espacioMapa.repaint();
        espacioMapa1.repaint();
        espacioMapa1.updateUI();

        for (int i = setRutaForm1.cbOrigen.getItemCount() - 1; i >= 0; i--) {
            String item = setRutaForm1.cbOrigen.getItemAt(i);
            if (!item.equals("Selecciona un Origen")) {
                setRutaForm1.cbOrigen.removeItemAt(i);
            }
        }

        for (int i = setRutaForm1.cbDestino.getItemCount() - 1; i >= 0; i--) {
            String item = setRutaForm1.cbDestino.getItemAt(i);
            if (!item.equals("Selecciona un Destino")) {
                setRutaForm1.cbDestino.removeItemAt(i);
            }
        }
        
        menu1.crearRuta.setEnabled(false);
        menu1.cargarMapa.setEnabled(true);
    }

    public void accion3() {
        if (espacioMapa1.mapa.getIcon() != null) {
            espacioMapa1.mapa.setIcon(null);
            espacioMapa1.espacioMapa.updateUI();
            espacioMapa1.espacioMapa.repaint();
            espacioMapa1.repaint();
            espacioMapa1.updateUI();
            mc.repintarGrafo(espacioMapa1.mapa, menu1.buttonCaminando.isSelected());
            espacioMapa1.repaint();
            espacioMapa1.updateUI();
            espacioMapa1.espacioMapa.updateUI();
            espacioMapa1.espacioMapa.repaint();
            if (menu1.buttonCaminando.isSelected()) {
                setRutaForm1.gasoDist.setEnabled(false);
                setRutaForm1.gasolina.setEnabled(false);

                setRutaForm1.desgaste.setEnabled(true);
                setRutaForm1.desgasteDistancia.setEnabled(true);
            } else {
                setRutaForm1.gasoDist.setEnabled(true);
                setRutaForm1.gasolina.setEnabled(true);

                setRutaForm1.desgaste.setEnabled(false);
                setRutaForm1.desgasteDistancia.setEnabled(false);
            }
        }
    }

    public void accion4() {
        int opcion = 0;

        if (setRutaForm1.gasolina.isSelected()) {
            opcion = 1;
        } else if (setRutaForm1.desgaste.isSelected()) {
            opcion = 2;
        } else if (setRutaForm1.distancia.isSelected()) {
            opcion = 3;
        } else if (setRutaForm1.gasoDist.isSelected()) {
            opcion = 4;
        } else if (setRutaForm1.desgasteDistancia.isSelected()) {
            opcion = 5;
        }
        mc.buscarCaminos(opcion, setRutaForm1.cbOrigen.getSelectedItem(), setRutaForm1.cbDestino.getSelectedItem(), menu1.buttonCaminando.isSelected(), espacioMapa1.mapa);

        espacioMapa1.espacioMapa.updateUI();
        espacioMapa1.espacioMapa.repaint();
        espacioMapa1.repaint();
        espacioMapa1.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cover;
    private com.edd.travelmapgt.swing.EspacioMapa espacioMapa1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.edd.travelmapgt.swing.Menu menu1;
    private com.edd.travelmapgt.swing.PanelBorder panelBorder1;
    private com.edd.travelmapgt.swing.SetRutaForm setRutaForm1;
    // End of variables declaration//GEN-END:variables
}
