package com.edd.travelmapgt;

import com.edd.travelmapgt.grafosN.GrafoN;
import com.edd.travelmapgt.grafosN.Peso;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mgome
 */
public class MenuController {

    private JPanel aux;
    private GrafoN actual;
    private String actualDoc;

    public JPanel getAux() {
        return aux;
    }

    public void setAux(JPanel aux) {
        this.aux = aux;
    }

    ImageIcon iconoSuccess = new ImageIcon("./resources/cheque3.png");
    boolean exito;

    public void limpiarLabel(JPanel espacioMapa, JLabel mapa) {
        mapa.setIcon(null);
        espacioMapa.updateUI();
        espacioMapa.repaint();
    }

    public GrafoN  crearGrafoNuevo(JPanel espacioMapa, JLabel mapa, boolean opcion) {
        
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            GrafoN grafo = new GrafoN();
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] ruta = line.split("\\|");
                if (ruta.length == 7) {
                    Peso p = new Peso(Integer.parseInt(ruta[6]), Integer.parseInt(ruta[4]), Integer.parseInt(ruta[2]), Integer.parseInt(ruta[5]), Integer.parseInt(ruta[3]));
                    String origen = ruta[0];
                    String destino = ruta[1];
                    grafo.nuevoNodo(origen);
                    grafo.nuevoNodo(destino);
                    grafo.newArista(origen, destino, p);
                } else {
                    JOptionPane.showConfirmDialog(null, "Error al leer el archivo, linea :" + line + "\nEl formato no es el esperado", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
                }
            }

            sc.close();
            actual = grafo;
            String[] fileName = file.getName().split("\\.");
            actualDoc = fileName[0];
            grafo.dibujarGraphviz(fileName[0], opcion);
            JOptionPane.showConfirmDialog(null, "Mapa creado con éxito", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, iconoSuccess);

            ImageIcon grafico = new ImageIcon("./dotFiles/" + fileName[0] + ".png");
            mapa.setIcon(grafico);
            return grafo;
            //cargarTrafico();
        } catch (Exception e) {

        }
        return null;
    }

    public void repintarGrafo(JLabel mapa, boolean opcion) {
        actual.dibujarGraphviz(actualDoc, opcion);
        String finalFile = actualDoc;
        if (opcion) {
            finalFile += "c";
        }
        ImageIcon grafico = new ImageIcon("./dotFiles/" + finalFile + ".png");
        mapa.setIcon(null);
        grafico.getImage().flush();
        mapa.setIcon(grafico);
    }
    
    public void buscarCaminos(int opcion, Object inicio, Object destino) {
        List<List<Object>> caminos = actual.buscarCamino(inicio, destino, opcion);
        if (!caminos.isEmpty()) {
            System.out.println("Todos los caminos encontrados:");
            for (List<Object> camino : caminos) {
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
            System.out.println("No se encontraron caminos desde '" + inicio + "' hasta '" + destino + "'.");
        }
    }
}
