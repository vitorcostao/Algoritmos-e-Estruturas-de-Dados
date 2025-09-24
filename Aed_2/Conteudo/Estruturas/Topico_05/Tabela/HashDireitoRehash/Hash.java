/**
 * Classe de tabela hash
 * 
 * 
 * hash = return elemento % m; -> Chave de pesquisa
 * rehash = return ++elemento % m -> Chave de pesquisa posterior
 * 
 * Inserção verifica se elemento é diferente de nulo, pois não faz sentido inserir -1 sendo que -1 é o valor sentinela nulo.
 * Calcula a posição com hash(elemento) e verifica se tabela[pos] é diferente de nulo e insere dado e resp = true.
 * Caso se a posição não for nula e ja estiver ocupada, faz o rehash(elemento) e verifica se tabela[pos] é nulo para inserir.
 * Retorna resp;
 * 
 * 
 * 
 * Pesquisar trabalha de forma semelhante.
 * Trabalha resp como variavel, calcula a posição e verifica se tabela[pos] == elemento, se for resp é true, senão faz o mesmo usando rehash
 */
public class Hash {

   // Definir dados
   int tabela[]; // Arranjo de elementos que é uma tabela
   int m; // Tamanho do arranjos
   final int NULO = -1; // Indicador

   // Cria tabela de tamanho 13
   public Hash() {
      this(13);
   }

   // Cria tabela de tamanho m
   public Hash(int m) {

      this.m = m; // Define tamanho
      this.tabela = new int[this.m]; // Reserva espaço para o vetor

      for (int i = 0; i < m; i++) {
         tabela[i] = NULO; // Seta dados do vetor como -1
      }
   }

   // Hash procura chave
   public int h(int elemento) {

      return elemento % m; // Função hash que procura chave
   }

   // Rehash procura proxima posição da chave
   public int reh(int elemento) {

      return ++elemento % m; // Função rehash que procura proxima posição da chave
   }

   // Inserção de dados
   public boolean inserir(int elemento) {
      
      // Definir dados
      boolean resp = false; // Inserção bem sucedida

      // Se o elemento for diferente de -1
      if (elemento != NULO) {

         // Procura a posição do elemento
         int pos = h(elemento);

         // Insere na tabela caso a posição seja nula
         if (tabela[pos] == NULO) {
            tabela[pos] = elemento;
            resp = true;

         } else { // Senão for nula, procura a posição da frente

            // Rehash
            pos = reh(elemento);

            // Insere na tabela caso posição seja nula
            if (tabela[pos] == NULO) {
               tabela[pos] = elemento;
               resp = true;
            }
         }
      }

      // Retorna se inserção foi bem sucedida
      return resp;
   }

   public boolean pesquisar(int elemento) {

      // Definir dados
      boolean resp = false;

      // Calcula posição do elemento
      int pos = h(elemento);

      // Se encontrado resp = true;
      if (tabela[pos] == elemento) {
         resp = true;

      } else if (tabela[pos] != NULO) { // Se for diferente de nulo

         // Faz rehash
         pos = reh(elemento);

         // Verifica
         if (tabela[pos] == elemento) {
            resp = true;
         }
      }

      // Retorna
      return resp;
   }

   boolean remover(int elemento) {
      boolean resp = false;
      // ...
      return resp;
   }
}