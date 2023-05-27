package model.Controlador;

import javax.swing.*;

public class ProcessosPrincipais {

    protected static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
        switch (opcao) {
            case 0: //Cadastros
                chamaMenuCadastros();
                break;
            case 1: //Processos

                break;
            case 2: //Relatorios
               //JOptionPane.showMessageDialog(null, ClienteDAO.buscaTodos());
                //JOptionPane.showMessageDialog(null, VendaDAO.buscaTodos());
                //chamaMenuPrincipal();
                break;
            case 3: //SAIR

                break;
        }
    }

    private static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Cliente", "Produto", "Venda", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Pessoa
                //cadastroDeCliente();
                break;
            case 1: //Produtos
                //cadastroDeProduto();
                break;
            case 2: //Seguro
                //chamaCadastroVenda();
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

}
