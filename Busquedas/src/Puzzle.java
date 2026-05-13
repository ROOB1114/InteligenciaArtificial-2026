public class Puzzle {
    public static void main(String[] args) {
        Nodo n;
        String estadoInicial = "5674 8321";
        System.err.println("\nEstado Inicial: " + estadoInicial);
        Puzzle8.imprimirHijos(new String[]{estadoInicial});
        // TODO: El estado objetivo "12345678 " Genera un error nullPointException
        // (el arbol de busqueda regresa null), Puede que sea desbordamiento de memoria o simplemente no encuentra el estado objetivo
        // Pasa con los 3 metodos de busqueda que tenemos implementados actualmente.
        // String estadoObjetivo = "12345678 ";
        String estadoObjetivo = "1238 4765";
        System.err.println("Estado Objetivo: " + estadoObjetivo);
        Puzzle8.imprimirHijos(new String[]{estadoObjetivo});

        ArbolDeBusqueda arbol = new ArbolDeBusqueda(new Nodo(estadoInicial));
        // n = arbol.busquedaPrimeroAnchura(estadoObjetivo);
        // n = arbol.busquedaEnProfundidad(estadoObjetivo);
        // n = arbol.busquedaPorCostoUniforme(estadoObjetivo);
        n = arbol.busquedaPorCostoUniformeHeuristica(estadoObjetivo);

        Puzzle8.imprimirHijos(new String[]{n.estado});
        System.out.println("Nivel: " + n.nivel);
        System.out.println("Ruta desde el estado inicial hasta estado objetivo:");
        imprimirRuta(n);
        System.out.println("Estados visitados: " + ArbolDeBusqueda.visitados.size());

    }

    // static void imprimirRuta(Nodo nodo) {
    //     if (nodo.padre != null) {
    //         // Puzzle8.imprimirHijos(new String[]{nodo.padre.estado});
    //         imprimirRuta(nodo.padre);
    //     } else {
    //         System.out.println("Estado inicial: " + nodo.estado);
    //     }
    //     System.out.println("Nivel: " + nodo.nivel);
    //     System.out.println("Costo total: " + nodo.costoTotal);
    //     Puzzle8.imprimirHijos(new String[]{nodo.estado});
    // }

    static void imprimirRuta(Nodo nodo) { // Se cambió por un método que imprima mediante ciclos para evitar que la recursividad desborde la pila de llamadas
        java.util.Stack<Nodo> pila = new java.util.Stack<>();
        Nodo actual = nodo;

        while (actual != null) {
            pila.push(actual);
            actual = actual.padre;
        }

        while (!pila.isEmpty()) {
            Nodo paso = pila.pop();
            
            if (paso.padre == null) {
                System.out.println("Estado inicial: " + paso.estado);
            }
            
            System.out.println("Nivel: " + paso.nivel);
            System.out.println("Costo total: " + paso.costoTotal);
            Puzzle8.imprimirHijos(new String[]{paso.estado});
        }
    }
    
}
