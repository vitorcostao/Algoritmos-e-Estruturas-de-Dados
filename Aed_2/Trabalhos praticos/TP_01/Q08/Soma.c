#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>
#include<ctype.h>

/**
 * Método recursivo para somar termos de uma String
 * @param num String de entrada padrão
 * @param i Índice de controle
 * @param sum Valor da soma
 * @return Valor da soma
 */
int SomaTermos(char* num, int i, int sum){

    // Definir dados
    int len = strlen(num);

    if(i == len){

        return sum;
    } else {

        sum += (int) num[i] - '0';

        return SomaTermos(num, i + 1, sum);
    }
}

/**
 * Método principal que lê strings e soma os seus termos.
 * O programa encerra quando a entrada for "FIM".
 * @param args Argumentos da linha de comando.
 */
int main(){

    // Definir dados
    int num;
    char str[256];

    fgets(str, 256, stdin);
    str[strcspn(str, "\n")] = '\0';

    while(strcmp(str, "FIM") != 0){

        printf("%d\n", SomaTermos(str, 0, 0));

        fgets(str, 256, stdin);
        str[strcspn(str, "\n")] = '\0';
    }
    

    return 0;
}