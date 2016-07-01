/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.apresentacao;

import br.edu.ifnmg.merci.entidade.Usuario;
import br.edu.ifnmg.merci.negocio.UsuarioBO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class TelaListarUsuariosForm extends javax.swing.JFrame {
    
    private static ArrayList< Usuario> listaUsuario = new ArrayList<>();
    
    /**
     * Creates new form TelaListarUsuariosForm
     */
    public TelaListarUsuariosForm() {
        initComponents();
        this.inicializaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabelaDeUsuarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnEditarTelaListarUsuario = new javax.swing.JButton();
        btnExcluirTelaListarUsuario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListaUsuarios);

        javax.swing.GroupLayout pnlTabelaDeUsuariosLayout = new javax.swing.GroupLayout(pnlTabelaDeUsuarios);
        pnlTabelaDeUsuarios.setLayout(pnlTabelaDeUsuariosLayout);
        pnlTabelaDeUsuariosLayout.setHorizontalGroup(
            pnlTabelaDeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlTabelaDeUsuariosLayout.setVerticalGroup(
            pnlTabelaDeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaDeUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEditarTelaListarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/merci/apresentacao/Imagens/iconUpdate.png"))); // NOI18N
        btnEditarTelaListarUsuario.setText("Editar");
        btnEditarTelaListarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTelaListarUsuarioActionPerformed(evt);
            }
        });

        btnExcluirTelaListarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/merci/apresentacao/Imagens/eraser.png"))); // NOI18N
        btnExcluirTelaListarUsuario.setText("Excluir");
        btnExcluirTelaListarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTelaListarUsuarioActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/merci/apresentacao/Imagens/iconDelete.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(btnEditarTelaListarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirTelaListarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarTelaListarUsuario)
                    .addComponent(btnExcluirTelaListarUsuario)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTabelaDeUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabelaDeUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarTelaListarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTelaListarUsuarioActionPerformed
        int codigoUsuarioAlterar = this.tblListaUsuarios.getSelectedRow();
       
        try {
                TelaUsuariosForm telaUsuario ;
                 
                   if( codigoUsuarioAlterar >= 0){
                       Usuario userSelecionado = listaUsuario.get( codigoUsuarioAlterar);
                       
                       String mensagem = "Deseja realmente alterar o usuario "+userSelecionado.getNome()+" ?";
                       int opcao = JOptionPane.showConfirmDialog(this, mensagem, "Alterar usuario", JOptionPane.YES_NO_OPTION);
                       
                       if( opcao == JOptionPane.YES_OPTION){
                            telaUsuario = new TelaUsuariosForm( userSelecionado);
                            telaUsuario.setVisible(true);  
                            this.inicializaTabela();
                       }
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "Selecione um usuario na tabela para fazer a alateração!", "Erro!", JOptionPane.ERROR_MESSAGE);
                   }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage(), "Falha na atualização do usuário", JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
    }//GEN-LAST:event_btnEditarTelaListarUsuarioActionPerformed

    private void btnExcluirTelaListarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTelaListarUsuarioActionPerformed
        int codigoUsuarioExcluir = this.tblListaUsuarios.getSelectedRow();
       
        try {
                TelaUsuariosForm telaUsuario ;
                 
                   if( codigoUsuarioExcluir >= 0){
                       Usuario userSelecionado = listaUsuario.get( codigoUsuarioExcluir);
                       
                       String mensagem = "Deseja realmente excluir o usuario "+userSelecionado.getNome()+" ?";
                       int opcao = JOptionPane.showConfirmDialog(this, mensagem, "Excluir usuario", JOptionPane.YES_NO_OPTION);
                       
                       if( opcao == JOptionPane.YES_OPTION){
                           UsuarioBO usuarioBO = new UsuarioBO();
                           if( usuarioBO.excluirUsuario( userSelecionado.getLogin())){
                               JOptionPane.showMessageDialog(this, "Usuario excluido com sucesso!!!!", "Exclusão de usuário!", JOptionPane.INFORMATION_MESSAGE);
                               this.inicializaTabela();
                           }else
                               JOptionPane.showMessageDialog(this, "Falha na exclusão do usuário!!!!", "Exclusão de usuário!", JOptionPane.INFORMATION_MESSAGE);
                       }
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "Selecione um usuario na tabela para fazer a alateração!", "Erro!", JOptionPane.ERROR_MESSAGE);
                   }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage(), "Falha na atualização do usuário", JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
    }//GEN-LAST:event_btnExcluirTelaListarUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mensagem = "Deseja realmente sair ?";
        int opcao = JOptionPane.showConfirmDialog(this, mensagem, "Excluir usuario", JOptionPane.YES_NO_OPTION);
        if( opcao == JOptionPane.YES_OPTION)
            this.dispose();
                       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaListarUsuariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListarUsuariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListarUsuariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListarUsuariosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListarUsuariosForm().setVisible(true);
              
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarTelaListarUsuario;
    private javax.swing.JButton btnExcluirTelaListarUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlTabelaDeUsuarios;
    private javax.swing.JTable tblListaUsuarios;
    // End of variables declaration//GEN-END:variables

    private void inicializaTabela() {
        UsuarioBO usuarioBO = new UsuarioBO();
        try{
            listaUsuario = usuarioBO.buscarTodosUsuarios();
            
            ModeloDadosUsuarios modelo = new ModeloDadosUsuarios( listaUsuario);
            tblListaUsuarios.setModel( modelo);
        
        } catch( SQLException ex){
            JOptionPane.showMessageDialog( this, ex.getMessage(), "Falha no banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   class ModeloDadosUsuarios extends AbstractTableModel{
        
        int rowSize ;
        ArrayList<Usuario> listaUsuarioModelo = new ArrayList<>();
        private ModeloDadosUsuarios( ArrayList<Usuario> lista ){
            listaUsuarioModelo = lista;
            rowSize = lista.size();
        }
        
        @Override
        public int getRowCount() {
            return rowSize;
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario novoUsuario = listaUsuario.get( rowIndex);
            
            if( columnIndex == 0){
                return novoUsuario.getNome();
            }
            else if( columnIndex == 1){
              return novoUsuario.getLogin();  
            }
            else if( columnIndex == 2){
                if( novoUsuario.getGrupoUsuarios().getGerente())
                    return "Sim";
                else
                    return "Não";
            }
            else if( columnIndex == 3){
                if( novoUsuario.getGrupoUsuarios().getGestorCompras())
                    return "Sim";
                else
                    return "Não";
            }
            else if( columnIndex == 4){
                if( novoUsuario.getGrupoUsuarios().getGestorEstoque())
                    return "Sim";
                else
                    return "Não";
            }
            else{
                if( novoUsuario.getGrupoUsuarios().getCaixeiro())
                    return "Sim";
                else
                    return "Não";
            }
         
        }
        @Override
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "Nome";
            } else if (coluna == 1) {
                return "Login";
            } else if (coluna == 2) {
                return "Gerente";
            } else if (coluna == 3) {
                return "Gestor de Compra";
            } else if (coluna == 4) {
                return "Gestor de estoque";
            } else {
                return "Caixeiro";
            }
        }

    }
}
