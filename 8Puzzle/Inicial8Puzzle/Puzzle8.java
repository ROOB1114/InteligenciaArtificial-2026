import java.util.*;

class Puzzle8 {

    public void buscarSolucion(String estadoInicial, String estadoObjetivo) {
        Queue<Nodo> cola = new LinkedList<>();
        HashSet<String> visitados = new HashSet<>();

        // El nodo raíz tiene profundidad 0 (0 transiciones)
        Nodo raiz = new Nodo(estadoInicial, null, 0);
        
        cola.add(raiz);
        visitados.add(estadoInicial);

        int nodosExplorados = 0; // Contador de estados visitados (sacados de la cola)

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            nodosExplorados++; // Aumentamos contador al procesar un nodo

            // --- VERIFICACIÓN DE META ---
            if (actual.estado.equals(estadoObjetivo)) {
                System.out.println("SOLUCION ENCONTRADA");
                System.out.println("--------------------------------");
                System.out.println("Numero de transiciones (pasos): " + actual.profundidad);
                System.out.println("Numero de estados visitados:    " + nodosExplorados);
                System.out.println("Total de estados en memoria:    " + visitados.size());
                System.out.println("--------------------------------");
                
                imprimirCamino(actual);
                return;
            }
            // -----------------------------

            List<String> hijos = generarSucesores(actual.estado);
            for (String hijoEstado : hijos) {
                if (!visitados.contains(hijoEstado)) {
                    visitados.add(hijoEstado);
                    // El hijo tiene la profundidad del padre + 1
                    cola.add(new Nodo(hijoEstado, actual, actual.profundidad + 1));
                }
            }
        }
        System.out.println("No se encontró solución.");
    }

    // Generación de sucesores (igual que antes)
    List<String> generarSucesores(String estado) {
        List<String> sucesores = new ArrayList<>();
        int i = estado.indexOf(" "); 

        // Movimientos posibles según la posición del espacio
        switch (i) {
            case 0: sucesores.add(intercambiar(estado, 0, 1)); sucesores.add(intercambiar(estado, 0, 3)); break;
            case 1: sucesores.add(intercambiar(estado, 1, 0)); sucesores.add(intercambiar(estado, 1, 2)); sucesores.add(intercambiar(estado, 1, 4)); break;
            case 2: sucesores.add(intercambiar(estado, 2, 1)); sucesores.add(intercambiar(estado, 2, 5)); break;
            case 3: sucesores.add(intercambiar(estado, 3, 0)); sucesores.add(intercambiar(estado, 3, 4)); sucesores.add(intercambiar(estado, 3, 6)); break;
            case 4: sucesores.add(intercambiar(estado, 4, 1)); sucesores.add(intercambiar(estado, 4, 3)); sucesores.add(intercambiar(estado, 4, 5)); sucesores.add(intercambiar(estado, 4, 7)); break;
            case 5: sucesores.add(intercambiar(estado, 5, 2)); sucesores.add(intercambiar(estado, 5, 4)); sucesores.add(intercambiar(estado, 5, 8)); break;
            case 6: sucesores.add(intercambiar(estado, 6, 3)); sucesores.add(intercambiar(estado, 6, 7)); break;
            case 7: sucesores.add(intercambiar(estado, 7, 4)); sucesores.add(intercambiar(estado, 7, 6)); sucesores.add(intercambiar(estado, 7, 8)); break;
            case 8: sucesores.add(intercambiar(estado, 8, 5)); sucesores.add(intercambiar(estado, 8, 7)); break;
        }
        return sucesores;
    }

    private String intercambiar(String estado, int i, int j) {
        char[] caracteres = estado.toCharArray();
        char temp = caracteres[i];
        caracteres[i] = caracteres[j];
        caracteres[j] = temp;
        return new String(caracteres);
    }

    private void imprimirCamino(Nodo nodo) {
        LinkedList<Nodo> camino = new LinkedList<>();
        Nodo aux = nodo;
        while (aux != null) {
            camino.addFirst(aux);
            aux = aux.padre;
        }

        System.out.println("Detalle del camino:");
        for (Nodo n : camino) {
            System.out.println("Paso " + n.profundidad + ": " + n.estado);
        }
    }
}