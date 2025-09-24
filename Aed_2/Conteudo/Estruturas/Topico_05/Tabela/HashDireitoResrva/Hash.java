
/**
 * Classe para tabela hash com área de reserva
 * 
 */
public class Hash {

   // Definir dados
   int tabela[]; // Arranjo para representar a tabela
   int m1, m2, m, reserva; // Tamanhos das tabelas
   final int NULO = -1; // Indicador 

   // Construtor que define tamanho das regiões como 13 e 7
   public Hash() {
      this(13, 7);
   }

   // Construtor que define tamanho das regiões como m1 e m2
   public Hash(int m1, int m2) {

      // Seta tamanhos
      this.m1 = m1;
      this.m2 = m2;
      this.m = m1 + m2;

      // Cria tabela com tamanho somado
      this.tabela = new int[this.m];

      // Reserva espaço para vetor
      for (int i = 0; i < m1; i++) {
         tabela[i] = NULO;
      }
      reserva = 0;
   }

   // Função hash para calcular posição
   public int h(int elemento) {
      return elemento % m1;
   }

   public boolean inserir(int elemento) {

      // Definir dados
      boolean resp = false;

      // Se elemento não for indicador nulo
      if (elemento != NULO) {

         // Calcula posição
         int pos = h(elemento);

         // Se tabela na posição da chave for nula, realiza inserção
         if (tabela[pos] == NULO) {
            tabela[pos] = elemento;
            resp = true;
         } else if (reserva < m2) { // Senão, se a área de reserva ocupada for menor que o seu tamanho, insere na área de reserva
            tabela[m1 + reserva] = elemento;
            reserva++;
            resp = true;
         }
      }

      // Retorna inserção bem sucedida ou não
      return resp;
   }

   public boolean pesquisar(int elemento) {

      // Definir dados
      boolean resp = false;

      // Calcula posição
      int pos = h(elemento);

      // Se o elemento foi encontrado resp = true
      if (tabela[pos] == elemento) {
         resp = true;

      } else if (tabela[pos] != NULO) { // Senão, se o valor na posição não for um indicador nulo procura na área de reserva
         for (int i = 0; i < reserva; i++) {
            if (tabela[m1 + i] == elemento) {
               resp = true;
               i = reserva;
            }
         }
      }

      // Retorna a pesquisa
      return resp;
   }

   boolean remover(int elemento) {
      boolean resp = false;
      // ...
      return resp;
   }
}