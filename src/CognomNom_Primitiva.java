import java.util.Random;
import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * https://github.com/gr1f0x/LaPrimitiva
 * @auhor Satenik Avetisyan - Carla Ramos - Joshua Abril
 * @version 1.0
 * @date 18-02-2024
 */
public class CognomNom_Primitiva {
    /**
     * Mètode main executable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        Scanner llegir = new Scanner(System.in);
        System.out.println("***** PRIMITIVA ******");
        int opcionMenu;
        do {
            System.out.println("Loteria \n1. Hacer Apuesta \n2. Girar el Bombo \n3. Juego nuevo \n4. Salir");
            opcionMenu = llegir.nextInt();
            int[] aposta = new int[7];

            switch (opcionMenu) {
                case 1:
                    aposta = introduirAposta();
                    break;
                case 2:
                    int[] combinacioGuanyadora = calcularCombinacioGuanyadora();

                    int premi;

                    if (combinacioGuanyadora != null) {
                        System.out.println("La combinació ganadora és: ");
                        for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                            System.out.print(combinacioGuanyadora[i] + " ");
                        }
                        System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
                    }

                    premi = comprovarEncerts(aposta, combinacioGuanyadora);
                    System.out.println("El teu premi és: " + premi + " €");
                    break;
                case 3:
                    aposta = null;
                    combinacioGuanyadora = null;
                    System.out.println("Ya puedes volver a jugar");
                    break;
                default:
                    break;
            }
        } while (opcionMenu != 4);
    }

    /**
     * Le pide al usuario numeros para la apuesta con control de errores
     *
     * @return array de la apuesta del usuario
     * @since 1.0
     */
    private static int[] introduirAposta() {
        Scanner llegir = new Scanner(System.in);
        int[] aposta = new int[7];
        boolean[] numerosRepetidos = new boolean[50]; // Un booleano para cada número de 1 a 49

        for (int i = 0; i < aposta.length - 1; i++) {
            int numeroUsuario;
            boolean repetido;
            do {
                repetido = false;
                System.out.println("Introduce tu apuesta número " + (i + 1) + ":");
                while (!llegir.hasNextInt()) {
                    System.out.println("Entrada inválida. Introduce un número entero.");
                    llegir.next();
                }
                numeroUsuario = llegir.nextInt();

                if (numeroUsuario >= 1 && numeroUsuario <= 49) {
                    if (numerosRepetidos[numeroUsuario]) {
                        repetido = true;
                        System.out.println("Número repetido. Introduce otro número.");
                    } else {
                        aposta[i] = numeroUsuario;
                        numerosRepetidos[numeroUsuario] = true;
                    }
                } else {
                    System.out.println("Número fuera del intervalo permitido (1-49). Introduce otro número.");
                }
            } while (repetido || !(numeroUsuario >= 1 && numeroUsuario <= 49));
        }

        int ultimoNumero;
        do {
            System.out.println("Introduce el último número (de 1 a 9):");
            while (!llegir.hasNextInt()) {
                System.out.println("Entrada inválida. Introduce un número entero.");
                llegir.next();
            }
            ultimoNumero = llegir.nextInt();

            if (ultimoNumero >= 1 && ultimoNumero <= 9) {
                aposta[6] = ultimoNumero;
            } else {
                System.out.println("Número de reintegro fuera del intervalo permitido (1-9).");
            }
        } while (!(ultimoNumero >= 1 && ultimoNumero <= 9));

        return aposta;
    }




    /**
     * Aquest metode genera una combinació guanyadora per a un joc de loteria.
     * La combinació consta de 6 números aleatoris del 1 al 49, sense repeticions,
     * i un número addicional del 0 al 9.
     * @return un array d'enters que representa la combinació guanyadora
     * @since 1.0
     */

    private static int[] calcularCombinacioGuanyadora() {
        int[] combinacion = new int[7];
        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            int num;
            boolean repetido;
            do {
                repetido = false;
                num = rand.nextInt(49) + 1;
                for (int j = 0; j < i; j++) {
                    if (combinacion[j] == num) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            combinacion[i] = num;
        }

        combinacion[6] = rand.nextInt(10);

        return combinacion;
    }


    /**
     * Compara los numeros de los arrays aposta y combinacioGuanyadora y da dinero en base a los numeros
     *
     * @param aposta // Array de los inputs del usuario
     * @param combinacioGuanyadora // Array de numeros Randoms
     * @return premi // Devuelve el numero de dinero
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        for (int i = 0; i < aposta.length; i++){
            for (int j = 0; j < combinacioGuanyadora.length; j++){
                if (aposta[i] == combinacioGuanyadora[j]){
                    encerts++;
                }
            }
        }
        //Comprobar reintegrament
        if (combinacioGuanyadora[6] == aposta[6]){
            reintregrament = true;
        }
        //Calcular premi
        if (reintregrament) {
            premi = encerts * 20 + 6;
        } else {
            premi = encerts * 20;
        }
        return premi;
    }

    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @param max valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);

        return x;
    }

    /**
     * Aquest mètode serveix per capturar floats des de teclat amb control d'errors
     * @param missatge
     * @return
     * @since 1.0
     */
    private static float llegirFloat(String missatge){
        Scanner llegir = new Scanner(System.in);
        float x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.print(missatge);
            valorCorrecte = llegir.hasNextFloat();

            if (!valorCorrecte){
                System.out.println("ERROR: Valor no float.");
            }else{
                x = llegir.nextFloat();
            }
            llegir.nextLine();
        }while(!valorCorrecte);

        return x;
    }

}
