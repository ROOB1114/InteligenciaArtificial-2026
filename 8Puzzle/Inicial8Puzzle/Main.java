public class Main {
    public static void main(String[] args) {
        Puzzle8 puzzle = new Puzzle8();
        
        // EJEMPLO: 
        // Estado Inicial (el espacio es ' ')
        String estadoInicial = "1238 4765"; 
        // Estado Objetivo
        String estadoObjetivo = "123478 65"; 

        System.out.println("--- INICIO DEL REPORTE ---");
        puzzle.buscarSolucion(estadoInicial, estadoObjetivo);
    }
}