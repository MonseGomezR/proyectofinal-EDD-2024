package com.edd.travelmapgt.grafos;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author mgome
 * @param 
 */
public class GrafoDinamico {

    private ArrayList<Vertice> vertices = new ArrayList<>();
    private ArrayList<Ruta> rutas = new ArrayList<>();
    private int id = 0;

    public void insertarVertice(String x) {
        vertices.add(new Vertice(x, id));
        id++;
    }

    public Vertice obtenerVertice(int pos) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice get = vertices.get(i);
            if (pos == i) {
                return vertices.get(i);
            }
        }
        return null;
    }

    public void insertarArista(int vInicio, int vFinal, Ruta ruta) {
        vertices.get(vInicio).agregarArista(new Arista(obtenerVertice(vFinal), ruta));
    }

    public int costoArista(int vInicio, int vFinal) {
        Vertice vertice = vertices.get(vInicio);
        ArrayList<Arista> aristas = vertice.getAristas();
        for (int j = 0; j < aristas.size(); j++) {
            Arista arista = aristas.get(j);
            if (arista.getDestino().equals(obtenerVertice(vFinal))) {
                return arista.getRuta().getDistancia();
            }
        }
        return -1;

    }

    public int orden() {
        return vertices.size();
    }

    public ArrayList sucesores(int pos) {
        ArrayList sucesores = new ArrayList<>();

        Vertice vertice = vertices.get(pos);

        ArrayList<Arista> aristas = vertice.getAristas();
        for (int i = 0; i < aristas.size(); i++) {
            sucesores.add(aristas.get(i).getDestino().getVerticeName());
        }
        return sucesores;
    }

    public String mostrar() {
        String mostrar = "";
        for (Vertice vertice : vertices) {
            ArrayList<Arista> aristas = vertice.getAristas();
            mostrar += vertice.id + ".     " + vertice.getVerticeName()+ "\n";
            for (Arista arista : aristas) {
                mostrar += "    " + arista.getDestino().getVerticeName()+ " " + arista.getRuta().getDistancia();
            }
            mostrar += "\n";
        }
        return mostrar;
    }

    public boolean dibujarGraphviz(String nombreArchivo) {
        String finalFile = "./dotFiles/" + nombreArchivo;
        try {
            String contenido = obtenerCodigoGraphviz();
            String finalPathDotFile = "./dotFiles/" + nombreArchivo + ".dot";
            File file = new File(finalPathDotFile);
            escribirArchivo(finalPathDotFile, contenido);

            MutableGraph mutableGrap = new Parser().read(file);
            Graphviz.fromGraph(mutableGrap).render(Format.PNG).toFile(new File(finalFile + ".png"));

            return true;
        } catch (IOException e) {
            return false;
        }

    }

    private void escribirArchivo(String ruta, String contenido) {
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            pw.write(contenido);
            pw.close();
            fichero.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public String obtenerCodigoGraphviz() {
        String mostrar = "";
        String texto = "digraph G\n"
                + "{\n"
                + "bgcolor=\"#D6D9DF\"\n"
                + "node [style = filled]\n"
                + "node [fillcolor = \"#EEEEEE\"]\n"
                + "node [color = \"#EEEEEE\"]\n"
                + "node [fontsize = 10]\n"
                + "layout=fdp\n"
                + "K=2\n";

        if (vertices != null) {
            for (Vertice vertice : vertices) {
                ArrayList<Arista> aristas = vertice.getAristas();
                for (Arista arista : aristas) {
                    mostrar += vertice.getVerticeName()+ "->" + arista.getDestino().getVerticeName()+ "\n";
                }
            }

            mostrar += "}";
            texto += mostrar;
        }
        System.out.println(mostrar());
        return texto;
    }

    public ArrayList<Ruta> getCaminos() {
        return rutas;
    }

    public void agregarCamino() {

    }

    public void DFS(Vertice inicio, Vertice destino, Camino caminoActual, ArrayList<Camino> todosCaminos) {
        caminoActual.agregarVertice(inicio);

        if (inicio == destino) {
            todosCaminos.add(caminoActual);
        } else {
            for (Arista arista : inicio.getAristas()) {
                if (!caminoActual.getVertices().contains(arista.getDestino())) {
                    DFS(arista.getDestino(), destino, caminoActual, todosCaminos);
                }
            }
        }

        caminoActual.getVertices().remove(caminoActual.getVertices().size() - 1);
    }

    public ArrayList<Camino> encontrarTodosCaminos(Vertice origen, Vertice destino) {
        ArrayList<Camino> todosCaminos = new ArrayList<>();
        Camino caminoActual = new Camino(origen);
        DFS(origen, destino, caminoActual, todosCaminos);
        return todosCaminos;
    }

    public int buscarVertichePorNombre(String nombre) {
        for (int i = 0; i < orden(); i++) {
            if (obtenerVertice(i).getVerticeName().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public void crearGrafoMarcado() {
        String texto = "digraph G\n"
                + "{\n"
                + "bgcolor=\"#D6D9DF\""
                + "node [shape = circle]\n"
                + "node [style = filled]\n"
                + "node [fillcolor = \"#EEEEEE\"]\n"
                + "node [color = \"#EEEEEE\"]\n"
                + "node [fontsize = 10]\n"
                + "node [height = 0.6]\n"
                + "node [width = 0.6]\n"
                + "edge [color = \"#00FFFF\"]\n";
    }

}
