package br.com.uam.apspoo.models;

import java.time.LocalDate;

/**
 * @author NycolasVieira
 */
public class Conta implements ContaInterface{
    private static int numero = 0;
    
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

    public void setSaldo(double saldo) throws Exception {
        if(saldo < 0){
            throw new Exception("Saldo não pode ser negativo");
        }
        
         this.saldo = saldo;
    }

    @Override
    public void depositar(double quantia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean debitar(double quantia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tranferir(Conta destino, double quantia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
