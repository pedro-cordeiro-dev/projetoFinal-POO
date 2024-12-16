import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TipoAssento {

    private int idTipoAssento;
    private String descricao;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public TipoAssento(int idTipoAssento, String descricao, String status) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
    }

    public int getidTipoAssento() {
        return idTipoAssento;
    }

    public void setidTipoAssento(int idTipoAssento) {
        this.idTipoAssento = idTipoAssento;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public boolean cadastrarTipoAssento() {
        try {
            System.out.println("Digite a descrição do tipo de assento:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o status do assento (disponível/indisponível):");
            String status = scanner.nextLine();
            System.out.println("Digite o ID do tipo de assento:");
            int idTipoAssento = scanner.nextInt();

            FileWriter fw = new FileWriter("tipo_assento.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(idTipoAssento + ";");
            writer.write(descricao + ";");
            writer.write(status + ";");
            writer.newLine();

            writer.close();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar tipo de assento");
            return false;
        }
    }

    public void exibirTipoAssento() {
        System.out.println("ID Tipo de Assento: " + this.getidTipoAssento());
        System.out.println("Descrição: " + this.getdescricao());
        System.out.println("Status: " + this.getstatus());
        System.out.println("--------------------");
    }

    public TipoAssento consultarTipoAssento(int id) {
        System.out.println("Digite o ID do tipo de assento que deseja consultar: ");
        int idDigitado = scanner.nextInt();
        scanner.nextLine();

        TipoAssento tipoAssentoLido = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("tipo_assento.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                if (Integer.parseInt(dados[0].trim()) == idDigitado) {
                    int idTipoAssento = Integer.parseInt(dados[0].trim());
                    String descricao = dados[1].trim();
                    String status = dados[2].trim();

                    tipoAssentoLido = new TipoAssento(idTipoAssento, descricao, status);
                    tipoAssentoLido.exibirTipoAssento();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao encontrar o tipo de assento: " + e.getMessage());
        }

        return tipoAssentoLido;
    }

    public void listar() {
        System.out.println("\nLendo dados do arquivo");

        try {
            ArrayList<TipoAssento> tiposAssentos = listaTipoAssentos();

            if (tiposAssentos.isEmpty()) {
                System.out.println("Nenhum tipo de assento encontrado.");
            } else {
                for (TipoAssento tipoAssento : tiposAssentos) {
                    tipoAssento.exibirTipoAssento();
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao listar tipos de assentos: " + e.getMessage());
        }
    }

    public ArrayList<TipoAssento> listaTipoAssentos() throws IOException {
        ArrayList<TipoAssento> tiposAssentos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("tipo_assento.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idTipoAssento = Integer.parseInt(dados[0].trim());
                String descricao = dados[1].trim();
                String status = dados[2].trim();

                TipoAssento tipoAssento = new TipoAssento(idTipoAssento, descricao, status);
                tiposAssentos.add(tipoAssento);
            }

        } catch (IOException e) {
            System.out.println("Erro ao registrar na lista de tipos de assentos: " + e.getMessage());
        }

        return tiposAssentos;
    }
}
