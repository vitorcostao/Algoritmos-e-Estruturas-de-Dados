# Resumo: Arquivos de Dados Estruturados

Todo arquivo é apenas uma sequência de bytes. Assim, para armazenar informações em um arquivo, é importante saber como representá-las por meio de bytes. Neste resumo, será mostrado como os dados estruturados são armazenados em um arquivo.

## O que são dados estruturados?

Os dados estruturados são informações organizadas segundo um formato padronizado, o que possibilita seu armazenamento sistemático e a execução de consultas de forma eficiente. Por exemplo, a entidade “Jogador” é composta pelos atributos Id, Nome e Pontos. Cada instância dessa entidade mantém a mesma estrutura de atributos, garantindo consistência e uniformidade nos dados durante o armazenamento.

## Conceitos importantes

-  **Entidade:** Define-se por Entidade, qualquer coisa do mundo real, podendo ser física ou abstrata.
-  **Atrubuto:** Define-se por Atributo, uma propriedade que descreve uma Entidade, ou seja, suas características.
-  **Registro:** Define-se por Registro, uma sequência de bytes em um arquivo que contém uma entidade.
-  **Campo:** Define-se por Campo, um parte do registro, também na forma de uma sequência de bytes, que contém um atributo da entidade.

## Exemplo utilizando a entidade Jogador

Nesta imagem, tem-se a representação de um arquivo de dados estruturados. Nela, é possível perceber que existem três instâncias da entidade "Jogador", cada uma com seus respectivos atributos. Além disso, a imagem mostra como esses registros são armazenados em um arquivo, por meio de sequências de bytes. 

<img width="937" height="527" alt="image" src="https://github.com/user-attachments/assets/364094aa-acc8-441b-bb71-8925d628dc58" />
