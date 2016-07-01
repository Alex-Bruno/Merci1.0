/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.apresentacao;

import br.edu.ifnmg.merci.entidade.GrupoUsuarios;
import br.edu.ifnmg.merci.entidade.Usuario;
import br.edu.ifnmg.merci.excecao.UsuarioCampoLoginVazioException;
import br.edu.ifnmg.merci.excecao.UsuarioCampoSenhaVazioException;
import br.edu.ifnmg.merci.excecao.UsuarioCaractereInvalidoLogin;
import br.edu.ifnmg.merci.excecao.UsuarioCaractereInvalidoSenhaException;
import br.edu.ifnmg.merci.excecao.UsuarioConfirmarSenhaInvalidoException;
import br.edu.ifnmg.merci.excecao.UsuarioException;
import br.edu.ifnmg.merci.negocio.GrupoUsuarioBO;
import br.edu.ifnmg.merci.negocio.UsuarioBO;
import br.edu.ifnmg.merci.negocio.UsuarioGrupoUsuarioBO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AlexBruno
 */
public class TelaLoginForm extends javax.swing.JFrame {
    
    private static Usuario usuario = new Usuario();
    private static UsuarioBO usuarioBO = new UsuarioBO();
    private static TelaUsuariosForm telaUsuarios = new TelaUsuariosForm();
    private static UsuarioGrupoUsuarioBO usuarioGrupoUsuarioBO = new UsuarioGrupoUsuarioBO();
    /**
     * Creates new form TelaLoginForm
     */
    public TelaLoginForm() {
        initComponents();
        
        
        this.verificaGrupoUsuarioVazio();
        this.verificaCadastroUsuarioVazio();
        this.bloquearBotoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblLoginTelaLogin = new javax.swing.JLabel();
        lblSenhaTelaLogin = new javax.swing.JLabel();
        lblConfirmarSenhaTelaLogin = new javax.swing.JLabel();
        btnLogoffTelaLogin = new javax.swing.JButton();
        btnLoginTelaLogin = new javax.swing.JButton();
        btnAlterarSenhaTelaLogin = new javax.swing.JButton();
        btnConfirmarSenhaTelaLogin = new javax.swing.JButton();
        txtSenhaTelaLogin = new javax.swing.JPasswordField();
        txtConfirmarSenhaTelaLogin = new javax.swing.JPasswordField();
        txtLoginTelaLogin = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGestao = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenu();
        itmCadastrarUsuario = new javax.swing.JMenuItem();
        itmListarUsuarios = new javax.swing.JMenuItem();
        itmFornecedores = new javax.swing.JMenuItem();
        itmMercadorias = new javax.swing.JMenuItem();
        itmPedidosCompra = new javax.swing.JMenuItem();
        itmEstoque = new javax.swing.JMenuItem();
        itmAbrirCaixa = new javax.swing.JMenuItem();
        itmSeparador = new javax.swing.JPopupMenu.Separator();
        itmSair = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Merci 1.0 - Tela Principal");
        setExtendedState(6);

        lblLoginTelaLogin.setText("Login: ");

        lblSenhaTelaLogin.setText("Senha: ");

        lblConfirmarSenhaTelaLogin.setText("Confirmar Senha: ");

        btnLogoffTelaLogin.setText("Logoff");
        btnLogoffTelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffTelaLoginActionPerformed(evt);
            }
        });

        btnLoginTelaLogin.setText("Login");
        btnLoginTelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginTelaLoginActionPerformed(evt);
            }
        });

        btnAlterarSenhaTelaLogin.setText("Alterar Senha");
        btnAlterarSenhaTelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarSenhaTelaLoginActionPerformed(evt);
            }
        });

        btnConfirmarSenhaTelaLogin.setText("Confirmar Senha");
        btnConfirmarSenhaTelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarSenhaTelaLoginActionPerformed(evt);
            }
        });

        txtSenhaTelaLogin.setMinimumSize(new java.awt.Dimension(2, 8));
        txtSenhaTelaLogin.setSelectionEnd(8);
        txtSenhaTelaLogin.setVerifyInputWhenFocusTarget(false);

        txtConfirmarSenhaTelaLogin.setMinimumSize(new java.awt.Dimension(2, 8));
        txtConfirmarSenhaTelaLogin.setSelectionEnd(8);
        txtConfirmarSenhaTelaLogin.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(btnLogoffTelaLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoginTelaLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarSenhaTelaLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmarSenhaTelaLogin)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSenhaTelaLogin)
                            .addComponent(lblConfirmarSenhaTelaLogin)
                            .addComponent(lblLoginTelaLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmarSenhaTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenhaTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoginTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoginTelaLogin)
                    .addComponent(txtLoginTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaTelaLogin)
                    .addComponent(txtSenhaTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmarSenhaTelaLogin)
                    .addComponent(txtConfirmarSenhaTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogoffTelaLogin)
                    .addComponent(btnLoginTelaLogin)
                    .addComponent(btnAlterarSenhaTelaLogin)
                    .addComponent(btnConfirmarSenhaTelaLogin))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        menuGestao.setText("Gestão");

        menuUsuarios.setText("Usuários");

        itmCadastrarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        itmCadastrarUsuario.setText("Cadastrar");
        itmCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastrarUsuarioActionPerformed(evt);
            }
        });
        menuUsuarios.add(itmCadastrarUsuario);

        itmListarUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        itmListarUsuarios.setText("Listar");
        itmListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarUsuariosActionPerformed(evt);
            }
        });
        menuUsuarios.add(itmListarUsuarios);

        menuGestao.add(menuUsuarios);

        itmFornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        itmFornecedores.setText("Fornecedores");
        itmFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmFornecedoresActionPerformed(evt);
            }
        });
        menuGestao.add(itmFornecedores);

        itmMercadorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        itmMercadorias.setText("Mercadorias");
        menuGestao.add(itmMercadorias);

        itmPedidosCompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        itmPedidosCompra.setText("Pedidos de Compra");
        menuGestao.add(itmPedidosCompra);

        itmEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        itmEstoque.setText("Estoque");
        itmEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEstoqueActionPerformed(evt);
            }
        });
        menuGestao.add(itmEstoque);

        itmAbrirCaixa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        itmAbrirCaixa.setText("Abrir Caixa");
        menuGestao.add(itmAbrirCaixa);
        menuGestao.add(itmSeparador);

        itmSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        itmSair.setText("Sair");
        menuGestao.add(itmSair);

        jMenuBar1.add(menuGestao);

        menuVendas.setText("Vendas");
        jMenuBar1.add(menuVendas);

        menuAjuda.setText("Ajuda");
        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmFornecedoresActionPerformed

    private void itmEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmEstoqueActionPerformed

    private void btnLoginTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginTelaLoginActionPerformed
        try {
            this.recumperaCamposLogin();
            
            usuario = usuarioBO.verificaLogin( usuario);
            
            JOptionPane.showMessageDialog( this, "Bem Vindo !!!", "Logado", JOptionPane.INFORMATION_MESSAGE);
            
            this.menuGestao.setEnabled( true);
            
            if( usuario.getGrupoUsuarios().getGerente()== true ){
                this.ativarGestaoGerente();
            }
            
            if( usuario.getGrupoUsuarios().getGestorCompras() == true ){
                this.ativarGestaoGestorCompras();
                
            }
            
            if( usuario.getGrupoUsuarios().getGestorEstoque() == true){
                this.ativarGetaoGestorCompras();
            }
           
            this.ativaBotoesAposLogin();
                
                
            this.txtSenhaTelaLogin.setText("");
        
        } catch (UsuarioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Login de usuário", JOptionPane.ERROR_MESSAGE);
            this.txtSenhaTelaLogin.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão com o banco de dados\n"+ex.getMessage(), "Login de Usuário", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginTelaLoginActionPerformed

    private void btnAlterarSenhaTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarSenhaTelaLoginActionPerformed
        this.ativarBotoesAlterarSenha();        
    }//GEN-LAST:event_btnAlterarSenhaTelaLoginActionPerformed

    private void btnConfirmarSenhaTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarSenhaTelaLoginActionPerformed
        try {
            this.recumperaCamposLogin();
                if( usuarioBO.alterarSenha( usuario)){
                    JOptionPane.showMessageDialog(this, "Senha alterada com sucesso!!!", "Login de Usuário", JOptionPane.INFORMATION_MESSAGE);
                    this.ativaBotoesAposLogin();
                }else{
                    JOptionPane.showMessageDialog(this, "Falha na alteração da senha.\nTente novamente", "Login de Usuário", JOptionPane.ERROR_MESSAGE);
                }
            
        } catch (UsuarioException ex) {
            Logger.getLogger(TelaLoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaLoginForm.class.getName()).log(Level.SEVERE, null, ex);JOptionPane.showMessageDialog(this, "Erro na conexão com o banco de dados\n"+ex.getMessage(), "Login de Usuário", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnConfirmarSenhaTelaLoginActionPerformed

    private void btnLogoffTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffTelaLoginActionPerformed
       this.limparCamposPreenchidos();
       this.telaUsuarios.dispose();
       this.bloquearBotoes();
    }//GEN-LAST:event_btnLogoffTelaLoginActionPerformed

    private void itmCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastrarUsuarioActionPerformed
        telaUsuarios.setVisible( true);
    }//GEN-LAST:event_itmCadastrarUsuarioActionPerformed

    private void itmListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListarUsuariosActionPerformed
        TelaListarUsuariosForm telaListarUsuarios = new TelaListarUsuariosForm();
        telaListarUsuarios.setVisible( true);
    }//GEN-LAST:event_itmListarUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarSenhaTelaLogin;
    private javax.swing.JButton btnConfirmarSenhaTelaLogin;
    private javax.swing.JButton btnLoginTelaLogin;
    private javax.swing.JButton btnLogoffTelaLogin;
    private javax.swing.JMenuItem itmAbrirCaixa;
    private javax.swing.JMenuItem itmCadastrarUsuario;
    private javax.swing.JMenuItem itmEstoque;
    private javax.swing.JMenuItem itmFornecedores;
    private javax.swing.JMenuItem itmListarUsuarios;
    private javax.swing.JMenuItem itmMercadorias;
    private javax.swing.JMenuItem itmPedidosCompra;
    private javax.swing.JMenuItem itmSair;
    private javax.swing.JPopupMenu.Separator itmSeparador;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblConfirmarSenhaTelaLogin;
    private javax.swing.JLabel lblLoginTelaLogin;
    private javax.swing.JLabel lblSenhaTelaLogin;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuGestao;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuVendas;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPasswordField txtConfirmarSenhaTelaLogin;
    private javax.swing.JTextField txtLoginTelaLogin;
    private javax.swing.JPasswordField txtSenhaTelaLogin;
    // End of variables declaration//GEN-END:variables

    private void bloquearBotoes() {
        btnAlterarSenhaTelaLogin.setEnabled( false);
        btnConfirmarSenhaTelaLogin.setEnabled( false);
        btnLogoffTelaLogin.setEnabled( false);
        txtConfirmarSenhaTelaLogin.setEnabled( false);
        btnLoginTelaLogin.setEnabled( true);
        this.itmAbrirCaixa.setEnabled( false);
        this.itmCadastrarUsuario.setEnabled( false);
        this.itmEstoque.setEnabled( false);
        this.itmFornecedores.setEnabled( false);
        this.itmListarUsuarios.setEnabled( false);
        this.itmMercadorias.setEnabled( false);
        this.itmPedidosCompra.setEnabled( false);
        this.itmSair.setEnabled( false);
        this.menuUsuarios.setEnabled( false);
        this.menuGestao.setEnabled( false);
        this.menuVendas.setEnabled( false);
    }

    private void recumperaCamposLogin() throws UsuarioException {
        
        String login = txtLoginTelaLogin.getText().trim();
        if( !login.equals(""))
            usuario.setLogin( login);
        else
            throw new UsuarioCampoLoginVazioException();
        
        String senha = new String( txtSenhaTelaLogin.getPassword()).trim();
        if( !senha.equals(""))
            usuario.setSenha( senha);
        else
            throw new UsuarioCampoSenhaVazioException();
        
        this.verificaCaracteresLoginSenha( login, senha);
        
        String confirmarSenha = new String( txtConfirmarSenhaTelaLogin.getPassword()).trim();
        if( !confirmarSenha.equals(""))
            if( !confirmarSenha.equals( senha))
                throw new UsuarioConfirmarSenhaInvalidoException();
        
        
    }

    private void ativaBotoesAposLogin() {
        btnAlterarSenhaTelaLogin.setEnabled( true);
        btnLogoffTelaLogin.setEnabled( true);
        txtSenhaTelaLogin.setText("");
        txtConfirmarSenhaTelaLogin.setText("");
        btnLoginTelaLogin.setEnabled( false);
        btnConfirmarSenhaTelaLogin.setEnabled( false);
        
       
    }

    private void ativarBotoesAlterarSenha() {
        txtConfirmarSenhaTelaLogin.setEnabled( true);
        btnConfirmarSenhaTelaLogin.setEnabled( true);
        this.btnAlterarSenhaTelaLogin.setEnabled( false);        
    }

    private void limparCamposPreenchidos() {
        this.txtLoginTelaLogin.setText("");
        this.txtSenhaTelaLogin.setText("");
    }

    private void ativarGestaoGerente() {
        this.menuUsuarios.setEnabled( true);
        this.itmAbrirCaixa.setEnabled( true);
        this.itmCadastrarUsuario.setEnabled( true);
        this.itmListarUsuarios.setEnabled( true);
    }

    private void ativarGestaoGestorCompras() {
        this.itmFornecedores.setEnabled( true);
        this.itmMercadorias.setEnabled( true);
        this.itmPedidosCompra.setEnabled( true);
    }

    private void ativarGetaoGestorCompras() {
        this.itmEstoque.setEnabled( true);
    }

    private void verificaCaracteresLoginSenha(String login, String senha) throws UsuarioException {
        
        for( int i = 0; i< login.length(); i+=1)
            if( (login.charAt(i) > 'Z' && login.charAt(i) > 'A') && (login.charAt(i) > 'z' && login.charAt(i) > 'a') && (login.charAt(i) > '0' && login.charAt(i) > '9'))
                throw new UsuarioCaractereInvalidoLogin();
        
        for( int i = 0; i< senha.length(); i+=1)
            if( (senha.charAt(i) > 'Z' && senha.charAt(i) > 'A') && (senha.charAt(i) > 'z' && senha.charAt(i) > 'a') && (senha.charAt(i) > '0' && senha.charAt(i) > '9'))
                throw new UsuarioCaractereInvalidoSenhaException();
                
    }

    private void verificaCadastroUsuarioVazio() {
        try {
            ArrayList< Usuario> listaUsuarioVazio;
                     
            listaUsuarioVazio = usuarioBO.buscarTodosUsuarios();
        
        
        if( listaUsuarioVazio.size() == 0){
            Usuario NovoUsuario = new Usuario();
            GrupoUsuarios grupoUsuarios = new GrupoUsuarios();
            String user = "admin";
            
            NovoUsuario.setLogin(user);
            NovoUsuario.setNome(user);
            NovoUsuario.setSenha(user);
            
            grupoUsuarios.setGerente( true);
            
            NovoUsuario.setGrupoUsuarios( grupoUsuarios);
            usuarioBO.cadastrarUsuario(NovoUsuario, user);
            usuarioGrupoUsuarioBO.verificaCadastrarUsuarioGrupoUsuario(NovoUsuario, grupoUsuarios);
        }
        
        } catch (UsuarioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Falha na conexao com o banco de dados "+ex.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void verificaGrupoUsuarioVazio() {
        
        try{
            GrupoUsuarioBO grupoUsuarioBO = new GrupoUsuarioBO();
            grupoUsuarioBO.verificaGruposCadastrados();
            
        }catch( SQLException ex){
            JOptionPane.showMessageDialog( this, "Falha no banco de dados. "+ex.getMessage(), "Procure o administrador do sistema", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}