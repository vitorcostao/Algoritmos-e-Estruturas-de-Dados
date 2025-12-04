# Algoritmo de Boyer Moore

Um dos algoritmos mais eficientes para reconhecimento exato de padrões é o algoritmo de Boyer-Moore.
Versões simplificadas ou completas desse algoritmo são frequentemente implementadas nos mecanismos de busca e substituição de softwares modernos, como editores de texto e navegadores.

O algoritmo realiza as comparações dos caracteres do padrão da direita para a esquerda, iniciando pelo último caractere. 
Em caso de diferença ou de casamento completo do padrão, são utilizadas duas regras previamente calculadas para determinar o deslocamento até a próxima comparação. 
Essas regras são conhecidas como deslocamento por caractere ruim e deslocamento por sufixo bom. Assim como no algoritmo KMP, o Boyer-Moore possui uma etapa de pré-processamento.

O algoritmo de Boyer-Moore tornou-se um dos algoritmos de casamento de padrões mais conhecidos e é frequentemente utilizado como referência para a avaliação de novas propostas.
Um novo algoritmo, em geral, é comparado ao Boyer-Moore quanto ao desempenho, sendo possível superá-lo apenas em situações específicas.