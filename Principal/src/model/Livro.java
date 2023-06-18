package model;

import java.time.LocalDate;

public class Livro {

    private String tituloLivro;
    private String autorLivro;
    private String editora;
    private LocalDate anoPublicacao;
    private String genero;

    public Livro(String tituloLivro, String autorLivro, String editora, LocalDate anoPublicacao, String genero) {
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    public String getTituloLivro() {
        return this.tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "tituloLivro='" + tituloLivro + '\'' +
                ", autorLivro='" + autorLivro + '\'' +
                ", editora='" + editora + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", genero='" + genero + '\'' +
                '}';
    }


    public Livro get(int i) {
        return null;
    }
}
