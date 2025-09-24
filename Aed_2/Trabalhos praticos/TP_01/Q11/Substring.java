import java.util.HashSet;
import java.util.Scanner;

/**
 * Classe que contém um método para encontrar a maior substring sem caracteres repetidos.
 */
public class Substring {

    /**
     * Método que retorna o tamanho da maior substring
     * @param s String a ser testada
     * @return Tamanho da maior substring
     */
    public static int longestSubstring(String str) {
        
        // Conjunto para armazenar caracteres da janela deslizante
        HashSet<Character> seen = new HashSet<>();
        
        // Ponteiros da janela deslizante e variável para armazenar o tamanho máximo encontrado
        int left = 0, maxLen = 0;

        // Percorre a string com o ponteiro "right"
        for(int right = 0; right < str.length(); right++){

            // Se o caractere já estiver na janela, move "left" até remover a duplicata
            while (seen.contains(str.charAt(right))) {
                
                // Caso encontre remove do mapeamento movendo ponteiros
                seen.remove(str.charAt(left));
                left++;
            }

            // Adiciona o caractere atual à janela e atualiza o tamanho máximo
            seen.add(str.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        if(maxLen == str.length()){

            return str.length();
        }

        return maxLen;
    }

    /**
     * Método principal que lê strings e mostra maior substring.
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
                System.out.println(longestSubstring(str));
                
                str = scanner.nextLine();
            }
        }
        
    }
}
