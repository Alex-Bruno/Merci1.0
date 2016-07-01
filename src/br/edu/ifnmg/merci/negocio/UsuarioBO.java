/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.negocio;

import br.edu.ifnmg.merci.entidade.Usuario;
import br.edu.ifnmg.merci.excecao.UsuarioLoginCadastradoException;
import br.edu.ifnmg.merci.excecao.UsuarioNaoEncontradoException;
import br.edu.ifnmg.merci.excecao.UsuarioSenhaIncorretaException;
import br.edu.ifnmg.merci.persistencia.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author AlexBruno
 */
public class UsuarioBO {
    
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static UsuarioGrupoUsuarioBO usuarioGrupoUsuarioBO = new UsuarioGrupoUsuarioBO();

    public Usuario verificaLogin(Usuario usuario) throws SQLException, UsuarioNaoEncontradoException, UsuarioSenhaIncorretaException {
        
         Usuario usuarioNovo = new Usuario();
         usuarioNovo = buscarUsuarioLogin( usuario.getLogin());
         
         if( usuarioNovo.getSenha().equals( usuario.getSenha()))
             return usuarioNovo;
         else
             throw new UsuarioSenhaIncorretaException();
    }

    public boolean alterarSenha(Usuario usuario) throws SQLException {
        return usuarioDAO.alterarSenha( usuario);
    }

    public int cadastrarUsuario(Usuario usuario, String login) throws SQLException, UsuarioLoginCadastradoException {
        if( verificaLoginCadastrado( login) == true){
            return usuarioDAO.inserirUsuario( usuario);
        
        }else{
                return usuarioDAO.alterarUsuario( usuario, login);
        }
        
    }
    
    private LinkedList<String> selectTodosLogin() throws SQLException{
        return usuarioDAO.selectTodosLogin();
    }

    private boolean verificaLoginCadastrado(String login) throws SQLException {
        LinkedList<String> listaLogin = this.selectTodosLogin();
        boolean status = true;
        
        for( String loginLista : listaLogin)
            if( login.equals(loginLista))
                return false;
        return status;
    }

    public Usuario buscarUsuarioLogin(String login) throws SQLException, UsuarioNaoEncontradoException {
        Usuario usuario = usuarioDAO.buscarUsuarioLogin( login);
        usuario.setGrupoUsuarios( usuarioGrupoUsuarioBO.selectGrupoUsuarioLogin( login));
        return usuario;
    }

    public boolean excluirUsuario(String login) throws SQLException {
        boolean status = false;
        
        if( usuarioGrupoUsuarioBO.excluirUsuarioGrupoUsuario( login) == true){
            if( usuarioDAO.excluirUsuario( login) == true)
                status = true;
        }
        
        return status;
    }

    public Usuario buscarUsuarioNome(String nome) throws SQLException, UsuarioNaoEncontradoException {
        Usuario usuario = usuarioDAO.buscarUsuarioNome( nome);
        usuario.setGrupoUsuarios( usuarioGrupoUsuarioBO.selectGrupoUsuarioLogin( usuario.getLogin()));
        return usuario;
    }
    
    public ArrayList<Usuario> buscarTodosUsuarios() throws SQLException{
        return usuarioDAO.buscarTodosUsuarios();
    }
    
    public int selectCodigoUsuario( String login) throws SQLException{
        return usuarioDAO.selectCodigoUsuario(login);
    }
}
