import java.util.Scanner;
public class Menu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, matricula, horario = 800;
        String nome = null, motivo;

        do {
            System.out.println("Menu Principal" + "\n\t1- Cadastro" + "\n\t2- Consulta" + "\n\t3- Sair");
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu){
                case 1:
                    System.out.println("Nome do aluno: ");
                    nome = scanner.nextLine();
                    System.out.println("Olá, " + nome + ". Escreva o motivo do seu atraso.");
                    motivo = scanner.nextLine();
                    break;
                case 2:
                    if (nome != null) {
                        System.out.println("Matrícula do aluno");
                        matricula = scanner.nextInt();
                        System.out.println("Olá, " + nome);
                        break;
                    }
                default:
                    System.out.println("Opção Inválida. Informa uma opção existente!");
            }
        } while (menu != 3);

        scanner.close();
    }
}
