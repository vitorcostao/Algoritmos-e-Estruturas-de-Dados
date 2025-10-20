# Estrutura de uma página


As Árvores B são frequentemente usadas em sistemas de bancos de dados, onde o volume de informações é muito grande. Por isso, elas também são armazenadas em arquivos, e é 
importante conhecer a estrutura de cada página (ou registro) da árvore, assim como a estrutura geral da árvore.

Uma página de uma Árvore B nada mais é do que um registro, e precisa suportar as mesmas operações feitas em arquivos sequenciais e indexados. Porém, para que a árvore seja eficiente, suas páginas devem ter tamanho fixo.

Um detalhe interessante é que esse tamanho fixo geralmente deve ser 4 KB (tamanho do setor do disco rígido) ou múltiplo disso, garantindo que a árvore funcione de forma eficiente. 
Para evitar que páginas fiquem “quebradas” entre dois setores, o cabeçalho do arquivo também pode ocupar 4 KB (um setor inteiro). Nesse cabeçalho, podem ser armazenadas informações sobre 
páginas excluídas (espaços disponíveis) e outros metadados importantes, como data de criação, data da última atualização e a última página modificada.

Tem-se, portanto, a estrutura de uma página em uma Árvore B:

| Campo        | Descrição                                                   |
|--------------|-------------------------------------------------------------|
| **N**        | Número de elementos armazenados no nodo                     |
| **P0**       | Ponteiro inicial para o primeiro nodo filho                 |
| **C0 / D0**  | Primeira chave e seu respectivo dado                        |
| **P1**       | Ponteiro para o próximo nodo filho                          |
| **C1 / D1**  | Segunda chave e seu respectivo dado                         |
| **P2**       | Ponteiro para o próximo nodo filho                          |
| ...          | Continua para os próximos elementos                         |
| **C<sub>n−1</sub> / D<sub>n−1</sub>** | Última chave e seu respectivo dado |
| **P<sub>n</sub>** | Ponteiro para o último nodo filho                      |


