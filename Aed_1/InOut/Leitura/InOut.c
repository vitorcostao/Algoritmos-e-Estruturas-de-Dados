#include<stdio.h>
#include "InOut.h"

/** Indices

 1 - Leitura de inteiros
 2 - Leitura de reais
 3 - Leitura de caracteres
 4 - Leitura de Strings

 -----> COMENTARIOS DEPOIS DA MAIN

*/

void m1(){

    int n = readInt();
    CleanBufferStdin();
    printf("Inteiro: %d", n);
    //n = readInt2();
    //printf("Inteiro: %d", n);

}

void m2(){

    float n = readFloat();
    CleanBufferStdin();
    printf("Real: %.2f", n);
    //n = readFloat2();
    //printf("Real: %.2f", n);

}

void m3(){

    char n = readChar();
    CleanBufferStdin();
    printf("Caractere: %c", n);
    //n = readChar2();
    //printf("Caractere: %c", n);

}

void m4(){

    char* n = readString(); //OBS: Maximo 100 caracteres
    CleanBufferStdin();
    printf("String: %s", n);
    //n = readString2();
    //printf("String: %s", n);

}

int main(){

    //Teste inicial
    m1();
    printf("\n");
    m2();
    printf("\n");
    m3();
    printf("\n");
    m4();

    printf("\n");

    return 0;
}


/** Analises

DETALHE: Digitar letras em leitura de numeros resulta em 0, o que e valido.
         Por isso, demonstracoes em que sao inseridas letras em testes de numeros,
         saida 0 sera validada.

         !OK -> Caso entrada seja '!' ou resultado inesperado.

Teste inicial:

        1) Entrada: 1    / Saida: 1    -> OK
        2) Entrada: 1    / Saida: 1.00 -> OK
        3) Entrada: a    / Saida: a    -> OK
        4) Entrada: abcd / Saida: abcd -> OK


Teste posterior(1):

        1) Entrada: a    / Saida: 0    -> OK
        1) Entrada: a    / Saida: 0.00 -> OK
        1) Entrada: a    / Saida: a    -> OK
        1) Entrada: a    / Saida: a    -> OK

        - OBS: Digitar numeros em caracteres e permitido na linguagem,
               afinal '1' e um caractere.


Teste posterior(2):

        1) Entrada: abcd    / Saida: 0     -> OK
        1) Entrada: !       / Saida: 0.00  -> !OK
        1) Entrada: !       / Saida: c     -> !OK
        1) Entrada: !       / Saida: ""    -> !OK ---> Sem entrada e saida NULL

        - OBS: Ao digitar "abcd" em uma funcao que espera um numero, a função - scanf - falha e deixa
               os caracteres restantes "abcd" no buffer de entrada. Isso pode causar problemas nas
               leituras subsequentes, pois o proximo scanf tentara ler esses caracteres, o que resulta
               em comportamentos inesperados.
               Para evitar isso, e necessario limpar o buffer de entrada apos uma falha de leitura.


Teste posterior(3):

        1) Entrada: abcd    / Saida: 0     -> OK
        1) Entrada: abcd    / Saida: 0.00  -> OK
        1) Entrada: abcd    / Saida: a     -> OK ---> Primeiro caractere na string
        1) Entrada: abcd    / Saida: abcd  -> OK

        - OBS: Com o buffer limpo, e possivel realizar a leitura de dados das outras funcoes, visto
               que nao ha dados no buffer de entrada para o scanf tentar ler. Entradas bem sucedidas.


---> A funcao CleanBufferStdin() limpa todo o buffer de entrada. O getchar limpa um unico caractere, por isso
     tal funcao verifica a existencia dos caracteres ate o '\n' para saber ate onde o buffer ira ser limpo.

*/
