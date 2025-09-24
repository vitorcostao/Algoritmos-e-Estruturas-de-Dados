import java.util.Random;
import java.util.Scanner;

/**
 * Classe para realizar a alteração aleatória.
 */
public class AlteracaoR {

    /**
     * Método recursivo encapsulado para realizar alteração aleatória de caracteres
     * @param str String a sofrer alteração
     * @return String alterada
     */
    public static String RandomAlteration(char[] str){

        // Definir dados
        Random gerador = new Random();
        gerador.setSeed(4);
        char c1 = (char) ('a' + Math.abs(gerador.nextInt()) % 26);
        char c2 = (char) ('a' + Math.abs(gerador.nextInt()) % 26);

        return RandomAlteration(str, 0, c1, c2);
    }

    /**
     * Método recursivo para realizar alteração aleatória de caracteres
     * @param str String a sofrer alteração
     * @param i Índice atual do da String
     * @param c1 Caractere escolhido
     * @param c2 Caractere escolhido
     * @return String alterada
     */
    public static String RandomAlteration(char[] str, int i, char c1, char c2){

        // Passo base
        if(i == str.length){
            
            return new String(str);
        } else {

            if(str[i] == c1){

                str[i] = c2;
            } else if(str[i] == c2){

                str[i] = c1;
            }
            
            // Passe recursivo
            return RandomAlteration(str, i + 1, c1, c2);
        }
    }

    /**
     * Método principal que lê strings e altera as letras selecionadas.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        try ( // Definir dados
            
            Scanner scanner = new Scanner(System.in)) {
            String str;
            char[] str2;
            
            // Leitura de dados
            str = scanner.nextLine();
            str2 = str.toCharArray();
            
            // Aplicando função
            str = RandomAlteration(str2);
            
            System.out.println(str);
        }
    }
}