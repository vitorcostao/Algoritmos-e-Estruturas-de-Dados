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

