package br.com.uam.apspoo.views;

import br.com.uam.apspoo.controllers.*;
import javax.swing.JOptionPane;

/**
 * @author NycolasVieira
 */
public class InterfaceUsuario {

    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        Banco banco = new Banco();
        GerenciaCliente gerenciaCliente = new GerenciaCliente();
        int encerrarPrograma = 1;
        
        do {
            var menuEscolha = JOptionPane.showInputDialog(opcoesMenu());
            
            switch(menuEscolha){
                case "9":
                    encerrarPrograma = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Valor inserido está incorreto, tente novamente");
                    break;
            }
        } while(encerrarPrograma != JOptionPane.YES_OPTION);
    }
    
    public static String opcoesMenu(){
        return "=== MENU DO BANCO ===\n"
                + "1 - Cadastrar Cliente\n"
                + "2 - Cadastrar Conta\n"
                + "3 - Listar Conta\n"
                + "4 - Pesquisar Conta\n"
                + "5 - Depositar\n"
                + "6 - Debitar(sacar)\n"
                + "7 - Transferir\n"
                + "8 - Remover Conta\n"
                + "9 - Sair\n";
    }
}
