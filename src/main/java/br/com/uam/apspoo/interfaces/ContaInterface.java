package br.com.uam.apspoo.interfaces;

import br.com.uam.apspoo.models.Conta;

/**
 * @author NycolasVieira
 */
public interface ContaInterface { 
    public void depositar(double quantia) throws Exception;
    
    public boolean debitar(double quantia) throws Exception;
    
    public boolean tranferir(Conta destino, double quantia) throws Exception;
    
    public String imprimir();
}
