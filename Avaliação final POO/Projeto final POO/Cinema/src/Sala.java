import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sala {

    private int idSala;
    private int capacidadeSala;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public Sala(int idSala, int capacidadeSala, String status) {
        this.idSala = idSala;
        this.capacidadeSala = capacidadeSala;
        this.status = status;
    }

    public int getIdSala() {
        return idSala;
    }

    public int getCapacidadeSala() {
        return capacidadeSala;
    }

    public String getStatus() {
        return status;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean cadastrarSala() {
        try {
            System.out.println("Digite o ID da sala:");
            int idSala = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite a capacidade da sala:");
            int capacidade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o status da sala:");
            String status = scanner.nextLine();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("sala.txt", true))) {
                writer.write(idSala + ";" + capacidade + ";" + status);
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar sala: " + e.getMessage());
            return false;
        }
    }

    public Sala consultarSala(int idSala) {
        Sala salaEncontrada = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("sala.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0].trim());

                if (id == idSala) {
                    int capacidade = Integer.parseInt(dados[1].trim());
                    String status = dados[2].trim();
                    salaEncontrada = new Sala(id, capacidade, status);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao consultar sala: " + e.getMessage());
        }

        return salaEncontrada;
    }

    public ArrayList<Sala> listarSalas() {
        ArrayList<Sala> salas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("sala.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0].trim());
                int capacidade = Integer.parseInt(dados[1].trim());
                String status = dados[2].trim();

                Sala sala = new Sala(id, capacidade, status);
                salas.add(sala);
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar salas: " + e.getMessage());
        }

        return salas;
    }

    public void exibirSalas() {
        ArrayList<Sala> salas = listarSalas();

        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala encontrada.");
        } else {
            for (Sala sala : salas) {
                System.out.println("ID da sala: " + sala.getIdSala());
                System.out.println("Capacidade da sala: " + sala.getCapacidadeSala());
                System.out.println("Status da sala: " + sala.getStatus());
                System.out.println("----------------------------");
            }
        }
    }
}
