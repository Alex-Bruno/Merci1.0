/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.excecao;

/**
 *
 * @author alex
 */
public class UsuarioCaractereInvalidoLogin extends UsuarioException {
    
    public UsuarioCaractereInvalidoLogin() {
        super("Login invalido.\nLogin deve possuir apenas caracteres 0-9, a-z, A-Z.");
    }
    
}
