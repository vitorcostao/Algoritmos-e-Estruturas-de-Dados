# Algoritmo de Força Bruta

## Funcionamento

A forma mais simples de casamento de padrões é a força bruta. Nesse caso, os testes são realizados nas sequências de símbolos do padrão em TODAS as posições possíveis do documento. 
Obviamente, não é eficiente, mas é importante conhecer tal algoritmo para que seja possível entender as vantagens das outras formas.
No casamento por força bruta, o resultado de um teste do padrão em uma posição não é aproveitado em um teste posterior. Assim, não há nenhuma otimização nessa forma de busca.

### Exemplo para ABABABA como texto e ABA como padrão

| Alinhamento (i) | Substring do texto               | Comparações                          | Resultado                      |
|:---------------:|:--------------------------------:|:------------------------------------:|:------------------------------:|
| 0               | `ABA`                            | `A == A`, `B == B`, `A == A`         | **Match** (ocorrência em 0..2) |
| 1               | `BAB`                            | `A != B` (falha em p[0])             | Não casa                       |
| 2               | `ABA`                            | `A == A`, `B == B`, `A == A`         | **Match** (ocorrência em 2..4) |
| 3               | `BAB`                            | `A != B` (falha em p[0])             | Não casa                       |
| 4               | `ABA`                            | `A == A`, `B == B`, `A == A`         | **Match** (ocorrência em 4..6) |