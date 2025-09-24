
import java.util.Scanner;

/**
 * Classe para inverter Strings.
 */
public class InverterR {
    
    /**
     * Método recursivo encapsulado para inverter String
     * @param str String da entrada padrão
     * @return String invertida
     */
    public static String Inverter(String str){
        
        // Transformar String em array
        char[] strInv = str.toCharArray();

        // Retornar invertido
        return Inverter(strInv, 0);        
    }

    /**
     * Método para inverter String
     * @param str String da entrada padrão
     * @param i Índice de controle
     * @return String invertida
     */
    public static String Inverter(char[] str, int i){

        // Passo base
        if(i == str.length / 2){

            String strInv = new String(str);
            return strInv;
        } else {

            // Tamanho 
            int len = str.length;

            // Troca
            char tmp = str[i];
            str[i] = str[str.length - i - 1];
            str[len - i - 1] = tmp;
            
            // Passo recursivo
            return Inverter(str, i + 1);
        }
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
           
            // Aplicando função
            str2 = Inverter(str);
            System.out.println(str2);
        }
    }
}
