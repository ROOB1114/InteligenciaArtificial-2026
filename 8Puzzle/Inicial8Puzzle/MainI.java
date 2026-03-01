public class MainI {
    public static void main(String[] args) {
        Puzzle8I puzzle = new Puzzle8I();
        
        // EJEMPLO: 
        // Estado Inicial (el espacio es ' ')
        String estadoInicial = "1238 4765"; 
        // Estado Objetivo
        String estadoObjetivo = "123478 65"; 

        System.out.println("--- INICIO DEL REPORTE ---");
        puzzle.buscarSolucion(estadoInicial, estadoObjetivo);
    }
}