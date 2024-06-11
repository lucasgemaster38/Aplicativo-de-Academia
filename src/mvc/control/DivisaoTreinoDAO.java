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
public class DivisaoTreinoDAO {
 
        public DivisaoTreino adiciona(DivisaoTreino divTreino) {

        String sql = "insert into divisaotreino "
                + "(nome,descricao,quantidade,dataCriacao,dataModificacao)" + " values (?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, divTreino.getNome());
            stmt.setString(2, divTreino.getDescricao());
            stmt.setInt(3, divTreino.getQuantidade());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(divTreino.getDataCriacao()));
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(divTreino.getDataModificacao()));
            
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
                int quantidade = rs.getInt("quantidade");
                Timestamp currentDateTimeC = rs.getTimestamp("dataCriacao");
                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                
                LocalDateTime dataEHoraAtualCriacao = currentDateTimeC.toLocalDateTime();
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();

                DivisaoTreino divTreino = new DivisaoTreino();

                divTreino.setId(id);
                divTreino.setNome(nome);
                divTreino.setDescricao(descricao);
                divTreino.setQuantidade(quantidade);
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
        String sql = "update divisaotreino set nome = ?, descricao = ?, quantidade = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, divTreino.getNome());
            stmt.setString(2, divTreino.getDescricao());
            stmt.setInt(3, divTreino.getQuantidade());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(divTreino.getDataModificacao()));
            stmt.setLong(5, divTreino.getId());
            
            stmt.execute();
            
            System.out.println("Divisão de Treino alterada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divTreino;
    }
        
    public DivisaoTreino buscaPorId(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = createPreparedStatement(connection, code);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                Timestamp currentDateTimeC = rs.getTimestamp("dataCriacao");
                Timestamp currentDateTimeM = rs.getTimestamp("dataModificacao");
                
                LocalDateTime dataEHoraAtualCriacao = currentDateTimeC.toLocalDateTime();
                LocalDateTime dataEHoraAtualModificacao = currentDateTimeM.toLocalDateTime();
                
                DivisaoTreino divTreino = new DivisaoTreino();
                
                divTreino.setId(id);
                divTreino.setNome(nome);
                divTreino.setDescricao(descricao);
                divTreino.setQuantidade(quantidade);
                divTreino.setDataModificacao(dataEHoraAtualModificacao);
                divTreino.setDataCriacao(dataEHoraAtualCriacao);
                
                return divTreino;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from divisaotreino where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
    
}
