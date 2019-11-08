package br.com.uam.apspoo.models;

/**
 * @author NycolasVieira
 */
public interface ContaInterface { 
    public void depositar(double quantia);
    
    public boolean debitar(double quantia);
    
    public boolean tranferir(Conta destino, double quantia);
    
    public void imprimir();
}
