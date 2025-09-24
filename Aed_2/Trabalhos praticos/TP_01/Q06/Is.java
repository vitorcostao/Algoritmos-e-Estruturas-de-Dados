import java.util.Scanner;

/**
 * Classe para verificar condições em Strings.
 */
public class Is {
    
    /**
     * Método para verificar se é um digito
     * @param c Caractere
     * @return Verificação
     */
    public static boolean IsDigit(char c){

        return (c >= '0' && c <= '9');
    }

    /**
     * Método para verificar se é uma letra
     * @param c Caractere
     * @return Verificação
     */
    public static boolean IsLetter(char c){

        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }

    /**
     * Método para verificar se caractere é uma vogal
     * @param c Caractere
     * @return Verificação
     */
    public static boolean FindVogal(char c){

        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ||
               (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') ||
                c == ' ';
    }

    /**
     * Método para verificar se há apenas vogais na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean isOnlyVogals(String str) {
        
        // Definir dados
        int len = str.length();
        boolean resp = true;

        // Percorrer String
        for(int i = 0; i < len; i++){

            // Verificação
            char c = str.charAt(i);
            if(!FindVogal(c)){

                resp = false;
                i = len;
            }
        }

        return resp;
    }

    /**
     * Método para verificar se há apenas consoantes na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean isOnlyConsonants(String str){

        // Definir dados
        boolean resp = true;
        int len = str.length();

        // Percorrer string
        for (int i = 0; i < len; i++) {

            // Verificações
            char c = str.charAt(i);
            if(IsLetter(c)){

                if(FindVogal(c)){

                    resp = false;
                    i = len;
                }
            } else if(c == ' '){

                
            } else {

                resp = false;
                i = len;
            }
        }

        return resp;
    }

    /**
     * Método para verificar se String é um inteiro
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean IsInteger(String str){

        // Definir dados
        boolean resp = true;
        int len = str.length();

        // Testa se primeiro caractere é um sinal de negativo
        if(str.charAt(0) == '-'){

            // Percorre string iniciando em 1
            for (int i = 1; i < len; i++) {
                
                // Se o caractere não for um digito
                // Então não é um número inteiro
                char c = str.charAt(i);
                if(!IsDigit(c)){

                    // Tratamento
                    resp = false;
                    i = len;
                }
            }

        } else { // Se não houver sinal de negativo

            // Percorre string
            for (int i = 0; i < len; i++) {
                
                // Se o caractere não for um digito
                // Então não é um número inteiro
                char c = str.charAt(i);
                if(!IsDigit(c)){

                    // Tratamento
                    resp = false;
                    i = len;
                }
            }
        }

        return resp;
    }

    /**
     * Método para contar quantas vírgulas ou pontos a String possuí
     * @param str String de entrada padrão
     * @return Quantia determindad
     */
    public static int CountPucts(String str){

        // Definir dados
        int cont = 0;

        for (char c : str.toCharArray()) {

            if(c == ',' || c == '.'){
              
                cont++;
            }
        }

        return cont;
    }

    /**
     * Método para verificar se String é um número real
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean IsFloat(String str){

        // Definir dados
        boolean resp = true;
        int len = str.length();

        // Se tiver mais de um ponto ou vírgula, não é real
        if(CountPucts(str) > 1){

            resp = false;
            return resp;
        }

        // Testa se primeiro caractere é um sinal ou menos
        if(str.charAt(0) == '-'){

                // Se for -> varrer string de 1 ate len
                for (int i = 1; i < len; i++) {
                
                    // Testar se não é um digito ou '.' ou ','
                    char c = str.charAt(i);
                    if(!IsDigit(c) && c != '.' && c != ','){
    
                        // Tratamento
                        resp = false;
                        i = len;
                    }
                }
        } else {

            // Se nao houver sinais -> varrer string de 0 ate len
            for (int i = 0; i < len; i++) {
            
                // Testar se não é um digito ou '.' ou ','
                char c = str.charAt(i);
                if(!IsDigit(c) && c != '.' && c != ','){

                    // Tratamento
                    resp = false;
                    i = len;
                }
            }
        }

        return resp;
    }

    /**
     * Método principal que lê strings e realiza verificações.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        // Definir dados
        String str;
    
        try ( Scanner scanner = new Scanner(System.in)) {
            
            // Leitura de dados
            str = scanner.nextLine();
            
            // Looping
            while(!str.equals("FIM")){
                
                // Verificações
                if(isOnlyVogals(str)){
                    
                    System.out.print("SIM ");
                } else {
                    
                    System.out.print("NAO ");
                }
                
                if(isOnlyConsonants(str)){
                    
                    System.out.print("SIM ");
                } else {
                    
                    System.out.print("NAO ");
                }
                
                if(IsInteger(str)){
                    
                    System.out.print("SIM ");
                } else {
                    
                    System.out.print("NAO ");
                }
                
                if(IsFloat(str)){
                    
                    System.out.println("SIM");
                    
                } else {
                    
                    System.out.println("NAO");
                }
                
                str = scanner.nextLine();
            }
        }

    }
}
