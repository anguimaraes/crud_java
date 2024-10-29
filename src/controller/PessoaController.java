package controller;

import dao.PessoaDAO;
import model.Pessoa;

import java.util.List;

public class PessoaController {
    private PessoaDAO pessoaDAO;

    public PessoaController() {
        this.pessoaDAO = new PessoaDAO();
    }

    public void criarPessoa(String nome, String endereco) {
        Pessoa pessoa = new Pessoa(nome, endereco);
        pessoaDAO.inserirPessoa(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaDAO.listarPessoas();
    }

    public void atualizarPessoa(int id, String nome, String endereco) {
        pessoaDAO.atualizarPessoa(id, nome, endereco);
    }
}