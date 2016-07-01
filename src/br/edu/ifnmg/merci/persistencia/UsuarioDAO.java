/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.persistencia;

import br.edu.ifnmg.merci.entidade.GrupoUsuarios;
import br.edu.ifnmg.merci.entidade.Usuario;
import br.edu.ifnmg.merci.excecao.UsuarioNaoEncontradoException;
import br.edu.ifnmg.merci.negocio.UsuarioGrupoUsuarioBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author AlexBruno
 */
public class UsuarioDAO {

    private static final String SELECT_USUARIO_LOGIN = "SELECT CODIGO, NOME, LOGIN, SENHA FROM USUARIO WHERE LOGIN = ?;";
    private static final String SELECT_USUARIO_NOME = "SELECT CODIGO, NOME, LOGIN, SENHA FROM USUARIO WHERE NOME = ?;";
    private static final String ALTERAR_SENHA = "UPDATE USUARIO SET SENHA = ? WHERE LOGIN = ?;";
    private static final String INSERT_USUARIO = "INSERT INTO \"PUBLIC\".\"USUARIO\"\n" +
        "( \"NOME\", \"LOGIN\", \"SENHA\" )\n" +
        "VALUES ( ?, ?, ?)";
    
    private static final String ALTERAR_USUARIO = "UPDATE USUARIO SET LOGIN = ?, NOME = ?, SENHA = ? WHERE LOGIN = ?;";
    
    private static final String SELECT_TODOS_LOGIN_USUARIOS = "SELECT LOGIN FROM USUARIO";
   
    private static final String DELETE_USUARIO = "DELETE FROM USUARIO WHERE LOGIN = ?";

    private static final String SELECT_TODOS_USUARIOS = "SELECT CODIGO, NOME, LOGIN, SENHA FROM USUARIO";
    
    private static final String SELECT_CODIGO_USUARIO = "SELECT CODIGO FROM USUARIO WHERE LOGIN = ?";
    
    public boolean alterarSenha(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean status = false;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( ALTERAR_SENHA);
            comando.setString( 1, usuario.getSenha());
            comando.setString( 2, usuario.getLogin());
            comando.execute();
            
            conexao.commit();
            
            status = true;
            
        } catch( Exception ex){
            if( comando != null)
                conexao.rollback();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        
        return status;
    }

    public int inserirUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        int status = -1;
        UsuarioGrupoUsuarioDAO usuarioGrupoUsuarioDAO = new UsuarioGrupoUsuarioDAO();
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( INSERT_USUARIO);
            comando.setString( 1, usuario.getNome());
            comando.setString( 2, usuario.getLogin());
            comando.setString( 3, usuario.getSenha());
 
            comando.execute();
            
            conexao.commit();
            
            status = selectCodigoUsuario( usuario.getLogin());
        
        } catch( Exception ex){
            if( comando != null)
                conexao.rollback();
            throw ex;
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }

        return status;
    }

    public LinkedList<String> selectTodosLogin() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        LinkedList<String> listaLogin = new LinkedList<>();
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( SELECT_TODOS_LOGIN_USUARIOS);
         
            resultado = comando.executeQuery();
            
            while( resultado.next())
                listaLogin.add( resultado.getString(1));
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return listaLogin;
    }     

    public Usuario buscarUsuarioLogin(String login) throws SQLException, UsuarioNaoEncontradoException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        Usuario usuario = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement( SELECT_USUARIO_LOGIN);
            
            comando.setString( 1,login);
            
            resultado = comando.executeQuery();
            
            if( resultado.next()){
                usuario = this.extrairLinha( resultado);
               
            }else
                throw new UsuarioNaoEncontradoException();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return usuario;
    }
    
    public int alterarUsuario( Usuario usuario, String login) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        int status = -1;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( ALTERAR_USUARIO);
            comando.setString( 1, usuario.getLogin());
            comando.setString( 2, usuario.getNome());
            comando.setString( 3, usuario.getSenha());
            comando.setString( 4, login);
            comando.execute();
            
            conexao.commit();
            
            status = this.selectCodigoUsuario( usuario.getLogin());
            
        } catch( Exception ex){
            if( comando != null)
                conexao.rollback();
            ex.printStackTrace();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        
        return status;
    }

    private Usuario extrairLinha(ResultSet resultado) throws SQLException {
        
        Usuario usuarioNovo = new Usuario();
        
        usuarioNovo.setCodido( resultado.getInt( 1));
        usuarioNovo.setNome( resultado.getString(2));
        usuarioNovo.setLogin( resultado.getString(3));
        usuarioNovo.setSenha( resultado.getString(4));
                
        return usuarioNovo;
    }

    public boolean excluirUsuario(String login) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean status = false;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( DELETE_USUARIO);
            comando.setString( 1, login);
            
            comando.execute();
            
            conexao.commit();
            
            status = true;
            
        } catch( Exception ex){
            if( comando != null)
                conexao.rollback();
            ex.printStackTrace();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        
        return status;
    }

    public Usuario buscarUsuarioNome(String nome) throws SQLException, UsuarioNaoEncontradoException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        Usuario usuario = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( SELECT_USUARIO_NOME);
            comando.setString( 1,nome);
            resultado = comando.executeQuery();
            
            if( resultado.next()){
                usuario = this.extrairLinha( resultado);
               
            }else
                throw new UsuarioNaoEncontradoException();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return usuario;
    }

    public ArrayList<Usuario> buscarTodosUsuarios() throws SQLException{
     
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        UsuarioGrupoUsuarioBO usuarioGrupoUsuarioBO = new UsuarioGrupoUsuarioBO();
        
        Usuario usuario = new Usuario();
        
        ArrayList< Usuario> listaUsuarios = new ArrayList<>();
        
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement( SELECT_TODOS_USUARIOS);
                        
            resultado = comando.executeQuery();
            
            
            while( resultado.next()){
                usuario = this.extrairLinha( resultado);
                String login = usuario.getLogin();
                
                usuario.setGrupoUsuarios( usuarioGrupoUsuarioBO.selectGrupoUsuarioLogin( login));
                
                listaUsuarios.add( usuario);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return listaUsuarios;
    }

    public int selectCodigoUsuario(String login) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement( SELECT_CODIGO_USUARIO);
            
            comando.setString(1, login);
            
            resultado = comando.executeQuery();
            
            
            if( resultado.next()){
                return resultado.getInt(1);
            }else
                return -1;
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
    }

  
}
