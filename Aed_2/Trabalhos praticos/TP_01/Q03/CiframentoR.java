
/**
 * Classe para realizar o ciframento de cesar.
 */
public class CiframentoR {

    /**
     * Método recursivo para transformar String em cifrada.
     * @param str String a ser cifrada.
     * @param i Índice atual da recursão.
     * @return String cifrada.
     */
    public static String CesarCifraRecursivo(char[] str) {

        return CesarCifraRecursivo(str, 0);
    }
   
    public static String CesarCifraRecursivo(char[] str, int i){

        // Passo base
        if(i == str.length){

            return new String(str);
        } else {


            str[i] = (char)(str[i] + 3);

            // Passo recursivo
            return CesarCifraRecursivo(str, i + 1);
        }
    }


    /**
     * Método principal que lê strings da entrada padrão e imprime a palavra cifrada.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){

        // Setando charset
        MyIO.setCharset("ISO-8859-1");

        // Definir dados
        String str1;
        char[] str2;
        

        // Leitura de dados
        str1 = MyIO.readLine();

        // Looping
        while(!str1.equals("FIM")){

            // Conversao
            str2 = str1.toCharArray();
            
            // Ciframento
            str1 = CesarCifraRecursivo(str2);
            
            // Saida
            MyIO.println(str1);
            str1 = MyIO.readLine();
        }
    }
}