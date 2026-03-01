class NodoI {
    String estado;
    NodoI padre;
    int profundidad; // Número de transiciones desde el inicio

    public NodoI(String estado, NodoI padre, int profundidad) {
        this.estado = estado;
        this.padre = padre;
        this.profundidad = profundidad;
    }
}