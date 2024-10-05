package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Clientes;
import ifma.edu.imobiliaria.repository.ClienteRepository;

import java.util.List;


public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void salvar(Clientes cliente) {
        clienteRepository.salvar(cliente);
    }

    public Clientes buscarPorId(Integer id) {
        return clienteRepository.buscarPorId(id);
    }

    public List<Clientes> listarTodos() {
        return clienteRepository.listarTodos();
    }

    public Clientes buscarPorCpf(String cpf) {
        return clienteRepository.buscarPorCpf(cpf);
    }
}
