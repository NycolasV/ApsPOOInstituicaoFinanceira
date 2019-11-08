package br.com.uam.apspoo.factory;

import br.com.uam.apspoo.controllers.*;
import br.com.uam.apspoo.models.*;
import javax.swing.JOptionPane;

/**
 * @author NycolasVieira
 */
public class MenuFactory {
    private final Banco banco;
    private final GerenciaCliente gerenciaCliente;
    
    public MenuFactory() {
         this.banco = new Banco();
         this.gerenciaCliente = new GerenciaCliente();
    }

    public void cadastrarCliente(){
        Cliente cliente = new Cliente();
        
        try{
           cliente.setNome(JOptionPane.showInputDialog(null, "Informe o nome:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE));
           cliente.setCpf(JOptionPane.showInputDialog(null, "Informe o cpf:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE));
           cliente.setTelefone(JOptionPane.showInputDialog(null, "Informe o telefone:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE));   
        } catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        gerenciaCliente.adicionar(cliente);
        JOptionPane.showMessageDialog(null, cliente.imprimir(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
}
