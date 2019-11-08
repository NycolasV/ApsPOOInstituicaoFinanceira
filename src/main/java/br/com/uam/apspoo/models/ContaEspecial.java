package br.com.uam.apspoo.models;

/**
 * @author NycolasVieira
 */
public class ContaEspecial extends Conta{
    
    private double limite;

    public ContaEspecial(Cliente cliente, double saldo) {
        super(cliente, saldo);
        this.limite = 100;
    } 

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
