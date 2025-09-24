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

class No {

    public int elemento;
    public No esq, dir;
    public No2 outro;

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
        this.outro = null;
    }
}

class No2 {
    public String elemento;
    public No2 esq, dir;

    public No2(String elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
    }
}

class ArvoreArvore {

    private No raiz;
    public static int comparacoes = 0;

    public ArvoreArvore() {
        raiz = null;
        inicializarPrimeiraArvore();
    }

    /**
     * Método para inserir dados iniciais na primeira árvore
     */
    private void inicializarPrimeiraArvore() {

        int[] valores = { 7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14 };
        for (int valor : valores) {

            try {

                raiz = inserirPrimeiraArvore(valor, raiz);
            } catch (Exception e) {

                System.err.println("Erro ao inserir: " + valor);
            }
        }
    }

    /**
     * Método privado para inserir elementos na árvore
     * 
     * @param x Elemento a ser inserido
     * @param i Nó em análise
     * @return Nó em análise
     * @throws Exception Tratamento de erros
     */
    private No inserirPrimeiraArvore(int x, No i) throws Exception {

        if (i == null) {

            comparacoes++;
            i = new No(x);
        } else if (x < i.elemento) {

            comparacoes++;
            i.esq = inserirPrimeiraArvore(x, i.esq);
        } else if (x > i.elemento) {

            comparacoes++;
            i.dir = inserirPrimeiraArvore(x, i.dir);
        } else {

            throw new Exception("Elemento já existe!");
        }
        return i;
    }

    /**
     * Método público para inserir
     * 
     * @param releasedYear Chave
     * @param name         Nome do Show
     * @throws Exception Tratamento de erros
     */
    public void inserirSegundaArvore(int releasedYear, String name) throws Exception {

        No no = buscarPrimeiraArvore(releasedYear, raiz);

        if (no != null) {

            comparacoes++;
            no.outro = inserirSegundaArvore(name, no.outro);
        } else {

            throw new Exception("Chave " + releasedYear + " não encontrada na primeira árvore!");
        }
    }

    /**
     * Método privado para inserir elemento
     * 
     * @param name Nome do Show
     * @param i    Nó em análise
     * @return Nó em análise
     * @throws Exception Tramento de excessões
     */
    private No2 inserirSegundaArvore(String name, No2 i) throws Exception {

        if (i == null) {

            comparacoes++;
            i = new No2(name);
        } else if (name.compareTo(i.elemento) < 0) {

            comparacoes++;
            i.esq = inserirSegundaArvore(name, i.esq);
        } else if (name.compareTo(i.elemento) > 0) {

            comparacoes++;
            i.dir = inserirSegundaArvore(name, i.dir);
        } else {

            throw new Exception("Nome já existe!");
        }
        return i;
    }

    /**
     * Método de busca em uma árvore
     * 
     * @param x Elemento a ser procurado
     * @param i Nó em análise
     * @return Status da pesquisa
     */
    private No buscarPrimeiraArvore(int x, No i) {

        while (i != null) {

            comparacoes++;
            if (x < i.elemento) {

                comparacoes++;
                i = i.esq;
            } else if (x > i.elemento) {

                comparacoes++;
                i = i.dir;
            } else {

                return i;
            }
        }
        return null;
    }


    public boolean buscar(String name) {
        return buscar(name, raiz);
    }

    private boolean buscar(String name, No i) {
        boolean resp;

        if (i == null) {
            
            comparacoes++;
            resp = false;
        } else {

            resp = buscarNaSecundaria(name, i.outro);
            if (!resp) {

                System.out.print("ESQ ");
                resp = buscar(name, i.esq);
            }

            if (!resp) {

                System.out.print("DIR ");
                resp = buscar(name, i.dir);
            }
        }

        return resp;
    }

    /**
     * Busca na árvore secundária (versão sem variável cmp)
     * 
     * @param name Nome a buscar
     * @param j    Nó atual da árvore secundária
     * @return true se encontrou
     */
    private boolean buscarNaSecundaria(String name, No2 j) {
        boolean resp;

        if (j == null) {

            comparacoes++;
            resp = false;
        } else {

            comparacoes++;
            if (name.equals(j.elemento)) {

                resp = true;
            } else if (name.compareTo(j.elemento) < 0) {

                System.out.print("esq ");
                resp = buscarNaSecundaria(name, j.esq);
            } else {

                System.out.print("dir ");
                resp = buscarNaSecundaria(name, j.dir);
            }
        }

        return resp;
    }
}

public class Q02 {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {

        // Começar medição de tempo
        long inicio = System.nanoTime();

        // Definir dados
        MyIO.setCharset("ISO-8859-1");
        ArvoreArvore arvore = new ArvoreArvore();
        String entrada1;
        String entrada2;

        // Leitura de dados
        entrada1 = MyIO.readLine();

        while (!entrada1.equals("FIM")) {

            Show show = Show.AddVetor("/tmp/disneyplus.csv", entrada1);
            arvore.inserirSegundaArvore(show.getReleaseYear() % 15, show.getTitle());
            entrada1 = MyIO.readLine();
        }

        entrada2 = MyIO.readLine();

        while (!entrada2.equals("FIM")) {

            System.out.print("raiz ");
            if(arvore.buscar(entrada2)){

                System.out.println("SIM");
            } else {

                System.out.println("NAO");
            }

            entrada2 = MyIO.readLine();
        }

        long fim = System.nanoTime();
        double tempoMs = (fim - inicio) / 1_000_000.0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("1521300_arvoreArvore.txt"))) {

            writer.printf("1521300\t%d\t%.2f\n", arvore.comparacoes, tempoMs);
        }
    }
}
