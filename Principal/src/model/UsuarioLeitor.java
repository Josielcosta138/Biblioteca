package model;

public class UsuarioLeitor extends Usuario{


    private int codigo;

    public UsuarioLeitor(String nome, String cpf) {
        super(nome, cpf);
    }

    public UsuarioLeitor(String nome, String cpf, int codigo) {
        super(nome, cpf);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "UsuarioLeitor{" +
                "codigo=" + codigo +
                '}';
    }
}
