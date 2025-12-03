# Compressão baseadas em dicionário

## LZW (Lempel-Ziv-Welch)

LZW trata-se de um método de compressão baseado em dicionários, ou seja, pela repetição de símbolos. Tal algoritmo
foi desenvolvido em 1984 por Terry Welch a partir do LZ78.

> A tentativa não é ser mais eficiente que Huffman, pois não há compressão baseada em probabilidade melhor
que Huffman. Logo, a ideia é chegar próximo e obter variações de compressões.


## Dicionário

O primeiro passo é criar uma tabela para os símbolos sendo que cada um deles e seus conjuntos possuem um valor de índice.
Desse modo, ao invés de armazenar os símbolos, armazena-se os valores dos índices de cada um deles.

### Exemplo

| Número    | 0 | 1 | 2 | 3  | 4  | 5  | 7  | 8  | 9   | 10   |
|-----------|---|---|---|----|----|----|----|----|-----|------|
| Símbolos  | a | b | w | wa | ab | bb | ba | aw | wab | bba  |

> LZW se destaca para compactar fluxos, pois os dados são trabalhados a medida que vão "chegando".