# Compressão de dados

## Definição

O conceito por trás de Compressão dos Dados é originada a partir da Teoria da Informação, que é uma área da computação.
Nessa área, há uma preocupação em quantificar as informações para fins de melhor armazenamento ou comunicação. Ou seja,
quantos bits são necessários para representar uma determinada informação, seja um arquivo, foto, vídeo e etc. 
Esse tipo de cálculo é bastante usado em comunicação, armazenamento, inteligência artificial e aprendizagem de máquina.

De modo simples, é possível dizer que símbolos mais frequentes devem gastar menos bits que um símbolo menos frequente.
Por exemplo, suponhas as seguintes alternativas de codificação da mensagem "AAAAAAAAAABBBBBCCD" (são 10 letras A, 5 letras B, 2 letras C e 1 letra D, totalizando 18 letras):

- Se A = 00, B = 01, C = 10 e D = 11, então a mensagem completa gastará 18*2 = 36 bits.
- Se A = 0, B = 10, C = 110 e D = 111, então a mensagem completa gastará 10*1 + 5*2 + 2*3 + 1*3 = 29 bits.

A segunda alternativa traz uma economia de aproximadamente 20% no uso dos bits. Em grandes massas de dados, 20% significa um ganho e tanto.

Em suma, a Compressão dos Dados oferece uma forma de codificação para gastar menos bits no armazenamento ou comunicação.


> OBS: Há redução da quantia de símbolos, por exemplo, uma letra representar uma palavra, e há redução do tamanho
do símbolo, por exemplo, usar menos de um byte para representar uma letra.

## Eficácia

Para avaliar a eficácia da uma compressão, é necessário observar a razão entre o tamanho dos dados comprimidos e o
tamanho original e subtraiir 1. Este valor é conhecido como razão da compressão dos dados. 

Se um arquivo gastava 800 bytes e, compactado, precisa de apenas 600 bytes, então a razão é dada por:

$$1 - \frac{600}{800} = 0,25 = 25% $$

Os métodos de compressão de dados são divididos em duas classes: com perdas e sem perdas. 
Em compressões com perdas, há alguma perda de precisão ou na qualidade dos dados em troca de maior razão de compressão.
Isto é aceitável em algumas aplicações tais como imagens, vídeos e áudios, contanto que a mensagem continue compreensível.
Quando não for o caso, usa-se a compressão sem perdas em que há uma reprodução exata dos dados originais, quando eles são descomprimidos.




