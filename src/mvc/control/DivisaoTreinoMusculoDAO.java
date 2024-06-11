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
public class DivisaoTreinoMusculoDAO {

        public DivisaoTreinoMusculo adiciona(DivisaoTreinoMusculo aplicacao) {

        String sql = "insert into divisaotreinomusculo"
                + "(descricao,divisaoTreino,dataCriacao,dataModificacao)" + " values (?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, aplicacao.getDescricao());
            stmt.setLong(2, aplicacao.getDivisaoDeTreino().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(aplicacao.getDataCriacao()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(aplicacao.getDataModificacao()));

            stmt.execute();

            System.out.println("Divisão de Treino Musculo inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //na verdade deveria retornar o elemento que foi inserido agora
        return aplicacao;
    }

    public List<DivisaoTreinoMusculo> lista(DivisaoTreinoMusculo divTreinoMusculo) {
        String sql = "select * from exercicioaplicacao";

        List<DivisaoTreinoMusculo> aplicacoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String descricao = rs.getString("descricao");
                Timestamp currentDateTimeC = rs.getTimestamp("dataCriacao");
                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                
                LocalDateTime dataEHoraAtualCriacao = currentDateTimeC.toLocalDateTime();
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();

                DivisaoTreinoMusculo aplicacao = new DivisaoTreinoMusculo();

                aplicacao.setId(id);
                aplicacao.setDescricao(descricao);
                aplicacao.setDataModificacao(dataEHoraAtualModificacao);
                aplicacao.setDataCriacao(dataEHoraAtualCriacao);
                
                aplicacoes.add(aplicacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return aplicacoes;
    }

    public Exercicio_Aplicacao exclui(Exercicio_Aplicacao aplicacao) {
        String sql = "delete from exercicioaplicacao where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, aplicacao.getId());

            stmt.execute();

            System.out.println("Exercicio aplicacao excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aplicacao;
    }
    
        public Exercicio_Aplicacao altera(Exercicio_Aplicacao aplicacao) {
        String sql = "update exercicioaplicacao set descricao = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, aplicacao.getDescricao());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(aplicacao.getDataModificacao()));
            stmt.setLong(3, aplicacao.getId());
            
            stmt.execute();
            
            System.out.println("Exercício Aplicação alterado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aplicacao;
    }
}
