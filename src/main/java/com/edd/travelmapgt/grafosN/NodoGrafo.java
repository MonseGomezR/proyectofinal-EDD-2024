package com.edd.travelmapgt.grafosN;

/**
 *
 * @author mgome
 */
public class NodoGrafo {
    public Object dato;
    public ListaAdyacencia la;
    public NodoGrafo siguiente;

    public NodoGrafo(Object dato) {
        this.dato = dato;
        this.la = new ListaAdyacencia();
        this.siguiente = null;
    }
    
    
}
