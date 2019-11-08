package br.com.uam.apspoo.models;

/**
 * @author NycolasVieira
 */
public class ContaEspecial extends Conta implements ContaInterface{
    
    private double limite;

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
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
