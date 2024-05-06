package com.edd.travelmapgt.grafos;

import java.util.ArrayList;

/**
 *
 * @author mgome
 * @param 
 */
    public class Vertice {
    private String verticeName;
    private ArrayList<Arista> aristas;
    public int id;

    public Vertice(String vertice, int id) {
        this.verticeName = vertice;
        this.id = id;
        this.aristas = new ArrayList<>();
    }

    public void agregarArista(Arista arista) {
        aristas.add(arista);
    }

    public Arista obtenerArista(String destino) {
        for (Arista arista : aristas) {
            if (arista.getDestino().getVerticeName().equals(destino)) {
                return arista;
            }
        }
        return null;
    }

    public String getVerticeName() {
        return verticeName;
    }

    public void setVerticeName(String verticeName) {
        this.verticeName = verticeName;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }
    
}
