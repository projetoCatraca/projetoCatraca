import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, escolha, i = 0, j = 1;
        String aviso = "Não há espaço para cadastrar um novo usuário!";
        String[][] alunos = new String[10][5];
        String[][] funcionarios = new String[3][4];
        long[] matriculaAlunos = new long[10];
        long[] matriculaFuncionarios = new long[3];

        do {
            // Menu Principal
            System.out.println("""
                            -- Menu Principal --
                            ____________________
                            |Você é:           |
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
                case 1:
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

                    if (escolha == 1) {
                        // Alunos
                        if (i < 10) {
                            System.out.println("-- Cadastro do Aluno --");
                            System.out.print("Nome do Aluno: ");
                            alunos[i][0] = scanner.nextLine();

                            System.out.print("Idade do Aluno: ");
                            alunos[i][1] = scanner.nextLine();

                            System.out.print("Sexo do Aluno: ");
                            alunos[i][2] = scanner.nextLine();

                            System.out.print("Curso do Aluno: ");
                            alunos[i][3] = scanner.nextLine();

                            System.out.print("Matricula: ");
                            matriculaAlunos[i] = scanner.nextLong();

                            alunos[i][4] = gerador(100, 100000) + "";
                            for (int x = 0; x < 10; x++) {
                                if (x != i) {
                                    if (alunos[i][4] == alunos[x][4]) {
                                        alunos[i][4] = (Integer.parseInt(alunos[i][4]) + 1) + "";
                                        x = 0;
                                    }
                                }
                            }
                            System.out.println("Código do usuário: " + alunos[i][4]);

                            i++;
                            scanner.nextLine();
                            System.out.println();
                        } else {
                            System.out.println(aviso);
                            System.out.println();
                        }
                    } else if (escolha == 2) {
                        // AQV
                        if (funcionarios[0][0] == null) {
                            System.out.println("-- Cadastro do AQV --");
                            System.out.print("Nome da(o) Analista de Qualidade de Vida (AQV): ");
                            funcionarios[0][0] = scanner.nextLine();

                            System.out.print("Idade: ");
                            funcionarios[0][1] = scanner.nextLine();

                            System.out.print("Sexo: ");
                            funcionarios[0][2] = scanner.nextLine();

                            System.out.print("Matricula: ");
                            matriculaFuncionarios[0] = scanner.nextLong();
                            scanner.nextLine();

                            funcionarios[0][3] = gerador(100, 100000) + "";
                            for (int x = 0; x < 3; x++) {
                                if (x != 0) {
                                    if (funcionarios[x][3] == funcionarios[0][3]) {
                                        funcionarios[0][3] = (Integer.parseInt(funcionarios[0][3]) + 1) + "";
                                        x = 0;
                                    }
                                }
                            }
                            System.out.println("Código do usuário: " + funcionarios[i][3]);

                            System.out.println();
                        } else {
                            System.out.println(aviso);
                            System.out.println();
                        }
                    } else if (escolha == 3) {
                        // Coordenadores
                        if (j < 3) {
                            System.out.println("-- Cadastro de Coordenador --");
                            System.out.print("Nome: ");
                            funcionarios[j][0] = scanner.nextLine();

                            System.out.print("Idade: ");
                            funcionarios[j][1] = scanner.nextLine();

                            System.out.print("Sexo: ");
                            funcionarios[j][2] = scanner.nextLine();

                            System.out.print("Matricula: ");
                            matriculaFuncionarios[j] = scanner.nextLong();
                            scanner.nextLine();

                            funcionarios[j][3] = gerador(100, 100000) + "";
                            for (int x = 0; x < 3; x++) {
                                if (x != j) {
                                    if (funcionarios[j][3] == funcionarios[x][3]) {
                                        funcionarios[j][3] = (Integer.parseInt(funcionarios[j][3]) + 1) + "";
                                        x = 0;
                                    }
                                }
                            }
                            System.out.println("Código do usuário: " + funcionarios[j][3]);

                            j++;
                            System.out.println();
                        } else {
                            System.out.println(aviso);
                            System.out.println();
                        }
                    } else {
                        System.out.println("Opção Inválida! Informa uma opção existente.");
                        System.out.println();
                    }
                    break;

                // Consulta
                case 2:
                    System.out.println("-- Consulta de alunos cadastrados --");
                    for (int x = 0; x < 10; x++) {
                        if (alunos[x][0] == null) {
                            break;
                        }
                        System.out.println("Nome: " + alunos[x][0]);
                        System.out.println("Idade: " + alunos[x][1]);
                        System.out.println("Sexo: " + alunos[x][2]);
                        System.out.println("Curso: " + alunos[x][3]);
                        System.out.println("Matrícula: " + matriculaAlunos[x]);
                        System.out.println("Código de usuário: " + alunos[x][4]);
                        System.out.println();
                    }
                    break;

                // Busca
                case 3:
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

                    // Busca pelo nome
                    if (escolha == 1) {
                        System.out.print("Digite o nome do aluno: ");
                        String nomebusca = scanner.nextLine();
                        boolean encontrado = false;

                        for (int x = 0; x < 10; x++) {
                            if (nomebusca.equals(alunos[x][0])) {
                                System.out.println("Aluno encontrado!");
                                System.out.println("Nome: " + alunos[x][0]);
                                System.out.println("Idade: " + alunos[x][1]);
                                System.out.println("Sexo: " + alunos[x][2]);
                                System.out.println("Curso: " + alunos[x][3]);
                                System.out.println("Matrícula: " + matriculaAlunos[x]);
                                System.out.println("Código do usuário: " + alunos[x][4]);
                                System.out.println();
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
                                System.out.println("Nome: " + alunos[x][0]);
                                System.out.println("Idade: " + alunos[x][1]);
                                System.out.println("Sexo: " + alunos[x][2]);
                                System.out.println("Curso: " + alunos[x][3]);
                                System.out.println("Matrícula: " + matriculaAlunos[x]);
                                System.out.println("Código do usuário: " + alunos[x][4]);
                                System.out.println();
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Aluno não encontrado!");
                        }

                    } else {
                        System.out.println("Opção Inválida! Informa uma opção existente.");
                        System.out.println();
                    }
                    break;

                // Encerramento do Programa
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção Inválida! Informa uma opção existente.");
                    System.out.println();
            }
        } while (menu != 4);

        scanner.close();
    }

    public static int gerador(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
