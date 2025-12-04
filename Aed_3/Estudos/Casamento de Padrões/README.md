# Casamento de padrões (Pattern Matching)

Uma das operações mais necessárias em computação é a identificação da presença de uma cadeia ou sequência de símbolos (ex.: caracteres)
em um documento, mensagem ou arquivo. Basicamente, é preciso saber se essa sequência aparece no documento e onde. 
Certamente qualquer pessoa já utilizou isto quando fez uma busca por palavras em documentos.

## Técnicas de busca por sequência em documentos

### Indexação

A primeira é a indexação de todas as sequência possíveis. Por exemplo, em um documento, é possível indexar todas as palavras nele existentes e fazer a busca nesse índice.
Para isso, seria necessário utilizar as listas invertidas.

### Busca sequencial pela sequência

A segunda técnica é a busca sequencial pela sequência, isto é, comparar sequencialmente cada símbolo da cadeia procurada com os símbolos do documento. 
Essa técnica é chamada de casamento de padrões. 
>O termo **padrão** aqui é usado por que a sequência não precisa ser tão rígida assim.
Além disso, esse termo também é mais flexível do que strings, porque os algoritmos podem ser usados para buscarmos sequências de pixels, de trechos de música, de DNA e entre outros.

## Algumas curiosidades

Apesar de esses algoritmos terem sido originalmente desenvolvidos para a busca de strings em textos, eles podem ser aplicados a diversos outros contextos, 
como identificação de paternidade por meio do DNA, detecção de riscos de invasão em sistemas, identificação de comportamento fraudulento em operadoras de seguro e 
análise do comportamento de consumidores em grandes lojas virtuais. 

Para isso, basta alterar o conceito de símbolo. Em textos, o símbolo corresponde a uma letra. Já em sequências genéticas, a um nucleotídeo. Na navegação em lojas virtuais, a um clique em um link.
Esses exemplos não apresentam maior complexidade do que a busca em textos, apenas utilizam símbolos diferentes das letras, como intervalos de login em sistemas
de aprendizagem ou operações de compra em cartões de crédito.

Os algoritmos de casamento de padrões dividem-se em duas categorias: 
  - Algoritmos de casamento exato de padrões
  - Algoritmos de casamento aproximado de padrões.

Desse modo, os algoritmos da primeira categoria buscam um padrão no arquivo sem qualquer tolerância a erros.
Isso significa que, caso exista um erro de escrita ou uma pequena variação no arquivo, o padrão não será encontrado. 
Por exemplo, ao buscar o nome “LUIS” em um arquivo, nenhuma ocorrência de “LUIZ” será identificada, devido à diferença na grafia em relação ao padrão.



