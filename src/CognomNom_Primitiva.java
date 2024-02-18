import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * @auhor //TODO: Nom Alumne
 * @version 1.0
 * @date //TODO: data
 */
//TODO: Fer refractor per canviar el nom de la classe
public class CognomNom_Primitiva {
    /**
     * Mètode main executable
     *
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    Scanner llegir = new Scanner(System.in);

    /**
     * //TODO: Completar
     *
     * @since 1.0
     */
    private static void menuPrincipal() {
        System.out.println("***** PRIMITIVA ******");

        int[] aposta = introduirAposta();
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
    }

    /**
     * //TODO: Completasr
     *
     * @return array de la apuesta del usuario //TODO: Completar
     * @since 1.0
     */
    private static int[] introduirAposta() {
        Scanner llegir = new Scanner(System.in);
        int[] aposta = new int[7];
        int numerosUsuaris;
        int ultimonumero;
        //TODO: Fer el codi del mètode
                for (int i = 0; i < aposta.length-1; i++) {
                    System.out.println("Introduce tu apuesta: " + (i + 1) + "");
                    while (!llegir.hasNextInt()) {
                        System.out.println("Entrada inválida. Introduce un número entero.");
                        llegir.next();
                    }
                    numerosUsuaris = llegir.nextInt();
                    if (numerosUsuaris >= 1 && numerosUsuaris <= 49) {
                        aposta[i] = numerosUsuaris;
                    } else {
                        System.out.println("Número fuera del interval permitido. Introduce otro número.");
                        i--;
                    }
                }
                do {
                System.out.println("Introduce el ultimo numero(de 1 a 9):");
                    while (!llegir.hasNextInt()) {
                        System.out.println("Entrada inválida. Introduce un número entero.");
                        llegir.next();
                    }
                ultimonumero = llegir.nextInt();

                    if (ultimonumero >= 1 && ultimonumero <= 9) {
                        aposta[6] = ultimonumero;
                    } else {
                        System.out.println("Número de reintegrament fora de l'interval permès.");
                    }
                }while (!(ultimonumero >= 1 && ultimonumero <= 9));

            System.out.println("La teva aposta és: ");
            for (int i = 0; i < aposta.length; i++) {
                System.out.print(aposta[i] + " ");
            }
            System.out.println();
            return aposta;
    }



    /**
     * //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora(){
        int[] combinacio = null;

        //TODO: Fer el codi del mètode

        return combinacio;
    }

    /**
     * //TODO: Completar
     * @param aposta //TODO: Completar
     * @param combinacioGuanyadora //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        //TODO: Fer el codi del mètode

        //Comprobar reintegrament
        //TODO: Fer el codi del mètode

        //Calcular premi
        //TODO: Fer el codi del mètode

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
