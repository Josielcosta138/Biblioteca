package model.Controlador;

import javax.swing.*;
import model.Controlador.ProcessosPrincipais;
import model.StatusGenero;
import model.UsuarioLeitor;
import repository.UsuarioLeitorDao;
import model.Execultavel.Main;

import java.time.LocalDate;

import static model.Controlador.ProcessosPrincipais.chamaMenuPrincipal;

public class Cadastros {

    public static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Bibliotecário","Usuário-Leitor", "Materiais", "Locação", "Voltar","Sair"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Bibliotecário

                //ChamaCadastroDeBibliotecrio();
                break;

            case 1: //Cadastro - Usuário-Leitor

                String[] opcoesMenuCadAltDel= {"Cadastrar","Alterar", "Deletar", "Sair"};
                int menuCadastroLeitor = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                        "Menu-Cadastro",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadAltDel, opcoesMenuCadAltDel[0]);

                switch (menuCadastroLeitor) {
                    case 0: //Cadastrar

                        String codigoMatricula = JOptionPane.showInputDialog(null,"Informe código da matricula (INT).");
                        int codigoMatriculaConvertido = Integer.parseInt(codigoMatricula);
                        String nome = JOptionPane.showInputDialog(null, "Informe seu nome do usuário leitor. ");
                        String cpf = JOptionPane.showInputDialog(null, "Informe cpf do usuário leitor. ");
                        String idade = JOptionPane.showInputDialog(null, "Informe idade usuário leitor (INT).");
                        int idadeConvertido = Integer.parseInt(idade);
                        String telefone = JOptionPane.showInputDialog(null, "Informe telefone do usuário leitor. ");
                        String endereco = JOptionPane.showInputDialog(null, "Informe endereco do usuário leitor. ");
                        String email = JOptionPane.showInputDialog(null, "Informe e-mail do usuário leitor. ");
                        LocalDate dataMatricula = LocalDate.now();
                        Object[] selecionaGenero = {"Masculino","Feminino","Outros"};
                        String  selecaoDefautl = (String) selecionaGenero[0];
                        Object selecaoGen = JOptionPane.showInputDialog(null," Informe genero do usuário Leitor:", "Genero", JOptionPane.QUESTION_MESSAGE, null,selecionaGenero, selecaoDefautl);

                        StatusGenero statusGenero = StatusGenero.MASCULINO;
                            if (selecaoGen.equals("Feminino")){
                                statusGenero = StatusGenero.FEMININO;
                            } else if (selecaoGen.equals("Outros")) {
                                statusGenero = StatusGenero.OUTROS;
                            }
                        //String dataMatriculaNova = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):");
                        UsuarioLeitor usuarioLeitor = new UsuarioLeitor(nome,cpf,statusGenero,codigoMatriculaConvertido,idadeConvertido,endereco,telefone,email,dataMatricula);
                        UsuarioLeitorDao.salvar(usuarioLeitor);
                        chamaMenuCadastros();
                        break;

                    case 1: //Alterar
                        String nomePesquisa = JOptionPane.showInputDialog(null,"Informe nome para alterar:");
                        for (UsuarioLeitor usuarioList : UsuarioLeitorDao.buscarTodos()) {
                               String nomeUsuario = usuarioList.getNome();
                            if (nomePesquisa.equals(nomeUsuario)){
                                JOptionPane.showMessageDialog(null,"Alteração de cadastro do Usuário leitor. ");
                            }
                        }



                        chamaMenuCadastros();
                        break;

                    case 2: //Deletar

                    case 3: //Sair
                        chamaMenuCadastros();
                }

              break;
            case 2: //Materiais
                //chamaCadastroDeMateriais();
                JOptionPane.showMessageDialog(null,"TESTE --> chamaCadastroDeMateriais()");
                break;
            case 3: // Locação
                //chamaCadastroDeLocacao();
                JOptionPane.showMessageDialog(null,"TESTE -> chamaCadastroDeLocacao()");
                break;
            case 4: //Voltar
                chamaMenuCadastros();
                break;
            case 5: //Sair
                chamaMenuPrincipal();


        }

    }




}
