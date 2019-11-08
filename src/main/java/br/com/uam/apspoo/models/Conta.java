package br.com.uam.apspoo.models;

import java.time.LocalDate;

/**
 * @author NycolasVieira
 */
public class Conta {
    private static int numero = 1;
    
    private Cliente cliente;
    
    private LocalDate dataAbertura;
    
    protected double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente, double saldo) {
        this.numero++;
        this.cliente = cliente;
        this.dataAbertura = LocalDate.now();
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
         this.saldo = saldo;
    }
}
