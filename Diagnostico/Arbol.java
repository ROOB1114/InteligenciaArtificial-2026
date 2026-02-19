class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    // Método solicitado: Verifica si el árbol no tiene raíz
    public boolean vacio() {
        return this.raiz == null;
    }

    // Método solicitado: Busca un nodo por su nombre
    public Nodo buscarNodo(String nombre) {
        return buscarRecursivo(this.raiz, nombre);
    }

    // Lógica interna de búsqueda (BST)
    private Nodo buscarRecursivo(Nodo actual, String nombre) {
        // Caso base: no encontrado o encontrado con éxito
        if (actual == null || actual.nombre.equals(nombre)) {
            return actual;
        }

        // En Java usamos compareTo para comparar Strings alfabéticamente
        // Si resultado < 0, nombre es menor; si > 0, es mayor.
        if (nombre.compareTo(actual.nombre) < 0) {
            return buscarRecursivo(actual.izquierdo, nombre);
        }

        return buscarRecursivo(actual.derecho, nombre);
    }

    // Método auxiliar para insertar nodos y probar el árbol
    public void insertar(String nombre) {
        this.raiz = insertarRecursivo(this.raiz, nombre);
    }

    private Nodo insertarRecursivo(Nodo actual, String nombre) {
        if (actual == null) {
            return new Nodo(nombre);
        }

        if (nombre.compareTo(actual.nombre) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, nombre);
        } else if (nombre.compareTo(actual.nombre) > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, nombre);
        }
        return actual;
    }
}