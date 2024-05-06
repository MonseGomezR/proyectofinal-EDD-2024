package com.edd.travelmapgt.grafos;

import java.util.ArrayList;

/**
 *
 * @author mgome
 */
public interface Grafo<T> {
    void insertarVertice(T x);
    int buscarVertichePorNombre(String nombre);
    T obtenerVertice(int pos);
    void insertarArista(int vInicio, int vFinal, int costo);
    int costoArista(int vInicio, int vFinal);
    int orden();
    ArrayList<T> sucesores(int pos);
    ArrayList<Ruta> getCaminos();
    String mostrar();
    boolean dibujarGraphviz();
    void agregarCamino();
    void buscarCamino(String origen, String destino);
    int inf=99999;
}
