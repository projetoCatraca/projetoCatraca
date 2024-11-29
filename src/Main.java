import java.util.Scanner;

// Adicionar a busca - por nome ou matricula
// id de cada usuário

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, escolha, i = 0, j = 0;
        String AQV = "", aviso = "Não há espaço para cadastrar um novo usuário!";
        String[][] alunos = new String[10][5];
        String[] coordenadores = new String[2];
        long[] matriculaAlunos = new long[10];
        long[] matriculaFuncionarios = new long[3];
        boolean teste = false;

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

                            System.out.println("Idade do Aluno");
                            alunos[i][1] = scanner.nextLine();

                            System.out.println("Sexo do Aluno");
                            alunos[i][2] = scanner.nextLine();

                            System.out.println("Curso do Aluno");
                            alunos[i][3] = scanner.nextLine();

                            System.out.println("Matricula");
                            matriculaAlunos[i] = scanner.nextLong();

                            alunos[i][4] = (matriculaAlunos[i]*3 + (Integer.parseInt(alunos[i][1]))*2 + matriculaAlunos[i]*2 + "");
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
                        if (AQV == "") {
                            System.out.println("Nome da(o) Analista de Qualidade de Vida (AQV)");
                            AQV = scanner.nextLine();

                            System.out.println("Matricula");
                            matriculaFuncionarios[0] = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println();
                        } else {
                            System.out.println(aviso);
                            System.out.println();
                        }
                    } else if (escolha == 3) {
                        // Coordenadores
                        if (j < 2) {
                            System.out.println("Nome");
                            coordenadores[j] = scanner.nextLine();

                            System.out.println("Matricula");
                            matriculaFuncionarios[j + 1] = scanner.nextLong();

                            j++;
                            scanner.nextLine();
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
                    System.out.println("\tAlunos Cadastrados");
                    for (int x = 0; x < 10; x++) {
                        if (alunos[x][0] == null) {
                            break;
                        }
                        System.out.println("Nome: " + alunos[x][0]);
                        System.out.println("Matrícula: " + matriculaAlunos[x]);
                        System.out.println();
                    }
                    break;

                // Busca
                case 3:
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
}
