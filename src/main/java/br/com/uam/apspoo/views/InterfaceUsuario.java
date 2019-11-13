package br.com.uam.apspoo.views;

import br.com.uam.apspoo.factory.*;
import javax.swing.JOptionPane;

/**
 * @author NycolasVieira
 */
public class InterfaceUsuario {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        MenuFactory factory = new MenuFactory();
        int encerrarPrograma = 1;

        do {
            String menuEscolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "MENU DO BANCO", JOptionPane.QUESTION_MESSAGE, null, opcoesMenu(), opcoesMenu()[0]);

            switch (menuEscolha) {
                case "Cadastrar Cliente":
                    factory.cadastrarCliente();
                    break;

                case "Cadastrar Conta":
                    factory.cadastrarConta();
                    break;

                case "Listar Conta":
                    factory.listar("conta");
                    break;

                case "Pesquisar Conta":
                    factory.informarNumeroConta("pesquisarConta");
                    break;

                case "Depositar":
                    factory.informarNumeroConta("depositar");
                    break;

                case "Debitar(sacar)":
                    factory.informarNumeroConta("debitar");
                    break;

                case "Transferir":
                    factory.transferirValor();
                    break;

                case "Remover Conta":
                    factory.informarNumeroConta("remover");
                    break;

                case "Sair":
                    encerrarPrograma = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Valor inserido está incorreto, tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (encerrarPrograma != JOptionPane.YES_OPTION);
    }

    public static String[] opcoesMenu() {
        return new String[]{"Cadastrar Cliente",
             "Cadastrar Conta",
             "Listar Conta",
             "Pesquisar Conta",
             "Depositar",
             "Debitar(sacar)",
             "Transferir",
             "Remover Conta",
             "Sair"};
    }
}
