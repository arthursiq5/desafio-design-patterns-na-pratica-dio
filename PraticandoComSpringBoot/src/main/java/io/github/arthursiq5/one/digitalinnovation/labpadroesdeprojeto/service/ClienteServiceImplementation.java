/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.service;

import io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.model.Cliente;
import io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.model.ClienteRepository;
import io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.model.Endereco;
import io.github.arthursiq5.one.digitalinnovation.labpadroesdeprojeto.model.EnderecoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author arthur
 */
public class ClienteServiceImplementation implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepservice viaCepService;
    
    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    /**
     * @param cliente cliente que quer adicionar
     */
    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    /**
     * @param id ID do cliente que quer alterar
     * @param cliente cliente (com os dados) que quer alterar
     */
    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    /**
     * @param id ID do cliente
     */
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }
    
}
