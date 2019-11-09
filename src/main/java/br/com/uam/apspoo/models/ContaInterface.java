package br.com.uam.apspoo.models;

/**
 * @author NycolasVieira
 */
public interface ContaInterface { 
    public void depositar(double quantia) throws Exception;
    
    public boolean debitar(double quantia) throws Exception;
    
    public boolean tranferir(Conta destino, double quantia) throws Exception;
    
    public String imprimir();
}
