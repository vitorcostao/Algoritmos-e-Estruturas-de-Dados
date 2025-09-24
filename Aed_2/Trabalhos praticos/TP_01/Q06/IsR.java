import java.util.Scanner;

/**
 * Classe para verificar condições em Strings.
 */
public class IsR {
    
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
               (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    /**
     * Método para verificar se caractere é um espaço
     * @param c Caractere
     * @return Verificação
     */
    public static boolean IsSpace(char c){

        return c == ' ';
    }

    /**
     * Método recursivo encapsulado para verificar se há apenas vogais na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean isOnlyVogals(String str){

        return isOnlyVogals(str, 0);
    }

    /**
     * Método recursivo para verificar se há apenas vogais na String
     * @param str String de entrada padrão
     * @param i Índice de controle
     * @return Verificação
     */    
    public static boolean isOnlyVogals(String str, int i){

        // Passo base
        if(i == str.length()){

            return true;
        } else { // Passo recursivo

            // Teste se c é uma vogal
            char c = str.charAt(i);
            if(!FindVogal(c) && !IsSpace(c)){

                return false;
            } else {

                // Chamada recursiva
                return isOnlyVogals(str, i + 1);
            }
        }
    }

    /**
     * Método recursivo encapsulado para verificar se há apenas consoantes na String
     * @param str String de entrada padrão
     * @return Verificação
     */
    public static boolean  isOnlyConsonants(String str){

        return isOnlyConsonants(str, 0);
    }

    /**
     * Método recursivo para verificar se há apenas consoantes na String
     * @param str String de entrada padrão
     * @param i Índice de controle
     * @return Verificação
     */
    public static boolean isOnlyConsonants(String str, int i){

        // Passo base
        if(i == str.length()){

            return true;
        } else {

            char c = str.charAt(i);
            if(IsLetter(c)){

                if(!FindVogal(c)){

                    // Passo recursivo
                    return isOnlyConsonants(str, i + 1);
                } else {

                    return false;
                }
            } else if(IsSpace(c)){

                // Passo recursivo
                return isOnlyConsonants(str, i + 1);
            } else {

                return false;
            }
        }
    }

    /**
     * Método para verificar se String é um inteiro
     * @param str String de entrada padrão
     * @param i Índice de controle
     * @return Verificação
     */
    public static boolean IsInteger(String str, int i){

        // Passo base
        if(i == str.length()){

            return true; 
        } else {

            char c = str.charAt(i);
            if(i > 0){

                if(c >= '0' && c <= '9'){

                    // Passo recursivo
                    return IsInteger(str, i + 1);
                } else {

                    return false;
                }
            } else {

                if(c == '-'){

                    // Passo recursivo
                    return IsInteger(str, i + 1);
                } else if(c >= '0' && c <= '9'){

                    // Passo recursivo
                    return IsInteger(str, i + 1);
                } else {

                    return false;
                }
            }
        }
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
     * @param i Índice de controle
     * @return Verificação
     */
    public static boolean IsFloat(String str, int i){

        // Definir dados
        int len = str.length();

        // Passo base
        if(i == len){

            return true;
        }

        if(CountPucts(str) > 1){

            return false;
        }

        char c = str.charAt(i);

        if(i == 0 && c == '-'){
           
            // Passo recursivo
            return IsFloat(str, i + 1);
        }

        if((c >= '0' && c <= '9') || c == '.' || c == ','){
   
            // Passo recursivo
            return IsFloat(str, i + 1);
        }

        return false;
    }

    /**
     * Método principal que lê strings e realiza verificações.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        // Definir dados
        String str;
        
        try (
            
            Scanner scanner = new Scanner(System.in)) {
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
                
                if(IsInteger(str, 0)){
                    
                    System.out.print("SIM ");
                } else {
                    
                    System.out.print("NAO ");
                }
                
                if(IsFloat(str, 0)){
                    
                    System.out.print("SIM\n");
                    
                } else {
                    
                    System.out.print("NAO\n");
                }
                
                str = scanner.nextLine();
            }
        }

    }
}
