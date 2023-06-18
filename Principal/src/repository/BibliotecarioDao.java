package repository;

import model.Bibliotecario;
import model.UsuarioLeitor;

import java.util.ArrayList;
import java.util.List;

public class BibliotecarioDao {

    static List<Bibliotecario> bibliotecarioslista = new ArrayList<>();

    public static void salvar(Bibliotecario bibliotecario){
        bibliotecarioslista.add(bibliotecario);

    }

    public static List<Bibliotecario> buscarTodos(){
        return bibliotecarioslista;
    }
}
