import java.io.*;
import java.util.*;


class Show {

    // Definir dados
    private String showId;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private String dateAdded;
    private int releaseYear;
    private String rating;
    private String duration;
    private String[] listedIn;

    /*------------------Construtores------------------ */

    /**
     * Construtor padrão da classe Show.
     * Inicializa todos os atributos com seus valores padrão (null para Strings e 0
     * para int, ArrayLists vazios).
     */
    Show() {
        this.showId = null;
        this.type = null;
        this.title = null;
        this.director = null;
        this.cast = null;
        this.country = null;
        this.dateAdded = null;
        this.releaseYear = 0;
        this.rating = null;
        this.duration = null;
        this.listedIn = null;
    }

    /**
     * Construtor da classe Show que permite a atribuição de valores a todos os
     * atributos.
     *
     * @param showId      O ID único do show.
     * @param type        O tipo do show.
     * @param title       O título do show.
     * @param director    O diretor do show.
     * @param cast        A lista de atores do show.
     * @param country     O país de produção do show.
     * @param dateAdded   A data em que o show foi adicionado à plataforma.
     * @param releaseYear O ano de lançamento do show.
     * @param rating      A classificação indicativa do show.
     * @param duration    A duração do show.
     * @param listedIn    A lista de categorias em que o show está listado.
     */
    Show(String showId, String type, String title, String director, String[] cast, String country,
            String dateAdded, int releaseYear, String rating, String duration, String[] listedIn) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = new String[cast.length];
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = new String[listedIn.length];
    }

    /*------------------Fim Construtores------------------ */

    /*------------------Getters------------------ */

    /**
     * Retorna o ID do show.
     * 
     * @return showId
     */
    public String getShowId() {

        return showId;
    }

    /**
     * Retorna o tipo do show.
     * 
     * @return type
     */
    public String getType() {

        return type;
    }

    /**
     * Retorna o título do show.
     * 
     * @return title
     */
    public String getTitle() {

        return title;
    }

    /**
     * Retorna o nome do diretor do show.
     * 
     * @return director
     */
    public String getDirector() {

        return director;
    }

    /**
     * Retorna a lista de atores do show.
     * 
     * @return cast
     */
    public String[] getCast() {

        return cast;
    }

    /**
     * Retorna o país de origem do show.
     * 
     * @return country
     */
    public String getCountry() {

        return country;
    }

    /**
     * Retorna a data em que o show foi adicionado.
     * 
     * @return dateAdded
     */
    public String getDateAdded() {

        return dateAdded;
    }

    /**
     * Retorna o ano de lançamento do show.
     * 
     * @return releaseYear
     */
    public int getReleaseYear() {

        return releaseYear;
    }

    /**
     * Retorna a classificação indicativa do show.
     * 
     * @return rating
     */
    public String getRating() {

        return rating;
    }

    /**
     * Retorna a duração do show.
     * 
     * @return duration
     */
    public String getDuration() {

        return duration;
    }

    /**
     * Retorna as categorias do show.
     * 
     * @return listedIn
     */
    public String[] getListedIn() {

        return listedIn;
    }

    /*------------------Fim Getters------------------ */

    /*------------------Setters------------------ */

    /**
     * Define o ID do show.
     * 
     * @param showId ID do show
     */
    public void setShowId(String showId) {

        this.showId = (showId.equals("")) ? "NaN" : showId;
    }

    /**
     * Define o tipo do show.
     * 
     * @param type Tipo do show
     */
    public void setType(String type) {

        this.type = (type.equals("")) ? "NaN" : type;
    }

    /**
     * Define o título do show.
     * 
     * @param title Título do show
     */
    public void setTitle(String title) {

        this.title = (title.equals("")) ? "NaN" : title;
    }

    /**
     * Define o nome do diretor do show.
     * 
     * @param director Nome do diretor
     */
    public void setDirector(String director) {

        this.director = (director.equals("")) ? "NaN" : director;
    }

    /**
     * Define a lista de atores do show.
     * 
     * @param cast Lista de atores
     */
    public void setCast(String[] cast) {

        if (cast.length == 1 && cast[0].equals("")) {

            this.cast = new String[] { "NaN" };
        } else {

            this.cast = cast;
        }
    }

    /**
     * Define o país de origem do show.
     * 
     * @param country País de origem
     */
    public void setCountry(String country) {

        this.country = (country.equals("")) ? "NaN" : country;
    }

    /**
     * Define a data em que o show foi adicionado.
     * 
     * @param dateAdded Data adicionada
     */
    public void setDateAdded(String dateAdded) {

        this.dateAdded = (dateAdded.equals("")) ? "NaN" : dateAdded;
    }

    /**
     * Define o ano de lançamento do show.
     * 
     * @param releaseYear Ano de lançamento
     */
    public void setReleaseYear(int releaseYear) {

        this.releaseYear = releaseYear;
    }

    /**
     * Define a classificação indicativa do show.
     * 
     * @param rating Classificação indicativa
     */
    public void setRating(String rating) {

        this.rating = (rating.equals("")) ? "NaN" : rating;
    }

    /**
     * Define a duração do show.
     * 
     * @param duration Duração
     */
    public void setDuration(String duration) {

        this.duration = (duration.equals("")) ? "NaN" : duration;
    }

    /**
     * Define as categorias em que o show está listado.
     * 
     * @param listedIn Lista de categorias
     */
    public void setListedIn(String[] listedIn) {

        if (listedIn.length == 1 && listedIn[0].equals("")) {

            this.listedIn = new String[] { "NaN" };
        } else {

            this.listedIn = listedIn;
        }
    }

    /*------------------Fim Setters------------------ */

    /**
     * Retorna uma cópia (clone) do objeto Show atual.
     * 
     * @return novo objeto Show com os mesmos dados
     */
    public Show Clone() {

        return new Show(
                this.showId,
                this.type,
                this.title,
                this.director,
                this.cast,
                this.country,
                this.dateAdded,
                this.releaseYear,
                this.rating,
                this.duration,
                this.listedIn);
    }

    /**
     * Transformar String em inteiro
     * 
     * @param str String a ser transformada
     */
    public int StrToInt(String str) {

        // Definir dados
        int len = str.length();
        int data = 0;

        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);
            data = (10 * data) + (c - '0');
        }

        return data;
    }

    /**
     * Leitura de dados da entrada e atribuições
     * 
     * @param in Entrada de dados
     */
    public void Ler(String in) throws Exception {

        // Definir dados
        String simplify = "";
        boolean flag = true;
        int len = in.length();

        // Varrer String para verificar se está entre aspas
        for (int i = 0; i < len; i++) {

            char c = in.charAt(i);
            if (c == '"')
                flag = !flag;
            else if (c == ',' && flag)
                simplify += '|';
            else
                simplify += c;
        }

        // Array de Strings simplificado
        String[] ShowStr = simplify.split("\\|");

        // Settando valores
        setShowId(ShowStr[0]);
        setType(ShowStr[1]);
        setTitle(ShowStr[2]);
        setDirector(ShowStr[3]);

        // Ajuste na formatação
        String[] CastAux = ShowStr[4].split(",\\s*");
        int castl = CastAux.length;
        quickSort(0, castl - 1, CastAux);
        setCast(CastAux);

        setCountry(ShowStr[5]);
        setDateAdded(ShowStr[6]);

        // Ajuste de variaveis
        setReleaseYear(StrToInt(ShowStr[7]));
        setRating(ShowStr[8]);
        setDuration(ShowStr[9]);

        // Ajuste na formatação
        String[] ListedInAux = ShowStr[10].split(",\\s*");
        int ListedLen = ListedInAux.length;
        quickSort(0, ListedLen - 1, ListedInAux);
        setListedIn(ListedInAux);

    }

    /**
     * Função para criar Show pela String de entrada
     * 
     * @param in String de entrada
     * @return Show criado
     */
    public static Show Create(String in) throws Exception {

        // Definir dados
        Show created = new Show();

        // Leitura
        created.Ler(in);
        return created;
    }

    /**
     * Funcção para transformar id como String
     * 
     * @param data
     * @return
     */
    public static String IdString(String data) {

        // Definir dados
        String result = "";
        int i = 0;

        while (data.charAt(i) != ',') {

            result += data.charAt(i);
            i++;
        }

        return result;
    }

    /**
     * Leitura do arquivo CSV
     * 
     * @param caminho Caminho do CSV
     * @param id      String de entrada
     */
    public static Show AddVetor(String caminho, String id) throws Exception {

        // Definir dados
        Show show = null;
        File file = new File(caminho);

        if (!file.exists()) {

            throw new FileNotFoundException("Arquivo não encontrado: " + caminho);
        }

        try (Scanner sc = new Scanner(file)) {

            String data;

            while (sc.hasNext()) {

                data = sc.nextLine();
                if (IdString(data).equals(id)) {

                    show = Create(data);
                }

            }
        }

        return show;
    }

     /**
     * Realiza a troca de posição de alguns elementos
     * 
     * @param i     Índice do primeiro elemento
     * @param j     Índice do segundo elemento
     * @param array Array de Strings a ser ordenado
     */
    public static void swap(int i, int j, String[] array){

        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Método QuickSort de ordenação para Strings
     * 
     * @param esq   Índice inicial
     * @param dir   Índice final
     * @param array Array de Strings a ser ordenado
     */
    public static void quickSort(int esq, int dir, String[] array){

        // Define índices e pivô no meio
        int i = esq, j = dir;
        String pivo = array[(esq + dir) / 2];

        // Varredura
        while(i <= j){

            // Define posição das Strings menores e maiores que o pivô
            while (array[i].compareTo(pivo) < 0)
                i++;
            while (array[j].compareTo(pivo) > 0)
                j--;

            // Troca elementos para que menores fiquem antes do pivô
            // Troca elementos para que maiores fiquem depois do pivô
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }

        // Chamada recursiva para parte da esquerda e da direita
        if (esq < j)
            quickSort(esq, j, array);
        if (i < dir)
            quickSort(i, dir, array);
    }

    public void Imprimir() {

        System.out.print("=> ");
        System.out.print(showId + " ## ");
        System.out.print(title + " ## ");
        System.out.print(type + " ## ");
        System.out.print(director + " ## ");

        System.out.print("[");

        // Elenco
        for (int i = 0; i < cast.length; i++) {

            if (i == cast.length - 1)
                System.out.print(cast[i]);
            else
                System.out.print(cast[i] + ", ");
        }

        System.out.print("]");

        System.out.print(" ## ");

        System.out.print(country + " ## ");
        System.out.print(dateAdded + " ## ");
        System.out.print(releaseYear + " ## ");
        System.out.print(rating + " ## ");
        System.out.print(duration + " ## ");

        System.out.print("[");

        // Categorias
        for (int i = 0; i < listedIn.length; i++) {

            if (i == listedIn.length - 1)
                System.out.print(listedIn[i]);
            else
                System.out.print(listedIn[i] + ", ");
        }

        System.out.print("] ##");
        System.out.println("");
    }

}

class No {

    // Definir dados
    public Show show;
    public No esq, dir;

    // Construtor padrão
    public No(){

        this.show = null;
        this.esq = null;
        this.dir = null;
    }

    // Construtor alternativo
    public No(Show show){

        this.show = show;
        this.dir = null;
        this.esq = null;
    }
}

class Arvore {

    // Definir dados
    private No raiz;
    private static int comparacoes = 0;

    // Construtor padrão
    public Arvore(){

        this.raiz = null;
    }

    public Arvore(No raiz){

        this.raiz = raiz;
    }

    public static int getComparacoes(){

        return comparacoes;
    }

    public void CaminharCentral(){

        CaminharCentral(raiz);
    }

    private void CaminharCentral(No i){

        if(i != null){

            CaminharCentral(i.esq);
            System.out.println(i.show.getTitle() + " ");
            CaminharCentral(i.dir);
        }
    }

    public void CaminharPre(){

        CaminharPre(raiz);
    }

    private void CaminharPre(No i){

        if(i != null){

            System.out.println(i.show.getTitle() + " ");
            CaminharPre(i.esq);
            CaminharPre(i.dir);
        }
    }

    public void CaminharPos(){

        CaminharPos(raiz);
    }

    private void CaminharPos(No i){

        if(i != null){

            CaminharPos(i.esq);
            CaminharPos(i.dir);
            System.out.println(i.show.getTitle());
        }
    }

    public void Inserir(Show show) throws Exception{

        raiz = Inserir(show, raiz);
    }

    private No Inserir(Show show, No i) throws Exception {

        if(i == null){

            comparacoes++;
            i = new No(show);
        } else if (show.getTitle().compareToIgnoreCase(i.show.getTitle()) < 0) {
            
            comparacoes++;
            i.esq = Inserir(show, i.esq);
        } else if(show.getTitle().compareToIgnoreCase(i.show.getTitle()) > 0) {

            comparacoes++;
            i.dir = Inserir(show, i.dir);
        } else {

            throw new Exception("Erro: Show já Inserido");
        }

        return i;
    }

    public boolean Search(String nome){

        return Search(nome, raiz);
    }

    private boolean Search(String name, No i){

        // Definir dados
        boolean resp;

        if(i == null){

            comparacoes++;
            resp = false;
        } else if(i.show.getTitle().equals(name)){

            comparacoes++;
            resp = true;
        } else if(i.show.getTitle().compareTo(name) > 0){

            comparacoes++;
            System.out.print(" esq");
            resp = Search(name, i.esq);
        } else {

            comparacoes++;
            System.out.print(" dir");
            resp = Search(name, i.dir);
        }

        return resp;
    }

    public void Remover(String nome) throws Exception {

        raiz = Remover(nome, raiz);
    }

    private No Remover(String nome, No i) throws Exception {

        if(i == null){

            throw new Exception("Erro: Não há dados para serem removidos");
        } else if (i.show.getTitle().compareTo(nome) > 0) {
            
            i.esq = Remover(nome, i.esq);
        } else if(i.show.getTitle().compareTo(nome) < 0) {

            i.dir = Remover(nome, i.dir);
        } else if(i.dir == null){

            i = i.esq;
        } else if(i.esq == null){

            i = i.dir;
        } else {

            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    private No maiorEsq(No i, No j){

        if(j.dir == null){

            i.show = j.show;
            j = j.esq;
        } else {

            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }
}

public class Q01 {

    public static void main(String[] args) throws Exception {
        
        // Começar medição de tempo
        long inicio = System.nanoTime();

        // Definir dados
        MyIO.setCharset("ISO-8859-1");
        Arvore arvore = new Arvore();
        String entrada1;
        String entrada2;
        

        // Leitura de dados
        entrada1 = MyIO.readLine();

        while(!entrada1.equals("FIM")){

            arvore.Inserir(Show.AddVetor("/tmp/disneyplus.csv", entrada1));
            entrada1 = MyIO.readLine();
        }

        entrada2 = MyIO.readLine();

        while(!entrada2.equals("FIM")){


            System.out.print("=>raiz ");
            if(arvore.Search(entrada2)){
                System.out.print(" SIM");
            } else {

                System.out.print(" NAO");
            }

            System.out.println("");
            entrada2 = MyIO.readLine();
        }
        
        long fim = System.nanoTime();
        double tempoMs = (fim - inicio) / 1_000_000.0;

        try(PrintWriter writer = new PrintWriter(new FileWriter("1521300_arvoreBinaria.txt"))){

            writer.printf("1521300\t%d\t%.2f\n", arvore.getComparacoes(), tempoMs);
        }
    }

}