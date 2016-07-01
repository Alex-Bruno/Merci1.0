/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.persistencia;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class GrupoUsuarioDAO {

    private static final String INSERT_GRUPO_USUARIO = "INSERT INTO \"PUBLIC\".\"GRUPO_USUARIO\"\n" +
        "( \"CODIGO\", \"DESCRICAO\" ) VALUES ( ?, ?)";
    private static final String SELECT_GRUPO_USUARIO = "SELECT CODIGO, DESCRICAO FROM GRUPO_USUARIO WHERE CODIGO = ?";
    
    public void CadastraGrupoUsuario(int codigo, String descricao) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( INSERT_GRUPO_USUARIO);
            
            comando.setInt( 1, codigo);
            comando.setString( 2, descricao);
            
            comando.execute();
            
            conexao.commit();
            
        }catch( Exception ex){
        
            if( comando != null)
                conexao.rollback();
        
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        
    }

    public boolean verificaGrupoCadastrado(int codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        try{
            
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( SELECT_GRUPO_USUARIO);
            
            comando.setInt( 1, codigo);
            
            resultado = comando.executeQuery();
            
            if( resultado.next())
                return true;
            else
                return false;            
            
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
    }
    
}
