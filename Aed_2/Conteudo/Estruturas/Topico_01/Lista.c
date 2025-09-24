#include<stdio.h>
#include<stdlib.h>

typedef struct Lista{

    // Definir dados
    int n;
    int cap;
    int* array;
} Lista;

Lista* newLista(int capacidade){

    // Definir dados
    Lista* lista;

    if(capacidade <= 0){

        printf("\nERROR: Its not possible to initialize the list with a capacity of %d", capacidade);
        return NULL;
    }

    // Reservar memoria
    lista = (Lista*)malloc(sizeof(Lista));

    if(!lista){ printf("\nERROR: Its not possible to alocate memory for the variable lista"); return NULL;}

    lista->n = 0;
    lista->cap = capacidade;
    lista->array = (int*)malloc(capacidade * sizeof(int));

    if(!lista->array){ printf("\nERROR: Its not possible to alocate memory for array list"); free(lista); return NULL;}

    return lista;
}

void DesLista(Lista* lista){

    if(lista){

        if(lista->array){

            free(lista->array);
        }
        free(lista);
    }
}

void InserirFim(Lista* lista, int value){

    if(!lista || lista->n >= lista->cap){

        printf("\nERROR: InserirFim - The list does not exist or the list is full");
        return;
    }

    lista->array[lista->n] = value;
    lista->n++;
}

void InserirPos(Lista* lista, int value, int pos){

    if(!lista || (lista->n >= lista->cap) || (pos < 0 || pos > lista->n)){

        printf("\nERROR: InserirPos - The list does not exist or the list is full or the position is invalid");
        return;
    }

    // Definir dados
    int len = lista->n;

    for(int i = len; i > pos; i--){

        lista->array[i] = lista->array[i - 1];
    }

    lista->array[pos] = value;
    lista->n++;
}

void InserirInicio(Lista* lista, int value){

    InserirPos(lista, value, 0);
}

int RemoverInicio(Lista* lista){

    if(!lista || lista->n == 0){

        printf("\nERROR: RemoverInicio - The list does not exist or the list is empty");
        return -1;
    }

    lista->n--;
    int len = lista->n;
    int resp = lista->array[0];

    for(int i = 0; i < len; i++){

        lista->array[i] = lista->array[i + 1];
    }

    return resp;
}

int RemoverFim(Lista* lista){

    if(!lista || lista->n == 0){

        printf("\nERROR: RemoverFim - The list does not exist or the list is empty");
        return -1;
    }

    lista->n--;
    int resp = lista->array[lista->n];

    return resp;
}

int RemoverPos(Lista* lista, int pos){

    if(!lista || lista->n == 0 || (pos < 0 || pos >= lista->n)){

        printf("\nERROR: RemoverFim - The list does not exist or the list is empty");
        return -1;
    }

    lista->n--;
    int len = lista->n;
    int resp = lista->array[pos];

    for(int i = pos; i < len; i++){

        lista->array[i] = lista->array[i + 1];
    }

    return resp;
}

void MostrarLista(Lista* lista){

    if(!lista){

        printf("\nThe list does not exist");
    }

    printf("\n\n");

    int len = lista->n;

    for(int i = 0; i < len; i++){

        printf("%d ", lista->array[i]);
    }
}

int Pesquisar(Lista* lista, int value){

    if(!lista){

        printf("\nERROR: Pesquisar - The list does not exist");
    }

    // Definir dados
    int len = lista->n;
    int resp = 0;

    for(int i = 0; i < len; i++){

        int search = lista->array[i];
        if(search == value){

            resp = 1;
            i = len;
        }
    }

    return resp;
}

int main(){

    // Definir dados
    Lista* lista = newLista(10);

    // Inserir os dados
    printf("\nLista inserida: ");
    InserirInicio(lista, 1);
    InserirFim(lista, 3);
    InserirPos(lista, 2, 1);
    MostrarLista(lista);

    // Pesquisa
    printf("\n\nPesquisa na lista: ");
    if(Pesquisar(lista, 2) == 1){

        printf("\n\nValor %d encontrado", 2);
    } else {

        printf("\n\nValor %d nao encontrado", 2);
    }

    // Remover dados
    printf("\n\nLista removida: ");
    RemoverPos(lista, 1);
    MostrarLista(lista);

    printf("\n");

    RemoverFim(lista);
    MostrarLista(lista);

    printf("\n");

    RemoverInicio(lista);
    MostrarLista(lista);

    RemoverFim(lista);

    return 0;
}