import java.util.Random;
import java.util.Scanner;


/**
 * Classe para realizar a alteração aleatória.
 */
public class Alteracao {

    /** 
     * Método para realizar alteração aleatória de caracteres
     * @param str String a sofrer alteração
     * @param gerador Gerador responsável por escolher os caracteres
     * @return String alterada.
    */
    public static String RandomAlteration(String str, Random gerador){

        // Definir dados
        char[] str2 = str.toCharArray();
        char c1 = (char) ('a' + Math.abs(gerador.nextInt()) % 26);
        char c2 = (char) ('a' + Math.abs(gerador.nextInt()) % 26);

        // Percorrer String
        for(int i = 0; i < str.length(); i++){

            // Comparação
            if(str2[i] == c1){

                // Alteração
                str2[i] = c2;
            }
          
        }

        return new String(str2);
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
            Random gerador = new Random();

            // Gerador
            gerador.setSeed(4);
            
            // Leitura de dados
            str = scanner.nextLine();
            
            // Looping
            while(!str.equals("FIM")){
                
                // Alteração
                str = RandomAlteration(str, gerador);
                System.out.println(str);
                str = scanner.nextLine();
                
                
            }
        }
    }
}