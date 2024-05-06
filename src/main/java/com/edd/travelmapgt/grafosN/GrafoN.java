package com.edd.travelmapgt.grafosN;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mgome
 */
public class GrafoN {

    private NodoGrafo primero;
    private NodoGrafo ultimo;
    private int tipoBusqueda;

    public GrafoN() {
        primero = null;
        ultimo = null;
        tipoBusqueda = -1;
    }

    public boolean vacio() {
        return primero == null;
    }

    public boolean existeVertice(Object dato) {
        boolean existe = false;
        if (!vacio()) {
            NodoGrafo temp = primero;
            while (temp != null && !existe) {
                if (temp.dato.toString().equals(dato.toString())) {
                    existe = true;
                }
                temp = temp.siguiente;
            }
        }
        return existe;
    }

    public void newArista(Object origen, Object destino) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo posicion = encontrarNodo(origen);
            posicion.la.nuevaAdy(destino);
        }
    }

    public void newArista(Object origen, Object destino, Peso peso) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoGrafo posicion = encontrarNodo(origen);
            posicion.la.nuevaAdy(destino, peso);
        }
    }

    public void nuevoNodo(Object dato) {
        if (!existeVertice(dato)) {
            NodoGrafo nuevoNodo = new NodoGrafo(dato);
            if (primero == null) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                ultimo.siguiente = nuevoNodo;
                ultimo = nuevoNodo;
            }
        }
    }

    public NodoGrafo encontrarNodo(Object dato) {
        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.dato.equals(dato.toString())) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public List<List<Object>> buscarCamino(Object inicio, Object destino, int tipo, boolean caminando) {
        List<List<Object>> todosLosCaminos = new ArrayList<>();
        Set<Object> visitados = new HashSet<>();
        List<Object> caminoActual = new ArrayList<>();
        List<List<Object>> caminosConPeso = new ArrayList<>();
        tipoBusqueda = tipo;
        buscarCaminoR(inicio, destino, visitados, caminoActual, todosLosCaminos, caminosConPeso, caminando);
        caminosConPeso.sort(Comparator.comparingDouble(this::calcularPeso));
        return caminosConPeso;
    }

    private double calcularPeso(List<Object> camino) {
        double pesoTotal = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            NodoGrafo nodoActual = encontrarNodo(camino.get(i));
            Arco arco = nodoActual.la.primero;
            while (arco != null) {
                if (arco.destino.equals(camino.get(i + 1))) {
                    switch (tipoBusqueda) {
                        case 1 -> {
                            pesoTotal += arco.peso.getGastoGasolina();
                        }
                        case 2 -> {
                            pesoTotal += arco.peso.getDesgaste();
                        }
                        case 3 -> {
                            pesoTotal += arco.peso.getDistancia();
                        }
                        case 4 -> {
                            pesoTotal += arco.peso.getGasolinaDistancia();
                        }
                        case 5 -> {
                            pesoTotal += arco.peso.getDesgasteDistancia();
                        }
                        default ->
                            throw new AssertionError();
                    }
                    break;
                }
                arco = arco.siguiente;
            }
        }
        return pesoTotal;
    }

    private void buscarCaminoR(Object actual, Object destino, Set<Object> visitados, List<Object> caminoActual, List<List<Object>> todosLosCaminos, List<List<Object>> caminosConPeso, boolean caminando) {
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual.equals(destino)) {
            todosLosCaminos.add(new ArrayList<>(caminoActual));
            caminosConPeso.add(new ArrayList<>(caminoActual));
        } else {
            NodoGrafo nodoActual = encontrarNodo(actual);
            Arco arcoActual = nodoActual.la.primero;
            while (arcoActual != null) {
                if (!visitados.contains(arcoActual.destino)) {
                    buscarCaminoR(arcoActual.destino, destino, visitados, caminoActual, todosLosCaminos, caminosConPeso, caminando);
                }
                if (caminando) {
                    NodoGrafo nodoDestino = encontrarNodo(arcoActual.destino);
                    Arco arcoOpuesto = nodoDestino.la.primero;
                    while (arcoOpuesto != null) {
                        if (arcoOpuesto.destino.equals(actual) && !visitados.contains(nodoDestino.dato)) {
                            buscarCaminoR(nodoDestino.dato, destino, visitados, caminoActual, todosLosCaminos, caminosConPeso, caminando);
                        }
                        arcoOpuesto = arcoOpuesto.siguiente;
                    }
                }
                arcoActual = arcoActual.siguiente;
            }
        }

        visitados.remove(actual);
        caminoActual.remove(caminoActual.size() - 1);
    }

    /*private void buscarCaminoR(Object actual, Object destino, Set<Object> visitados, List<Object> caminoActual, List<List<Object>> todosLosCaminos, List<List<Object>> caminosConPeso, boolean caminando) {
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual.equals(destino)) {
            todosLosCaminos.add(new ArrayList<>(caminoActual));
            caminosConPeso.add(new ArrayList<>(caminoActual));
        } else {
            NodoGrafo nodoActual = encontrarNodo(actual);
            Arco arcoActual = nodoActual.la.primero;
            while (arcoActual != null) {
                if (!visitados.contains(arcoActual.destino)) {
                    buscarCaminoR(arcoActual.destino, destino, visitados, caminoActual, todosLosCaminos, caminosConPeso, caminando);
                }
                arcoActual = arcoActual.siguiente;
            }
        }

        visitados.remove(actual);
        caminoActual.remove(caminoActual.size() - 1);
    }*/
    public String obtenerCodigoDot(boolean dirigido) {
        String mostrar = "";
        String texto = "";
        if (dirigido) {
            texto += " graph G\n";
        } else {
            texto += " digraph G\n";
        }
        texto += """
                       {
                       node [style = filled]
                       node [fillcolor = "#EEEEEE"]
                       node [color = "#EEEEEE"]
                       node [fontsize = 10]
                       layout=fdp
                       K=2
                       """;

        if (!vacio()) {
            NodoGrafo aux = primero;
            while (aux != null) {
                if (!aux.la.vacia()) {
                    Arco aux2 = aux.la.primero;
                    while (aux2 != null) {
                        mostrar += aux.dato.toString();
                        if (dirigido) {
                            mostrar += "--";
                        } else {
                            mostrar += "->";
                        }
                        mostrar += aux2.destino.toString() + "\n";
                        aux2 = aux2.siguiente;
                    }
                }
                aux = aux.siguiente;
            }

            mostrar += "}";
            texto += mostrar;
        }
        return texto;

    }

    public boolean dibujarGraphviz(String nombreArchivo, boolean dirigido) {
        String finalFile = "./dotFiles/" + nombreArchivo;
        try {
            String contenido = obtenerCodigoDot(dirigido);
            String finalPathDotFile = "./dotFiles/" + nombreArchivo + ".dot";
            File file = new File(finalPathDotFile);
            escribirArchivo(finalPathDotFile, contenido);

            MutableGraph mutableGrap = new Parser().read(file);
            if (dirigido) {
                finalFile += "c";
            }
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

    public boolean dibujarGraphvizCamino(String nombreArchivo, boolean dirigido, List<NodoGrafo> mejorCamino, List<NodoGrafo> peorCamino) {
        String finalFile = "./dotFiles/" + nombreArchivo + "caminos";
        try {
            String contenido = obtenerCodigoDotCamino(dirigido, mejorCamino, peorCamino);
            String finalPathDotFile = "./dotFiles/" + nombreArchivo + "caminos.dot";
            File file = new File(finalPathDotFile);
            escribirArchivo(finalPathDotFile, contenido);

            MutableGraph mutableGrap = new Parser().read(file);
            if (dirigido) {
                finalFile += "C";
            }
            Graphviz.fromGraph(mutableGrap).render(Format.PNG).toFile(new File(finalFile + ".png"));

            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public String obtenerCodigoDotCamino(boolean dirigido, List<NodoGrafo> mejorCamino, List<NodoGrafo> peorCamino) {
        String mostrar = "";
        String texto = "";
        boolean mejor = false;
        boolean peor = false;
        if (dirigido) {
            texto += " graph G\n";
        } else {
            texto += " digraph G\n";
        }
        texto += """
                       {
                       node [style = filled]
                       node [fillcolor = "#EEEEEE"]
                       node [color = "#EEEEEE"]
                       node [fontsize = 10]
                       layout=fdp
                       K=2
                       """;

        if (!vacio()) {
            NodoGrafo aux = primero;
            while (aux != null) {
                if (!aux.la.vacia()) {
                    Arco aux2 = aux.la.primero;
                    while (aux2 != null) {
                        mostrar += aux.dato.toString();
                        if (dirigido) {
                            mostrar += "--";
                        } else {
                            mostrar += "->";
                        }

                        mostrar += aux2.destino.toString();

                        mejor = false;
                        peor = false;

                        for (int i = 0; i < mejorCamino.size(); i++) {
                            if (mejorCamino.get(i).dato.toString().equals(aux.dato.toString())) {
                                if (mejorCamino.get(i).la.primero.destino.toString().equals(aux2.destino.toString())) {
                                    mejor = true;
                                }
                            }
                        }
                        for (int i = 0; i < peorCamino.size(); i++) {
                            if (peorCamino.get(i).dato.toString().equals(aux.dato.toString())) {
                                if (peorCamino.get(i).la.primero.destino.toString().equals(aux2.destino.toString())) {
                                    peor = true;
                                }
                            }
                        }

                        if (mejor && peor) {
                            mostrar += "[color=\"teal:red\"]";
                        } else if (mejor) {
                            mostrar += "[color=\"teal\"]";
                        } else if (peor) {
                            mostrar += "[color=\"red\"]";
                        }

                        mostrar += "\n";

                        aux2 = aux2.siguiente;
                    }
                }
                aux = aux.siguiente;
            }

            mostrar += "}";
            texto += mostrar;
        }
        return texto;

    }

    public NodoGrafo getPrimero() {
        return primero;
    }

    public NodoGrafo getUltimo() {
        return ultimo;
    }

    @Override
    public String toString() {
        String cadena = "";
        NodoGrafo temp = primero;
        while (temp != null) {
            cadena += temp.dato.toString() + "  ->  " + temp.la.toString();
            temp = temp.siguiente;
        }
        return cadena;
    }

}
