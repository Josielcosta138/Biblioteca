package model.Controlador;

import javax.swing.*;

import model.Livro;
import model.StatusGenero;
import model.UsuarioLeitor;
import repository.LivroDao;
import repository.UsuarioLeitorDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static model.Controlador.ProcessosPrincipais.chamaMenuPrincipal;

public class Cadastros {

    public static Object chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Bibliotecário", "Usuário-Leitor", "Materiais", "Locação", "Voltar", "Sair"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Bibliotecário

                //ChamaCadastroDeBibliotecrio();
                break;

            case 1: //Cadastro - Usuário-Leitor

                String[] opcoesMenuCadAltDel = {"Cadastrar", "Alterar", "Deletar", "Sair"};
                int menuCadastroLeitor = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                        "Menu-Cadastro",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadAltDel, opcoesMenuCadAltDel[0]);

                switch (menuCadastroLeitor) {
                    case 0: //Cadastrar

                        String codigoMatricula = JOptionPane.showInputDialog(null, "Informe código da matricula (INT).");
                        int codigoMatriculaConvertido = Integer.parseInt(codigoMatricula);
                        String nome = JOptionPane.showInputDialog(null, "Informe seu nome do usuário leitor. ");
                        String cpf = JOptionPane.showInputDialog(null, "Informe cpf do usuário leitor. ");
                        String idade = JOptionPane.showInputDialog(null, "Informe idade usuário leitor (INT).");
                        int idadeConvertido = Integer.parseInt(idade);
                        String telefone = JOptionPane.showInputDialog(null, "Informe telefone do usuário leitor. ");
                        String endereco = JOptionPane.showInputDialog(null, "Informe endereco do usuário leitor. ");
                        String email = JOptionPane.showInputDialog(null, "Informe e-mail do usuário leitor. ");
                        LocalDate dataMatricula = LocalDate.now();
                        Object[] selecionaGenero = {"Masculino", "Feminino", "Outros"};
                        String selecaoDefautl = (String) selecionaGenero[0];
                        Object selecaoGen = JOptionPane.showInputDialog(null, " Informe genero do usuário Leitor:", "Genero", JOptionPane.QUESTION_MESSAGE, null, selecionaGenero, selecaoDefautl);

                        StatusGenero statusGenero = StatusGenero.MASCULINO;
                        if (selecaoGen.equals("Feminino")) {
                            statusGenero = StatusGenero.FEMININO;
                        } else if (selecaoGen.equals("Outros")) {
                            statusGenero = StatusGenero.OUTROS;
                        }
                        //String dataMatriculaNova = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):");
                        UsuarioLeitor usuarioLeitor = new UsuarioLeitor(nome, cpf, statusGenero, codigoMatriculaConvertido, idadeConvertido, endereco, telefone, email, dataMatricula);
                        UsuarioLeitorDao.salvar(usuarioLeitor);
                        chamaMenuCadastros();
                        break;

                    case 1: //Alterar
                        String nomePesquisa = JOptionPane.showInputDialog(null, "Informe nome para alterar:");
                        for (UsuarioLeitor usuarioList : UsuarioLeitorDao.buscarTodos()) {
                            String nomeUsuario = usuarioList.getNome();
                            if (nomePesquisa.equals(nomeUsuario)) {
                                JOptionPane.showMessageDialog(null, "Alteração de cadastro do Usuário leitor. ");
                            }

                        }


                        chamaMenuCadastros();
                        break;

                    case 2: //Deletar

                    case 3: //Sair
                        chamaMenuPrincipal();
                }

                break;
            case 2: //Materiais

                Object[] selecionaMateriais = {"Livros", "Outros"};
                String selecaoDefautl = (String) selecionaMateriais[0];
                Object selecaoGen = JOptionPane.showInputDialog(null, " Selecione o Material Desejado: ", "Materiais",
                        JOptionPane.QUESTION_MESSAGE, null, selecionaMateriais, selecaoDefautl);
                String[] selecaoGen2 = {"Cadastrar", "Alterar", "Deletar", "Sair"};

                int menuCadastroLivro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                        "Menu-Cadastro Livro",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, selecaoGen2, selecaoGen2[0]);

                switch (menuCadastroLivro) {
                    case 0: //Cadastrar Livro

                        String tituloLivro = JOptionPane.showInputDialog(null, "Informe o Titulo: ");
                        String autorLivro = JOptionPane.showInputDialog(null, "Informe o Autor: ");
                        String editora = JOptionPane.showInputDialog(null, "Informe a Editora: ");
                        String dataInput = JOptionPane.showInputDialog(null, "Informe a Data de Publicação (dd/MM/yyyy):");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate anoPublicacao = LocalDate.parse(dataInput, formatter);
                        String genero = JOptionPane.showInputDialog(null, "Informe o genero do Livro: ");

                        Livro livro = new Livro(tituloLivro, autorLivro, editora, anoPublicacao, genero);
                        LivroDao.salvar(livro);
                        JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuCadastros();
                        break;

                    case 1: //Alterar
                        String livroPesquisa = JOptionPane.showInputDialog(null, "Informe o nome do livro para alterar:");

                        for (Livro livro1 : LivroDao.buscarTodos()) {
                            if (livroPesquisa.equals(livro1.getTituloLivro())) {
                                String livroPesquisa1 = JOptionPane.showInputDialog(null, "Informe o nome do livro para alterar:");
                                livro1.setTituloLivro(livroPesquisa1); // Substitua "novoTitulo" pelo título atualizado
                                JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso para: " + livro1.getTituloLivro());
                            }
                        }

                        chamaMenuCadastros();
                        break;

                    case 3: //Sair
                        chamaMenuCadastros();
                }
                //JOptionPane.showMessageDialog(null,"TESTE --> chamaCadastroDeMateriais()");

            case 3: // Locação
                //chamaCadastroDeLocacao();
                //JOptionPane.showMessageDialog(null, "TESTE -> chamaCadastroDeLocacao()");
                break;
            case 4: //Voltar
                chamaMenuCadastros();
                break;
            case 5: //Sair
                chamaMenuPrincipal();


        }
        return null;
    }
}






