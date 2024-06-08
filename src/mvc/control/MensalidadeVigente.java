/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author lucas
 */
public class MensalidadeVigente {
    private static long serial;
    private long id;
    private BigDecimal valor;
    
    private LocalDate início;
    private LocalDate término;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private boolean pago;
    
    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        MensalidadeVigente.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getInício() {
        return início;
    }

    public void setInício(LocalDate início) {
        this.início = início;
    }

    public LocalDate getTérmino() {
        return término;
    }

    public void setTérmino(LocalDate término) {
        this.término = término;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    

    @Override
    public String toString() {
        return "MensalidadeVigente{" + "id=" + id + ", valor=" + valor + ", in\u00edcio=" + início + ", t\u00e9rmino=" + término + '}';
    }

    
    
}
