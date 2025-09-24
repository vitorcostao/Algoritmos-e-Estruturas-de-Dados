import java.util.Arrays;
import java.util.Scanner;

/* Problema em questão 
 
A família toda ficou excitada pela novidade.
Todos sabiam que o meu avô tinha sido um excelente jogador de bridge por décadas, 
mas quando foi anunciado que ele estaria no Guinness Book, o livro dos recordes, 
como o jogador de bridge de maior sucesso de todos os tempos, wow, aquilo foi surpreendente.

A Associação Internacional de Bridge (AIB) tem mantido, por diversos anos, um ranking semanal dos melhores jogadores do mundo. 
Considerando que cada aparição em um ranking semanal constitui um ponto para o jogador,
meu avô foi nominado o melhor jogador de todos os tempos porque ele conseguiu o maior número de pontos.

Tendo muitos amigos que também estavam competindo com ele, meu avô está extremamente curioso para saber que jogador(es) ficou(aram) com o segundo lugar.
Ele precisa de um programa, o qual, dada uma lista com os ranking semanais, descubra que jogador(es) ficou(aram) com o segundo lugar, de acordo com o número de pontos.

*/

/* Entrada

A entrada contém diversos casos de teste. Jogadores são identificados por inteiros de 1 a 10000. 
A primeira linha de um caso de teste contém dois inteiros N e M, 
indicando, respectivamente, o número de rankings disponíveis (2 ≤ N ≤ 500) e o número de jogadores em cada ranking (2 ≤ M ≤ 500). 
Cada uma das próximas N linhas contém a descrição de um ranking semanal. 
Cada descrição é composta por uma sequência de M inteiros, separados por um espaço em branco, 
identificando os jogadores que apareceram naquele ranking semanal. 

Você pode assumir que:
em cada caso de teste há exatamente um melhor jogador e ao menos um segundo melhor jogador,
cada ranking semanal consiste de M jogadores distintos.
O final da entrada é indicado por N = M = 0.
 
 */

public class Exercicio_01 {

    public static int toInt(String str){

        char[] strarray = str.toCharArray();
        int len = str.length();
        int data = 0;

        for(int i = 0; i < len; i++){

            data = (data*10) + (strarray[i] - '0');
        }

        return data;
    }

    

    public static void ShowMost(int[] array, int segundo){

        int len = array.length;

        for(int i = 0; i < len; i++){

            if(array[i] == segundo){

                System.out.print((i) + " ");
            }
        }
    }

    public static int SegundoMaior(int[] array){

        int maior = 0;
        int segundoMaior = 0;
        int len = array.length;

        for (int i = 0; i < len; i++) {
            
            if(array[i] > maior){

                maior = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            
            if(array[i] > segundoMaior && array[i] < maior){

                segundoMaior = array[i];
            }
        }        

        return segundoMaior;
    }

    

    public static void printA(String[] arr){

        int len = arr.length;

        for(int i = 0; i < len; i++){

            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }

    public static void main(String[] args) {

        try (
            
            // Definir dados
            Scanner sc = new Scanner(System.in)) {

            // Rankings e quantia de jogadores
            int n = 0, m = 0;

            // Segundo maior valor
            int segundo = 0;
            
            // Descrição semanal
            String descricao;

            // Lista com todos id´s com tamanho 10000 -> Posição 0 é o id 1
            int[] id = new int[10000];

            // Leitura de dados
            n = sc.nextInt();    
            m = sc.nextInt();    
            sc.nextLine();

            // Enquanto n e m forem diferentes de 0
            while((n != 0) && (m != 0)){

                // Resetar o array para evitar contagens erradas
                Arrays.fill(id, 0);

                // Quantia de rankings
                for(int i = 0; i < n; i++){

                    // Leitura da descrição
                    descricao = sc.nextLine();

                    // Separar por espaços e armazenar em arranjos
                    String[] idStrings = descricao.split("\\s+");
                    int len = idStrings.length;
                    
                    // Converter valor para inteiro e adicioná-lo para lista de id´s
                    for(int j = 0; j < len; j++){

                        // Posicao referente ao id
                        int p = toInt(idStrings[j]);
                        id[p]++;
                    }
                }

                // Atribui a quantia de vezes que o segundo maior aparece
                segundo = SegundoMaior(id);
                ShowMost(id, segundo);

                // Leitura de dados
                n = sc.nextInt();    
                m = sc.nextInt();  
                sc.nextLine();
            }  
        }    
    }
}