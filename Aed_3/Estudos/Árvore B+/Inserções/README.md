# Inserções em Árvores B+

De modo claro, a Árvore B+ segue praticamente os mesmos principios para inserções. Todavia, há algumas diferenças.

### 1) Inserção normal

- Caso não haja restrições para inserção, como página cheia, apenas insira.

### 2) Divisão de Folhas

- Caso a página esteja cheia, divida ao meio.
  
    - Sempre o elemento que será promovido é o menor à direita, pois na Árvore B+, os elementos à direita são maiores ou iguais ao pai.

>OBS: Se necessário, continue dividindo as páginas em um processo recursivo.


## Exemplos

### Inserção da chave 5
<img width="621" height="168" alt="image" src="https://github.com/user-attachments/assets/acc24850-05cf-495e-9013-639a3bfe7b8f" />

<img width="621" height="168" alt="image" src="https://github.com/user-attachments/assets/f4b43c5c-b7c4-4641-9284-7bbd1ed746cd" />

> OBS: Durante a inserção da chave 5, ocorre a divisão de folhas. Nesse processo, a chave quatro é promovida para cima, pois na Árvore B+, a
comparação realizada é feita primeiro com filho à esquerda, se não for menor e nem igual, logo poderá ser a próxima chave ou o próximo filho.


