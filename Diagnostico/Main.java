public class Main {
    public static void main(String[] args) {
        Arbol miArbol = new Arbol();

        System.out.println("Esta vacio? " + miArbol.vacio()); // true

        miArbol.insertar("Marta");
        miArbol.insertar("Alberto");
        miArbol.insertar("Zaira");

        Nodo resultado = miArbol.buscarNodo("Alberto");
        
        if (resultado != null) {
            System.out.println("Nodo encontrado: " + resultado.nombre);
        } else {
            System.out.println("Nodo no encontrado.");
        }
    }
}