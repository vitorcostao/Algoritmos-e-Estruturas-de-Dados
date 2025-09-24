

import java.util.Scanner;

/**
 * Classe para contar palavras em um String.
 */
public class Contar {
    
    /**
     * Método para contar palavras em uma String
     * @param str String de entrada padrão
     * @return Número de palavras
     */
    public static int CountWordInStr(String str){

        // Definir dados
        int len = str.length();
        int cont = 0;
        boolean space = true;

        // Percorrer String
        for(int i = 0; i < len; i++){

            // Verificações
            char c = str.charAt(i);
            if (c == ' ') {

                space = true;  
            } else if (space) {

                cont++;
                space = false;  
            }
        }

        return cont;
    }
    
    /**
     * Método principal que lê strings e conta quantas palavras existem na String.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        try ( 
            
            // Definir dados
            Scanner scanner = new Scanner(System.in)) {
            String str;
            
            // Leitura de dados
            str = scanner.nextLine();
            
            // Looping
            while(!str.equals("FIM")){
                
                // Mostrar dados
                System.out.println(CountWordInStr(str));
                
                str = scanner.nextLine();
            }
        }
    }
}
