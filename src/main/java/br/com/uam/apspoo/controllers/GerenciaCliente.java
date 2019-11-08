package br.com.uam.apspoo.controllers;

import br.com.uam.apspoo.models.*;
import java.util.ArrayList;

/**
 * @author NycolasVieira
 */
public class GerenciaCliente {
    private final ArrayList<Cliente> listaCliente;

    public GerenciaCliente() {
        this.listaCliente = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }
    
    public void adicionar(Cliente cliente){
        if(cliente == null)
            return;
        
        listaCliente.add(cliente);
    }
    
    public String listar(){
        return null;
    }
    
    public boolean existeCpf(Cliente cliente){
        return false;
    }
}
