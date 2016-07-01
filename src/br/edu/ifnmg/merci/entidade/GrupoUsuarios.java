/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.merci.entidade;

/**
 *
 * @author AlexBruno
 */
public class GrupoUsuarios {
    private boolean gerente;
    private boolean gestorCompras;
    private boolean gestorEstoque;
    private boolean caixeiro;

    public GrupoUsuarios() {
        this.gerente = false;
        this.gestorCompras = false;
        this.gestorEstoque = false;
        this.caixeiro = false;
    }

    
    public boolean getGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public boolean getGestorCompras() {
        return gestorCompras;
    }

    public void setGestorCompras(boolean gestorCompras) {
        this.gestorCompras = gestorCompras;
    }

    public boolean getGestorEstoque() {
        return gestorEstoque;
    }

    public void setGestorEstoque(boolean gestorEstoque) {
        this.gestorEstoque = gestorEstoque;
    }

    public boolean getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(boolean caixeiro) {
        this.caixeiro = caixeiro;
    }
    
    
}
