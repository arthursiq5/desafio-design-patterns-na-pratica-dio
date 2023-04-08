/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.service;

import io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author arthur
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepservice {
    @GetMapping
    Endereco consultarCep(@PathVariable("cep") String cep);
}
