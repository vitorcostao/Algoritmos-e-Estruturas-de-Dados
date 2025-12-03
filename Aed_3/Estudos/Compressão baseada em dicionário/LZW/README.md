# LZW - Algoritmo

## Como funciona?

- Inicializar o dicionário (símbolos básicos), ou seja, símbolos que podem aparecer na mensagem. Além disso, conjuntos
  específicos ou amplos são evitados e é trabalhado sob uma perspectiva de 256 valores possíveis para os bytes (e não
  caracteres).

- Repetir o processo até o fim do texto

  - A partir da posição atual, achar a maior string **w** existente no dicionário.
  - Olhar o próximo caráter a que não fez parte de **w**.
  - Escrever a sequência **wa** no dicionário.
  - Avançar para a posição de **a**.


### Compressão Mensagem: "A B A B A"

---

## Etapa 1

A B A B A

0

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |


## Etapa 2:

A B A B A

0 1  

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |
| 4      | ba       |



## Etapa 3:

A B --- [A B] A

0 1 -----  3
> Traços servem apenas para mostrar que AB de código 3 foi colocado na saída

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |
| 4      | ba       |
| 5      | aba      |



A B --- [A B] --- A

0 1 -----  3 ----- 0
> Traços servem apenas para mostrar que AB de código 3 foi colocado na saída

| Código | Símbolo  |
|--------|----------|
| 0      | a        |
| 1      | b        |
| 2      | c        |
| 3      | ab       |
| 4      | ba       |


### Conclusão

A saída de tal mensagem para os símbolos é: 0 1 3 0

---

### Descompressão

Para a saída 0 1 3 0, tem-se a representação: **0000(0) - 0001(1) - 0011(3) - 0000(0)**. Desse modo, teriam
quatro números de quatros bits cada, que seria um total de 16 bits. 

Como a mensagem possui 6 caracteres, armazená-la em números de 8 bits resultariam em 48 bits, o que mantém
a eficiência do algoritmo, visto que a compressão final é dada por:

  $$Compressão = 1 - \frac{16}{48} = 0,667$$ 






