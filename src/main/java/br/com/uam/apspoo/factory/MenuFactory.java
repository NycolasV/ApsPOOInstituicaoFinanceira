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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        banco.adicionar(conta);
        JOptionPane.showMessageDialog(null, conta.imprimir(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void listar(String tipoLista) {
        switch (tipoLista) {
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

    public void informarNumeroConta(String tipoPesquisa) {
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Nº da Conta:", "Pesquisa Número Conta", JOptionPane.QUESTION_MESSAGE));

            switch (tipoPesquisa) {
                case "pesquisarConta":
                    JOptionPane.showMessageDialog(null, banco.pesquisar(numero), "Conta Pesquisada", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "depositar":
                    Conta contaDeposito = banco.getConta(numero);
                    contaDeposito.depositar(Double.parseDouble(JOptionPane.showInputDialog(null, "Valor a ser depositado:", "Depósito", JOptionPane.QUESTION_MESSAGE)));
                    banco.setConta(contaDeposito);

                    JOptionPane.showMessageDialog(null, "Novo saldo: " + contaDeposito.getSaldo(), "Depósito", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "debitar":
                    Conta contaDebito = banco.getConta(numero);
                    contaDebito.debitar(Double.parseDouble(JOptionPane.showInputDialog(null, "Valor a ser debitado:", "Saque", JOptionPane.QUESTION_MESSAGE)));
                    banco.setConta(contaDebito);

                    JOptionPane.showMessageDialog(null, "Novo saldo: " + contaDebito.getSaldo(), "Saque", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "remover":
                    int confirmarRemocao = JOptionPane.showConfirmDialog(null, "Deseja remover a conta Nº " + numero);
                    if (confirmarRemocao == JOptionPane.YES_OPTION) {
                        if (banco.remover(numero)) {
                            JOptionPane.showMessageDialog(null, "Conta removida com sucesso!", "Remover conta", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta inválida ou não pode ser removida", "Remover conta", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void transferirValor() {
        try {
            int numeroOrigem = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Nº da Conta de Origem:", "Transferencia", JOptionPane.QUESTION_MESSAGE));
            Conta contaOrigem = banco.getConta(numeroOrigem);
            
            int numeroDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Nº da Conta de Destino:", "Transferencia", JOptionPane.QUESTION_MESSAGE));
            Conta contaDestino = banco.getConta(numeroDestino);
            
            double quantia = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor a ser transferido:", "Transferencia", JOptionPane.QUESTION_MESSAGE));
            
            if(contaOrigem.tranferir(contaDestino, quantia)){
                JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!", "Transferencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferencia", "Transferencia", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
