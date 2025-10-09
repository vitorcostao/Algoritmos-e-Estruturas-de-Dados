# Intercalação Balanceada

## Funcionamento

A intercalação balanceada de M caminhos é um algoritmo de intercalação que opera com arquivos temporários. Os dados são extraídos do arquivo principal em blocos que podem ser ordenados em memória principal. Em seguida esses blocos são escritos nos arquivos temporários. 

Como geralmente haverá muito mais blocos do que arquivos temporários, cada arquivo temporário conterá uma fila desses blocos como, por exemplo:

    Arquivo_temporário_1: B1 B4 B7 B10 ...
    Arquivo_temporário_2: B2 B5 B8 B11 ...
    Arquivo_temporário_3: B3 B6 B9 B12 ...

Para garantir uma boa distribuição dos blocos, eles são escritos alternadamente entre os arquivos temporários.

>Observação: Nesse exemplo, o segmento S1 será composto pela intercalação dos blocos B1, B2 e B3 enquanto o segmento S2 será composto pela intercalação dos blocos B4, B5 e B6 e assim em diante. 

Em seguida, toma-se um bloco de cada arquivo temporário gerando um segmento ordenado maior. Serão, assim, gerados vários segmentos ordenados que serão distribuídos 
por um segundo conjunto de arquivos temporários, também de forma balanceada:

    Arquivo_temporário_4: S1 S4 S7 S10 ...
    Arquivo_temporário_5: S2 S5 S8 S11 ...
    Arquivo_temporário_6: S3 S6 S9 S12 ...

> Observação: Define-se bloco como o conjunto de registros ordenado em memória principal, enquanto segmento refere-se ao conjunto de registros gerado a partir de uma intercalação. Na prática, blocos e segmentos representam conjuntos de registros, podendo-se afirmar que o bloco corresponde ao menor segmento existente no processo de ordenação. Assim, o tamanho do bloco está limitado à quantidade de registros que podem ser ordenados em memória principal, ao passo que os segmentos abrangem conjuntos maiores de registros.


O processo se repete, com a intercalação de um segmento de cada arquivo temporário, gerando segmentos ainda maiores e escritos em um novo conjunto de arquivos temporários. 

As intercalações de segmentos ordenados nos arquivos temporários acabam quando restar apenas um único segmento ordenado contendo todos os dados.

### Intercalação de Segmento Variável

Em termos práticos, a intercalação de segmento variável segue o mesmo princípio da intercalação balanceada, ou seja, vários segmentos previamente ordenados são intercalados para formar um novo conjunto de registros em ordem crescente.

A principal diferença, entretanto, está no tamanho dos segmentos, que não precisa ser fixo. Em vez de trabalhar com blocos de tamanho uniforme, como ocorre na intercalação balanceada, esse método permite que segmentos de diferentes tamanhos sejam combinados em cada etapa.

Essa abordagem pode proporcionar melhor aproveitamento do espaço disponível nos arquivos temporários e reduzir o número de passadas necessárias, especialmente quando alguns segmentos já são significativamente maiores que outros.