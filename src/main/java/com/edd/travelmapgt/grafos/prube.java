package com.edd.travelmapgt.grafos;

import java.util.ArrayList;

class vert {
    int dato;
    ArrayList<arist> aristas;

    public vert(int dato) {
        this.dato = dato;
        aristas = new ArrayList<>();
    }
}

class arist {
    vert destino;
    rutea ruta;

    public arist(vert destino, rutea ruta) {
        this.destino = destino;
        this.ruta = ruta;
    }
}

class rutea {
    // Aquí puedes agregar los datos necesarios para el costo del camino, como distancia, tiempo, etc.
    // Por simplicidad, solo agregaremos un identificador de ruta.
    int id;

    public rutea(int id) {
        this.id = id;
    }
}

public class prube {
    ArrayList<vert> vertices;

    public prube() {
        vertices = new ArrayList<>();
    }

    public void agregarvert(int dato) {
        vertices.add(new vert(dato));
    }

    public void agregararist(vert origen, vert destino, rutea ruta) {
        origen.aristas.add(new arist(destino, ruta));
    }

    public void DFS(vert inicio, vert destino, ArrayList<vert> caminoActual, ArrayList<ArrayList<vert>> todosCaminos) {
        caminoActual.add(inicio);

        if (inicio == destino) {
            todosCaminos.add(new ArrayList<>(caminoActual));
        } else {
            for (arist arista : inicio.aristas) {
                if (!caminoActual.contains(arista.destino)) {
                    DFS(arista.destino, destino, caminoActual, todosCaminos);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }

    public ArrayList<ArrayList<vert>> encontrarTodosCaminos(vert origen, vert destino) {
        ArrayList<ArrayList<vert>> todosCaminos = new ArrayList<>();
        ArrayList<vert> caminoActual = new ArrayList<>();
        DFS(origen, destino, caminoActual, todosCaminos);
        return todosCaminos;
    }

    public static void main(String[] args) {
        prube grafo = new prube();
        
        // Agregar vértices
        vert a = new vert(1);
        vert b = new vert(2);
        vert c = new vert(3);
        grafo.agregarvert(a.dato);
        grafo.agregarvert(b.dato);
        grafo.agregarvert(c.dato);

        // Agregar aristas
        grafo.agregararist(a, b, new rutea(1));
        grafo.agregararist(b, c, new rutea(2));
        grafo.agregararist(a, c, new rutea(3));

        // Encontrar todos los caminos entre dos vértices
        vert origen = a;
        vert destino = c;
        ArrayList<ArrayList<vert>> todosCaminos = grafo.encontrarTodosCaminos(origen, destino);

        // Imprimir todos los caminos encontrados
        for (ArrayList<vert> camino : todosCaminos) {
            System.out.print("Camino: ");
            for (vert vertice : camino) {
                System.out.print(vertice.dato + " ");
            }
            System.out.println();
        }
    }
}