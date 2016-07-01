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
public class UsuarioLoginGrandeException extends UsuarioException {
   
    public UsuarioLoginGrandeException() {
        super("O campo de login deve ter no mínimo um e no máximo 8 caracteres alfanuméricos");
    }
}
