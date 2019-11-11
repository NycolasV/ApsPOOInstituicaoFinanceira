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
        String textoLista = "Número de contas: " + listaConta.size() + "\n\n";
        
        textoLista = listaConta.stream()
                .filter((s) -> !(s instanceof ContaEspecial))
                .map((s) -> s.imprimir() + "--------------------------\n")
                .reduce(textoLista, String::concat);
        
        textoLista = listaConta.stream()
                .filter((s) -> s instanceof ContaEspecial)
                .map((s) -> s.imprimir() + "--------------------------\n")
                .reduce(textoLista, String::concat);
        
        return textoLista;
    }
    
    public String pesquisar(int numero) throws Exception{
        if(numero <= 0)
            throw new Exception("Entrada inválida");
                
        return listaConta.stream().filter(s -> s.getNumero() == numero).map((s) -> s.imprimir()).findFirst().get();
    }
    
    public Conta getConta(int numero) throws Exception{
        if(numero <= 0)
            throw new Exception("Entrada inválida");
                
        return listaConta.stream().filter(s -> s.getNumero() == numero).findFirst().get();
    }
    
    public void setConta(Conta conta) {
        listaConta.stream().filter(s -> s.getNumero() == conta.getNumero()).forEach((s) -> s = conta);
    }
    
    public boolean remover(int numero){
        try{
            var conta = getConta(numero);
            
            if(conta.getSaldo() != 0)
                return false;
                
            return listaConta.remove(conta);
        } catch(Exception ex){
            return false;
        }
    }
}
