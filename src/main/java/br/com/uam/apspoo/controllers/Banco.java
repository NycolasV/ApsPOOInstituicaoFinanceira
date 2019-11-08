package br.com.uam.apspoo.controllers;

import br.com.uam.apspoo.models.*;
import java.util.ArrayList;

/**
 * @author NycolasVieira
 */
public class Banco {
    private final ArrayList<Conta> listaConta;

    public Banco() {
        this.listaConta = new ArrayList<>();
    }

    public ArrayList<Conta> getListaConta() {
        return listaConta;
    }
    
    public void adicionar(Conta conta){
        if(conta == null)
            return;
        
        listaConta.add(conta);
    }
    
    public String listar(){
        return null;
    }
    
    public String pesquisar(int numero){
        return null;
    }
    
    public Conta getConta(int numero){
        return null;
    }
    
    public boolean remover(int numero){
        return false;
    }
}
