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
        String text = "Número de clientes: " + listaCliente.size() + "\n\n";
        
        text = listaCliente.stream()
                .map((f) -> f.imprimir() + "--------------------------\n")
                .reduce(text, String::concat);
        
        return text;
    }
    
    public Cliente getCliente(String cpf){
        return listaCliente.stream().filter(s -> s.getCpf().equals(cpf)).findFirst().get();
    }
    
    public boolean existeCpf(Cliente cliente){        
        return listaCliente.stream().anyMatch((s) -> (s.getCpf().equals(cliente.getCpf())));
    }
}
