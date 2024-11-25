import java.util.Scanner;

public class Menu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, i = 0, j = 0;
        String AQV = "", aviso = "Não há espaço para cadastrar um novo usuário!";
        String[] alunos = new String[10];
        String[] coordenadores = new String[2];
        long[] matriculaAlunos = new long[10];
        long[] matriculaFuncionarios = new long[3];

        do {
            // Menu Principal
            System.out.println("Menu Principal \n\t1- Cadastro \n\t2- Consulta \n\t3- Sair");
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();
            scanner.nextLine();   // Limpar o buffer
            System.out.println(); // Espaço

            switch (menu){
                case 1:
                    // Menu Usuário
                    System.out.println("Você é: \n\t1- Aluno \n\t2- AQV \n\t3- Coordenador");
                    System.out.print("Escolha uma opção: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    if (escolha == 1) {
                        // Alunos
                        if (i < 10) {
                            System.out.println("Nome do Aluno");
                            alunos[i] = scanner.nextLine();

                            System.out.println("Matricula");
                            matriculaAlunos[i] = scanner.nextLong();

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
                    }
                    else {
                        System.out.println("Opção Inválida! Informa uma opção existente.");
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("\tAlunos Cadastrados");
                    for (int x = 0; x < 10; x++) {
                        if (alunos[x] == null) {
                            break;
                        }
                        System.out.println("Nome: " + alunos[x]);
                        System.out.println("Matrícula: " + matriculaAlunos[x]);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção Inválida! Informa uma opção existente.");
                    System.out.println();
            }
        } while (menu != 3);

        scanner.close();
    }
}
