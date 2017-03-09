package br.com.repassi.testewebservice.testewebservice.modelo;

import java.io.Serializable;

/**
 * Created by Regis on 17/09/16.
 */
public class UsuarioParameter implements Serializable {

    private String email;
    private String senha;

    public UsuarioParameter() {
        email = null;
        senha = null;
    }

    public UsuarioParameter(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String nome) {
        this.email = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String email) {
        this.senha = email;
    }
}
