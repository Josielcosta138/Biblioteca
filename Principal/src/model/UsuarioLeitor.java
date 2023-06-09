package model;

import java.time.LocalDate;

public class UsuarioLeitor extends Usuario{

    private int codigoMatricula;
    private int idade;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataMatricula;


    public UsuarioLeitor(String nome, String cpf, StatusGenero statusGenero, int codigoMatricula, int idade, String endereco, String telefone, String email, LocalDate dataMatricula) {
        super(nome, cpf, statusGenero);
        this.codigoMatricula = codigoMatricula;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataMatricula = dataMatricula;
    }


    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }


    @Override
    public String toString() {
        return "UsuarioLeitor{" +
                "\n codigoMatricula=" + codigoMatricula +
                ",\n nome=" + getNome() +
                ",\n cpf=" + getCpf() +
                ",\n idade=" + idade +
                ",\n endereco='" + endereco + '\'' +
                ",\n telefone='" + telefone + '\'' +
                ",\n email='" + email + '\'' +
                ",\n dataMatricula=" + dataMatricula +
                ",\n statusGenero=" + statusGenero +
                '}';
    }
}
