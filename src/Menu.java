import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        String nome, motivo, aluno = "Andre Gondek", matricula = String.valueOf(3976);
        double horario = 800;

        System.out.println("Menu Principal" + "\n\t1- Cadastro" + "\n\t2- Consulta");
        menu = scanner.nextInt();
        scanner.nextLine();

        if (menu == 1) {
            System.out.println("Nome do aluno: ");
            nome = scanner.nextLine();
            System.out.println("Olá, " + nome + ". Escreva o motivo do seu atraso.");
            motivo = scanner.nextLine();
        } else if (menu == 2) {
            System.out.println("Matrícula do aluno");
            matricula = scanner.nextLine();
            matricula = aluno;
            System.out.println("Olá, " + aluno + ". Escreva o motivo do seu atraso.");
            motivo = scanner.nextLine();
        } else {
            System.out.println("Selecione uma opção entre os números 1 e 2.");

        }
    }
}
