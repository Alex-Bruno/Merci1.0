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
public class UsuarioLoginCadastradoException extends UsuarioException {

    public UsuarioLoginCadastradoException() {
        super("Este login já está cadastrado.\nTente outro novamente.");
    }
    
}
