# Encadeamento Interno e Externo

A principal diferença do Encadeamento Interno para o Endereçamento Aberto é o fato da flexibilidade para expansão dos dados, ou seja, enquanto em uma solução é mais eficiente quando a quantia
de registros é previsível, a outra se mostrar mais interessante quando o sistema deve priorizar escalabilidade.

## Área de Reserva

A área de reserva em uma tabela hash é uma parte auxiliar usada para armazenar elementos que causam colisão, ou seja, quando duas ou mais chaves diferentes são mapeadas para a
mesma posição na tabela principal pela função hash. Essa área funciona como um espaço extra dentro da própria estrutura,
servindo como uma extensão da tabela principal para garantir que nenhum dado seja perdido devido a colisões.

Quando uma chave é inserida, o algoritmo calcula sua posição com base na função hash. Se essa posição estiver livre, o elemento é armazenado normalmente na tabela principal. 
No entanto, se já existir outro elemento naquele mesmo índice, ocorre uma colisão. Nesse caso, em vez de usar sondagens, o elemento é armazenado na área de reserva,
e a posição original passa a conter um ponteiro (ou índice) que indica onde o novo elemento foi guardado. Assim, forma-se uma espécie de cadeia de elementos que compartilham o mesmo valor de hash,
todos dentro do mesmo vetor físico da tabela.

## Encadeamento Interno

<img width="913" height="498" alt="Captura de tela 2025-10-16 114438" src="https://github.com/user-attachments/assets/aa04d905-d0b5-4683-978b-d5bc993cfeec" />

---

## Encadeamento Externo

<img width="916" height="505" alt="image" src="https://github.com/user-attachments/assets/21fbe3a0-39bd-49d4-8fa1-8ac4796a2e66" />
