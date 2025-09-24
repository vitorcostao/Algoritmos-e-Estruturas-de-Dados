#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ContM(const char* array){
    
    int cont = 0;
    int len = strlen(array);

    for(int i = 0; i < len; i++){

        if(array[i] >= 'A' && array[i] <= 'Z'){
            
            cont++;
        }
    }

    return cont;
}

int main() {
    char Str1[100];

    while(scanf(" %[^\n]", Str1) != EOF){
        
        printf("%d\n", ContM(Str1));
    }

    return 0;
}
