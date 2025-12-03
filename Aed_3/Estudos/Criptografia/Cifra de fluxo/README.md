# Tipos de Cifragem em Criptografia Simétrica

Este documento aborda os dois principais modelos de cifragem empregados na **Criptografia Simétrica**: as Cifras de Fluxo (*Stream Ciphers*) e as Cifras de Bloco (*Block Ciphers*). O foco será dado às Cifras de Fluxo, com uma análise detalhada do **One Time Pad (OTP)** e o uso de Geradores de Números Pseudoaleatórios.

---

## 1. Modelos de Cifragem

Na criptografia simétrica, a transformação do texto plano em texto cifrado pode ocorrer de duas maneiras distintas:

| Modelo de Cifragem | Princípio Operacional | Exemplo Clássico |
| :--- | :--- | :--- |
| **Cifras de Fluxo** (*Stream Cipher*) | A cifragem é realizada **bit a bit** ou **símbolo a símbolo**. | Substituição Simples |
| **Cifras de Bloco** (*Block Cipher*) | A cifragem é realizada em **blocos** de dados, cada um contendo múltiplos símbolos. | Transposição de Colunas |

---

## 2. Cifras de Fluxo (*Stream Ciphers*)

As Cifras de Fluxo são algoritmos de chave simétrica que operam combinando o fluxo de bits da mensagem (*bitstream*) com um fluxo de bits de chave (*keystream*).

### 2.1. Operação Fundamental

A encriptação é tipicamente realizada por meio de uma simples operação **OU Exclusivo (XOR)**, devido às suas propriedades reversíveis:

| Operação | Fórmula |
| :--- | :--- |
| **Cifragem** | $c = E(k, m) = k \oplus m$ |
| **Decifragem** | $m = D(k, c) = k \oplus c$ |

Onde $m$ é a mensagem, $k$ é o fluxo de chave (*keystream*) e $c$ é o texto cifrado.

### 2.2. O One Time Pad (OTP)

O **One Time Pad (OTP)**, desenvolvido por **Gilbert Vernam** em 1917, é o exemplo teórico de segurança máxima em cifras de fluxo.

O OTP é **matematicamente inquebrável**, desde que duas condições essenciais sejam atendidas:
1.  A chave deve ser uma *string* de bits **verdadeiramente aleatória**.
2.  A chave deve ter o **mesmo tamanho** da mensagem a ser criptografada.
3.  A chave deve ser utilizada **apenas uma vez** (*one time*).

### 2.3. Geradores de Chaves Pseudoaleatórias (PRNG)

A exigência de chaves longas e verdadeiramente aleatórias no OTP impõe desafios práticos de gerenciamento e sigilo. Para contornar esta limitação, os algoritmos modernos de cifras de fluxo utilizam um **Gerador de Números Pseudoaleatórios (PRNG)**.

O PRNG utiliza uma **chave semente** (tipicamente de 64, 128, 256 ou mais bits) para gerar um fluxo de chave (*keystream*) que se comporta de maneira pseudoaleatória.

| Operação | Fórmula |
| :--- | :--- |
| **Cifragem** | $c = \text{PRNG}(k) \oplus m$ |
| **Decifragem** | $m = \text{PRNG}(k) \oplus c$ |

Exemplos de cifras de fluxo que utilizam PRNG incluem **RC4**, **Salsa20** e **SEAL**.

---

## 3. Análise de Cifras de Fluxo

As Cifras de Fluxo apresentam um conjunto de características que definem sua aplicação e vulnerabilidades:

| Vantagens | Desvantagens |
| :--- | :--- |
| **Alta Velocidade:** Algoritmos lineares no tempo e constantes no espaço, permitindo processamento rápido. | **Baixa Difusão:** Toda a informação de um símbolo de texto plano está contida em um único símbolo de texto cifrado. |
| **Baixa Propagação de Erros:** Um erro na cifragem de um símbolo dificilmente afetará os símbolos subsequentes. | **Suscetibilidade a Inserções e Modificações:** Um intruso pode inserir texto falso que pode parecer autêntico, exigindo mecanismos de autenticação adicionais. |
