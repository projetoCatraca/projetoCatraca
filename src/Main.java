import java.util.Scanner;
import java.util.Random;

public class Main {
    static long[] codigosDeUsuario = new long[13];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, escolha, i = 0, j = 1;
        String aviso = "Não há espaço para cadastrar um novo usuário!";
        String[][] alunos = new String[10][4];
        String[][] funcionarios = new String[3][3];
        long[] matriculaAlunos = new long[10];
        long[] matriculaFuncionarios = new long[3];

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
                            scanner.nextLine();

                            gerarCodigo(i);

                            i++;
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

                            gerarCodigo(10);

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

                            gerarCodigo(j+10);

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
                    if (alunos[0][0] != null) {
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
                            System.out.println("Código de usuário: " + codigosDeUsuario[x]);
                            System.out.println();
                        }
                    } else {
                        System.out.println("Ainda não há alunos cadastrados!\n");
                    }
                    break;

                // Busca
                case 3:
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
                                    System.out.println("Código do usuário: " + codigosDeUsuario[x]);
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
                                    System.out.println("Código do usuário: " + codigosDeUsuario[x]);
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
                    } else {
                        System.out.println("Ainda não há alunos cadastrados!\n");
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
}
