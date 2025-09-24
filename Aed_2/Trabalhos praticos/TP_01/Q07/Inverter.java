
import java.util.Scanner;

/**
 * Classe para inverter Strings.
 */
public class Inverter {
    
    /**
     * Método para inverter String
     * @param str String da entrada padrão
     * @return String invertida
     */
    public static String inverter(String str){

        // Definir dados
        char[] strInv = str.toCharArray();
        int len = str.length();

        // Percorrer ate a metade
        for(int i = 0; i < len / 2; i++){

            // Realizar a troca
            char tmp = strInv[i];
            strInv[i] = strInv[len - i - 1];
            strInv[len - i - 1] = tmp;
        }

        // Copiar array para string
        String str2 = new String(strInv);

        return str2;
    }

    /**
     * Método principal que lê strings e as invertem.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        try ( 
            
            // Definir dados
            Scanner scanner = new Scanner(System.in)) {
            String str, str2;
            
            // Leitura de dados
            str = scanner.nextLine();
            
            // Looping
            while(!str.equals("FIM")){
                
                // Aplicando função
                str2 = inverter(str);
                
                System.out.println(str2);
                
                str = scanner.nextLine();
            }
        }
    }
}
