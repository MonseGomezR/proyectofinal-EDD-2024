package com.edd.travelmapgt.grafos;

/**
 *
 * @author mgome
 * @param 
 */
public class Arista {
    private Vertice destino;
    private Ruta ruta;

    public Arista(Vertice destino, Ruta ruta) {
        this.destino = destino;
        this.ruta = ruta;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    
    
}
