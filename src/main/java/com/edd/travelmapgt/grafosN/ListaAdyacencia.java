package com.edd.travelmapgt.grafosN;

/**
 *
 * @author mgome
 */
public class ListaAdyacencia {

    Arco primero;
    Arco ultimo;

    public ListaAdyacencia() {
        primero = null;
        ultimo = null;
    }

    public boolean vacia() {
        return primero == null;
    }

    public boolean adyacente(Object dato) {
        Arco actual = primero;
        while (actual != null) {
            if (actual.destino.toString().equals(dato.toString())) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void nuevaAdy(Object destino) {
        if (!adyacente(destino)) {
            insertar(new Arco(destino));
        }
    }

    public void nuevaAdy(Object destino, Peso peso) {
        if (!adyacente(destino)) {
            insertar(new Arco(destino, peso));
        }
    }

    public void insertar(Arco nodo) {
        if (primero == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.siguiente = nodo;
            ultimo = nodo;
        }
    }

    @Override
    public String toString() {
        String cadena = "";
        Arco temp = primero;
        while (temp != null) {
            cadena += temp.destino.toString() + "   ;   ";
            temp = temp.siguiente;
        }
        return cadena;
    }

}
