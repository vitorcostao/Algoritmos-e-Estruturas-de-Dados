# Cifras de Substituição

As **Cifras de Substituição** são fundamentais para a criptografia.
Elas consistem em formas de cifrar e decifrar determinadas mensagens.

---

## Como funcionam as cifras de substituição.

Uma **Cifra de Substituição** é um algoritmo criptográfico no qual caractere de um texto é substituída por outro caractere cifrado. Este processo é funciona com base em uma regra ou chave específica, que estabelece o mapeamento entre o alfabeto original e o alfabeto cifrado.

Tem-se as funções que definem o processo de transformação:

| Operação       | Descrição                                                                                |
| :------------- | :--------------------------------------------------------------------------------------- |
| **Cifragem**   | Transformação da mensagem ($m$) em texto cifrado ($c$) por meio da chave ($k$).          |
| **Decifragem** | Recuperação da mensagem original ($m$) a partir do texto cifrado ($c$) e da chave ($k$). |

A segurança está na confidencialidade da chave ($k$).

---

## Exemplos de Cifras 

A seguir, tem-se algumas cifras famosas:

### Ciframento de César

A **Cifra de César** é uma cifra de substituição monoalfabética. O mecanismo de cifragem consiste
em deslocar cada letra do texto plano um número fixo de posições no alfabeto.

O problema é que se não houver algumas regras mais rígidas em termos de implementação, será mais fácil
para hackers identificarem quais letras correspondem à letra cifrada devido a intensa repetição.

As operações de cifragem e decifragem são expressas matematicamente:

| Operação       | Fórmula                   |
| :------------- | :------------------------ |
| **Cifragem**   | $E(x) = (x + 3) \bmod 26$ |
| **Decifragem** | $D(x) = (x - 3) \bmod 26$ |

Devido à sua chave fixa (ou facilmente determinável), a Cifra de César é considerada criptograficamente fraca e suscetível à **análise de força bruta** e **análise de frequência**.

### Cifra de Vigenère 

A **Cifra de Vigenère** representa uma **cifra polialfabética**.

Diferentemente da Cifra de César, que utiliza um único deslocamento para toda a mensagem,
a Cifra de Vigenère emprega múltiplos deslocamentos, determinados por uma **palavra-chave**.

O processo de cifragem é realizado da seguinte forma:
1.  A palavra-chave é repetida ciclicamente para corresponder ao comprimento da mensagem.
2.  Cada letra do texto plano é cifrada utilizando um deslocamento diferente, correspondente à letra da palavra-chave na mesma posição.

