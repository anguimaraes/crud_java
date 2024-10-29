package dao;

import model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/crud_java";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public void inserirPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, endereco) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEndereco());

            stmt.executeUpdate();
            System.out.println("Pessoa inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Metodo para listar todas as pessoas
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                pessoas.add(new Pessoa(nome, endereco));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }
}
