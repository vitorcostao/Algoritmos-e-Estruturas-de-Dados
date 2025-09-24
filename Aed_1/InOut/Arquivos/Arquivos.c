#include<stdio.h>
#include<stdlib.h>
#include<string.h>

/** Arquivos

 Os arquivos sao responsaveis por guardas dados e diferentes informacoes.
 Nesta sessao veremos como gravar e ler dados de arquivos, bem como entender algumas
 caracteristicas importantes durante o processo de leitura.

 -----> COMENTARIOS DEPOIS DA MAIN

*/

void ImprmirInt(int n, int* a){

    for(int i = 0; i < n; i++){

        printf("%d ", a[i]);
    }
}

void ImprmirFloat(int n, float* f){

    for(int i = 0; i < n; i++){

        printf("%.1f ", f[i]);
    }
}

void ImprmirChar(int n, char* c){

    for(int i = 0; i < n; i++){

        printf("%c ", c[i]);
    }
}

void ImprmirString(int n, char** s){

    for(int i = 0; i < n; i++){

        if(i == n - 1){

           printf("%s.", s[i]);
        } else {

           printf("%s, ", s[i]);
        }

    }
}

void GravarArquivo1(){

    //Definir dados
    FILE* arq1 = fopen("INT.TXT", "wt");
    FILE* arq2 = fopen("FLOAT.TXT", "wt");

    for(int i = 0; i < 10; i++){

        fprintf(arq1, "%d\n", i + 1);
        fprintf(arq2, "%.2f\n", (float)i + 1);
    }

    fclose(arq1);
    fclose(arq2);
}

void GravarArquivo2(){

    //Definir dados
    FILE* arq1 = fopen("CHAR.TXT", "wt");
    FILE* arq2 = fopen("STRING.TXT", "wt");
    char str[50];

    for(int i = 0; i < 10; i++){

        fprintf(arq1, "%c\n", ('A' + i));

        printf("\nDigite uma palavra: ");
        fgets(str, 50, stdin);
        str[strcspn(str, "\n")] = '\0';

        fprintf(arq2, "%s\n", str);
    }

    fclose(arq1);
    fclose(arq2);

}

int* LerArquivoI(){

     //Definir dados
     FILE* arq1 = fopen("INT.TXT", "rt");
     int* a = (int*)malloc(10 * sizeof(int));

     for(int i = 0; i < 10; i++){

         fscanf(arq1, "%d", &a[i]);
     }

     fclose(arq1);
     return a;
}

float* LerArquivoR(){

     //Definir dados
     FILE* arq1 = fopen("FLOAT.TXT", "rt");
     float* a = (float*)malloc(10 * sizeof(float));

     for(int i = 0; i < 10; i++){

         fscanf(arq1, "%f", &a[i]);
     }

     fclose(arq1);
     return a;

}

char* LerArquivoC(){

     //Definir dados
     FILE* arq1 = fopen("CHAR.TXT", "rt");
     char* a = (char*)malloc(10 * sizeof(char));

     for(int i = 0; i < 10; i++){

         fscanf(arq1, " %c", &a[i]);
     }

     fclose(arq1);
     return a;

}

char** LerArquivoS(){

     //Definir dados
     FILE* arq1 = fopen("STRING.TXT", "rt");
     char** a = (char**)malloc(10 * sizeof(char*));

     for(int i = 0; i < 10; i++){

         a[i] = (char*)malloc(50 * sizeof(char));
     }

     int i = 0;
     char buffer[50];
     while(fgets(buffer, 50, arq1) != NULL && i < 10){

        buffer[strcspn(buffer, "\n")] = '\0';
        strcpy(a[i], buffer);
        i++;
     }

     fclose(arq1);
     return a;

}


int main(){

    //Imprimir inteiros e reais por linha
    GravarArquivo1();
    int*   i = LerArquivoI();
    float* f = LerArquivoR();

    printf("\nNUMEROS INTEIROS: ");
    ImprmirInt(10, i);

    printf("\n\n");

    printf("\nNUMEROS REAIS: ");
    ImprmirFloat(10, f);

    printf("\n\n");

    //Imprimir caracteres e strings por linha
    //GravarArquivo2();
    char*  c = LerArquivoC();
    char** s = LerArquivoS();

    printf("\nCARACTERES: ");
    ImprmirChar(10, c);

    printf("\n\n");

    printf("\nSTRINGS: ");
    ImprmirString(10, s);

    printf("\n\n");



    //Liberar memoria alocada
    free(i);
    free(f);
    free(c);

    for(int i = 0; i < 10; i++){

        free(s[i]);
    }

    free(s);

    return 0;
}

/** Analises

DETALHE: Trabalhando operacoes com arquivos.



Teste inicial:

        1) Gravacao de 1 a 10 para reais e inteiros.
        2) Leitura de 1 a 10 para reais e inteiros armazenando em arrays.
        3) Gravacao de char e strings.
        4) Leitura de char e strings armazenando em arrays.

        - OBS: Arquivos possuem quantia de dados determinadas pelo programador,
               no caso, 10. Por isso, leitura de dados se torna mais simples.


Explicando funcoes de leitura:

        Todas funcoes de leitura de dados retornam arrays do tipo de dado correspondente,
        ao gravado. Como os formatos dos arquivos eram { dado\n } a leitura nao se torna complexa.
        Para atribuir aos arrays, a funcao fscanf foi utilizada - ela retorna a quantia de dados lidos
        o que usaremos para determinar a quantia de dados existentes no arquivo sem que tenha um numero.
        Para atribuir ao array da string, a funcao fgets foi utilizada, foi criado um buffer temporario
        que lia a linha do arquivo e que, posteriormente, seria copiada parra o array da string.


---> Alocacoes e desalocacoes feitas bem como funcoes para imprimir os dados.


*/
