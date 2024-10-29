package view;

import controller.PessoaController;
import model.Pessoa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaController pessoaController = new PessoaController();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Listar pessoas");
            System.out.println("3. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();

                    pessoaController.criarPessoa(nome, endereco);
                    break;
                case 2:
                    List<Pessoa> pessoas = pessoaController.listarPessoas();
                    System.out.println("\nLista de Pessoas:");
                    for (Pessoa pessoa : pessoas) {
                        System.out.println("Nome: " + pessoa.getNome() + ", Endereço: " + pessoa.getEndereco());
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}