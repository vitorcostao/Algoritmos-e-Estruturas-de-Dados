#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){

    // Definir dados
    double n;
    int quantia = 0;
    int notas[] = {2, 5, 10, 20, 50, 100};
    float moedas[] = {0.01, 0.05, 0.10, 0.25, 0.50, 1.00};

    // Leitura
    scanf("%lf", &n);
    printf("NOTAS:\n");
    quantia = n / 100;
    n = n - (quantia * 100);
    printf("%d nota(s) de R$ 100.00\n", quantia);

    quantia = n / 50;
    n = n - (quantia * 50);
    printf("%d nota(s) de R$ 50.00\n", quantia);

    quantia = n / 20;
    n = n - (quantia * 20);
    printf("%d nota(s) de R$ 20.00\n", quantia);

    quantia = n / 10;
    n = n - (quantia * 10);
    printf("%d nota(s) de R$ 10.00\n", quantia);

    quantia = n / 5;
    n = n - (quantia * 5);
    printf("%d nota(s) de R$ 5.00\n", quantia);

    quantia = n / 2;
    n = n - (quantia * 2);
    printf("%d nota(s) de R$ 2.00\n", quantia);

    printf("MOEDAS:\n");

    quantia = n / 1;
    n = n - (quantia * 1);
    printf("%d moeda(s) de R$ 1.00\n", quantia);

    quantia = n * 2;
    n = n - (quantia * 0.5);
    printf("%d moeda(s) de R$ 0.50\n", quantia);

    quantia = n * 4;
    n = n - (quantia * 0.25);
    printf("%d moeda(s) de R$ 0.25\n", quantia);

    quantia = n * 10;
    n = n - (quantia * 0.10);
    printf("%d moeda(s) de R$ 0.10\n", quantia);

    quantia = n * 20;
    n = n - (quantia * 0.05);
    printf("%d moeda(s) de R$ 0.05\n", quantia);

    quantia = n * 100;
    n = n - (quantia * 0.01);
    printf("%d moeda(s) de R$ 0.01\n", quantia);


    return 0;
}
