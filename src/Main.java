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
            System.out.println("Menu Principal \n\t1- Cadastro \n\t2- Consulta \n\t3- Busca \n\t4- Sair");
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();
            scanner.nextLine();   // Limpar o buffer
            System.out.println(); // Espaço

            switch (menu) {
                case 1:
                    cadastrarUsuarios();
                    break;

                // Consulta
                case 2:
                    if (alunos[0][0] != null) {
                        System.out.println("\tAlunos Cadastrados");
                        for (int x = 0; x < 10; x++) {
                            if (alunos[x][0] == null) {
                                break;
                            }
                            exibirDados(alunos, matriculaAlunos, codigosDeUsuario, x);
                        }
                    } else {
                        System.out.println("Ainda não há alunos cadastrados!\n");
                    }
                    break;

                // Busca
                case 3:
                    if (alunos[0][0] != null) {
                        System.out.println("\t1- Nome \n\t2- Matrícula\n");
                        System.out.print("Escolha a opção que deseja fazer a busca: ");
                        escolha = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();

                        // Busca pelo nome
                        if (escolha == 1) {
                            System.out.print("Digite o nome do aluno: ");
                            String nomebusca = scanner.nextLine();
                            boolean encontrado = false;

                            for (int x = 0; x < 10; x++) {
                                if (nomebusca.equals(alunos[x][0])) {
                                    System.out.println("Aluno encontrado!");
                                    exibirDados(alunos, matriculaAlunos, codigosDeUsuario, x);
                                    encontrado = true;
                                    break;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("Aluno não encontrado!");
                            }

                            // Busca pela matrícula
                        } else if (escolha == 2) {
                            System.out.print("Digite a matrícula do aluno: ");
                            long matriculaBusca = scanner.nextLong();
                            boolean encontrado = false;

                            for (int x = 0; x < 10; x++) {
                                if (matriculaBusca == matriculaAlunos[x]) {
                                    System.out.println("Aluno encontrado!");
                                    exibirDados(alunos, matriculaAlunos, codigosDeUsuario, x);
                                    encontrado = true;
                                    break;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("Aluno não encontrado!");
                            }

                        } else {
                            System.out.println("Opção Inválida! Informa uma opção existente." + "\n");
                        }
                    } else {
                        System.out.println("Ainda não há alunos cadastrados!\n");
                    }
                    break;

                    // Encerramento do Programa
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção Inválida! Informa uma opção existente." + "\n");
            }
        } while (menu != 4);
        
        scanner.close();
    }

    public static void gerarCodigo(int min, int max, long[] vetor, int contador) {
        Random random = new Random();
        vetor[contador] = random.nextInt((max - min) + 1) + min;

        for (int x = 0; x < 10; x++) {
            if (x != contador) {
                while (vetor[contador] == vetor[x]) {
                    vetor[contador] = random.nextInt((max - min) + 1) + min;
                }
            }
        }
        System.out.println("Código do usuário: " + vetor[contador] + "\n");
    }

    public static void impedirRegistroVazio(String[][] matriz, int linha, int coluna, String texto) {
        while (matriz[linha][coluna] == "") {
            System.out.print("Este campo é obrigatório!\n" + texto + ": ");
            matriz[linha][coluna] = scanner.nextLine();
        }
        System.out.println();
    }

    public static void exibirDados(String[][] matriz, long[] vetor, long[] codigo, int linha) {
        System.out.println("Nome: " + matriz[linha][0]);
        System.out.println("Idade: " + matriz[linha][1]);
        System.out.println("Sexo: " + matriz[linha][2]);
        System.out.println("Curso: " + matriz[linha][3]);
        System.out.println("Matrícula: " + vetor[linha]);
        System.out.println("Código do usuário: " + codigo[linha] + "\n");
    }

    public static void cadastrarUsuarios() {
        // Menu Cadastro
        System.out.println("Você é: \n\t1- Aluno \n\t2- AQV \n\t3- Coordenador");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (escolha) {
            // Alunos
            case 1:
                if (i < 10) {
                    for (int x = 0; x < 4; x++) {
                        System.out.println(tiposDeDados[x] + " do Aluno");
                        alunos[i][x] = scanner.nextLine();
                        impedirRegistroVazio(alunos, i, x, tiposDeDados[x] + " do Aluno");
                    }
                    System.out.println("Matrícula do Aluno");
                    matriculaAlunos[i] = scanner.nextLong();
                    scanner.nextLine();
                    gerarCodigo(100000, 999999, codigosDeUsuario, i);

                    i++;

                } else {
                    System.out.println(avisoEspaco + "\n");
                }
                break;
            // AQV
            case 2:
                if (funcionarios[0][0] == null) {
                    for (int x = 0; x < 3; x++) {
                        System.out.println(tiposDeDados[x] + " da AQV");
                        funcionarios[0][x] = scanner.nextLine();
                        impedirRegistroVazio(funcionarios, 0, x, tiposDeDados[x] + " da AQV");
                    }
                    System.out.println("Matrícula da AQV");
                    matriculaFuncionarios[0] = scanner.nextLong();
                    scanner.nextLine();
                    gerarCodigo(100000, 999999, codigosDeUsuario, 0);
                } else {
                    System.out.println(avisoEspaco + "\n");
                }
                break;
            // Coordenadores
            case 3:
                if (j < 3) {
                    for (int x = 0; x < 3; x++) {
                        System.out.println(tiposDeDados[x] + " do Coordenador");
                        funcionarios[j][x] = scanner.nextLine();
                        impedirRegistroVazio(funcionarios, j, x, tiposDeDados[x] + " do Coordenador");
                    }
                    System.out.println("Matrícula do Coordenador");
                    matriculaFuncionarios[j] = scanner.nextLong();
                    scanner.nextLine();
                    gerarCodigo(100000, 999999, codigosDeUsuario, j);

                    j++;

                } else {
                    System.out.println(avisoEspaco + "\n");
                }
                break;
            default:
                System.out.println("Opção Inválida! Informe uma opção existente.\n");
        }
    }

    public static void consultarUsuarios() {

    }

    public static void buscarUsuarios() {

    }
}
