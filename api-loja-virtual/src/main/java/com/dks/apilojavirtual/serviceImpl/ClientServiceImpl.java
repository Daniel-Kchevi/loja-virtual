package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.repository.ClientRepository;
import com.dks.apilojavirtual.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void edit(Client client) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Client getClientById(Long id) {
        return null;
    }
}
