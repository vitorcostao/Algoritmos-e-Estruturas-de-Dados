/**

    STRUCTS ARRAYS -> ESTUDOS DIRIGIDOS THELDO
    Aluno: Vitor Costa Oliveira Rolla
*/

#include<stdio.h>   //Para entrada e saidas
#include<stdlib.h>  //Para alocacao de memoria
#include<string.h>  //Para trabalhar cadeia de caracteres
#include<ctype.h>   //Para trabalhar aspectos das strings
#include<stdbool.h> //Para trabalhar booleanos
#include<time.h>    //Para sementes aleatorias

//----------------------------------------------//

typedef
struct int_array {

     int  length;
     int* data;
     int   Ix;

} IntA;

typedef IntA* RefIntA;


RefIntA Inicializar_Array(int n){

    RefIntA ponteiro = (RefIntA)malloc(sizeof(IntA));

    if(!ponteiro){

        printf("\nERROR: Nao foi possivel alocar memoria");
        return NULL;

    } else {

        ponteiro->data = (int*)malloc(n * sizeof(int));
        if(!ponteiro->data){

            printf("\nERROR: Nao foi possivel alocar memoria para data");
            return NULL;
        }

        ponteiro->length = n;
        ponteiro->Ix     = 0;

        return ponteiro;
    }
}

void FreeArray(RefIntA NewArray){

    if(NewArray){
        if(NewArray->data){

            free(NewArray->data);
        }

        free(NewArray);
    }
}

/**

Printar Arranjo:

1) Testa se ha dados
2) For para percorrer e printar

*/

void PrintIntArray(IntA Array){

    if(Array.data){

        for(Array.Ix = 0; Array.Ix < Array.length; Array.Ix++){

            printf("\n[%d]: %d", Array.Ix + 1, Array.data[Array.Ix]);
        }
    }
}

void metodo_01(){

    int n;

    do {

        printf("\nDefina o tamanho do Array: ");
        scanf("%d", &n);
        getchar();

    } while(n <= 0);

    RefIntA Arranjo = Inicializar_Array(n);
    if(Arranjo->data){

        for(Arranjo->Ix = 0; Arranjo->Ix < Arranjo->length; Arranjo->Ix++){

            Arranjo->data[Arranjo->Ix] = 2 * Arranjo->Ix;
        }

        PrintIntArray(*Arranjo);
    }

    FreeArray(Arranjo);
    printf("\n");
}


IntA readIntArray(){

    IntA Arranjo;

    do{

        printf("\nDetermine o tamanho do array: ");
        scanf("%d", &Arranjo.length);
        getchar();

    } while(Arranjo.length <= 0);

    Arranjo.data = (int*)malloc(Arranjo.length * sizeof(int));

    if(!Arranjo.data){

        printf("\nERROR: Nao foi possivel alocar memoria");

    } else {

        printf("\nDefina os valores do Array: \n");

        for(Arranjo.Ix = 0; Arranjo.Ix < Arranjo.length; Arranjo.Ix++){

            printf("\n[%d]: ", Arranjo.Ix + 1);
            scanf("%d", &Arranjo.data[Arranjo.Ix]);
            getchar();
        }

    }

    Arranjo.Ix = 0;
    return Arranjo;
}

void metodo_02(){

     IntA Array = readIntArray();

     if(Array.data){

        printf("\n");
        PrintIntArray(Array);
        free(Array.data);

     }

    printf("\n");
}

void fprintIntArray(char* filename, IntA Array){

    FILE* arquivo = fopen(filename, "wt");

    if(!arquivo){

        printf("\nERROR: Nao foi possivel abrir o arquivo");
        return;

    } else {

        fprintf(arquivo, "%d\n", Array.length);

        for(Array.Ix = 0; Array.Ix < Array.length; Array.Ix++){

            fprintf(arquivo, "%d\n", Array.data[Array.Ix]);
        }

        printf("\n\nVALORES GUARDADOS COM SUCESSO EM %s", filename);
        fclose(arquivo);
    }
}

void metodo_03(){

     IntA array = readIntArray();

     if(array.data){

        PrintIntArray(array);
        fprintIntArray("DADOS2.TXT", array);

        free(array.data);

     } else {

        printf("\nNao ha dados disponiveis");
     }

     printf("\n");
}

int freadArraySize(char* filename){

    int n = 0;

    FILE* arquivo = fopen(filename, "rt");
    if(!arquivo){

        printf("\nERROR: Nao foi possivel abrir o arquivo");

    } else {

        fscanf(arquivo, "%d", &n);

        if(n <= 0){

            printf("\nERROR: Tamanho invalido");
            n = 0;
        }

        fclose(arquivo);
    }

    return n;
}

IntA freadArray(char* filename){

    IntA arranjo;
    arranjo.Ix = 0;

    FILE* arquivo = fopen(filename, "rt");

    if(!arquivo){

        printf("\nERROR: Nao foi possivel abrir o arquivo ou ele nao existe");
        return arranjo;
    }

    fscanf(arquivo, "%d", &arranjo.length);
    if(arranjo.length <= 0){printf("\nERROR: Tamanho invalido"); fclose(arquivo); return arranjo;}

    arranjo.data = (int*)malloc(arranjo.length * sizeof(int));
    if(!arranjo.data){printf("\nERROR: Nao foi possivel alocar memoria"); return arranjo;}

    while(!feof(arquivo) && arranjo.Ix < arranjo.length){

        fscanf(arquivo, "%d", &arranjo.data[arranjo.Ix]);
        arranjo.Ix++;
    }


    printf("\nVALORES LIDOS DO ARQUIVO %s COM SUCESSO", filename);
    fclose(arquivo);
    return arranjo;
}

void metodo_04(){

     IntA array = freadArray("ARRAY1.TXT");

     if(array.data){

        printf("\n");
        PrintIntArray(array);
        free(array.data);
     }

     printf("\n");
}

RefIntA copyIntArray(IntA array){

    RefIntA other = (RefIntA)malloc(sizeof(IntA));
    if(!other){

        printf("\nERROR: Nao foi possivel alocar memoria");
        return NULL;

    }

    if(array.length > 0){

        other->data = (int*)malloc(array.length * sizeof(int));
        if(!other->data){printf("\nERROR: Nao foi possivel alocar memoria de data"); free(other); return NULL;}

        for(other->Ix = 0; other->Ix < array.length; other->Ix++){

            other->data[other->Ix] = array.data[other->Ix];
        }

        other->Ix     = 0;
        other->length = array.length;

        return other;

    } else {

        printf("\nERROR: Tamanho invalido");
        return NULL;
    }
}

void metodo_05(){

    IntA array = freadArray("ARRAY1.TXT");

    if(array.data){

        RefIntA other = copyIntArray(array);

        printf("\n\nOriginal: ");
        PrintIntArray(array);

        printf("\n\nCopia: ");
        PrintIntArray(*other);

        free(array.data);
        FreeArray(other);

    } else {

        printf("\nERROR: Nao ha dados");
    }
    printf("\n");
}

typedef
struct intMatrix{

    int rows;
    int cols;
    int** data;
    int ix, iy;

} IntM;

typedef IntM* refIntM;

/**

1) Ler dimensoes com testes de verificacao
2) Aloca memoria para a estrutura e testa
3) Aloca memoria para ponteiro data** e testa
4) Aloca memoria para ponteiro data* e testa
5) Liberar memoria nos casos em que nao foi possivel alocar
6) 3 alocacoes demandam 3 liberacoes

*/

refIntM NovaMatrix(int l, int c){

    if(l <= 0 || c <= 0){

        printf("\nERROR: Dimensoes invalidas");
        return NULL;

    } else {

        refIntM NewMatrix = (refIntM)malloc(sizeof(IntM));
        if(!NewMatrix){

            printf("\nERROR: Nao foi possivel alocar memoria");
            return NULL;

        }

        NewMatrix->cols = c;
        NewMatrix->rows = l;
        NewMatrix->ix   = 0;
        NewMatrix->iy   = 0;
        NewMatrix->data = (int**)malloc(NewMatrix->rows * sizeof(int*));

        if(!NewMatrix->data){

            printf("\nERROR: Nao foi possivel alocar memoria");
            free(NewMatrix);
            return NULL;
        }

        for(NewMatrix->ix = 0; NewMatrix->ix < NewMatrix->rows; NewMatrix->ix++){

            NewMatrix->data[NewMatrix->ix] = (int*)malloc(NewMatrix->cols * sizeof(int));

            if(!NewMatrix->data[NewMatrix->ix]){

                printf("\nERROR: Nao foi possivel alocar memoria");
                for(int i = 0; i < NewMatrix->ix; i++){

                    free(NewMatrix->data[i]);
                }

                free(NewMatrix->data);
                free(NewMatrix);
                return NULL;
            }
        }

        NewMatrix->ix = 0;
        NewMatrix->iy = 0;
        return NewMatrix;

    }
}

void freeMatrix(refIntM Matrix){

    if(Matrix){

        if(Matrix->data){

            for(Matrix->ix = 0; Matrix->ix < Matrix->rows; Matrix->ix++){

                free(Matrix->data[Matrix->ix]);
            }

            free(Matrix->data);
        }
        free(Matrix);
    }
}

void PrintIntMatrix(refIntM Matrix){

    for(Matrix->ix = 0; Matrix->ix < Matrix->rows; Matrix->ix++){
        for(Matrix->iy = 0; Matrix->iy < Matrix->cols; Matrix->iy++){

            printf("[%d]\t", Matrix->data[Matrix->ix][Matrix->iy]);
        }
        printf("\n");
    }

}


void metodo_06(){

     int l = 0;;
     printf("\nDigite as linha: ");
     scanf("%d", &l);
     getchar();

     int c = 0;
     printf("\nDigite as colunas: ");
     scanf("%d", &c);
     getchar();

     refIntM Matrix = NovaMatrix(l, c);

     if(Matrix && Matrix->data){

        for(Matrix->ix = 0; Matrix->ix < Matrix->rows; Matrix->ix++){
            for(Matrix->iy = 0; Matrix->iy < Matrix->cols; Matrix->iy++){

                Matrix->data[Matrix->ix][Matrix->iy] = Matrix->ix * Matrix->ix;
            }
        }
        PrintIntMatrix(Matrix);
     }

    freeMatrix(Matrix);
    printf("\n");
}

void readIntMatrix(refIntM Matrix){

    printf("\n\nDefina os valores da matriz: ");
    for(Matrix->ix = 0; Matrix->ix < Matrix->rows; Matrix->ix++){
        for(Matrix->iy = 0; Matrix->iy < Matrix->cols; Matrix->iy++){

            printf("\n\n[%d][%d]: ", Matrix->ix + 1, Matrix->iy + 1);
            scanf("%d", &Matrix->data[Matrix->ix][Matrix->iy]);
            getchar();
        }
        printf("\n");
    }
}

void metodo_07(){

    int l = 0;;
    printf("\nDigite as linha: ");
    scanf("%d", &l);
    getchar();

    int c = 0;
    printf("\nDigite as colunas: ");
    scanf("%d", &c);
    getchar();

    refIntM matrix = NovaMatrix(l, c);

    if(matrix && matrix->data){

        readIntMatrix(matrix);
        PrintIntMatrix(matrix);
    }

}

void fprintIntMatrix(char* filename, refIntM matrix){

    FILE* arquivo = fopen(filename, "wt");
    if(!arquivo){

        printf("\nERROR: Nao foi possivel abrir o arquivo");
        freeMatrix(matrix);
        return;
    }

    fprintf(arquivo, "%d\n", matrix->rows);
    fprintf(arquivo, "%d\n", matrix->cols);

    for(matrix->ix = 0; matrix->ix < matrix->rows; matrix->ix++){
        for(matrix->iy = 0; matrix->iy < matrix->cols; matrix->iy++){

            fprintf(arquivo, "%d\n", matrix->data[matrix->ix][matrix->iy]);
        }
    }

    printf("\nVALORES GUARDADOS COM SUCESSO EM %s\n\n", filename);
    matrix->ix = 0;
    matrix->iy = 0;
    fclose(arquivo);
}

void metodo_08(){

    int l = 0;;
    printf("\nDigite as linha: ");
    scanf("%d", &l);
    getchar();

    int c = 0;
    printf("\nDigite as colunas: ");
    scanf("%d", &c);
    getchar();

    refIntM matrix = NovaMatrix(l, c);

    if(matrix && matrix->data){

        readIntMatrix(matrix);
        fprintIntMatrix("MATRIX1.TXT", matrix);

    } else {

        printf("\nERROR: Nao ha dados disponiveis");
    }

    freeMatrix(matrix);

}

refIntM freadMatrix(char* filename){

    FILE* arquivo = fopen(filename, "rt");
    if(!arquivo){

        printf("\nERROR: Nao foi possivel abrir o arquivo.");
        return NULL;
    }

    int l = 0;
    int c = 0;

    fscanf(arquivo, "%d", &l);
    fscanf(arquivo, "%d", &c);

    if(l <= 0 || c <= 0){

       printf("\nERROR: Dimensoes invalidas");
       return NULL;

    }

    refIntM Matrix = NovaMatrix(l, c);


    if(Matrix && Matrix->data){

        for(Matrix->ix = 0; Matrix->ix < Matrix->rows; Matrix->ix++){
            for(Matrix->iy = 0; Matrix->iy < Matrix->cols; Matrix->iy++){

                fscanf(arquivo, "%d", &Matrix->data[Matrix->ix][Matrix->iy]);
            }
        }

        printf("\nVALORES LIDOS DE %s COM SUCESSO.\n\n", filename);
        fclose(arquivo);
        return Matrix;


    } else {

        printf("\nERROR: Nao ha dados disponiveis");
        fclose(arquivo);
        return NULL;
    }
}

void metodo_09(){

    refIntM matrix = freadMatrix("MATRIX1.TXT");
    printf("\n");

    if(!matrix){

        return;
    }

    PrintIntMatrix(matrix);
    freeMatrix(matrix);
    printf("\n");
}

refIntM copyIntMatrix(refIntM matrix){

    refIntM other = NovaMatrix(matrix->rows, matrix->cols);

    if(other && other->data){

        for(other->ix = 0; other->ix < other->rows; other->ix++){
            for(other->iy = 0; other->iy < other->cols; other->iy++){

                other->data[other->ix][other->iy] = matrix->data[other->ix][other->iy];
            }
        }

        return other;

    } else {

        printf("\nNao ha dados disponiveis");
        return NULL;
    }

}

void metodo_10(){

     refIntM matrix = freadMatrix("MATRIX1.TXT");

     if(!matrix){

        return;
     }

     refIntM other = copyIntMatrix(matrix);

     printf("\n\nOther: \n\n");
     PrintIntMatrix(other);

     printf("\n");
}

RefIntA RandomNumbers(int inicio, int fim){

     if(inicio < fim){

        int n;

        do {

            printf("\nDefina o tamanho do Array: ");
            scanf("%d", &n);
            getchar();

        } while(n <= 0);

        RefIntA arranjo = Inicializar_Array(n);

        srand(time(NULL));

        for(arranjo->Ix = 0; arranjo->Ix < arranjo->length; arranjo->Ix++){

            arranjo->data[arranjo->Ix] = rand() % fim - inicio - 1;

        }

        return arranjo;

     } else {

        printf("\nERROR: O valor inicial deve ser menor que o final");
        return NULL;
     }
}

void metodo_11(){

     int inicio, fim;

     printf("\nDefina o inicio: ");
     scanf("%d", &inicio);
     getchar();

     printf("\nDefina o fim: ");
     scanf("%d", &fim);
     getchar();

     RefIntA array = RandomNumbers(inicio, fim);
     fprintIntArray("DADOS.TXT", *array);
     PrintIntArray(*array);
     printf("\n");

}

int SearchArray(RefIntA array, int value){


    for(array->Ix = 0; array->Ix < array->length; array->Ix++){

        if(array->data[array->Ix] == value){

           return array->Ix;
        }
    }
}

void metodo_12(){

     int value    = 0;
     int position = -1;
     IntA array   = freadArray("DADOS.TXT");

     if(array.data == NULL){

        return;
     }

     printf("\n\nDigite o valor que deseja procurar no arranjo: ");
     scanf("%d", &value);
     getchar();

     position = SearchArray(&array, value);

     if(position != -1){

        printf("\nO valor %d foi encontrado na posicao %d dentro do arranjo lido", value, position);

     } else {

        printf("\nO valor nao esta presente no arranjo lido");
     }

     printf("\n");
}

bool CompareArray(IntA Array1, IntA Array2){

    bool test = true;

    if(Array1.length != Array2.length){

        test = false;
        return test;

    } else {

        for(Array1.Ix = 0; Array1.Ix < Array1.length; Array1.Ix++){

            if(Array1.data[Array1.Ix] != Array2.data[Array1.Ix]){

                test = false;
                return test;
            }
        }

        return test;
    }
}

void metodo_13(){

     IntA arranjo1 = freadArray("DADOS1.TXT");
     printf("\n");
     IntA arranjo2 = freadArray("DADOS2.TXT");
     printf("\n");
     bool test = CompareArray(arranjo1, arranjo2);

     if(test){

        printf("\nOs Array 1 e 2 sao iguais");
        printf("\n");
        PrintIntArray(arranjo1);
        printf("\n");
        PrintIntArray(arranjo2);

     } else {

        printf("\nOs Array 1 e 2 sao diferentes");
        PrintIntArray(arranjo1);
        printf("\n");
        PrintIntArray(arranjo2);
     }


     printf("\n");
}

IntA soma(IntA array1, IntA array2){

        IntA soma;
        int k = 0;

        printf("\nDefina a constante: ");
        scanf("%d", &k);
        getchar();

        if(array1.length != array2.length){

            printf("\nERROR: Nao eh possivel soma arranjos com tamanhos distintos");

            soma.data   = NULL;
            soma.Ix     = -1;
            soma.length = 0;
            return soma;


        }

        soma.data   = (int*)malloc(array1.length * sizeof(int));
        soma.length = array1.length;

        if(!soma.data){

            printf("\nERROR: Nao foi possivel alocar memoria");
            soma.data   = NULL;
            soma.Ix     = -1;
            soma.length = 0;
            return soma;
        }

        for(soma.Ix = 0; soma.Ix < soma.length; soma.Ix++){

            soma.data[soma.Ix] = array1.data[soma.Ix] + (k * array2.data[soma.Ix]);
        }

        soma.length = array1.length;
        soma.Ix = 0;
        return soma;

}

void metodo_14(){

     IntA array1 = freadArray("DADOS1.TXT");
     IntA array2 = freadArray("DADOS2.TXT");

     IntA Soma   = soma(array1, array2);

     PrintIntArray(Soma);

}


bool Decrescent(IntA arranjo){

     bool test = true;

     for(arranjo.Ix = 0; arranjo.Ix < arranjo.length - 1; arranjo.Ix++){
        for(int j = arranjo.Ix + 1; j < arranjo.length; j++){
            if(arranjo.data[arranjo.Ix] < arranjo.data[j]){

               test = false;
               return test;

           }
        }
     }

    return test;
}

void metodo_15(){

     IntA arranjo = freadArray("DADOS1.TXT");
     bool test = Decrescent(arranjo);

     if(test){

        printf("\nO arranjo esta em ordem descrescente\n\n");
        PrintIntArray(arranjo);

     } else {

        printf("\nO arranjo nao esta em ordem descrescente\n\n");
        PrintIntArray(arranjo);
     }

    printf("\n");
}

refIntM transpose(IntM matrix){

        refIntM matrix2 = NovaMatrix(matrix.cols, matrix.rows);

        for(matrix2->ix = 0; matrix2->ix < matrix2->rows; matrix2->ix++){
            for(matrix2->iy = 0; matrix2->iy < matrix2->cols; matrix2->iy++){

                matrix2->data[matrix2->ix][matrix2->iy] = matrix.data[matrix2->iy][matrix2->ix];

            }
        }

        return matrix2;
}

void metodo_16(){

     refIntM matrix1 = freadMatrix("MATRIX1.TXT");

     if(!matrix1){

        printf("\n");
        return;
     }

     refIntM matrix2 = transpose(*matrix1);
     PrintIntMatrix(matrix2);

     freeMatrix(matrix1);
     freeMatrix(matrix2);
     printf("\n");
}

bool isAllZeros(IntM matrix){

    bool test = true;

    for(matrix.ix = 0; matrix.ix < matrix.rows; matrix.ix++){
        for(matrix.iy = 0; matrix.iy < matrix.cols; matrix.iy++){

            if(matrix.data[matrix.ix][matrix.ix] != 0){

                test = false;
                return test;
            }
        }
    }

    return test;
}

void metodo_17(){

     refIntM matrix = freadMatrix("MATRIX1.TXT");

     if(!matrix){

        printf("\n");
        return;
     }

     bool test = isAllZeros(*matrix);

     if(test){

        printf("\nA matriz eh compostas de zeros");
        printf("\n");
        PrintIntMatrix(matrix);

     } else {

        printf("\nA matriz eh compostas de outros numeros alem de zero");
        printf("\n");
        PrintIntMatrix(matrix);
     }

     freeMatrix(matrix);
     printf("\n");
}

bool CompareMatrix(IntM matrix1, IntM matrix2){

    bool test = true;

    if(matrix1.cols != matrix2.cols ||
       matrix1.rows != matrix2.rows){

       test = false;
       return test;

    } else {

        for(matrix1.ix = 0; matrix1.ix < matrix1.rows; matrix1.ix++){
            for(matrix1.iy = 0; matrix1.iy < matrix1.cols; matrix1.iy++){

                if(matrix1.data[matrix1.ix][matrix1.iy] !=
                   matrix2.data[matrix1.ix][matrix1.iy]){

                    test = false;
                    return test;
                }
            }
        }

        return test;
    }
}

void metodo_18(){

     refIntM matrix1 = freadMatrix("MATRIX1.TXT");
     refIntM matrix2 = freadMatrix("MATRIX2.TXT");

     if(!matrix1 || !matrix2){

        if(matrix1 && !matrix2){

            freeMatrix(matrix1);

        } else if(matrix2 && !matrix1){

            freeMatrix(matrix1);
        }

        return;
     }

     bool test = CompareMatrix(*matrix1, *matrix2);

     if(test){

        printf("\nSao matrizes iguais: \n");
        printf("\nMatrix 1: \n"); PrintIntMatrix(matrix1);
        printf("\nMatrix 2: \n"); PrintIntMatrix(matrix2);

     } else {

        printf("\nSao matrizes distintas: \n");
        printf("\nMatrix 1: \n"); PrintIntMatrix(matrix1);
        printf("\nMatrix 2: \n"); PrintIntMatrix(matrix2);
     }

     freeMatrix(matrix1);
     freeMatrix(matrix2);
     printf("\n");
}

refIntM sumMatrix(IntM matrix1, IntM matrix2){

    if(matrix1.cols != matrix2.cols ||
       matrix1.rows != matrix2.rows){

       printf("\nERROR: Matrizes com dimensoes distintas");
       return NULL;
    }

    refIntM soma = NovaMatrix(matrix1.rows, matrix1.cols);

    int k = 0;

    printf("\nDefina uma constante a ser aplicada: ");
    scanf("%d", &k);
    getchar();

    for(matrix1.ix = 0; matrix1.ix < matrix1.rows; matrix1.ix++){
        for(matrix1.iy = 0; matrix1.iy < matrix1.cols; matrix1.iy++){

            soma->data[matrix1.ix][matrix1.iy] = matrix1.data[matrix1.ix][matrix1.iy] + (k * matrix2.data[matrix1.ix][matrix1.iy]);
        }
    }


    return soma;
}

void metodo_19(){

     refIntM matrix1 = freadMatrix("MATRIX1.TXT");
     PrintIntMatrix(matrix1);
     printf("\n");

     refIntM matrix2 = freadMatrix("MATRIX2.TXT");
     PrintIntMatrix(matrix2);
     printf("\n");

     if(matrix1 && matrix1->data &&
        matrix2 && matrix2->data){

        refIntM soma = sumMatrix(*matrix1, *matrix2);

        if(soma && soma->data){

            printf("\nMatrix Soma: \n");
            PrintIntMatrix(soma);
            printf("\n");

            freeMatrix(matrix1);
            freeMatrix(matrix2);
            freeMatrix(soma);
            return;

        } else {

            printf("\nERROR: Nao ha dados");
            freeMatrix(matrix1);
            freeMatrix(matrix2);
            return;
        }

     } else {

        printf("\nERROR: Nao ha dados");
        return;
     }
}

refIntM multiplieMatrix(IntM matrix1, IntM matrix2){

        if(matrix1.cols != matrix2.rows){

            printf("\nERROR: Matrizes com dimensoes invalidas");
            return NULL;
        }

        refIntM matrix = NovaMatrix(matrix1.rows, matrix2.cols);


        for(matrix->ix = 0; matrix->ix < matrix->rows; matrix->ix++){
            for(matrix->iy = 0; matrix->iy < matrix->cols; matrix->iy++){

                int soma = 0;

                for(int k = 0; k < matrix1.cols; k++){

                    soma = soma + (matrix1.data[matrix->ix][k] * matrix2.data[k][matrix->iy]);
                }

                matrix->data[matrix->ix][matrix->iy] = soma;
            }
        }

        matrix->ix = 0;
        matrix->iy = 0;
        return matrix;
}

void metodo_20(){

     refIntM matrix1 = freadMatrix("MATRIX1.TXT");
     PrintIntMatrix(matrix1);
     printf("\n");

     refIntM matrix2 = freadMatrix("MATRIX2.TXT");
     PrintIntMatrix(matrix2);
     printf("\n");

     if(matrix1 && matrix1->data &&
        matrix2 && matrix2->data){

        refIntM mul = multiplieMatrix(*matrix1, *matrix2);

        if(mul && mul->data){

            printf("\nMatrix multiplicada: \n");
            PrintIntMatrix(mul);
            printf("\n");

            freeMatrix(matrix1);
            freeMatrix(matrix2);
            freeMatrix(mul);
            return;

        } else {

            printf("\nERROR: Nao ha dados");
            freeMatrix(matrix1);
            freeMatrix(matrix2);
            return;
        }

     } else {

        printf("\nERROR: Nao ha dados");
        return;
     }
}

IntA SortArrayDown(IntA array){

        for(array.Ix = 0; array.Ix < array.length - 1; array.Ix++){
            for(int k = array.Ix; k < array.length; k++){

                if(array.data[array.Ix] > array.data[k]){

                    int tmp = array.data[array.Ix];
                    array.data[array.Ix] = array.data[k];
                    array.data[k] = tmp;

                }
            }
        }

        return array;
}

void metodo_21(){

     IntA array1      = freadArray("DADOS1.TXT");

     printf("\n\nArray desordenado: \n");
     PrintIntArray(array1);
     printf("\n");

     array1 = SortArrayDown(array1);

     printf("\nArray ordenado: \n");
     PrintIntArray(array1);
     printf("\n");

}

bool identityMatrix(refIntM matrix){

     bool test = true;

     for(matrix->ix = 0; matrix->ix < matrix->rows; matrix->ix++){
            for(matrix->iy = 0; matrix->iy < matrix->cols; matrix->iy++){

                if(matrix->ix == matrix->iy && matrix->data[matrix->ix][matrix->iy] != 1){

                    test = false;
                    return test;

                } else if(matrix->ix != matrix->iy && matrix->data[matrix->ix][matrix->iy] != 0){

                    test = false;
                    return test;
                }
            }
        }

      return test;
}

void metodo_22(){

     refIntM matrix1 = freadMatrix("MATRIX1.TXT");
     printf("\nMatrix1: \n\n");
     PrintIntMatrix(matrix1);

     refIntM matrix2 = freadMatrix("MATRIX2.TXT");
     printf("\nMatrix2: \n\n");
     PrintIntMatrix(matrix2);

     if(matrix1 && matrix1->data &&
        matrix2 && matrix2->data){

        bool test = true;
        test = identityMatrix(multiplieMatrix(*matrix1, *matrix2));

        if(test){

            printf("\nA multiplicacao resulta em identidade: \n\n");
            printf("\nMatrix resultate: \n\n");
            PrintIntMatrix(multiplieMatrix(*matrix1, *matrix2));
            printf("\n");

        } else {

            printf("\nA multiplicacao nao resulta em identidade: \n\n");
            PrintIntMatrix(multiplieMatrix(*matrix1, *matrix2));
            printf("\n");
        }

     } else {

        printf("\nERROR: Nao ha dados disponiveis");
     }
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

