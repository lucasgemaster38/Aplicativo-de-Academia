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
public class Academia1DAO {

    public Academia1 adiciona(Academia1 a) {

        String sql = "insert into academia "
                + "(nome,endereco,dataCriacao,dataModificacao)" + " values (?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEndereco());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDataCriacao()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(a.getDataCriacao()));

            stmt.execute();

            System.out.println("Academia inserida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return a;

    }

    public List<Academia1> lista(Academia1 elemento) {
        String sql = "select * from academia";

        List<Academia1> academias = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                Timestamp currentDateTimeC = rs.getTimestamp("dataCriacao");
                LocalDateTime dataEHoraAtualCriacao = currentDateTimeC.toLocalDateTime();

                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();

                Academia1 academia = new Academia1();

                academia.setId(id);
                academia.setNome(nome);
                academia.setEndereco(endereco);
                academia.setDataCriacao(dataEHoraAtualCriacao);
                academia.setDataModificacao(dataEHoraAtualModificacao);
                academias.add(academia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return academias;
    }

    public Academia1 exclui(Academia1 academia) {
        String sql = "delete from academia where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, academia.getId());

            stmt.execute();

            System.out.println("Academia excluída com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return academia;
    }
    
        public Academia1 altera(Academia1 academia) {
        String sql = "update academia set nome = ?, endereco = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, academia.getNome());
            stmt.setString(2, academia.getEndereco());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(academia.getDataModificacao()));
            stmt.setLong(4, academia.getId());
            
            stmt.execute();
            
            System.out.println("Academia alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return academia;
    }
}
