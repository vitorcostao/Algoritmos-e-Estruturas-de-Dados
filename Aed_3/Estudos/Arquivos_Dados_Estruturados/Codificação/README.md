# Armazenamento de informações em computadores
Todas as informações armazenadas em computadores são representadas como **sequências de bytes**. Cada byte é formado por **8 bits** e pode representar números, caracteres, ou partes de imagens e outros dados.

Por exemplo, considere o byte 01000001:


- Em decimal, ele corresponde a `65`.  
- Em hexadecimal, é `0x41`.  
- E, na codificação ASCII, representa a letra maiúscula **A**.

Da mesma forma, o valor `66` (`01000010` em binário ou `0x42` em hexadecimal) representa a letra **B**, `67` representa **C**, e assim por diante. As letras minúsculas começam no valor `97` (`a = 97`, `b = 98`, `c = 99`).

---

### Mapeamento em ASCII para valores númericos

| Letra | Binário | Decimal | Hexadecimal |
|:------|:--------|:--------|:------------|
| A | 01000001 | 65 | 0x41 |
| B | 01000010 | 66 | 0x42 |
| C | 01000011 | 67 | 0x43 |
| a | 01100001 | 97 | 0x61 |
| b | 01100010 | 98 | 0x62 |
| c | 01100011 | 99 | 0x63 |

---

Uma codificação de caracteres é, portanto, o mapeamento de caracteres em números exclusivos. Ela permite que computadores armazenem e manipulem textos de forma consistente. Além de letras, a codificação também cobre números, sinais de pontuação e símbolos especiais.

No entanto, diferentes codificações históricas causaram problemas na troca de dados entre países e sistemas. Para padronizar a representação de caracteres em múltiplos idiomas, foi criado o Unicode, mantido pelo Unicode Consortium. 
O Unicode define um sistema de codificação de caracteres universal, garantindo compatibilidade global e permitindo a representação de praticamente todos os símbolos e letras usados em linguagens humanas.