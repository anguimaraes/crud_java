package controller;

import dao.PessoaDAO;
import model.Pessoa;

public class PessoaController {
    private PessoaDAO pessoaDAO;

    public PessoaController() {
        this.pessoaDAO = new PessoaDAO();
    }

    public void criarPessoa(String nome, String endereco) {
        Pessoa pessoa = new Pessoa(nome, endereco);
        pessoaDAO.inserirPessoa(pessoa);
    }
}