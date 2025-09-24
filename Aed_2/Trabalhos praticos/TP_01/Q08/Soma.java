

import java.util.Scanner;

/**
 * Classe para somar termos de uma String.
 */
public class Soma {
    
    /**
     * Método recursivo encapsulado para somar termos de uma String
     * @param num String de entrada padrão
     * @return Valor da soma
     */
    public static int SomaTermos(String num){

        return SomaTermos(num, 0, 0);
    }

    /**
     * Método recursivo para somar termos de uma String
     * @param num String de entrada padrão
     * @param i Índice de controle
     * @param sum Valor da soma
     * @return Valor da soma
     */
    public static int SomaTermos(String num, int i, int sum){
        
        // Passo base
        if(i == num.length()){

            return sum;
        } else {

            char c = num.charAt(i);
            if(c >= '0' && c <= '9'){

                sum += (int) c - '0';
            }
            
            // Passo recursivo
            return SomaTermos(num, i + 1, sum);
        }
        
    }

    /**
     * Método principal que lê strings e soma os seus termos.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        try ( 
            
            // Definir dados
            Scanner scanner = new Scanner(System.in)) {
            String n;
            
            // Leitura de dados
            n = scanner.nextLine();
            
            while(!n.equals("FIM")){
                
                // Mostrar dados
                System.out.println(SomaTermos(n));
                
                n = scanner.nextLine();
            }
        }
    }
}
