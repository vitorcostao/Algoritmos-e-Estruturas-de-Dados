#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

#define MAX 512
#define MAX_CAST_LISTED 20
#define MAX_PARTS 60
#define MAXTAM    1289
#define MAX_PILHA 1000

int n = 0;


//-------------------------------------------------------------------------------------




/**
 * Aloca uma matriz de strings com tamanhos baseados nas constantes definidas
 * @param rows Número de linhas
 * @return Ponteiro para a matriz alocada ou NULL em caso de falha
 */
char** allocateStringMatrix(int rows){

    if(rows <= 0 || rows > MAX_CAST_LISTED){

        return NULL;
    }

    char** matrix = (char**)malloc(rows * sizeof(char*));

    if(matrix == NULL){

        return NULL;
    }

    for(int i = 0; i < rows; i++){

        matrix[i] = (char*)malloc(MAX * sizeof(char));
        if(matrix[i] == NULL){

            for(int j = 0; j < i; j++){

                free(matrix[j]);
            }

            free(matrix);
            return NULL;
        }

        matrix[i][0] = '\0';
    }

    return matrix;
}




/**
 * Libera uma matriz de strings
 * @param matrix Matriz a ser liberada
 * @param rows Número de linhas na matriz
 */
void freeStringMatrix(char** matrix, int rows){

    if(matrix != NULL){

        for(int i = 0; i < rows; i++){

            free(matrix[i]);
        }

        free(matrix);
    }
}




/**
 * Definir Struct para os dados
 * Alocação de variaveis locais
 */
typedef struct SHOW{

    char showId[7];
    char type[MAX];
    char title[MAX];
    char director[MAX];
    char cast[MAX_CAST_LISTED][MAX];
    int castCount;
    char country[MAX];
    char dateAdded[MAX];
    int realeseYear;
    char rating[MAX];
    char duration[MAX];
    char listedIn[MAX_CAST_LISTED][MAX];
    int listedInCount;

} Show;




/**
 * Alocar espaço para Array de Shows
 * @param n Tamanho do array
 * @return Array alocado
 */
Show* ArrayShow(int n){

    // Definir dados
    Show* s = (Show*)malloc(n * sizeof(Show));

    // Verificação
    if(!s) return NULL;

    return s;
}




//---------------------------------------------------Getters*/




/**
 * Retorna o ID do show.
 */
const char* getShowId(Show* show){

    return show->showId;
}




/**
 * Retorna o tipo do show.
 */
const char* getType(Show* show){

    return show->type;
}




/**
 * Retorna o título do show.
 */
const char* getTitle(Show* show){

    return show->title;
}




/**
 * Retorna o nome do diretor.
 */
const char* getDirector(Show* show){

    return show->director;
}




/**
 * Obtém o elenco como matriz alocada dinamicamente
 * @param show Ponteiro para a estrutura Show
 * @return Matriz alocada dinamicamente ou NULL
 */
char** getCastMember(const Show* show){

    if(show == NULL || show->castCount <= 0 || show->castCount > MAX_CAST_LISTED){

        return NULL;
    }

    // Definir dados
    char** castArray = allocateStringMatrix(show->castCount);
    if(castArray == NULL){

        return NULL;
    }

    for(int i = 0; i < show->castCount; i++){

        strcpy(castArray[i], show->cast[i]);
    }

    return (char**)castArray;
}




/**
 * Retorna o país do show.
 */
const char* getCountry(Show* show){

    return show->country;
}




/**
 * Retorna a data de adição do show.
 */
const char* getDateAdded(Show* show){

    return show->dateAdded;
}




/**
 * Retorna o ano de lançamento.
 */
int getReleaseYear(Show* show){

    return show->realeseYear;
}




/**
 * Retorna a classificação indicativa.
 */
const char* getRating(Show* show){

    return show->rating;
}




/**
 * Retorna a duração do show.
 */
const char* getDuration(Show* show){

    return show->duration;
}




/**
 * Obtém as categorias como matriz alocada dinamicamente
 * @param show Ponteiro para a estrutura Show
 * @return Matriz alocada dinamicamente ou NULL
 */
char** getListedIn(const Show* show){

    // Verificação dos parâmetros de entrada
    if(show == NULL || show->listedInCount <= 0 || show->listedInCount > MAX_CAST_LISTED){

        return NULL;
    }

    // Aloca a matriz de strings
    char** listedInArray = allocateStringMatrix(show->listedInCount);
    if(listedInArray == NULL){

        return NULL;
    }

    // Copia cada categoria para a matriz alocada
    for(int i = 0; i < show->listedInCount; i++){

        strcpy(listedInArray[i], show->listedIn[i]);
    }

    return (char**)listedInArray;
}




//---------------------------------------------------Setters




/**
 * Define o ID do show.
 * @param show Ponteiro para o show.
 * @param id ID do show.
 */
void setShowId(Show* show, const char* id){

    strcpy(show->showId, id);
}




/**
 * Define o tipo do show.
 * @param show Ponteiro para o show.
 * @param type Tipo do show.
 */
void setType(Show* show, const char* type){

    strcpy(show->type, type);
}




/**
 * Define o título do show.
 * @param show Ponteiro para o show.
 * @param title Título do show.
 */
void setTitle(Show* show, const char* title){

    strcpy(show->title, title);
}




/**
 * Define o diretor do show.
 * @param show Ponteiro para o show.
 * @param director Nome do diretor.
 */
void setDirector(Show* show, const char* director){

    strcpy(show->director, director);
}




/**
 * Define os membros do elenco do show.
 * @param show Ponteiro para o show.
 * @param cast Array de nomes dos atores.
 * @param count Quantidade de atores no elenco.
 */
void setCastMembers(Show* show, char** cast, int count){

    for(int i = 0; i < count; i++){

        strcpy(show->cast[i], cast[i]);
    }

    show->castCount = count;
}






/**
 * Define o país do show.
 * @param show Ponteiro para o show.
 * @param country Nome do país.
 */
void setCountry(Show* show, const char* country){

    strcpy(show->country, country);
}




/**
 * Define a data de adição do show.
 * @param show Ponteiro para o show.
 * @param date Data de adição.
 */
void setDateAdded(Show* show, const char* date){

    strcpy(show->dateAdded, date);
}




/**
 * Define o ano de lançamento do show.
 * @param show Ponteiro para o show.
 * @param year Ano de lançamento.
 */
void setReleaseYear(Show* show, int year){

    show->realeseYear = year;
}




/**
 * Define a classificação indicativa do show.
 * @param show Ponteiro para o show.
 * @param rating Classificação indicativa.
 */
void setRating(Show* show, const char* rating){

    strcpy(show->rating, rating);
}




/**
 * Define a duração do show.
 * @param show Ponteiro para o show.
 * @param duration Duração do show.
 */
void setDuration(Show* show, const char* duration){

    strcpy(show->duration, duration);
}




/**
 * Define as categorias do show.
 * @param show Ponteiro para o show.
 * @param listed Array com os gêneros.
 * @param count Quantidade de gêneros.
 */
void setListedIn(Show* show, char** listed, int count){

    if(count > MAX_CAST_LISTED) count = MAX_CAST_LISTED;

    for(int i = 0; i < count; i++){

        strcpy(show->listedIn[i], listed[i]);
    }

    show->listedInCount = count;
}




/**
 * Cria uma cópia do Show (clone).
 *
 * @param original Ponteiro para a struct Show original.
 * @return Um novo Show com os mesmos dados do original.
 */
Show cloneShow(const Show* original) {

    // Definir dados
    Show novo;

    strcpy(novo.showId, original->showId);
    strcpy(novo.type, original->type);
    strcpy(novo.title, original->title);
    strcpy(novo.director, original->director);
    strcpy(novo.country, original->country);
    strcpy(novo.dateAdded, original->dateAdded);
    strcpy(novo.rating, original->rating);
    strcpy(novo.duration, original->duration);
    novo.realeseYear = original->realeseYear;

    novo.castCount = original->castCount;
    for(int i = 0; i < original->castCount; i++){

        strcpy(novo.cast[i], original->cast[i]);
    }


    novo.listedInCount = original->listedInCount;
    for(int i = 0; i < original->listedInCount; i++){

        strcpy(novo.listedIn[i], original->listedIn[i]);
    }

    return novo;
}



//========================================================Outras funções

typedef struct Celula{

    Show elemento;
    struct Celula* topo;

} Celula;

Celula* NovaCelula(Show show){

    // Definir dados
    Celula* nova = (Celula*)malloc(sizeof(Celula));

    nova->elemento = show;
    nova->topo = NULL;

    return nova;
}

typedef struct Pilha{

    Celula* topo;
} Pilha;

Pilha* NovaPilha(){

    // Definir dados
    Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
    pilha->topo = NULL;

    return pilha;
}

void empilhar(Pilha* pilha, Show show){

    // Definir dados
    Celula* nova = NovaCelula(show);
    nova->topo = pilha->topo;
    pilha->topo = nova;     
}

Show desempilhar(Pilha* pilha){

    // Definir dados
    Celula* tmp = pilha->topo;
    Show show = tmp->elemento;
    pilha->topo = tmp->topo;
    free(tmp);

    return show;
}

int getTamPilha(Pilha* pilha){

    // Definir dados
    int count = 0;
    Celula* atual = pilha->topo;

    while(atual != NULL){

        count++;
        atual = atual->topo;
    }

    return count;
}

/**
 * Troca de dados entre as Strings para o quicksort
 *
 * @param a String para trocar
 * @param b String para trocar
 */
void swap(char a[MAX], char b[MAX]){

    // Definir dados
    char temp[MAX];
    strcpy(temp, a);
    strcpy(a, b);
    strcpy(b, temp);
}

/**
 * Método QuickSort de ordenação para Strings
 *
 * @param esq   Índice inicial
 * @param dir   Índice final
 * @param array Array de Strings a ser ordenado
 */
void quickSort(int esq, int dir, char arr[][MAX]){

    // Definir dados
    int i = esq, j = dir;
    char pivo[MAX];
    strcpy(pivo, arr[(esq + dir) / 2]);

    while (i <= j){

        while (strcmp(arr[i], pivo) < 0) i++;
        while (strcmp(arr[j], pivo) > 0) j--;

        if(i <= j){

            swap(arr[i], arr[j]);
            i++;
            j--;
        }
    }

    if(esq < j) quickSort(esq, j, arr);
    if(i < dir) quickSort(i, dir, arr);
}

/**
 * Imprime os dados de um show no formato especificado.
 *
 * @param show Ponteiro para a struct Show.
 */
void imprimirShow(Show show){

    printf("=> ");
    printf("%s ## ", show.showId);
    printf("%s ## ", show.title);
    printf("%s ## ", show.type);
    printf("%s ## ", show.director);

    printf("[");

    // Elenco
    for(int i = 0; i < show.castCount; i++){

        printf("%s", show.cast[i]);

        if(i < show.castCount - 1){

           printf(", ");
        }
    }


    printf("] ## ");

    printf("%s ## ", show.country);
    printf("%s ## ", show.dateAdded);
    printf("%d ## ", show.realeseYear);
    printf("%s ## ", show.rating);
    printf("%s ## ", show.duration);


    printf("[");

    // Categorias
    for(int i = 0; i < show.listedInCount; i++){

        printf("%s", show.listedIn[i]);

        if(i < show.listedInCount - 1){

           printf(", ");
        }
    }

    printf("] ##\n");
}




/**
 * Converte uma String em Array de Strings separadas por "-"
 * Substitui campos vazios (//) por "NaN".
 *
 * @param str String de entrada.
 * @return Array de strings resultantes.
 */
char** StrToArrayStringToken(char* str){

    if(!str) return NULL;

    // Contar quantidade de '|'
    int cont = 0;
    int k = 0;
    while(str[k] != '\0'){

        if(str[k] == '|') cont++;
        k++;
    }

    // Definir dados para alocação -> A quantia de dados é o to/tmp/ : 2 Virgulas e 3 dados
    // Usar delimitador que não é usado.
    int totalCampos = cont + 1;
    char** result = (char**)malloc(totalCampos * sizeof(char*));

    for (int i = 0; i < totalCampos; i++){

        result[i] = (char*)malloc(MAX * sizeof(char));
    }

    // Definir dados
    int campo = 0;
    int i = 0, j = 0;
    char tmp[MAX];
    int len = strlen(str);

    // Percorrer String
    while (i <= len){

        // Se for - ou \0 encerra o campo
        if(str[i] == '|' || str[i] == '\0'){

            tmp[j] = '\0';

            // Se campo for vazio se torna NaN
            if(j == 0){

                strcpy(result[campo++], "NaN");
            } else{

                // Copia o campo para o resultado
                strcpy(result[campo++], tmp);
            }

            // Reinicia temp
            j = 0;

        } else{

            // Formação do campo
            tmp[j++] = str[i];
        }

        i++;
    }

    return result;
}



/**
 * Conta quantas vírgulas uma String possui
 *
 * @param str String a ser contada
 * @return Quantia de vírgulas
 */
int ContVir(char* str){

    // Definir dados
    int i = 0, cont = 0;

    while(str[i] != '\0'){

        if(str[i] == ','){

            cont++;
        }

        i++;
    }

    return cont;
}



/**
 * Converte uma String em Array de Strings separadas por vírgulas
 *
 * Substitui campos vazios por "NaN" e remove espaços nas bordas.
 *
 * @param str String de entrada
 * @return Array de strings alocado dinamicamente ou NULL em caso de erro
 */
char** StrToArrayStringVir(char* str){

    if(!str){

        char** result = (char**)malloc(sizeof(char*));
        result[0] = (char*)malloc(MAX * sizeof(char));
        strcpy(result[0], "NaN");

        return result;
    }

    // Contar quantidade de vírgulas
    int cont = 0;
    for(int i = 0; str[i] != '\0'; i++){

        if(str[i] == ',') cont++;
    }

    // Definir dados para alocação
    int totalCampos = cont + 1;
    char** result = (char**)malloc(totalCampos * sizeof(char*));

    for(int i = 0; i < totalCampos; i++){

        result[i] = (char*)malloc(MAX * sizeof(char));
        strcpy(result[i], "");
    }

    // Definir dados
    int campo = 0;
    int i = 0, j = 0;
    char tmp[MAX];
    int len = strlen(str);
    int primeiroChar = 1;
    int ultimoNaoEspaco = -1;

    while (i <= len){

        if(str[i] == ',' || str[i] == '\0'){

            tmp[j] = '\0';
            tmp[ultimoNaoEspaco + 1] = '\0';

            if(j == 0 || strlen(tmp) == 0){

                strcpy(result[campo++], "NaN");
            } else {

                strcpy(result[campo++], tmp);
            }

            j = 0;
            primeiroChar = 1;
            ultimoNaoEspaco = -1;

        } else {

            if(!(primeiroChar && str[i] == ' ')){

                if(str[i] != ' ') ultimoNaoEspaco = j;
                tmp[j++] = str[i];
                primeiroChar = 0;
            }
        }

        i++;
    }


    return result;
}




/**
 * Transformar String em inteiro
 *
 * @param str String a ser transformada
 */
int StrToInt(char* str){

    // Definir dados
    int len = strlen(str);
    int data = 0;

    for(int i = 0; i < len; i++){

        char c = str[i];
        data = (10 * data) + (c - '0');
    }

    return data;
}




/**
 * Ler Show em uma String
 *
 * @param in String de entrada
 */
Show Ler(const char* in){

    // Definir dados
    Show show;
    int len = strlen(in);
    bool flag = true;
    int j = 0;
    char* simplify = (char*)malloc(2 * MAX * sizeof(char));

    if(!simplify)return show;

    for(int i = 0; i < len; i++){

        char c = in[i];

        if(c == '"'){
            flag = !flag;
        } else if (c == ',' && flag){
            simplify[j++] = '|';
        } else {
            simplify[j++] = c;
        }
    }

    simplify[j] = '\0';

    // Aplicando Array de Strings
    char** ArrayStrings = StrToArrayStringToken(simplify);

    setShowId(&show, ArrayStrings[0]);
    setType(&show, ArrayStrings[1]);
    setTitle(&show, ArrayStrings[2]);
    setDirector(&show, ArrayStrings[3]);

    // Caso especial
    char** CastMembers = StrToArrayStringVir(ArrayStrings[4]);

    setCastMembers(&show, CastMembers, ContVir(ArrayStrings[4]) + 1);



    setCountry(&show, ArrayStrings[5]);
    setDateAdded(&show, ArrayStrings[6]);
    setReleaseYear(&show, StrToInt(ArrayStrings[7]));
    setRating(&show, ArrayStrings[8]);
    setDuration(&show, ArrayStrings[9]);

    // Caso especial
    char** ListedIn = StrToArrayStringVir(ArrayStrings[10]);
    setListedIn(&show, ListedIn, ContVir(ArrayStrings[10]) + 1);


    return show;
}

/**
 * Conta quantas Strings válidas existem em um array de Strings.
 *
 * @param tamanhoMax Tamanho máximo do array
 * @param arr Array de Strings
 */
int contarStringsValidas(char arr[][MAX], int tamanhoMax) {

    // Definir dados
    int count = 0;

    for (int i = 0; i < tamanhoMax; i++) {

        if (arr[i][0] != '\0') {
            count++;
        }
    }
    return count;
}


/**
 * Lê todos os shows de um arquivo CSV.
 *
 * @return Vetor de structs Show alocado dinamicamente.
 */
void LerCsv(Show array[]) {

    // Definir dados
    FILE* csv = fopen("/tmp/disneyplus.csv", "rt");

    if (!csv) {

        perror("Erro ao abrir o arquivo");
        return;
    }

    char* lixo = malloc(2048 * sizeof(char));
    fgets(lixo, 2047, csv);
    free(lixo);

    for(int i = 0; i < 1289; i++){

        char* buffer = malloc(2048 * sizeof(char));

        if(fgets(buffer, 2047, csv) == NULL){

            free(buffer);

        } else {

            buffer[strcspn(buffer, "\n")] = '\0';
            array[i] = Ler(buffer);
            quickSort(0, array[i].listedInCount - 1, array[i].listedIn);
            quickSort(0, array[i].castCount - 1, array[i].cast);
            free(buffer);
        }
    }

    fclose(csv);
}

int ExtraiIdString(char* buffer) {

    // Definir dados
    int id = 0;

    // Sscanf para obter dados
    if (buffer[0] == 's') {
        sscanf(buffer + 1, "%d", &id);
    }

    return id;
}



/**
 * Lê todos os shows de um arquivo CSV.
 *
 * @return Vetor de structs Show alocado dinamicamente.
 */
void LerCsvId(Pilha* pilha, char* idStr) {

    // Definir dados
    FILE* csv = fopen("/tmp/disneyplus.csv", "rt");

    if (!csv) {
        perror("Erro ao abrir o arquivo");
        return;
    }

    int flag = 0;
    char buffer[2048];
    fgets(buffer, sizeof(buffer), csv);

    while (fgets(buffer, sizeof(buffer), csv) && flag == 0) {

        buffer[strcspn(buffer, "\n")] = '\0';

        int idLinha = ExtraiIdString(buffer);
        int idAlvo = ExtraiIdString(idStr);
        if (idLinha == idAlvo) {
            empilhar(pilha, Ler(buffer));
            quickSort(0, pilha->topo->elemento.listedInCount - 1, pilha->topo->elemento.listedIn);
            quickSort(0, pilha->topo->elemento.castCount - 1, pilha->topo->elemento.cast);
            
            flag = 1;
        }
    }

    fclose(csv);
}

Show GetFileShow(char* idStr){

    // Definir dados
    FILE* csv = fopen("/tmp/disneyplus.csv", "rt");
    Show encontrado;

    if (!csv) {
        perror("Erro ao abrir o arquivo");
        return encontrado;

    } else {

        int flag = 0;
        char buffer[2048];
        fgets(buffer, sizeof(buffer), csv);

        while (fgets(buffer, sizeof(buffer), csv) && flag == 0) {

            buffer[strcspn(buffer, "\n")] = '\0';

            int idLinha = ExtraiIdString(buffer);
            int idAlvo = ExtraiIdString(idStr);
            if (idLinha == idAlvo) {
                encontrado = Ler(buffer);
                flag = 1;
            }
        }

        fclose(csv);
        return encontrado;
    }


}


//========================================================== Aplicação


int main() {

    // Definir dados
    Show removidos[16];
    Pilha* pilha = NovaPilha();

    int j = 0;
    int x = 0;


    // Entrada de dados
    char* input = malloc(1001 * sizeof(char));
    scanf(" %1000[^\n]", input);

    while (strcmp(input, "FIM") != 0) {
        LerCsvId(pilha, input);
        scanf(" %1000[^\n]", input);
    }

    scanf("%d", &x);
    getchar();

    // Entrada de dados
    char* input2 = malloc(1001 * sizeof(char));
    if (input2 == NULL) {
        perror("Erro ao alocar memória para input2");
        free(input);
        return 1;
    }


    for (int k = 0; k < x; k++) {

        scanf(" %1000[^\n]", input2);
        char* comando = strtok(input2, " ");

        if (strcmp(comando, "I") == 0) {

            char* id = strtok(NULL, " ");
            empilhar(pilha, GetFileShow(id));
        } else if (strcmp(comando, "R") == 0) {

           removidos[j++] = desempilhar(pilha);
        }
    }

    for (int i = 0; i < j; i++) {

        printf("(R) %s\n", removidos[i].title);
    }

    int tam = getTamPilha(pilha) - 1;

    for(Celula* i = pilha->topo; i != NULL; i = i->topo) {

        // Imprime o índice do show
        printf("[%d] ", tam--);
        imprimirShow(i->elemento);
    }


    free(input);
    free(input2);

    return 0;
}