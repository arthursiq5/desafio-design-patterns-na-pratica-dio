/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.dio.desafio.src.singleton;

/**
 * Singleton "preguiçoso"
 * @author arthur
 */
public class SingletonLazy {
    private static SingletonLazy instancia = null;
    
    private SingletonLazy() {
        super();
    }
    
    public String toString() {
        return "Esta é uma instância de SingletonLazy";
    }
    
    public static SingletonLazy getSingleton() {
        if (SingletonLazy.instancia == null) {
            SingletonLazy.instancia = new SingletonLazy();
        }
        return SingletonLazy.instancia;
    }
    
    public static void main(String[] args) {
        System.out.println(SingletonLazy.getSingleton());
    }
}
