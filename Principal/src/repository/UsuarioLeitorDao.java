package repository;

import model.UsuarioLeitor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioLeitorDao {

    static List<UsuarioLeitor> usuarioLeitorsLista = new ArrayList<>();

    public static void salvar(UsuarioLeitor usuarioLeitor){
        usuarioLeitorsLista.add(usuarioLeitor);
    }

    public static List<UsuarioLeitor> buscarTodos(){
        return usuarioLeitorsLista;
    }

}
