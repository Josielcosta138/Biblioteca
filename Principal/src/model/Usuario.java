package model;

public class Usuario {

    private String nome;
    private String cpf;

    StatusGenero statusGenero;


    public Usuario(String nome, String cpf, StatusGenero statusGenero) {
        this.nome = nome;
        this.cpf = cpf;
        this.statusGenero = statusGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusGenero getStatusGenero() {
        return statusGenero;
    }

    public void setStatusGenero(StatusGenero statusGenero) {
        this.statusGenero = statusGenero;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", statusGenero=" + statusGenero +
                '}';
    }
}

