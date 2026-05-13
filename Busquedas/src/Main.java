import java.util.Arrays;

public class Main {
    static int contador = 0;
    public static void main(String[] args) throws Exception {
        // String estadoInicial = "1238 4765";
        String estadoInicial = "1238 4765";
        System.out.println("Estado Inicial: " + estadoInicial);

        String[] sucesores = Puzzle8.generaSucesores(estadoInicial);

        System.out.println("Sucesores generados: " + Arrays.toString(sucesores));

        encontrarRutas(sucesores);
    }

    static void encontrarRutas(String[] sucesores) {
        for (String sucesor : sucesores) {
            if (sucesor.equals(Puzzle8.estadoFinal)) {
                System.out.println("¡Estado final alcanzado!");
                Puzzle8.imprimirHijos(new String[]{sucesor});
                System.exit(0);
            } else {
                System.out.println("Estado sucesor: " + sucesor);
                sucesores = Puzzle8.generaSucesores(sucesor);
                System.out.println("Sucesores generados: " + Arrays.toString(sucesores));
                // System.exit(0);

                if(sucesores != null) {
                    contador++;
                    System.out.println("Número de estados generados: " + contador);
                    if (contador > 3) {
                        contador = 0;
                        continue;
                    }
                    else {
                        encontrarRutas(sucesores);
                    }
                    
                    System.out.println("Volviendo al estado anterior: " + sucesor);
                }
            }
            
        }
        System.exit(0);
    }

}


// |1|2|3|
// |8| |4|
// |7|6|5|
