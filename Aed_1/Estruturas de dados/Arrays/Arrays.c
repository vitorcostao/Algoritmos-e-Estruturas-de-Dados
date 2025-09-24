/**

    Arrays -> ESTUDOS DIRIGIDOS THELDO
    Aluno: Vitor Costa Oliveira Rolla
*/

#include<stdio.h>   //Para entrada e saidas
#include<string.h>  //Para trabalhar cadeia de caracteres
#include<stdlib.h>  //Para alocacao de memoria
#include<ctype.h>   //Para trabalhar aspectos das strings
#include<stdbool.h> //Para trabalhar condicoes
#include<time.h>    //Sementes aleatorias


//----------------------------------------------//

void PrintIntArray(int n, int Array[]){

    if(n <= 0){

        printf("\nERROR");
        return;
    }

    for(int i = 0; i < n; i++){

        printf("\n[%d]: %d", i + 1, Array[i]);
    }
}

void metodo_01(){

    int Array[] = {1, 2, 3, 4, 5};

    PrintIntArray(5, Array);

    printf("\n");
}

void ReadIntArray(int n, int Array[]){

    if(n <= 0){

        printf("\nERROR");
        return;
    }

    for(int i = 0; i < n; i++){

        printf("\n[%d]: ", i + 1);
        scanf("%d", &Array[i]);
        getchar();
    }
}

void metodo_02(){

    int Array[5];

    ReadIntArray(5, Array);
    PrintIntArray(5, Array);

    printf("\n");
}

void fprintIntArray(int n, int Array[], char* filename){

    if(n > 0){

        FILE* arquivo = fopen(filename, "wt");

        if(!arquivo){printf("\nERROR"); return;}

        fprintf(arquivo, "\n%d", n);

        for(int i = 0; i < n; i++){

            fprintf(arquivo, "\n%d", Array[i]);
        }

        printf("\n\nVALORES GUARDADOS COM SUCESSO\n\n");
        fclose(arquivo);

    } else {

        printf("\nERROR");
        return;
    }
}

void metodo_03(){

    int Array[5];

    ReadIntArray(5, Array);
    fprintIntArray(5, Array, "ARRAY.TXT");

    printf("\n");
}

int freadArraySize(char* filename){

    //dados
    int n;
    FILE* arquivo = fopen(filename, "rt");

    if(!arquivo){printf("\nERROR"); return -1;}

    fscanf(arquivo, "\n%d", &n);

    fclose(arquivo);
    return n;

}

void freadArray(int n, int Array[], char* filename){

    FILE* arquivo = fopen(filename, "rt");

    if(!arquivo){printf("\nERROR"); return;}

    fscanf(arquivo, "\n%d", &n);

    for(int i = 0; i < n; i++){

        fscanf(arquivo, "\n%d", &Array[i]);
    }

    fclose(arquivo);
}

void metodo_04(){

    int n = freadArraySize("ARRAY.TXT");
    int Array[n];

    freadArray(n, Array, "ARRAY.TXT");

    printf("\n");
}

void CopyIntArray(int n, int Copy[], int Array[]){

    if(n <= 0){ printf("\nERROR"); return;}

    for(int i = 0; i < n; i++){

        Copy[i] = Array[i];
    }
}

void metodo_05(){

    int n = freadArraySize("ARRAY.TXT");

    if(n > 0){

       int Array[n];
       int Other[n];

        freadArray(n, Array, "ARRAY.TXT");
        CopyIntArray(n, Other, Array);
        PrintIntArray(n, Other);
        printf("\n");
        PrintIntArray(n, Array);

    } else { printf("\nERROR"); return;}

    printf("\n");
}

int SumIntArray(int n, int Array[]){

    int soma = 0;

    for(int i = 0; i < n; i++){

        soma = soma + Array[i];
    }

    return soma;
}

void metodo_06(){

    int n = freadArraySize("ARRAY.TXT");

    if(n <= 0){ printf("\nERROR"); return;}

    int array[n]; freadArray(n, array, "ARRAY.TXT");

    printf("\nA soma dos valores do arranjo eh: [%d]", SumIntArray(n, array));

    printf("\n");
}

bool isAllZeros(int n, int Array[]){

    bool Test = true;

    if(n <= 0){ printf("\nERROR"); return false; }

    for(int i = 0; i < n; i++){

        if(Array[i] != 0){

            Test = false;
            return Test;
        }
    }

    return Test;
}

void metodo_07(){

    int n = freadArraySize("ARRAY.TXT");
    int Array[n]; freadArray(n, Array, "ARRAY.TXT");
    bool teste = isAllZeros(n, Array);

    printf("\n(0 - Arranjo com outros numeros / 1 - Arranjo de zeros): ");
    printf(" %d", teste);

    printf("\n");
}

void addIntArray(int n, int array1[], int array2[], int array3[]){

    for(int i = 0; i < n; i++){

        array3[i] = array1[i] + array2[i];
    }

    PrintIntArray(n, array3);
}

void metodo_08(){

    int n = freadArraySize("ARRAY.TXT");

    if(n <= 0){printf("\nERROR"); return;}

    int array1[n]; freadArray(n, array1, "ARRAY.TXT");
    int array2[n]; ReadIntArray(n, array2);
    int array3[n]; addIntArray(n, array1, array2, array3);

    printf("\n");
}

bool isEqual(int n, int Array1[], int Array2[]){

    bool test = true;

    for(int i = 0; i < n; i++){

        if(Array1[i] != Array2[i]){

            test = false;
            return test;
        }
    }

    return test;
}

void metodo_09(){

    int n       = freadArraySize("ARRAY.TXT");

    if(n <= 0){

        printf("\nERROR: Tamanho invalido");
        return;
    }

    int* Array1 = (int*)malloc(n * sizeof(int));

    if(!Array1){

        printf("\nERROR");
        return;
    }

    int* Array2 = (int*)malloc(n * sizeof(int));

    if(!Array2){

        free(Array1);
        printf("\nERROR");
        return;
    }

    freadArray(n, Array1, "ARRAY.TXT");
    ReadIntArray(n, Array2);

    printf("\n(1) - Arrays iguais");
    printf("\n(0) - Arrays Distintos");
    printf("\n\nResult: %d", isEqual(n, Array1, Array2));

    free(Array1);
    free(Array2);
    printf("\n");
}

bool SearchArray(int value, int n, int Array[]){

    bool result = false;

    for(int i = 0; i < n; i++){

        if(value == Array[i]){

            result = true;
            return result;
        }
    }

    return result;
}

void metodo_10(){

    bool result = false;
    int value;
    int n = freadArraySize("ARRAY.TXT");

    if(n <= 0){

        printf("\nERROR");
        return;
    }

    int Array[n];
    freadArray(n, Array, "ARRAY.TXT");

    printf("\nDigite o valor que deseja procurar no Arranjo: ");
    scanf("%d", &value);
    getchar();

    printf("\n(1) - Valor encontrado no Array");
    printf("\n(0) - Valor nao encontrado no Array");
    result = SearchArray(value, n, Array);
    printf("\nResult: %d", result);

    printf("\n");
}

void ReadAndTest(int* Array, int n) {

    printf("\nDigite os valores para o Array:");

    for (int i = 0; i < n; i++) {

        printf("\n\n[%d]: ", i + 1);
        scanf("%d", &Array[i]);
        getchar();


        while (Array[i] % 2 != 0 || Array[i] < 0) {

            printf("Numero impar ou negativo detectado - Insira um numero valido: ");
            scanf("%d", &Array[i]);
            getchar();
        }
    }
}


void metodo_11(){

    int n;

    printf("\nDigite o tamanho do array: ");
    scanf("\n%d", &n);
    getchar();

    if(n <= 0){

        printf("\n  ERROR");
        return;
    }

    int* array = (int*)malloc(n * sizeof(int));

    if(!array){ printf("\n  ERROR"); return;}

    ReadAndTest(array, n);

    free(array);
    printf("\n");
}

int ArraySizeEvenPositive(char* filename, int* array1, int count){

    int n = 0;

    for(int i = 0; i < count; i++){

        if(array1[i] % 2 == 0 && array1[i] > 0){

            n++;
        }
    }

    return n;
}

void ArrayEvenPositive(char* filename, int* array1, int n){

    FILE* arquivo = fopen(filename, "wt");
    if(!arquivo){ printf("\n  ERROR"); return;}

    int tam = ArraySizeEvenPositive("ARRAY1.TXT", array1, n);

    fprintf(arquivo, "\n%d", tam);
    for(int i = 0; i < n; i++){

        if(array1[i] % 2 == 0 && array1[i] > 0){

            fprintf(arquivo, "\n%d", array1[i]);
        }
    }

    printf("\nValores pares e positivos guardados com sucesso");

    fclose(arquivo);
}

void metodo_12(){

    int n      = freadArraySize("ARRAY.TXT");
    if(n <= 0){printf("\n   ERROR"); return;}

    int* Array = (int*)malloc(n * sizeof(int));
    if(!Array){printf("\n   ERROR"); return;}

    freadArray(n, Array, "ARRAY.TXT");
    ArrayEvenPositive("ARRAY1.TXT", Array, n);

    free(Array);
    printf("\n");
}

int* RandonNumbersInterval(int a, int b){

    int n;

    printf("\nDefina a quantia de termos: ");
    scanf("%d", &n);
    getchar();

    if(n > 0){

        int* Array = (int*)malloc(n * sizeof(int));
        if(!Array){ printf("\nError: Memoria nao alocada"); return NULL;}

        srand(time(NULL));

        for(int i = 0; i < n; i++){

            Array[i] = rand() % (b - a + 1) + a;

            while(Array[i] < a || Array[i] > b){

                Array[i] = rand() % (b - a + 1) + a;
            }
        }

        fprintIntArray(n, Array, "DADOS.TXT");
        PrintIntArray(n, Array);
        return Array;

    } else{

        printf("\nERROR: Tamanho invalido");
        return NULL;
    }


}

void metodo_13(){

    int a, b;

    printf("\nValor inicial: ");
    scanf("%d", &a);
    getchar();

    printf("\nValor final: ");
    scanf("%d", &b);
    getchar();

    if(b > a){

       int* Array = RandonNumbersInterval(a, b);
       free(Array);
       printf("\n\nVALORES GUARDADOS COM SUCESSO\n\n");

    } else{

        printf("\nERROR: Intervalos invalidos");
    }

    printf("\n");
}

int MenorImpar(int n, int* Array) {

    int menor = 9999999;
    int encontrou_impar = 0;

    for (int i = 0; i < n; i++) {
        if (Array[i] % 2 != 0 && Array[i] < menor) {
            menor = Array[i];
            encontrou_impar = 1;
        }
    }

    if (encontrou_impar) {
        return menor;
    } else {
        printf("\nNao foi encontrado nenhum numero impar.\n");
        return -1;
    }
}

int* LerDoArquivo(int* n, char* filename){

    FILE* arquivo = fopen(filename, "rt");
    if(!arquivo){printf("\nERROR: Nao foi possivel abrir o arquivo"); return NULL;}

    fscanf(arquivo, "\n%d", n);

    if(*n > 0){

        int* Array = (int*)malloc(*n * sizeof(int));
        if(!Array){printf("\nERROR: Nao foi possivel abrir o arquivo"); return NULL;}


        for(int i = 0; i < *n; i++){

            fscanf(arquivo, "\n%d", &Array[i]);
        }

        printf("\n\nVALORES LIDOS COM SUCESSO\n\n");
        fclose(arquivo);
        return Array;

    } else {

        printf("\nERROR: Tamanho invalido");
        fclose(arquivo);
        return NULL;
    }
}

void metodo_14(){

    int n = 0;
    int* Array = LerDoArquivo(&n, "DADOS.TXT");

    int menor = MenorImpar(n, Array);

    printf("\nO menor valor do arranjo e: %d", menor);

    printf("\n");
}

int MaiorImpar(int n, int* Array) {

    int maior = -9999999;
    int encontrou_impar = 0;

    for (int i = 0; i < n; i++) {
        if (Array[i] % 2 != 0 && Array[i] > maior) {
            maior = Array[i];
            encontrou_impar = 1;
        }
    }

    if (encontrou_impar) {
        return maior;
    } else {
        printf("\nNao foi encontrado nenhum numero impar.\n");
        return -1;
    }
}

void metodo_15(){

    int n = 0;
    int* Array = LerDoArquivo(&n, "DADOS.TXT");

    int maior = MaiorImpar(n, Array);

    printf("\nO menor valor do arranjo e: %d", maior);

    printf("\n");
}

int foundMedia(int n, int* Array){

    int i     = 0;
    int soma  = 0;
    int media = 0;

    for(i = 0; i < n; i++){

        soma = soma + Array[i];
    }

    media = soma / (i + 1);

    return media;
}

void ArquivosMedias(char* filename1 ,char* filename2, int* Array, int media, int n){

    printf("\nMedia = %d", media);

    FILE* arquivo1 = fopen(filename1, "wt");
    if(!arquivo1){printf("\nERROR: Nao foi possivel abrir o arquivo 1"); return;}

    FILE* arquivo2 = fopen(filename2, "wt");
    if(!arquivo2){printf("\nERROR: Nao foi possivel abrir o arquivo 1"); return;}

    fprintf(arquivo1, "%s\n\n", "VALORES MENORES OU IGUAIS A MEDIA");
    fprintf(arquivo2, "%s\n\n", "VALORES MAIORES QUE A MEDIA");

    for(int i = 0; i < n; i++){

        if(Array[i] <= media){

            fprintf(arquivo1, "\n%d", Array[i]);

        } else {

            fprintf(arquivo2, "\n%d", Array[i]);
        }
    }

    fclose(arquivo1);
    fclose(arquivo2);
}

void metodo_16(){

    int n = 0;
    int* Array = LerDoArquivo(&n, "DADOS.TXT");

    if(n > 0){

        int media = foundMedia(n, Array);
        ArquivosMedias("MENORIGUAL.TXT", "MAIOR.TXT", Array, media, n);
        printf("\n\nVALORES GUARDADOS COM SUCESSO EM SEUS RESPECTIVOS ARQUIVOS\n\n");

    }
    printf("\n");
}

bool IsDecrescentArray(int* array, int n){

    bool test = true;

    for(int i = 0; i < n - 1; i++){

        if(array[i] < array[i + 1]){

            test = false;
            return test;
        }
    }

    return test;
}

void metodo_17(){

    bool test = true;
    int n;

    printf("\nDefina o tamanho do Array: ");
    scanf("%d", &n);
    getchar();

    if(n > 0){

        int* array = (int*)malloc(n * sizeof(int));
        if(!array){printf("\nERROR: Nao foi possivel alocar memoria"); return;}

        ReadIntArray(n, array);

        test = IsDecrescentArray(array, n);

        printf("\n(0) - Para Array nao ordenado em decrescente");
        printf("\n(1) - Para Array ordenado em decrescente");
        printf("\n\nResult[%d]", test);

        free(array);

    } else {

        printf("\nERROR: Tamanho invalido");
    }

    printf("\n");
}

void SearchValueArray(int procurado, int pi, int n, int* Array){

    while(pi < n){

        if(Array[pi] == procurado){

            printf("\n\nVALOR %d ENCONTRADO NA POSICAO %d",procurado ,pi);
            return;
        }

        pi++;
    }

    printf("\n\nVALOR %d NAO ENCONTRADO A PARTIR DA POSICAO INDICADA", procurado);
}

void metodo_18(){

    int n  = 0;
    int pi = 0;
    int procurado = 0;

    int* array = LerDoArquivo(&n, "DADOS.TXT");

    if(n > 0){

        printf("\nDigite o valor a ser procurado: ");
        scanf("%d", &procurado);
        getchar();

        printf("\nDigite a partir de qual posicao se deseja procurar: ");
        scanf("%d", &pi);
        getchar();

        if(pi >= 0){

            SearchValueArray(procurado, pi, n, array);

        } else {

            printf("\nERROR: Tamanho invalido");

        }



    } else {

        printf("\nERROR: Tamanho invalido");
    }

    printf("\n");
}

void metodo_19(){

    printf("\n\nMETODO 18 FOI FEITO INDICANDO VALOR E POSICAO");
    printf("\nPARA SEGUIR O METODO 19, FAZER APENAS ALGUMAS ALTERACOES NO METODO ACIMA");

    printf("\n");
}

int SearchValueTimes(int procurado, int pi, int n, int* Array){

    int contador = 0;

    while(pi < n){

        if(Array[pi] == procurado){

            contador++;
        }

        pi++;
    }

    return contador;
}

void metodo_20(){

    int n         = 0;
    int pi        = 0;
    int procurado = 0;
    int count     = 0;

    int* array = LerDoArquivo(&n, "DADOS.TXT");

    if(n > 0){

        printf("\nDigite o valor a ser procurado: ");
        scanf("%d", &procurado);
        getchar();

        printf("\nDigite a partir de qual posicao se deseja procurar: ");
        scanf("%d", &pi);
        getchar();

        if(pi >= 0){

            count = SearchValueTimes(procurado, pi, n, array);
            printf("\nO valor %d aparece %d vezes no Array a partir da posicao indicada", procurado, count);

        } else {

            printf("\nERROR: Tamanho invalido");

        }



    } else {

        printf("\nERROR: Tamanho invalido");
    }

    printf("\n");
}

int* DivisoresImpares(int *array, int value){

    int n = 0;

    for(int i = 1; i <= value; i++){

        if(i % 2 != 0 && value % i == 0){

            n++;
        }
    }

    if(n > 0){

       array = (int*)malloc(n * sizeof(int));
       if(!array){printf("\nERROR: Nao foi possivel alocar memoria"); return NULL;}

       int Po = 0;

       for(int i = 1; i <= value; i++){

           if(i % 2 != 0 && value % i == 0){
              array[Po] = i;
              Po++;
           }
       }


       PrintIntArray(n, array);
       fprintIntArray(n, array, "DIVISORES.TXT");
       return array;

    } else {

        printf("\nERROR: Tamanho invalido");
        return NULL;
    }
}

void metodo_21(){

    int value = 0;

    printf("\nDigite um valor inteiro: ");
    scanf("%d", &value);
    getchar();

    int* array = DivisoresImpares(array, value);

    free(array);
    printf("\n");
}

void escreverPalavras(char* filename) {

    int n = 0;
    FILE* arquivo = fopen(filename, "wt");
    if (!arquivo) {
        printf("\nERROR: Nao foi possivel abrir o arquivo");
        return;
    }

    char Palavra[50];

    while (n < 100) {

        printf("\n");

        fgets(Palavra, 50, stdin)
        Palavra[strcspn(Palavra, "\n")] = '\0';

        if (strcmp(Palavra, "PARAR") == 0) {
            printf("\nRetornando . . .");
            break;
        }

        fprintf(arquivo, "%s\n", Palavra);
        n++;
    }

    fclose(arquivo);
}

void LerPalavras(char* filename) {

    FILE* arquivo = fopen(filename, "rt");
    if (!arquivo) {
        printf("\nERROR: Nao foi possivel abrir o arquivo");
        return;
    }

    char Palavra[50];
    int c = 0;

    while (fscanf(arquivo, "%49s", Palavra) == 1 && c < 10) {
        int len = strlen(Palavra);

        if (len > 0 && (Palavra[0] == 'C' || Palavra[0] == 'c' ||
                        Palavra[len - 1] == 'C' || Palavra[len - 1] == 'c')) {
            printf("\n%s", Palavra);
        }

        c++;
    }

    fclose(arquivo);
}

void metodo_22(){

    escreverPalavras("PALAVRAS.TXT");
    LerPalavras("PALAVRAS.TXT");
    printf("\n");
}

int main (){

    int opcao = 1;

    do{

        printf("\nDigite a opcao: ");
        scanf("%d", &opcao);
        getchar();


        switch(opcao){

        case 0:
            printf("\nEncerrar . . . ");
            break;

        case 1:
            metodo_01();
            break;

        case 2:
            metodo_02();
            break;

        case 3:
            metodo_03();
            break;

        case 4:
            metodo_04();
            break;

        case 5:
            metodo_05();
            break;

        case 6:
            metodo_06();
            break;

        case 7:
            metodo_07();
            break;

        case 8:
            metodo_08();
            break;

        case 9:
            metodo_09();
            break;

        case 10:
            metodo_10();
            break;

        case 11:
            metodo_11();
            break;

        case 12:
            metodo_12();
            break;

        case 13:
            metodo_13();
            break;

        case 14:
            metodo_14();
            break;

        case 15:
            metodo_15();
            break;

        case 16:
            metodo_16();
            break;

        case 17:
            metodo_17();
            break;

        case 18:
            metodo_18();
            break;

        case 19:
            metodo_19();
            break;

        case 20:
            metodo_20();
            break;

        case 21:
            metodo_21();
            break;

        case 22:
            metodo_22();
            break;

        default:
            printf("Opcao invalida . . .");
            break;
        }

    } while(opcao != 0);

    return 0;
}
