# Remoções em uma Árvore B.

Durante a remoção em uma Árvore B, é importante lembrar das regras de tal estrutura de dados:

### Regras básicas

**1. Cada página (exceto a raiz) deve ter pelo menos 50% de ocupação.**

**2. O número de filhos (exceto a folha) corresponde ao número de chaves mais uma unidade, portanto, para uma árvore de ordem 5, é possível 6 filhos para os nodos.**

**3. Todas as folhas estão no mesmo nível (crescimento para cima).**

---

## Casos de remoção

### Caso 1 - Remoção Simples

Se o elemento estiver em uma folha e a folha mantiver os 50% de ocupação basta removê-lo, e, se necessário, realocar as posições.

### Caso 2 - Antecessor

Se o elemento não estiver em uma folha, basta trocá-lo por seu antecessor para manter o equilibrio da árvore.

### Caso 3 - Rotação

Se o elemento estiver em uma folha e a folha ficar com menos de 50% de ocupação e a página irmã puder ceder, basta realizar uma rotação.

### Caso 4 - Fusão de Folhas

Se o elemento estiver em uma folha e a folha ficar com menos de 50% de ocupação e a página irmã não puder ceder, basta realizar uma fusão de folhas, descendo uma chave do pai.
> OBS: No código, há um teste de ordem para saber se será verificado primeiro com irmão direito e depois com irmão esquerdo.


## Exemplos

### Remoção da chave 13

<img width="925" height="301" alt="image" src="https://github.com/user-attachments/assets/c9ece806-94f8-4371-bd45-a53d78ef8eee" />
<img width="925" height="301" alt="image" src="https://github.com/user-attachments/assets/9185299a-ff17-4f6c-bb29-2ba3b53d54ce" />


> OBS: Basta remover 13 e fazer o shift do 14.

### Remoção da chave 29

<img width="923" height="294" alt="image" src="https://github.com/user-attachments/assets/04ab6103-c882-47c3-b7ba-37302414aee2" />
<img width="923" height="294" alt="image" src="https://github.com/user-attachments/assets/a4593fbb-ee30-4a38-bbb6-cd9761407b33" />


> OBS: Neste caso, como o elemento não está em uma folha, basta trocar pelo seu antecessor.

### Remoção do 35

<img width="928" height="311" alt="image" src="https://github.com/user-attachments/assets/a3da8454-6ca5-4079-9e86-4f9e2d83a2cd" />

> OBS: Neste caso, ao remover o 35, basta fazer uma rotação, pois, ao removê-lo, a folha fica com menos de 50% de ocupação. 

### Remoção do 42

<img width="925" height="305" alt="image" src="https://github.com/user-attachments/assets/55b931ea-499d-4a6b-9a84-767259c5d13b" />

> OBS: Neste caso, como nenhum dos irmão podem ceder chave, basta realizar a fusão de páginas e assim descer uma das chaves para tal fusão. 


