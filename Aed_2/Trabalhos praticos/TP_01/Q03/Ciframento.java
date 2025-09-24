
/**
 * Classe para realizar o ciframento de cesar.
 */
public class Ciframento {

    /**
     * Método que retorna String cifrada.
     * Adiciona a chave para cada caractere.
     * @param str String a ser cifrada.
     */
    public static String CesarCifra(String str){

        // Definir dados
        int len = str.length();
        String cesar = "";

        // Percorre String
        for(int i = 0; i < len; i++){

            // Soma três para cada caractere
            char c = str.charAt(i);
            cesar += (char) (c + 3);
        }

        // Retorno
        return cesar;
    }

    /**
     * Método principal que lê strings da entrada padrão e imprime a palavra cifrada.
     * O programa encerra quando a entrada for "FIM".
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){

        // Definir dados
        String str1, str2;

        // Leitura de dados
        str1 = MyIO.readLine();

        // Looping
        while(!str1.equals("FIM")){

            // Aplicando função
            str2 = CesarCifra(str1);

            MyIO.println(str2);

            str1 = MyIO.readLine();
        }
    }
}