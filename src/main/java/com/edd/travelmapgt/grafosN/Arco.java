package com.edd.travelmapgt.grafosN;

/**
 *
 * @author mgome
 */
public class Arco {
    Object destino;
    Peso peso;
    Arco siguiente;

    public Arco(Object destino) {
        this.destino = destino;
        this.siguiente = null;
    }

    public Arco(Object destino, Peso peso) {
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;
    }
    
    
    
}
