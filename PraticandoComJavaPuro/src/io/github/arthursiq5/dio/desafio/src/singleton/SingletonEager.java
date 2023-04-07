/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.dio.desafio.src.singleton;

/**
 *
 * @author arthur
 */
public class SingletonEager {
    
    private static SingletonEager instancia = new SingletonEager();
    
    private SingletonEager() {
            super();
    }
    
    public static SingletonEager getInstance() {
            return instancia;
    }
    
    public static void main(String[] args) {
        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);
        System.out.println(SingletonEager.getInstance());
        eager = SingletonEager.getInstance();
        System.out.println(eager);
    }
}
