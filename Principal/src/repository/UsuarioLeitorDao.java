package repository;

import model.StatusGenero;
import model.Usuario;
import model.UsuarioLeitor;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static model.Controlador.ProcessosPrincipais.chamaMenuPrincipal;

public class UsuarioLeitorDao {

    static List<UsuarioLeitor> usuarioLeitorsLista = new ArrayList<>();

    public static void salvar(UsuarioLeitor usuarioLeitor){
        usuarioLeitorsLista.add(usuarioLeitor);
    }

    public static List<UsuarioLeitor> buscaTodosUsuarios(){
        return usuarioLeitorsLista;
    }

    public static Object[] UsuariosNaLista(){
        List<UsuarioLeitor> usuarios = buscaTodosUsuarios();
        List<String> usuariosNomes = new ArrayList<>();

        for (UsuarioLeitor usuarioLeitor : usuarios) {
            usuariosNomes.add(usuarioLeitor.getNome());
        }
        return usuarios.toArray();
    }


    public static List<UsuarioLeitor> buscarPorNome(String nome) {
        List<UsuarioLeitor> usuariosFiltrados = new ArrayList<>();
        for (Usuario usuario : usuarioLeitorsLista) {
            if (usuario.getNome().contains(nome)) {
                usuariosFiltrados.add((UsuarioLeitor) usuario);
            }
        }
        return usuariosFiltrados;
    }


    public static void AlterarUsuarioLeitor(UsuarioLeitor usuarioLeitor){

        JOptionPane.showMessageDialog(null, "Atenção voçê irá alterar um usuário!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

        Object[] selecionaListaUsuarioLeitor = UsuarioLeitorDao.UsuariosNaLista();
        String iniciaComUsuario = (String) selecionaListaUsuarioLeitor[0];
        Object selecionaUsuario = JOptionPane.showInputDialog(null,"Selecione o Usuário","Lista de usuários",JOptionPane.QUESTION_MESSAGE,null,selecionaListaUsuarioLeitor,iniciaComUsuario);
        List<UsuarioLeitor>usuarios = UsuarioLeitorDao.buscarPorNome(selecionaUsuario.toString());

        String nomePesquisa = usuarios.toString();
        for (UsuarioLeitor usuarioList : UsuarioLeitorDao.buscarTodos()) {
            String nomeUsuario = usuarioList.getNome();

            if (nomePesquisa.equals(nomeUsuario)){
                String novoNome = JOptionPane.showInputDialog(null, "Informe o novo nome do usuário leitor.");
                String novoCpf = JOptionPane.showInputDialog(null, "Informe o novo CPF do usuário leitor.");
                String novaIdade = JOptionPane.showInputDialog(null, "Informe a nova idade do usuário leitor (INT).");
                int novaIdadeConvertida = Integer.parseInt(novaIdade);
                String novoTelefone = JOptionPane.showInputDialog(null, "Informe o novo telefone do usuário leitor.");
                String novoEndereco = JOptionPane.showInputDialog(null, "Informe o novo endereço do usuário leitor.");
                String novoEmail = JOptionPane.showInputDialog(null, "Informe o novo e-mail do usuário leitor.");
                LocalDate novaDataMatricula = usuarioLeitor.getDataMatricula();

                Object[] selecionaGenero = {"Masculino", "Feminino", "Outros"};
                String selecaoDefautl = (String) selecionaGenero[0];
                Object selecaoGen = JOptionPane.showInputDialog(null, "Informe o novo gênero do usuário leitor:", "Gênero", JOptionPane.QUESTION_MESSAGE, null, selecionaGenero, selecaoDefautl);

                StatusGenero novoStatusGenero = StatusGenero.MASCULINO;
                if (selecaoGen.equals("Feminino")) {
                    novoStatusGenero = StatusGenero.FEMININO;
                } else if (selecaoGen.equals("Outros")) {
                    novoStatusGenero = StatusGenero.OUTROS;
                }

                usuarioLeitor.setNome(novoNome);
                usuarioLeitor.setCpf(novoCpf);
                usuarioLeitor.setIdade(novaIdadeConvertida);
                usuarioLeitor.setTelefone(novoTelefone);
                usuarioLeitor.setEndereco(novoEndereco);
                usuarioLeitor.setEmail(novoEmail);
                usuarioLeitor.setStatusGenero(novoStatusGenero);

                UsuarioLeitorDao.atualizar(usuarioLeitor);
                JOptionPane.showMessageDialog(null, "Usuário leitor atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário leitor não encontrado.");
            }
                chamaMenuPrincipal();
            }
        }

    private static void atualizar(UsuarioLeitor usuarioLeitor) {
        UsuarioLeitorDao.salvar(usuarioLeitor);
    }


    public static List<UsuarioLeitor> buscarTodos(){
        return usuarioLeitorsLista;
    }

}
