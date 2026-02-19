class Nodo {
    String estado;
    Nodo padre;
    int profundidad; // Número de transiciones desde el inicio

    public Nodo(String estado, Nodo padre, int profundidad) {
        this.estado = estado;
        this.padre = padre;
        this.profundidad = profundidad;
    }
}