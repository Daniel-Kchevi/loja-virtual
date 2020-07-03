package com.dks.apilojavirtual.service;

import com.dks.apilojavirtual.domain.Client;

import java.util.List;

public interface ClientService{

    List<Client> list();

    Client create (Client client);

    void edit (Client client);

    void delete (Long id);

    Client getClientById(Long id);


}
