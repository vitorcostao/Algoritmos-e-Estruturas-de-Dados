#include<stdio.h>

/** Cadeia de caracteres

 Strings: A string e um arranjo de caracteres. Sera analisado o comportamento
          desse tipo de dados.

 -----> COMENTARIOS DEPOIS DA MAIN

*/

int main(){

    //Definir dados
    char  s1[100];
    char* s2;

    //Scanf
    printf("\nDigite uma palavra: ");
    scanf("%s", &s1);
    getchar();
    printf("\n%s", s1);

    printf("\n\n");

    //fgets
    printf("\nDigite uma palavra: ");
    fgets(s1, 100, stdin);
    printf("\n%s", s1);

    return 0;
}


/** Analises

DETALHE: Nao sera usado for(condicao) para preencher arranjo de caracteres,
         serao testadas formas de leitura de dados para strings.



Teste inicial:

        1) Entrada: abc  / Saida: abc  -> OK
        2) Entrada: a bc / Saida: a    -> !OK

        - OBS: Uso do scanf permite leitura ate os espacos (Mais testes foram realizados para comprovar).


Teste posterior(1):

        1) Entrada(scanf): a bc  / Saida: a  -> OK
        2) Entrada(fgets): !     / Saida: bc -> !OK

        - OBS: Lendo ate o espaco, scanf nao captura o resto da string no buffer, assim
               o fgets nem realizada a entrada pelo stdin do teclado, capturando o que restou
               do buffer, para isso seria necessario limpar o buffer com funcao.


Teste posterior(2):

        1) Entrada(scanf): abc  / Saida: abc -> OK
        2) Entrada(fgets): abc  / Saida: abc -> OK

        - OBS: Entradas validas pois foram capturadas todos caracteres do buffer.

---> A funcao fgets, durante o processo de leitura, inclui o caractere '\n' no final da string, use
     strcspn(string, "\n") = '\0, pois isso tranformara o '\n' lido em '\0'.


*/
