import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ingresso {

    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;

    Scanner scanner = new Scanner(System.in);

    public Ingresso(int idIngresso, double valorPago, SalaAssento salaAssento, Sessao sessao) {
        this.idIngresso = idIngresso;
        this.valorPago = valorPago;
        this.salaAssento = salaAssento;
        this.sessao = sessao;
    }

    public int getIdIngresso() {
        return idIngresso;
    }

    public double getValorPago() {
        return valorPago;
    }

    public SalaAssento getSalaAssento() {
        return salaAssento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public boolean cadastrarIngresso() {
        try {
            System.out.println("Digite o ID do ingresso:");
            int idIngresso = Integer.parseInt(scanner.nextLine());

            System.out.println("Digite o valor pago:");
            double valorPago = Double.parseDouble(scanner.nextLine());

            System.out.println("Digite o ID da SalaAssento:");
            int idSalaAssento = Integer.parseInt(scanner.nextLine());
            SalaAssento salaAssento = new SalaAssento(idSalaAssento, null, null).consultarSalaAssento(idSalaAssento);
            if (salaAssento == null) {
                System.out.println("SalaAssento não encontrada.");
                return false;
            }

            System.out.println("Digite o ID da Sessão:");
            int idSessao = Integer.parseInt(scanner.nextLine());
            Sessao sessao = new Sessao(idSessao, null, null, "").consultarSessao(idSessao);
            if (sessao == null) {
                System.out.println("Sessão não encontrada.");
                return false;
            }

            FileWriter fw = new FileWriter("ingressos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(idIngresso + ";" + valorPago + ";" + idSalaAssento + ";" + idSessao);
            writer.newLine();
            writer.close();

            System.out.println("Ingresso cadastrado com sucesso!");
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar ingresso: " + e.getMessage());
            return false;
        }
    }

    public Ingresso consultarIngresso(int id) {
        Ingresso ingressoEncontrado = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("ingressos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idIngresso = Integer.parseInt(dados[0]);
                if (idIngresso == id) {
                    double valorPago = Double.parseDouble(dados[1]);
                    int idSalaAssento = Integer.parseInt(dados[2]);
                    SalaAssento salaAssento = new SalaAssento(idSalaAssento, null, null).consultarSalaAssento(idSalaAssento);
                    int idSessao = Integer.parseInt(dados[3]);
                    Sessao sessao = new Sessao(idSessao, null, null, "").consultarSessao(idSessao);
                    ingressoEncontrado = new Ingresso(idIngresso, valorPago, salaAssento, sessao);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar ingresso: " + e.getMessage());
        }
        return ingressoEncontrado;
    }

    public ArrayList<Ingresso> listarIngressos() {
        ArrayList<Ingresso> ingressos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ingressos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idIngresso = Integer.parseInt(dados[0]);
                double valorPago = Double.parseDouble(dados[1]);
                int idSalaAssento = Integer.parseInt(dados[2]);
                SalaAssento salaAssento = new SalaAssento(idSalaAssento, null, null).consultarSalaAssento(idSalaAssento);
                int idSessao = Integer.parseInt(dados[3]);
                Sessao sessao = new Sessao(idSessao, null, null, "").consultarSessao(idSessao);
                ingressos.add(new Ingresso(idIngresso, valorPago, salaAssento, sessao));
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar ingressos: " + e.getMessage());
        }
        return ingressos;
    }

    public void exibirIngresso() {
        System.out.println("ID Ingresso: " + idIngresso);
        System.out.println("Valor Pago: " + valorPago);
        System.out.println("SalaAssento ID: " + (salaAssento != null ? salaAssento.getidSalaAssento() : "Não informado"));
        System.out.println("Sessão ID: " + (sessao != null ? sessao.getIdSessao() : "Não informado"));
        System.out.println("----------------------------");
    }

    public void listar() {
        ArrayList<Ingresso> ingressos = listarIngressos();
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso encontrado.");
        } else {
            for (Ingresso ingresso : ingressos) {
                ingresso.exibirIngresso();
            }
        }
    }
}
