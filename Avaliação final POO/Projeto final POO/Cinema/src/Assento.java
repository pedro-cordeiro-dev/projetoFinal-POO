import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assento {

    Scanner scanner = new Scanner(System.in);

    private int idAssento;
    private TipoAssento tipoAssento;

    public Assento(int idAssento, TipoAssento tipoAssento){

        this.idAssento = idAssento;
        this.tipoAssento = tipoAssento;

    }

    public int getidAssento() {

        return idAssento;

    }

    public TipoAssento gettipoAssento(){

        return tipoAssento;

    }

    public void setidAssento(int idAssento){

        this.idAssento = idAssento;

    }

    public void setidTipoAssento(TipoAssento tipoAssento){

        this.tipoAssento = tipoAssento;

    }

    public boolean cadastrarAssento() {
        try {
            System.out.println("Digite o ID do assento:");
            int idAssento = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite a descrição do tipo de assento:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o status do assento (disponível/indisponível):");
            String status = scanner.nextLine();

            TipoAssento tipoAssento = new TipoAssento(idAssento, descricao, status);
            Assento assento = new Assento(idAssento, tipoAssento);

            FileWriter fw = new FileWriter("assento.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(assento.getidAssento() + ";");
            writer.write(assento.gettipoAssento().getdescricao() + ";");
            writer.write(assento.gettipoAssento().getstatus() + ";");
            writer.newLine();

            writer.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar assento");
            return false;
        }
    }

    public void consultarAssento() {
        try {
            System.out.println("Digite o ID do assento que deseja consultar: ");
            int idAssento = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Assento> assentos = listarAssentos();

            for (Assento a : assentos) {
                if (a.getidAssento() == idAssento) {
                    a.exibirAssento();
                    return;
                }
            }

            System.out.println("Assento não encontrado.");
        } catch(Exception e){

            System.out.println("erro ao consultar Assento");

        }
    }

    public ArrayList<Assento> listarAssentos() {
        ArrayList<Assento> assentos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("assento.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idAssento = Integer.parseInt(dados[0].trim());
                TipoAssento tipoAssento = new TipoAssento(idAssento, dados[1].trim(), dados[2].trim());

                Assento assento = new Assento(idAssento, tipoAssento);
                assentos.add(assento);
            }

        } catch (IOException e) {
            System.out.println("Erro ao listar assentos: " + e.getMessage());
        }

        return assentos;
    }

    public void exibirAssento() {
        System.out.println("ID Assento: " + this.getidAssento());
        System.out.println("Tipo de Assento: " + this.gettipoAssento().getdescricao());
        System.out.println("Status: " + this.gettipoAssento().getstatus());
        System.out.println("--------------------");
    }
}
