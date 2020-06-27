package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.exception.ClientNotFound;
import com.dks.apilojavirtual.repository.ClientRepository;
import com.dks.apilojavirtual.service.ClientService;
import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final String clientNotFund = "O cliente não foi encontrado.";

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    @Override
    public void edit(Client client) {
        try {
            checkingCustomer(client.getId());
            clientRepository.save(client);
        }catch (Exception e){
            throw new ClientNotFound(clientNotFund);
        }
    }

    @Override
    public void delete(Long id) {
        try{
            checkingCustomer(id);
            clientRepository.deleteById(id);
        }catch (Exception e){
            throw new ClientNotFound(clientNotFund);
        }
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> cli = null;
        Client client = new Client();
        try {
            cli = clientRepository.findById(id);
            if (null==cli.get()){
                throw new ClientNotFound(clientNotFund);
            }
        }catch (Exception e){
            throw new ClientNotFound(clientNotFund);
        }
        client = cli.get();
        return client;
    }

    private void checkingCustomer(Long id) {
        getClientById(id);
    }
}
