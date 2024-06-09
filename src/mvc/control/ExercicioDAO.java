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
public class ExercicioDAO {
    
 
    public Exercicio adiciona(Exercicio exercicio) {

        String sql = "insert into exercicio "
                + "(nome,descricao,dataCriacao,dataModificacao)" + " values (?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(exercicio.getDataCriacao()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(exercicio.getDataModificacao()));

            stmt.execute();

            System.out.println("Exercicio inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return exercicio;
    }

    public List<Exercicio> lista(Exercicio ex) {
        String sql = "select * from exercicio";

        List<Exercicio> exercicios = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Timestamp currentDateTimeC = rs.getTimestamp("dataCriacao");
                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                
                LocalDateTime dataEHoraAtualCriacao = currentDateTimeC.toLocalDateTime();
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();

                Exercicio exercicio = new Exercicio();

                exercicio.setId(id);
                exercicio.setDescricao(descricao);
                exercicio.setDataModificacao(dataEHoraAtualModificacao);
                exercicio.setDataCriacao(dataEHoraAtualCriacao);
                
                exercicios.add(exercicio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return exercicios;
    }

    public Exercicio exclui(Exercicio exercicio) {
        String sql = "delete from exercicio where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, exercicio.getId());

            stmt.execute();

            System.out.println("Exercicio excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exercicio;
    }
    
        public Exercicio altera(Exercicio exercicio) {
        String sql = "update exercicio set nome = ?, descricao = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(exercicio.getDataCriacao()));
            stmt.setLong(4, exercicio.getId());
            
            stmt.execute();
            
            System.out.println("Exercício alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exercicio;
    }
    
}
