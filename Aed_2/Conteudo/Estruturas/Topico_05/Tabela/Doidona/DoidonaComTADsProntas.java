class Celula {

   // Definir dados
   public int elemento;
   public Celula prox;

   public Celula(){

      this.elemento = -1;
      this.prox = null;
   }

   public Celula(int elemento){

      this.elemento = elemento;
      this.prox = null;
   }
}

class ListaSimples {

   // Definir dados
   private Celula primeiro, ultimo;

   public ListaSimples(){

      this.primeiro = this.ultimo = null;
   }

   public void inserirFim(int elemento){

      InserirFim(elemento, ultimo);
   }  

   private void InserirFim(int elemento, Celula ultimo){

      ultimo.prox = new Celula(elemento);
      ultimo = ultimo.prox;
   }

   public boolean pesquisar(int elemento){

      boolean resp = false;

      for(Celula i = primeiro; i.prox != null; i = i.prox){

         if(i.elemento == elemento){

            resp = true;
            i = null;
         }
      }

      return resp;
   }

   public void mostrar(){

      System.out.print("[ ");
      for(Celula i = primeiro.prox; i.prox != null; i = i.prox){

         System.out.print(i.elemento);
      }
      System.out.print(" ]");
   }
}

class No {

   // Definir dados
   public int elemento;
   public No esq, dir;

   public No(){

      this.elemento = -1;
      this.esq = this.dir = null;
   }

   public No(int elemento){

      this.elemento = elemento;
      this.esq = this.dir = null;
   }
}

class ArvoreBinaria {

   // Definir dados
   private No raiz;

   public ArvoreBinaria(){

      this.raiz = null;
   }

   public boolean pesquisar(int elemento) throws Exception {

      return pesquisar(elemento, raiz);
   }

   private boolean pesquisar(int elemento, No i) throws Exception {

      boolean resp;

      if(i == null){

         resp = false;
      } else if (i.elemento == elemento) {
          
         resp = true;
      } else if(elemento < i.elemento){

         resp = pesquisar(elemento, i.esq);
      } else {

         resp = pesquisar(elemento, i.dir);
      }

      return resp;
   }

   public void inserir(int elemento) throws Exception {
      
      raiz = inserir(elemento, raiz);
   }

   private No inserir(int elemento, No i) throws Exception {

      if(i == null){

         i = new No(elemento);
      } else if(elemento < i.elemento){

         i.esq = inserir(elemento, i.esq);
      } else if(elemento > i.elemento){

         i.dir = inserir(elemento, i.dir);
      } else {

         throw new Exception("Erro: Elemento já inserido");
      }

      return i;
   }

   public void mostrar(){
       
      mostrar(raiz);
   }

   public void mostrar(No i){

      if(i != null){

         mostrar(i.esq);
         System.out.print(i.elemento + " ");
         mostrar(i.dir);
      }
   }
}

class NoAVL {

   public int elemento;
   public NoAVL esq, dir;
   public int nivel;

   public NoAVL(){

      this.elemento = this.nivel = -1;
      this.esq = this.dir = null;
   }

   public NoAVL(int elemento){

      this.elemento = elemento;
      this.nivel = 1;
      this.esq = this.dir = null;
   }

   public NoAVL (int elemento, NoAVL esq, NoAVL dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}

   public void setNivel(){

      this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
   }

   public static int getNivel(NoAVL no){

      return (no == null) ? 0 : no.nivel;
   }
}

class AVL {

   // Definir dados
   private NoAVL raiz;

   public AVL(){
      raiz = null;
   }

   public boolean pesquisar(int elemento){

      return pesquisar(elemento, raiz);
   }

   public boolean pesquisar(int elemento, NoAVL i){

      boolean resp;

      if(i == null){

         resp = false;
      } else if(i.elemento == elemento){

         resp = true;
      } else if(elemento < i.elemento){

         resp = pesquisar(elemento, i.esq);
      } else {

         resp = pesquisar(elemento, i.dir);
      }

      return resp;
   }

   public void mostrar(){

      mostrar(raiz);
   }

   private void mostrar(NoAVL i){

      if(i != null){

         mostrar(i.esq);
         System.out.print(i.elemento + " ");
         mostrar(i.dir);
      }
   }

   public void inserir(int elemento) throws Exception {

      raiz = inserir(elemento, raiz);
   }

   private NoAVL inserir(int elemento, NoAVL i) throws Exception {

      if(i == null){

         i = new NoAVL(elemento);
      } else if(elemento < i.elemento){

         i.esq = inserir(elemento, i.esq);
      } else if(elemento > i.elemento){

         i.dir = inserir(elemento, i.dir);
      } else {

         throw new Exception("Erro: Elemento já inserido");
      }

      return balancear(i);
   }

   private NoAVL balancear(NoAVL no) throws Exception {

      if(no != null){

         int fator = NoAVL.getNivel(no.dir) - NoAVL.getNivel(no.esq);

         if(Math.abs(fator) <= 1){

            no.setNivel();
         } else if(fator == 2){

            int fatorFilhoDir = NoAVL.getNivel(no.dir.dir) - NoAVL.getNivel(no.dir.esq);

            if(fatorFilhoDir == -1){

               no.dir = rotacionarDir(no.dir);
            }

            no = rotacionarEsq(no);
         } else if(fator == -2){

            int fatorFilhoEsq = NoAVL.getNivel(no.esq.dir) - NoAVL.getNivel(no.esq.esq);
         
            if(fatorFilhoEsq == 1){

               no.esq = rotacionarEsq(no.esq);
            }

            no = rotacionarDir(no);
         } else {

            throw new Exception("Erro: Fator inválido");
         }
      }
   }

   private NoAVL rotacionarDir(NoAVL no) {
		System.out.println("Rotacionar DIR(" + no.elemento + ")");
		NoAVL noEsq = no.esq;
		NoAVL noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setNivel(); // Atualizar o nivel do no
		noEsq.setNivel(); // Atualizar o nivel do noEsq

		return noEsq;
	}

	private NoAVL rotacionarEsq(NoAVL no) {
		System.out.println("Rotacionar ESQ(" + no.elemento + ")");
		NoAVL noDir = no.dir;
		NoAVL noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;

		no.setNivel(); // Atualizar o nivel do no
		noDir.setNivel(); // Atualizar o nivel do noDir
		return noDir;
	}
}

class DoidonaComTADsProntas {
   final int TAMT1 = 100;
   final int TAMT3 = 100;
   final int NULO = -0x7FFFFF;

   int[] t1;
   int[] t3;

   ArvoreBinaria arvoreBinaria;
   ListaSimples lista;
   AVL arvoreAVL;

   public Doidona(){
      
      t1 = new int [TAMT1];
      t3 = new int [TAMT3];

      for(int i = 0; i < TAMT1; i++){
         t1[i] = NULO;
      }
      for(int i = 0; i < TAMT3; i++){
         t3[i] = NULO;
      }

      arvoreBinaria = new ArvoreBinaria();
      arvoreAVL = new AVL();
      lista = new ListaSimples();
   }

   public int hashT1(int elemento){
   }

   public int hashT2(int elemento){
      return elemento % 3;
   }

   public int hashT3(int elemento){
   }

   public int rehashT3(int elemento){
   }

   public void inserir(int elemento) throws Exception{
      int i = hashT1(elemento);
      if(elemento == NULO) {
         //gerar msg de erro para o usuario...
      } else if(t1[i] == NULO){
         t1[i] = elemento;
      }else if(hashT2(elemento) == 0){
         i = hashT3(elemento);
         if(t3[i] == NULO){
            t3[i] = elemento;
         } else {
            i = rehashT3(elemento);
            if(t3[i] == NULO){
               t3[i] = elemento;
            } else {
               arvoreBinaria.inserir(elemento);
            }
         }
      }else if (hashT2(elemento) == 1){
         lista.inserirFim(elemento);
      }else if (hashT2(elemento) == 2){
         arvoreAVL.inserir(elemento);
      } else {
         System.out.println("ERRO!!!!");
      }
   }
   void remover (int elemento){
   }

   boolean pesquisar (int elemento) throws Exception{
      boolean resp = false;
      int pos = hashT1(elemento);
      if(elemento == NULO){
         resp = false;
      } else if(t1[pos] == elemento){
         resp = true;
      }else {
         pos = hashT2(elemento);
         if (pos == 0){
            pos = hashT3(elemento);
            if(t3[pos] == elemento){
               resp = true;
            }else{
               pos = rehashT3(elemento);
               if(t3[pos] == elemento){
                  resp = true;
               }else{
                  resp = arvoreBinaria.pesquisar(elemento);
               }
            }
         }else if (pos == 1){
            resp = lista.pesquisar(elemento);
         } else {
            resp = arvoreAVL.pesquisar(elemento);
         }
      }
      return resp;
   }

   void mostrar(){
      //t1, t3, arvoreBinaria, lista, arvoreAVL
      for(int i = 0; i < TAMT1; i++){
         if(t1[i] != NULO){
            System.out.println(t1[i]);
         }
      }
      for(int i = 0; i < TAMT3; i++){
         if(t3[i] != NULO){
            System.out.println(t3[i]);
         }
      }
      arvoreBinaria.mostrar();
      lista.mostrar();
      arvoreAVL.mostrar();
   }
}
