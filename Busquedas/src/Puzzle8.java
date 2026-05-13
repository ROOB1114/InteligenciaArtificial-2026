public class Puzzle8 {
    static final String estadoFinal = "12 843765";

    // String[]
    static String[] generaSucesores(String estadoActual) {
        int indice = estadoActual.indexOf(" ");
        String[] hijos = null;
        String hijo1, hijo2, hijo3, hijo4;
        switch(indice) {
            case 0 -> { // Genera 2 
                hijo1 = estadoActual.substring(1,2) + estadoActual.charAt(0)+ estadoActual.substring(2);
                hijo2 = estadoActual.charAt(3) + estadoActual.substring(1,3) + estadoActual.charAt(0) + estadoActual.substring(4);
                // imprimirHijos(hijo1, hijo2);
                hijos = new String[]{hijo1, hijo2};
            }
            case 1 -> { // Genera 3 
                hijo1 = estadoActual.charAt(1) + estadoActual.substring(0, 1) + estadoActual.substring(2);
                hijo3 = estadoActual.substring(0, 1) + estadoActual.charAt(4) + estadoActual.substring(2,4) + estadoActual.charAt(1) + estadoActual.substring(5);
                hijo2 = estadoActual.substring(0, 1) + estadoActual.charAt(2) + estadoActual.charAt(1) + estadoActual.substring(3);
                // imprimirHijos(hijo1, hijo2, hijo3);
                hijos = new String[]{hijo1, hijo2, hijo3};
            }
            case 2 -> { // Genera 2
                hijo1 = estadoActual.substring(0,2) + estadoActual.charAt(5) + estadoActual.substring(3, 5) + estadoActual.charAt(2) + estadoActual.substring(6);
                hijo2 = estadoActual.substring(0,1) + estadoActual.charAt(2) + estadoActual.charAt(1) + estadoActual.substring(3);
                // imprimirHijos(hijo1, hijo2);
                hijos = new String[]{hijo1, hijo2};
            }
            case 3 -> { // Genera 3
                hijo1 = estadoActual.substring(3,4) + estadoActual.substring(1, 3) + estadoActual.charAt(0) + estadoActual.substring(4);
                hijo2 = estadoActual.substring(0, 3) + estadoActual.charAt(4) + estadoActual.charAt(3) + estadoActual.substring(5);
                hijo3 = estadoActual.substring(0,3) + estadoActual.charAt(6) + estadoActual.substring(4, 6) + estadoActual.charAt(3) + estadoActual.substring(7);
                // imprimirHijos(hijo1, hijo2, hijo3);
                hijos = new String[]{hijo1, hijo2, hijo3};
            }
            case 4 -> { // Genera 4
                hijo1 = estadoActual.substring(0, 1) + estadoActual.charAt(4) + estadoActual.substring(2,4) + estadoActual.charAt(1) + estadoActual.substring(5);
                hijo2 = estadoActual.substring(0, 4) + estadoActual.charAt(5) + estadoActual.charAt(4) + estadoActual.substring(6);
                hijo3 = estadoActual.substring(0, 4) + estadoActual.charAt(7) + estadoActual.substring(5,7) + estadoActual.charAt(4) + estadoActual.substring(8);
                hijo4 = estadoActual.substring(0,3) + estadoActual.charAt(4) + estadoActual.charAt(3) + estadoActual.substring(5);
                // imprimirHijos(hijo2, hijo1, hijo3, hijo4);
                hijos = new String[]{hijo1, hijo2, hijo3, hijo4}; // Orden distinto para llegar al resultado esperado en menos iteraciones 
            }
            case 5 -> { // Genera 3
                hijo1 = estadoActual.substring(0, 2) + estadoActual.charAt(5) + estadoActual.substring(3, 5) + estadoActual.charAt(2) + estadoActual.substring(6);
                hijo2 = estadoActual.substring(0, 5) + estadoActual.charAt(8) + estadoActual.substring(6,8) + estadoActual.charAt(5) + estadoActual.substring(9);
                hijo3 = estadoActual.substring(0, 4) + estadoActual.charAt(5) + estadoActual.charAt(4) + estadoActual.substring(6);
                // imprimirHijos(hijo1, hijo2, hijo3);
                hijos = new String[]{hijo1, hijo2, hijo3};
            }
            case 6 -> { // Genera 2
                hijo1 = estadoActual.substring(0,3) + estadoActual.charAt(6) + estadoActual.substring(4, 6) + estadoActual.charAt(3) + estadoActual.substring(7);
                hijo2 = estadoActual.substring(0, 6) + estadoActual.charAt(7) + estadoActual.charAt(6) + estadoActual.substring(8);
                // imprimirHijos(hijo1, hijo2);
                hijos = new String[]{hijo1, hijo2};
            }
            case 7 -> { // Genera 3
                hijo1 = estadoActual.substring(0, 4) + estadoActual.charAt(7) + estadoActual.substring(5,7) + estadoActual.charAt(4) + estadoActual.substring(8);
                hijo2 = estadoActual.substring(0, 6) + estadoActual.charAt(7) + estadoActual.charAt(6) + estadoActual.substring(8);
                hijo3 = estadoActual.substring(0, 7) + estadoActual.charAt(8) + estadoActual.charAt(7) + estadoActual.substring(9);
                // imprimirHijos(hijo1, hijo2, hijo3);
                hijos = new String[]{hijo1, hijo2, hijo3};
            }
            case 8 -> { // Genera 2
                hijo1 = estadoActual.substring(0, 5) + estadoActual.charAt(8) + estadoActual.substring(6,8) + estadoActual.charAt(5);
                hijo2 = estadoActual.substring(0, 7) + estadoActual.charAt(8) + estadoActual.charAt(7);
                // imprimirHijos(hijo1, hijo2);
                hijos = new String[]{hijo1, hijo2};
            }
        }
        // imprimirHijos(hijos);
        return hijos;
    }

    // static void imprimirHijos(String... hijos) {
    //     for (String hijo : hijos) {
    //         for (int i = 0; i < hijo.length(); i++) {
    //             System.out.print("|" + hijo.charAt(i));
    //             if (i == 2 || i == 5 || i == 8) {
    //                 System.out.println("|");
    //             }
    //         }
    //         System.out.println(hijo+"\n");
    //     }
    // }

        static void imprimirHijos(String[] hijos) {
        for (String hijo : hijos) {
            for (int i = 0; i < hijo.length(); i++) {
                System.out.print("|" + hijo.charAt(i));
                if (i == 2 || i == 5 || i == 8) {
                    System.out.println("|");
                }
            }
            System.out.println(hijo+"\n");
        }
    }


}
                                                                                                            // |1|2|3|
                                                                                                            // |8| |4|
                                                                                                            // |7|6|5|
