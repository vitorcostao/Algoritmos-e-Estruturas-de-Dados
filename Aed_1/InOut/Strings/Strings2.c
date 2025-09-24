#include<stdio.h>
#include<string.h>
#include<stdlib.h>

/** Cadeia de caracteres

 Strings: A string e um arranjo de caracteres. Sera analisada
          as diversas formas de representar um arranjo de palavras.

 -----> COMENTARIOS DEPOIS DA MAIN

*/

void imprimirArrayLocal(char s1[][100], int n){

     for(int i = 0; i < 3; i++){

        printf("\n%s\n", s1[i]);
     }
}

void imprimirArrayDin1E(char (*p)[100], int n){

     for(int i = 0; i < 3; i++){

        printf("\n%s\n", *(p + i));
    }
}

void imprimirArrayDin2E(char **str, int n){

     for(int i = 0; i < 3; i++){

        printf("\n%s\n", *(str + i));
    }
}

int main(){

    //Definir dados
    char s1[3][100];
    char (*p)[100];
    char **str;

    //Teste 1
    for(int i = 0; i < 3; i++){

        fgets(s1[i], 100, stdin);
        s1[i][strcspn(s1[i], "\n")] = '\0';
    }
    imprimirArrayLocal(s1, 3);






    //Teste 2
    p = (char (*)[100])malloc(3 * sizeof(*p));
    for(int i = 0; i < 3; i++){

        fgets(*(p + i), 100, stdin);
        *(p + i)[strcspn(*(p + i), "\n")] = '\0';
    }
    imprimirArrayDin1E(p, 3);






    //Teste 3
    str = (char**)malloc(3 * sizeof(char*));
    for(int i = 0; i < 3; i++){ str[i] = (char*)malloc(100 * sizeof(char)); }

    for(int i = 0; i < 3; i++){

        fgets(str[i], 100, stdin);
        str[i][strcspn(str[i], "\n")] = '\0';
    }
    imprimirArrayDin2E(str, 3);


    //Liberar memorias alocadas
    free(p);
    for(int i = 0; i < 3; i++){

        free(str[i]);
    }
    free(str);
    return 0;
}


/** Analises

DETALHE: Trabalhando array de strings e suas formas de serem representadas.



Teste inicial:

        1) Entrada: ab c / Saida: ab c -> OK (3x)

        - OBS: Acessando s1[i] para obter endereco da string e preenche-la.


Teste posterior(1):

        1) Entrada(fgets): ab c  / Saida: ab c -> OK (Teste 1 - 3x)
        2) Entrada(fgets): ab c  / Saida: ab c -> OK (Teste 2 - 3x)

        - OBS: Utilizando ponteiro char (*p)[100], indicando que
               cada p e um endereco e 100 e o tamanho de cada string,
               alocar p (char (*p)[100]) em sizeof(*p), acessando *(p + i)
               para obter o endereco da string.


Teste posterior(2):

        1) Entrada(fgets): ab c  / Saida: ab c -> OK (Teste 1 - 3x)
        2) Entrada(fgets): ab c  / Saida: ab c -> OK (Teste 2 - 3x)
        3) Entrada(fgets): ab c  / Saida: ab c -> OK (Teste 3 - 3x)

        - OBS: Utilizando ponteiro char **str, e necessario alocar (char**) em um
               tamanho em sizeof(char*) e posteriormente uma alocacao em for(condicao)
               com casting (char*) em sizeof(char) para cada letra, acessando str[i] para
               obter o endereco da string.


---> Alocacoes e desalocacoes feitas bem como funcoes para imprimir os dados.


*/
