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
public class UsuarioGrupoNaoSelecionadoException extends UsuarioException {
    public UsuarioGrupoNaoSelecionadoException( ) {
        super("Selecione pelo menos um opção do grupo de usuário");
    }
}
