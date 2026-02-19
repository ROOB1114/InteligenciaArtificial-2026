import java.util.*;

public class Main {
    public static void main(String[] args) {
        Puzzle8 puzzle = new Puzzle8();
        
        // EJEMPLO:
        String estadoInicial = "1238 4765";
        String estadoObjetivo = "123478 65";

        // ---------------------------------------------------------
        // ***TIPO DE BÚSQUEDA AQUÍ ***
        // 1 = Anchura (BFS) -> Lento, halla el óptimo.
        // 2 = Profundidad (DFS) -> Rápido, halla solución larga.
        // 3 = Prioridad (A*) -> Inteligente, halla óptimo rápido.
        // ---------------------------------------------------------
        int tipoBusqueda = 1; 
        // ---------------------------------------------------------

        System.out.println("Estado Inicial: [" + estadoInicial + "]");
        System.out.println("Estado Objetivo: [" + estadoObjetivo + "]");
        System.out.println("---------------------------------------");

        switch (tipoBusqueda) {
            case 1:
                System.out.println("Iniciando Busqueda por Anchura (BFS)...");
                puzzle.busquedaAnchura(estadoInicial, estadoObjetivo);
                break;
            case 2:
                System.out.println("Iniciando Busqueda por Profundidad (DFS)...");
                puzzle.busquedaProfundidad(estadoInicial, estadoObjetivo);
                break;
            case 3:
                System.out.println("Iniciando Busqueda por Prioridad (A*)...");
                puzzle.busquedaPrioridad(estadoInicial, estadoObjetivo);
                break;
            default:
                System.out.println("Opcion no válida");
        }
    }
}


class Nodo implements Comparable<Nodo> {
    String estado;
    Nodo padre;
    int costoG;      // Costo del camino desde el inicio (profundidad)
    int costoH;      // Heurística (estimación a la meta)
    int costoF;      // Costo Total (F = G + H)

    public Nodo(String estado, Nodo padre, int g, int h) {
        this.estado = estado;
        this.padre = padre;
        this.costoG = g;
        this.costoH = h;
        this.costoF = g + h;
    }

    // Para la cola de prioridad (ordena de menor a mayor costo F)
    @Override
    public int compareTo(Nodo otro) {
        return Integer.compare(this.costoF, otro.costoF);
    }
}

class Puzzle8 {

    // 1. ANCHURA (Queue)
    public void busquedaAnchura(String inicial, String objetivo) {
        Queue<Nodo> frontera = new LinkedList<>();
        ejecutarBusqueda(frontera, inicial, objetivo);
    }

    // 2. PROFUNDIDAD (Stack)
    public void busquedaProfundidad(String inicial, String objetivo) {
        Stack<Nodo> frontera = new Stack<>();
        ejecutarBusqueda(frontera, inicial, objetivo);
    }

    // 3. PRIORIDAD (PriorityQueue)
    public void busquedaPrioridad(String inicial, String objetivo) {
        PriorityQueue<Nodo> frontera = new PriorityQueue<>();
        ejecutarBusqueda(frontera, inicial, objetivo);
    }

    // --- ALGORITMO GENÉRICO ---
    private void ejecutarBusqueda(Collection<Nodo> frontera, String inicial, String objetivo) {
        HashSet<String> visitados = new HashSet<>();
        
        int h = contarPiezasMalColocadas(inicial, objetivo);
        Nodo raiz = new Nodo(inicial, null, 0, h);
        
        frontera.add(raiz);
        visitados.add(inicial);

        int nodosPopped = 0; // Contador de nodos sacados de la cola

        while (!frontera.isEmpty()) {
            Nodo actual;

            // Extraer nodo según la estructura de datos
            if (frontera instanceof Queue) {
                // Para Anchura y Prioridad
                actual = ((Queue<Nodo>) frontera).poll(); 
            } else {
                // Para Profundidad (Stack)
                actual = ((Stack<Nodo>) frontera).pop();  
            }
            
            nodosPopped++; // Contador del nodo extraído!

            // VERIFICAR META
            if (actual.estado.equals(objetivo)) {
                imprimirEstadisticas(actual, nodosPopped, visitados.size());
                return;
            }

            // EXPANDIR HIJOS
            for (String estadoHijo : generarSucesores(actual.estado)) {
                if (!visitados.contains(estadoHijo)) {
                    visitados.add(estadoHijo);
                    
                    int nuevoG = actual.costoG + 1; // Costo aumenta en 1 por nivel
                    int nuevoH = contarPiezasMalColocadas(estadoHijo, objetivo);
                    
                    Nodo hijo = new Nodo(estadoHijo, actual, nuevoG, nuevoH);
                    frontera.add(hijo);
                }
            }
        }
        System.out.println("Frontera vacía. No se encontró solución.");
    }

    private void imprimirEstadisticas(Nodo meta, int nodosPopped, int visitadosTotales) {
        System.out.println("\nSOLUCION ENCONTRADA");
        System.out.println("==========================================");
        System.out.println("Costo de la solucion (Pasos/Nivel): " + meta.costoG);
        System.out.println("Nodos sacados de la queue (Popped): " + nodosPopped);
        System.out.println("Estados unicos generados (Visitados): " + visitadosTotales);
        System.out.println("==========================================");
        
        // Reconstruir camino
        LinkedList<String> camino = new LinkedList<>();
        Nodo temp = meta;
        while(temp != null){
            camino.addFirst(temp.estado);
            temp = temp.padre;
        }
        
        System.out.println("Camino (" + camino.size() + " estados):");
        int i = 0;
        for(String est : camino) {
            i++;
            System.out.println( i + ". -> [" + est + "]");
        }
    }

    // Heurística simple (Piezas fuera de lugar)
    private int contarPiezasMalColocadas(String actual, String objetivo) {
        int count = 0;
        for (int i = 0; i < actual.length(); i++) {
            if (actual.charAt(i) != ' ' && actual.charAt(i) != objetivo.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    // Generar movimientos
    private List<String> generarSucesores(String estado) {
        List<String> sucesores = new ArrayList<>();
        int i = estado.indexOf(" ");
        // Matriz de movimientos válidos
        int[][] movimientos = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8},
            {3, 7}, {4, 6, 8}, {5, 7}
        };
        for (int nuevoIndice : movimientos[i]) {
            sucesores.add(intercambiar(estado, i, nuevoIndice));
        }
        return sucesores;
    }

    private String intercambiar(String estado, int i, int j) {
        char[] chars = estado.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}