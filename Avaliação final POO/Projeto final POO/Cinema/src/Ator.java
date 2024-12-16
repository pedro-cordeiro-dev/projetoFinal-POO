import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ator extends Pessoa{

    Scanner scanner = new Scanner(System.in);

    private int registro;

    public Ator(String cpf, String nome, String email, int registro){

        super(cpf, nome, email);
        this.registro = registro;

    }

    public int getregistro(){

        return registro;

    }

    public void setregistro(int registro){

        this.registro = registro;

    }

    public void exibirAtor(){

        System.out.println("nome: " + this.getnome());
        System.out.println("cpf: " + this.getcpf());
        System.out.println("email: " + this.getemail());
        System.out.println("matricula: " + getregistro());
        System.out.println("--------------------");

    }


    public boolean cadastrarAtor(){


        try {

            System.out.println("Digite o seu nome:");
                String nome = scanner.nextLine();
            System.out.println("Digite seu Cpf: ");
                String cpf = scanner.nextLine();
            System.out.println("Digite seu email: ");
                String email = scanner.nextLine();
            System.out.println("digite sua matricula: ");
                int matricula = scanner.nextInt();

                FileWriter fw = new FileWriter("Ator.txt", true);
                BufferedWriter writer = new BufferedWriter(fw);

                    writer.write(nome + ";");
                       /* writer.newLine(); */
                    writer.write(cpf + ";");
                       /* writer.newLine(); */
                       writer.write(email + ";");
                       /* writer.newLine(); */
                       writer.write(matricula + ";");
                        writer.newLine();

                    writer.close();


            return true;    

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Ator");

            return false;

            }        

    }

    public Ator consultarAtor(String cpfAtor) {

        System.out.println("Digite o CPF do ator: ");
            String cpfDigitado = scanner.nextLine().trim();

        Ator AtorLido = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\Projeto final POO\\Cinema\\ator.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados[1].trim().equals(cpfDigitado)) {
                    String nomeAtor = dados[0].trim();
                    String cpf = dados[1].trim();
                    String emailAtor = dados[2].trim();
                    int registroAtor = Integer.parseInt(dados[3].trim());

                    AtorLido = new Ator(nomeAtor, cpf, emailAtor, registroAtor);
                    AtorLido.exibirAtor();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao encontrar o Ator: " + e.getMessage());
        }

        return AtorLido;

    }

    public ArrayList<Ator> listaAtores() throws IOException {
    ArrayList<Ator> atores = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\Projeto final POO\\Cinema\\ator.txt"))) {
        String linha;

        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");

            String nomeAtor = dados[0].trim();
            String cpfAtor = dados[1].trim();
            String emailAtor = dados[2].trim();
            int registroAtor = Integer.parseInt(dados[3].trim());

            Ator ator = new Ator(nomeAtor, cpfAtor, emailAtor, registroAtor);
            atores.add(ator);
        }
    } catch (IOException e) {
        System.out.println("Erro ao registrar os atores na ArrayList: " + e.getMessage());
    }
    return atores;
}

public void listarAtores() {
    try {
        ArrayList<Ator> atores = listaAtores();

        if (atores.isEmpty()) {
            System.out.println("Nenhum ator encontrado.");
        } else {
            for (Ator ator : atores) {
                ator.exibirAtor();
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao listar os atores: " + e.getMessage());
    }
}

}
