import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int menu, escolha, i = 0, j = 1;
    static String avisoEspaco = "Não há espaço para cadastrar um novo usuário!";
    static String[] tiposDeDados = {"Nome", "Idade", "Sexo", "Curso"};
    static String[][] alunos = new String[10][4], funcionarios = new String[3][3];
    static long[] matriculaAlunos = new long[10];
    static long[] matriculaFuncionarios = new long[3];
    static long[] codigosDeUsuario = new long[13];

    public static void main(String[] args) {
        do {
            // Menu Principal
            System.out.println("""
                            -- Menu Principal --
                            ____________________
                            |1- Cadastro       |
                            |2- Consulta       |
                            |3- Busca          |
                            |4- Sair           |
                            |__________________|
                            """);
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();
            scanner.nextLine();   // Limpar o buffer
            System.out.println(); // Espaço

            switch (menu) {
                // Cadastro
                case 1:
                    cadastrarUsuarios();
                    break;

                // Consulta
                case 2:
                    consultarAlunos();
                    break;

                // Busca
                case 3:
                    buscarAlunos();
                    break;

                // Encerramento do Programa
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção Inválida! Informe uma opção existente." + "\n");
            }
        } while (menu != 4);

        scanner.close();
    }

    // Funções Principais

    public static void cadastrarUsuarios() {
        // Menu Cadastro
        System.out.println("""
                                - Você é: -
                            ____________________
                            |1- Aluno          |
                            |2- AQV            |
                            |3- Coordenador    |
                            |__________________|
                            """);
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (escolha) {
            // Alunos
            case 1:
                if (i < 10) {
                    System.out.println("-- Cadastro do Aluno --");
                    for (int x = 0; x < 4; x++) {
                        System.out.print(tiposDeDados[x] + " do Aluno: ");
                        alunos[i][x] = scanner.nextLine();
                        impedirRegistroVazio(alunos, i, x, tiposDeDados[x] + " do Aluno");
                    }
                    System.out.print("Matrícula do Aluno: ");
                    matriculaAlunos[i] = scanner.nextLong();
                    scanner.nextLine();
                    gerarCodigo(i);

                    i++;

                } else {
                    System.out.println(avisoEspaco + "\n");
                }
                break;
            // AQV
            case 2:
                if (funcionarios[0][0] == null) {
                    System.out.println("-- Cadastro do AQV --");
                    for (int x = 0; x < 3; x++) {
                        System.out.print(tiposDeDados[x] + " da AQV: ");
                        funcionarios[0][x] = scanner.nextLine();
                        impedirRegistroVazio(funcionarios, 0, x, tiposDeDados[x] + " da AQV");
                    }
                    System.out.print("Matrícula da AQV: ");
                    matriculaFuncionarios[0] = scanner.nextLong();
                    scanner.nextLine();
                    gerarCodigo(10);
                } else {
                    System.out.println(avisoEspaco + "\n");
                }
                break;
            // Coordenadores
            case 3:
                if (j < 3) {
                    System.out.println("-- Cadastro de Coordenador --");
                    for (int x = 0; x < 3; x++) {
                        System.out.print(tiposDeDados[x] + " do Coordenador: ");
                        funcionarios[j][x] = scanner.nextLine();
                        impedirRegistroVazio(funcionarios, j, x, tiposDeDados[x] + " do Coordenador");
                    }
                    System.out.print("Matrícula do Coordenador: ");
                    matriculaFuncionarios[j] = scanner.nextLong();
                    scanner.nextLine();
                    gerarCodigo(j+10);

                    j++;

                } else {
                    System.out.println(avisoEspaco + "\n");
                }
                break;
            default:
                System.out.println("Opção Inválida! Informe uma opção existente.\n");
        }
    }

    public static void consultarAlunos() {
        if (alunos[0][0] != null) {
            System.out.println("-- Consulta de alunos cadastrados --");
            for (int x = 0; x < 10; x++) {
                if (alunos[x][0] == null) {
                    break;
                }
                exibirDados(x);
            }
        } else {
            System.out.println("Ainda não há alunos cadastrados!\n");
        }
    }

    public static void buscarAlunos() {
        if (alunos[0][0] != null) {
            System.out.println("""
                            ____________________
                            |Busca por:        |
                            |1- Nome           |
                            |2- Matrícula      |
                            |__________________|
                            
                            """);
            System.out.print("Escolha a opção que deseja fazer a busca: ");
            escolha = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            // Busca pelo Nome
            if (escolha == 1) {
                System.out.print("Digite o nome do aluno: ");
                String nomeBusca = scanner.nextLine();
                boolean encontrado = false;

                for (int x = 0; x < 10; x++) {
                    if (nomeBusca.equals(alunos[x][0])) {
                        System.out.println("Aluno encontrado!");
                        exibirDados(x);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Aluno não encontrado!");
                }

                // Busca pela Matrícula
            } else if (escolha == 2) {
                System.out.print("Digite a matrícula do aluno: ");
                long matriculaBusca = scanner.nextLong();
                boolean encontrado = false;

                for (int x = 0; x < 10; x++) {
                    if (matriculaBusca == matriculaAlunos[x]) {
                        System.out.println("Aluno encontrado!");
                        exibirDados(x);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Aluno não encontrado!");
                }

            } else {
                System.out.println("Opção Inválida! Informe uma opção existente." + "\n");
            }
        } else {
            System.out.println("Ainda não há alunos cadastrados!\n");
        }
    }

    // Funções Secundárias

    public static void gerarCodigo(int contador) {
        Random random = new Random();
        codigosDeUsuario[contador] = random.nextInt((999999 - 100000) + 1) + 100000;

        for (int x = 0; x < 13; x++) {
            if (x != contador) {
                while (codigosDeUsuario[contador] == codigosDeUsuario[x]) {
                    codigosDeUsuario[contador] = random.nextInt((999999 - 100000) + 1) + 100000;
                }
            }
        }
        System.out.println("Código do usuário: " + codigosDeUsuario[contador] + "\n");
    }

    public static void impedirRegistroVazio(String[][] matriz, int linha, int coluna, String texto) {
        if (matriz[linha][coluna] == "") {
            while (matriz[linha][coluna] == "") {
                System.out.print("Este campo é obrigatório!\n" + texto + ": ");
                matriz[linha][coluna] = scanner.nextLine();
            }
            System.out.println();
        }
    }

    public static void exibirDados(int linha) {
        for (int x = 0; x < 4; x++) {
            System.out.println(tiposDeDados[x] + ": " + alunos[linha][x]);
        }
        System.out.println("Matrícula: " + matriculaAlunos[linha]);
        System.out.println("Código do usuário: " + codigosDeUsuario[linha] + "\n");
    }
}
