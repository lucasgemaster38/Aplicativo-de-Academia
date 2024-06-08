/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.time.LocalDate;

/**
 *
 * @author lucas
 */
public class MensalidadeVigenteDAO {
    private MensalidadeVigente[] mensalidades = new MensalidadeVigente[100];
    
    public LocalDate calcularDataPagamento(int indice, LocalDate dataInicio) {
        
        if (mensalidades[indice] == null || mensalidades[indice].isPago()) {
            return null; // Retorna null se a mensalidade não existir ou já estiver paga
        }
        LocalDate dataVencimento = mensalidades[indice].getTérmino();
        
        int ultimoDiaMes = dataVencimento.lengthOfMonth();
        LocalDate dataPagamento = LocalDate.of(dataVencimento.getYear(), dataVencimento.getMonth(), ultimoDiaMes);

        if (dataPagamento.isBefore(dataInicio)) {
            return dataInicio;
        }

        return dataPagamento;
    }
}
