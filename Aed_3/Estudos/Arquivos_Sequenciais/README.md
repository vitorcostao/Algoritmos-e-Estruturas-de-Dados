# Resumo: Arquivos Sequenciais

Em acesso sequencial a registros, é tratada a questão do acesso a vários registros e não apenas a um ou outro registro específico (o que é chamado de acesso aleatório).
Em acessos sequenciais, geralmente existe algum critério na organização dos registros, isto é, algo que define a ordem deles. Esse critério é chamado de chave de ordenação e normalmente é determinado a partir de um ou mais campos do registro.
Há, porém, a possibilidade de se trabalhar com arquivos sequenciais em que não há nenhuma chave de ordenação.

## Características

 - Os registros são acessados na ordem em que estão armazenados e normalmente são usados quando há poucas (ou nenhuma) movimentação de registros.
 - Tem como objetivo o acesso rápido a um conjunto de registros.
 - Não são bons para acessos aleatórios,
 - Os registros nos arquivos sequenciais podem estar ordenados por chave ou não.

## Observações

  - O arquivo eventualmente precisará ser reordenado para se manter a ordem dos registros.

      - Arquivos sequenciais são usados quando sofrem poucas alterações.

      
  - Arquivos sequenciais geralmente são usados como arquivos temporários.
    
      - Existem outras estruturas bem melhores para acesso aleatório como os arquivos indexados e os arquivos diretos.
