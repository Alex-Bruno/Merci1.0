/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.excecao;

/**
 *
 * @author AlexBruno
 */
public class UsuarioSenhaIncorretaException extends UsuarioException{

    public UsuarioSenhaIncorretaException() {
        super("Senha não confere com cadastrada.");
    }
    
}
