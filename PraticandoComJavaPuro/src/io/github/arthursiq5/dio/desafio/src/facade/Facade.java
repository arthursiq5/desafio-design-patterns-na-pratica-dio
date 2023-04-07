/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.dio.desafio.src.facade;

import io.github.arthursiq5.dio.desafio.src.facade.subprojeto.CepApi;
import io.github.arthursiq5.dio.desafio.src.facade.subprojeto.CrmService;

/**
 *
 * @author arthur
 */
public class Facade {
    public void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
