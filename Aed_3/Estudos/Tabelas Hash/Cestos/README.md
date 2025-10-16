# Cestos (Tabelas Hash)

As tabelas hash devem considerar as particularidades do acesso sequencial aos arquivos, uma vez que a leitura e a escrita de dados em dispositivos de armazenamento não ocorrem em unidades arbitrárias, 
mas sim em blocos físicos conhecidos como setores, geralmente de 4 KB.

Considerando, por exemplo, um par de chave e valor composto por um inteiro e um long, totalizando aproximadamente 12 bytes, é possível observar que um único acesso ao disco pode recuperar ou armazenar centenas de
pares de chave e valor simultaneamente. Isso ocorre porque, independentemente da quantidade de dados solicitada, o sistema de armazenamento realizará a leitura ou a escrita de um setor completo.

Dessa forma, torna-se mais eficiente organizar a tabela hash de modo que opere com blocos de 4 KB, em vez de realizar acessos individuais a cada par de chave e valor. Cada um desses blocos pode, então, 
corresponder a um dos endereços ou posições da tabela hash. No contexto específico das tabelas hash armazenadas em disco, tais blocos recebem a denominação de cestos, que é de maneira análoga às páginas utilizadas
nas estruturas de árvores B, que também fazem uso de blocos de tamanho fixo para otimizar o desempenho das operações de leitura e escrita em memória secundária.

<img width="912" height="412" alt="image" src="https://github.com/user-attachments/assets/73d7d83a-fb33-443b-ac2f-c9431074ec77" />


## Tratamento de Colisões

O tratamento de colisões em tabelas hash armazenadas em disco ocorre quando um cesto encontra-se cheio, não sendo possível inserir novos registros naquele espaço.
Nessa situação, diferentes estratégias podem ser adotadas para garantir que o novo elemento seja devidamente armazenado sem perda de dados.

Uma das abordagens consiste em alocar o registro no próximo cesto que possua espaço disponível, seguindo o princípio do endereçamento aberto. 
Nesse método, o sistema realiza uma busca sequencial ou controlada por uma função de sondagem até encontrar um cesto livre, no qual o novo par de chave e valor será inserido.

Outra possibilidade é empregar as técnicas tradicionais de tratamento de colisões, adaptando-as ao contexto dos cestos. Nesse caso, considera-se que cada posição da tabela hash corresponde a um cesto, 
podendo-se aplicar métodos como sondagem linear, sondagem quadrática ou duplo hashing para determinar o próximo cesto a ser utilizado.

Essas estratégias permitem que o sistema mantenha a eficiência no acesso e na inserção de dados, mesmo diante de colisões inevitáveis, preservando o equilíbrio entre desempenho e uso adequado do espaço em disco.