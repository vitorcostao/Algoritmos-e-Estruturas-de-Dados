# Cifra de fluxo

As **Cifras de Fluxo** são fundamentais para a criptografia. 
Elas consistem em formas diferentes, em relação às de substituição e às de transposição, 
de cifrar e decifrar determinadas mensagens.

---

## Cifras de Fluxo

As Cifras de Fluxo são algoritmos de chave simétrica que operam combinando o f
luxo de bits da mensagem (*bitstream*) com um fluxo de bits de chave (*keystream*).

### Operação Fundamental

A encriptação é tipicamente realizada por meio de uma simples operação 
**OU Exclusivo (XOR)**, devido às suas propriedades reversíveis:

| Operação       | Fórmula                    |
| :------------- | :------------------------- |
| **Cifragem**   | $c = E(k, m) = k \oplus m$ |
| **Decifragem** | $m = D(k, c) = k \oplus c$ |

Onde $m$ é a mensagem, $k$ é o fluxo de chave (*keystream*) e $c$ é o texto cifrado.

### One Time Pad (OTP)

O **One Time Pad (OTP)** é o exemplo teórico de segurança máxima em cifras de fluxo.

O OTP é **matematicamente inquebrável**, desde que duas condições essenciais sejam atendidas:
1.  A chave deve ser uma *string* de bits **verdadeiramente aleatória**.
2.  A chave deve ter o **mesmo tamanho** da mensagem a ser criptografada.
3.  A chave deve ser utilizada **apenas uma vez** (*one time*).

### Geradores de Chaves Pseudoaleatórias (PRNG) : @thigogomes (Pesquisa de TI - III)

Os algoritmos modernos de cifras de fluxo utilizam um **Gerador de Números Pseudoaleatórios (PRNG)**.

O PRNG utiliza uma **chave semente** para gerar um fluxo de chave (*keystream*) 
que se comporta de maneira pseudoaleatória.

| Operação       | Fórmula                       |
| :------------- | :---------------------------- |
| **Cifragem**   | $c = \text{PRNG}(k) \oplus m$ |
| **Decifragem** | $m = \text{PRNG}(k) \oplus c$ |


---

## Análise de Cifras de Fluxo

As Cifras de Fluxo apresentam um conjunto de características que definem sua aplicação e vulnerabilidades:

| Vantagens                                                                                                       | Desvantagens                                                                                                                                                    |
| :-------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Alta Velocidade:** Algoritmos lineares no tempo e constantes no espaço, permitindo processamento rápido.      | **Baixa Difusão:** Toda a informação de um símbolo de texto plano está contida em um único símbolo de texto cifrado.                                            |
| **Baixa Propagação de Erros:** Um erro na cifragem de um símbolo dificilmente afetará os símbolos subsequentes. | **Suscetibilidade a Inserções e Modificações:** Um intruso pode inserir texto falso que pode parecer autêntico, exigindo mecanismos de autenticação adicionais. |
