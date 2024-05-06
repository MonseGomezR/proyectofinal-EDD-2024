package com.edd.travelmapgt;

import com.edd.travelmapgt.grafos.Grafo;
import com.edd.travelmapgt.grafos.GrafoDinamico;
import com.edd.travelmapgt.grafos.Ruta;
import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mgome
 */
public class FrameGUI extends javax.swing.JFrame {

    private boolean exito;
    ImageIcon iconoSuccess;
    final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * Creates new form FrameGUI
     */
    public FrameGUI() {
        initComponents();
        iconoSuccess = new ImageIcon("./resources/cheque3.png");
        ActionListener timerListener = (ActionEvent e) -> {
            Date date = new Date();
            String time = timeFormat.format(date);
            timeLabel.setText("Hora:    " + time);
        };
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        principal = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        limpiarMapa = new javax.swing.JButton();
        crearGrafo = new javax.swing.JButton();
        crearArbol = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        espacioMapa = new javax.swing.JPanel();
        mapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        principal.setLayout(new java.awt.BorderLayout());

        panelBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBotones.setMinimumSize(new java.awt.Dimension(250, 600));
        panelBotones.setPreferredSize(new java.awt.Dimension(250, 600));
        panelBotones.setRequestFocusEnabled(false);
        panelBotones.setLayout(new java.awt.GridBagLayout());

        limpiarMapa.setText("Limpiar");
        limpiarMapa.setFocusPainted(false);
        limpiarMapa.setPreferredSize(new java.awt.Dimension(200, 75));
        limpiarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarMapaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelBotones.add(limpiarMapa, gridBagConstraints);

        crearGrafo.setFocusPainted(false);
        crearGrafo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearGrafo.setLabel("Grafo");
        crearGrafo.setPreferredSize(new java.awt.Dimension(200, 75));
        crearGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearGrafoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelBotones.add(crearGrafo, gridBagConstraints);

        crearArbol.setText("Ver Mapa");
        crearArbol.setFocusPainted(false);
        crearArbol.setPreferredSize(new java.awt.Dimension(200, 75));
        crearArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearArbolActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelBotones.add(crearArbol, gridBagConstraints);

        timeLabel.setFont(new java.awt.Font("Zrnic Rg", 0, 18)); // NOI18N
        timeLabel.setText("Hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelBotones.add(timeLabel, gridBagConstraints);

        principal.add(panelBotones, java.awt.BorderLayout.WEST);

        espacioMapa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        espacioMapa.setMinimumSize(new java.awt.Dimension(540, 600));
        espacioMapa.setPreferredSize(new java.awt.Dimension(540, 600));
        espacioMapa.setLayout(new javax.swing.BoxLayout(espacioMapa, javax.swing.BoxLayout.LINE_AXIS));

        mapa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mapa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mapa.setMaximumSize(new java.awt.Dimension(10000, 10000));
        mapa.setMinimumSize(new java.awt.Dimension(540, 600));
        mapa.setPreferredSize(new java.awt.Dimension(540, 600));
        espacioMapa.add(mapa);

        principal.add(espacioMapa, java.awt.BorderLayout.CENTER);

        getContentPane().add(principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarMapaActionPerformed
        mapa.setIcon(null);
        espacioMapa.updateUI();
        espacioMapa.repaint();
    }//GEN-LAST:event_limpiarMapaActionPerformed

    private void crearArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearArbolActionPerformed
        
    }//GEN-LAST:event_crearArbolActionPerformed

    private void crearGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearGrafoActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null);
            File file = fc.getSelectedFile();
            GrafoDinamico grafo = new GrafoDinamico();
            Scanner scanner = new Scanner(file);

            int numOrigen = 0;
            int numDestino = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] ordenRuta = line.split("\\|");
                if (ordenRuta.length == 7) {
                    Ruta ruta = new Ruta(Integer.parseInt(ordenRuta[2]), Integer.parseInt(ordenRuta[3]), Integer.parseInt(ordenRuta[4]), Integer.parseInt(ordenRuta[5]), Integer.parseInt(ordenRuta[6]));
                    String origen = ordenRuta[0];
                    String destino = ordenRuta[1];
                    int distancia = ruta.getDistancia();

                    numOrigen = grafo.buscarVertichePorNombre(origen);
                    numDestino = grafo.buscarVertichePorNombre(destino);

                    if (numOrigen == -1) {
                        grafo.insertarVertice(origen);
                        numOrigen = grafo.orden() - 1;
                    }

                    if (numDestino == -1) {
                        grafo.insertarVertice(destino);
                        numDestino = grafo.orden() - 1;
                    }

                    grafo.insertarArista(numOrigen, numDestino, ruta);

                    exito = true;

                } else {
                    System.err.println("La línea no tiene el formato esperado: " + line);
                    JOptionPane.showConfirmDialog(null, "Error al leer el archivo, linea :" + line + "\nEl formato no es el esperado", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
                    break;
                }
            }
            scanner.close();
            String[] fileName= file.getName().split("\\.");
            grafo.dibujarGraphviz(fileName[0]);

            JOptionPane.showConfirmDialog(null, "Mapa creado con éxito", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, iconoSuccess);

            ImageIcon grafico = new ImageIcon("./dotFiles/" + fileName[0] + ".png");
            mapa.setIcon(grafico);
            espacioMapa.updateUI();
            espacioMapa.repaint();

        } catch (FileNotFoundException e) {
            JOptionPane.showConfirmDialog(null, "Error al crear el mapa, no se encontró el archivo", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, iconoSuccess);
            e.printStackTrace();
        }

    }//GEN-LAST:event_crearGrafoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearArbol;
    private javax.swing.JButton crearGrafo;
    private javax.swing.JPanel espacioMapa;
    private javax.swing.JButton limpiarMapa;
    private javax.swing.JLabel mapa;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel principal;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
