/**

    Matrizes -> ESTUDOS DIRIGIDOS THELDO
    Aluno: Vitor Costa Oliveira Rolla
*/

#include<stdio.h>   // Para entrada e saidas
#include<string.h>  //Para trabalhar cadeia de caracteres
#include<ctype.h>   //Para trabalhar aspectos das strings
#include<stdbool.h> //Para trabalhar condicoes

//----------------------------------------------//

void InitializeMatrix(int rows, int cols, int Matrix[][cols]){

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < rows; j++){

            Matrix[i][j] = 0;
        }
    }
}

void printIntMatrix(int rows, int cols, int matrix[][cols]){

    printf("\n");

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            printf("%3d\t", matrix[i][j]);
        }
        printf("\n");
    }
}

void metodo_01(){

    int matrix[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    printf("\nExercicio - 1\n\n");
    printIntMatrix(3, 3, matrix);

    printf("\n");
}

void readIntMatrix(int rows, int cols, int matrix[][cols]){

    printf("\n\nDefina valores para a Matriz\n\n");

    int count = 1;

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            printf("[%d]: ", count);
            scanf("%d", &matrix[i][j]);
            getchar();

            count++;
        }
        printf("\n");
    }
}

void metodo_02(){

    int matrix[3][3];

    printf("\nExercicio - 2\n\n");
    readIntMatrix(3,3,matrix);
    printIntMatrix(3, 3, matrix);

    printf("\n");
}

void fprintIntMatrix(char* filename, int rows, int cols, int matrix[][cols]){

    FILE* arquivo = fopen(filename, "wt");

    if(!arquivo){

        printf("ERROR: Nao foi possivel abrir o arquivo");
    }

    fprintf(arquivo, "%d\n", rows);
    fprintf(arquivo, "%d\n", cols);

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            fprintf(arquivo, "%d\n", matrix[i][j]);
        }
    }

    printf("\nValores guardados com sucesso em %s", filename);

    fclose(arquivo);
}

void metodo_03(){

    printf("\nExercicio - 3\n\n");

    int rows;
    int cols;

    printf("\nDigite o valor da linha: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o valor da coluna: ");
    scanf("%d", &cols);
    getchar();


    if(rows < 0 || cols < 0){

       printf("\nERROR: Dimensoes invalidas para a matriz");
       return;

    } else if(rows > 0 && cols > 0){

            int matrix[rows][cols];
            readIntMatrix(rows,cols,matrix);
            fprintIntMatrix("MATRIX1.TXT",rows, cols, matrix);

    }



    printf("\n");
}

int freadMatrixRows(char* filename){

    int rows = 0;

    FILE* arquivo = fopen(filename, "rt");
    if(!arquivo){printf("\nERROR: Nao foi possivel abrir o arquivo"); return -1;}

    fscanf(arquivo, "%d\n", &rows);

    if(rows <= 0){printf("\nERROR: Dimensao invalida"); rows = 0;}

    return rows;
}

int freadMatrixCols(char* filename){

    int cols = 0;

    FILE* arquivo = fopen(filename, "rt");
    if(!arquivo){printf("\nERROR: Nao foi possivel abrir o arquivo"); return -1;}

    fscanf(arquivo, "%d\n", &cols);
    fscanf(arquivo, "%d\n", &cols);

    if(cols <= 0){printf("\nERROR: Dimensao invalida"); cols = 0;}

    return cols;
}

void freadIntMatrix(char* filename, int rows, int cols, int matrix[][cols]){

    FILE* arquivo = fopen(filename, "rt");
    if(!arquivo){printf("\nERROR: Nao foi possivel abrir o arquivo"); return;}

    fscanf(arquivo, "%d\n", &rows);
    fscanf(arquivo, "%d\n", &cols);

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas");

    } else {

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                fscanf(arquivo, "%d\n", &matrix[i][j]);
            }
        }

        printf("\nValores lidos do arquivo com sucesso: \n");
    }

    fclose(arquivo);
}

void metodo_04(){

    printf("\nExercicio - 4\n\n");

    int rows = freadMatrixRows("MATRIX1.TXT");
    int cols = freadMatrixCols("MATRIX1.TXT");

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas");
        return;

    } else {

        int matrix[rows][cols];
        freadIntMatrix("MATRIX1.TXT", rows, cols, matrix);
        printIntMatrix(rows, cols, matrix);

    }
}

void copyIntMatrix(int rows, int cols, int matrix1[][cols], int matrix2[][cols]){

    if(rows <= 0 || cols <= 0){

       printf("\nERROR: dimensoes invalidas");
       return;

    } else {

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                matrix2[i][j] = matrix1[i][j];
            }
        }
    }
}

void metodo_05(){

    printf("\nExercicio - 5\n\n");

    int rows = freadMatrixRows("MATRIX1.TXT");
    int cols = freadMatrixCols("MATRIX1.TXT");

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas");
        return;

    } else {

        int matrix[rows][cols];
        int other [rows][cols];

        freadIntMatrix("MATRIX1.TXT", rows, cols, matrix);

        copyIntMatrix(rows, cols, matrix, other);

        printf("\nOriginal: \n");
        printIntMatrix(rows, cols, matrix);

        printf("\nCopia: \n");
        printIntMatrix(rows, cols, other);

    }
}

void TransposeMatrix(int rows, int cols, int matrix1[][cols]){

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas");
        return;

    } else {

        int matrix2[cols][rows];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                matrix2[j][i] = matrix1[i][j];
            }
        }

        printIntMatrix(cols, rows, matrix2);
    }
}

void metodo_06(){

    printf("\nExercicio - 6\n\n");

    int rows = 0;
    int cols = 0;

    printf("\nDefina as dimensoes(linhas): ");
    scanf("%d", &rows);
    getchar();

    printf("\nDefina as dimensoes(colunas): ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else{

        int matrix[rows][cols];
        readIntMatrix(rows, cols, matrix);

        printf("\nMatrix 1: ");
        printIntMatrix(rows, cols, matrix);

        printf("\nMatrix 1 Transposta: ");
        TransposeMatrix(rows, cols, matrix);

    }
}

 bool isIdentity(int rows, int cols, int matrix[][cols]){

    bool result = false;

    if(rows != cols){

        printf("\nERROR: Dimensoes invalidos");

    } else {

        result = true;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(i == j){

                    result = result && (matrix[i][j] == 1);

                } else {

                    result = result && (matrix[i][j] == 0);
                }
            }
        }
    }

    return result;
 }

void metodo_07(){

    printf("\nExercicio - 7\n\n");

    int rows = 0;
    int cols = 0;

    printf("\nDefina as dimensoes(linhas): ");
    scanf("%d", &rows);
    getchar();

    printf("\nDefina as dimensoes(colunas): ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");
        return;

    } else {

        bool test;

        int matrix[rows][cols];
        readIntMatrix(rows, cols, matrix);

        test = isIdentity(rows, cols, matrix);
        printIntMatrix(rows, cols, matrix);

        if(test){

            printf("\nA matrix eh identidade\n\n");

        } else {

            printf("\nA matrix nao eh identidade\n\n");
        }

    }
}

bool IsEqual(int rows, int cols, int matrix1[][cols], int matrix2[][cols]){

    bool test = true;

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            test = test && (matrix1[i][j] == matrix2[i][j]);
        }
    }

    return test;
}

void metodo_08(){

    printf("\nExercicio - 8\n\n");

    int rows = 0;
    int cols = 0;

    printf("\nDefina as dimensoes(linhas): ");
    scanf("%d", &rows);
    getchar();

    printf("\nDefina as dimensoes(colunas): ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");
        return;

    } else {

        bool test;

        int matrix1[rows][cols];
        readIntMatrix(rows, cols, matrix1);

        int matrix2[rows][cols];
        readIntMatrix(rows, cols, matrix2);

        test = IsEqual(rows, cols, matrix1, matrix2);
        printf("\nMatrix 1");
        printIntMatrix(rows, cols, matrix1);
        printf("\nMatrix 2");
        printIntMatrix(rows, cols, matrix2);

        if(test){

            printf("\nAs matrizes sao iguais\n\n");

        } else {

            printf("\nAs matrizes nao sao iguais\n\n");
        }

    }

}

void addIntMatrix(int rows, int cols, int matrix1[][cols], int matrix2[][cols], int k){

     int matrix3[rows][cols];
     InitializeMatrix(rows, cols, matrix3);


     for(int i = 0; i < rows; i++){
        for(int j = 0; j < rows; j++){

            matrix3[i][j] = matrix1[i][j] + (k * matrix2[i][j]);
        }
    }

    printf("\nMatrix 3: ");
    printIntMatrix(rows, cols, matrix3);
}

void metodo_09(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        int matrix1[rows][cols];
        readIntMatrix(rows, cols, matrix1);
        printf("\nMatrix 1: ");
        printIntMatrix(rows, cols, matrix1);

        int matrix2[rows][cols];
        readIntMatrix(rows, cols, matrix2);
        printf("\nMatrix 2: ");
        printIntMatrix(rows, cols, matrix2);

        int k;
        printf("\nDefina a constante: ");
        scanf("%d", &k);
        getchar();

        addIntMatrix(rows, cols, matrix1, matrix2, k);
    }
}

void multIntMatrix(int rows1, int cols1, int rows2, int cols2,
                   int matrix1[][cols1], int matrix2[][cols2]){


    int soma = 0;
    int matrix3[rows1][cols2];
    InitializeMatrix(rows1, cols2, matrix3);

    for(int i = 0; i < rows1; i++){
        for(int j = 0; j < cols2; j++){

            soma = 0;
            for(int k = 0; k < cols1; k++){

                soma = soma + (matrix1[i][k] * matrix2[k][j]);
            }

            matrix3[i][j] = soma;
        }
    }

    printf("\nMatrix resultante: ");
    printIntMatrix(rows1, cols2, matrix3);

}

void metodo_10(){

    int rows1, cols1, rows2, cols2;

    printf("\nDigite o numero de linhas da primera matriz: ");
    scanf("%d", &rows1);
    getchar();

    printf("\nDigite o numero de colunas da primeira matriz: ");
    scanf("%d", &cols1);
    getchar();

    printf("\nDigite o numero de linhas da segunda matriz: ");
    scanf("%d", &rows2);
    getchar();

    printf("\nDigite o numero de colunas da segunda matriz: ");
    scanf("%d", &cols2);
    getchar();

    if(rows1 <= 0 || cols1 <= 0 || rows2 <= 0 || cols2 <= 0 ||
       cols1 != rows2){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        int matrix1[rows1][cols1];
        readIntMatrix(rows1, cols1, matrix1);
        printf("\nMatrix 1: ");
        printIntMatrix(rows1, cols1, matrix1);

        int matrix2[rows2][cols2];
        readIntMatrix(rows2, cols2, matrix2);
        printf("\nMatrix 2: ");
        printIntMatrix(rows2, cols2, matrix2);

        multIntMatrix(rows1, cols1, rows2, cols2, matrix1, matrix2);
    }
}

/**

    INICIANDO EXERCICIOS PROPOSTOS

*/

void InitializeDoubleMatrix(int rows, int cols, double matrix[][cols]){

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < rows; j++){

            matrix[i][j] = 0.0;
        }
    }
}

void readNegativeMatrix(int rows, int cols, double matrix[][cols]){

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            printf("\n[%d][%d]: ", i + 1, j + 1);
            scanf("%lf", &matrix[i][j]);
            getchar();

            if(matrix[i][j] > 0){

                while(matrix[i][j] > 0){

                    printf("\nERROR: Numero positivo ou caractere estranho");
                    printf("\n\nRedefina o valor digitado: ");
                    printf("\n\n[%d][%d]: ", i + 1, j + 1);
                    scanf("%lf", &matrix[i][j]);
                    getchar();
                }
            }
        }
    }
}

void readMatrix(int rows, int cols, double matrix[][cols]){

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            printf("\n[%d][%d]: ", i + 1, j + 1);
            scanf("%lf", &matrix[i][j]);
            getchar();

        }
    }
}

void printDoubleMatrix(int rows, int cols, double matrix[][cols]){

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            printf("%.1lf\t", matrix[i][j]);
        }
        printf("\n");
    }
}

void metodo_11(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printDoubleMatrix(rows, cols, matrix);
    }
}

void fprintDoubleMatrix(char* filename, int rows, int cols,
                        double matrix[][cols]){

     FILE* arquivo = fopen(filename, "wt");

     if(!arquivo){

        printf("\nERROR: Nao foi possivel abrir o arquivo\n\n");

     } else {

        fprintf(arquivo, "%d\n", rows);
        fprintf(arquivo, "%d\n", cols);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                fprintf(arquivo, "%.1lf\n", matrix[i][j]);
            }
        }

        printf("\n");
        printDoubleMatrix(rows, cols, matrix);
        printf("\nVALORES GUARDADOS COM SUCESSO!");
        printf("\nFECHANDO ARQUIVO\n\n");
        fclose(arquivo);
     }
}

void metodo_12(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        fprintDoubleMatrix("MATRIX2.TXT", rows, cols, matrix);
    }
}

void printDiagonalDoubleMatrix(int rows, int cols, double matrix[][cols]){

    printf("\n\nDiagonal Principal da Matriz: \n");

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(i == j){

                printf("%.1lf\t", matrix[i][j]);

            } else {

                printf(".\t");
            }
        }
        printf("\n");
    }
}

void metodo_13(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printDiagonalDoubleMatrix(rows, cols, matrix);
    }
}

void printSDiagonalDoubleMatrix(int rows, int cols, double matrix[][cols]){

    printf("\n");
    printf("\n\nDiagonal Principal da Matriz: \n");

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(j == cols - i - 1){

                printf("%.1lf\t");

            } else {

                printf(".\t");
            }
        }

        printf("\n");
    }
}

void metodo_14(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printSDiagonalDoubleMatrix(rows, cols, matrix);
    }
}

void printLDTriangleDoubleMatrix(int rows, int cols, double matrix[][cols]){

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(i > j){

                printf("%.1lf\t", matrix[i][j]);

            } else {

                printf(".\t");
            }
        }
        printf("\n");
    }
}

void printLUTriangleDoubleMatrix(int rows, int cols, double matrix[][cols]){

    printf("\n");
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(j > i){

                printf("%.1lf\t", matrix[i][j]);

            } else {

                printf(".\t");
            }
        }
        printf("\n");
    }
}

void metodo_15(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printLDTriangleDoubleMatrix(rows, cols, matrix);
    }
}

void metodo_16(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printLUTriangleDoubleMatrix(rows, cols, matrix);
    }
}

void printSLDTriangleDoubleMatrix(int rows, int cols, double matrix[][cols]){

    printf("\n");
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(i > cols - j - 1){

                printf("%.1lf\t", matrix[i][j]);

            } else {

                printf(".\t");
            }
        }
        printf("\n");
    }
}

void metodo_17(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printSLDTriangleDoubleMatrix(rows, cols, matrix);
    }
}

void printSLUTriangleDoubleMatrix(int rows, int cols, double matrix[][cols]){

    printf("\n");
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(i < cols - j - 1){

                printf("%.1lf\t", matrix[i][j]);

            } else {

                printf(".\t");
            }
        }
        printf("\n");
    }
}

void metodo_18(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);
        printf("\nDefina o valor da Matriz: ");
        readNegativeMatrix(rows, cols, matrix);
        printSLUTriangleDoubleMatrix(rows, cols, matrix);
    }
}

bool allZerosLTriangleDoubleMatrix(int rows, int cols, double matrix[][cols]){

    bool result = true;

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(i > j){

                result = result && (matrix[i][j] != 0);
            }
        }
    }

    return result;
}

void metodo_19(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        bool result;

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);

        printf("\nDefina o valor da Matriz: ");
        readMatrix(rows, cols, matrix);

        result = allZerosLTriangleDoubleMatrix(rows, cols, matrix);
        if(result){

            printf("\n\nTODOS OS VALORES ABAIXO DE DP SAO DIFERENTES DE ZERO\n\n");
            printLDTriangleDoubleMatrix(rows, cols, matrix);

        } else {

            printf("\n\nTODOS OS VALORES ABAIXO DE DP SAO IGUAIS ZERO\n\n");
            printLDTriangleDoubleMatrix(rows, cols, matrix);
        }

    }
}

bool allZerosUTriangleDoubleMatrix(int rows, int cols, double matrix[][cols]){

    bool result = true;

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){

            if(i < j){

                result = result && (matrix[i][j] != 0);
            }
        }
    }

    return result;

}

void metodo_20(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0 || rows != cols){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        bool result;

        double matrix[rows][cols];
        InitializeDoubleMatrix(rows, cols, matrix);

        printf("\nDefina o valor da Matriz: ");
        readMatrix(rows, cols, matrix);

        result = allZerosLTriangleDoubleMatrix(rows, cols, matrix);
        if(result){

            printf("\n\nTODOS OS VALORES ACIMA DE DP SAO DIFERENTES DE ZERO\n\n");
            printLUTriangleDoubleMatrix(rows, cols, matrix);

        } else {

            printf("\n\nTODOS OS VALORES ACIMA DE DP SAO IGUAIS ZERO\n\n");
            printLUTriangleDoubleMatrix(rows, cols, matrix);
        }

    }
}

void MatrixCrescente(int rows, int cols, int Matrix[][cols], char* filename){

     FILE* arquivo = fopen(filename, "wt");
     if(!arquivo){printf("\nERROR: Nao foi possivel abrir o arquivo"); return;}

     int soma = 0;

     fprintf(arquivo, "%d\n", rows);
     fprintf(arquivo, "%d\n", cols);

     for(int i = 0; i < rows; i++){
         for(int j = 0; j < cols; j++){

            soma = soma + 1;
            Matrix[i][j] = soma;
            fprintf(arquivo, "%d\n", Matrix[i][j]);

         }
     }

     fclose(arquivo);
     printIntMatrix(rows, cols, Matrix);
}

void metodo_21(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        int Matrix[rows][cols];
        MatrixCrescente(rows, cols, Matrix, "EXTRAS1.TXT");

    }
}

void MatrixDecrescente(int rows, int cols, int Matrix[][cols], char* filename){

    FILE* arquivo = fopen(filename, "wt");
    if(!arquivo){printf("\nERROR: Nao foi possivel abrir o arquivo"); return;}

    int value = rows * cols;

    fprintf(arquivo, "%d\n", rows);
    fprintf(arquivo, "%d\n", cols);

    for(int i = 0; i < rows; i++){
         for(int j = 0; j < cols; j++){

            Matrix[i][j] = value;
            fprintf(arquivo, "%d\n", Matrix[i][j]);
            value--;
         }
     }

     fclose(arquivo);
     printIntMatrix(rows, cols, Matrix);
}

void metodo_22(){

    int rows, cols;

    printf("\nDigite o numero de linhas: ");
    scanf("%d", &rows);
    getchar();

    printf("\nDigite o numero de colunas: ");
    scanf("%d", &cols);
    getchar();

    if(rows <= 0 || cols <= 0){

        printf("\nERROR: Dimensoes invalidas\n\n");

    } else {

        int Matrix[rows][cols];
        MatrixDecrescente(rows, cols, Matrix, "EXTRAS2.TXT");

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
