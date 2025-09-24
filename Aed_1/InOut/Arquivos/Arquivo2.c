#include<stdio.h>
#include<stdlib.h>
#include<string.h>

/** Arquivos

 Os arquivos sao responsaveis por guardas dados e diferentes informacoes.
 Nesta sessao, leremos dados de arquivos que nao possuem suas quantias como
 informacao explicita, seja no proprio arquivo, seja pela informacao.

 -----> COMENTARIOS DEPOIS DA MAIN

*/

typedef struct Pessoa{

        char  nome[50];
        int   id;
        int   idade;
        char  sexo;

} P;



/** Dados Heterogeneos

P* inicializar(P* pessoa){

    for(int i = 0; i < 5; i++){

        strcpy(pessoa[i].nome, " ");
        pessoa[i].id = -1;
        pessoa[i].idade = -1;
        pessoa[i].sexo = ' ';

    }
    return pessoa;
}

P* preencher(P* Pessoa){

    //Definir dados
    char s[50];

    for(int i = 0; i < 5; i++){

        printf("\nNome: ");
        fgets(s, 50, stdin);
        s[strcspn(s, "\n")] = '\0';
        strcpy(Pessoa[i].nome, s);
        Pessoa[i].id = i;
        Pessoa[i].idade = 22 + i;
        printf("\nSexo: ");
        scanf(" %c", &Pessoa[i].sexo);
        getchar();

    }

    return Pessoa;
}

void GravarArquivo3(P* pessoa){

    //Definir dados
    FILE* arq = fopen("PESSOA.TXT", "wt");

    for(int i = 0; i < 5; i++){

        fprintf(arq, "%d: %s, %d, %c\n", pessoa[i].id, pessoa[i].nome, pessoa[i].idade, pessoa[i].sexo);
    }

    fclose(arq);
}

int ContaDadosPessoas(){

    //Definir dados
    FILE* arq = fopen("PESSOA.TXT", "rt");
    int n = 0;
    char linha[100];

    while(fgets(linha, 100, arq) != NULL){

        n++;
    }

    fclose(arq);
    return n;
}

P* LerArquivoPessoas(P* pessoa){

    //Definir dados
    FILE* arq = fopen("PESSOA.TXT", "rt");
    int n = ContaDadosPessoas();

    for(int i = 0; i < n; i++){

        fscanf(arq, "%d: %49[^,], %d, %c\n", &pessoa[i].id, pessoa[i].nome, &pessoa[i].idade, &pessoa[i].sexo);
    }

    fclose(arq);
    return pessoa;
}

void imprimirPessoas(P* pessoa){

    for(int i = 0; i < 5; i++){

        printf("%d: %s, %d, %c\n", pessoa[i].id + 1, pessoa[i].nome, pessoa[i].idade, pessoa[i].sexo);
    }
}
*/

/** Dados homogeneos

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

int ContarDadosArquivoI(char* filename){

    FILE* arq = fopen(filename, "rt");

    int n = 0;
    int a;

    while(fscanf(arq, "%d", &a) == 1){

        n++;
    }

    fclose(arq);
    return n;
}

int ContarDadosArquivoF(char* filename){

    FILE* arq = fopen(filename, "rt");

    int n = 0;
    float a;

    while(fscanf(arq, "%f", &a) == 1){

        n++;
    }

    fclose(arq);
    return n;
}

int ContarDadosArquivoC(char* filename){

    FILE* arq = fopen(filename, "rt");

    int n = 0;
    char a;

    while(fscanf(arq, " %c", &a) == 1){

        n++;
    }

    fclose(arq);
    return n;
}

int ContarDadosArquivoS(char* filename){

    FILE* arq = fopen(filename, "rt");

    int n = 0;
    char buffer[100];

    while(fgets(buffer, 100, arq) != NULL){

        n++;
    }

    fclose(arq);
    return n;
}

int* LerArquivoI(){

     //Definir dados
     FILE* arq1 = fopen("INT.TXT", "rt");
     int* a = (int*)malloc(10 * sizeof(int));
     int n = ContarDadosArquivoI("INT.TXT");

     for(int i = 0; i < n; i++){

         fscanf(arq1, "%d", &a[i]);
     }

     fclose(arq1);
     return a;
}

float* LerArquivoR(){

     //Definir dados
     FILE* arq1 = fopen("FLOAT.TXT", "rt");
     float* a = (float*)malloc(10 * sizeof(float));
     int n = ContarDadosArquivoF("FLOAT.TXT");

     for(int i = 0; i < n; i++){

         fscanf(arq1, "%f", &a[i]);
     }

     fclose(arq1);
     return a;

}

char* LerArquivoC(){

     //Definir dados
     FILE* arq1 = fopen("CHAR.TXT", "rt");
     char* a = (char*)malloc(10 * sizeof(char));
     int n = ContarDadosArquivoC("CHAR.TXT");

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
     int n = ContarDadosArquivoS("STRING.TXT");

     for(int i = 0; i < 10; i++){

         a[i] = (char*)malloc(50 * sizeof(char));
     }

     int i = 0;
     char buffer[50];
     while(fgets(buffer, 50, arq1) != NULL && i < n){

        buffer[strcspn(buffer, "\n")] = '\0';
        strcpy(a[i], buffer);
        i++;
     }

     fclose(arq1);
     return a;

}

*/




int main(){

/** Dados homogeneos

    //Imprimir inteiros e reais por linha
    int*   i = LerArquivoI();
    float* f = LerArquivoR();

    printf("\nNUMEROS INTEIROS: ");
    ImprmirInt(ContarDadosArquivoI("INT.TXT"), i);

    printf("\n\n");

    printf("\nNUMEROS REAIS: ");
    ImprmirFloat(ContarDadosArquivoF("FLOAT.TXT"), f);

    printf("\n\n");

    //Imprimir caracteres e strings por linha
    char*  c = LerArquivoC();
    char** s = LerArquivoS();

    printf("\nCARACTERES: ");
    ImprmirChar(ContarDadosArquivoC("CHAR.TXT"), c);

    printf("\n\n");

    printf("\nSTRINGS: ");
    ImprmirString(ContarDadosArquivoS("STRING.TXT"), s);

    printf("\n\n");



    //Liberar memoria alocada
    free(i);
    free(f);
    free(c);

    for(int i = 0; i < 10; i++){

        free(s[i]);
    }

    free(s);

*/

/** Dados Heterogeneos

    //Definir dados
    P* pessoa = (P*)malloc(5 * sizeof(P));
    pessoa = inicializar(pessoa);

    //pessoa = preencher(pessoa);
    //GravarArquivo3(pessoa);
    pessoa = LerArquivoPessoas(pessoa);
    imprimirPessoas(pessoa);
*/

    return 0;
}




/** Analises

DETALHE: Trabalhando operacoes com arquivos.



Teste inicial:

        1) Dados contados por meio da funcao fscanf, pois ela retorna a quantia de dados
           lidos, enquanto fscanf ler determinada quantia de acordo com a formatacao, o
           contador incrementa uma unidade.


Teste posterior(Dados heterogeneos):

        1) Aplicacao de struct de pessoas com diferentes tipos de dados.
        2) While(fgets) -> Indica se houve dados lidos para contabilizar.
        3) Uso de fscanf com formato especifico do arquivo para guardar valores.

        - OBS: Uso de %49[^,] indica que serao 49 caracteres lidos e virgulas nao serao lidas.


---> Alocacoes e desalocacoes feitas bem como funcoes para imprimir os dados.


*/
