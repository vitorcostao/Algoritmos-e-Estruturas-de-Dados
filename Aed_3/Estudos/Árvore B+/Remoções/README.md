# Remoções em uma Árvore B+.

Os casos de remoção em Árvores B+ são iguais aos da Árvore B, todavia há algumas mudanças:

- Ao realizar a fusão de folhas, a retenção de uma chave só ocorre nas folhas, pois em páginas superiores isto não é necessário.

- Caso seja necessário descer com uma chave, se ela já tiver sido removida, ela deverá sumir.

## Exemplos

### Remoção da chave 10

<img width="491" height="171" alt="image" src="https://github.com/user-attachments/assets/87f85f3f-8640-40f4-8535-d2d7f8bb7f74" />

<img width="491" height="171" alt="image" src="https://github.com/user-attachments/assets/d3653698-3f7f-4bfb-a100-426e110b8d12" />

> OBS: Remover o 10, neste caso, apenas move as outras chaves, porém se for necessária a fusão de páginas em não folhas, a chave deve
descer, já em páginas folhas, a chave não deve descer, devido à questão da validade de chaves em folhas.