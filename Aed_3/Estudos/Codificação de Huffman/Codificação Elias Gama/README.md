# Compressão de Elias Gama

A **Codificação Elias Gama** é uma forma de codificação em que se busca usar menos bits para números pequenos e mais bits para números grandes. 
Esse tipo de codificação considera, portanto, que números pequenos são muito mais frequentes que os números grandes.

## Surgimento

A compressão estatística, isto é, aquela baseada na probabilidade, é apenas uma das formas de compressão. Nessa codificação, é preciso usar alguma sequência binária de tamanho variável. 
Se todos os símbolos dessa informação tiverem a mesma quantidade de bits, então não é possível compactar nada.
O segredo todo dessa compressão é, portanto, encontrar uma forma de codificação diferente. Por exemplo, em uma situação em que números pequenos apareçam muito mais vezes que números grandes, é possível pensar em
uma compressão unária, em que:

<img width="273" height="555" alt="image" src="https://github.com/user-attachments/assets/a1724d4c-56b3-449c-a453-731577e8be35" />

A partir desta tabela, é possível observar que essa codificação tende a apresentar desempenho inferior à codificação binária tradicional à medida que os valores aumentam. 
Portanto, torna-se necessário buscar alternativas mais eficientes. Uma dessas alternativas, aplicável inicialmente apenas a números pequenos, é a codificação de Elias-Gama. Essa técnica baseia-se no princípio de que qualquer número
N pode ser representado a partir de uma potência de 2:

$$N = 2^p + q$$

em que q deve ser menor que $$2^p$$.

A seguir, a potência (p) pode ser codificada utilizando uma **sequência unária** (composta por zeros), enquanto o restante (q) é representado por uma **sequência binária** com o mesmo número de bits de \(p\).
Dessa maneira, obtêm-se os códigos correspondentes para números pequenos.

<img width="200" height="451" alt="image" src="https://github.com/user-attachments/assets/3ca926ab-cd86-4350-861f-b28a8c2c8c2c" />
