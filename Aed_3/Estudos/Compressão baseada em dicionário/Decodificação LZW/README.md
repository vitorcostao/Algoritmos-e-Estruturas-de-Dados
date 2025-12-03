# LZW - Algoritmo (Descompressão)

## Como funciona?

- Inicializar o dicionário (símbolos básicos).
- Decodificar o primeiro índice, escrevê-lo na saída e armazená-lo em **w**.
- Colocar **w** no dicionário.
- Repetir até o fim dos índices.

  - Decodificar o primeiro símbolo **s** do próximo índice.
  - Trocar o da última entrada do dicionário por **s**.
  - Decodificar o resto do índice, escrevê-lo na saída e armazená-lo em **w**.
  - Colocar **w** no dicionário.   



### Descompressão para saída: "0 1 3 0"

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |



## Etapa 1

0 1 3 0

a

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |

> OBS: Colocar o do atual junto com o primeiro do próximo símbolo.



## Etapa 1

0 1 3 0

a b

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |
| 4      | ba       |

> OBS: Colocar o do atual junto com o primeiro do próximo símbolo.


## Etapa 3

0 1 --- 3 -- 0

a b -- ab 

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |
| 4      | ba       |
| 5      | aba      |

> OBS: Colocar o do atual junto com o primeiro do próximo símbolo.



## Etapa 4

0 1 --- 3 -- 0

a b -- ab -- a

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |
| 4      | ba       |
| 5      | aba      |

> OBS: Colocar o do atual junto com o primeiro do próximo símbolo.


## Conclusão

A mensagem gerada pela saída 0 1 3 0 é equivalente a "a b a b a", que é exatamente a mesma que foi codificada
no README da pasta LZW - Codificação.
