/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.persistencia;

import br.edu.ifnmg.merci.entidade.GrupoUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AlexBruno
 */
public class UsuarioGrupoUsuarioDAO {
    
    private static final String INSERT_USUARIO_GRUPO_USUARIO = "INSERT INTO \"PUBLIC\".\"USUARIO_GRUPO_USUARIO\"\n" +
        "( \"USUARIO_FK\", \"GRUPO_USUARIO_FK\" )\n" +
        "VALUES ( ?, ?);"; 
    private static final String SELECT_GRUPO_USUARIO_LOGIN_USUARIO = "SELECT GRUPO_USUARIO_FK FROM USUARIO_GRUPO_USUARIO WHERE USUARIO_FK = ?";
    
    private static final String DELETE_USUARIO_GRUPO_USUARIO_LOGIN =" DELETE FROM USUARIO_GRUPO_USUARIO WHERE USUARIO_FK = ?";
    private static final String DELETE_USUARIO_GRUPO_USUARIO =" DELETE FROM USUARIO_GRUPO_USUARIO WHERE USUARIO_FK = ? AND GRUPO_USUARIO_FK = ?";
    
    private static final String UPDADE_LOGIN_USUARIO_GRUPO_USUARIO = "UPDATE USUARIO_GRUPO_USUARIO SET USUARIO_FK = ? WHERE USUARIO_FK = ?";
    
    public boolean cadastraGrupoUsuario( int usuario, int codigo) throws SQLException {
        
        Connection conexao = null;
        PreparedStatement comando = null;
        
        boolean status = false;
        
        try{
            
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( INSERT_USUARIO_GRUPO_USUARIO);
            comando.setInt( 1, usuario);
            comando.setInt( 2, codigo);
           
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

    public GrupoUsuarios selectGrupoUsuarioLogin(int login) throws SQLException {
        GrupoUsuarios grupoUsuarios = new GrupoUsuarios();
        
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( SELECT_GRUPO_USUARIO_LOGIN_USUARIO);
            comando.setInt( 1, login);
            
            resultado = comando.executeQuery();
                    
            while( resultado.next()){
                if( resultado.getInt( 1) == 1){
                    grupoUsuarios.setGerente(true);
                }else if(resultado.getInt( 1) == 2 ){
                    grupoUsuarios.setGestorCompras(true);
                }else if(resultado.getInt( 1) == 3 ){
                    grupoUsuarios.setGestorEstoque(true);
                }else{
                    grupoUsuarios.setCaixeiro(true);
                }
            }
            
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return grupoUsuarios;
    }

    public boolean excluirUsuarioGrupoUsuarioLogin(int login) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean status = false;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( DELETE_USUARIO_GRUPO_USUARIO_LOGIN);
            comando.setInt(1, login);
         
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

    public boolean verificaUsuarioGrupoUsuarioExistente(int codigo) throws SQLException {
        
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( SELECT_GRUPO_USUARIO_LOGIN_USUARIO);
            comando.setInt( 1, codigo);
            
            resultado = comando.executeQuery();
                    
            if( resultado.next()){
              return false;
            }else
                return true;
            
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
    }

    public boolean excluirUsuarioGrupoUsuario(int login, int codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean status = false;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( DELETE_USUARIO_GRUPO_USUARIO);
            comando.setInt(1, login);
            comando.setInt( 2, codigo);
         
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

}
