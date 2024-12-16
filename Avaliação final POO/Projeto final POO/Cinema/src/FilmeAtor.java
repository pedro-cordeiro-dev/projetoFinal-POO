import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmeAtor {

    Scanner scanner = new Scanner(System.in);

    private int idFilmeAtor;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;

    public FilmeAtor(int idFilmeAtor, Ator ator, Filme filme, String personagem, boolean principal){

        this.idFilmeAtor = idFilmeAtor;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;

    }

    public int getidFilmeAtor(){

        return idFilmeAtor;

    }

    public Ator getator(){

        return ator;

    }

    public Filme getfilme(){

        return filme;

    }

    public String getpersonagem(){

        return personagem;

    }

    public boolean getprincipal(){

        return principal;

    }

    public void setidFilmeAtor(int idFilmeAtor){

        this.idFilmeAtor = idFilmeAtor;

    }

    public void setator(Ator ator){

        this.ator = ator;
    }

    public void setfilme(Filme filme){

        this.filme = filme;

    }

    public void setpersonagem(String personagem){

        this.personagem = personagem;
    }

    public void setprincipal(boolean principal){

        this.principal = principal;

    }

    public void exibirFilmeAtor() {
        System.out.println("ID FilmeAtor: " + idFilmeAtor);
        System.out.println("Ator: " + ator.getnome());
        System.out.println("Filme: " + filme.gettitulo());
        System.out.println("Personagem: " + personagem);
        System.out.println("Principal: " + (principal ? "Sim" : "Não"));
        System.out.println("--------------------");
    }

    public boolean cadastrarFilmeAtor() {
        try {
            System.out.println("Digite o ID do FilmeAtor:");
            int idFilmeAtor = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o CPF do ator:");
            String cpfAtor = scanner.nextLine();
            Ator ator = consultarAtor(cpfAtor);

            if (ator == null) {
                System.out.println("Ator não encontrado!");
                return false;
            }

            System.out.println("Digite o ID do filme:");
            int idFilme = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite o título do filme:");
            String tituloFilme = scanner.nextLine();
            Filme filme = new Filme(idFilme, tituloFilme, 0, null, "");

            System.out.println("Digite o nome do personagem:");
            String personagem = scanner.nextLine();
            System.out.println("O personagem é principal? (true/false):");
            boolean principal = scanner.nextBoolean();

            FilmeAtor filmeAtor = new FilmeAtor(idFilmeAtor, ator, filme, personagem, principal);

            FileWriter fw = new FileWriter("filmeAtor.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(idFilmeAtor + ";");
            writer.write(ator.getnome() + ";");
            writer.write(filme.gettitulo() + ";");
            writer.write(personagem + ";");
            writer.write(principal + ";");
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {
            System.out.println("Erro ao cadastrar FilmeAtor: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<FilmeAtor> listaFilmesAtor() throws IOException {
        ArrayList<FilmeAtor> filmesAtor = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("filmeAtor.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idFilmeAtor = Integer.parseInt(dados[0].trim());
                String nomeAtor = dados[1].trim();
                String tituloFilme = dados[2].trim();
                String personagem = dados[3].trim();
                boolean principal = Boolean.parseBoolean(dados[4].trim());

                FilmeAtor filmeAtor = new FilmeAtor(idFilmeAtor, new Ator(nomeAtor, "", "", 0), new Filme(0, tituloFilme, 0, null, ""), personagem, principal);
                filmesAtor.add(filmeAtor);
            }
        } catch (IOException e) {
            System.out.println("Erro ao registrar os FilmesAtor na ArrayList: " + e.getMessage());
        }
        return filmesAtor;
    }

    public void listarFilmesAtor() {
        try {
            ArrayList<FilmeAtor> filmesAtor = listaFilmesAtor();

            if (filmesAtor.isEmpty()) {
                System.out.println("Nenhum filme encontrado.");
            } else {
                for (FilmeAtor filmeAtor : filmesAtor) {
                    System.out.println(filmeAtor.getfilme().gettitulo());
                    System.out.println("Ator: " + filmeAtor.getator().getnome());
                    System.out.println("Personagem: " + filmeAtor.getpersonagem());
                    System.out.println("Principal: " + filmeAtor.getprincipal());
                    System.out.println("--------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar os FilmesAtor: " + e.getMessage());
        }
    }
}

