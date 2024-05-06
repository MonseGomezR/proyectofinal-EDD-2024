package com.edd.travelmapgt;

import com.edd.travelmapgt.grafosN.GrafoN;
import com.edd.travelmapgt.grafosN.Peso;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialOceanicTheme;

/**
 *
 * @author mgome
 */
public class TravelMapGT {

    public static Main newMain;

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                newMain = new Main();
                newMain.setVisible(true);
            }
        });

 /*GrafoN grafo = new GrafoN();
        grafo.nuevoNodo("a");
        grafo.nuevoNodo("b");
        grafo.nuevoNodo("c");
        grafo.nuevoNodo("d");
        grafo.nuevoNodo("e");
        grafo.nuevoNodo("f");

        grafo.newArista("a", "b", new Peso(20, 5, 2));
        grafo.newArista("b", "d", new Peso(15, 4, 3));
        grafo.newArista("d", "a", new Peso(28, 6, 2));
        grafo.newArista("c", "d", new Peso(18, 4, 2));
        grafo.newArista("a", "c", new Peso(12, 3, 2));
        grafo.newArista("d", "f", new Peso(30, 7, 4));
        grafo.newArista("b", "f", new Peso(22, 6, 3));
        grafo.newArista("d", "b", new Peso(15, 5, 3));
        grafo.newArista("a", "d", new Peso(28, 7, 4));

        List<List<Object>> todosLosCaminos = grafo.buscarCamino("a", "f");
        
        if (!todosLosCaminos.isEmpty()) {
            System.out.println("Todos los caminos encontrados:");
            for (List<Object> camino : todosLosCaminos) {
                System.out.print("Camino: ");
                for (int i = 0; i < camino.size(); i++) {
                    System.out.print(camino.get(i));
                    if (i < camino.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No se encontraron caminos desde 'a' hasta 'f'.");
        }*/
        

        /*grafo.insertarVertice("A"); //0
        grafo.insertarVertice("B"); //1
        grafo.insertarVertice("C"); //2
        grafo.insertarVertice("D"); //3
        grafo.insertarVertice("E"); //4
        
        grafo.insertarArista(0, 2, 12);
        grafo.insertarArista(0, 3, 60);
        grafo.insertarArista(1, 0, 10);
        grafo.insertarArista(2, 3, 32);
        grafo.insertarArista(2, 1, 20);
        grafo.insertarArista(4, 0, 7);
        
        System.out.println(grafo.mostrar());
        grafo.dibujarGraphviz();*/
    }
}
