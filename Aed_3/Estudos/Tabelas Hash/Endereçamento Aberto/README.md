# Endereçamento aberto

Durante as inserções de índices em Tabelas Hash, é muito comum que alguns dados, ao terem seus endereços calculados pelas funções de dispersões, possuam um mesmo endereço. Tal fenômeno é chamado de colisão. Devido a isso,
é necessário que as colisões sejam tratadas para evitar inconsistência dos dados.

Desse modo, uma das técnicas utilizadas é o endereçamento aberto, que corresponde a um outro lugar que se localiza dentro da própria tabela (em algum endereço vazio) e é calculado matematicamente,
tal o processo de endereçamento aberto. 

## Colisões

<img width="921" height="511" alt="image" src="https://github.com/user-attachments/assets/637b4a9f-8438-44df-b2c7-1b9782a28bba" />

## Tratamento de colisões

Como já mencionado, é imprescindível que colisões sejam tratadas para que não haja inconsistência entre os dados, a partir disso, tem-se as formas de tratamento:

- Endereçamento aberto: Usa outras posições vazias dentro da própria da tabela hash
  
- Encadeamento interno: Usa uma área extradentro da própria da tabela hash
  
- Encadeamento externo: Usa uma área externa, fora da tabela (p.ex., um segundo arquivo).

## Endereçamento aberto

Trata-se de uma solução para que uma nova posição vazia seja encontrada para tratar a colisão entre dados. Existem três formas de procurar tais posições vazias:

### Sondagem Linear

<img width="922" height="395" alt="image" src="https://github.com/user-attachments/assets/a9f89a84-6c96-44a5-9fb4-cc0ba8f43e80" />

---

A Sondagem Linear é um dos métodos mais simples para tratar colisões em uma tabela hash, pois a principal vantagem está na facilidade de implementação, já que o cálculo da próxima posição 
é feito apenas somando um valor fixo ao índice original. Além disso, esse método apresenta boa localidade de referência, o que significa que os elementos tendem a ficar próximos na memória,
favorecendo o desempenho do cache e tornando as buscas mais rápidas enquanto a tabela não estiver muito cheia.

No entanto, a sondagem linear sofre com um problema conhecido como agrupamento primário (clustering), em que várias chaves acabam se concentrando em uma sequência de posições contíguas.
Isso faz com que as operações de inserção e busca se tornem progressivamente mais lentas conforme o fator de carga da tabela aumenta. Em tabelas muito cheias, o tempo médio para localizar um elemento cresce significativamente.

---

### Sondagem Quadrática

<img width="922" height="395" alt="image" src="https://github.com/user-attachments/assets/69937f13-355c-4ff9-93fd-779a87240933" />

---

A Sondagem Quadrática busca resolver o problema do agrupamento primário encontrado na sondagem linear, alterando a forma como os índices são recalculados após uma colisão.
Em vez de somar um incremento fixo, o método utiliza incrementos quadráticos (como 1², 2², 3², ...), o que faz com que as posições alternativas fiquem mais dispersas na tabela. 
Essa dispersão reduz a formação de grandes blocos consecutivos de posições ocupadas, melhorando o desempenho em relação à sondagem linear.

Por outro lado, a sondagem quadrática apresenta uma desvantagem importante: Ela pode gerar o chamado agrupamento secundário, em que chaves com o mesmo valor de hash inicial seguem exatamente a mesma sequência de sondagens.
Além disso, há casos em que a tabela pode não ser completamente percorrida, impedindo a inserção de novos elementos mesmo que ainda existam posições vazias.

---

### Duplo Hash

<img width="922" height="395" alt="image" src="https://github.com/user-attachments/assets/5c55dd81-08e1-4c1d-8c60-f540445bae80" />

---

O Duplo Hash é uma técnica mais sofisticada que utiliza duas funções hash diferentes. Quando ocorre uma colisão, o segundo hash é usado para determinar o tamanho do passo entre as posições testadas.
Essa abordagem proporciona uma excelente distribuição dos elementos, reduzindo fortemente tanto o agrupamento primário quanto o secundário. Assim, o desempenho das operações de busca, inserção e remoção tende a ser mais consistente, mesmo com um fator de carga mais alto.

A principal desvantagem do duplo hash é sua maior complexidade de implementação, já que é necessário definir duas funções hash bem projetadas para garantir bons resultados.
Além disso, o cálculo de duas funções em cada operação pode aumentar um pouco o custo computacional, tornando-o ligeiramente mais lento em tabelas pequenas, embora essa diferença seja compensada em aplicações maiores onde 
a redução de colisões tem maior impacto.

