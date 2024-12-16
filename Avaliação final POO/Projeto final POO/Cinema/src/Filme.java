import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filme {

    Scanner scanner = new Scanner(System.in);

    private int idFilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;

    public Filme(int idFilme, String titulo, int classificacao, Genero genero, String status){

        this.idFilme = idFilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = status;


    }

    public int getidFilme(){

        return idFilme;
    }

    public String gettitulo(){

        return titulo;

    }

    public int getclassificacao(){

        return classificacao;
    }

    public Genero getgenero(){

        return genero;

    }

    public String status(){

        return status;
    }

    public void setidFilme(int idFilme){

        this.idFilme = idFilme;
    }

    public void settitulo(String titulo){

        this.titulo = titulo;
    }

       public void exibirFilme() {
        System.out.println("ID do Filme: " + idFilme);
        System.out.println("Título: " + titulo);
        System.out.println("Classificação: " + classificacao);
        System.out.println("Gênero: " + genero.getdescricao());
        System.out.println("Status: " + status);
        System.out.println("--------------------");
    }

    public boolean cadastrarFilme() {
        try {
            System.out.println("Digite o ID do Filme:");
            int idFilme = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite o título do Filme:");
            String titulo = scanner.nextLine();
            System.out.println("Digite a classificação do Filme:");
            int classificacao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite o status do Filme:");
            String status = scanner.nextLine();

            System.out.println("Digite o ID do Gênero:");
            int idGenero = scanner.nextInt();
            scanner.nextLine();
            String descricaoGenero = "";
            Genero genero = new Genero(idGenero, descricaoGenero, "");

            FileWriter fw = new FileWriter("filme.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(idFilme + ";");
            writer.write(titulo + ";");
            writer.write(classificacao + ";");
            writer.write(genero.getdescricao() + ";");
            writer.write(status + ";");
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {
            System.out.println("Erro ao cadastrar Filme: " + e.getMessage());
            return false;
        }
    }

    public Filme consultarFilme(int idFilme) {
        Filme filmeLido = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("filme.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0].trim()) == idFilme) {
                    String tituloFilme = dados[1].trim();
                    int classificacaoFilme = Integer.parseInt(dados[2].trim());
                    String descricaoGenero = dados[3].trim();
                    Genero genero = new Genero(0, descricaoGenero, "");
                    String statusFilme = dados[4].trim();

                    filmeLido = new Filme(idFilme, tituloFilme, classificacaoFilme, genero, statusFilme);
                    filmeLido.exibirFilme();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar Filme: " + e.getMessage());
        }

        return filmeLido;
    }

    public ArrayList<Filme> listaFilmes() throws IOException {
        ArrayList<Filme> filmes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("filme.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idFilme = Integer.parseInt(dados[0].trim());
                String tituloFilme = dados[1].trim();
                int classificacaoFilme = Integer.parseInt(dados[2].trim());
                String descricaoGenero = dados[3].trim();
                Genero genero = new Genero(0, descricaoGenero, "");
                String statusFilme = dados[4].trim();

                Filme filme = new Filme(idFilme, tituloFilme, classificacaoFilme, genero, statusFilme);
                filmes.add(filme);
            }
        } catch (IOException e) {
            System.out.println("Erro ao registrar na lista de filmes: " + e.getMessage());
        }

        return filmes;
    }

    public void listarFilmes() {
        System.out.println("\nLendo dados do arquivo");

        try {
            ArrayList<Filme> filmes = listaFilmes();

            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme encontrado.");
            } else {
                for (Filme filme : filmes) {
                    filme.exibirFilme();
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }
}
