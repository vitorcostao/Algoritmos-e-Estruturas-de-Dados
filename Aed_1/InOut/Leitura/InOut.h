#ifndef INOUT_H
#define INOUT_H

#include<stdio.h>
#include<string.h>
#include<stdlib.h>


/*

    - Todas funcoes abaixo realizam a leitura de dados, porem faremos alguns testes com valores inesperados
     e deixaremos registrados os resultados comentados para algumas possibilidades invalidas.

    - Posteriormente, iremos melhorar as funcoes para torna-las mais robustas usando boas praticas de programacao

*/


void CleanBufferStdin(){

    int buffer;

    while((buffer = getchar()) != '\n');
}



//----------------------------------------------------Funcoes iniciais

int readInt(){

    //Definir dados
    int n;

    printf("\n\nDigite um valor: ");
    scanf("%d", &n);
    getchar();

    return n;
}

float readFloat(){

    //Definir dados
    float n;

    printf("\n\nDigite um valor: ");
    scanf("%f", &n);
    getchar();

    return n;
}

char readChar(){

    //Definir dados
    char n;

    printf("\n\nDigite uma letra: ");
    scanf(" %c", &n);
    getchar();

    return n;
}

char* readString(){

    //Definir dados
    char* n = (char*)malloc(100 * sizeof(char));

    printf("\n\nDigite uma palavra: ");
    fgets(n, 100, stdin);
    n[strcspn(n, "\n")] = '\0';

    return n;
}


//----------------------------------------------------Funcoes melhoradas

int readInt2(){

    //Definir dados
    int n;

    printf("\n\nDigite um valor: ");
    scanf("%d", &n);
    getchar();

    while(getchar() != '\n'); //Limpa dados adicionais digitado pelo usuario

    return n;
}

float readFloat2(){

    //Definir dados
    float n;

    printf("\n\nDigite um valor: ");
    scanf("%f", &n);
    getchar();

    while(getchar() != '\n'); //Limpa dados adicionais digitado pelo usuario

    return n;
}

char readChar2(){

    //Definir dados
    char n;

    printf("\n\nDigite uma letra: ");
    scanf(" %c", &n);
    getchar();

    while(getchar() != '\n'); //Limpa dados adicionais digitado pelo usuario

    return n;
}

char* readString2(){

    //Definir dados
    char* n = (char*)malloc(100 * sizeof(char));

    printf("\n\nDigite uma palavra: ");
    fgets(n, 100, stdin);
    n[strcspn(n, "\n")] = '\0';

    return n;
}


#endif // INOUT_H
