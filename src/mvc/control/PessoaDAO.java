/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import academia.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lucas
 */
public class PessoaDAO {
    
    
    public Pessoa adiciona(Pessoa pessoa) {

        String sql = "insert into pessoa "
                + "(nome,sexo,nascimento,login,senha,tipoUsuario,dataCriacao,dataModificacao)" + " values (?,?,?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setDate(3, java.sql.Date.valueOf(pessoa.getNascimento()));
            stmt.setString(4, pessoa.getLogin());
            stmt.setString(5, pessoa.getSenha());
            stmt.setInt(6, pessoa.getTipoUsuario());
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(pessoa.getDataCriacao()));
            stmt.setTimestamp(8, java.sql.Timestamp.valueOf(pessoa.getDataModificacao()));

            stmt.execute();

            System.out.println("Pessoa inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return pessoa;
    }

    public List<Pessoa> lista(Pessoa elemento) {
        String sql = "select * from pessoa";

        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String sexo = rs.getString("sexo");
                Date currentDate = rs.getDate("nascimento");
                LocalDate dataNascimento = currentDate.toLocalDate();
                
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                int tipoUsuario = rs.getInt("tipoUsuario");
                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();

                Pessoa pessoa = new Pessoa();

                pessoa.setId(id);
                pessoa.setNome(nome);
                pessoa.setSexo(sexo);
                pessoa.setNascimento(dataNascimento);
                //stmt.setDate(10, java.sql.Date.valueOf(mix.getDataAtual()));
                pessoa.setLogin(login);
                pessoa.setLogin(senha);
                pessoa.setTipoUsuario(tipoUsuario);
                pessoa.setDataCriacao(dataEHoraAtualModificacao);
                pessoa.setDataModificacao(dataEHoraAtualModificacao);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return pessoas;
    }

    public Pessoa exclui(Pessoa pessoa) {
        String sql = "delete from pessoa where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, pessoa.getId());

            stmt.execute();

            System.out.println("Pessoa excluída com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoa;
    }
    
        public Pessoa altera(Pessoa pessoa) {
        String sql = "update pessoa set nome = ?, sexo = ?, nascimento = ?, "
                + "login = ?, senha = ?, tipoUsuario = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setDate(3, java.sql.Date.valueOf(pessoa.getNascimento()));
            stmt.setString(4, pessoa.getLogin());
            stmt.setString(5, pessoa.getSenha());
            stmt.setInt(6, pessoa.getTipoUsuario());
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(pessoa.getDataModificacao()));
            stmt.setLong(8, pessoa.getId());
            
            stmt.execute();
            
            System.out.println("Pessoa alterada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoa;
    }
}


