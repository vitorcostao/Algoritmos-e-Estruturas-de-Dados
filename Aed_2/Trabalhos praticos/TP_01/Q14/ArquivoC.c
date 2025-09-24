#include <stdio.h>

/**
 * Método que imprime valores em arquivo
 * @param filename Nome do arquivo
 */
void fprint(char *filename){

    // Definir dados
    FILE *arq = fopen(filename, "wt");
    int n;
    float real;

    scanf("%d", &n);

    // Impressão de dados
    for (int i = 0; i < n; i++){
        scanf("%f", &real);
        fprintf(arq, "%f\n", real);
    }

    // Fecha o arquivo após escrita
    fclose(arq);
}

/**
 * Método para ler arquivo de trás para frente
 */
void readFileReversed(FILE *arq){

    // Definir dados
    float num;

    // Lê o número do arquivo
    if (fscanf(arq, "%f", &num) != 1){
        return;
    }

    // Aplica recursão
    readFileReversed(arq);

    // Printa retornos com formatação adequada
    printf("%g\n", num);
}

/**
 * Método principal que grava e lê dados de um arquivo de trás para frente.
 * @param args Argumentos da linha de comando.
 * @throws URISyntaxException
 */
int main(){

    // Definir dados
    char *filename = "dados.txt";

    fprint(filename);

    FILE *arq = fopen(filename, "rt");

    readFileReversed(arq);

    fclose(arq);

    return 0;
}
