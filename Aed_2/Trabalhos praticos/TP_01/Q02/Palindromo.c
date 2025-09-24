#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

/**
 * Método principal para verificar se uma string é um palíndromo.
 * @param str String a ser verificada.
 * @return true se a string for um palíndromo, @code false caso contrário.
 */
bool isPalindromo(char* str){

    // Definir dados
    bool resp = true;
    int len = strlen(str);

    if(str[len - 1] == '\n'){
        str[len - 1] = '\0';
        len--;
    }

    // Percorrer string
    for(int i = 0; i < len / 2; i++){

        // Comparar
        if((str[i] != str[len - i - 1])){

            // Tratamento
            resp = false;
            i = len;
        }
    }

    // Retorno
    return resp;
}

/**
 * Função principal que lê strings da entrada padrão e verifica se são palíndromos.
 * O programa encerra quando a entrada for "FIM".
 * @param args Argumentos da linha de comando.
 */
int main(){

    // Definir dados
    char str[1000];

    // Leitura
    fgets(str, 1000, stdin);
    str[strcspn(str, "\n")] = '\0';

    // Looping
    while(strcmp(str, "FIM") != 0){

        // Saída com operador ternário
        printf("%s\n", isPalindromo(str) ? "SIM" : "NAO");

        fgets(str, 1000, stdin);
        str[strcspn(str, "\n")] = '\0';
    }

    return 0;
}
