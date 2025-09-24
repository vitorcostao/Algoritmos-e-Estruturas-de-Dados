#include<stdio.h>
#include<string.h>

/** Saida de dados

 Formatacao de dados: Uso da funcao printf bem como seus possiveis parametros

 -----> COMENTARIOS DEPOIS DA MAIN

*/

int main(){

    //Definir dados
    int n;
    float f;
    char c;
    char p[10];

    //Inicializar
    n = 2; f = 1.82; c = 'a'; strcpy(p, "abcd");


/**
    printf("Teste sem inicializar\n");
    printf("n: %d\n", n);
    printf("f: %f\n", f);
    printf("c: %c\n", c);
    printf("p: %s", p);

    //Inicializar
    n = 2; f = 1.82; c = 'a'; strcpy(p, "abcd");

    printf("\n\n");

    printf("Teste inicial\n");
    printf("n: %d\n", n);
    printf("f: %f\n", f);
    printf("c: %c\n", c);
    printf("p: %s", p);

    printf("\n\n");

    printf("Teste posterior(1)\n");
    printf("n: %f\n", n);
    printf("f: %d\n", f);
    printf("c: %d\n", c);
    printf("p: %f\n", p);

*/


    printf("Inteiro: %d\n", n);
    printf("Float com 2 casas: %.2f\n", f);
    printf("Caractere: %c\n", c);
    printf("String: %s\n", p);

    printf("\n\n");

    printf("Alinhado a direita: %5d\n", n);
    printf("Alinhado a esquerda: %-5d\n", n);

    printf("\n\n");

    printf("Preenchido com zeros: %05d\n", n);

    return 0;
}


/** Analises

DETALHE: O especificador de formato (%) trabalha o tipo de dados referente sera usado nas funcoes:
         - %d: Inteiro
         - %f: Real
         - %c: Caractere
         - %s: String


Teste sem inicializar:

        Comportamentos indefinidos!


Teste inicial:

        Impressao dos dados seguindo formatacao padrao!


Teste posterior(1):

        Imprimindo formatadores errados!
        - Cada tipo de dado ocupa um espaco na memoria.
        - Imprimir formatador errado gera comportamentos estranhos.
        - Usar %d em %c e vice versa, imprime o valor na tabela ASCII.

        1) Saida(%d -> %f): Indefinido -> !OK
        2) Saida(%f -> %d): Indefinido -> !OK
        3) Saida(%d -> %c): 97         -> OK
        4) Saida(%f -> %s): Indefinido -> !OK


--->A parte nao comentada mostra algumas das formatacoes mais utilizadas!

*/
