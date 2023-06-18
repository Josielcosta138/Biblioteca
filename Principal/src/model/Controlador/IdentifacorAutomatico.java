package model.Controlador;

import java.util.Scanner;

public class IdentifacorAutomatico {
    public static String gerarIdentificador(String nome, String sobrenome) {
        String identificador = "";

        if (nome.length() >= 3) {
            identificador += nome.substring(0, 3);
        } else {
            identificador += nome;
        }

        if (sobrenome.length() >= 3) {
            identificador += sobrenome.substring(0, 3);
        } else {
            identificador += sobrenome;
        }

        return identificador.toLowerCase();
    }
}
