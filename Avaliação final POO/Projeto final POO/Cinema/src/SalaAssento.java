import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalaAssento {

    Scanner scanner = new Scanner(System.in);

    private int idSalaAssento;
    private Assento assento;
    private Sala sala;

    public SalaAssento(int idSalaAssento, Assento assento, Sala sala) {
        this.idSalaAssento = idSalaAssento;
        this.assento = assento;
        this.sala = sala;
    }

    public SalaAssento(){}

    public int getidSalaAssento() {
        return idSalaAssento;
    }

    public Assento getassento() {
        return assento;
    }

    public Sala getsala() {
        return sala;
    }

    public void setidSalaAssento(int idSalaAssento) {
        this.idSalaAssento = idSalaAssento;
    }

    public void setassento(Assento assento) {
        this.assento = assento;
    }

    public void setsala(Sala sala) {
        this.sala = sala;
    }

    public boolean cadastrarSalaAssento() {
        try {
            System.out.println("Digite o ID da SalaAssento:");
            int idSalaAssento = Integer.parseInt(scanner.nextLine());
    
            System.out.println("Digite o número do assento:");
            String numeroAssento = scanner.nextLine();
    
            System.out.println("Digite a descrição do tipo de assento:");
            String descricaoTipo = scanner.nextLine();
    
            System.out.println("Digite o status do assento (disponível/indisponível):");
            String statusAssento = scanner.nextLine();
    
            TipoAssento tipoAssento = new TipoAssento(descricaoTipo, statusAssento);
            Assento assento = new Assento(numeroAssento, tipoAssento);
    
            System.out.println("Digite o número da sala:");
            String numeroSala = scanner.nextLine();
    
            System.out.println("Digite a capacidade da sala:");
            int capacidadeSala = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
    
            System.out.println("Digite o status da sala:");
            String statusSala = scanner.nextLine();
    
            Sala sala = new Sala(numeroSala, capacidadeSala, statusSala);
    
            FileWriter fw = new FileWriter("salaAssento.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
    
            writer.write(idSalaAssento + ";");
            writer.write(numeroAssento + ";");
            writer.write(numeroSala + ";");
            writer.newLine();
    
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar SalaAssento: " + e.getMessage());
            return false;
        }
    }

    public SalaAssento consultarSalaAssento(int id) {
        SalaAssento salaAssentoLida = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("salaAssento.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idSalaAssento = Integer.parseInt(dados[0].trim());
                if (idSalaAssento == id) {
                    String numeroAssento = dados[1].trim();
                    String numeroSala = dados[2].trim();

                    Assento assento = new Assento(numeroAssento);
                    Sala sala = new Sala(numeroSala);

                    salaAssentoLida = new SalaAssento(idSalaAssento, assento, sala);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar SalaAssento: " + e.getMessage());
        }

        return salaAssentoLida;
    }

    public ArrayList<SalaAssento> listaSalaAssento() throws IOException {
        ArrayList<SalaAssento> salaAssentos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("salaAssento.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                int idSalaAssento = Integer.parseInt(dados[0].trim());
                String numeroAssento = dados[1].trim();
                String numeroSala = dados[2].trim();

                Assento assento = new Assento(numeroAssento);
                Sala sala = new Sala(numeroSala);

                SalaAssento salaAssento = new SalaAssento(idSalaAssento, assento, sala);
                salaAssentos.add(salaAssento);
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar SalaAssento: " + e.getMessage());
        }

        return salaAssentos;
    }

    public void listarSalaAssentos() {
        try {
            ArrayList<SalaAssento> salaAssentos = listaSalaAssento();

            if (salaAssentos.isEmpty()) {
                System.out.println("Nenhuma SalaAssento encontrada.");
            } else {
                for (SalaAssento salaAssento : salaAssentos) {
                    System.out.println("ID: " + salaAssento.getidSalaAssento());
                    System.out.println("Assento: " + salaAssento.getassento().getnumeroAssento());
                    System.out.println("Sala: " + salaAssento.getsala().getnumeroSala());
                    System.out.println("--------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar SalaAssentos: " + e.getMessage());
        }
    }
}
