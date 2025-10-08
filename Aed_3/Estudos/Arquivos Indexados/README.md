# Resumo: Arquivos Indexados

Em aplicações contemporâneas, nas quais se realizam numerosas consultas aleatórias por entidades específicas, os **arquivos indexados** demonstram-se mais adequados do que os arquivos sequenciais.  

## Definição

Arquivos indexados são aqueles que dispõem de uma **estrutura adicional de apoio às buscas**, independentemente de os dados estarem ordenados ou não. Essa estrutura é denominada **índice** e, em geral, é implementada sob a forma de:

- **Tabela hash**  
- **Árvore**  

> Observação: algumas dessas estruturas de dados serão detalhadas na unidade subsequente.  

## Funcionamento

- A operação de busca não é realizada diretamente sobre o arquivo de dados, mas sim por intermédio do **índice**.  
- O índice identifica os registros que atendem aos critérios de pesquisa e fornece suas **localizações precisas** no arquivo de dados.  
- Cada registro pode, posteriormente, ser recuperado diretamente por meio de seu endereço no arquivo.  

## Múltiplos Índices

Um mesmo arquivo pode conter **diversos índices**, cada um baseado em um atributo ou conjunto de atributos distintos.  

Exemplo: em um **sistema de gerenciamento de clientes**, é possível definir:  

- Um índice baseado no **ID do cliente**  
- Um índice baseado no **nome do cliente**  
- Um índice baseado no **e-mail do cliente**  

## Classificação dos Índices

Os índices podem ser classificados de diversas maneiras, dependendo de sua função e organização:

- **Primários ou secundários**:  
  - Primários: baseados na chave primária do arquivo; cada registro possui um único índice primário.  
  - Secundários: baseados em outros atributos, permitindo buscas adicionais sem alterar a ordem do arquivo.  

- **Diretos ou indiretos**:  
  - Diretos: o índice aponta diretamente para o endereço físico do registro no arquivo.  
  - Indiretos: o índice aponta para uma posição intermediária ou tabela de ponte, que então referencia o registro.  

- **Densos ou esparsos**:  
  - Densos: cada registro do arquivo possui uma entrada correspondente no índice.  
  - Esparsos: nem todos os registros possuem uma entrada no índice; normalmente usado em arquivos ordenados para reduzir o tamanho do índice.  

## Vantagens

- **Busca eficiente e acelerada**, mesmo em arquivos de grande volume.  
- **Redução expressiva** do número de leituras diretas no arquivo de dados.  
- Possibilita consultas flexíveis por diferentes atributos, sem alterar a estrutura do arquivo de dados principal.  
