package dao;

import model.Pessoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
