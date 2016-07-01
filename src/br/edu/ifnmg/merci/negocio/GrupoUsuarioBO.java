/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.negocio;

import br.edu.ifnmg.merci.persistencia.GrupoUsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class GrupoUsuarioBO {

    public void verificaGruposCadastrados() throws SQLException {
        GrupoUsuarioDAO grupoUsuarioDAO = new GrupoUsuarioDAO();
        
        for( int i = 1; i<= 4 ; i+=1)
            if( grupoUsuarioDAO.verificaGrupoCadastrado( i ) == true)
                continue;
            else{
                String descricao;
                if( i == 1)
                   descricao = "Gerente";
                
                else if( i == 2)
                   descricao = "Gestor de Compra";
                
                else if( i== 3)
                    descricao = "Gestor de Estoque";
                
                else
                    descricao = "Caixeiro";
                   
                grupoUsuarioDAO.CadastraGrupoUsuario(i, descricao);
            }
    }
    
}
