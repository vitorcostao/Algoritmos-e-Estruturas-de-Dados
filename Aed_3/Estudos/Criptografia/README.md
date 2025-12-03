# Segurança no Armazenamento de Dados e Criptografia

A segurança no armazenamento de dados constitui, atualmente, um dos mais relevantes desafios da área de Tecnologia da Informação. Embora essa preocupação também se estenda às comunicações realizadas pela Internet — uma vez que foram os sistemas de comunicação que inicialmente impulsionaram o desenvolvimento de técnicas de proteção —, o foco deste material concentra-se especificamente na proteção das informações armazenadas.

Os frequentes casos de vazamento e roubo de informações na Internet evidenciam a importância desse tema. Contudo, como os mecanismos de troca de mensagens costumam ser, em geral, mais seguros do que os próprios meios de armazenamento, os ataques maliciosos tendem a se concentrar na invasão de sistemas, em vez da interceptação direta de comunicações. Dessa forma, torna-se evidente que o conhecimento sobre métodos seguros de armazenamento de dados é uma competência essencial para qualquer desenvolvedor.

## Criptografia como Mecanismo de Proteção

O principal recurso utilizado para assegurar a proteção dos dados armazenados é a criptografia. Esse processo consiste na transformação das informações originais em dados incompreensíveis, por meio de um procedimento denominado cifragem. O grande desafio da criptografia é garantir que os dados se tornem ilegíveis para pessoas não autorizadas, ao mesmo tempo em que se preserve a possibilidade de sua recuperação legítima, por meio da decifragem.

## Técnicas de Cifragem

Diversos algoritmos criptográficos fazem uso, essencialmente, de duas técnicas fundamentais:

### Cifra de Transposição

Baseia-se na alteração da posição dos bytes ou bits dos dados, mantendo inalterados os seus valores originais.

### Cifra de Substituição

Consiste na substituição direta dos bytes originais por outros bytes distintos, alterando o conteúdo dos dados de forma controlada.

Essas técnicas podem ser aplicadas de maneira isolada ou combinada, de acordo com o nível de segurança desejado.

## Chave Criptográfica

Tanto as cifras de transposição quanto as de substituição são influenciadas por um parâmetro fornecido pelo usuário, denominado chave criptográfica. A variação dessa chave implica diretamente em diferentes resultados de cifragem, o que aumenta significativamente a segurança do processo.

## Finalidades da Criptografia

As técnicas criptográficas são empregadas com o objetivo de garantir três princípios fundamentais da segurança da informação:

- **Privacidade:** assegura que apenas indivíduos autorizados tenham acesso aos dados.
- **Integridade:** garante que as informações não tenham sido alteradas de forma indevida.
- **Autenticidade:** possibilita a verificação da identidade do aut



---



# Algoritmos Criptográficos

Há muitos algoritmos criptográficos desenvolvidos ao longo das últimas décadas. Alguns foram abandonados por não oferecerem mais segurança suficiente, outros evoluíram em variantes e modos de operação.


## Algoritmos de Chave Simétrica

Entre os algoritmos de chave simétrica mais conhecidos, destacam-se:

- **Data Encryption Standard (DES)**
- **Triple DES (3DES ou TDES)**
- **Advanced Encryption Standard (AES)**


## Data Encryption Standard (DES)

O DES é um cifrador de bloco. Ele opera em blocos de 64 bits e utiliza uma chave efetiva de 56 bits. Hoje,
é considerado inseguro para aplicações modernas, principalmente devido à vulnerabilidade a ataques de força bruta.

---

## Triple DES (3DES)

O Triple DES surgiu como uma tentativa de aumentar a segurança do DES por meio da aplicação do algoritmo três vezes consecutivas com chaves diferentes. Mais seguro que o DES, porém menos eficiente,
além de, gradualmente, estar sendo substituído por algoritmos mais modernos.

---

## Advanced Encryption Standard (AES)

O AES é o padrão atual para criptografia simétrica. Ele opera com blocos de 128 bits e permite chaves de 128, 192 ou 256 bits. É utilizado em sistemas modernos devido à alta segurança e desempenho.

---

## Outros algoritmos


### Chave Simétrica
- IDEA  
- Blowfish  
- Twofish  

### Chave Assimétrica
- Diffie-Hellman  
- RSA  

### Funções Hash Criptográficas
- MD5  
- SHA-1  
- SHA-2  
- SHA-3  



