# Registros em arquivos de dados estruturados

Os registros podem ser de tamanho fixo (em bytes) ou de tamanho variável. Geralmente eles são de tamanho variável quando há algum campo também de tamanho variável. 
Nesse caso, é necessário mecanismos para saber qual é o tamanho de cada registro.

---

## 1. Registros de Tamanho Fixo com Campos de Tamanho Fixo

Esta é a estrutura mais simples. Todos os registros no arquivo possuem o mesmo tamanho, e cada campo dentro do registro também tem um comprimento pré-definido e constante. A localização de qualquer registro pode ser calculada diretamente a partir de sua posição, multiplicando o índice do registro pelo seu tamanho fixo.

<img width="937" height="529" alt="image" src="https://github.com/user-attachments/assets/f2e2417f-d65c-4540-80db-2d31c2e42656" />

---

## 2. Registros de Tamanho Fixo com Campos de Tamanho Variável

Neste modelo, o registro como um todo ainda possui um tamanho fixo, mas os campos internos podem variar. Para acomodar essa variabilidade, ponteiros ou marcadores de fim de campo são utilizados. O espaço total do registro é fixo, e o espaço não utilizado por um campo pode ser aproveitado por outro ou preenchido com um caractere nulo.

<img width="938" height="530" alt="image" src="https://github.com/user-attachments/assets/14355abe-9b3c-4d2b-b36e-ebfc39440ef2" />

---

## 3. Registros de Tamanho Variável

Quando os próprios registros têm tamanhos diferentes, a estrutura se torna mais complexa. Isso geralmente ocorre quando há campos de tamanho variável que podem conter uma quantidade muito díspar de dados (como campos de texto longo ou blobs). Para gerenciar isso, cada registro é prefixado com um campo que indica seu próprio tamanho, ou um delimitador especial é usado para marcar o fim de um registro.

<img width="939" height="532" alt="image" src="https://github.com/user-attachments/assets/cc91db1f-1f62-48ce-9dbe-a765794cef08" />


---

## Tabela Comparativa

| Tipo de Registro | Acesso ao Registro | Gerenciamento de Espaço | Complexidade |
| :--- | :--- | :--- | :--- |
| **Fixo com Campos Fixos** | Direto e rápido | Baixa eficiência (desperdício) | Baixa |
| **Fixo com Campos Variáveis** | Direto | Média eficiência | Média |
| **Variável** | Sequencial | Alta eficiência (sem desperdício) | Alta |

