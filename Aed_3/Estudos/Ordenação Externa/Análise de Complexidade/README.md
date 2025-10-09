# Análise de Complexidade da Intercalação Balanceada

O algoritmo de ordenação externa por intercalações balanceadas realiza acesso sequencial aos dados, o que garante uma eficiência na leitura dos registros individuais.
Contudo, a cada intercalação, torna-se necessário ler todos os registros de um conjunto de arquivos temporários e escrever esses registros em outro conjunto de arquivos temporários.

Esse processo é denominado “passada pelo arquivo”. Ele ocorre uma vez na fase inicial, durante a distribuição dos blocos ordenados entre os arquivos temporários,
e repete-se a cada nova intercalação realizada ao longo do processo.

Dessa forma, o desempenho da ordenação externa depende diretamente do número de passadas realizadas, visto que cada uma implica leituras e escritas completas em disco, 
operações que são relativamente custosas em termos de tempo de execução.

Portanto, sendo:

- (N) é o número total de registros;
- (B) é o número de registros que cabem e podem ser ordenados em memória principal (tamanho do bloco);
- (m) é o grau da intercalação (número de vias/arquivos lidos simultaneamente).

Logo:

$$Passadas = 1 + \left\lceil \log_{m}\left(\frac{N}{b}\right)\right\rceil$$


