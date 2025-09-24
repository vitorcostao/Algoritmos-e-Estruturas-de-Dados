#include<stdio.h>
#include<stdlib.h>

typedef struct Pilha{

    int n;
    int capacidade;
    int* array;

} Pilha;

// "Construtor"
Pilha* newPilha(int tam){

    // Definir dados
    Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
    if(!pilha){ printf("\nERROR: Its not possible to alocate memory for the stack"); return NULL; }

    pilha->capacidade = tam;
    pilha->n = 0;
    pilha->array = (int*)malloc(tam * sizeof(int));
    if(!pilha->array){

        printf("\nERROR: Its not possible to alocate memory for the array stack");
        free(pilha);
        return NULL;
    }

    return pilha;
}

// "Destrutor"
void DesPilha(Pilha* pilha){

    if(pilha){

        if(pilha->array){

            free(pilha->array);
        }

        free(pilha);
        printf("\nThe desalocation was successfull");
    }
}

// Empilhar -> Inserir no fim
void Empilhar(Pilha* pilha, int value){

    if(!pilha || pilha->n >= pilha->capacidade){

        printf("\nERROR: The stack does not exist or the stack ir full");
    }

    pilha->array[pilha->n] = value;
    pilha->n++;
}

int Desempilhar(Pilha* pilha){

    if(!pilha || pilha->n == 0){

        printf("\nERROR: The stack does not exist or the stack is empty");
    }

    pilha->n--;
    int resp = pilha->array[pilha->n];

    return resp;
}

// Mostrar
void mostrarPilha(Pilha* pilha){

    if(!pilha || pilha->n == 0){

        printf("ERROR: The stack does not exist or the stack is empty");
    }

    // Definir dados
    int len = pilha->n;

    printf("\nPilha em ordem de remocao: ");

    for(int i = 0; i < len; i++){

        printf("%d " , pilha->array[len - i - 1]);
    }

    printf("\n\n");
}

int Pesquisar(Pilha* pilha, int ele){

    // Definir dados
    int resp = 0;
    int len = pilha->n;

    for(int i = 0; i < len; i++){

        if(pilha->array[i] == ele){

            resp = 1;
            i = pilha->n;
        }
    }

    return resp;
}

int main(){

    // Definir dados
    Pilha* pilha = newPilha(10);

    Empilhar(pilha, 1);
    Empilhar(pilha, 2);
    Empilhar(pilha, 3);
    Empilhar(pilha, 4);
    Empilhar(pilha, 5);
    Empilhar(pilha, 6);
    Empilhar(pilha, 7);
    Empilhar(pilha, 8);
    Empilhar(pilha, 9);
    Empilhar(pilha, 10);
    mostrarPilha(pilha);

    Desempilhar(pilha);
    Desempilhar(pilha);
    Desempilhar(pilha);
    Desempilhar(pilha);
    Desempilhar(pilha);
    mostrarPilha(pilha);

    if(Pesquisar(pilha, 5) == 1){

        printf("\nTrue para o elemento 5");
    } else {

        printf("\nFalse para o elemento 5");
    }



    return 0;
}