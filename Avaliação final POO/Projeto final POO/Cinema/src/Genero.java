import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Genero {

    Scanner scanner = new Scanner(System.in);

    private int id;
    private String descricao;
    private String status;

    public Genero(int id, String descricao, String status){

        this.id = id;
        this.descricao = descricao;
        this.status = status;


    }

    public int getid(){

        return id;

    }

    public String getdescricao(){

        return descricao;

    }

    public String getstatus(){

        return status;

    }

    public void setid(int id){

        this.id = id;

    }

    public void setdescricao(String descricao){

        this.descricao = descricao;

    }

    public void setstatus(String status){

        this.status = status;

    }

        public void exibirGenero() {
        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        System.out.println("--------------------");
    }

    public boolean cadastrarGenero() {
        try {
            System.out.println("Digite o ID do Gênero:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha
            System.out.println("Digite a descrição do Gênero:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o status do Gênero:");
            String status = scanner.nextLine();

            FileWriter fw = new FileWriter("genero.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(id + ";");
            writer.write(descricao + ";");
            writer.write(status + ";");
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {
            System.out.println("Erro ao cadastrar Gênero: " + e.getMessage());
            return false;
        }
    }

    public Genero consultarGenero(int id) {
        Genero generoLido = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("genero.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0].trim()) == id) {
                    String descricaoGenero = dados[1].trim();
                    String statusGenero = dados[2].trim();

                    generoLido = new Genero(id, descricaoGenero, statusGenero);
                    generoLido.exibirGenero();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar Gênero: " + e.getMessage());
        }

        return generoLido;
    }

    public ArrayList<Genero> listaGeneros() throws IOException {
        ArrayList<Genero> generos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("genero.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idGenero = Integer.parseInt(dados[0].trim());
                String descricaoGenero = dados[1].trim();
                String statusGenero = dados[2].trim();

                Genero genero = new Genero(idGenero, descricaoGenero, statusGenero);
                generos.add(genero);
            }
        } catch (IOException e) {
            System.out.println("Erro ao registrar na lista de gêneros: " + e.getMessage());
        }

        return generos;
    }

    public void listarGeneros() {
        System.out.println("\nLendo dados do arquivo");

        try {
            ArrayList<Genero> generos = listaGeneros();

            if (generos.isEmpty()) {
                System.out.println("Nenhum gênero encontrado.");
            } else {
                for (Genero genero : generos) {
                    genero.exibirGenero();
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao listar gêneros: " + e.getMessage());
        }
    }
}
