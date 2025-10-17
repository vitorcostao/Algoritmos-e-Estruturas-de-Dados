# Tabela Hash Extensível

Quando se altera o número de endereços uma tabela hash tradicional (estática), é necessário recalcular a posição de todas as chaves. No entanto, à medida que o número de chaves cresce, tal processo fica cada vez mais lento. Seria melhor, assim, que tivesse uma alternativa em que um número mínimo de chaves precisasse ser reposicionado quando a tabela crescesse.

E é exatamente isso que a tabela hash extensível se propõe a fazer. Ela é uma tabela que trabalha com cestos e, quando um cesto estoura a sua capacidade, a tabela cresce e apenas as chaves daquele cesto estourado precisam ser reposicionadas.

## Vantagens

- O diretório cresce, sem precisarmos reposicionar todos os registros (do índice)
- O índice (lista de buckets) cresce de acordo com a necessidade
- Como não há encadeamento dos buckets, não há perda de eficiência


## Funcionamento

<img width="894" height="334" alt="image" src="https://github.com/user-attachments/assets/9b8de716-9cf6-4f1a-a4bb-c5ab7247165a" />

A imagem acima demonstra como é a estrutura de uma Tabela Hash Extensível. Desse modo, percebe-se a presença dos cestos e ponteiros para tais cestos que possuem endereço obtido através da função hash.

### Adicionar 9

<img width="894" height="334" alt="image" src="https://github.com/user-attachments/assets/fd17598f-3f59-447e-84e0-561cf8086c1d" />

Ao adicionar a chave 9, não ocorre nenhum problema, pois há espaço para tal inserção

### Adicionar 20

<img width="894" height="369" alt="image" src="https://github.com/user-attachments/assets/aa56a436-6199-4c4d-bd3b-bd75afb9c624" />

Ao adicionar a chave 20, haverá problema de colisão, pois o cesto estará cheio. Nesse caso, é necessário aumentar a profundidade do bucket para 3,
permitindo assim que a quantia de ponteiros dobre, fazendo com que seja possível realocar as posições.
