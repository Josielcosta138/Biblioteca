package repository;

import model.Bibliotecario;
import model.Livro;
import model.UsuarioLeitor;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    static List<Livro> livrolista = new ArrayList<>();

    public static void salvar(Livro livro){
        livrolista.add(livro);

    }

    public static void alterar(Livro livro) {
        String tituloLivro = JOptionPane.showInputDialog(null, "Informe o Titulo: ");
        livro.setTituloLivro(tituloLivro);
        String autorLivro = JOptionPane.showInputDialog(null, "Informe o Autor: ");
        livro.setAutorLivro(autorLivro);
        String editora = JOptionPane.showInputDialog(null, "Informe a Editora: ");
        livro.setEditora(editora);
        String dataInput = JOptionPane.showInputDialog(null, "Informe a Data de Publicação (dd/MM/yyyy):");
        livro.setAnoPublicacao(LocalDate.parse(dataInput));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate anoPublicacao = LocalDate.parse(dataInput, formatter);
        String genero = JOptionPane.showInputDialog(null, "Informe o genero do Livro: ");
        livro.setGenero(genero);
    }



    public static List<Livro> buscarTodos(){
        return livrolista;
    }

    public static List<Livro> buscarPorNome(String s) {
        List<Livro> LivroFiltradas = new ArrayList<>();
        for (Livro livro : livrolista) {
            if (livro.getTituloLivro().contains(livro.getTituloLivro())) {
                LivroFiltradas.add(livro);
            }
        }
        return LivroFiltradas;
    }



    private static List<Livro> buscaTodos() {

        return livrolista;
        }
    }

