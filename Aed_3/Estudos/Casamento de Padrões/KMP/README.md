# Algoritmo KMP

O algoritmo KMP é baseado em uma máquina de estados, que é construída a partir do padrão e não do documento em que esse padrão será buscado.
A construção da máquina de estados é feita antes da busca propriamente dita. Assim, ela ocorre em uma fase de pré-processamento.

## Funcionamento

Para compreender a ideia por trás desse conceito, considere-se o exemplo do padrão ARANHA a ser buscado em um documento.
Esse padrão contém a repetição da sequência de caracteres AR, ou seja, apresenta a repetição de um prefixo.
Suponha que, durante a busca no documento, tenham sido encontrados os caracteres ARAN. Nesse ponto, faltaria apenas o caractere HA para que o padrão fosse completamente identificado.

Entretanto, imagine que o próximo caractere no documento, em vez do H esperado, seja a letra A. Nesse caso, o padrão não será reconhecido nessa tentativa de casamento. 
Ainda assim, observa-se que a sequência ARANA, embora não corresponda ao padrão completo, possui nos seus três últimos caracteres (ARA) um possível início do padrão ARANHA. 
Dessa forma, caso os próximos caracteres do documento sejam N e, em seguida, H e A, o padrão será encontrado com apenas mais comparações de caracteres.

Caso fosse utilizado o algoritmo de força bruta, seria necessário reiniciar a verificação e comparar novamente todos os seis caracteres do padrão.


