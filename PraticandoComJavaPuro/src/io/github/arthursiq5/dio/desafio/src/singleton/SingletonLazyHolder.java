/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.dio.desafio.src.singleton;

/**
 * Singleton "Lazy Holder"
 * @author arthur
 */
public class SingletonLazyHolder {
    private static class InstanceHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.instancia;
    }
    
    public static void main(String[] args) {
        SingletonLazyHolder lazy = SingletonLazyHolder.getInstancia();
        System.out.println(lazy);
        System.out.println(lazy);
    }
}
