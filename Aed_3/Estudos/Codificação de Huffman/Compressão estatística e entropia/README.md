# Compressão estatística e entropia

Existem vários sistemas de codificação, todavia, para identificar o melhor, a Teoria da informação introduz um conceito de 
entropia, que é responsável por sinalizar quantos bit são necessários, em média, para representar os símbolos de uma mensagem.

## Cálculo da entropia

Suponha a seguinte mensagem: "ABCD". Nesta mensagem há 4 letras, cada uma com a probabilidade de 25%. Assim, todas têm mesma chance de aparecer e, portanto, 
cada uma acabará usando 2 bits para ser representada: A=00, B=01, C=10 e D=11. A entropia, que indica o tamanho médio de cada símbolo, neste caso, é de 2 bits.

Todavia, caso a mensagem fosse: "AAAABBCD", então as frequências são: A = 1/2, B = 1/4, C = 1/8 e D = 1/8. Em termos de probabilidade, têm-se os seguintes valores: A = 50%, B = 25%, C = 12,5% e D = 12,5%. 

Para cada símbolo, tem-se:

$$Si = -\log{2}{(Pi)}$$

Nesse caso, a estimativa de bits Si para cada símbolo i depende da probabilidade Pi desse símbolo, logo:

- $$Sa = -\log{2}{(Pa)} = -\log{2}{(0.5)} = 1$$
- $$Sb = -\log{2}{(Pb)} = -\log{2}{(0.25)} = 2$$
- $$Sc = -\log{2}{(Pc)} = -\log{2}{(0.125)} = 3$$
- $$Sd = -\log{2}{(Pd)} = -\log{2}{(0.125)} = 3$$

Desse modo, sabendo a quantia de letras da mensagem, que são A = 4, B = 2, C = 1 e D = 1, é possível saber a quantia de bits necessários na mensagem:

$$4 * 1 + 2 * 2 + 3 * 1 + 3 * 1 = 14$$

Portanto, o tamanho médio de cada símbolo corresponde a:

$$\frac{14}{8} = 1.75$$

Além disso, é possível calcular a entropia diretamente, basta multiplicar o tamanho de cada símbolo pela sua própria probabilidade. Desenvolvendo esse cálculo, tem-se:

$$0.5 * 1 + 0.25 * 2 + 0.125 * 1 + 0.125 * 1 = 1.75$$

