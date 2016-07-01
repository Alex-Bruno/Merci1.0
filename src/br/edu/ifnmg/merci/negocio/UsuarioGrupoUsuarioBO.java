/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.negocio;

import br.edu.ifnmg.merci.entidade.GrupoUsuarios;
import br.edu.ifnmg.merci.entidade.Usuario;
import br.edu.ifnmg.merci.excecao.UsuarioException;
import br.edu.ifnmg.merci.excecao.UsuarioNaoEncontradoException;
import br.edu.ifnmg.merci.persistencia.UsuarioGrupoUsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author AlexBruno
 */
public class UsuarioGrupoUsuarioBO {
    
    private static UsuarioGrupoUsuarioDAO usuarioGrupoUsuarioDAO = new UsuarioGrupoUsuarioDAO();            
    private static UsuarioBO usuarioBO = new UsuarioBO();
    
    public boolean verificaCadastrarUsuarioGrupoUsuario( Usuario usuario,GrupoUsuarios grupoUsuarios) throws SQLException, UsuarioException{
        
        int codigo = usuarioBO.selectCodigoUsuario( usuario.getLogin());
        
        if( codigo > 0){

            boolean verificaUsuarioGrupoUsuarioExistente = usuarioGrupoUsuarioDAO.verificaUsuarioGrupoUsuarioExistente( codigo);

            if( verificaUsuarioGrupoUsuarioExistente == false){
                return this.atualizaCadastroUsuarioGrupoUsuario( codigo, grupoUsuarios);
            }else{
                return this.cadastrarUsuarioGrupoUsuario(codigo, grupoUsuarios);
            }
        }else
            throw new UsuarioNaoEncontradoException();
        
 }

    public GrupoUsuarios selectGrupoUsuarioLogin(String login) throws SQLException {
       int codigo = usuarioBO.selectCodigoUsuario(login);
       
       return usuarioGrupoUsuarioDAO.selectGrupoUsuarioLogin( codigo);
    }

    public boolean excluirUsuarioGrupoUsuario(String login) throws SQLException {
        int codigo = usuarioBO.selectCodigoUsuario(login);

       return usuarioGrupoUsuarioDAO.excluirUsuarioGrupoUsuarioLogin( codigo);
    }

    private boolean atualizaCadastroUsuarioGrupoUsuario(int codigo, GrupoUsuarios grupoUsuarios) throws SQLException {
            GrupoUsuarios novogrupoUsuario = usuarioGrupoUsuarioDAO.selectGrupoUsuarioLogin( codigo);
            boolean status = true;
            
       
            if( grupoUsuarios.getGerente() == true && novogrupoUsuario.getGerente() == false){
                
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 1) == true){
                    status = true;
                    
                }else
                    status = false;
                
            }else if( grupoUsuarios.getGerente() == false && novogrupoUsuario.getGerente() == true ){
                    if( usuarioGrupoUsuarioDAO.excluirUsuarioGrupoUsuario( codigo, 1))
                        status = true;
                    else 
                        status = false;
            }

            if( grupoUsuarios.getGestorCompras() == true && novogrupoUsuario.getGestorCompras()== false){
                
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 2)  == true){
                   
                    status = true;
                }
                else
                    status = false;
                
            }else if( grupoUsuarios.getGestorCompras()== false && novogrupoUsuario.getGestorCompras()== true ){
                    if( usuarioGrupoUsuarioDAO.excluirUsuarioGrupoUsuario( codigo, 2))
                        status = true;
                    else
                        status = false;
            }

            if( grupoUsuarios.getGestorEstoque() == true && novogrupoUsuario.getGestorEstoque()== false){
                 
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 3) == true){
                    status = true;
                }else
                    status = false;
                
                
            }else if( grupoUsuarios.getGestorEstoque()== false && novogrupoUsuario.getGestorEstoque()== true ){
                    if( usuarioGrupoUsuarioDAO.excluirUsuarioGrupoUsuario( codigo, 3))
                        status = true;
                    else 
                        status = false;
            }

            if( grupoUsuarios.getCaixeiro() == true && novogrupoUsuario.getCaixeiro()== false){
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 4) == true)
                    status = true;
                else
                    status = false;
                
            }
            else if( grupoUsuarios.getCaixeiro()== false && novogrupoUsuario.getCaixeiro()== true ){
                    if( usuarioGrupoUsuarioDAO.excluirUsuarioGrupoUsuario( codigo, 4))
                        status = true;
                    else 
                        status = false;
            }
            return status;
                
    }

    private boolean cadastrarUsuarioGrupoUsuario(int codigo, GrupoUsuarios grupoUsuarios) throws SQLException {
        boolean status = false;
        if( grupoUsuarios.getGerente() == true){

                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 1) == true){

                    status = true;
                }
            }

            if( grupoUsuarios.getGestorCompras() == true){
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 2)  == true){

                    status = true;
                }
            }

            if( grupoUsuarios.getGestorEstoque() == true){
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 3) == true)
                    status = true;
            }

            if( grupoUsuarios.getCaixeiro() == true){
                if( usuarioGrupoUsuarioDAO.cadastraGrupoUsuario( codigo, 4) == true)
                    status = true;
              
             }       
        return status;
    }

}
