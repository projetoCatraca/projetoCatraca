import java.util.Scanner;
public class Menu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, horario = 800;
        String AQV;
        String[] aluno = new String[2];
        String[] coordenacao = new String[2];
        int id[] = new int[6];
        String[] motivo = new String[2];
        int matriculaAluno[] = new int[3];
        int matriculaFuncionario[] = new int[3];

        do {
            System.out.println("Menu Principal" + "\n\t1- Cadastro" + "\n\t2- Consulta" + "\n\t3- Sair");
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu){
                case 1:
                    for (int i = 0; i < aluno.length; i++) {
                            System.out.println("Nome do aluno: ");
                            aluno[i] = scanner.nextLine();
                            System.out.println("Olá, " + aluno[i] + ". Escreva o motivo do seu atraso.");
                            motivo[i] = scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("\nNomes dos Alunos:");
                    for (String nome : aluno) {
                        System.out.println(nome);
                    }

//                    if (nome != null) {
//                        System.out.println("Matrícula do aluno");
//                        matricula = scanner.nextInt();
//                        System.out.println("Olá, " + nome);
                        break;

                default:
                    System.out.println("Opção Inválida. Informa uma opção existente!");
            }
        } while (menu != 3);

        scanner.close();
    }
}
