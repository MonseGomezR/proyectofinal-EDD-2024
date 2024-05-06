package com.edd.travelmapgt;

/**
 *
 * @author mgome
 */
public class Nodo {
    
    private Nodo izquierda;
    private Nodo derecha;
    private int valor;
    
    public void insertarHijo (Nodo hijo) {
        if (hijo.getValor() < this.valor) {
            if (this.izquierda != null) {
                izquierda.insertarHijo(hijo);
            } else {
                izquierda = hijo;
            }
        } else {
            if (derecha != null) {
                derecha.insertarHijo(hijo);
            } else {
                derecha = hijo;
            }
        }
    }
    
    public void enOrden() {
        if(izquierda != null) {
            izquierda.enOrden();
        }
        
        System.out.println(valor);
        
        if(derecha != null) {
            derecha.enOrden();
        }
    }
    
    public void preOrden() {
        System.out.println(valor);
        if(izquierda != null) {
            izquierda.preOrden();
        }
        if(derecha != null) {
            derecha.preOrden();
        }
    }
    
    public void postOrden() {
        if(izquierda != null) {
            izquierda.postOrden();
        }
        if(derecha != null) {
            derecha.postOrden();
        }
        System.out.println(valor);
    }
    
    public String textoGraphviz() {
        if(izquierda == null && derecha == null) {
            return String.valueOf(valor);
        } else {
            String texto = "";
            if(izquierda != null) {
                texto = valor + "->" + izquierda.textoGraphviz() + "\n";
            }
            if(derecha != null) {
                texto += valor + "->" + derecha.textoGraphviz() + "\n";
            }
            return texto;
        }
    }

    /**
     * @return el nodo izquierdo
     */
    public Nodo getIzquierda () {
        return izquierda;
    }

    /**
     * @return el nodo derecho
     */
    public Nodo getDerecha() {
        return derecha;
    }

    /**
     * @return el valor del nodo
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param izquierda el nodo izquierda a insertar
     */
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @param derecha el nodo derecha a insertar
     */
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    /**
     * @param valor el valor del nodo a insertar
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
