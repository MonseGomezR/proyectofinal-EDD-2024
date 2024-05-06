package com.edd.travelmapgt;

import com.edd.travelmapgt.grafos.GrafoDinamico;
import com.edd.travelmapgt.grafos.Ruta;
import com.edd.travelmapgt.grafosN.GrafoN;
import com.edd.travelmapgt.grafosN.NodoGrafo;
import com.edd.travelmapgt.grafosN.Peso;
import com.edd.travelmapgt.swing.EspacioMapa;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.JTextComponent;

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
        
    }

    /*public void crearGrafo(JPanel espacioMapa, JLabel mapa) {
        
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
            nodosActuales = new String[grafo.orden()];
            for(int i = 0; i < grafo.orden(); i++) {
                nodosActuales[i] = grafo.obtenerVertice(i).getVerticeName();
            }
            
            scanner.close();
            
            String[] fileName= file.getName().split("\\.");
            grafo.dibujarGraphviz(fileName[0]);
            JOptionPane.showConfirmDialog(null, "Mapa creado con éxito", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, iconoSuccess);

            ImageIcon grafico = new ImageIcon("./dotFiles/" + fileName[0] + ".png");
            mapa.setIcon(grafico);
            cargarTrafico();
        } catch (FileNotFoundException e) {
            JOptionPane.showConfirmDialog(null, "Error al crear el mapa, no se encontró el archivo", "Creacion de Mapa", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, iconoSuccess);
            e.printStackTrace();
        }
    }
    
    public void seleccionarDestino(JPanel panelOpciones, JPanel panelPrincipal) {
        
    }
    
    private void cargarTrafico() {
        
    }
    
    public String[] getNodosActuales() {
        return nodosActuales;
    }*/
}
