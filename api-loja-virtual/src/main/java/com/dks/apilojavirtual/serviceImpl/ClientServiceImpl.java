package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public List<Client> list() {
        return null;
    }

    @Override
    public Client create(Client client) {
        return null;
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
