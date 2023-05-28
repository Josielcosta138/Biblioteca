package model.Controlador;
import model.Controlador.Cadastros.*;
import repository.UsuarioLeitorDao;

import javax.swing.*;

import static model.Controlador.Cadastros.chamaMenuCadastros;

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
                JOptionPane.showMessageDialog(null, UsuarioLeitorDao.buscarTodos());
                //JOptionPane.showMessageDialog(null, VendaDAO.buscaTodos());
                chamaMenuPrincipal();
                break;

            case 3: //SAIR

                break;
        }
    }



}
