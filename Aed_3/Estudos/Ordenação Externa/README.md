# Resumo: Ordenação Externa

Quando se utiliza um arquivo sequencial ordenado, é necessário assegurar que os dados estejam dispostos na ordem correta. Em geral, esses arquivos são construídos sob demanda, a partir de informações provenientes de diversas fontes. Após a coleta, torna-se indispensável ordená-los para que possam ser utilizados de maneira eficiente.

Existem também situações em que os dados já se encontram ordenados, porém, em virtude de inclusões ou modificações, há a necessidade de reordenação.

Como, na maioria dos casos, o conjunto de dados armazenado em um arquivo excede a capacidade da memória principal, os algoritmos tradicionais de ordenação, como o quicksort ou o mergesort, não são adequados. Nesses casos, a ordenação deve ser realizada diretamente no dispositivo de armazenamento. Além disso, tais algoritmos demandam diversas operações de leitura e escrita, que, por envolverem o acesso ao disco, são consideravelmente lentas.

A ordenação externa — isto é, a ordenação executada em memória secundária — deve ser projetada de modo a minimizar o número de leituras e escritas em disco, explorando, sempre que possível, a leitura e escrita de grandes blocos de dados para otimizar o desempenho do processo.