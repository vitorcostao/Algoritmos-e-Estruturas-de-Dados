# Operações em Arquivos Indexados

As quatro operações fundamentais realizadas em armazenamentos permanentes (arquivos) são: **Create, Read, Update e Delete (CRUD)**. Nos arquivos indexados, essas operações são realizadas com o apoio de **índices**, permitindo buscas mais rápidas, mesmo em arquivos de grande volume.

---

## Índices

Arquivos indexados dispõem de **estruturas auxiliares** chamadas **índices**, que podem ser implementadas como:

- **Tabela hash**  
- **Árvore**  

Um índice aponta para o endereço dos registros no arquivo de dados, permitindo que as buscas não precisem percorrer todos os registros sequencialmente.

### Classificação dos Índices

- **Primários ou secundários**:  
  - Primários: baseados na chave primária do arquivo.  
  - Secundários: baseados em outros atributos para consultas adicionais.  

- **Diretos ou indiretos**:  
  - Diretos: apontam diretamente para o endereço físico do registro.  
  - Indiretos: utilizam ponteiros intermediários para localizar o registro.  

- **Densos ou esparsos**:  
  - Densos: cada registro possui uma entrada no índice.  
  - Esparsos: nem todos os registros possuem entrada no índice; normalmente usados em arquivos ordenados.  

---

## Descrição das Operações

- **Create**: Insere uma nova entidade no arquivo, atualizando também os índices correspondentes.  
- **Read**: Recupera dados de uma ou mais entidades existentes, utilizando os índices quando disponíveis.  
- **Update**: Atualiza os dados de uma entidade, mantendo a consistência do índice.  
- **Delete**: Remove ou marca como excluído uma entidade, atualizando o índice.

---

## Operações sobre Registros Únicos e Múltiplos

- Um método **Read** baseado em **ID** (índice primário) retorna, geralmente, apenas uma entidade.  
- Um método **Read** baseado em critérios amplos (ex.: nome, e-mail ou outros atributos com índices secundários) pode retornar múltiplas entidades.

---

## Lápide (Marcação Lógica de Exclusão)

Em vez de remover fisicamente os registros, é comum utilizar a técnica da **lápide**, que marca o registro como excluído:

- Evita deslocamentos e reescritas desnecessárias.  
- Permite recuperação futura dos registros, se necessário.  
- Mantém a continuidade da numeração de IDs.  

---

## Create

```bash
01: algoritmo create(objeto)
02:   mover o ponteiro para início do arquivo (cabeçalho)
03:   ler últimoID
04:   objeto.ID ← últimoID + 1
05:   mover o ponteiro para início do arquivo
06:   escrever objeto.ID
07:   criar registro para o objeto
08:   mover para o fim do arquivo
09:   pos ← posição do ponteiro
10:   escrever registro
11:   inserir o par (objeto.ID, pos) no índice
12: fim-algoritmo
```

## Read (de uma única entidade)

```bash
01: algoritmo read(ID)
02:   pos ← buscar o ID no índice
03:   se pos ≠ -1
04:     então mover o ponteiro para pos
05:           ler registro
06:           se registro.lapide ≠ '*'
07:              então extrair objeto do registro
08:                    retornar objeto e terminar
09:           fim-se
10:   fim-se
11:   retornar objeto vazio // null
12: fim-algoritmo
```


## Update

```bash
01: algoritmo update(novoObjeto)
02:   pos ← buscar o ID no índice
03:   se pos ≠ -1
04:      então mover o ponteiro para pos
05:            ler registro
06:            se registro.lapide ≠ '*'
07:               então extrair objeto do registro  // para algum teste do objeto
08:                     criar novoRegistro para novoObjeto
09:                     se novoRegistro.tamanho ⩽ registro.tamanho
10:                        então mover para pos
11:                              escrever novoRegistro mantendo ind.tam.
12:                        senão mover para pos
13:                              escrever lápide como excluído
14:                              mover para fim do arquivo
15:                              pos ← posição do ponteiro
16:                              escrever novoRegistro
17:                              atualizar o endereço para o ID no índice
18:                              retornar verdadeiro e terminar
19:                     fim-se
20:            fim-se
21:   fim-se
22:   retornar falso
23: fim-algoritmo
```

## Delete

```bash
01: algoritmo delete(ID)
02:   pos ← buscar o ID no índice
03:   se pos ≠ -1
04:      então mover o ponteiro para pos
05:            ler registro
06:            se registro.lapide ≠ '*'
07:               então extrair objeto do registro // para algum teste do objeto
08:                     mover para pos
09:                     escrever lápide como excluído
10:                     remover o ID do índice
11:                     retornar verdadeiro e terminar
12:            fim-se
13:   fim-se
14:   retornar falso
15: fim-algoritmo
```