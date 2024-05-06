/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edd.travelmapgt;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author mgome
 */
public class prueba extends JFrame {
    private JButton miBoton;
    private JPanel miPanel;

    public prueba() {
        miBoton = new JButton("Agregar contenido");
        miPanel = new JPanel();

        miBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el contenido que desees a tu JPanel.
                // Por ejemplo, vamos a agregar un nuevo JLabel cada vez que se presione el botón.
                miPanel.add(new JLabel("Nuevo contenido"));
                miPanel.revalidate();
                miPanel.repaint();
            }
        });

        this.setLayout(new BorderLayout());
        this.add(miBoton, BorderLayout.SOUTH);
        this.add(miPanel, BorderLayout.CENTER);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new prueba();
            }
        });
    }
}
