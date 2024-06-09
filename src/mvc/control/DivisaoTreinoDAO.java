/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import academia.ConnectionFactory;
import java.sql.Connection;
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
public class DivisaoTreinoDAO {
 
        public DivisaoTreino adiciona(DivisaoTreino divTreino) {

        String sql = "insert into divisaotreino "
                + "(nome,descricao,dataCriacao,dataModificacao)" + " values (?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, divTreino.getNome());
            stmt.setString(2, divTreino.getDescricao());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(divTreino.getDataCriacao()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(divTreino.getDataModificacao()));
            
            stmt.execute();

            System.out.println("Divisão de Treino inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return divTreino;
    }

    public List<DivisaoTreino> lista(DivisaoTreino dt) {
        String sql = "select * from divisaotreino";

        List<DivisaoTreino> divisoesTreino = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Timestamp currentDateTimeC = rs.getTimestamp("dataCriacao");
                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                
                LocalDateTime dataEHoraAtualCriacao = currentDateTimeC.toLocalDateTime();
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();

                DivisaoTreino divTreino = new DivisaoTreino();

                divTreino.setId(id);
                divTreino.setNome(nome);
                divTreino.setDescricao(descricao);
                divTreino.setDataModificacao(dataEHoraAtualModificacao);
                divTreino.setDataCriacao(dataEHoraAtualCriacao);
                
                divisoesTreino.add(divTreino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return divisoesTreino;
    }

    public DivisaoTreino exclui(DivisaoTreino divTreino) {
        String sql = "delete from divisaotreino where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, divTreino.getId());

            stmt.execute();

            System.out.println("Divisão de Treino excluída com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divTreino;
    }
    
        public DivisaoTreino altera(DivisaoTreino divTreino) {
        String sql = "update divisaotreino set nome = ?, descricao = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, divTreino.getNome());
            stmt.setString(2, divTreino.getDescricao());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(divTreino.getDataModificacao()));
            stmt.setLong(4, divTreino.getId());
            
            stmt.execute();
            
            System.out.println("Divisão de Treino alterada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divTreino;
    }
    
}
