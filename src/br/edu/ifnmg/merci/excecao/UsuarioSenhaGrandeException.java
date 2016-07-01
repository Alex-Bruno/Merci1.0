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
public class UsuarioSenhaGrandeException extends UsuarioException{
   
    public UsuarioSenhaGrandeException() {
        super("O campo de senha deve ter no mínimo um e no máximo 8 caracteres alfanuméricos");
    }
}
