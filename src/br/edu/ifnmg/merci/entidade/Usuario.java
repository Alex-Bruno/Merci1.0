/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.entidade;

/**
 *
 * @author AlexBruno
 */
public class Usuario {
    private int codido;
    private String nome ;
    private String login;
    private String senha;
    private GrupoUsuarios grupoUsuarios = new GrupoUsuarios();

    public Usuario() {
        this.codido = -1;
        this.nome = "";
        this.login = "";
        this.senha = "";
    }

    public int getCodido() {
        return codido;
    }

    public void setCodido(int codido) {
        this.codido = codido;
    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public GrupoUsuarios getGrupoUsuarios() {
        return grupoUsuarios;
    }

    public void setGrupoUsuarios(GrupoUsuarios grupoUsuarios) {
        this.grupoUsuarios = grupoUsuarios;
    }
        
}
