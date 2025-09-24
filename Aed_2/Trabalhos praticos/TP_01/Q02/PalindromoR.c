#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>
#include<ctype.h>

/**
 * Método recursivo para verificar se uma string é um palíndromo.
 * @param str String a ser verificada.
 * @param i Índice atual da recursão.
 * @return true se a string for um palíndromo, false caso contrário.
 */
bool isPalindromo(char* str, int i, int len){

    // Passo base
    if(i == (len / 2)){

        return true;
    } else { 

        if(str[i] != str[len - i - 1]){

            return false;
        } else {
            
            // Passo recursivo
            return isPalindromo(str, i + 1, len);
        }
    }
}

int main(){

    // Definir dados
    char str[1000];

    // Leitura de dados
    fgets(str, 1000, stdin);
    str[strcspn(str, "\n")] = '\0';

    // Looping
    while(strcmp(str, "FIM") != 0){
        
        // Saída com operaor ternário
        printf("%s\n", isPalindromo(str, 0, strlen(str)) ? "SIM" : "NAO");

        fgets(str, 1000, stdin);
        str[strcspn(str, "\n")] = '\0';
    }

    return 0;
}