import java.io.BufferedReader;
import java.io.BufferedWriter;
/* import java.io.File;*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Funcionario extends Pessoa{

    Scanner scanner = new Scanner(System.in);

    private int matricula;
    private Date horarioTrabalho;

    public Funcionario(String nome, String cpf, String email, int matricula /* Date horarioTrabalho */){

        super(cpf, nome, email);
        this.matricula = matricula;
        /* this.horarioTrabalho = horarioTrabalho; */

    }

    public int getmatricula(){

        return matricula;
    }

    public Date gethorarioTrabalho(){

        return horarioTrabalho;
    }

    public void setmatricula(int matricula){

        this.matricula = matricula;

    }

    public void sethorarioTrabalho(Date horarioTrabalho){

        this.horarioTrabalho = horarioTrabalho;
    }

    public boolean cadastrarFuncionario(){


        try {

            System.out.println("Digite o seu nome:");
                String nome = scanner.nextLine();
            System.out.println("Digite seu Cpf: ");
                String cpf = scanner.nextLine();
            System.out.println("Digite seu email: ");
                String email = scanner.nextLine();
            System.out.println("digite sua matricula: ");
                int matricula = scanner.nextInt();

                FileWriter fw = new FileWriter("funcionario.txt", true);
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
            System.out.println("Erro ao cadastrar funcionario");

            return false;

            }        

    }

    public void exibirFuncionario(){

        System.out.println("nome: " + this.getnome());
        System.out.println("cpf: " + this.getcpf());
        System.out.println("email: " + this.getemail());
        System.out.println("matricula: " + getmatricula());
        System.out.println("--------------------");

    }
    
    public Funcionario consultarFuncionario(String cpf) {

        System.out.println("Digite o CPF do funcionário: ");
            String cpfDigitado = scanner.nextLine().trim();

        Funcionario funcionarioLido = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\Projeto final POO\\Cinema\\funcionario.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados[1].trim().equals(cpfDigitado)) {
                    String nomeFuncionario = dados[0].trim();
                    String cpfFuncionario = dados[1].trim();
                    String emailFuncionario = dados[2].trim();
                    int matriculaFuncionario = Integer.parseInt(dados[3].trim());

                    funcionarioLido = new Funcionario(nomeFuncionario, cpfFuncionario, emailFuncionario, matriculaFuncionario);
                    funcionarioLido.exibirFuncionario();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao encontrar o funcionário: " + e.getMessage());
        }

        return funcionarioLido;
    }

    public ArrayList<Funcionario> listaFuncionarios() throws IOException{
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\Projeto final POO\\Cinema\\funcionario.txt"))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                
                String[] dados = linha.split(";");

                String nomeFuncionario = dados[0].trim();
                String cpfFuncionario = dados[1].trim();
                String emailFuncionario = dados[2].trim();
                int matriculaFuncionario = Integer.parseInt(dados[3].trim());

                Funcionario funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, emailFuncionario, matriculaFuncionario);
                funcionarios.add(funcionario); 

            }

        } catch(IOException e) {

            System.out.println("erro ao registrar na arraylist");

        }
        return funcionarios;
    }
    
    public void listar() {

        System.out.println("\nLendo dados do arquivo");

        try {

            ArrayList<Funcionario> funcionarios = listaFuncionarios();

                if(funcionarios.isEmpty()) {

                    System.out.println("nenhum funcionario encontrado.");

                } else {

                    for(Funcionario funcionario : funcionarios) {

                        funcionario.exibirFuncionario();

                    }

                }     

        } catch(IOException e) {

            System.out.println("erro ao listar funcionarios" + e.getMessage());

        }

    }

}

    