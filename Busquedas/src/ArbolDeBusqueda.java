import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ArbolDeBusqueda {
    Nodo raiz = new Nodo("1238 4765"); // Estado inicial del puzzle8
    public static HashSet<String> visitados = new HashSet<>();

    public ArbolDeBusqueda(Nodo raiz) {
        this.raiz = raiz;
    }

    Nodo busquedaPrimeroAnchura(String estadoObjetivo) {
        if (raiz == null) 
            return null;


        Queue<Nodo> cola = new LinkedList<>();
        Nodo actual;
        cola.add(raiz);
        while(!cola.isEmpty()) {
            actual = cola.poll();
            if(actual.estado.equals(estadoObjetivo)) {
                return actual;
            } else {
                List<Nodo> sucesores = actual.getSucesores();
                for (Nodo sucesor : sucesores) {
                    if (!visitados.contains(sucesor.estado)) {
                        sucesor.setCostoTotal(actual.getCostoTotal() + Character.getNumericValue(sucesor.estado.charAt(actual.estado.indexOf(' '))));
                        cola.add(sucesor);
                        visitados.add(sucesor.estado);
                    }
                }
            }
        }
        return null;
    }

    Nodo busquedaEnProfundidad(String estadoObjetivo) {
        if (raiz == null) 
            return null;


        Stack<Nodo> pila = new Stack<>();
        Nodo actual;
        pila.add(raiz);
        while(!pila.isEmpty()) {
            actual = pila.pop();
            if(actual.estado.equals(estadoObjetivo)) {
                return actual;
            } else {
                List<Nodo> sucesores = actual.getSucesores();
                for (Nodo sucesor : sucesores) {
                    if (!visitados.contains(sucesor.estado)) {
                        sucesor.setCostoTotal(actual.getCostoTotal() + Character.getNumericValue(sucesor.estado.charAt(actual.estado.indexOf(' '))));
                        pila.add(sucesor);
                        visitados.add(sucesor.estado);
                    }
                }
            }
        }
        return null;
    }

    Nodo busquedaPorCostoUniforme(String estadoObjetivo) {
        if (raiz == null) 
            return null;

        NodoComparadorPorPrioridad comparador = new NodoComparadorPorPrioridad();
        PriorityQueue<Nodo> cola = new PriorityQueue<>(10, comparador);

        Nodo actual;
        cola.add(raiz);
        while(!cola.isEmpty()) {
            actual = cola.poll();
            if(actual.estado.equals(estadoObjetivo)) {
                return actual;
            } else {
                if (visitados.contains(actual.estado))
                    continue;
                
                visitados.add(actual.estado);
                List<Nodo> sucesores = actual.getSucesores();
                for (Nodo sucesor : sucesores) {
                    if (!visitados.contains(sucesor.estado)) {
                        sucesor.setCostoTotal(actual.getCostoTotal() + Character.getNumericValue(sucesor.estado.charAt(actual.estado.indexOf(' '))));
                        cola.add(sucesor);
                    }
                }
            }
        }
        return null;
    }

    Nodo busquedaPorCostoUniformeHeuristica(String estadoObjetivo) {
        if (raiz == null) 
            return null;

        NodoComparadorPorPrioridad comparador = new NodoComparadorPorPrioridad();
        PriorityQueue<Nodo> cola = new PriorityQueue<>(10, comparador);

        Nodo actual;
        cola.add(raiz);
        while(!cola.isEmpty()) {
            actual = cola.poll();
            if(actual.estado.equals(estadoObjetivo)) {
                return actual;
            } else {
                if (visitados.contains(actual.estado))
                    continue;
                
                visitados.add(actual.estado);
                List<Nodo> sucesores = actual.getSucesores();
                for (Nodo sucesor : sucesores) {
                    if (!visitados.contains(sucesor.estado)) {
                        sucesor.setCostoTotal(
                            actual.getCostoTotal() + 0 +
                            heuristicTwo(sucesor.estado, estadoObjetivo)
                        );
                        cola.add(sucesor);
                    }
                }
            }
        }
        return null;
    }

        // TODO: Implementar heuristica para busqueda por costo uniforme.
    // Example code del profesor:
    private int heuristicOne(String currentState, String goalSate) { // Hamming distance
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            if (currentState.charAt(i) != goalSate.charAt(i))
                difference += 1;
        return difference;
    }
    
    // La heuristica puede ser libre, por lo que se me ocurre usar las 4 esquinas del puzzle.

    private static int heuristic(String currentState, String goalState) {
        int difference = 0;
        if (currentState.charAt(0) != goalState.charAt(0))
            difference += 1;
        if (currentState.charAt(2) != goalState.charAt(2))
            difference += 1;
        if (currentState.charAt(6) != goalState.charAt(6))
            difference += 1;
        if (currentState.charAt(8) != goalState.charAt(8))
            difference += 1;
        return difference;
    }
    // "012345678"
    // |0|1|2|
    // |3|4|5|
    // |6|7|8|

    private int heuristicTwo(String currentState, String goalSate) { // Manhattan distance
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            for (int j = 0; j < goalSate.length(); j += 1)
                if (currentState.charAt(i) == goalSate.charAt(j))
                    difference = difference + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 + j / 3));
        return difference;
    }

    private int heuristicThree(String currentState, String goalSate) { // Conflicto Lineal + Manhattan distance
        int difference = 0;
        int manhattanDistance = 0;
        for (int i = 0; i < currentState.length(); i += 1)
        {
            for (int j = 0; j < goalSate.length(); j += 1)
            {
                if (currentState.charAt(i) == goalSate.charAt(j))
                    manhattanDistance = (Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 + j / 3);
            }
        }
        difference = difference + 2 * manhattanDistance - 1;
        return difference;
    }
    
}
