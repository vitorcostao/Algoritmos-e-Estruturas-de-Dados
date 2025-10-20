# Inserções em uma Árvore B.

O primeiro passo para inserir um dado em uma Árvore B e localizar onde tal elemento será inserido, para isso é importante lembrar como funciona a busca.

## Busca em Árvore B

A busca em uma árvore segue uma lógica recursiva ou iterativa, dependendo da implementação. Os passos gerais são:

- **Passo 1:** Comece pela **raiz** da árvore.

- **Passo 2:** No **nodo atual (página)**:
  - Percorra as **chaves do nodo** da esquerda para a direita:
    1. Compare o valor desejado com a chave atual.
    2. Se o valor for **menor**, siga para o **filho à esquerda da chave**.
    3. Se o valor for **igual**, a busca **termina com sucesso**.
    4. Se não, continue para a **próxima chave**.
    
- **Passo 3:** Se chegar ao final das chaves do nodo sem encontrar:
  - O elemento não existe.
  
- **Passo 4:** Repita os passos 2 e 3 **recursivamente** até:
  - Encontrar a chave.
  - Chegar a um **nodo folha** sem encontrar a chave.


## Inserção

Tendo localizado onde será a inserção, basta analisar qual dos casos a inserção se encontra:

### 1) Inserção normal

- Caso não haja restrições para inserção, como página cheia, apenas insira.

### 2) Divisão de Folhas

- Caso a página esteja cheia, divida ao meio.
  
    - Se o elemento for inserido à esquerda, promova o maior daquela página.
    - Se o elemento for inserido à direita, promova o menor daquela página. 

>OBS: Se necessário, continue dividindo as páginas em um processo recursivo.
  