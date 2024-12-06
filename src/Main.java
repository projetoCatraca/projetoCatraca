import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int menu, escolha, i = 0, j = 1;
        String aviso = "Não há espaço para cadastrar um novo usuário!";
        String[][] alunos = new String[10][5];
        String[][] funcionarios = new String[3][4];
        long[] matriculaAlunos = new long[10];
        long[] matriculaFuncionarios = new long[3];

        do {
            // Menu Principal
            System.out.println("Menu Principal \n\t1- Cadastro \n\t2- Consulta \n\t3- Busca \n\t4- Sair");
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();
            scanner.nextLine();   // Limpar o buffer
            System.out.println(); // Espaço

            switch (menu) {
                case 1:
                    // Menu Cadastro
                    System.out.println("Você é: \n\t1- Aluno \n\t2- AQV \n\t3- Coordenador");
                    System.out.print("Escolha uma opção: ");
                    escolha = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    if (escolha == 1) {
                        // Alunos
                        if (i < 10) {
                            System.out.println("Nome do Aluno");
                            alunos[i][0] = scanner.nextLine();
                            ImpedirRegistroVazio(alunos, "Nome do aluno: ", i, 0);

                            System.out.println("Idade do Aluno");
                            alunos[i][1] = scanner.nextLine();
                            ImpedirRegistroVazio(alunos, "Idade do aluno: ", i, 1);

                            System.out.println("Sexo do Aluno");
                            alunos[i][2] = scanner.nextLine();
                            ImpedirRegistroVazio(alunos, "Sexo do aluno: ", i, 2);

                            System.out.println("Curso do Aluno");
                            alunos[i][3] = scanner.nextLine();
                            ImpedirRegistroVazio(alunos, "Curso do aluno: ", i, 3);

                            System.out.println("Matricula do Aluno");
                            matriculaAlunos[i] = scanner.nextLong();
                            scanner.nextLine();

                            alunos[i][4] = GeradorDeCodigo(100, 100000) + "";
                            for (int x = 0; x < 10; x++) {
                                if (x != i) {
                                    if (alunos[i][4] == alunos[x][4]) {
                                        alunos[i][4] = (Integer.parseInt(alunos[i][4]) + 1) + "";
                                        x = 0;
                                    }
                                }
                            }
                            System.out.println("Código do usuário: " + alunos[i][4] + "\n");

                            i++;

                        } else {
                            System.out.println(aviso + "\n");
                        }
                    } else if (escolha == 2) {
                        // AQV
                        if (funcionarios[0][0] == null) {
                            System.out.println("Nome da(o) Analista de Qualidade de Vida (AQV)");
                            funcionarios[0][0] = scanner.nextLine();
                            ImpedirRegistroVazio(funcionarios, "Nome da(o) Analista de Qualidade de Vida (AQV): ", 0, 0);

                            System.out.println("Idade da(o) Analista de Qualidade de Vida (AQV)");
                            funcionarios[0][1] = scanner.nextLine();
                            ImpedirRegistroVazio(funcionarios, "Idade da(o) Analista de Qualidade de Vida (AQV): ", 0, 1);

                            System.out.println("Sexo da(o) Analista de Qualidade de Vida (AQV)");
                            funcionarios[0][2] = scanner.nextLine();
                            ImpedirRegistroVazio(funcionarios, "Sexo da(o) Analista de Qualidade de Vida (AQV): ", 0, 2);

                            System.out.println("Matricula da(o) Analista de Qualidade de Vida (AQV)");
                            matriculaFuncionarios[0] = scanner.nextLong();
                            scanner.nextLine();

                            funcionarios[0][3] = GeradorDeCodigo(100, 100000) + "";
                            for (int x = 0; x < 3; x++) {
                                if (x != 0) {
                                    if (funcionarios[x][3] == funcionarios[0][3]) {
                                        funcionarios[0][3] = (Integer.parseInt(funcionarios[0][3]) + 1) + "";
                                        x = 0;
                                    }
                                }
                            }
                            System.out.println("Código do usuário: " + funcionarios[i][3] + "\n");

                        } else {
                            System.out.println(aviso + "\n");
                        }
                    } else if (escolha == 3) {
                        // Coordenadores
                        if (j < 3) {
                            System.out.println("Nome do Coordenador");
                            funcionarios[j][0] = scanner.nextLine();
                            ImpedirRegistroVazio(funcionarios, "Nome do Coordenador: ", j, 0);

                            System.out.println("Idade do Coordenador");
                            funcionarios[j][1] = scanner.nextLine();
                            ImpedirRegistroVazio(funcionarios, "Idade do Coordenador: ", j, 1);

                            System.out.println("Sexo do Coordenador");
                            funcionarios[j][2] = scanner.nextLine();
                            ImpedirRegistroVazio(funcionarios, "Sexo do Coordenador: ", j, 2);

                            System.out.println("Matricula do Coordenador");
                            matriculaFuncionarios[j] = scanner.nextLong();
                            scanner.nextLine();

                            funcionarios[j][3] = GeradorDeCodigo(100, 100000) + "";
                            for (int x = 0; x < 3; x++) {
                                if (x != j) {
                                    if (funcionarios[j][3] == funcionarios[x][3]) {
                                        funcionarios[j][3] = (Integer.parseInt(funcionarios[j][3]) + 1) + "";
                                        x = 0;
                                    }
                                }
                            }
                            System.out.println("Código do usuário: " + funcionarios[j][3] + "\n");

                            j++;
                        } else {
                            System.out.println(aviso + "\n");
                        }
                    } else {
                        System.out.println("Opção Inválida! Informa uma opção existente.\n");
                    }
                    break;

                // Consulta
                case 2:
                    if (alunos[0][0] != null) {
                        System.out.println("\tAlunos Cadastrados");
                        for (int x = 0; x < 10; x++) {
                            if (alunos[x][0] == null) {
                                break;
                            }
                            ExibirDados(alunos, matriculaAlunos, x);
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
                                    ExibirDados(alunos, matriculaAlunos, x);
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
                                    ExibirDados(alunos, matriculaAlunos, x);
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

    public static int GeradorDeCodigo(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static void ImpedirRegistroVazio(String[][] matriz, String texto, int linha, int coluna) {
        while (matriz[linha][coluna] == "") {
            System.out.print("Este campo é obrigatório!\n" + texto);
            matriz[linha][coluna] = scanner.nextLine();
        }
        System.out.println();
    }

    public static void ExibirDados(String[][] matriz, long[] vetor, int linha) {
        System.out.println("Nome: " + matriz[linha][0]);
        System.out.println("Idade: " + matriz[linha][1]);
        System.out.println("Sexo: " + matriz[linha][2]);
        System.out.println("Curso: " + matriz[linha][3]);
        System.out.println("Matrícula: " + vetor[linha]);
        System.out.println("Código do usuário: " + matriz[linha][4] + "\n");
    }
}
