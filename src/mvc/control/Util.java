/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author lucas
 */
public class Util {
    
    private static Pessoa pessoaLogada = null;
    
    private static LocalDateTime diaAtual = LocalDateTime.of(2023, Month.MARCH, 01, 22, 05);

    public static Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public static void setPessoaLogada(Pessoa pessoaLogada) {
        Util.pessoaLogada = pessoaLogada;
    }

    public static LocalDateTime getDiaAtual() {
        return diaAtual;
    }
    
    public static int getDiaDoMes() {
        return diaAtual.getDayOfMonth();
    }

    public static void incrementaDias(int dias) {
        diaAtual.plusDays(dias);
    }
    
    public static void incrementaMes(int numeroMeses) {
        diaAtual.plusMonths(numeroMeses);
    }
}
