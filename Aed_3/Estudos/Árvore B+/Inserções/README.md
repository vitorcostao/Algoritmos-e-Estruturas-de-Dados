# Inserções em Árvores B+

De modo claro, a Árvore B+ segue praticamente os mesmos principios para inserções. Todavia, há algumas diferenças.

### 1) Inserção normal

- Caso não haja restrições para inserção, como página cheia, apenas insira.

### 2) Divisão de Folhas

- Caso a página esteja cheia, divida ao meio.
  
    - Sempre o elemento que será promovido é o menor à direita, pois na Árvore B+, os elementos à direita são maiores ou iguais ao pai.

>OBS: Se necessário, continue dividindo as páginas em um processo recursivo.
  