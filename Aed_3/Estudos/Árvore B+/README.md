# Árvores B+


## O que é uma Árvore B+ ?

**A Árvore B+ é uma estrutura de dados em que cada nodo (ou página) possui mais de um elemento, porém sendo eficiente para leituras sequenciais.**



## Diferença entre Árvore B e Árvore B+

Em suma, tais estruturas são bem semelhantes em termos de estrutura, todavia, elas possuem diferenças. Dessa forma, diferentemente da Árvore B, a B+ possui um ponteiro que liga sequencialmente as suas folhas, o que a torna mais eficiente para leituras sequenciais, visto que não é necessário retornar ao pai para descer ao próximo filho.

Além disso, na B+, os dados válidos se encontram apenas nas folhas, ou seja, as páginas não folhas servem apenas para percorrer o caminho para os dados propriamente válidos


## Regras básicas

### **1. Cada página (exceto a raiz) deve ter pelo menos 50% de ocupação.**
### **2. O número de filhos (exceto a folha) corresponde ao número de chaves mais uma unidade, portanto, para uma árvore de ordem 5, é possível 6 filhos para os nodos.**
### **3. Todas as folhas estão no mesmo nível (crescimento para cima).**
### **4. Todas chaves são armazenadas nas folhas.**