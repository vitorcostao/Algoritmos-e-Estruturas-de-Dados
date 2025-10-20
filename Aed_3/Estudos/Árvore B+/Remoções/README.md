# Remoções em uma Árvore B+.

Os casos de remoção em Árvores B+ são iguais aos da Árvore B, todavia há algumas mudanças:

- Ao realizar a fusão de folhas, a retenção de uma chave só ocorre nas folhas, pois em páginas superiores isto não é necessário.

- Caso seja necessário descer com uma chave, se ela já tiver sido removida, ela deverá sumir.