package br.com.fiap.feedfront.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.feedfront.dto.ClienteDTO;
import br.com.fiap.feedfront.exception.ResourceNotFoundException;
import br.com.fiap.feedfront.model.Cliente;
import br.com.fiap.feedfront.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));

        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));

        clienteRepository.delete(cliente);
    }
}
