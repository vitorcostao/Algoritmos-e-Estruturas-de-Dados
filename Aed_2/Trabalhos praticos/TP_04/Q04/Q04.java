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
    public static void swap(int i, int j, String[] array) {

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
    public static void quickSort(int esq, int dir, String[] array) {

        // Define índices e pivô no meio
        int i = esq, j = dir;
        String pivo = array[(esq + dir) / 2];

        // Varredura
        while (i <= j) {

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

class NoAN{
  public boolean cor;
  public Show elemento;
  public NoAN esq, dir;

  public NoAN(Show elemento){
    this(elemento, false, null, null);
  }
  public NoAN(Show elemento, boolean cor){
    this(elemento, cor, null, null);
  }

  public NoAN(Show elemento,boolean cor, NoAN esq, NoAN dir){
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

class Alvinegra{
    private NoAN raiz;
    public int comp;

    public Alvinegra(){
        raiz = null;
        comp = 0;
    }

    public void inserir(Show elemento)throws Exception{
        if (raiz == null){
            raiz = new NoAN(elemento);
        } else if (raiz.esq == null && raiz.dir == null){
            if (elemento.getTitle().compareTo(raiz.elemento.getTitle()) < 0){
                raiz.esq = new NoAN(elemento);
            } else{
                raiz.dir = new NoAN(elemento);
            }
        } else if (raiz.esq == null){
            if (elemento.getTitle().compareTo(raiz.elemento.getTitle()) < 0){
                raiz.esq = new NoAN(elemento);
            } else if (elemento.getTitle().compareTo(raiz.dir.elemento.getTitle()) < 0){
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
            } else{
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else if (raiz.dir == null){
            if (elemento.getTitle().compareTo(raiz.elemento.getTitle()) > 0){
                raiz.dir = new NoAN(elemento);
            } else if (elemento.getTitle().compareTo(raiz.esq.elemento.getTitle()) > 0){
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
            } else{
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else{
            inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }
    private void inserir(Show elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception{
        if (i == null){
            if (elemento.getTitle().compareTo(pai.elemento.getTitle()) < 0){
                i = pai.esq = new NoAN(elemento, true);
            } else{
                i = pai.dir = new NoAN(elemento, true);
            }
            if (pai.cor == true){
                balancear(bisavo, avo, pai, i);
            }
        } else{
            if (i.esq != null && i.dir != null && i.esq.cor && i.dir.cor){
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz){
                    i.cor = false;
                } else if (pai.cor == true){
                    balancear(bisavo, avo, pai, i);
                }
            }

            if (elemento.getTitle().compareTo(i.elemento.getTitle()) < 0){
                inserir(elemento, avo, pai, i, i.esq);
            } else if (elemento.getTitle().compareTo(i.elemento.getTitle()) > 0){
                inserir(elemento, avo, pai, i, i.dir);
            } else{
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }
    }

    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i){
        if (pai.cor == true){
            if (pai.elemento.getTitle().compareTo(avo.elemento.getTitle()) > 0){
                if (i.elemento.getTitle().compareTo(pai.elemento.getTitle()) > 0){
                    avo = rotacaoEsq(avo);
                } else{
                    avo = rotacaoDirEsq(avo);
                }
            } else{
                if (i.elemento.getTitle().compareTo(pai.elemento.getTitle()) < 0){
                    avo = rotacaoDir(avo);
                } else{
                    avo = rotacaoEsqDir(avo);
                }
            }
            if (bisavo == null){
                raiz = avo;
            } else if (avo.elemento.getTitle().compareTo(bisavo.elemento.getTitle()) < 0){
                bisavo.esq = avo;
            } else{
                bisavo.dir = avo;
            }

            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    private NoAN rotacaoDir(NoAN no){
        NoAN noEsq = no.esq;
        no.esq = noEsq.dir;
        noEsq.dir = no;
        return noEsq;
    }

    private NoAN rotacaoEsq(NoAN no){
        NoAN noDir = no.dir;
        no.dir = noDir.esq;
        noDir.esq = no;
        return noDir;
    }

    private NoAN rotacaoDirEsq(NoAN no){
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private NoAN rotacaoEsqDir(NoAN no){
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    public boolean pesquisar(String titulo){
        System.out.print("=>raiz ");
        return pesquisar(titulo, raiz);
    }

    private boolean pesquisar(String titulo, NoAN i){
        boolean resp;
        if (i == null){
            resp = false;
        } else if (titulo.equals(i.elemento.getTitle())){
            comp++;
            resp = true;
        } else if (titulo.compareTo(i.elemento.getTitle()) < 0){
            comp++;
            System.out.print("esq ");
            resp = pesquisar(titulo, i.esq);
        } else{
            comp++;
            System.out.print("dir ");
            resp = pesquisar(titulo, i.dir);
        }
        return resp;
    }
}

public class Q04 {

    public static void main(String[] args) throws Exception {

        // Começar medição de tempo
        long inicio = System.nanoTime();

        // Definir dados
        MyIO.setCharset("ISO-8859-1");
        Alvinegra arvore = new Alvinegra();
        String entrada1;
        String entrada2;

        // Leitura de dados
        entrada1 = MyIO.readLine();

        while (!entrada1.equals("FIM")) {

            Show show = Show.AddVetor("/tmp/disneyplus.csv", entrada1);
            arvore.inserir(show);
            entrada1 = MyIO.readLine();
        }

        entrada2 = MyIO.readLine();

        while (!entrada2.equals("FIM")) {


            if (arvore.pesquisar(entrada2)) {

                System.out.println(" SIM");
            } else {

                System.out.println(" NAO");
            }

            entrada2 = MyIO.readLine();
        }

        long fim = System.nanoTime();
        double tempoMs = (fim - inicio) / 1_000_000.0;
    }
}
