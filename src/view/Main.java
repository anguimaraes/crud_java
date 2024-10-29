package view;

import controller.PessoaController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        PessoaController pessoaController = new PessoaController();
        pessoaController.criarPessoa(nome, endereco);

        scanner.close();
    }
}