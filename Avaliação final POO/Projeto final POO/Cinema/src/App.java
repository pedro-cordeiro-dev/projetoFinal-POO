import java.util.Scanner;

public class App {

    public static void menuAtor(Scanner scanner, Ator ator){

        int opcaoMenuAtor = -1;
            while(opcaoMenuAtor != 0){

                System.out.println("\n--- Menu Ator ---");
                System.out.println("1. Cadastrar Ator");
                System.out.println("2. Listar Atores");
                System.out.println("3. Consultar Ator");
                System.out.println("0. Voltar");
                System.out.print("Opção: ");
                opcaoMenuAtor = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoMenuAtor) {
                    case 1:
                        ator.cadastrarAtor();
                        break;
                    case 2:
                        ator.listarAtores();
                        break;
                    case 3:
                        System.out.println("Digite o CPF do ator a ser consultado:");
                        String cpf = scanner.nextLine();
                        ator.consultarAtor(cpf);
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }

    }

    public static void menuFuncionario(Scanner scanner, Funcionario funcionario) {
        int opcaoMenuFuncionario = -1;
        while(opcaoMenuFuncionario != 0){
            System.out.println("\n--- Menu Funcionario ---");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Listar Funcionarios");
            System.out.println("3. Consultar Funcionario");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuFuncionario = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuFuncionario) {
                case 1:
                    funcionario.cadastrarFuncionario();
                    break;
                case 2:
                    funcionario.listar();
                    break;
                case 3:
                    System.out.println("Digite o CPF do funcionario a ser consultado:");
                    String cpf = scanner.nextLine();
                    funcionario.consultarFuncionario(cpf);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void menuSessao(Scanner scanner, Sessao sessao) {
        int opcaoMenuSessao = -1;
        while(opcaoMenuSessao != 0){
            System.out.println("\n--- Menu Sessao ---");
            System.out.println("1. Cadastrar Sessao");
            System.out.println("2. Listar Sessoes");
            System.out.println("3. Consultar Sessao");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuSessao = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuSessao) {
                case 1:
                    sessao.cadastrarSessao();
                    break;
                case 2:
                    sessao.listarSessoes();
                    break;
                case 3:
                    System.out.println("Digite o ID da Sessao a ser consultada:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    sessao.consultarSessao(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void menuAssento(Scanner scanner, Assento assento) {
        int opcaoMenuAssento = -1;
        while(opcaoMenuAssento != 0){
            System.out.println("\n--- Menu Assento ---");
            System.out.println("1. Cadastrar Assento");
            System.out.println("2. Listar Assentos");
            System.out.println("3. Consultar Assento");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuAssento = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuAssento) {
                case 1:
                    assento.cadastrarAssento();
                    break;
                case 2:
                    assento.listarAssentos();
                    break;
                case 3:
                    System.out.println("Digite o ID do Assento a ser consultado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    assento.consultarAssento();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuTipoAssento(Scanner scanner, TipoAssento tipoAssento) {
        int opcaoMenuTipoAssento = -1;
        while(opcaoMenuTipoAssento != 0){
            System.out.println("\n--- Menu TipoAssento ---");
            System.out.println("1. Cadastrar TipoAssento");
            System.out.println("2. Listar TipoAssentos");
            System.out.println("3. Consultar TipoAssento");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuTipoAssento = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuTipoAssento) {
                case 1:
                    tipoAssento.cadastrarTipoAssento();
                    break;
                case 2:
                    tipoAssento.listar();
                    break;
                case 3:
                    System.out.println("Digite o ID do TipoAssento a ser consultado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    tipoAssento.consultarTipoAssento(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuSalaAssento(Scanner scanner, SalaAssento salaAssento) {
        int opcaoMenuSalaAssento = -1;
        while(opcaoMenuSalaAssento != 0){
            System.out.println("\n--- Menu SalaAssento ---");
            System.out.println("1. Cadastrar SalaAssento");
            System.out.println("2. Listar SalaAssentos");
            System.out.println("3. Consultar SalaAssento");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuSalaAssento = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuSalaAssento) {
                case 1:
                    salaAssento.cadastrarSalaAssento();
                    break;
                case 2:
                    salaAssento.listarSalaAssentos();
                    break;
                case 3:
                    System.out.println("Digite o ID do SalaAssento a ser consultado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    salaAssento.consultarSalaAssento(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void menuSala(Scanner scanner, Sala sala) {
        int opcaoMenuSala = -1;
        while(opcaoMenuSala != 0){
            System.out.println("\n--- Menu Sala ---");
            System.out.println("1. Cadastrar Sala");
            System.out.println("2. Listar Salas");
            System.out.println("3. Consultar Sala");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuSala = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuSala) {
                case 1:
                    sala.cadastrarSala();
                    break;
                case 2:
                    sala.listarSalas();
                    break;
                case 3:
                    System.out.println("Digite o ID da Sala a ser consultada:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    sala.consultarSala(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void menuIngresso(Scanner scanner, Ingresso ingresso) {
        int opcaoMenuIngresso = -1;
        while(opcaoMenuIngresso != 0){
            System.out.println("\n--- Menu Ingresso ---");
            System.out.println("1. Cadastrar Ingresso");
            System.out.println("2. Listar Ingressos");
            System.out.println("3. Consultar Ingresso");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuIngresso = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuIngresso) {
                case 1:
                    ingresso.cadastrarIngresso();
                    break;
                case 2:
                    ingresso.listarIngressos();
                    break;
                case 3:
                    System.out.println("Digite o ID do Ingresso a ser consultado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    ingresso.consultarIngresso(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void menuGenero(Scanner scanner, Genero genero) {
        int opcaoMenuGenero = -1;
        while(opcaoMenuGenero != 0){
            System.out.println("\n--- Menu Genero ---");
            System.out.println("1. Cadastrar Genero");
            System.out.println("2. Listar Generos");
            System.out.println("3. Consultar Genero");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuGenero = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuGenero) {
                case 1:
                    genero.cadastrarGenero();
                    break;
                case 2:
                    genero.listarGeneros();
                    break;
                case 3:
                    System.out.println("Digite o ID do Genero a ser consultado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    genero.consultarGenero(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuFilme(Scanner scanner, Filme filme) {
        int opcaoMenuFilme = -1;
        while(opcaoMenuFilme != 0){
            System.out.println("\n--- Menu Filme ---");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Listar Filmes");
            System.out.println("3. Consultar Filme");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoMenuFilme = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcaoMenuFilme) {
                case 1:
                    filme.cadastrarFilme();
                    break;
                case 2:
                    filme.listarFilmes();
                    break;
                case 3:
                    System.out.println("Digite o ID do Filme a ser consultado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    filme.consultarFilme(id);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }    

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Ator ator = new Ator(null, null, null, 0);
        Assento assento = new Assento(0, null);
        Filme filme = new Filme(0, null, 0, null, null);
        FilmeAtor filmeAtor = new FilmeAtor(0, ator, filme, null, false);
        Funcionario funcionario = new Funcionario(null, null, null, 0);
        Genero genero = new Genero(0, null, null);
        Ingresso ingresso = new Ingresso(0, 0, null, null);
        Sala sala = new Sala(0, 0, null);
        SalaAssento salaAssento = new SalaAssento(0, assento, sala);
        Sessao sessao = new Sessao(0, filme, funcionario, null);
        TipoAssento tipoAssento = new TipoAssento(0, null, null);

        int opcaoMenuPrincipal = -1;

            
        try {
            while (opcaoMenuPrincipal != 0) {
        
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Ator");
                System.out.println("2. Assento");
                System.out.println("3. Filme");
                System.out.println("4. Sessao");
                System.out.println("5. Funcionario");
                System.out.println("6. Genero");
                System.out.println("7. Ingresso");
                System.out.println("8. Sala");
                System.out.println("9. TipoAssento");
                System.out.println("10. SalaAssento");
                System.out.println("11. FilmeAtor");
                System.out.println("0. Sair");
                System.out.print("Opção: ");
                
                opcaoMenuPrincipal = scanner.nextInt();
                scanner.nextLine();
        
                switch (opcaoMenuPrincipal) {
                    case 1:
                        menuAtor(scanner, ator);
                        break;
                    case 2:
                        menuAssento(scanner, assento);
                        break;
                    case 3:
                        menuFilme(scanner, filme);
                        break;
                    case 4:
                        menuSessao(scanner, sessao);
                        break;
                    case 5:
                        menuFuncionario(scanner, funcionario);
                        break;
                    case 6:
                        menuGenero(scanner, genero);
                        break;
                    case 7:
                        menuIngresso(scanner, ingresso);
                        break;
                    case 8:
                        menuSala(scanner, sala);
                        break;
                    case 9:
                        menuTipoAssento(scanner, tipoAssento);
                        break;
                    case 10:
                        menuSalaAssento(scanner, salaAssento);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro. Certifique-se de inserir um valor válido.");
            scanner.nextLine();
        }
        
        }

    }

