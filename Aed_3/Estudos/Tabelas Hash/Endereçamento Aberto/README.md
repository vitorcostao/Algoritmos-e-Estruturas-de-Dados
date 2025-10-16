# Endereçamento aberto

Durante as inserções de índices em Tabelas Hash, é muito comum que alguns dados, ao terem seus endereços calculados pelas funções de dispersões, possuam um mesmo endereço. Tal fenômeno é chamado de colisão. Devido a isso,
é necessário que as colisões sejam tratadas para evitar inconsistência dos dados.

Desse modo, uma das técnicas utilizadas é o endereçamento aberto, que corresponde a um outro lugar que se localiza dentro da própria tabela (em algum endereço vazio) e é calculado matematicamente,
tal o processo de endereçamento aberto. 

## Colisões

<img width="921" height="511" alt="image" src="https://github.com/user-attachments/assets/637b4a9f-8438-44df-b2c7-1b9782a28bba" />

## Tratamento de colisões

Como já mencionado, é imprescindível que colisões sejam tratadas para que não haja inconsistência entre os dados, a partir disso, tem-se as formas de tratamento:

- Endereçamento aberto: Usa outras posições vazias dentro da própria da tabela hash
  
- Encadeamento interno: Usa uma área extradentro da própria da tabela hash
  
- Encadeamento externo: Usa uma área externa, fora da tabela (p.ex., um segundo arquivo).

## Endereçamento aberto

Trata-se de uma solução para que uma nova posição vazia seja encontrada para tratar a colisão entre dados. Existem três formas de procurar tais posições vazias:

### Sondagem Linear

<img width="922" height="395" alt="image" src="https://github.com/user-attachments/assets/a9f89a84-6c96-44a5-9fb4-cc0ba8f43e80" />

### Sondagem Quadrática

<img width="922" height="395" alt="image" src="https://github.com/user-attachments/assets/69937f13-355c-4ff9-93fd-779a87240933" />

### Duplo Hash

<img width="922" height="395" alt="image" src="https://github.com/user-attachments/assets/5c55dd81-08e1-4c1d-8c60-f540445bae80" />

