/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.dio.desafio.src.strategy;

/**
 *
 * @author arthur
 */
public class Robo {
    private Comportamento comportamento = null;
    
    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
    
    public void mover() {
        comportamento.mover();
    }
    
    public static void main(String[] args) {
        Robo robo = new Robo();
        
        robo.setComportamento(new ComportamentoNormal());
        robo.mover();
        
        robo.setComportamento(new ComportamentoAgressivo());
        robo.mover();
        
        robo.setComportamento(new ComportamentoDefensivo());
        robo.mover();
        
        robo.setComportamento(new ComportamentoNormal());
        robo.mover();
    }
}
