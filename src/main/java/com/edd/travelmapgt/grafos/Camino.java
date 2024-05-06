package com.edd.travelmapgt.grafos;

import java.util.ArrayList;


public class Camino {
    private ArrayList<Vertice> vertices;
    private Vertice inicio;

    public Camino(Vertice inicio) {
        this.inicio = inicio;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void agregarVertice(Vertice v) {
        vertices.add(v);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertice vertice : vertices) {
            sb.append(vertice.getVerticeName()).append(" ");
        }
        return sb.toString();
    }
    
}
