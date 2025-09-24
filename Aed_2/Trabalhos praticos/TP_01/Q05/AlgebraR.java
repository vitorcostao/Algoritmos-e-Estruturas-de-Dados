import java.util.Scanner;

/**
 * Classe para solucionar expressões booleanas.
 */
public class AlgebraR {

    /**
     * Método que captura os valores booleanos na String
     * @param str Entrada com valores e expressão
     * @return Array de bools com respectivos valores
     */
    public static boolean[] Values(String str) {
        
        // Definir dados
        int numVars = str.charAt(0) - '0'; 
        int len = str.length();
        boolean[] values = new boolean[numVars];
        int j = 0;

        // Percorrer String
        for (int i = 0; i < len; i++) {
            
            char c = str.charAt(i);
            if (c == '1') {
                values[j] = true;
                j++;
            } else if (c == '0') {
                values[j] = false;
                j++;
            }
        }


        return values;
    }

    /**
     * Método para encontrar o índice da expressão
     * @param Str String de entrada padrão
     * @return Índice
     */
    public static int firstIndexOperation(String Str){

        // Definir dad0s
        int i, j = 0;
        int len = Str.length();

        for (i = 0; i < len; i++) {
            
            char c = Str.charAt(i);
            if(c == 'a' || c == 'n' || c == 'o'){

                j = i;
                i = len;
            }
        }

        return j;
    }
    

    /**
     * Método para ter String de entrada somente com expressão
     * @param str String de entrada padrão
     * @param values Array booleano com valores das variáveis
     * @return Expressão booleana
     */
    public static String Expression(String str, boolean[] values) {
        
        // Definir dados
        String exp = "";
        int len = str.length();
        int initial = firstIndexOperation(str);

        /**
         * Substituir letras pelos valores das variáveis
         * Substituir and, or, not por &, | , ! respectivamente
         */
        for (int i = initial; i < len; i++) {
            
            char c = str.charAt(i);
            if (c == 'A'){

                exp += (values[0] ? 1 : 0);
            } else if (c == 'B') {

                exp += (values[1] ? 1 : 0);
            } else if (c == 'C') {
                
                exp += (values[2] ? 1 : 0);
            } else if (c == 'a') {
                
                exp += '&';
                i = i + 2;
            } else if (c == 'o') {
                
                exp += '|';
                i = i + 1;
            } else if (c == 'n') {
                
                exp += '!';
                i = i + 2;
            }  else if (c != ' ' && c != ',') {
                exp += c;
            } 
        }
        return exp;
    }

    /**
     * Método para encontrar última abertura de parenteses
     * @param str Expressão booleana
     * @return Índice do parentese
     */
    public static int LastOpen(String str){

        // Definir dados
        int len = str.length();
        int j = 0;

        // Percorrer String
        for(int i = 0; i < len; i++){

            char c = str.charAt(i);
            if(c == '('){

                j = i;
            }
        }

        return j;
    }

    /**
     * Método para encontrar primeiro fechamento de parenteses a partir do índice
     * @param str Expressão booleana
     * @param inicio Índice do parentese de abertura
     * @return Índice do parentese de fechamento
     */
    public static int LastEnd(String str, int inicio){

        // Definir dados
        int len = str.length();
        int j = 0;

        // Percorrer String
        for(int i = inicio; i < len; i++){

            char c = str.charAt(i);
            if(c == ')'){

                j = i;
                i = len;
            }
        }

        return j;
    }

    /**
     * Método para obter uma substring a partir do índices
     * @param str Expressão booleana
     * @param inicio Índice inicial
     * @param fim Índice final
     * @return Substring
     */
    public static String substr(String str, int inicio, int fim){

        // Definir dados
        String sub = "";

        for(int i = inicio; i < fim; i++){

            char c = str.charAt(i);
            sub += c;
        }

        return sub;
    }

    /**
     * Método para resolver expressão booleana
     * @param substr Expressão booleana dentro da entrada padrão
     * @return Solução booleana em formato de String
     */
    public static String SolutionPart(String substr){

        // Definir dados
        int len = substr.length();
        char op = substr.charAt(0);

        switch (op) {
            case '&' -> {
                for(int i = 1; i < len; i++){
                    
                    if(substr.charAt(i) == '0'){
                        
                        return "0";
                    }
                }
                
                return "1";
            }
            case '|' -> {
                for(int i = 1; i < len; i++){
                    
                    if(substr.charAt(i) == '1'){
                        
                        return "1";
                    }
                }

                return "0";
            }
            case '!' -> {
                if(substr.charAt(2) == '1'){
                    
                    return "0";
                } else if(substr.charAt(2) == '0'){ 
                    
                    return "1";
                }
            }
            default -> {
            }
        }
        return "";
    }
    

    /**
     * Método recursivo para resolver a expressão booleana padrão
     * @param exp Expressão booleana padrão
     * @return Solução
     */
    public static boolean Solution(String exp){

        // Passo base
        if(exp.length() == 1){

            return exp.equals("1");
        } else {

            // Capturando expressões
            int inicio = LastOpen(exp);
            int fim = LastEnd(exp, inicio);

            // Tratamento
            String part = substr(exp, inicio - 1, fim + 1);
            String resultado = SolutionPart(part);
            
            exp = substr(exp, 0, inicio - 1) + resultado + substr(exp, fim + 1, exp.length());

            // Passo recursivo
            return Solution(exp);
        }
    }

    /**
     * Método principal que lê strings e resolve expressões booleanas.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        // Definir dados
        String str, str2;
        try ( // Definir dados
            
            Scanner scanner = new Scanner(System.in)) {
            str = scanner.nextLine();
            
            // Looping
            while(!str.equals("0")){
                
                // Tratamento
                boolean[] values = Values(str);
                str2 = Expression(str, values);
                
                // Saída com if-else
                if(Solution(str2)){
                    
                    System.out.println("1");
                } else {
                    
                    System.out.println("0");
                }
                
                str = scanner.nextLine();
            }
        }
    }
}
