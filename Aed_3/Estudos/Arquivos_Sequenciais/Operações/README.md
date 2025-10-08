# Operações em Arquivos Sequenciais

As quatro operações fundamentais realizadas em armazenamentos permanentes (arquivos) são: **Create, Read, Update e Delete (CRUD)**.  



## Descrição das Operações

- **Create**: Insere uma nova entidade no arquivo.  
- **Read**: Recupera dados de uma ou mais entidades existentes.  
- **Update**: Atualiza os dados de uma entidade no arquivo.  
- **Delete**: Remove uma entidade do arquivo, geralmente por meio de marcação lógica.  

## Operações sobre Registros Únicos e Múltiplos

As operações CRUD podem ser aplicadas tanto a um único registro quanto a múltiplos registros:

- Um método **Read** baseado em **ID** retornará, em geral, apenas uma entidade, uma vez que os IDs são valores exclusivos.  
- Um método **Read** baseado em critérios mais amplos (como data de nascimento, modelo de carro ou gênero de filme) poderá retornar múltiplas entidades correspondentes aos critérios especificados.  



## Diversidade de Implementações

Cada operação CRUD pode possuir várias implementações, desde que apresentem **assinaturas distintas** (parâmetros de entrada e valores de retorno diferentes).  

Por exemplo, em um arquivo de usuários, é possível implementar:

- **Read por ID**: Retorna uma única entidade.  
- **Read por e-mail**: Retorna uma única entidade.  
- **Read por termos do nome** (ex.: "Ana", "Carlos", "João", "Paula"): Retorna um conjunto de entidades que correspondam aos termos pesquisados.  

Dessa forma, o sistema garante flexibilidade na recuperação de dados, permitindo consultas específicas ou mais abrangentes, conforme a necessidade da aplicação.  



## Lápide (Marcação Lógica de Exclusão)

Em vez de remover fisicamente os registros de um arquivo, pode-se utilizar a técnica da **lápide**, que consiste em marcar o registro como excluído, mantendo-o no arquivo.  

- Isso evita deslocamentos e reescritas desnecessárias no arquivo.  
- Permite a recuperação futura de registros, caso necessário.  
- Facilita a manutenção da integridade dos dados e a continuidade da numeração de IDs.  


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
09:   escrever registro
10: fim-algoritmo
```


## Read (de uma única entidade)

```bash
01: algoritmo read(ID)
02:   mover o ponteiro para o primeiro registro (após o cabeçalho)
03:   enquanto não atingir o fim do arquivo
04:     ler próximo registro
05:     se registro.lapide ≠ '*'
06:       então extrair objeto do registro
07:             se objeto.ID = ID
08:               então retornar objeto e terminar
09:             fim-se
10:     fim-se
11:   fim-enquanto
12:   retornar objeto vazio // null
13: fim-algoritmo
```



## Read (de um conjunto de entidades)

```bash
01: algoritmo read(critérios)
02:   criar conjunto vazio
03:   mover o ponteiro para o primeiro registro (após o cabeçalho)
04:   enquanto não atingir o fim do arquivo
05:     ler próximo registro
06:     se registro.lapide ≠ '*'
07:       então extrair objeto do registro
08:             se objeto atender aos critérios
09:               então adicionar objeto ao conjunto
10:             fim-se
11:     fim-se
12:   fim-enquanto
13:   retornar conjunto 
14: fim-algoritmo
```


## Update

```bash
01: algoritmo update(novoObjeto)
02:   mover para o primeiro registro do arquivo (após cabeçalho)
03:   enquanto não atingir o fim do arquivo
04:     pos ← posição do ponteiro
05:     ler próximo registro
06:     se registro.lapide ≠ '*'
07:       então extrair objeto do registro
08:             se objeto.ID = novoObjeto.ID
09:               então criar novoRegistro para novoObjeto
10:                     se novoRegistro.tamanho ⩽ registro.tamanho
11:                       então mover para pos
12:                             escrever novoRegistro mantendo ind.tam.
13:                       senão mover para pos
14:                             escrever lápide como excluído
15:                             mover para fim do arquivo
16:                             escrever novoRegistro
17:                       fim-se
18:                       retornar verdadeiro e terminar
19:             fim-se
20:     fim-se
21:   fim-enquanto
22:   retornar falso
23: fim-algoritmo
```


## Delete

```bash
01: algoritmo delete(ID)
02:   mover o ponteiro para o primeiro registro (após o cabeçalho)
03:   enquanto não atingir o fim do arquivo
04:     pos ← posição do ponteiro
05:     ler próximo registro
06:     se registro.lapide ≠ '*'
07:       então extrair objeto do registro
08:             se objeto.ID = ID
09:               então mover para pos
10:                     escrever lápide como excluído
11:                     retornar verdadeiro e terminar
12:             fim-se
13:     fim-se
14:   fim-enquanto
15:   retornar falso
16: fim-algoritmo
```

