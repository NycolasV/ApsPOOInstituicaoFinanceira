package br.com.uam.apspoo.models;

import java.text.DecimalFormat;

/**
 * @author NycolasVieira
 */
public class ContaEspecial extends Conta implements ContaInterface {

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
        if (quantia <= 0) {
            throw new Exception("Quantia inválida!");
        }

        this.saldo += quantia;
        
        DecimalFormat df = new DecimalFormat("#.##");
        this.saldo = Double.parseDouble(df.format(this.saldo));
    }

    @Override
    public boolean debitar(double quantia) throws Exception {
        if (quantia <= 0) {
            throw new Exception("Quantia inválida!");
        }

        var saldoValidacao = this.saldo;
        var limiteValidacao = this.limite;
        if ((saldoValidacao -= quantia) < (limiteValidacao -= 2 * limite)) {
            throw new Exception("Saldo insulficiente!");
        }
        
        this.saldo -= quantia;
        
        DecimalFormat df = new DecimalFormat("#.##");
        this.saldo = Double.parseDouble(df.format(this.saldo));
        return true;
    }

    @Override
    public boolean tranferir(Conta destino, double quantia) {
        var saldoValidacao = this.saldo;
        var limiteValidacao = this.limite;
        if (quantia <= 0 
                || destino == null 
                || (saldoValidacao -= quantia) < (limiteValidacao -= 2 * limite))
            return false;

        this.saldo -= quantia;
        destino.saldo += quantia;
        
        DecimalFormat df = new DecimalFormat("#.##");
        this.saldo = Double.parseDouble(df.format(this.saldo));
        destino.saldo = Double.parseDouble(df.format(destino.saldo));
        return true;
    }

    @Override
    public String imprimir() {
        return "Nº: " + this.getNumero() + "\n"
                + "NOME: " + this.getCliente().getNome() + "\n"
                + "CPF: " + this.getCliente().getCpf() + "\n"
                + "DATA ABERTURA: " + this.getDataAbertura() + "\n"
                + "SALDO: " + this.getSaldo() + "\n"
                + "LIMITE: " + this.limite + "\n";
    }
}
