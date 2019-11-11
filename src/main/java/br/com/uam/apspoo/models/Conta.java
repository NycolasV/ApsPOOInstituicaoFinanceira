package br.com.uam.apspoo.models;

import java.time.LocalDate;

/**
 * @author NycolasVieira
 */
public class Conta implements ContaInterface{
    private static int numeroConta = 1;
    
    private int numero;
    
    private Cliente cliente;
    
    private LocalDate dataAbertura;
    
    protected double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente, double saldo) {
        this.numero = numeroConta++;
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

    public void setSaldo(double saldo) throws Exception {
        if(saldo < 0)
            throw new Exception("Saldo não pode ser negativo");
        
         this.saldo = saldo;
    }

    @Override
    public void depositar(double quantia) throws Exception{
        if(quantia <= 0)
            throw new Exception("Quantia inválida!");
        
        this.saldo += quantia;
    }

    @Override
    public boolean debitar(double quantia) throws Exception {
        if(quantia <= 0)
            throw new Exception("Quantia inválida!");
        
        var saldoValidacao = this.saldo;
        if((saldoValidacao -= quantia) < 0)
            throw new Exception("Saldo insulficiente!");
        
        this.saldo -= quantia;
        return true;
    }

    @Override
    public boolean tranferir(Conta destino, double quantia) {
        var saldoValidacao = this.saldo;
        if(quantia <= 0 
                || destino == null 
                || (saldoValidacao -= quantia) < 0)
            return false;
        
        this.saldo -= quantia;
        destino.saldo += quantia;
        return true;
    }

    @Override
    public String imprimir() {        
        return  "Nº: " + this.numero + "\n"
                + "NOME: " + this.cliente.getNome() + "\n" 
                + "CPF: " + this.cliente.getCpf() + "\n"
                + "DATA ABERTURA: " + this.dataAbertura + "\n"
                + "SALDO: " + this.saldo + "\n";
    }
}
