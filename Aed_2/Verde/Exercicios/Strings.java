import java.util.Scanner;

public class Strings {

    public static String formatCPF(String cpf, int len){

        // Definir dados
        char[] string = cpf.toCharArray();
        char[] cpfarray = new char[len + 3];

        int j = 0;
        for(int i = 0; i < len; i++){

            switch (i) {
                case 3:
                case 7:
                    cpfarray[i] = '.';
                    break;
                default:
                    cpfarray[i] = string[j++];
                    break;
            }
        }

        cpfarray[j + 2] = '-';
        cpfarray[j + 3] = string[9];
        cpfarray[j + 4] = string[10];

        return new String(cpfarray);
    }

    public static int countSbtr(String str, String sub){

        int index = 0;
        int cont = 0;

        while((index = str.indexOf(sub, index)) != -1){

            cont++;
            index += sub.length();
        }

        return cont;
    }

    public static String substituir(char[] strarray, char a1, char a2, int len){

        for(int i = 0; i < len; i++){

            if(strarray[i] == a1){

                strarray[i] = a2;
            }
        }

        return new String(strarray);
    }

    public static boolean IsPalindromo(char[] strarray, int len){

        // Definir dados
        boolean resp = true;

        for (int i = 0; i < len / 2; i++) {
            
            if(strarray[i] != strarray[len - i - 1]){

                resp = false;
                i = len;
            }
        }

        return resp;
    }

    public static int ContVogals(String str, int len){

        // Definir dados
        char[] array = str.toCharArray();
        int cont = 0;

        for(int i = 0; i < len; i++){

            if(array[i] == 'a' || array[i] == 'o' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u'){

                cont++;
            }
        }

        return cont;
    }

    public static void ImprimirEspelhoNum(int num){

        if(num == 0);
        else {

            System.out.print(num % 10);
            ImprimirEspelhoNum(num / 10);
        }
    }

    public static void ImprimirEspelho(int[] array, int len){

        for(int i = 0; i < len; i++){

            System.out.print(array[i]);
        }

        for(int i = 0; i < len; i++){

            ImprimirEspelhoNum(array[i]);
        }
    }

    public static String InverteString(char[] str, int i, int len){

        if(i == len / 2){

            return new String(str);
        } else {

            char tmp = str[i];
            str[i] = str[len - i - 1];
            str[len - i - 1] = tmp;
            return InverteString(str, i + 1, len);
        }
    }

     public static void main (String[] args){

        try ( 
                // Definir dados
                Scanner sc = new Scanner(System.in)) {
                int opcao;
                
                // Strings e caracteres
                String str = "Banana";
                char[] strarray = str.toCharArray();
                String cpf = "12345678910";

                // Inteiros
                int[] intarray = {10, 11, 12, 13};
                int len = strarray.length;
                int lencpf = cpf.length();
            

                // Ler opcao
                System.out.println("\nDigite uma opcao: ");
                opcao = sc.nextInt();
                
                while(opcao != 0){

                    switch(opcao){
                        case 1 -> {

                            System.out.println("Metodo 1 - Inversao de strings");
                            InverteString(strarray, 0, 6);
                        }
                        case 2 -> {

                            System.out.println("Metodo 2 - Espelho em java");
                            ImprimirEspelho(intarray, len);
                            
                        }
                        case 3 -> {

                            System.out.println("Metodo 3 - Contar vogais");
                            System.out.println(str);
                            System.out.println(ContVogals(str, len));
                        }
                        case 4 -> {

                            System.out.println("Metodo 4 - Palindromo");
                            if(IsPalindromo(strarray, len)){

                                System.out.println("E palindromo: " + str);
                            } else {

                                System.out.println("Nao e palindromo: " + str);
                            }
                        }
                        case 5 -> {

                            System.out.println("Metodo 5 - Substituir");
                            str = substituir(strarray, 'B', 'm', len);
                            System.out.println(str);
                        }
                        case 6 -> {

                            System.out.println("Metodo 6 - Substring");
                            boolean contem = str.contains("ana");
                            System.out.println(contem);

                            // Há funcoes como indexOf(Índice inicial), startswith(Comeca com substr), endwith(Termina com substr), contains(Contem substr)
                        }
                        case 7 -> {

                            System.out.println("Metodo 7 - Contar substring");
                            int cont = countSbtr(str, "na");
                            System.out.println(cont);

                            
                        }
                        case 8 -> {

                            System.out.println("Metodo 8 - Formatar cpf");
                            System.out.println(formatCPF(cpf, lencpf));

                            
                        }
                        default -> throw new AssertionError();
                    }

                    System.out.println("\nDigite uma opcao: ");
                    opcao = sc.nextInt();
                    System.out.println("\n");
                }

                System.out.println("Encerrando o programa!");
            }
    }
}
