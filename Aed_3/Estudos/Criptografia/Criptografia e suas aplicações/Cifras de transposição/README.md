# Cifras de Transposição

As **Cifras de Transposição** são fundamentais para a criptografia. Elas consistem em formas diferentes, em relação às de substituição, de cifrar e decifrar determinadas mensagens.

---

## Como funcionam as cifras de transposição.

Uma **Cifra de Transposição** é um algoritmo criptográfico no qual os caracteres do texto plano são rearranjados em uma nova ordem, sem que o valor de cada caractere individual seja alterado. O processo de cifragem consiste na **troca de posição** dos símbolos.

O processo de transformação é definido pelas seguintes funções:

| Operação       | Descrição                                                                                |
| :------------- | :--------------------------------------------------------------------------------------- |
| **Cifragem**   | Transformação da mensagem ($m$) em texto cifrado ($c$) por meio da chave ($k$).          |
| **Decifragem** | Recuperação da mensagem original ($m$) a partir do texto cifrado ($c$) e da chave ($k$). |

A chave ($k$) estabelece o mapeamento entre a posição original e a nova posição do caractere. A segurança está na confidencialidade da chave ($k$).

---

## Exemplos de Cifras

A seguir, apresenta-se um exemplo notável de cifra de transposição:

### Cifra das Colunas

A **Cifra das Colunas** é um método de transposição que utiliza uma palavra-chave para definir a ordem de leitura das colunas de uma matriz.

O processo de cifragem:
1.  **Escrita:** O texto plano é escrito em uma matriz, preenchendo-a linha por linha. O número de colunas é determinado pelo comprimento da palavra-chave.
2.  **Leitura:** O texto cifrado é gerado pela leitura das colunas, seguindo a ordem numérica estabelecida pelos valores dos caracteres da palavra-chave.

**Exemplo Ilustrativo:**

Considerando a palavra-chave **CARO**, que define a ordem de leitura das colunas (C=2, A=1, R=4, O=3), e a mensagem **FIMDESEMANA**:

| C (2) | A (1) | R (4) | O (3) |
| :---: | :---: | :---: | :---: |
| F     | I     | M     | D     |
| E     | S     | E     | M     |
| A     | N     | A     |       |

A leitura das colunas na ordem 1, 2, 3, 4 resulta no texto cifrado: **ISNFEADMMEA**.

A decifragem exige a reconstrução da matriz com base na palavra-chave e a leitura subsequente linha por linha. A segurança desta cifra depende do comprimento e da aleatoriedade da palavra-chave.
