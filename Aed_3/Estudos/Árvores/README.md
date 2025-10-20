# Árvores B


## O que é uma Árvore B ?

**A Árvore B é uma estrutura de dados de busca em que cada nodo (ou página) possui mais de um elemento.**

## Estrutura

<img width="656" height="212" alt="image" src="https://github.com/user-attachments/assets/ac0cbbbd-d168-4842-8091-3b86344ff219" />

### Nodo(ou página)

Os nodos representam as unidades básicas de armazenamento da estrutura. Cada nodo contém um conjunto de chaves e ponteiros para outros nodos, permitindo que os dados sejam organizados 
de forma hierárquica e equilibrada. Quando a árvore é armazenada em disco, cada nodo normalmente corresponde a uma página física do arquivo, ou seja, um bloco de dados que pode ser lido ou gravado de uma só vez.
Por isso, quando o sistema precisa acessar informações, ele não carrega toda a árvore para a memória principal, mas apenas as páginas necessárias. 
Essa característica torna o acesso muito mais eficiente, pois reduz o número de leituras no disco e aproveita melhor a transferência de blocos maiores de dados.


## Ordem

O parâmetro `Ordem` possui duas definições:

  - Número mínimo de elementos que cada página (exceto a raiz) pode ter (Cormen, 2001; Bayer e McCreight, 1972)
  - Número de filhos que cada página pode ter (Knuth, 1978)

>OBS: Será utilizada a segunda definição para este estudo.


## Regras básicas

### **1. Cada página (exceto a raiz) deve ter pelo menos 50% de ocupação.**
### **2. O número de filhos (exceto a folha) corresponde ao número de chaves mais uma unidade, portanto, para uma árvore de ordem 5, é possível 6 filhos para os nodos.**
### **3. Todas as folhas estão no mesmo nível (crescimento para cima).**