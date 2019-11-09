package br.com.uam.apspoo.models;

/**
 * @author NycolasVieira
 */
public class ContaEspecial extends Conta implements ContaInterface{
    
    private double limite;

    public ContaEspecial() {
    } 
    
    public ContaEspecial(Cliente cliente, double saldo) {
        super(cliente, saldo);
        this.limite = 1000;
    } 

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void depositar(double quantia) throws Exception {
        if(quantia <= 0)
            throw new Exception("Quantia inválida!");
        
        this.saldo += quantia;
    }

    @Override
    public boolean debitar(double quantia) throws Exception {
        if(quantia <= 0)
            throw new Exception("Quantia inválida!");
        
        var saldoValidacao = this.saldo;
        var limiteValidacao = this.limite;
        if((saldoValidacao -= quantia) < (limiteValidacao -= 2*limite))
            throw new Exception("Saldo insulficiente!");
        
        this.saldo -= quantia;
        return true;
    }

    @Override
    public boolean tranferir(Conta destino, double quantia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimir() {
        return  "Nº: " + this.getNumero() + "\n"
                + "NOME: " + this.getCliente().getNome() + "\n" 
                + "CPF: " + this.getCliente().getCpf() + "\n"
                + "DATA ABERTURA: " + this.getDataAbertura() + "\n"
                + "SALDO: " + this.getSaldo() + "\n"
                + "LIMITE: " + this.limite + "\n";
    }
}
