package repository;

import model.Bibliotecario;
import model.Livro;
import model.UsuarioLeitor;

import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    static List<Livro> livrolista = new ArrayList<>();

    public static void salvar(Livro livro){
        livrolista.add(livro);

    }

    public static List<Livro> buscarTodos(){
        return livrolista;
    }
}
