package br.com.uam.apspoo.factory;

import br.com.uam.apspoo.controllers.*;
import br.com.uam.apspoo.models.*;
import java.awt.HeadlessException;
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

    public void cadastrarCliente() {
        Cliente cliente = new Cliente();

        try {
            cliente.setNome(JOptionPane.showInputDialog(null, "Informe o nome:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE));
            cliente.setCpf(JOptionPane.showInputDialog(null, "Informe o CPF:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE));
            cliente.setTelefone(JOptionPane.showInputDialog(null, "Informe o telefone:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (gerenciaCliente.existeCpf(cliente)) {
            JOptionPane.showMessageDialog(null, "CPF informado já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        gerenciaCliente.adicionar(cliente);
        JOptionPane.showMessageDialog(null, cliente.imprimir(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cadastrarConta() {
        int eContaEspecial = JOptionPane.showConfirmDialog(null, "Deseja criar uma conta especial?");

        Conta conta;
        try {
            Cliente cliente = gerenciaCliente.getCliente(JOptionPane.showInputDialog(null, "Informe o CPF do Cliente: ", "Cadastro de Conta", JOptionPane.QUESTION_MESSAGE));
            double saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o saldo inicial: ", "Cadastro de Conta", JOptionPane.QUESTION_MESSAGE));

            switch (eContaEspecial) {
                case JOptionPane.YES_OPTION:
                    conta = new ContaEspecial(cliente, saldo);
                    break;

                case JOptionPane.NO_OPTION:
                    conta = new Conta(cliente, saldo);
                    break;

                default:
                    return;
            }
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        banco.adicionar(conta);
        JOptionPane.showMessageDialog(null, conta.imprimir(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void listarClasse(String tipoLista){
        switch(tipoLista){
            case "conta":
                JOptionPane.showMessageDialog(null, banco.listar(), "Lista de Contas", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "cliente":
                JOptionPane.showMessageDialog(null, gerenciaCliente.listar(), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
                break;
            
            default:
                break;
        }
    }
}
