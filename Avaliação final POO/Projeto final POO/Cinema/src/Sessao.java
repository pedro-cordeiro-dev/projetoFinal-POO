import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sessao {

    private int idSessao;
    private Filme filme;
    private Funcionario funcionario;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public Sessao(int idSessao, Filme filme, Funcionario funcionario, String status) {
        this.idSessao = idSessao;
        this.filme = filme;
        this.funcionario = funcionario;
        this.status = status;
    }

    public Sessao(){}

    public int getIdSessao() {
        return idSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean cadastrarSessao() {
        try {
            System.out.println("Digite o ID da sessão:");
            int idSessao = Integer.parseInt(scanner.nextLine());

            System.out.println("Digite o ID do filme:");
            int idFilme = Integer.parseInt(scanner.nextLine());
            Filme filme = new Filme(idFilme, "", 0, null, "").consultarFilme(idFilme);
            if (filme == null) {
                System.out.println("Filme não encontrado.");
                return false;
            }

            System.out.println("Digite o CPF do funcionário responsável:");
            String cpfFuncionario = scanner.nextLine();
            Funcionario funcionario = new Funcionario(null, null, null, 0).consultarFuncionario(cpfFuncionario);
            if (funcionario == null) {
                System.out.println("Funcionário não encontrado.");
                return false;
            }

            System.out.println("Digite o status da sessão:");
            String status = scanner.nextLine();

            FileWriter fw = new FileWriter("sessoes.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(idSessao + ";" + idFilme + ";" + cpfFuncionario + ";" + status);
            writer.newLine();
            writer.close();

            System.out.println("Sessão cadastrada com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar sessão: " + e.getMessage());
            return false;
        }
    }

    public Sessao consultarSessao(int id) {
        Sessao sessaoEncontrada = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("sessoes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idSessao = Integer.parseInt(dados[0]);
                if (idSessao == id) {
                    int idFilme = Integer.parseInt(dados[1]);
                    Filme filme = new Filme(idFilme, "", 0, null, "").consultarFilme(idFilme);
                    Funcionario funcionario = new Funcionario(null, null, null, 0).consultarFuncionario(dados[2]);
                    String status = dados[3];
                    sessaoEncontrada = new Sessao(idSessao, filme, funcionario, status);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar sessão: " + e.getMessage());
        }
        return sessaoEncontrada;
    }

    public ArrayList<Sessao> listarSessoes() {
        ArrayList<Sessao> sessoes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("sessoes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idSessao = Integer.parseInt(dados[0]);
                int idFilme = Integer.parseInt(dados[1]);
                Filme filme = new Filme(idFilme, "", 0, null, "").consultarFilme(idFilme);
                Funcionario funcionario = new Funcionario(null, null, null, 0).consultarFuncionario(dados[2]);
                String status = dados[3];
                sessoes.add(new Sessao(idSessao, filme, funcionario, status));
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar sessões: " + e.getMessage());
        }
        return sessoes;
    }

    public void exibirSessao() {
        System.out.println("ID Sessão: " + idSessao);
        System.out.println("Filme: " + (filme != null ? filme.gettitulo() : "Não informado"));
        System.out.println("Funcionário: " + (funcionario != null ? funcionario.getnome() : "Não informado"));
        System.out.println("Status: " + status);
        System.out.println("----------------------------");
    }

    public void listar() {
        ArrayList<Sessao> sessoes = listarSessoes();
        if (sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão encontrada.");
        } else {
            for (Sessao sessao : sessoes) {
                sessao.exibirSessao();
            }
        }
    }
}
