# Listas Invertidas

## O que é uma Lista Invertida (ou Índice Invertido)?

Uma lista invertida é uma lista de termos em que cada um desses termos possui uma lista secundária de entidades em que o termo aparece. Os termos podem ser atributos completos ou partes deles.

Por exemplo, no título do livro "Sistemas de Bancos de Dados" aparecem os termos "bancos", "dados", "de" e "sistemas". Já no livro "Estruturas de Dados" aparecem os termos "dados", "de" e "estruturas". 

Se atribuido ao primeiro livro o ID 1 e, ao segundo livro, o ID 2, torna-se possível montar a seguinte lista invertida, em que cada termo contém uma lista dos livros em que esse termo aparece:

![Exemplo de Lista Invertida](https://github.com/user-attachments/assets/ca431e4c-cff0-4af7-bb2f-e21988cfccee)

Por meio dessa imagem, é possível perceber o por que essas listas são chamadas de listas invertidas: são utilizados dados para se obter o ID, ao invés do ID para se obter os dados.

---

## Como é realizada a pesquisa por Índices Invertidos?

### 1) Primeiro Passo: Normalização da Consulta

Antes de buscar nos índices, a consulta do usuário precisa ser **pré-processada** de forma semelhante aos documentos que já estão indexados, removendo stop-words:

- **Remover Stop Words**  
  Ex.: `"Sistemas de Bancos"` → `"Sistemas Bancos"`  

- **Transformar tudo em minúsculas**  
  Ex.: `"sistemas dados"` → `"sistemas dados"`  

- **Remover acentos e caracteres especiais**  
  Ex.: `"sistemas bancos"` → `"sistemas bancos"`  

- **Tokenizar a consulta** (dividir em palavras)  
  Ex.: `"sistemas dados"` → `["sistemas", "dados"]`

> Esse passo garante que a consulta seja compatível com os termos do índice invertido.

---

### 2) Segundo Passo: Análise do índice.

**Tendo as seguintes tarefas:**

- Agendar reunião com a equipe de atendimentos
- Enviar relatório de desempenho da equipe para a diretoria
- Verificar e-mails da diretoria e e-mails da equipe
- Enviar e-mails sobre a reunião para os clientes
- Elaborar relatório de atendimentos aos clientes

Após a realização do passo (1), é necessário que cada palavra seja computada de acordo com seu id e sua frequência, logo tem-se os pares (ID, Frequência):

- agendar: (1, 0.25)
- reuniao: (1, 0.25) (4, 0.25)
- equipe: (1, 0.25) (2, 0.2) (3, 0.2)
- atendimentos: (1, 0.25) (5, 0.25)
- enviar: (2, 0.2) (4, 0.25)
- relatorio: (2, 0.2) (5,0.25)
- desempenho: (2, 0.2)
- diretoria: (2, 0.2)
- verificar: (3, 0.2)
- e-mails: (3, 0.4) (4, 0.25)
- diretoria: (3, 0.2)
- clientes: (4, 0.25) (5, 0.25)
- elaborar: (5, 0.25)

> Estes valores de frequência serão utilizados posteriormente para o cálculo de **TF-IDF**, permitindo determinar a relevância de cada documento em relação à consulta.

---

### 3) Terceiro Passo: Processo de Consulta a partir de uma busca

Para a consulta "e-mails reunião equipe", cada palavra da busca é comparada com os pares de ID e frequência das tarefas calculados anteriormente.

Para cada palavra, é calculado o IDF, que corresponde ao total de tarefas dividido pelo número de tarefas em que a palavra aparece. 

O valor do IDF é então multiplicado pela frequência da palavra em cada tarefa, resultando no valor TF-IDF, que indica a relevância da palavra em cada tarefa.
Os valores TF-IDF calculados para cada palavra permitem determinar a relevância de cada tarefa em relação à consulta realizada.

+ e-mails –  IDF: 5/2  Lista: (3, 0.4) (4, 0.25)  →  (3, 1.0)  (4, 0.625)
+ reuniao – IDF: 5/2 Lista: (1, 0.25) (4, 0.25)  →  (1, 0.625)  (4, 0.625)
+ equipe – IDF: 5/3 Lista: (1, 0.25) (2, 0.2) (3, 0.2)  →  (1, 0.417) (2, 0.333) (3, 0.333)


---

### 4) Quarto Passo: Ranking dos Resultados

Após realizados os passos (1), (2) e (3), é necessário somar os cálculos realizados de acordo com os id´s, por exemplo:

- Para id 1:
    
    - (1, 1.042): 0.625 + 0.417

- Para id 2:
    
    - (2, 0.333): 0.333


- Para id 3:
    
    - (3, 1.333): 1.0 + 0.333

- Para id 4:
    
    -  (4, 1.250): 0.625 + 0.625

---

### 4) Quarto Passo: Ordenar os resultados por cálculo obtido e exibir

Resultado (não ordenado):   (1, 1.042)   (2, 0.333)   (3, 1.333)   (4, 1.250)
 
Resposta ordenada para o usuário:

- Verificar e-mails da diretoria e e-mails da equipe (3)
- Enviar e-mails sobre a reunião para os clientes (4)
- Agendar reunião com a equipe de atendimentos (1)
- Enviar relatório de desempenho da equipe para a diretoria (2)


       