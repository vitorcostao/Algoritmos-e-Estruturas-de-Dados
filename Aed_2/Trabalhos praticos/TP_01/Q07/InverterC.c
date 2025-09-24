#include<stdio.h>
#include<stdlib.h>
#include<string.h>

/**
 * Método recursivo que inverte uma String
 * @param str String a ser invertida
 * @param i Índice de controle
 * @return String invertida
 */
char* inverter(char* str, int i){

    // Definir dados
    int len = strlen(str);

    // Passo base
    if(i == len / 2){

        return str;
    } else {

        // Troca
        char tmp = str[i];
        str[i] = str[len - i - 1];
        str[len - i - 1] = tmp;

        // Passo recursivo
        return inverter(str, i + 1);
    }
}

/**
 * Método principal que lê Strings e as invertem
 * O progrma encerra quando a entrada for "FIM"
 */
int main (){

    // Definir dados
    char str[256];

    fgets(str, 256, stdin);
    str[strcspn(str, "\n")] = '\0';

    while(strcmp(str, "FIM") != 0){

        char str2[256];
        strcpy(str2, str);

        inverter(str2, 0);

        printf("%s\n", str2);

        fgets(str, 256, stdin);
        str[strcspn(str, "\n")] = '\0';
    }

    return 0;
}