import java.util.Scanner;

/**
 * Classe para verificar se uma string é um palíndromo.
 */
public class PalindromoR {

    /**
     * Método principal para verificar se uma string é um palíndromo.
     * @param str String a ser verificada.
     * @return true se a string for um palíndromo, @code false caso contrário.
     */
    static boolean isPalindromo(String str) {

        return isPalindromo(str, 0);
    }

    /**
     * Método recursivo para verificar se uma string é um palíndromo.
     * @param str String a ser verificada.
     * @param i Índice atual da recursão.
     * @return true se a string for um palíndromo, false caso contrário.
     */
    static boolean isPalindromo(String str, int i) {

        // Definir dados
        int j = str.length() - 1 - i;

        // Passo base
        if(i == str.length() / 2){

            return true;
        } else if(str.charAt(i) != str.charAt(j)){
            
            return false;
        }

        // Passo recursivo
        return isPalindromo(str, i + 1);
    }

    /**
     * Método principal que lê strings da entrada padrão e verifica se são palíndromos.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){

        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            
            while(!str.equals("FIM")){
                if (isPalindromo(str)) {
                    
                    System.out.println("SIM");
                } else {
                    
                    System.out.println("NAO");
                }
                str = scanner.nextLine();
            }
        }
    }
}
