# Cifra de Bloco

As **Cifras de Bloco** são fundamentais para a criptografia. 
Elas consistem em formas diferentes, em relação às de substituição e às de transposição e às de fluxo, 
de cifrar e decifrar determinadas mensagens.

---

## Cifras de Bloco

As Cifras de Bloco são algoritmos de chave simétrica que operam sobre blocos de dados de tamanho fixo, geralmente de 64 ou 128 bits. Cada bloco da mensagem é cifrado de forma independente ou encadeada por meio de modos de operação, utilizando a mesma chave criptográfica.

Faz-se um XOR do bloco plano atual com o bloco cifrado anterior.  
Para o primeiro bloco (quando não há bloco anterior), é realizado um XOR com um vetor de inicialização (V.I.).

### Operação Fundamental

A encriptação nas cifras de bloco, especialmente no modo CBC (*Cipher Block Chaining*), é realizada por meio da operação  
**OU Exclusivo (XOR)** combinada com uma função de cifragem por bloco:

| Operação       | Fórmula                                      |
| :------------- | :------------------------------------------- |
| **Cifragem**   | $c_i = E(k, m_i \oplus c_{i-1})$             |
| **Decifragem** | $m_i = D(k, c_i) \oplus c_{i-1}$             |

Onde:
- $m_i$ é o bloco atual da mensagem,
- $c_i$ é o bloco cifrado atual,
- $c_{i-1}$ é o bloco cifrado anterior,
- $k$ é a chave criptográfica,
- $E$ é a função de cifragem,
- $D$ é a função de decifragem.

Para o primeiro bloco, utiliza-se o vetor de inicialização:

\[c_0 = E(k, m_0 \oplus VI)\]


---

## Análise de Cifras de Bloco

As Cifras de Bloco apresentam um conjunto de características que definem suas principais vantagens e desvantagens:

| Vantagens                                                                 | Desvantagens                                                                 |
| ------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| **Alta Difusão:** A informação de um símbolo é distribuída entre vários símbolos do texto cifrado. | **Baixa Velocidade:** Um bloco inteiro deve ser acumulado antes que a cifragem ou a decifragem possa começar. |
| **Imunidade a Alterações:** É difícil inserir símbolos no texto cifrado sem que a modificação seja detectada. | **Propagação de Erros:** Um erro em um único símbolo pode corromper todo o bloco. |
