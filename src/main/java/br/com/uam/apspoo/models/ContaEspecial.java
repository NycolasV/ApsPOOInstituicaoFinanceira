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
        return  "Nº: " + this.getNumero() + "\n"
                + "NOME: " + this.getCliente().getNome() + "\n" 
                + "CPF: " + this.getCliente().getCpf() + "\n"
                + "DATA ABERTURA: " + this.getDataAbertura() + "\n"
                + "SALDO: " + this.getSaldo() + "\n"
                + "LIMITE: " + this.limite + "\n";
    }
}
