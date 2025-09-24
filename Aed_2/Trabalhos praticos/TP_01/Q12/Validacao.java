import java.util.Scanner;

/**
 * Classe para verificar validação de senha.
 */
public class Validacao {

    /**
     * Método para verificar se há letra maiúscula na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean Maius(String str) {
       
        // Definir dados
        boolean resp = false;
        int len = str.length();

        // Percorrer String
        for(int i = 0; i < len; i++){
            
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {

                resp = true;
                i = len;
            }
        }
        return resp;
    }

    /**
     * Método para verificar se há letra minúscula na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean Minus(String str) {
       
        // Definir dados
        boolean resp = false;
        int len = str.length();

        // Percorrer String
        for(int i = 0; i < len; i++){
            
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {

                resp = true;
                i = len;
            }
        }
        return resp;
    }

    /**
     * Método para verificar se há digito na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean Num(String str) {
        
        // Definir dados
        boolean resp = false;
        int len = str.length();

        // Percorrer String
        for(int i = 0; i < len; i++){
            
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {

                resp = true;
                i = len;
            }
        }
        return resp;
    }

    /**
     * Método para verificar se há caracete especial na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean Esp(String str) {
        
        // Definir dados
        boolean resp = false;
        int len = str.length();

        // Percorrer String
        for(int i = 0; i < len; i++){
            
            char c = str.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {

                resp = true;
                i = len;
            }
        }
        return resp;
    }
    
    /**
     * Método para verificar a validade da senha
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean isValid(String str){

        // Definir dados
        boolean resp = false;

        if(str.length() < 8){

            return resp;
        }

        if(Maius(str) && Minus(str) && Num(str) && Esp(str)){

            resp = true;
        }

        return resp;
    }

    /**
     * Método principal que lê strings e verifica se são senhas válidas.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){


        try (Scanner scanner = new Scanner(System.in, "ISO-8859-1")) {
            // Looping
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                
                // Verifica se a entrada � "FIM" para encerrar o loop
                if (str.equals("FIM")) {
                    break;
                }
                
                if (isValid(str)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }
    }
}

